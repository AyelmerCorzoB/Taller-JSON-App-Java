package com.hexagonaljava.application.usecase.client;

import java.util.Scanner;

import com.hexagonaljava.application.usecase.problems.ValidacionInt;
import com.hexagonaljava.application.usecase.problems.ValidacionString;

public class registrarCliente {
    public void registro(Scanner sc, ClientUseCase clienteCasoUso) {
        System.out.print("Ingrese ID del Cliente: ");
        ValidacionInt.validar(sc);
        int idRegistro = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese Nombre: ");
        ValidacionString.validar(sc);
        String nombre = sc.nextLine();

        System.out.print("Ingrese Email: ");
        ValidacionString.validar(sc);
        String email = sc.nextLine();

        while (!email.contains("@")) {
            System.out.println("**************\t   ERROR\t    **********");
            System.out.println(
                    "El email debe contener '@'. Por favor, ingresa un email válido (ejemplo: correo@ejemplo.com).");
            System.out.print("Ingrese Email: ");
            email = sc.nextLine();
        }

        clienteCasoUso.registrarCliente(idRegistro, nombre, email);
        System.out.println("✅ Cliente registrado exitosamente.");
    }
}
