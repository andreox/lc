//bruteforce solution

class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        
        int i = 0 ;
        int j = 0 ;
        int screen_output = 0 ;
        int num_words = sentence.length ;
        int curr_len = 0 ;
        while( i < rows ) {
            
            if ( (sentence[j].length()+1+curr_len) <= cols ) {
                
                curr_len += sentence[j].length()+1 ;
                j = (j+1)%num_words ;
                if ( j == 0 ) screen_output++ ;
                
            }
            
            else if ( (sentence[j].length()+curr_len) == cols ) {
                curr_len += sentence[j].length()+1 ;
                j = (j+1)%num_words ;
                if ( j == 0 ) screen_output++ ;
                i++ ;
                curr_len = 0 ;
            }
            
            else if ( (sentence[j].length()+curr_len) > cols ) {
                curr_len = 0 ;
                i++ ;
            }
        }
        
        return screen_output ;
    }
}
