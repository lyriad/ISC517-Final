package com.isc517final.events.Repositories;

import com.isc517final.events.Models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EventRepository extends JpaRepository<Event, Long> {
    
    Event findById(long id);

    Event findByName(String name);

    @Query("SELECT COUNT(1) FROM Event e WHERE e.name = :name")
    int existsByName(@Param("name") String name);
}
