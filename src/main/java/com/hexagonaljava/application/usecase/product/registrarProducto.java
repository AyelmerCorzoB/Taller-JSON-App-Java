package com.hexagonaljava.application.usecase.product;

import java.util.Scanner;

import com.hexagonaljava.application.usecase.problems.ValidacionInt;
import com.hexagonaljava.application.usecase.problems.ValidacionString;

public class registrarProducto {
    public void registrar(Scanner sc, ProductUseCase productCasoUso) {
        System.out.print("Ingrese ID del Producto: ");
        ValidacionInt.validar(sc);
        int idRegistroP = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese Nombre: ");
        ValidacionString.validar(sc);
        String nombre = sc.nextLine();
        System.out.print("Ingrese la cantidad: ");
        ValidacionInt.validar(sc);
        int stock = sc.nextInt();
        sc.nextLine();
        productCasoUso.registrarproducto(idRegistroP, nombre, stock);
        System.out.println("✅ Producto registrado exitosamente.");
    }
}
