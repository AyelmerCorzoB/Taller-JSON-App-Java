package com.hexagonaljava.application.usecase.client;

import java.util.Scanner;

import com.hexagonaljava.application.usecase.problems.*;

public class BuscarCliente {
    public void buscar(Scanner sc, ClientUseCase clienteCasoUso) {
        System.out.print("Ingresa el ID del cliente a buscar: ");
        ValidacionInt.validar(sc);
        int idBusqueda = sc.nextInt();
        sc.nextLine();
        clienteCasoUso.obtenerCliente(idBusqueda);
    }
}
