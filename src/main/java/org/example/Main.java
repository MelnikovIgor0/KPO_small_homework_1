package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final Matrix A = new Matrix(new ArrayList(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(5, -2)),
                        new ArrayList<>(Arrays.asList(-3, 1))
                )
        ));

        final Matrix B = new Matrix(new ArrayList(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(4, 3)),
                        new ArrayList<>(Arrays.asList(-2, 2))
                )
        ));

        System.out.println(A.multiply(B));
    }
}