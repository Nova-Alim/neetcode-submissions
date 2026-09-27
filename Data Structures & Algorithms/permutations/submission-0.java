class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> current = new ArrayList<>();

        boolean[] used= new boolean[nums.length];

        recursion(nums,used,result,current);

        return result;
        
    }

     private void recursion(
        int[] nums,
        boolean[] used,
        List<List<Integer>> result,
        List<Integer> current
    ){
        if(current.size()==nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=0; i<nums.length;i++){
            if(used[i]== true){
                continue;
            }

            current.add(nums[i]);
            used[i]= true;

            recursion(nums,used,result,current);

            current.remove(current.size()-1);
            used[i]=false;
        }

    }
}
