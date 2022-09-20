package edu.touro.cs.mcon364;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testDuplicates() {
        assertEquals(1, MonteCarlo.numberOfDuplicates(Arrays.asList(1, 1, 2, 3)));
        assertEquals(0, MonteCarlo.numberOfDuplicates(List.of()));
        assertEquals(2, MonteCarlo.numberOfDuplicates(Arrays.asList(1, 1, 2, 2, 3, 4)));
    }

    @Test
    void test100() {
        assertEquals(1.0, MonteCarlo.monteCarlo(366));
        assertEquals(1.0, MonteCarlo.monteCarlo(367));
    }

    @Test
    void test50() {
        assertEquals(.5, MonteCarlo.monteCarlo(23), .03);
    }

    @Test
    void test99() {
        assertEquals(.999, MonteCarlo.monteCarlo(73), .0009);
    }

    @Test
    void test0() {
        assertEquals(0, MonteCarlo.monteCarlo(1));
        assertEquals(0, MonteCarlo.monteCarlo(0));
    }
}