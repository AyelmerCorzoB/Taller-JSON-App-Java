package com.taller.application.ui.filtros;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import com.taller.domain.ExprecionesLambda.Predicator;
import com.taller.domain.entity.Team;
import com.taller.domain.entity.Players;

public class Filtrar {
    public List<Team> fundadosDespuesDelAño2000(List<Team> equipos) {
        Predicator predicator = new Predicator();
        return equipos.stream()
                .filter(team -> predicator.test(team.getYearfoundation()))
                .collect(Collectors.toList());
    }

    public void entrenadores(List<Team> equipos) {
        Consumer<Team> imprimirEntrenador = team -> {
            System.out.println(" Equipo: " + team.getName() + " - Entrenador: " + team.getCoach());
        };
        equipos.forEach(imprimirEntrenador);
    }

    public List<Team> ListaEquiposGanadores(List<Team> equipos) {
        Predicator predicator = new Predicator();
        return equipos.stream()
                .filter(team -> {
                    return team.getStatistics() != null &&
                            team.getStatistics().stream()
                                    .anyMatch(estadistica -> {
                                        try {
                                            int pg = (estadistica.getPg());
                                            return predicator.test2(pg);
                                        } catch (NumberFormatException e) {
                                            return false;
                                        }
                                    });
                })
                .collect(Collectors.toList());
    }

    public BiConsumer<Team, List<Players>> calcularPromedioEdad = (team, players) -> {
        double promedio = players.stream()
                .mapToInt(Players::getAge)
                .average()
                .orElse(0.0);

        String promedioFormateado = String.format("%.1f", promedio);

        System.out.println("Equipo: " + team.getName() + " - Promedio de edad de los jugadores: " + promedioFormateado);
    };

    public void jugadorMasAlto(List<Team> equipos) {
        Consumer<Team> encontrarJugadorMasAlto = team -> {

            if (team.getPlayers() != null && !team.getPlayers().isEmpty()) {

                Players jugadorMasAlto = team.getPlayers().stream()
                        .max((p1, p2) -> Double.compare(p1.getHeight(), p2.getHeight()))
                        .orElse(null);

                if (jugadorMasAlto != null) {
                    System.out.println("==================================" + "\nEquipo: " + team.getName() +
                            " - Jugador más alto: " + jugadorMasAlto.getName() +
                            " - Altura: " + jugadorMasAlto.getHeight() + "\n==================================");
                } else {
                    System.out.println("Equipo: " + team.getName() + " - No tiene jugadores registrados.");
                }
            } else {
                System.out.println("Equipo: " + team.getName() + " - No tiene jugadores registrados.");
            }
        };

        equipos.forEach(encontrarJugadorMasAlto);
    }

    public void sumarGolesAFavor(List<Team> equipos) {
        Consumer<Team> calcularGoles = team -> {

            if (team.getStatistics() != null && !team.getStatistics().isEmpty()) {

                int totalGoles = team.getStatistics().stream()
                        .mapToInt(estadistica -> {
                            try {
                                return (estadistica.getGf());
                            } catch (NumberFormatException e) {
                                return 0;
                            }
                        })
                        .sum();

                System.out.println("=========================="+"\nEquipo: " + team.getName() + " - Total de goles a favor: " + totalGoles +"\n==========================");
            } else {
                System.out.println("Equipo: " + team.getName() + " - No tiene estadísticas registradas.");
            }
        };

        equipos.forEach(calcularGoles);
    }
}