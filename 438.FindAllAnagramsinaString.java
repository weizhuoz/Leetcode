438. Find All Anagrams in a String
https://leetcode.com/problems/find-all-anagrams-in-a-string/
https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s== null || p==null || s.length()<p.length()){
            return res;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<p.length();i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int left = 0;
        int right = 0;
        int counter = map.size();
        while(right<s.length()){
            char cur = s.charAt(right);
            if(map.containsKey(cur)){
                 map.put(cur, map.get(cur)-1);
                 if(map.get(cur)==0){
                     counter--;
                 }
            }
            right++;
            while(counter==0){
                char b = s.charAt(left);
                if(map.containsKey(b)){
                    map.put(b,map.get(b)+1);
                    if(map.get(b)>0){
                        counter++;
                    }
                }
                if(right-left==p.length()){
                    res.add(left);
                }
                left++;
            }
       }
        return res;
    }
}