// https://leetcode.com/problems/build-array-from-permutation/

public class BuildArrayFromPermutation {
    public int[] buildArray(int[] nums) {
        
        int n = nums.length;
        for(int i=0; i<n; i++){
            nums[i] = nums[i] + (nums[nums[i]] % n) * n;
        }
        for(int i=0; i<n; i++){
            nums[i] = nums[i] / n;
        }
        
        return nums;
    }
}
