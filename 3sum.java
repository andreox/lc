class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        //LESSON LEARNED : When it comes about duplicates, use Sets! 
        HashMap<Integer,Integer> k_with_index = new HashMap<Integer,Integer>() ;
        Set<List<Integer>> ret_lists = new HashSet<List<Integer>> () ;
        if ( nums.length < 3 ) return new ArrayList(ret_lists) ;
        Arrays.sort(nums) ;
        for ( int i = 0 ; i < nums.length ; i++ ) k_with_index.put((-1)*nums[i],i) ;
        
        for ( int i = 0 ; i < nums.length-1 ; i++ )  {
            for ( int j = i+1 ; j < nums.length ; j++ ) {
            if ( k_with_index.containsKey(nums[i]+nums[j]) ) {
                int k_index = k_with_index.get(nums[i]+nums[j]) ;
                if ( k_index != i && k_index != j ) {
                    System.out.println(nums[k_index]+" "+nums[i]+" "+nums[j]) ;
                    ArrayList<Integer> triplet = new ArrayList<Integer>() ;
                    triplet.add(nums[k_index]) ;
                    triplet.add(nums[i]) ;
                    triplet.add(nums[j]) ;
                    Collections.sort(triplet) ;
                    ret_lists.add(triplet) ;
                    
                }
            }
            }
        }
        
        return new ArrayList(ret_lists) ;
        
    }
}
