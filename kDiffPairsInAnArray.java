class Solution {
    
    public int findPairs(int[] nums, int k) {
        
        Map<Integer,Integer> numsMap = new HashMap<>() ;
        Set<Pair<Integer,Integer>> diffSets = new HashSet<>() ;
        
        for ( int i = 0 ; i < nums.length ; i++ ) {
            numsMap.put(nums[i],i) ;
            
        }
        
        int countDiffPairs = 0 ;
        for ( int i = 0 ; i < nums.length ; i++ ) {
            
            if ( numsMap.get(nums[i]+k) != null && !diffSets.contains(new Pair<>(nums[i],nums[numsMap.get(nums[i]+k)])) && !diffSets.contains(new Pair<>(nums[ numsMap.get(nums[i]+k)],nums[i])) && i != numsMap.get(nums[i]+k)) {
                
                System.out.println( nums[i] + " " + nums[ numsMap.get(nums[i]+k)]) ;
                ++countDiffPairs ;
                diffSets.add(new Pair<>(nums[i],nums[numsMap.get(nums[i]+k)])) ;
            }
        }
        
        return diffSets.size() ;
        
    }
}
