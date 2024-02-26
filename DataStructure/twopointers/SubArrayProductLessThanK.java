package TwoPointers;

public class SubArrayProductLessThanK {
    public static int subArrayProductLessThanK(int[] nums, int k){
        int left = 0;
        int right = 0;
        int count = 0;
        int product = 1;
        while(right < nums.length){
            product *= nums[right];
            while(product >= k && left < right){
                product /= nums[left];
                left += 1;
            }
            if(product < k){
                count += (right-left +1);
            }
            right += 1;

        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        int k = 100;
        int count = subArrayProductLessThanK(nums, k);
        System.out.println(count);
    }
}
