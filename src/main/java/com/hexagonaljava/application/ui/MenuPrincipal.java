package com.hexagonaljava.application.ui;

public class MenuPrincipal {
    public static void mostrarMenuPrincipal() {
        String menu = """
                ****CLIENTES Y PRODUCTOS****
                1. CRUD - Clientes
                2. CRUD - Productos
                3. Salir
                Seleccione una opción:""";
        System.out.print(menu);
    }
}
