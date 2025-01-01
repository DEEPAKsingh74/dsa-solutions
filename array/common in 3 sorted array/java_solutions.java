import java.util.*;



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
