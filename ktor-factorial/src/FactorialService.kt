package com.synclab.internship

import java.math.BigInteger

class FactorialService {

    fun factorial(number: Int?): BigInteger? {
        if (number != null) {
            var result = BigInteger("1")
            for (i in number downTo 2) {
                result = result.multiply(BigInteger.valueOf(i.toLong()))
            }
            return result
        }
        return null
    }
}