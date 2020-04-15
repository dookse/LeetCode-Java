package explore.challenge30day.week3;

public class ProductofArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];
        answer[0] = 1;

        for (int i = 1; i < length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        int r = 1;
        for (int i = length - 1; i >= 0; i--) {
            answer[i] = answer[i] * r;
            r *= nums[i];
        }
        return answer;
    }

}
