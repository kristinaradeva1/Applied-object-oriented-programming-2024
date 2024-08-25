package stocks;

import java.util.Scanner;

public class StockTest {

    public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter symbol: ");
            String symbol = input.next();
            System.out.print("Enter name: ");
            String name = input.next();
            System.out.print("Enter previousClosingPrice: ");
            double previousClosingPrice = input.nextDouble();
            System.out.print("Enter currentPrice: ");
            double currentPrice = input.nextDouble();
            Stock stock1 = new Stock(symbol, name);
            stock1.setCurrentPrice(currentPrice);
            stock1.setPreviousClosingPrice(previousClosingPrice);
            System.out.println("Percentage of change of stock: " + stock1.changePercent());
    }
}
