class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        Arrays.sort(nums);

        backtrack(0, nums, current, result);

        return result;
    }

    private void backtrack(
        int start,
        int[] nums,
        List<Integer> current,
        List<List<Integer>> result
    ) {

        // Every current subset is valid
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {

            // Skip duplicate choices at the same level
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // Choose
            current.add(nums[i]);

            // Explore
            // i + 1 because each array element is used at most once
            backtrack(i + 1, nums, current, result);

            // Undo
            current.remove(current.size() - 1);
        }
    }
}