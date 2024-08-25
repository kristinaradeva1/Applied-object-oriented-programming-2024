package test;

import functions.Tabulate;
import services.Computable;

public class TabulateTest {
    public static void main(String[] args) {
        Tabulate tabulate = new Tabulate(null);
        tabulate.tabulate(0, 90, 5);

        Tabulate.tabulateFunction(1, 10, 10, new Computable() {
            @Override
            public double function(double x) {
                return x * x - 5;
            }
        });
    }
}