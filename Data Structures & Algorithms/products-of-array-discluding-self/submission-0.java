class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod =1;
        int[] res = nums.clone();
        for(int i=0;i<nums.length;i++){
            prod = prod*nums[i];
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                int prd =1;
                for(int j=0;j<nums.length;j++){
                                            System.out.println("nums[j] is "+nums[j]);

                    System.out.println("i and j right now "+i+" "+j);
                    if(j!=i){
                        System.out.println(i+" and "+j+" are not equal");
                        //System.out.println("nums[j] is "+nums[j]);
                        prd = prd*nums[j];
                        System.out.println("prd value rn "+prd);
                    }
                }
                System.out.println(prd);
                res[i]=prd;
            }
            else{
                if(prod==0){
                    res[i]=0;
                }
                else{
                res[i]=prod/nums[i];
                }
            }
        }
        return res;
    }
}  
