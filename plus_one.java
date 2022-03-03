class Solution {
    public int[] plusOne(int[] digits) {
        
        int len = digits.length ;
        int [] ret = new int[len+1] ;
        
        int carry = 0 ;
        if ( digits[len-1] == 9 ) {
            carry = 1 ;
            ret[len] = 0 ;
            
        }
        else 
            ret[len] = digits[len-1]+1 ;
        
        for ( int i = len-2 ; i >= 0 ; i-- ) {
            
            if ( digits[i] + carry == 10 ) {
                carry = 1 ;
                ret[i+1] = 0 ;
            }
            
            else {
                ret[i+1] = digits[i]+carry ;
                carry = 0 ;
            }
        }
        
        ret[0] = carry ;
        int[] ret_adjusted ;
        if ( carry== 0 ) { 
            ret_adjusted = new int[len] ;
            for ( int i = len ; i >= 1 ; i-- ) {
                ret_adjusted[i-1] = ret[i] ;
            }
            
            return ret_adjusted ;
        }
        return ret ;
    } 
}
