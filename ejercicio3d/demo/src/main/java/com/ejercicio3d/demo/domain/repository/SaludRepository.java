package com.ejercicio3d.demo.domain.repository;

import java.io.IOException;

import com.ejercicio3d.demo.domain.model.Salud;

public interface SaludRepository {
    Salud consultar() throws IOException, InterruptedException;
}