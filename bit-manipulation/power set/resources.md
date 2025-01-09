# Links:

- [Geeks For Geeks](https://www.geeksforgeeks.org/problems/power-set4302/1/)

# Problem Statement :

Given a string s of length n, find all the possible non-empty subsequences of the string s in lexicographically-sorted order.

#### Examples :

Input : 
s = "abc"
Output: 
a ab abc ac b bc c
Explanation : 
There are a total 7 number of subsequences possible for the given string, and they are mentioned above in lexicographically sorted order.

Input: 
s = "aa"
Output: 
a a aa
Explanation : 
There are a total 3 number of subsequences possible for the given string, and they are mentioned above in lexicographically sorted order.

#### Constraints :

1 <= n <= 16
s constitutes of lower case english alphabets



## Related Problems :


### Optimized Solution Complexity

**_Time_** : O(n * 2^n)
**_Space_** : O(n * 2^n)