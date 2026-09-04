class Solution {
    public int longestConsecutive(int[] nums) {
        

        Set<Integer> seen= new HashSet<>();

        if(nums.length==0){
            return 0;
        }

        for(int num: nums){
            seen.add(num);
        }

        
        int maxLength=1;

        for(int num: seen){
            int counter=1;
            int current= num;

            if(!seen.contains(num-1)){
                

                while(seen.contains(current+1)){
                    current++;
                    counter++;
                }

                maxLength=Math.max(maxLength,counter);
            }

        }
        return maxLength;
    }
}
