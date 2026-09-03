class Solution {

    public String encode(List<String> strs) {

     
        StringBuilder word= new StringBuilder();
        
        for(int i=0; i<strs.size(); i++){
         int size= strs.get(i).length();

         word.append( size + "#" + strs.get(i));
        }

        return word.toString();

    }

    public List<String> decode(String str) {

        List<String> list = new ArrayList<>();

        for(int i=0; i<str.length();){

            int j= str.indexOf('#',i);
            String number= str.substring(i,j);
            int length=Integer.parseInt(number);


            String word= str.substring(j+1,j+1+length);
            list.add(word);
            i=j+1+length;
           

            }
           

             return list;
    }
}
