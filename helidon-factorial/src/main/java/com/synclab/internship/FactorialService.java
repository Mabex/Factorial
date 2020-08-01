package com.synclab.internship;

import io.helidon.webserver.Routing;
import io.helidon.webserver.Service;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigInteger;
import java.util.concurrent.locks.ReentrantLock;

@ApplicationScoped
public class FactorialService implements Service {

    //private static ReentrantLock reentrantLock = new ReentrantLock(true);

    public BigInteger factorial(int number) {
        //reentrantLock.lock();
        try {
            BigInteger result = new BigInteger("1");
            while (number > 1) {
                result = result.multiply(BigInteger.valueOf(number));
                number--;
            }
            return result;
        } finally {
            //reentrantLock.unlock();
        }
    }

    @Override
    public void update(Routing.Rules rules) {    }
}
