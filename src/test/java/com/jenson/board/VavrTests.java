package com.jenson.board;

import io.vavr.control.Option;
import io.vavr.control.Try;
import org.junit.Test;
import scala.Function5;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VavrTests {

    @Test
    public void option_null_test() {
        String name = null;
        Option<String> nameOption = Option.of(name);

        System.out.println("nameOption = " + nameOption);
        assertEquals("pay", nameOption.getOrElse("pay"));
    }

    @Test(expected = NullPointerException.class)
    public void optional_null_test() {
        String name = null;
        Optional<String> nameOptional = Optional.of(name);

        System.out.println("nameOptional = " + nameOptional);
        assertEquals("pay", nameOptional.orElse("pay"));
    }

    @Test
    public void try_test() {
        Try<Integer> result = Try.of(() -> 1/0);
        assertTrue(result.isFailure());
    }

    @Test
    public void try_advance_test() {
        Try<Integer> result = Try.of(() -> 1/0);
        int errorValue = result.getOrElse(-1);
        assertEquals(-1, errorValue);
    }

    @Test
    public void function_test() {
        Function<Integer, Integer> square = (num) -> num * num;
        int result = square.apply(2);

        assertEquals(4, result);
    }

    @Test
    public void bi_function_test() {
        BiFunction<Integer, Integer, Integer> sum = (num1, num2) -> num1 + num2;
        int result = sum.apply(5, 7);

        assertEquals(12, result);
    }

    
}
