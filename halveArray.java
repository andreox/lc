class Solution {
    public int halveArray(int[] nums) {
        
        long totalSum = 0 ;
        PriorityQueue<Double> pQueue = new PriorityQueue<>(Collections.reverseOrder()) ;
        for ( int i = 0 ; i < nums.length ; i++ ) {
            totalSum += nums[i] ;
            pQueue.add((double)nums[i]) ;
        }
        
        double tempTotalSum = (double) totalSum ;
        double halfSum = (double) totalSum/2 ;
        int countMoves = 0 ;
        
        while ( tempTotalSum > halfSum ) {
            
            ++countMoves ;
            double d = pQueue.remove() ;
            d /= 2 ;
            tempTotalSum -= d ;
            pQueue.add(d) ;
            
        }
        
        return countMoves ;
        
    }
}
