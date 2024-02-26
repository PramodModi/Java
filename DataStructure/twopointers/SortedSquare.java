package TwoPointers;

public class SortedSquare {
    public static int[] sortedSquare(int[] nums){
        int left = 0;
        int right = nums.length-1;
        int[] result = new int[nums.length];
        int index = nums.length-1;
        while(left < right){
            int nl = nums[left] * nums[left];
            int nr = nums[right]* nums[right];
            if(nr >= nl){
                result[index] = nr;
                right -= 1;
            }
            else{
                result[index] = nl;
                left += 1;
            }
            index -= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] result = sortedSquare(nums);
        for(int n : result){
            System.out.println(n);
        }
    }
}
