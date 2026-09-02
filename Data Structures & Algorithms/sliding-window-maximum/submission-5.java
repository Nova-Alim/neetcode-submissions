class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] result= new int[nums.length-k+1];
        
        Deque<Integer> queue = new ArrayDeque<>();

        for(int i=0; i<nums.length; i++){

            while(!queue.isEmpty() && nums[i] > nums[queue.peekLast()]){
                queue.pollLast();
            }

            while(!queue.isEmpty() && queue.peekFirst()< i-k+1){
                queue.pollFirst();
            }

            queue.add(i);
            
            if(i>=k-1){
                result[i-k+1]=nums[queue.peekFirst()];
            }
        }
        return result;
    }
}
