// https://leetcode.com/problems/move-zeroes/


public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int j = 0;
        
        for(int i=0; i< nums.length; i++){
            
            if(nums[i] == 0)
                continue;
            else{
                nums[j] = nums[i];
                j++;
            }
        }
        
        while(j<nums.length){
            nums[j] = 0;
            j++;
        }        
        
    }
}
