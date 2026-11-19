package com.ejercicio3d.demo.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import com.google.gson.Gson;


import com.ejercicio3d.demo.domain.model.Salud;
import com.ejercicio3d.demo.domain.repository.SaludRepository;



public class SaludApiRepository implements SaludRepository {

    private final Gson gson = new Gson();


    private static final String URL =
        "https://localhost:8443/api/v1/salud";

    private final HttpClient http = HttpClient.newBuilder()
        .connectTimeout(Duration.ofSeconds(5))
        .build();

    @Override
    public Salud consultar() throws IOException, InterruptedException {

        HttpRequest req = HttpRequest.newBuilder(URI.create(URL))
            .header("Accept", "application/json")
            .timeout(Duration.ofSeconds(5))
            .GET()
            .build();

        HttpResponse<String> response = http.send(
            req,
            HttpResponse.BodyHandlers.ofString()
        );

        if (response.statusCode() != 200) {
            throw new IOException(
                "Server returned HTTP " + response.statusCode()
            );
        }

        return gson.fromJson(response.body(), Salud.class);    
    }
}   