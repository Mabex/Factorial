package com.synclab.internship;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.logging.Logger;

@Path("/factorial")
@ApplicationScoped
public class FactorialRestController {

    FactorialService factorialService;
    private static Logger log = Logger.getLogger(FactorialRestController.class.getName());

    @Inject
    public FactorialRestController(FactorialService factorialService) {
        this.factorialService = factorialService;
    }

    @Path("/{number}")
    @GET
    public String getFactorial(@PathParam("number") int number) {

        Instant start = Instant.now();
        factorialService.factorial(number);

        //log.info("OK: " + number + " after " + Duration.between(start, Instant.now()).toMillis() + " ms");
        return number + " after " + Duration.between(start, Instant.now()).toMillis() + " ms";
    }
}
