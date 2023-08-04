import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> subarraySum(int[] arr, int N, int S) {
        ArrayList<Integer> result = new ArrayList<>();
        
        int left = 0;
        int right = 0;
        int currentSum = 0;
        
        while (right < N) {
            currentSum += arr[right];
            
            while (currentSum > S) {
                currentSum -= arr[left];
                left++;
            }
            
            if (currentSum == S) {
                result.add(left + 1);  // Adjusting for 1-based indexing
                result.add(right + 1); // Adjusting for 1-based indexing
                return result;
            }
            
            right++;
        }
        
        result.add(-1);
        return result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] arr1 = {1, 2, 3, 7, 5};
        int N1 = 5;
        int S1 = 12;
        System.out.println(solution.subarraySum(arr1, N1, S1)); // Output: [2, 4]
        
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int N2 = 10;
        int S2 = 15;
        System.out.println(solution.subarraySum(arr2, N2, S2)); // Output: [1, 5]
    }
}

