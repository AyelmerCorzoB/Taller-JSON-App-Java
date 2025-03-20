package com.taller.application.usecase.opciones;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.taller.application.ui.menus.MenuRetos;
import com.taller.application.usecase.problems.ValidacionInt;
import com.taller.domain.entity.Players;
import com.taller.domain.entity.Team;
import com.taller.domain.entity.TeamsService;

public class FuncionesMenuRetos2 {
    public static void arrancar() {
        Scanner sc = new Scanner(System.in);
        TeamsService servicio = new TeamsService();

        List<Team> equipos = servicio.obtenerTodosLosEquipos();

        int opcionMenuRetos;
        do {
            MenuRetos.mostrarMenu2();
            ValidacionInt.validar(sc);
            opcionMenuRetos = sc.nextInt();
            sc.nextLine();
            switch (opcionMenuRetos) {
                case 1:
                    List<String> entrenadoresConEmpates = equipos.stream()
                            .filter(team -> team.getStatistics().get(0).getPe() > 0)
                            .map(Team::getCoach)
                            .collect(Collectors.toList());

                    if (entrenadoresConEmpates.isEmpty()) {
                        System.out.println("📂 No se encontraron equipos con partidos empatados.");
                    } else {
                        System.out.println("✅ Entrenadores de equipos con al menos un partido empatado:");
                        entrenadoresConEmpates.forEach(entrenador -> {
                            System.out.println("| Entrenador: " + entrenador + " |");
                            System.out.println("------------------------------------------------------");
                        });
                    }
                    break;
                case 2:
                    Map<String, Integer> golesPorEquipo = equipos.stream()
                            .collect(Collectors.toMap(
                                    Team::getName,
                                    team -> team.getStatistics().get(0).getGf()));

                    System.out.println("✅ Goles a favor por equipo:");
                    golesPorEquipo.forEach((equipo, goles) -> {
                        System.out.println("| Equipo: " + equipo + " | Goles a favor: " + goles + " |");
                        System.out.println("------------------------------------------------------");
                    });
                    break;
                case 3:
                    List<Players> jugadoresBrasilenos = equipos.stream()
                            .flatMap(team -> team.getPlayers().stream())
                            .filter(player -> "Brasileño".equalsIgnoreCase(player.getNationality()))

                            .sorted(Comparator.comparingInt(Players::getAge))
                            .collect(Collectors.toList());

                    if (jugadoresBrasilenos.isEmpty()) {
                        System.out.println("📂 No se encontraron jugadores de nacionalidad Brasileño.");
                    } else {
                        System.out.println("✅ Jugadores Brasileños ordenados por edad:");
                        jugadoresBrasilenos.forEach(player -> {
                            String jugadorInfo = String.format(
                                    "| Nombre: %s | Edad: %d | Nacionalidad: %s |",
                                    player.getName(), player.getAge(), player.getNationality());
                            System.out.println(jugadorInfo);
                            System.out.println("------------------------------------------------------");
                        });
                    }
                    break;
                case 4:
                    List<Team> equiposConEntrenadorLargo = equipos.stream()
                            .filter(team -> team.getCoach().length() > 10)
                            .collect(Collectors.toList());
                    if (equiposConEntrenadorLargo.isEmpty()) {
                        System.out.println(
                                "📂 No se encontraron equipos cuyo entrenador tenga más de 10 caracteres en su nombre.");
                    } else {
                        System.out.println("✅ Equipos cuyo entrenador tiene más de 10 caracteres en su nombre:");
                        equiposConEntrenadorLargo.forEach(team -> {
                            String equipoInfo = String.format(
                                    "| Equipo: %s | Entrenador: %s |",
                                    team.getName(), team.getCoach());
                            System.out.println(equipoInfo);
                            System.out.println("------------------------------------------------------");
                        });
                    }
                    break;
                case 5:
                    boolean algunEquipoConMasDe25Puntos = equipos.stream()
                            .anyMatch(team -> team.getStatistics().get(0).getTp() > 25);
                    if (algunEquipoConMasDe25Puntos) {
                        System.out.println("✅ Al menos un equipo tiene más de 25 puntos.");
                    } else {
                        System.out.println("📂 Ningún equipo tiene más de 25 puntos.");
                    }
                    break;
                case 6:
                    FuncionesMenuRetos3.arrancar();
                default:
                    System.out.println("❌ Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        } while (opcionMenuRetos != 7);
    }
}