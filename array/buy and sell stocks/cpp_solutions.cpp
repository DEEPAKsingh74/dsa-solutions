#include <bits/stdc++.h>

using namespace std;

//1 ==========  Basic method  =========

/*
	//5 ======= Concept  ==========
	1. Only apply sell after you buy it.

	//5 ====== Complexity  =======
	Time: O(n)
	space: O(1)

*/

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int buy = INT_MAX;
        int ans = -1;
        for(int i = 0; i < prices.size(); i++){

            buy = min(buy, prices[i]);

            ans = max(ans, prices[i] - buy);
        }

        return ans;
    }
};