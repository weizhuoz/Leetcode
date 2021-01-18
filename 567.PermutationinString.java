567. Permutation in String
https://leetcode.com/problems/permutation-in-string/
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1==null || s2==null || s1.length()>s2.length()){
            return false;
        }
        int[] counter = new int[26];
        for(int i=0;i<s1.length();i++){
            counter[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<s2.length();i++){
            counter[s2.charAt(i)-'a']--;
            if(i>=s1.length()){
                counter[s2.charAt(i-s1.length())-'a']++;
            }
            if(allZero(counter)){
                return true;
            }
        }
        return false;
        
    }
    private boolean allZero(int[] counter){
        for(int i=0;i<counter.length;i++){
            if(counter[i]!=0){
                return false;
            }
        }
        return true;
    }
}