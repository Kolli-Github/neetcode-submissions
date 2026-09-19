class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int slength = 0;
        int glength=0;
        if(nums1.length<=nums2.length){
            slength = nums1.length;
            glength = nums2.length;
        }
        else{
            slength = nums2.length;
            glength = nums1.length;
        }

        int small[] = new int[slength];
        int greater[] = new int[glength];
        if(slength == nums1.length){
            small=nums1;
            greater = nums2;
        }
        else{
            small=nums2;
            greater=nums1;
        }

        int total = slength + glength;
        int half = total/2;

        int l =0;
        int r = slength-1;

        while(true){
            int i = (int)Math.floor((l + r) / 2.0);
            int j = half-i-2;
            double Sleft;
            double Sright;
            double Gleft;
            double Gright;
            if(i>=0){
                Sleft=small[i];
            }
            else{
                Sleft=Double.NEGATIVE_INFINITY;
            }

            if(i+1 < slength){
                Sright = small[i+1];
            }
            else{
                Sright = Double.POSITIVE_INFINITY;
            }

            if(j>=0){
                Gleft=greater[j];
            }
            else{
                Gleft=Double.NEGATIVE_INFINITY;
            }

            if(j+1 < glength){
                Gright = greater[j+1];
            }
            else{
                Gright = Double.POSITIVE_INFINITY;
            }

            if(Sleft<=Gright && Gleft<=Sright){
                if(total%2==1){
                   return Math.min(Sright, Gright);
                }
                else{
                    return (Math.max(Sleft,Gleft) + Math.min(Sright,Gright))/2;
                }
            }
            else if(Gleft>Sright){
                l=i+1;
            }
            else{
                r=i-1;
            }
        }

  
    }
}
