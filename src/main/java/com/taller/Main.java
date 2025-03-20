package com.taller;

import java.util.Scanner;

import com.taller.application.ui.menus.MenuPrincipal;
import com.taller.application.usecase.opciones.FuncionesMenuEjercicios;
import com.taller.application.usecase.opciones.FuncionesMenuRetos;
import com.taller.application.usecase.problems.ValidacionInt;

public class Main {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            int opcionMenuPrincipal;
            do {
                MenuPrincipal.mostrarMenu();
                ValidacionInt.validar(sc);
                opcionMenuPrincipal = sc.nextInt();
                sc.nextLine();
                switch (opcionMenuPrincipal) {
                    case 1:
                        FuncionesMenuEjercicios.arrancar();
                        break;
                    case 2:
                        FuncionesMenuRetos.arrancar();
                        break;
                    case 3:
                        System.out.println("Saliendo....");
                    break;
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