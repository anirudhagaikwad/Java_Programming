package greedyAlgorithms;
/*
Greedy algorithms are algorithms that make locally optimal choices at each step with the hope of finding a global optimum.  
*/
public class GreedyAlgorithm {
    public static void main(String[] args) {
        int amount = 73; // amount for which to make change
        int[] denominations = {25, 10, 5, 1}; // available coin denominations
        int numCoins = minCoins(amount, denominations);
        System.out.println("Minimum number of coins required: " + numCoins);
    }

/*
Consider the problem of finding the minimum number of coins required to make change for a given amount. Let's assume we have an unlimited supply of coins of denominations 1, 5, 10, 25 cents.

Here's the implementation of the greedy algorithm for this problem:    
*/
    public static int minCoins(int amount, int[] denominations) {
        int numCoins = 0;
        for (int denomination : denominations) {
            numCoins += amount / denomination;
            amount %= denomination;
            if (amount == 0) {
                break;
            }
        }
        return numCoins;
    }
}

/*
In this implementation, we start with the largest denomination (25 cents) and greedily use as many coins of that denomination as possible until we can't use any more. Then we move on to the next largest denomination (10 cents) and repeat the process until we have used enough coins to make change for the given amount.

The denominations array stores the available coin denominations in descending order, which allows us to start with the largest denomination first.

The numCoins variable keeps track of the number of coins used so far, while the amount variable keeps track of the remaining amount to be changed.

The amount / denomination expression calculates the maximum number of coins of the current denomination that can be used, while the amount %= denomination expression updates the amount variable to reflect the remaining amount after using as many coins of the current denomination as possible.

The if (amount == 0) statement checks if we have made change for the full amount and breaks out of the loop if we have.

This implementation is an example of a greedy algorithm because at each step we make the locally optimal choice of using as many coins of the current denomination as possible, with the hope of finding the globally optimal solution of using the minimum number of coins overall.
*/