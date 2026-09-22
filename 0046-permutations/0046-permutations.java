import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(nums, new ArrayList<>(), ans);

        return ans;
    }

    void backtrack(int[] nums, List<Integer> current,
                   List<List<Integer>> ans) {

        // Base case
        if (current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // Try every number
        for (int i = 0; i < nums.length; i++) {

            // If already used, skip
            if (current.contains(nums[i])) {
                continue;
            }

            // Choose
            current.add(nums[i]);

            // Explore
            backtrack(nums, current, ans);

            // Undo
            current.remove(current.size() - 1);
        }
    }
}