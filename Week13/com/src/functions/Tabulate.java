package functions;

import services.Computable;

import java.util.Scanner;

public class Tabulate {
    private Computable callBack;

    public Tabulate(Computable callBack) {
       setCallBack(callBack);
    }

    public Computable getCallBack() {
        return callBack;
    }

    public void setCallBack(Computable callBack) {
        if(callBack != null) {
            this.callBack = callBack;
        }else{
            this.callBack = new Functions().getSinFunction();
        }
    }
    public void tabulate( double a, double b, int steps) {
        tabulateFunction(a, b, steps, callBack);
    }

    public static void tabulateFunction( double a, double b, int steps, Computable computable) {
        if(computable == null) {
            System.out.println("Computable can't be null");
            return;
        }

        if(a >= b) {
            System.out.println("a can't be more than or equal to b");
        }
        if(steps <= 0){
            System.out.println("Intervals can't be less than 0");
            return;
        }
        Scanner input = new Scanner(System.in);
        int size = ((int) (b - a)) / steps;
        double x;

        System.out.printf("-15s%-15s\n", "X", "F(X)");
        for(int i = 0; i <= steps; i++) {
            x = a + steps * i;
            System.out.printf("%-3.2f%-3.2f\n", x, computable.function(x));
            if(i % 20 == 19){
                System.out.println("Please Enter to continue");
                input.nextLine();
            }
        }
    }
}
