
//1 ================  Using Difference Array  ===============

/*
	//5 ====  Concept  ======
	1. Finding the difference array :
		a. [l, r, x] => arr[l] = x, arr[r+1] = -x;
		b. find the cumulative sum of the arr after the above.
	2. after that apply the new array sum found to the string.


*/


class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int sn = s.length();
        int[] cumulativeArr = new int[sn];
        StringBuilder ans = new StringBuilder();

        // Populate the difference array
        for (int[] q : shifts) {
            int l = q[0];
            int r = q[1];
            int sh = (q[2] == 0) ? -1 : 1;

            cumulativeArr[l] += sh;
            if (r + 1 < sn) cumulativeArr[r + 1] -= sh;
        }

        // Calculate the cumulative sum and build the result
        for (int i = 0; i < sn; i++) {
            if (i != 0) cumulativeArr[i] += cumulativeArr[i - 1];

            // Calculate the new character after applying shifts
            int newChar = (s.charAt(i) - 'a' + cumulativeArr[i]) % 26;
            if (newChar < 0) newChar += 26;

            ans.append((char) ('a' + newChar));
        }

        return ans.toString();
    }
}
