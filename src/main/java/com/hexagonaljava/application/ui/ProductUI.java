package com.hexagonaljava.application.ui;

import java.util.Scanner;

import com.hexagonaljava.application.usecase.problems.*;
import com.hexagonaljava.application.usecase.product.*;

public class ProductUI {
    public static void manejarMenuProductos(Scanner sc, ProductUseCase productCasoUso) {
        int opcionProducts;
        do {
            String menuProducts = """
                    ********PRODUCTOS********
                    1. Registrar Producto
                    2. Obtener Producto por ID
                    3. Listar todos los productos
                    4. Actualizar un producto
                    5. Eliminar un producto
                    6. Salir...
                    Seleccione una opción:""";
            System.out.print(menuProducts);

            ValidacionInt.validar(sc);
            opcionProducts = sc.nextInt();
            sc.nextLine();

            switch (opcionProducts) {
                case 1:
                    registrarProducto registrarProducto = new registrarProducto();
                    registrarProducto.registrar(sc, productCasoUso);
                    break;
                case 2:
                    BuscarProducto buscarProducto = new BuscarProducto();
                    buscarProducto.buscar(sc, productCasoUso);
                    break;
                case 3:
                    productCasoUso.listarproductos();
                    break;
                case 4:
                    ActualizarProducto actualizarProducto = new ActualizarProducto();
                    actualizarProducto.actualizar(sc, productCasoUso);
                    break;
                case 5:
                    EliminarProducto eliminarProducto = new EliminarProducto();
                    eliminarProducto.eliminar(sc, productCasoUso);
                    break;
                case 6:
                    System.out.println("Saliendo....");
                    break;
                default:
                    System.out.println("Opción inválida. Vuelva a intentarlo.");
                    break;
            }
        } while (opcionProducts != 6);
    }

}
