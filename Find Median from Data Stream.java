class MedianFinder {

    PriorityQueue<Integer> maxHeap; //stores the smaller half elements
    PriorityQueue<Integer> minHeap; //stores the greater half elements

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a); 
        minHeap = new PriorityQueue<>(); 
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        
        if(maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll()); 
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0; 
    }
}
