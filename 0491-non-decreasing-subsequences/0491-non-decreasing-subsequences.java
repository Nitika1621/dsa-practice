import java.util.*;

class Solution {

    public List<List<Integer>> findSubsequences(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(nums, 0, new ArrayList<>(), ans);

        return ans;
    }

    void backtrack(int[] nums, int start,
                   List<Integer> current,
                   List<List<Integer>> ans) {

        if (current.size() >= 2) {
            ans.add(new ArrayList<>(current));
        }

        Set<Integer> used = new HashSet<>();

        for (int i = start; i < nums.length; i++) {

            if (used.contains(nums[i])) {
                continue;
            }

            if (!current.isEmpty() &&
                nums[i] < current.get(current.size() - 1)) {
                continue;
            }

            used.add(nums[i]);

            current.add(nums[i]);

            backtrack(nums, i + 1, current, ans);

            current.remove(current.size() - 1);
        }
    }
}