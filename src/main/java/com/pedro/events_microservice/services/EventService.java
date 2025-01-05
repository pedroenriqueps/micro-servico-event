package com.pedro.events_microservice.services;


import com.pedro.events_microservice.domain.Event;
import com.pedro.events_microservice.domain.Subscription;
import com.pedro.events_microservice.dtos.EmailRequestDTO;
import com.pedro.events_microservice.dtos.EventRequestDTO;
import com.pedro.events_microservice.exceptions.EventFullException;
import com.pedro.events_microservice.exceptions.EventNotFoundException;
import com.pedro.events_microservice.repositories.EventRepository;
import com.pedro.events_microservice.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private EmailServiceClient emailServiceClient;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public List<Event> getUpcomingEvents() {
        return eventRepository.findByDateAfterOrderByDate(LocalDateTime.now());
    }

    public Event createEvent(EventRequestDTO eventRequest) {
        Event newEvent = new Event(eventRequest);
        return eventRepository.save(newEvent);
    }

    private Boolean isEventFull(Event event){
        return event.getRegisteredParticipants() >= event.getMaxParticipants();
    }

    public void registerParticipant(String eventId, String participantEmail) {
        Event event = eventRepository.findById(eventId).orElseThrow(EventNotFoundException::new);

        if (event.getRegisteredParticipants() < event.getMaxParticipants()) {
            Subscription subscription = new Subscription(event, participantEmail);
            subscriptionRepository.save(subscription);
            event.setRegisteredParticipants(event.getRegisteredParticipants() + 1);

            EmailRequestDTO emailRequest = new EmailRequestDTO(participantEmail, "Confirmação de Inscrição", "Você foi inscrito no evento com sucesso!");

            emailServiceClient.sendEmail(emailRequest);
        }

        if(isEventFull(event)) {
            throw new EventFullException();
        }

    }
}
