package com.hexagonaljava.application.ui;

import java.util.Scanner;

import com.hexagonaljava.application.usecase.client.*;
import com.hexagonaljava.application.usecase.problems.*;

public class ClientUI {
    public static void manejarMenuClientes(Scanner sc, ClientUseCase clienteCasoUso) {
        int opcionClient;
        do {
            String menuCliente = """
                    ********CLIENTES********
                    1. Registrar Cliente
                    2. Obtener cliente por ID
                    3. Listar todos los clientes
                    4. Actualizar un cliente
                    5. Eliminar un cliente
                    6. Salir...
                    Seleccione una opción:""";
            System.out.print(menuCliente);

            ValidacionInt.validar(sc);
            opcionClient = sc.nextInt();

            sc.nextLine();

            switch (opcionClient) {
                case 1:
                    registrarCliente registrar = new registrarCliente();
                    registrar.registro(sc, clienteCasoUso);
                    break;
                case 2:
                    BuscarCliente buscarCliente = new BuscarCliente();
                    buscarCliente.buscar(sc, clienteCasoUso);
                    break;
                case 3:
                    clienteCasoUso.listarClientes();
                    break;
                case 4:
                    ActualizarCliente actualizarCliente = new ActualizarCliente();
                    actualizarCliente.actualizar(sc, clienteCasoUso);
                    break;
                case 5:
                    EliminarCliente eliminarCliente = new EliminarCliente();
                    eliminarCliente.eliminar(sc, clienteCasoUso);
                    break;
                case 6:
                    System.out.println("Saliendo....");
                    break;
                default:
                    System.out.println("Opción inválida. Vuelva a intentarlo.");
                    break;
            }
        } while (opcionClient != 6);
    }
}
