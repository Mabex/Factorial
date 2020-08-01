package com.synclab.internship.SpringBootFactorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Logger;

@RestController
public class FactorialRestController {

    private final FactorialService factorialService;
    private static Logger log = Logger.getLogger(FactorialRestController.class.getName());

    @Autowired
    FactorialRestController(FactorialService factorialService) {
        this.factorialService = factorialService;
    }

    @GetMapping("/factorial/{number}")
    public String getFactorial(@PathVariable("number") int number) {

        Instant start = Instant.now();

        factorialService.factorial(number);

        //log.info("OK: " + number + " after " + Duration.between(start, Instant.now()).toMillis() + " ms");
        return number + " after " + Duration.between(start, Instant.now()).toMillis() + " ms";
    }
}
