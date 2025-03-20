package com.taller;

import java.util.Scanner;
import java.util.List;

import com.taller.application.ui.filtros.Filtrar;
import com.taller.application.ui.filtros.FiltrosRetos;
import com.taller.application.ui.menus.MenuEjercicios;
import com.taller.application.ui.menus.MenuPrincipal;
import com.taller.application.ui.menus.MenuRetos;
import com.taller.application.usecase.problems.ValidacionInt;
import com.taller.domain.entity.TeamsService;
import com.taller.domain.entity.Players;
import com.taller.domain.entity.Team;

public class Main {
    public static void main(String[] args) {
        TeamsService servicio = new TeamsService();
        Filtrar filtrar = new Filtrar();
        FiltrosRetos filtrosRetos = new FiltrosRetos();

        try (Scanner sc = new Scanner(System.in)) {
            int opcionMenuPrincipal;
            do {
                MenuPrincipal.mostrarMenu();
                ValidacionInt.validar(sc);
                opcionMenuPrincipal = sc.nextInt();
                sc.nextLine();
                switch (opcionMenuPrincipal) {
                    case 1:
                        int opcionMenuEjercicios;
                        do {
                            MenuEjercicios.mostrarMenu();
                            ValidacionInt.validar(sc);
                            opcionMenuEjercicios = sc.nextInt();
                            sc.nextLine();
                            switch (opcionMenuEjercicios) {
                                case 1:
                                    servicio.listarTeams();
                                    break;
                                case 2:
                                    List<Team> equiposFiltrados = filtrar
                                            .fundadosDespuesDelAño2000(servicio.obtenerTodosLosEquipos());
                                    if (equiposFiltrados.isEmpty()) {
                                        System.out.println("📂 No hay equipos fundados después del año 2000.");
                                    } else {
                                        System.out.println("✅ Equipos fundados después del año 2000:");
                                        equiposFiltrados.forEach(team -> {
                                            String lista = String.format(
                                                    "| ID: %s - Nombre: %s - Fecha de fundación: %s |",
                                                    team.getId(), team.getName(), team.getYearfoundation());
                                            System.out
                                                    .println("------------------------------------------------------");
                                            System.out.println(lista);
                                            System.out
                                                    .println("------------------------------------------------------");
                                        });
                                    }
                                    break;
                                case 3:
                                    System.out.println("✅ Entrenadores:");
                                    filtrar.entrenadores(servicio.obtenerTodosLosEquipos());
                                    break;
                                case 4:
                                    System.out.println("✅ Calcular promedio de edad de los jugadores:");
                                    List<Team> equipos = servicio.obtenerTodosLosEquipos();
                                    equipos.forEach(team -> {
                                        List<Players> jugadores = team.getPlayers();
                                        filtrar.calcularPromedioEdad.accept(team, jugadores);
                                    });
                                    break;

                                case 5:
                                    List<Team> equiposGanadores = filtrar
                                            .ListaEquiposGanadores(servicio.obtenerTodosLosEquipos());
                                    if (equiposGanadores.isEmpty()) {
                                        System.out.println("📂 No hay equipos con más de 20 partidos ganados.");
                                    } else {
                                        System.out.println("✅ Equipos con más de 20 partidos ganados:");
                                        equiposGanadores.forEach(team -> {
                                            String lista = String.format(
                                                    "| ID: %s - Nombre: %s - Partidos ganados: %s |",
                                                    team.getId(), team.getName(),
                                                    team.getStatistics().get(0).getPg());
                                            System.out
                                                    .println("------------------------------------------------------");
                                            System.out.println(lista);
                                            System.out
                                                    .println("------------------------------------------------------");
                                        });
                                    }
                                    break;
                                case 6:
                                    System.out.println("✅ Jugador más alto por equipo:");
                                    filtrar.jugadorMasAlto(servicio.obtenerTodosLosEquipos());
                                    break;
                                case 7:
                                    System.out.println("✅ Sumar goles a favor por equipo:");
                                    filtrar.sumarGolesAFavor(servicio.obtenerTodosLosEquipos());
                                    break;
                                case 8:
                                    System.out.println("Saliendo....");
                                    break;
                                default:
                                    System.out.println("Opción inválida. Vuelva a intentarlo.");
                                    break;

                            }
                        } while (opcionMenuEjercicios != 8);
                        break;
                    case 2:
                        int opcionMenuRetos;
                        do {
                            MenuRetos.mostrarMenu();
                            ValidacionInt.validar(sc);
                            opcionMenuRetos = sc.nextInt();
                            sc.nextLine();
                            switch (opcionMenuRetos) {
                                case 1:
                                    List<Team> equiposConMasDe15 = filtrosRetos
                                            .ListarEquipos15Puntos(servicio.obtenerTodosLosEquipos());
                                    if (equiposConMasDe15.isEmpty()) {
                                        System.out.println("📂 No hay equipos con más de 15 puntos en la liga.");
                                    } else {
                                        System.out.println("✅ Equipos con más de 15 puntos en la liga:");
                                        equiposConMasDe15.forEach(team -> {
                                            String lista = String.format(
                                                    "| ID: %s - Nombre: %s - Partidos ganados: %s |", team.getName(),
                                                    team.getStatistics().get(0).getTp());
                                            System.out
                                                    .println("------------------------------------------------------");
                                            System.out.println(lista);
                                            System.out
                                                    .println("------------------------------------------------------");
                                        });
                                    }
                                    break;

                                default:
                                    break;
                            }
                        } while (opcionMenuRetos != 3);

                    default:
                        break;
                }
            } while (opcionMenuPrincipal != 3);

        } catch (Exception e) {
            System.out.println("❌ Ocurrió un error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}