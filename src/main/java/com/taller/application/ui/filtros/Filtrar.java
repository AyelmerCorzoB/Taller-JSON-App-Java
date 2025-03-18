package com.taller.application.ui.filtros;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import com.taller.domain.entity.Team;
import com.taller.domain.filtros.Predicator;

public class Filtrar {
    public List<Team> fundadosDespuesDelAño2000(List<Team> equipos) {
        Predicator predicator = new Predicator();

        // Filtrar los equipos fundados después del año 2000
        return equipos.stream()
            .filter(team -> predicator.test(team.getYearfoundation()))
            .collect(Collectors.toList());
    }

    public void entrenadores(List<Team> equipos) {
        // Definir el Consumer que imprime el nombre del entrenador
        Consumer<Team> imprimirEntrenador = team -> {
            System.out.println(" Equipo: " + team.getName() + " - Entrenador: " + team.getCoach());
        };

        // Aplicar el Consumer a cada equipo en la lista
        equipos.forEach(imprimirEntrenador);
    }
}