class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        
        List<HashMap<Character,Integer>> countCharsList = new ArrayList<>() ;
        List<String> universalStrings = new ArrayList<>() ;
        
        for ( int i = 0 ; i < words1.length ; i++ ) {
            
            HashMap<Character,Integer> currMap = new HashMap<Character,Integer>() ;
            
            for ( int j = 0 ; j < words1[i].length() ; j++ ) {
                
                if ( currMap.get(words1[i].charAt(j)) == null ) {
                    currMap.put(words1[i].charAt(j),1) ;
                }
                else
                    currMap.put( words1[i].charAt(j), currMap.get(words1[i].charAt(j))+1) ;
            }
            
            countCharsList.add(currMap) ;
        }
        
        HashMap<Character,Integer> countCharsW2 = new HashMap<>() ;
        
        for ( int i = 0 ; i < words2.length ; i++ ) {
            
            Map<Character,Integer> currMap = new HashMap<>() ;
            
            for ( int j = 0 ; j < words2[i].length() ; j++ ) {
                
                if ( currMap.get(words2[i].charAt(j)) == null ) {
                    currMap.put(words2[i].charAt(j),1) ;
                }
                else
                    currMap.put( words2[i].charAt(j), currMap.get(words2[i].charAt(j))+1) ;
            }
            
            for ( Character k : currMap.keySet() ) {
                
                if ( countCharsW2.get(k) != null && countCharsW2.get(k) < currMap.get(k)) countCharsW2.put(k, currMap.get(k)) ;
                
                else if ( countCharsW2.get(k) == null ) countCharsW2.put(k, currMap.get(k)) ;
            }
             
        }
        
       for ( int i = 0 ; i < words1.length ; i++ ) {
           
           boolean isUniversal = true ;
           
           for ( Character k : countCharsW2.keySet() ) {
                   
                   if ( countCharsList.get(i).get(k) == null ) {
                       isUniversal = false ;
                       break ;
                   }
                   else if ( countCharsList.get(i).get(k) != null && countCharsList.get(i).get(k) < countCharsW2.get(k) ) {
                       isUniversal = false ;
                       break ;
                   }
                   
               
           }
           
           if ( isUniversal ) universalStrings.add(words1[i]) ;
       }
        
        return universalStrings ;
        
    }
}
