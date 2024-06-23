package com.challengespring.ChallengeLibros.model;

import com.challengespring.ChallengeLibros.services.I_ConvierteDatos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ConvierteDatos implements I_ConvierteDatos {
    private ObjectMapper objetctMapper = new ObjectMapper();

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return objetctMapper.readValue(json.toString(), clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

