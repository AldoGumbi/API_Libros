package com.challengespring.ChallengeLibros.services;

public interface I_ConvierteDatos {

    <T> T obtenerDatos(String json, Class<T> clase);
}
