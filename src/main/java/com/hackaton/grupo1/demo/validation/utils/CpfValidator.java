package com.hackaton.grupo1.demo.validation.utils;

import java.util.Scanner;
import com.hackaton.grupo1.demo.exceptions.BadRequestException;

public class CpfValidator {
    static Scanner teclado = new Scanner(System.in);

    public static boolean ValidarCpf(String cpf) {
        try {
            if (cpf == null || cpf.length() != 11) return false;
            int numero1, numero2, numero3, numero4, numero5, numero6, numero7, numero8, numero9;
            int somaPrimeiroDigitoVerificador, somaSegundoDigitoVerificador;
            int primeiroDigitoVerificador, segundoDigitoVerificador;

            cpf = removerFormatacaoCPF(cpf);

            numero1 = obterNumeroPosicao(cpf, 0);
            numero2 = obterNumeroPosicao(cpf, 1);
            numero3 = obterNumeroPosicao(cpf, 2);
            numero4 = obterNumeroPosicao(cpf, 3);
            numero5 = obterNumeroPosicao(cpf, 4);
            numero6 = obterNumeroPosicao(cpf, 5);
            numero7 = obterNumeroPosicao(cpf, 6);
            numero8 = obterNumeroPosicao(cpf, 7);
            numero9 = obterNumeroPosicao(cpf, 8);

            somaPrimeiroDigitoVerificador = (numero1 * 10) + (numero2 * 9) + (numero3 * 8) + (numero4 * 7) + (numero5 * 6) + (numero6 * 5) + (numero7 * 4) + (numero8 * 3) + (numero9 * 2);

            primeiroDigitoVerificador = calcularDigitoVerificador(somaPrimeiroDigitoVerificador);

            somaSegundoDigitoVerificador = (numero1 * 11) + (numero2 * 10) + (numero3 * 9) + (numero4 * 8) + (numero5 * 7) + (numero6 * 6) + (numero7 * 5) + (numero8 * 4) + (numero9 * 3) + (primeiroDigitoVerificador * 2);

            segundoDigitoVerificador = calcularDigitoVerificador(somaSegundoDigitoVerificador);

            switch (cpf) {
                case "00000000000":
                case "11111111111":
                case "22222222222":
                case "33333333333":
                case "44444444444":
                case "55555555555":
                case "66666666666":
                case "77777777777":
                case "88888888888":
                case "99999999999":
                    System.out.print("CPF Inválido");
                    return false; // 🔥 aqui
                default:

                    if (obterNumeroPosicao(cpf, 9) == primeiroDigitoVerificador && obterNumeroPosicao(cpf, 10) == segundoDigitoVerificador) {
                        return true;
                    } else {
                        System.out.print("CPF Inválido");
                        return false; 
                    }
            }
        } catch (Exception e) {
            return false;
        }
    }

    static int calcularDigitoVerificador(int soma) {
        int resto = soma % 11;
        int dv;

        if (resto < 2) {
            dv = 0;
        } else {
            dv = 11 - resto;
        }

        return dv;
    }

    static int obterNumeroPosicao(String str, int posicao) {
        return (str.charAt(posicao) - '0');
    }

    static String removerFormatacaoCPF(String cpf) {
        cpf = cpf.replace(".", "");
        cpf = cpf.replace("-", "");

        return cpf;
    }

}