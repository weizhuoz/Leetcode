76. Minimum Window Substring
https://leetcode.com/problems/minimum-window-substring/
class Solution {
    public String minWindow(String s, String t) {
        if(s==null || t==null || t.length()>s.length()){
            return "";
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++){
            char temp = t.charAt(i);
            map.put(temp,map.getOrDefault(temp,0)+1);
        }
        int left = 0;
        int right = 0;
        int counter = map.size();;
        int head = 0;
        int minLength = Integer.MAX_VALUE;
        while(right < s.length()){
            char cur = s.charAt(right);
            if(map.containsKey(cur)){
                map.put(cur, map.get(cur)-1);
                if(map.get(cur)==0){
                    counter--;
                }
            }
            right++;
            while(counter==0){
                char tmp = s.charAt(left);
                if(map.containsKey(tmp)){
                    map.put(tmp,map.get(tmp)+1);
                    if(map.get(tmp)>0){
                        counter++;
                    }
                }
                if(right-left < minLength){
                    minLength = right-left;
                    head = left;
                }
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(head,head+minLength);        
    }
}