package com.synclab.internship;

import javax.inject.Singleton;
import java.math.BigInteger;
import java.util.concurrent.locks.ReentrantLock;

@Singleton
public class FactorialService {

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
}
