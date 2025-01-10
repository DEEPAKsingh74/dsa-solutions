#include <bits/stdc++.h>

using namespace std;

//1 ==========  Normally using map  ==========

/*
	//5 =====  Concept=========

	1. Just count the frequency and check if it is subset or not.

*/

class Solution {
public:
    bool isSubset(vector<int> &wf, vector<int> &fre2 ){
        for(int i = 0; i < 26; i++){
            if(wf[i] < fre2[i]){
                return false;
            }
        }

        return true;
    }

    vector<string> wordSubsets(vector<string>& words1, vector<string>& words2) {
        
        vector<string> result;

        vector<int> freq2(26, 0);
        for(string word: words2){
            vector<int> wf(26, 0);

            for(char l: word){
                wf[l-'a']++;

                freq2[l-'a'] = max(freq2[l-'a'], wf[l-'a']);
            }
        }

        for(string word: words1){
            vector<int> wf(26, 0);

            for(auto ch: word){
                wf[ch-'a']++;
            }

            if(isSubset(wf, freq2)){
                result.push_back(word);
            }
        }

        return result;
    }
};