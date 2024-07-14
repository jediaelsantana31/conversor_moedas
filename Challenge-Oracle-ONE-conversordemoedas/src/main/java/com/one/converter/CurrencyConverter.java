package com.one.converter;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyConverter {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/41de42d8eee502ab645d0cf8/latest/";

    public double convert(String fromCurrency, String toCurrency, double amount) throws Exception {
        String requestUrl = API_URL + fromCurrency;
        URL url = new URL(requestUrl);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonParser jp = new JsonParser();
        JsonObject root = jp.parse(new InputStreamReader((InputStream) request.getContent())).getAsJsonObject();
        JsonObject rates = root.getAsJsonObject("conversion_rates");

        double rate = rates.get(toCurrency).getAsDouble();
        return amount * rate;
    }
}
