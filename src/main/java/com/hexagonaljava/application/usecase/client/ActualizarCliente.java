package com.hexagonaljava.application.usecase.client;

import java.util.Scanner;

import com.hexagonaljava.application.usecase.problems.ValidacionInt;
import com.hexagonaljava.application.usecase.problems.ValidacionString;

public class ActualizarCliente {
    public void actualizar(Scanner sc, ClientUseCase clienteCasoUso) {
        System.out.print("Ingresa el ID del cliente que quieres actualizar: ");
        ValidacionInt.validar(sc);
        int idActualizar = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese el nuevo nombre: ");
        ValidacionString.validar(sc);
        String nuevoNombre = sc.nextLine();
        System.out.print("Ingresa el nuevo email: ");
        ValidacionString.validar(sc);
        String nuevoEmail = sc.nextLine();
        clienteCasoUso.actualizarCliente(idActualizar, nuevoNombre, nuevoEmail);
    }
}
