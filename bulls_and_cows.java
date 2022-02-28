//rough solution

class Solution {
    public String getHint(String secret, String guess) {
        
        HashMap<Character,Integer> map_cows = new HashMap<Character,Integer>() ;
        int count_cows = 0 ;
        int count_bulls = 0 ;
        Set skip_indexes = new HashSet() ;
        int len = secret.length() ;
        
        for ( int i = 0 ; i < len ; i++ ) {
            
            if ( secret.charAt(i) == guess.charAt(i) ) {
                count_bulls++ ;
                skip_indexes.add(i) ;
            }
        }
        
        System.out.println(secret) ;
        
        for ( int i = 0 ; i < len ; i++ ) {
            
            if ( skip_indexes.contains(i)) continue ;
            if ( map_cows.get(secret.charAt(i)) == null ) {
                map_cows.put(secret.charAt(i), 1) ;
            }
            
            else {
                map_cows.put(secret.charAt(i), map_cows.get(secret.charAt(i)) + 1) ;
            }
            
        }
        
        
        for ( int i = 0 ; i < len ; i++ ) {

            if ( skip_indexes.contains(i)) continue ;
            Integer find = map_cows.get(guess.charAt(i)) ;
            if ( find != null && find == 1 ) {
                count_cows++ ;
                map_cows.remove(guess.charAt(i)) ;
            }
            
            else if ( find != null && find > 1 ) {
                count_cows++ ;
                map_cows.put( guess.charAt(i), find-1) ;
            }
        }
        
        return count_bulls+"A"+count_cows+"B" ;
        
    }
}
