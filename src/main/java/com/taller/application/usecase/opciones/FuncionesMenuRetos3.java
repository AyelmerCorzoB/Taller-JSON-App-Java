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

public class FuncionesMenuRetos3 {
    public static void arrancar() {
        Scanner sc = new Scanner(System.in);
        TeamsService servicio = new TeamsService();

        List<Team> equipos = servicio.obtenerTodosLosEquipos();

        int opcionMenuRetos;
        do {
            MenuRetos.mostrarMenu3();
            ValidacionInt.validar(sc);
            opcionMenuRetos = sc.nextInt();
            sc.nextLine();
            switch (opcionMenuRetos) {
                case 1:
                    Map<String, Long> jugadoresPorPosicion = equipos.stream()
                            .flatMap(team -> team.getPlayers().stream())
                            .collect(Collectors.groupingBy(
                                    Players::getPosition,
                                    Collectors.counting()));

                    if (jugadoresPorPosicion.isEmpty()) {
                        System.out.println("📂 No se encontraron jugadores.");
                    } else {
                        System.out.println("✅ Jugadores agrupados por posición:");
                        jugadoresPorPosicion.forEach((posicion, cantidad) -> {
                            System.out.println("| Posición: " + posicion + " | Cantidad: " + cantidad + " |");
                            System.out.println("------------------------------------------------------");
                        });
                    }
                    break;
                case 2:
                    List<Team> equiposConMasDe20Goles = equipos.stream()
                            .filter(team -> team.getStatistics().get(0).getGf() > 20)

                            .sorted(Comparator.comparingInt(
                                    team -> ((Team) team).getStatistics().get(0).getGf()).reversed())
                            .collect(Collectors.toList());

                    if (equiposConMasDe20Goles.isEmpty()) {
                        System.out.println("📂 No se encontraron equipos con más de 20 goles a favor.");
                    } else {
                        System.out.println("✅ Equipos con más de 20 goles a favor (ordenados de mayor a menor):");
                        equiposConMasDe20Goles.forEach(team -> {
                            System.out.printf("| Equipo: %s | Goles a favor: %d |%n", team.getName(),
                                    team.getStatistics().get(0).getGf());
                            System.out.println("------------------------------------------------------");
                        });
                    }
                    break;
                case 3:
                    System.out.println("Salir..");
                    break;
                default:
                    System.out.println("❌ Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        } while (opcionMenuRetos != 3);
    }
}