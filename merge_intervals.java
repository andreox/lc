class Solution {
    public int[][] merge(int[][] intervals) {
        
        int n = intervals.length ;
        int m = 2 ;
        //sort(intervals) ;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0])) ;
        ArrayList<List<Integer>> merged_intervals_list = new ArrayList<List<Integer>>() ;
        
        for ( int i = 0 ; i <= n-1 ; i++ ) {
            int start_interval = intervals[i][0] ;
            int end_interval = intervals[i][1] ;
            int j = i+1 ;
            while ( j < n && intervals[j][0] <= end_interval ) {
                end_interval = Math.max(end_interval, intervals[j++][1]);
            }
            
            ArrayList<Integer> merged_interval = new ArrayList<Integer>() ;
            merged_interval.add(start_interval) ;
            merged_interval.add(end_interval) ;
            merged_intervals_list.add(merged_interval) ;
            i = j-1 ;
        }
        
        int count_intervals = merged_intervals_list.size() ;
        int [][] merged_intervals_matrix = new int[count_intervals][2] ;
        
        for ( int i = 0 ; i < count_intervals ; i++ ) {
            merged_intervals_matrix[i][0] = merged_intervals_list.get(i).get(0) ;
            merged_intervals_matrix[i][1] = merged_intervals_list.get(i).get(1) ;

        }
        
        return merged_intervals_matrix ;
    }
    
    public void sort(int[][] intervals) {
        
        for ( int i = 0 ; i < intervals.length-1 ; i++ ) {
            for ( int j = i+1 ; j < intervals.length; j++ ) {
                if ( intervals[j][0] < intervals[i][0] ) {
                    int tmp = intervals[i][0] ;
                    intervals[i][0] = intervals[j][0] ;
                    intervals[j][0] = tmp ;
                    tmp = intervals[i][1] ;
                    intervals[i][1] = intervals[j][1] ;
                    intervals[j][1] = tmp ;
                }
            }
        }
    }
}

/* 1 3
    2 6
    8 10
    15 18
    */
