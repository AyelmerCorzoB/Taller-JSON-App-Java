package com.hexagonaljava.application.usecase.product;

import java.util.Scanner;

import com.hexagonaljava.application.usecase.problems.ValidacionInt;

public class EliminarProducto {
    public void eliminar(Scanner sc, ProductUseCase productCasoUso) {
        System.out.print("Ingresa el ID del Producto que quieres eliminar: ");
        ValidacionInt.validar(sc);
        int idEliminar = sc.nextInt();
        productCasoUso.eliminarproducto(idEliminar);
    }
}
