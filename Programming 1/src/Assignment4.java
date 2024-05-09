import java.util.*;

public class Assignment4 {

    public double calculateAveragePrice(int[] arr) {
        double total = 0;
        // looping through to process the array finding the sum
        for(int price: arr) {
            total += price;
        }
        return (total / arr.length);
    }

    public int findMaximumPrice(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }

    public int countOccurences(int[] arr, int targetPrice) {
        int count = 0;

        for(int price: arr) {
            if(price == targetPrice){
                count++;
            }
        }
        return count;
    }

    public ArrayList<Integer> computeCumulativeSum(ArrayList<Integer> stockList) {
        for(int i = 1; i < stockList.size(); i++) {
            // summing current value with previous value exluding first element
            int curr = stockList.get(i);
            int prev = stockList.get(i - 1);
            int sum = curr + prev;
            stockList.set(i, sum);
        }

        return stockList;
    }

    public static void main(String[] args) {
        Assignment4 market = new Assignment4();
        
        int[] stockPricesArray = {182, 151, 132, 178, 132, 195, 147, 132, 169, 151};
        ArrayList<Integer> stockPricesList = new ArrayList<Integer>();

        // Add hardcoded prices to ArrayList
        for (int price : stockPricesArray) {
            stockPricesList.add(price);
        }

        System.out.println("Average stock price: " + market.calculateAveragePrice(stockPricesArray));
        System.out.println("Maximum stock price: " + market.findMaximumPrice(stockPricesArray));
        System.out.println("Frequency of stock price 132: " + market.countOccurences(stockPricesArray, 132));

        System.out.print("Cumulative stock prices: \n[");
        ArrayList<Integer> cumList = market.computeCumulativeSum(stockPricesList);
        for (int i = 0; i < cumList.size(); i++) {
            if(i > 0){
                System.out.print(",");
            }
            System.out.print(cumList.get(i));
        }
        System.out.println("]");
    }
}