package com.taller.application.usecase.opciones;

import java.util.List;
import java.util.Scanner;

import com.taller.application.ui.filtros.Filtrar;
import com.taller.application.ui.menus.MenuEjercicios;
import com.taller.application.usecase.problems.ValidacionInt;
import com.taller.domain.entity.Players;
import com.taller.domain.entity.Team;
import com.taller.domain.entity.TeamsService;

public class FuncionesMenuEjercicios {

    public static void arrancar() {
        Scanner sc = new Scanner(System.in);
        TeamsService servicio = new TeamsService();
        Filtrar filtrar = new Filtrar();
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
    }
}
