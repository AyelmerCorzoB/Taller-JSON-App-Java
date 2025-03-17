package com.hexagonaljava;

import java.util.Scanner;

import com.hexagonaljava.application.ui.ClientUI;
import com.hexagonaljava.application.ui.MenuPrincipal;
import com.hexagonaljava.application.ui.ProductUI;
import com.hexagonaljava.application.usecase.client.ClientUseCase;
import com.hexagonaljava.application.usecase.problems.ValidacionInt;
import com.hexagonaljava.application.usecase.product.ProductUseCase;
import com.hexagonaljava.domain.repository.ClientRespository;
import com.hexagonaljava.domain.repository.ProductRepository;
import com.hexagonaljava.infrastructure.database.ConnectionFactory;
import com.hexagonaljava.infrastructure.persistence.client.ClientRepositoryImpl;
import com.hexagonaljava.infrastructure.persistence.product.ProductRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        ClientRespository repositorioClient = new ClientRepositoryImpl(ConnectionFactory.crearConexion());
        ProductRepository repositorioProduct = new ProductRepositoryImpl(ConnectionFactory.crearConexion());
        ClientUseCase clienteCasoUso = new ClientUseCase(repositorioClient);
        ProductUseCase productUseCase = new ProductUseCase(repositorioProduct);

        try (Scanner sc = new Scanner(System.in)) {
            int opcionMenu;
            do {
                MenuPrincipal.mostrarMenuPrincipal();
                
                ValidacionInt.validar(sc);
                
                opcionMenu = sc.nextInt();
                
                sc.nextLine(); 
                switch (opcionMenu) {
                    case 1:
                        ClientUI.manejarMenuClientes(sc, clienteCasoUso);
                        break;
                    case 2:
                        ProductUI.manejarMenuProductos(sc, productUseCase);
                        break;
                    case 3:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción inválida. Vuelva a intentarlo.");
                        break;
                }
            } while (opcionMenu != 3);
        } 
    }
}