class Solution {

    public String encode(List<String> strs) {
        StringBuilder megaZord= new StringBuilder();
            for(String word: strs){
                megaZord.append(word.length()).append('#').append(word);
            }

            return megaZord.toString();
    }

    public List<String> decode(String str) {

        List<String> coll = new ArrayList<>();

        int i=0;

        while(i< str.length()){
            
        int j=i;

        while(str.charAt(j) !='#'){
            j++;
        }

        String wordLength= str.substring(i,j);
        int length= Integer.parseInt(wordLength);

        String word= str.substring(j+1,j+1+length);

        coll.add(word);

        i=j+1+length;

           
        }

        return coll;
    }
}
