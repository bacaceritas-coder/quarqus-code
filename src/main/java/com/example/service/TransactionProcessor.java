package com.example.service;

import com.example.model.Transaction;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import io.smallrye.reactive.messaging.kafka.Record;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

@ApplicationScoped
public class TransactionProcessor {


    @Inject
    TransactionService service;

    @Incoming("input-topic")
    @Outgoing("output-topic")
    public Record<String, String> consumeAndProduce(Record<String, String> record) {
        String message = record.value();
        System.out.println("Received message: " + message);

        Transaction tx = service.process(message);
        if (tx == null) return null;

        // Ubah menjadi JSON-like string untuk dikirim ke Kafka
        String output = String.format(
                "{\"product\":\"%s\",\"quantity\":%d,\"price\":%d,\"total\":%d}",
                tx.product, tx.quantity, tx.price, tx.total
        );

        System.out.println("Processed & sending to output-topic: " + output);

        // Return message baru ke output-topic
        return Record.of(record.key(), output);

    }
}
