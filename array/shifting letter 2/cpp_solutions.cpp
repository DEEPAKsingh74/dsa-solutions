#include <bits/stdc++.h>

using namespace std;

//1 ================  Using Difference Array  ===============

/*
	//5 ====  Concept  ======
	1. Finding the difference array :
		a. [l, r, x] => arr[l] = x, arr[r+1] = -x;
		b. find the cumulative sum of the arr after the above.
	2. after that apply the new array sum found to the string.


*/

class Solution {
public:
    string shiftingLetters(string s, vector<vector<int>>& shifts) {
        int n = shifts.size();
        int sn = s.size();
        string ans;
        vector<int> cumulative_arr(sn, 0);

        for(auto q: shifts){
            int l = q[0];
            int r = q[1];
            int sh = (q[2] == 0) ? -1 : 1;
            
            cumulative_arr[l] += sh;
            if(r+1 < sn) cumulative_arr[r+1] -= sh;
        }

        for (int i = 0; i < sn; i++) {
            if(i != 0) cumulative_arr[i] += cumulative_arr[i-1];
            int new_char = (s[i] - 'a' + cumulative_arr[i]) % 26;
            if (new_char < 0) new_char += 26;
            ans += ('a' + new_char);
        }

        return ans;
    }
};