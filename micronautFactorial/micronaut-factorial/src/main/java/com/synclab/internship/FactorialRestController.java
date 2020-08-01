package com.synclab.internship;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

import javax.inject.Inject;
import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.logging.Logger;

@Controller("/factorial")
public class FactorialRestController {

    FactorialService factorialService;
    private static Logger log = Logger.getLogger(FactorialRestController.class.getName());

    @Inject
    public FactorialRestController(FactorialService factorialService) {
        this.factorialService = factorialService;
    }

    @Get("/{number}")
    public String getFactorial(@PathVariable int number) {

        Instant start = Instant.now();
        factorialService.factorial(number);

        //log.info("OK: " + number + " after " + Duration.between(start, Instant.now()).toMillis() + " ms");
        return number + " after " + Duration.between(start, Instant.now()).toMillis() + " ms";
    }
}
