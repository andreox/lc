class Solution {
    
    static class Point {
        int x ;
        int y ;
        Point( int x, int y ) {
            this.x = x ;
            this.y = y ;
        }
        
        public double dist_from_0() {
            return ( Math.sqrt((x*x)+(y*y)))  ;
            
        }
        
        public void print() {
            System.out.println("x : "+x+" y: "+y) ;
        }
        
        public int getX() { return x ; }
        public int getY() { return y ; }
        
    }
    
    static class PointComparator implements Comparator<Point> {
        
        public int compare( Point p1, Point p2 ) {
            if ( p1.dist_from_0() > p2.dist_from_0() ) {
                return 1 ;
            }
            else if ( p1.dist_from_0() < p2.dist_from_0() )
                return -1 ;
            return 0 ;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<Point> min_heap_points = new PriorityQueue<Point>(k, new PointComparator()) ;
        
        int [][] ret_matrix = new int[k][2] ;
        
        for ( int i = 0 ; i < points.length ; i++ ) {
            Point p = new Point(points[i][0], points[i][1]) ;
            min_heap_points.add(p) ;
            
        }
        
        int i = 0 ;
        
        while ( k > 0 && min_heap_points.peek() != null ) {
            Point p = min_heap_points.poll() ;
            p.print() ;
            ret_matrix[i][0] = p.getX() ;
            ret_matrix[i][1] = p.getY() ;
            i++ ;
            k-- ;
        }
        
        return ret_matrix ;
    }
}
