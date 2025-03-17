package com.hexagonaljava.application.usecase.problems;

import java.util.Scanner;

public class ValidacionString {
    public static void validar(Scanner dato){
        while (!dato.hasNextLine()) {
            System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
            System.out.print("Reintente: ");
            dato.nextLine(); 
        }
    }
}
