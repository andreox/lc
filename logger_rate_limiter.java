class Logger {

    HashMap<String,Integer> words_timestamp ;
    public Logger() {
        words_timestamp = new HashMap<String,Integer>() ;
        
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        
        if ( words_timestamp.get(message) == null ) {
            int next_allowed_time = timestamp + 10 ;
            words_timestamp.put(message,next_allowed_time) ;
        }
        
        else {
            int allowed_time = words_timestamp.get(message) ;
            if ( allowed_time <= timestamp ) {
                words_timestamp.put(message, timestamp+10) ;
                return true ;
            }
            else return false ;
        }
        
        return true ;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
