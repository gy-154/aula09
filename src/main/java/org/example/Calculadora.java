package org.example;

public class Calculadora {

    // Método para somar dois números inteiros
    public static int somar(int a, int b) {
        return a + b;
    }

    // Método para dividir dois números inteiros
    public static int dividir(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisão por zero não permitida");
        }
        return a / b;
    }
}
