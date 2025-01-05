package com.pedro.events_microservice.dtos;

public record EventRequestDTO( int registeredParticipants, String date, String title, String description, int maxParticipants) {

}
