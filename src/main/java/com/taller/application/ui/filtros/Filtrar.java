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
                                            int pg = Integer.parseInt(estadistica.getPg());
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
        // Este String es para formatear el resultado y que no salga 33.3333333333 y mas
        // que solo imprima 33.3
        String promedioFormateado = String.format("%.1f", promedio);

        System.out.println("Equipo: " + team.getName() + " - Promedio de edad de los jugadores: " + promedioFormateado);
    };

    public void jugadorMasAlto(List<Team> equipos) {
        Consumer<Team> encontrarJugadorMasAlto = team -> {
            // Verificar si el equipo tiene jugadores
            if (team.getPlayers() != null && !team.getPlayers().isEmpty()) {
                // Usar Stream para encontrar al jugador más alto
                Players jugadorMasAlto = team.getPlayers().stream()
                        .max((p1, p2) -> Double.compare(p1.getHeight(), p2.getHeight())) // Comparar alturas
                        .orElse(null); // Si no hay jugadores, devolver null
    
                // Mostrar el resultado
                if (jugadorMasAlto != null) {
                    System.out.println("=================================="+"\nEquipo: " + team.getName() + 
                                       " - Jugador más alto: " + jugadorMasAlto.getName() + 
                                       " - Altura: " + jugadorMasAlto.getHeight()+ "\n==================================");
                } else {
                    System.out.println("Equipo: " + team.getName() + " - No tiene jugadores registrados.");
                }
            } else {
                System.out.println("Equipo: " + team.getName() + " - No tiene jugadores registrados.");
            }
        };
    
        // Aplicar la lógica a cada equipo
        equipos.forEach(encontrarJugadorMasAlto);
    }
}