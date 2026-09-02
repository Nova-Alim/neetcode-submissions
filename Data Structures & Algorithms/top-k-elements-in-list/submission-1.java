class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] result= new int[k];


        for(int i=0; i<nums.length; i++){
       
          map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        int count =0;

        while(count < k){
           
           int biggest=0;
           int number=0;

           for(int num: map.keySet()){

                if(map.get(num) > biggest){
                    biggest=map.get(num);
                    number=num;
                    
                }
           }
           result[count]=number;
            map.remove(number);
            count++;
        }
        return result;
    }
}
