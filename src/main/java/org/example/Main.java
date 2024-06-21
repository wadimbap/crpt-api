package org.example;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        CrptApi.Document.Description description = new CrptApi.Document.Description("string");
        CrptApi.Document.Product product = new CrptApi.Document.Product("string", "2020-01-23", "string", "string", "string", "2020-01-23", "string", "string", "string");
        CrptApi.Document.Product[] products = {product};
        CrptApi.Document document = new CrptApi.Document(description, "string", "string", "LP_INTRODUCE_GOODS", true, "string", "string", "string", "2020-01-23", "string", products, "2020-01-23", "string");

        CrptApi api = new CrptApi(TimeUnit.SECONDS, 5);
        try {
            api.createDocument(document, "signature");
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}