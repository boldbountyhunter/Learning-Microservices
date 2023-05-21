package com.microservices.moviebookingservice.repository;

import com.microservices.moviebookingservice.entity.TicketDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketDetailsRepository extends JpaRepository<TicketDetails, Long> {

    public List<TicketDetails> findAllByUserId(long userId);

}
