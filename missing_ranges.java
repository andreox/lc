class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        
        ArrayList<String> ranges = new ArrayList<String>() ;
        
        if ( nums.length == 0 ) {
            if ( lower == upper ) ranges.add(new String(Integer.toString(lower))) ;
            else ranges.add(new String(Integer.toString(lower)+"->"+Integer.toString(upper))) ;
            return ranges ;
        }
        
        if ( nums[0] > lower ) {
            
                if ( (nums[0]-lower) == 1 ) 
                    ranges.add(new String(Integer.toString(lower))) ;
                
                else 
                    ranges.add(new String(Integer.toString(lower)+"->"+Integer.toString(nums[0]-1))) ;
                
        }
        
        int i ;
        for ( i = 0 ; i < nums.length-1 ; i++ ) {
             
            if ( (nums[i+1]-nums[i]) == 2 ) 
                ranges.add(new String(Integer.toString((nums[i+1]+nums[i])/2))) ;
            
            
            else if (  (nums[i+1]-nums[i]) > 2 )
                ranges.add(new String(Integer.toString(nums[i]+1)+"->"+Integer.toString(nums[i+1]-1))) ;
                  
        }
        
        if ( nums[i] < upper ) {
                if ( (upper-nums[i]) == 1 )
                    ranges.add(Integer.toString(upper)) ;
                
                else
                    ranges.add(new String(Integer.toString(nums[i]+1)+"->"+upper)) ;
        }
        
        return ranges ;
        
    }
}
