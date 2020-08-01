package com.synclab.internship;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.logging.Logger;

@Path("/factorial")
@ApplicationScoped
public class FactorialRestController {

    private final FactorialService factorialService;
    private static Logger log = Logger.getLogger(FactorialRestController.class.getName());

    @Inject // Inject annotation is optional while using ApplicationScoped
    public FactorialRestController(FactorialService factorialService) {
        this.factorialService = factorialService;
    }

    @GET
    @Path("/{number}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getFactorial(@PathParam int number) {

        Instant start = Instant.now();
        factorialService.factorial(number);

        //log.info("OK: " + number + " after " + Duration.between(start, Instant.now()).toMillis() + " ms");
        return number + " after " + Duration.between(start, Instant.now()).toMillis() + " ms";
    }
}