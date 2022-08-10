class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer> course_numbers = new HashSet<>() ;
        Set<Integer> total_courses = new HashSet<>() ;
        
        for ( int i = 0 ; i < numCourses ; i++ ) {
            course_numbers.add(i) ;
            total_courses.add(i) ;
        }
        
        //Here you remove each node with entering arch from course_numbers set and add graph links to graph data structure
        
        List<List<Integer>> courses_graph = new ArrayList<>() ;
        for ( int i = 0 ; i < numCourses ; i++ ) courses_graph.add(new ArrayList<Integer>()) ;
        
        Set<Integer> courses_visited = new HashSet<>() ;
        
        for ( int i = 0 ; i < prerequisites.length ; i++ ) {
            course_numbers.remove(prerequisites[i][0]) ;
            courses_graph.get(prerequisites[i][1]).add(prerequisites[i][0]) ;
        }
        
        if ( course_numbers.size() == 0 ) return false ;
        
        Iterator it = course_numbers.iterator() ;
        
        while ( it.hasNext() ) {
            Integer elem = (Integer) it.next() ;
            System.out.println("Root: "+elem) ;
            
            //DFS
            Stack<Integer> visit_stack = new Stack<>() ;
            visit_stack.push(elem) ;
            
            while ( !visit_stack.isEmpty() ) {
                
                int node = visit_stack.pop() ;
                courses_visited.add(node) ;

                for ( int i = 0 ; i < courses_graph.get(node).size() ; i++ ) {
                    int next_node = courses_graph.get(node).get(i) ;
                    visit_stack.add(next_node) ;
                    if ( !courses_visited.contains(next_node) ) {
                        courses_visited.add(next_node) ;
                    }
                    else if ( courses_visited.contains(next_node)  ) {
                        System.out.println("Cycle detected!") ;
                        return false ;
                    }

                }
            } 
        }
        
        if ( courses_visited.size() == total_courses.size() ) return true ;
        return false ;
    }
}
