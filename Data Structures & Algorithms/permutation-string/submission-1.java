class Solution {
    public boolean checkInclusion(String s1, String s2) {
        

        HashMap<Character,Integer> word1 = new HashMap<>();
        HashMap<Character,Integer> word2 = new HashMap<>();

        if(s1==null || s2== null) return false;

        int left=0;
        int right=0;

      
      for(int i=0; i<s1.length();i++){
        word1.put(s1.charAt(i),word1.getOrDefault(s1.charAt(i),0)+1);
      }
       

        while(right < s2.length()){
            word2.put(s2.charAt(right),word2.getOrDefault(s2.charAt(right),0)+1);

            if(((right -left)+1) > s1.length()){
                word2.put(s2.charAt(left),word2.getOrDefault(s2.charAt(left),0)-1);

                if(word2.get(s2.charAt(left))==0){
                word2.remove(s2.charAt(left));
                ;}

                left++;
            }

            if(word1.equals(word2)){
                return true;
            }
            right++;

        }


            return false;

 }

    }

