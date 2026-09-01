class Solution {
    public String minWindow(String s, String t) {
        
        HashMap<Character,Integer> values = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();

        for(int i=0; i<t.length(); i++){
            values.put(t.charAt(i),values.getOrDefault(t.charAt(i),0)+1);
        }

        int left=0;
        int right=0;
        int minLength= Integer.MAX_VALUE;
        int minLeft=0;

        while(right < s.length()){
        
        window.put(s.charAt(right),window.getOrDefault(s.charAt(right),0)+1);

        boolean valid=true;

       for(char c: values.keySet()){

         if(window.getOrDefault(c,0) < values.get(c)){
           valid=false;
           break;
       }

        }

        while(valid){

        if(right-left+1 < minLength){
            minLength= right-left+1;
            minLeft=left;
        }

        char removed= s.charAt(left);
        window.put(s.charAt(left),window.get(s.charAt(left))-1);
        left++;

        if(values.containsKey(removed) && window.getOrDefault(removed,0) < values.get(removed)){
            valid=false;
        }
        }


        right++;
  
    }

    if(minLength == Integer.MAX_VALUE){
    return "";
    }

      return s.substring(minLeft,minLeft+ minLength);
 }
}
