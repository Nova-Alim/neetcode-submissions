class MedianFinder {

    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;



    public MedianFinder() {
         large = new PriorityQueue<>();
         small = new PriorityQueue<>((a,b)-> Integer.compare(b,a));
    }
    
    public void addNum(int num) {

        if(small.isEmpty() || small.peek() >= num){
            small.offer(num);
        }else{
            large.offer(num);
        }

        if(small.size() > large.size() +1){
            large.offer(small.poll());
        }else if(large.size()>small.size()+1){
            small.offer(large.poll());
        }
       
    }
    
    public double findMedian() {
        if(small.size() > large.size()){
            return small.peek();
        }else if(large.size()> small.size()){
            return large.peek();
        } else {
            return (small.peek() + large.peek()) / 2.0;
        }
    }
}
