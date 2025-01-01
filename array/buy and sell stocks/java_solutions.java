
class Solution {

    //1 ======== Basic method  ===============
    /*
        Concept:
        - Only apply "sell" after you "buy".
        - Track the minimum price so far and calculate the potential profit at each step.
        
        Complexity:
        - Time: O(n)
        - Space: O(1)
    */
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE; // Minimum price to buy
        int maxProfit = 0; // Maximum profit so far
        
        for (int price : prices) {
            buy = Math.min(buy, price); // Update the minimum price
            maxProfit = Math.max(maxProfit, price - buy); // Calculate the maximum profit
        }
        
        return maxProfit;
    }

}
