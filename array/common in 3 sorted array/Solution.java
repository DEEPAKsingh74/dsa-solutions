import java.util.*;

//1 ==============  Using 3 pointers approach  ==============


/*
	//5 ==== Concept 
	1. keep three pointers at start of each array and as the arr are sorted move the pointers with smallest value when all three values dont match.
	2. handle duplicates also.

	//5 =======  complexity
	Time: O(n)
	space: O(n)

*/


public class Solution {
    // Function to find common elements in three arrays.
    public List<Integer> commonElements(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> ans = new ArrayList<>();
        
        int i = 0, j = 0, k = 0;
        int ni = arr1.length, nj = arr2.length, nk = arr3.length;
        
        while (i < ni && j < nj && k < nk) {
            if (arr1[i] == arr2[j] && arr1[i] == arr3[k] && (ans.isEmpty() || ans.get(ans.size() - 1) != arr1[i])) {
                ans.add(arr1[i]);
                i++;
                j++;
                k++;
            } else {
                int mini = Math.min(Math.min(arr1[i], arr2[j]), arr3[k]);
                if (arr1[i] == mini) i++;
                else if (arr2[j] == mini) j++;
                else k++;
            }
        }
        
        return ans;
    }
}
