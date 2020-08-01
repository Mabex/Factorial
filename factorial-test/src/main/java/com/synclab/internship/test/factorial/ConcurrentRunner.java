package com.synclab.internship.test.factorial;

import com.fasterxml.jackson.databind.JsonNode;
import com.synclab.internship.test.factorial.service.ServiceCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class ConcurrentRunner {

    private ServiceCaller serviceCaller;

    @Autowired
    ConcurrentRunner(ServiceCaller serviceCaller, Environment env) {
        this.serviceCaller = serviceCaller;
    }

    public void factorial(int requests, int factorial) throws Exception {
        Instant start = Instant.now();
        List<CompletableFuture<String>> allFutures = new ArrayList<>();

        for (int i = 0; i < requests; i++) {
            // Add i to change factorial each time - deactivated for now
            allFutures.add(serviceCaller.callOtherService(Integer.toString(factorial)));
        }

        // Await completion of a set of independent CompletableFutures
        CompletableFuture.allOf(allFutures.toArray(new CompletableFuture[0])).join();

        // Just a check, remember to comment
        /*for (int i = 0; i < requests; i++) {
            System.out.println("Response: " + allFutures.get(i).get());
        }*/

        System.out.println("Total time: " + Duration.between(start, Instant.now()).toMillis() + "ms");
    }
}
