class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> current= new ArrayList<>();
      Arrays.sort(candidates);

        backtrack(0, target, candidates, current, result);

        return result;
    }

    private void backtrack(
        int start,
        int remaining,
        int[] candidates,
        List<Integer> current,
        List<List<Integer>> result
    ) {

        // We found a valid combination
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // Skip duplicate choices at the SAME level
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Since the array is sorted, everything after this is too big
            if (candidates[i] > remaining) {
                break;
            }

            // CHOOSE
            current.add(candidates[i]);

            // EXPLORE
            // i + 1 because each element can only be used once
            backtrack(
                i + 1,
                remaining - candidates[i],
                candidates,
                current,
                result
            );

            // UNDO
            current.remove(current.size() - 1);
        }
    }
}