class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> current = new ArrayList<>();
        

            backtrack(0, target, nums,current, result);

        return result;
    }

    private void backtrack(
        int index, int remaining, int[] nums, List<Integer> current, List<List<Integer>> result) {
            if(remaining==0){
                result.add(new ArrayList<>(current));
                return;
            }

            for(int i=index; i<nums.length; i++){

                if(nums[i] > remaining){
                    continue;
                }

                current.add(nums[i]);

                 backtrack(
                i,
                remaining - nums[i],
                nums,
                current,
                result
            );

           
            current.remove(current.size() - 1);

            }


        }
}
