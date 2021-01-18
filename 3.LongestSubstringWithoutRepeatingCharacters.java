3. Longest Substring Without Repeating Characters
https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0){return 0;}
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int counter = 0;
        int max= Integer.MIN_VALUE;
        while(right<s.length()){
            char cur = s.charAt(right);
            map.put(cur,map.getOrDefault(cur,0)+1);
            if(map.get(cur)>1){
                counter ++;
            }
            right++;
            while(counter>0){
                char c = s.charAt(left);
                if(map.get(c)>1){
                    counter--;
                }
                map.put(c,map.get(c)-1);
                left++;
            }
            max = Math.max(max, right-left);
        }
        return max;
    }
}