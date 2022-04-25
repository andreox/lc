class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        
        PriorityQueue<Character> maxHeap = new PriorityQueue<Character>(Collections.reverseOrder()) ;
        
        HashMap<Character,Integer> countChars = new HashMap<Character,Integer>() ;
        
        
        StringBuilder result = new StringBuilder() ;
        
        for ( int i = 0 ; i < s.length() ; i++ ) {
            
            if  ( countChars.get(s.charAt(i)) == null ) {
                countChars.put(s.charAt(i),1) ;
                maxHeap.add(s.charAt(i)) ;
            }
            
            else countChars.put(s.charAt(i), countChars.get(s.charAt(i))+1) ;
            
        }
        
        while ( !maxHeap.isEmpty() ) {
            
            char c = maxHeap.peek() ;
            int count = 0 ;
            while ( countChars.get(c) > 0 && count < repeatLimit ) {
                
                result.append(c) ;
                countChars.put(c, countChars.get(c)-1) ;
                count++ ;
            }
            
            if ( countChars.get(c) == 0 ) maxHeap.poll() ;
            else if ( countChars.get(c) != 0 && count == repeatLimit && maxHeap.size() > 1 ) {
                //identify second largest and append just 1 char
                char secLargest = secondLargest(maxHeap,c) ;
                result.append(secLargest) ;
                countChars.put(secLargest, countChars.get(secLargest)-1) ;
                if ( countChars.get(secLargest) == 0 ) maxHeap.remove(secLargest) ;
            }
            
            else if ( countChars.get(c) != 0 && count == repeatLimit && maxHeap.size() == 1 ) break ;
        }
        
        return String.valueOf(result) ;
    }
    
    Character secondLargest(PriorityQueue<Character> pq, char c ) {
        
        Iterator<Character> it = pq.iterator() ;
        char max = 'a' ;
        while ( it.hasNext() ) {
            char curr = it.next() ;
            if ( curr != c && curr >= max ) max = curr ;
        }
        
        return max ;
    }
}
