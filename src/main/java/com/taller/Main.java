package com.taller;

import java.util.Scanner;
import java.util.List;

import com.taller.application.ui.filtros.Filtrar;
import com.taller.application.ui.menus.MenuPrincipal;
import com.taller.application.usecase.problems.ValidacionInt;
import com.taller.domain.entity.TeamsService;
import com.taller.domain.entity.Team;

public class Main {
    public static void main(String[] args) {
        TeamsService servicio = new TeamsService();
        Filtrar filtrar = new Filtrar();

        try (Scanner sc = new Scanner(System.in)) {
            int opcionMenu;
            do {
                MenuPrincipal.mostrarMenuPrincipal();
                ValidacionInt.validar(sc);
                opcionMenu = sc.nextInt();
                sc.nextLine(); 

                switch (opcionMenu) {
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
                                System.out.println("------------------------------------------------------");
                                System.out.println(lista);
                                System.out.println("------------------------------------------------------");
                            });
                        }
                        break;
                    case 3:
                        System.out.println("✅ Entrenadores:");
                        filtrar.entrenadores(servicio.obtenerTodosLosEquipos());
                        break;
                    default:
                        System.out.println("Opción inválida. Vuelva a intentarlo.");
                        break;
                }
            } while (opcionMenu != 4); // Cambia la condición para salir del bucle
        } catch (Exception e) {
            System.out.println("❌ Ocurrió un error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}