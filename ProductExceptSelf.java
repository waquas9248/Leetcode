//Neetcode - 150

class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] leftProd = new int[nums.length];

        int prod = 1;

        for(int i = 0; i < nums.length; i++){
            leftProd[i] = prod;
            prod *= nums[i];
        }

        System.out.println(Arrays.toString(leftProd));
        prod = 1;

        for(int i = nums.length-1 ; i >= 0 ; i--){
            int temp = prod*nums[i];
            nums[i] = prod*leftProd[i];
            prod = temp;
        }

        return nums;
        
    }
}  
