class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        double res = (double)0;
        
        int n = nums1.length + nums2.length;

        if( n == 0 )
            return (double)0;

        if( n % 2 == 1 )
        {
            int index = n / 2; 

            int i = 0;
            int j = 0;
            int count = -1;

            while(i < nums1.length && j < nums2.length ){
                
                count++;

                if(nums1[i] < nums2[j])
                {
                
                    if(count == index)
                        return nums1[i];
                    i++;
                    
                }else if(nums1[i] > nums2[j]){
                    
                    if(count == index)
                        return nums2[j];
                    j++;

                }else{
                    
                    if(count == index)
                        return nums1[i];
                    i++;
                    count++;
                    if(count == index)
                        return nums1[i];
                    j++;
                }


            }if(i == nums1.length){


                while(j < nums2.length){
                     count++;

                     if(count == index)
                        return nums2[j];
                     
                     j++;

                }
            }else{
                while(i < nums1.length){
                     count++;

                     if(count == index)
                        return nums1[i];
                     
                     i++;

                }

            }





        }else{
            int index2 = n/2 ;
            int index1 = (n/2) - 1 ;

            int i = 0;
            int j = 0;
            int count = -1;

            while(i < nums1.length && j < nums2.length ){
                count++;

                if(nums1[i] < nums2[j])
                {
                
                    if(count == index1)
                    {
                        if( i != nums1.length - 1)
                        {
                            if(nums1[i+1] > nums2[j])
                                return ( (double)(nums1[i]) + (double)(nums2[j]) )/2;
                            else if(nums1[i+1] < nums2[j])
                                return ( (double)(nums1[i]) + (double)(nums1[i+1]) )/2;
                            else
                                return ( (double)(nums1[i]) + (double)(nums1[i+1]) )/2;

                        }
                        else{
                            return ( (double)(nums1[i]) + (double)(nums2[j]) )/2;
                        }


                    }
                    i++;
                    
                }else if(nums1[i] > nums2[j]){
                    
                    if(count == index1)
                    {
                        if( j != nums2.length - 1)
                        {
                            if(nums2[j+1] > nums1[i])
                                return ( (double)(nums1[i]) + (double)(nums2[j]) )/2;
                            else if(nums2[j+1] < nums1[i])
                                return ( (double)(nums2[j]) + (double)(nums2[j+1]) )/2;
                            else
                                return ( (double)(nums2[j]) + (double)(nums2[j+1]) )/2;

                        }
                        else{
                            return ( (double)(nums1[i]) + (double)(nums2[j]) )/2;
                        }


                    }
                    j++;

                }else{
                    
                    if(count == index1)
                        return (double)(nums1[i]);
                    i++;
                    count++;
                    if(count == index1)
                    {
                        if(i != nums1.length && j+1 != nums2.length)
                        { 

                            if(nums1[i] > nums2[j+1] )
                                return ( (double)(nums2[j]) + (double)(nums2[j+1]) ) / 2;
                            else if(nums1[i] < nums2[j+1])
                                return ( (double)(nums2[j]) + (double)(nums1[i]) ) / 2;

                            else
                                return ( (double)(nums2[j]) + (double)(nums1[i]) ) / 2;
                        }else if( i == nums1.length ){
                             return  ( (double)(nums2[j]) + (double)(nums2[j+1]) ) / 2;
                        }
                        else{
                            return  ( (double)(nums2[j]) + (double)(nums1[i]) ) / 2;
                        }

                        
                           
                    }
                        
                    j++;
                }


            }if(i == nums1.length){

                while(j < nums2.length){
                    count++;
                    if(count == index1)
                        return ( (double)(nums2[j]) + (double)(nums2[j+1]) ) / 2;

                    j++;
                }


            }else{
                
                while(i < nums1.length){
                    count++;
                    if(count == index1)
                        return ( (double)(nums1[i]) + (double)(nums1[i+1]) ) / 2;

                    i++;
                }

            }


        }

    return res;

    }
}
