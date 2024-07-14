package com.one.main;

import com.one.converter.ConversionHistory;
import com.one.converter.CurrencyConverter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConversorMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();
        ConversionHistory history = new ConversionHistory();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        while (true) {
            System.out.println("Bem-vindo ao Conversor de Moedas");
            System.out.println("Escolha uma opção de conversão:");
            System.out.println("1. Dólar para Real");
            System.out.println("2. Real para Dólar");
            System.out.println("3. Euro para Real");
            System.out.println("4. Real para Euro");
            System.out.println("5. Dólar para Euro");
            System.out.println("6. Euro para Dólar");
            System.out.println("7. Ver histórico de conversões");
            System.out.println("0. Sair");

            int opcao = scanner.nextInt();
            if (opcao == 0) {
                break;
            }

            if (opcao == 7) {
                history.printHistory();
                continue;
            }

            System.out.print("Digite o valor que deseja converter: ");
            double valor = scanner.nextDouble();

            try {
                double resultado = 0;
                String fromCurrency = "";
                String toCurrency = "";
                switch (opcao) {
                    case 1:
                        fromCurrency = "USD";
                        toCurrency = "BRL";
                        resultado = converter.convert(fromCurrency, toCurrency, valor);
                        break;
                    case 2:
                        fromCurrency = "BRL";
                        toCurrency = "USD";
                        resultado = converter.convert(fromCurrency, toCurrency, valor);
                        break;
                    case 3:
                        fromCurrency = "EUR";
                        toCurrency = "BRL";
                        resultado = converter.convert(fromCurrency, toCurrency, valor);
                        break;
                    case 4:
                        fromCurrency = "BRL";
                        toCurrency = "EUR";
                        resultado = converter.convert(fromCurrency, toCurrency, valor);
                        break;
                    case 5:
                        fromCurrency = "USD";
                        toCurrency = "EUR";
                        resultado = converter.convert(fromCurrency, toCurrency, valor);
                        break;
                    case 6:
                        fromCurrency = "EUR";
                        toCurrency = "USD";
                        resultado = converter.convert(fromCurrency, toCurrency, valor);
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        continue;
                }

                String timestamp = LocalDateTime.now().format(formatter);
                String conversionRecord = String.format("%s: %.2f %s para %.2f %s", timestamp, valor, fromCurrency, resultado, toCurrency);
                history.addConversion(conversionRecord);

                System.out.printf("O valor convertido é: %.2f%n", resultado);
            } catch (Exception e) {
                System.out.println("Erro na conversão: " + e.getMessage());
            }
        }
    }
}
