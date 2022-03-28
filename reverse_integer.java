//definitely improvable

class Solution {
    public int reverse(int x) {
        
        String stringNumber = Integer.toString(x) ;
        boolean isNegative = true ;
        StringBuilder stringNumberBuilder ;
        int minVal = Integer.MIN_VALUE ;
        int maxVal = Integer.MAX_VALUE ;
        int reversedInt = 0 ;
        
        if ( stringNumber.charAt(0) >= '1' && stringNumber.charAt(0) <= '9' ) isNegative = false ;
        
        if ( isNegative ) stringNumberBuilder = new StringBuilder(stringNumber.substring(1,stringNumber.length())) ;
        else stringNumberBuilder = new StringBuilder(stringNumber.substring(0,stringNumber.length())) ;
        
        stringNumberBuilder = stringNumberBuilder.reverse() ;
        
        int exponent = 0 ;
        for ( int i = stringNumberBuilder.length()-1 ; i >= 0 ; i-- ) {
            long valToAdd = (stringNumberBuilder.charAt(i)-'0')*(long)Math.pow(10,exponent++) ;
            if ( valToAdd > maxVal || valToAdd > maxVal || reversedInt+valToAdd > maxVal || reversedInt+valToAdd < minVal ) return 0 ;
            else reversedInt += valToAdd ;
        }
        
        if ( isNegative ) reversedInt *= -1 ;
        return reversedInt ;
 }
}
