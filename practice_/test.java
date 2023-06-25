package practice_;


import java.util.*;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] n3=new int[nums1.length+nums2.length];
        float median = 0.0f;
        System.arraycopy(nums1,0,n3,0,nums1.length);
        System.arraycopy(nums2,0,n3,nums1.length,nums2.length);
        Arrays.sort(n3);
        System.out.println(Arrays.toString(n3));
        if(n3.length%2==1)median=n3[(n3.length-1)/2];
        else {
            int n1 = n3[n3.length/2-1];
            int n2 = n3[n3.length/2];
            median=(float)(n1+n2)/2;
        }
        return median;
    }
}
public class test {
    public static void main(String[] args) {

        Solution s= new Solution();
        System.out.println(        s.findMedianSortedArrays(new int[]{1, 4, 5, 6, 7,8},new int[]{4,5,6,7})
);
    }
}
