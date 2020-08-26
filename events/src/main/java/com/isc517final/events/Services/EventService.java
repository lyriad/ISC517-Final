package com.isc517final.events.Services;

import java.util.List;
import javax.transaction.Transactional;
import com.isc517final.events.Models.Event;
import com.isc517final.events.Repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    
    @Autowired
    private EventRepository repository;

    public List<Event> all() {
        return repository.findAll();
    }

    public Event findById(long id) {
        return repository.findById(id);
    }

    public Event findByName(String name) {
        return repository.findByName(name);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    public boolean existsByName(String name) {
        return repository.existsByName(name) == 1;
    }

    @Transactional
    public Event createOrUpdate(Event event) {
        return repository.save(event);
    }

    @Transactional
    public void delete(long id) {
        repository.deleteById(id);
    }
}