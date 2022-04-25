class FindSumPairs {

    int [] nums1 ;
    int[] nums2 ;
    HashMap<Integer,Integer> nums2Map ;
    public FindSumPairs(int[] nums1, int[] nums2) {
        
        this.nums1 = new int[nums1.length] ;
        this.nums2 = new int[nums2.length] ;
        nums2Map = new HashMap<Integer,Integer>() ;
        
        for ( int i = 0 ; i < nums1.length ; i++ ) {
            this.nums1[i] = nums1[i] ;
            
        }
        
        for ( int i = 0 ; i < nums2.length ; i++ ) {
            this.nums2[i] = nums2[i] ;
            if ( nums2Map.get(nums2[i]) == null )  nums2Map.put(nums2[i],1) ;
            else nums2Map.put(nums2[i], nums2Map.get(nums2[i])+1) ;
        }
        
    }
    
    public void add(int index, int val) {
        
        if ( nums2Map.get(nums2[index]) == 1 ) nums2Map.remove(nums2[index]) ;
        else nums2Map.put( nums2[index], nums2Map.get(nums2[index])-1) ;
        
        this.nums2[index] += val ;
        if ( nums2Map.get(nums2[index]) != null ) nums2Map.put(nums2[index], nums2Map.get(nums2[index])+1) ;
        else nums2Map.put(nums2[index],1) ;
        
    }
    
    public int count(int tot) {
        
        int count = 0 ;
        
        for ( int i = 0 ; i < nums1.length ; i++ ) {
            if ( nums2Map.get(tot-nums1[i]) != null ) count += nums2Map.get(tot-nums1[i]) ;
        }
        return count ;
    }
}
