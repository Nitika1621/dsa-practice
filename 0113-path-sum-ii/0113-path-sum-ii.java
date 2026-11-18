
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        solve(root, targetSum, path, ans);

        return ans;
    }

    public void solve(TreeNode root, int targetSum,
                      List<Integer> path, List<List<Integer>> ans) {

        if (root == null) {
            return;
        }

        path.add(root.val);
        targetSum -= root.val;

        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                ans.add(new ArrayList<>(path));
            }
        }

        solve(root.left, targetSum, path, ans);
        solve(root.right, targetSum, path, ans);

        path.remove(path.size() - 1);
    }
}
