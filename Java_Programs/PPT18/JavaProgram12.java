package PPT18;
/*
Given the following three values, the task is to find the total number of maximum chocolates you can eat.

money: Money you have to buy chocolates
price: Price of a chocolate
wrap: Number of wrappers to be returned for getting one extra chocolate.

Example:
Input: money = 16, price = 2, wrap = 2
Output:   15
Price of a chocolate is 2. You can buy 8 chocolates from
amount 16. You can return 8 wrappers back and get 4 more
chocolates. Then you can return 4 wrappers and get 2 more
chocolates. Finally you can return 2 wrappers to get 1
more chocolate.
*/


import java.io.*;

class JavaProgram12 {

    // Returns number of chocolates we can  have from given number of chocolates
    // and number of wrappers required to get a chocolate.
    static int countRec(int choc, int wrap)
    {

        // If number of chocolates is less than  number of wrappers required.
        if (choc < wrap)
            return 0;

        // We can immediately get newChoc using  wrappers of choc.
        int newChoc = choc / wrap;

        // Now we have "newChoc + choc%wrap" wrappers.
        return newChoc + countRec(newChoc +
                choc % wrap, wrap);
    }

    // Returns maximum number of chocolates we can eat with given money, price of
    // chocolate and number of wrappers  required to get a chocolate.
    static int countMaxChoco(int money,
                             int price, int wrap)
    {

        // We can directly buy below number of chocolates
        int choc = money/price;

        // countRec returns number of chocolates we can have from given number of  chocolates
        return choc + countRec(choc, wrap);
    }


    public static void main (String[] args)
    {
        int money = 15 ; // total money
        int price = 1; // cost of each candy

        // no of wrappers needs to be  exchanged for one chocolate.
        int wrap = 3 ;
        System.out.println(
                countMaxChoco(money, price, wrap));
    }
}
