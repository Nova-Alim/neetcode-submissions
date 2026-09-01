class Solution {
    public int lengthOfLongestSubstring(String s) {


        

        int left=0;
        int right=0;
        int counter=0;

        char[] arr= s.toCharArray();

        HashSet<Character> table = new HashSet<>();

        while(right<arr.length){

         while(table.contains(arr[right])){
            table.remove(arr[left]);
            left++;
         }

        table.add(arr[right]);
         right++;

        counter= Math.max(counter,table.size());
        }
        return counter;
    }
}
