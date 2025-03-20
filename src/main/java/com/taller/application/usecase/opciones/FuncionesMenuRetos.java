package com.taller.application.usecase.opciones;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.taller.application.ui.filtros.FiltrosRetos;
import com.taller.application.ui.menus.MenuRetos;
import com.taller.application.usecase.problems.ValidacionInt;
import com.taller.domain.entity.Players;
import com.taller.domain.entity.Team;
import com.taller.domain.entity.TeamsService;

public class FuncionesMenuRetos {
    public static void arrancar() {
        Scanner sc = new Scanner(System.in);
        TeamsService servicio = new TeamsService();
        FiltrosRetos filtrosRetos = new FiltrosRetos();

        List<Team> equipos = servicio.obtenerTodosLosEquipos();

        int opcionMenuRetos;
        do {
            MenuRetos.mostrarMenu();
            ValidacionInt.validar(sc);
            opcionMenuRetos = sc.nextInt();
            sc.nextLine();
            switch (opcionMenuRetos) {
                case 1:
                    List<Team> equiposConMasDe15 = filtrosRetos.ListarEquipos15Puntos(equipos);
                    if (equiposConMasDe15.isEmpty()) {
                        System.out.println("📂 No hay equipos con más de 15 puntos en la liga.");
                    } else {
                        System.out.println("✅ Equipos con más de 15 puntos en la liga:");
                        equiposConMasDe15.forEach(team -> {
                            String lista = String.format(
                                    "|Nombre: %s - Partidos ganados: %s |", team.getName(),
                                    team.getStatistics().get(0).getTp());
                            System.out.println("------------------------------------------------------");
                            System.out.println(lista);
                            System.out.println("------------------------------------------------------");
                        });
                    }
                    break;

                case 2:
                    List<Team> equiposFiltrados = filtrosRetos.ListarEquipos15Puntos(equipos);

                    if (equiposFiltrados.isEmpty()) {
                        System.out.println("📂 No se encontraron equipos");
                    } else {
                        double promedioGolesAFavor = equiposFiltrados.stream()
                                .collect(Collectors.averagingInt(team -> team.getStatistics().get(0).getGf()));

                        System.out.println("✅ Promedio de goles a favor por equipo: " + promedioGolesAFavor);

                        System.out.println("📋 Lista de equipos con sus goles a favor:");
                        equiposFiltrados.forEach(team -> {
                            String lista = String.format(
                                    "|Nombre: %s - Goles a favor: %s |", team.getName(),
                                    team.getStatistics().get(0).getGf());
                            System.out.println("------------------------------------------------------");
                            System.out.println(lista);
                            System.out.println("------------------------------------------------------");
                        });
                    }
                    break;

                case 3:
                    Optional<Team> equipoConMasVictorias = equipos.stream()
                            .max(Comparator.comparingInt(team -> team.getStatistics().get(0).getPg()));

                    if (equipoConMasVictorias.isPresent()) {
                        Team equipo = equipoConMasVictorias.get();
                        System.out.println("🏆 Equipo con más victorias:");
                        System.out.println("| Nombre: " + equipo.getName() + " | Victorias: "
                                + equipo.getStatistics().get(0).getPg() + " |");
                    } else {
                        System.out.println("📂 No se encontraron equipos.");
                    }
                    break;

                case 4:
                    Optional<Players> jugadorMasAlto = equipos.stream()
                            .flatMap(team -> team.getPlayers().stream())
                            .max(Comparator.comparingInt(Players::getHeight));

                    if (jugadorMasAlto.isPresent()) {
                        Players jugador = jugadorMasAlto.get();
                        System.out.println("🏆 Jugador más alto:");
                        System.out.println(
                                "| Nombre: " + jugador.getName() + " | Altura: " + jugador.getHeight() + " cm |");
                    } else {
                        System.out.println("📂 No se encontraron jugadores.");
                    }
                    break;
                case 5:
                    long totalDelanteros = equipos.stream()
                            .flatMap(team -> team.getPlayers().stream())
                            .filter(player -> "Delantero".equalsIgnoreCase(player.getPosition()))
                            .count();
                    System.out.println("⚽ Total de delanteros en la UEFA Champions League: " + totalDelanteros);
                    break;
                case 6:
                    FuncionesMenuRetos2.arrancar();
                    break;
                default:
                    System.out.println("❌ Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        } while (opcionMenuRetos != 7);
    }
}