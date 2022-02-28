//Still unsolved
//Hard problem

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> ret_list = new List<String>() ;
        
        String str_to_append = new String() ;
        String final_str = new String() ;
        int total_char_inserted = 0 ;
        Stack<Integer> last_index_inserted = new LinkedList<>() ;
        List<String> list_strings_to_append = new List<String>() ;
        int count_words = 0 ;
        
        for ( int i = 0 ; i < words.length ; i++ ) {

            if ( str_to_append.isEmpty() && words[i].length() < maxWidth ) {
                
                last_index_inserted.add(str_to_append.length()+words[i].length()-1) ;
                str_to_append += words[i] ;
                total_char_inserted += words[i].length() ;
                str_to_append += ' ' ;
                list_string_to_append.add(words[i]) ;
                count_words += 1 ;
                
            }
            
            else if ( !str_to_append.isEmpty() && ( words[i].length() + str_to_append.length() + 1 ) < maxWidth ) {
                
                last_index_inserted.add(str_to_append.length()+words[i].length()-1) ;
                str_to_append += words[i] ;
                total_char_inserted += words[i].length() ;
                str_to_append += ' ' ;list_string_to_append.add(words[i]) ;
                count_words += 1 ;
                
            }
            
            else if ( !str_to_append.isEmpty() && ( words[i].length() + str_to_append.length()) == maxWidth ) {
                
                last_index_inserted.add(str_to_append.length()+words[i].length()-1) ;
                str_to_append += words[i] ;
                total_char_inserted += words[i].length() ;
                list_string_to_append.add(words[i]) ;
                count_words += 1;
                
                
            }
            
            else if ( !str_to_append.isEmpty() && ( words[i].length() + str_to_append.length() ) > maxWidth ) {
                //adjust spaces in order to fill string and reach maxWidth
                int total_num_of_spaces = maxWidth - total_char_inserted ;
                int spaces = total_num_of_spaces / count_words ;
                int k = 0 ;
                while ( !last_index_inserted.isEmpty() ) {
                    
                    int index = last_index_inserted.pop() ;
                    final_str += list_strings_to_append.get(k) ;
                    String blank = new String(' ') ;
                    if ( (spaces + final_str).length() <= maxWidth ) 
                        final_str += (blank*spaces) ;
                    else
                        final_str += (blank*())
                    
                }
                
                
                //append string to ret_list
                //empty the string 
            }
        }
    }
}
