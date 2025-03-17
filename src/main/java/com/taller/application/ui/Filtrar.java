package com.taller.application.ui;

import java.util.List;
import java.util.stream.Collectors;

import com.taller.domain.entity.Team;
import com.taller.domain.filtros.Consumers;
import com.taller.domain.filtros.Predicator;

public class Filtrar {
    public List<Team> fundadosDespuesDelAño2000(List<Team> equipos) {
        Predicator predicator = new Predicator();

        // Filtrar los equipos fundados después del año 2000
        return equipos.stream()
            .filter(team -> predicator.test(team.getYearfoundation()))
            .collect(Collectors.toList());
    }

    // public List<Team> entrenadores(List<Team> equipos) {
    //     Consumers consumers = new Consumers();

    //     return equipos.stream()
    //         .filter(coach -> consumers.)
    // }
}