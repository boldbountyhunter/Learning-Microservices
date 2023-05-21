package com.microservices.moviebookingservice.resource;

import com.microservices.moviebookingservice.entity.TicketDetails;
import com.microservices.moviebookingservice.model.BookedTicketDetails;
import com.microservices.moviebookingservice.service.MovieBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie-booking")
public class MovieBookingController {

    private MovieBookingService movieBookingService;

    @Autowired
    public MovieBookingController(MovieBookingService movieBookingService) {
        this.movieBookingService = movieBookingService;
    }

    @PostMapping("")
    public ResponseEntity<BookedTicketDetails> bookTicket(@RequestBody TicketDetails ticketDetails) {
        return new ResponseEntity<>(movieBookingService.bookTicket(ticketDetails), HttpStatus.ACCEPTED);
    }

    @GetMapping("/tickets/{userId}")
    public ResponseEntity<List<BookedTicketDetails>> getAllTicketsByUserId(@PathVariable long userId) {
        return new ResponseEntity<>(movieBookingService.getTicketDetailsByUserID(userId), HttpStatus.OK);
    }
}
