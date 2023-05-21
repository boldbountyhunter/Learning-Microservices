package com.microservices.moviebookingservice.service;

import com.microservices.moviebookingservice.entity.TicketDetails;
import com.microservices.moviebookingservice.externalService.PaymentService;
import com.microservices.moviebookingservice.externalService.TheatreService;
import com.microservices.moviebookingservice.model.*;
import com.microservices.moviebookingservice.repository.TicketDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class MovieBookingService {

    private TicketDetailsRepository ticketDetailsRepository;
    private PaymentService paymentService;
    private TheatreService theatreService;

    @Autowired
    public MovieBookingService(TicketDetailsRepository ticketDetailsRepository, PaymentService paymentService, TheatreService theatreService) {
        this.ticketDetailsRepository = ticketDetailsRepository;
        this.paymentService = paymentService;
        this.theatreService = theatreService;
    }

    public List<BookedTicketDetails> getTicketDetailsByUserID(long userId) {
        List<BookedTicketDetails> listOfBookedTicketDetails = new ArrayList<>();
        List<TicketDetails> allTickets = ticketDetailsRepository.findAllByUserId(userId);
        List<Long> paymentIds = allTickets.stream().map(TicketDetails::getPaymentId).collect(Collectors.toList());
        Map<Long, Payment> paymentMap = paymentService.getAllPaymentByIds(paymentIds).stream().collect(Collectors.toMap(Payment::getId, Function.identity()));

        allTickets.forEach(ticketDetails -> {
            TheatreDetails theatreDetails = theatreService.getTheatreByTheatreIdAndMovieId(ticketDetails.getTheatreId(), ticketDetails.getMovieId());
            Payment paymentDetails = paymentMap.get(ticketDetails.getPaymentId());
            BookedTicketDetails bookedTicketDetails = getBookedTicketDetailsFromTicketDetails(ticketDetails, theatreDetails, paymentDetails);
            listOfBookedTicketDetails.add(bookedTicketDetails);
        });

        return listOfBookedTicketDetails;

    }

    public BookedTicketDetails bookTicket(TicketDetails ticketDetails) {
        TheatreDetails theatreDetails = theatreService.getTheatreByTheatreIdAndMovieId(ticketDetails.getTheatreId(), ticketDetails.getMovieId());
        MovieTheatreDetails movieTheatreDetails = theatreDetails.getMovieTheatreDetails().stream().findFirst().get();
        Payment payment = paymentService.makePayment(new Payment(movieTheatreDetails.getMovieTicketPrice()));
        ticketDetails.setPaymentId(payment.getId());
        theatreService.bookSeat(new SeatMovieTheatre(ticketDetails.getNoOfSeats(), ticketDetails.getTheatreId(), ticketDetails.getMovieId()));
        ticketDetails = ticketDetailsRepository.save(ticketDetails);


        return getBookedTicketDetailsFromTicketDetails(ticketDetails, theatreDetails, payment);
    }

    public BookedTicketDetails getBookedTicketDetailsFromTicketDetails(TicketDetails ticketDetails, TheatreDetails theatreDetails, Payment paymentDetails) {

        MovieTheatreDetails movieTheatreDetails = theatreDetails.getMovieTheatreDetails().stream().findFirst().get();
        BookedTicketDetails bookedTicketDetails = new BookedTicketDetails();

        bookedTicketDetails.setTicketId(ticketDetails.getId());
        bookedTicketDetails.setTimeOfBooking(ticketDetails.getTimeOfBooking());
        bookedTicketDetails.setTicketAmount(paymentDetails.getAmount());
        bookedTicketDetails.setMovieName(movieTheatreDetails.getMovieName());
        bookedTicketDetails.setMovieDuration(movieTheatreDetails.getDuration());
        bookedTicketDetails.setTimeOfShow(movieTheatreDetails.getTimeOfShow());
        bookedTicketDetails.setDateOfShow(movieTheatreDetails.getDateOfShow());
        bookedTicketDetails.setNoOfSeats(ticketDetails.getNoOfSeats());
        bookedTicketDetails.setUserId(ticketDetails.getUserId());
        bookedTicketDetails.setMovieName(movieTheatreDetails.getMovieName());
        bookedTicketDetails.setTheatreName(theatreDetails.getName());
        return bookedTicketDetails;
    }


}
