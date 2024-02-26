package TwoPointers;

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicatesFromSortedArray(int[] nums){
        int unique = 0;
        int index = 1;
        while(index < nums.length){
            if(nums[unique] != nums[index]){
                unique += 1;
                nums[unique] = nums[index];
            }
            index += 1;
        }
        return unique + 1;
    }
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int result =  removeDuplicatesFromSortedArray(nums);
        System.out.println(result);
    }
}
