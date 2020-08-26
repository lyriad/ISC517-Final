package com.isc517final.events.Repositories;

import java.util.List;
import com.isc517final.events.Models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    
    Invoice findById(long id);

    @Query("SELECT i FROM Invoice i WHERE i.userId = :userId")
    List<Invoice> findAllByUser(@Param("userId") long userId);

    @Query("SELECT i FROM Invoice i WHERE i.eventId = :eventId")
    List<Invoice> findAllByEvent(@Param("eventId") long eventId);
}