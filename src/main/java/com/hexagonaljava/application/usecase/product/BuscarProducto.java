package com.hexagonaljava.application.usecase.product;

import java.util.Scanner;

import com.hexagonaljava.application.usecase.problems.ValidacionInt;

public class BuscarProducto {
    public void buscar(Scanner sc, ProductUseCase productCasoUso) {
        System.out.print("Ingresa el ID del producto a buscar: ");
        ValidacionInt.validar(sc);
        int idBusqueda = sc.nextInt();
        sc.nextLine();
        productCasoUso.obtenerproducto(idBusqueda);
    }
}
