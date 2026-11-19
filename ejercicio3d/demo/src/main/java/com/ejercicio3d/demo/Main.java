package com.ejercicio3d.demo;

import com.ejercicio3d.demo.api.SaludApiRepository;
import com.ejercicio3d.demo.domain.model.Salud;

public class Main {

    public static void main(String[] args) {

        SaludApiRepository saludRepository = new SaludApiRepository();

        Salud salud;

        try {
            salud = saludRepository.consultar();
            System.out.println("Estado del servidor: " + salud.estado());

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

    }
}