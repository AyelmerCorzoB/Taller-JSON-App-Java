package com.taller.application.ui.filtros;

import java.util.List;
import java.util.stream.Collectors;

import com.taller.domain.ExprecionesLambda.Predicator;
import com.taller.domain.entity.Team;

public class FiltrosRetos {

    public List<Team> ListarEquipos15Puntos(List<Team> equipos) {
        Predicator predicator = new Predicator();
        return equipos.stream()
                .filter(team -> {
                    return team.getStatistics() != null &&
                            team.getStatistics().stream()
                                    .anyMatch(estadistica -> {
                                        try {
                                            int tp = (estadistica.getTp());
                                            return predicator.test3(tp);
                                        } catch (NumberFormatException e) {
                                            return false;
                                        }
                                    });
                })
                .collect(Collectors.toList());
    }
}
