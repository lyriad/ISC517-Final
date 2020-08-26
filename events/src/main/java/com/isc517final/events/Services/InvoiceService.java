package com.isc517final.events.Services;

import java.util.List;

import javax.transaction.Transactional;

import com.isc517final.events.Models.Invoice;
import com.isc517final.events.Repositories.InvoiceRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class InvoiceService {
    
    @Autowired
    private InvoiceRepository repository;

    public List<Invoice> all() {
        return repository.findAll();
    }

    public Invoice findById(long id) {
        return repository.findById(id);
    }
    public List<Invoice> findAllByUser(long userId) {
        return repository.findAllByUser(userId);
    }

    public List<Invoice> findAllByEvent(long eventId) {
        return repository.findAllByEvent(eventId);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Transactional
    public Invoice createOrUpdate(Invoice user) {
        return repository.save(user);
    }

    @Transactional
    public void delete(long id) {
        repository.deleteById(id);
    }   
}