package com.synclab.internship.SpringBootFactorial;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class FactorialService {

    //private final ReentrantLock reentrantLock = new ReentrantLock(true);

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
}
