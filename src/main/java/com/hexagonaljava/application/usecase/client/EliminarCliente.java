package com.hexagonaljava.application.usecase.client;

import java.util.Scanner;

import com.hexagonaljava.application.usecase.problems.ValidacionInt;

public class EliminarCliente {
    public void eliminar(Scanner sc, ClientUseCase clienteCasoUso) {
        System.out.print("Ingresa el ID del cliente que quieres eliminar: ");
        ValidacionInt.validar(sc);
        int idEliminar = sc.nextInt();
        clienteCasoUso.eliminarCliente(idEliminar);
    }
}
