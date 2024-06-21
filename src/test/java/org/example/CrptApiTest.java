package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@ExtendWith(MockitoExtension.class)
class CrptApiTest {

    private CrptApi api;

    @BeforeEach
    void setUp() {
        api = new CrptApi(TimeUnit.SECONDS, 5);
    }

    @Test
    void testCreateDocumentWithinLimit() {
        CrptApi.Document.Description description = new CrptApi.Document.Description("string");
        CrptApi.Document.Product product = new CrptApi.Document.Product(
                "string",
                "2020-01-23",
                "string",
                "string",
                "string",
                "2020-01-23",
                "string",
                "string",
                "string"
        );
        CrptApi.Document.Product[] products = {product};
        CrptApi.Document document = new CrptApi.Document(
                description, "string",
                "string",
                "LP_INTRODUCE_GOODS",
                true,
                "string",
                "string",
                "string",
                "2020-01-23",
                "string",
                products,
                "2020-01-23",
                "string"
        );

        assertDoesNotThrow(() -> api.createDocument(document, "signature"));
    }

    @Test
    void testCreateDocumentExceedingLimit() throws InterruptedException, IOException {
        CrptApi.Document.Description description = new CrptApi.Document.Description("string");
        CrptApi.Document.Product product = new CrptApi.Document.Product(
                "string",
                "2020-01-23",
                "string",
                "string",
                "string",
                "2020-01-23",
                "string",
                "string",
                "string"
        );
        CrptApi.Document.Product[] products = {product};
        CrptApi.Document document = new CrptApi.Document(description,
                "string",
                "string",
                "LP_INTRODUCE_GOODS",
                true,
                "string",
                "string",
                "string",
                "2020-01-23",
                "string",
                products,
                "2020-01-23",
                "string"
        );

        for (int i = 0; i < 10; i++) {
            api.createDocument(document, "signature");
        }

        assertTrue(true);
    }
}
