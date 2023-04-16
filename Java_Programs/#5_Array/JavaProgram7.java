package PPT5;
/*
The cost of a stock on each day is given in an array. Find the maximum profit that you can make by buying and selling on those days. If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.

Examples:

Input: arr[] = {100, 180, 260, 310, 40, 535, 695}
Output: 865
Explanation: Buy the stock on day 0 and sell it on day 3 => 310 – 100 = 210
                       Buy the stock on day 4 and sell it on day 6 => 695 – 40 = 655
                       Maximum Profit  = 210 + 655 = 865

Input: arr[] = {4, 2, 2, 2, 4}
Output: 2
Explanation: Buy the stock on day 1 and sell it on day 4 => 4 – 2 = 2
                       Maximum Profit  = 2
*/

import java.util.*;

class JavaProgram7 {

    // Function to return the maximum profit
    // that can be made after buying and
    // selling the given stocks
    static int maxProfit(int price[], int start, int end)
    {

        // If the stocks can't be bought
        if (end <= start)
            return 0;

        // Initialise the profit
        int profit = 0;

        // The day at which the stock
        // must be bought
        for (int i = start; i < end; i++) {

            // The day at which the
            // stock must be sold
            for (int j = i + 1; j <= end; j++) {

                // If buying the stock at ith day and
                // selling it at jth day is profitable
                if (price[j] > price[i]) {

                    // Update the current profit
                    int curr_profit
                            = price[j] - price[i]
                            + maxProfit(price, start, i - 1)
                            + maxProfit(price, j + 1, end);

                    // Update the maximum profit so far
                    profit = Math.max(profit, curr_profit);
                }
            }
        }
        return profit;
    }


    public static void main(String[] args)
    {
        int price[] = { 100, 180, 260, 310, 40, 535, 695 };
        int n = price.length;

        System.out.print(maxProfit(price, 0, n - 1));
    }
}


