class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> nums1Set = new HashSet<Integer>() ;
        
        for ( int i = 0 ; i< nums1.length ; i++ ) nums1Set.add(nums1[i]) ;
        
        List<Integer> list = new ArrayList<>() ;
        
        for ( int i = 0 ; i < nums2.length ; i++ ) {
            if ( nums1Set.contains(nums2[i])) {
                list.add(nums2[i]) ;
                nums1Set.remove(nums2[i]) ;
            }
        }
        
        int[] ar = new int[list.size()] ;
        for( int i = 0 ; i<  list.size() ; i++ )
            ar[i] = list.get(i) ;
        
        return ar ;
    }
}
