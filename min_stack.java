class MinStack {
    
    int min_val ;
    LinkedList<Integer> root ;
    PriorityQueue<Integer> min_heap ;
    HashMap<Integer,Integer> count_occurrencies ;
    
    public MinStack() {
        root = new LinkedList<Integer>() ;
        min_val = Integer.MIN_VALUE ;
        min_heap = new PriorityQueue<Integer>() ;
        count_occurrencies = new HashMap<Integer,Integer>() ;
        
    }
    
    public void push(int val) {
        
        root.addFirst(val) ;
        
        
        if ( count_occurrencies.get(val) != null && count_occurrencies.get(val) >= 1 ) count_occurrencies.put(val,count_occurrencies.get(val)+1) ;
        else if ( count_occurrencies.get(val) != null && count_occurrencies.get(val) == 0 ) {
            count_occurrencies.put(val,1) ;
            min_heap.add(val) ;
        }
        else {
            count_occurrencies.put(val,1) ;
            min_heap.add(val) ;
        }
        
    }
    
    public void pop() {
        
        if ( count_occurrencies.get(root.peekFirst()) == 1 ) {
            System.out.println("I'm removing "+root.peekFirst()) ;
            count_occurrencies.put(root.peekFirst(),count_occurrencies.get(root.peekFirst())-1) ;
            min_heap.remove(root.peekFirst()) ;
        }
        else count_occurrencies.put(root.peekFirst(),count_occurrencies.get(root.peekFirst())-1) ;
        
        root.removeFirst() ;
        
    }
    
    public int top() {
        
        return root.peekFirst() ;
        
    }
    
    public int getMin() {
        
        return min_heap.peek() ;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
