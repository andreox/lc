class Solution {
    
    public int maxDistToClosest_greedy(int[] seats) {
        
        //greedy solution
        int n = seats.length ;
        int [] one_indices = new int[n] ;
        int count_one = 0 ;
        for ( int i = 0 ; i < n ; i++ ) {
            if ( seats[i] == 1 ) one_indices[count_one++] = i ;
        }
        
        int max_seat = 0 ;
        for ( int i = 0 ; i < n ; i++ ) {
            if ( seats[i] == 0 ) {
                for ( int j = 0 ; j < count_one ; j++ ) {
                    if ( i < one_indices[0]) max_seat = Math.max( max_seat, one_indices[0]-i) ;
                     else if ( i > one_indices[count_one-1] ) max_seat = Math.max( max_seat, i-one_indices[count_one-1]) ;
                    else if ( i > one_indices[j] && i < one_indices[j+1]) {
                        max_seat = Math.max( max_seat, Math.min(i-one_indices[j], one_indices[j+1]-i)) ;
                    }
                   
                }
            }
        }
        
        return max_seat ;
    }
}
