class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String,List<String>> map = new HashMap<>();

        for(int i=0; i<strs.length;i++){

        int[] count= new int[26];

       

        for(int j=0; j<strs[i].length();j++){
        
        count[strs[i].charAt(j)-'a']++;
        }

        String key = Arrays.toString(count);

        if(map.containsKey(key)){
            map.get(key).add(strs[i]);
        }else{
           List<String> anna = new ArrayList<>();
           anna.add(strs[i]);
           map.put(key,anna);
        }
        
    }

    return new ArrayList<>(map.values());
}
}