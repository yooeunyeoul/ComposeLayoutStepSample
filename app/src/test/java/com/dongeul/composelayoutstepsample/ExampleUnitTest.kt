package com.dongeul.composelayoutstepsample

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


    fun factorial(n:Int, acc:Int):Int{
        return if (n <= 0) {
            acc
        } else {
            factorial(n-1,n*acc)
        }
    }

    @Test
    fun factorialTest(){
        factorial(10, 1)
    }

}