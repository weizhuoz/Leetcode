34. Find First and Last Position of Element in Sorted Array
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length == 0){
            return new int[]{-1,-1};
        }
        int firstPos = -1;
        int secondPos = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = (end - start)/2 + start;
            if(nums[mid] >= target){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(nums[start] == target){
            firstPos = start;
        }else if(nums[end] == target){
            firstPos = end;
        }
        
        start = 0;
        end = nums.length - 1;
        
        while(start + 1 < end){
            int mid = (end - start)/2 + start;
            if(nums[mid] <= target){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(nums[end] == target){
            secondPos = end;
        }else if(nums[start] == target){
            secondPos = start;
        }
        return new int[]{firstPos,secondPos};
    }
}