package com.port.container.repository;

import com.port.container.model.Event;

import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, String> {
    Event findById(long id);

}
