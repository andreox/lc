class Solution {
    public int connectSticks(int[] sticks) {
        
        PriorityQueue<Integer> sticksQueue = new PriorityQueue<Integer>() ;
        
        for ( int i = 0 ; i < sticks.length ; i++ ) sticksQueue.add(sticks[i]) ;
        
        int totalCost = 0 ;
        int currCost = 0 ;
        
        while ( sticksQueue.size() > 1 ) {
            
            int minStick = sticksQueue.poll() ;
            int secondMinStick = sticksQueue.poll() ;
            currCost = minStick+secondMinStick ;
            totalCost += currCost ;
            sticksQueue.add(currCost) ;
            
        }
        
        return totalCost ;
    }
    
}
