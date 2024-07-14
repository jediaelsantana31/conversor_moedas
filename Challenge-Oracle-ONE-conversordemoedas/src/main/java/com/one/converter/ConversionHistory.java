package com.one.converter;

import java.util.ArrayList;
import java.util.List;

public class ConversionHistory {

    private List<String> history;

    public ConversionHistory() {
        this.history = new ArrayList<>();
    }

    public void addConversion(String conversion) {
        history.add(conversion);
    }

    public void printHistory() {
        if (history.isEmpty()) {
            System.out.println("Nenhuma conversão realizada.");
        } else {
            System.out.println("Histórico de Conversões:");
            for (String entry : history) {
                System.out.println(entry);
            }
        }
    }
}
