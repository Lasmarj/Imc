package com.lasmarj.imc.util;

public class ImcCalculator {

    public static double calcularAltura(double alturaMt) {
        return alturaMt;
    }

    public static double calcularPeso(double alturaCm, double pesoKg) {
        return (alturaCm - 100) - ((alturaCm - pesoKg) / 4) * (5.0 / 100);
    }

    public static double calcularImc(double alturaMt, double pesoKg) {
        return pesoKg / Math.pow(alturaMt, 2);
    }

    public static String classificarImc(double imc) {
        if (imc < 20) return "Baixo peso";
        if (imc < 25) return "Peso normal";
        if (imc < 30) return "Sobrepeso";
        return "Obesidade";
    }
}
