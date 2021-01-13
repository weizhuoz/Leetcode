752. Open the Lock
https://leetcode.com/problems/open-the-lock/
class Solution {
    public int openLock(String[] deadends, String target) {
        
        Set<String> visited = new HashSet<>();
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        String start = "0000";
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        int step = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String current = queue.poll();
                if(deadSet.contains(current)){
                    continue;
                }
                if(target.equals(current)){
                    return step;
                }
                List<String> nextSteps = getNextStatus(current);
                for(String next : nextSteps){
                    if(visited.contains(next) || deadSet.contains(next)){
                        continue;
                    }
                    queue.offer(next);
                    visited.add(next);
                }
            }
            step++;
        }
        return -1;
    }
    private List<String> getNextStatus(String current){
        List<String> nextSteps = new ArrayList<>();
        for(int i=0;i<current.length();i++){
            int curNum = current.charAt(i) - '0';
            String nextAddOne = current.substring(0,i) + String.valueOf((10+curNum+1)%10) + current.substring(i+1);
            String nextMinusOne = current.substring(0,i) + String.valueOf((10+curNum-1)%10) + current.substring(i+1);
            nextSteps.add(nextAddOne);
            nextSteps.add(nextMinusOne);
        }
        return nextSteps;
    }
    
}