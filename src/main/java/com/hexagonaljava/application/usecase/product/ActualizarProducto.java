package com.hexagonaljava.application.usecase.product;

import java.util.Scanner;

public class ActualizarProducto {
    public void actualizar(Scanner sc,ProductUseCase productCasoUso){
        System.out.print("Ingresa el ID del producto que quieres actualizar: ");
                    int idActualizar = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese el nuevo nombre: ");
                    String nuevoNombre = sc.nextLine();
                    System.out.print("Ingresa el nuevo precio: ");
                    int nuevoStock = sc.nextInt();
                    sc.nextLine();
                    productCasoUso.actualizarproducto(idActualizar, nuevoNombre, nuevoStock);
    }
}
