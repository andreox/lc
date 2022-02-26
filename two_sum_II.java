class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        HashMap<Integer,Integer> num_index = new HashMap<Integer,Integer>() ;
        int[] indexes = new int[2] ;
        
        for ( int i = 0 ; i < numbers.length ; i++ ) {
            num_index.put(numbers[i],i) ;
        }
        
        for ( int i = 0 ; i < numbers.length ; i++ ) {
    
            Integer second_index = num_index.get(target-numbers[i]) ;
            if ( second_index != null ) {
                indexes[0] = i+1 ;
                indexes[1] = second_index+1 ;
                if ( indexes[0] > indexes[1]) {
                    int tmp = indexes[0] ;
                    indexes[0] = indexes[1] ;
                    indexes[1] = tmp ;
                }
                
                return indexes ;
            }
        }
        return indexes ;
    }
}
