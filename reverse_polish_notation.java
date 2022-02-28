class Solution {
    public int evalRPN(String[] tokens) {
        Stack operands = new Stack() ;
        
        for ( int i = 0 ; i < tokens.length ; i++ ) {

            if ( !isOperand(tokens[i])) {
                operands.push(tokens[i]) ;
            }
            
            else {
                String n1 = String.valueOf(operands.pop()) ;
                String n2 = String.valueOf(operands.pop()) ;
                operands.push(Integer.toString(evaluate_expression(tokens[i],n2,n1))) ;
            }
        }
        
        return Integer.parseInt(String.valueOf(operands.pop())) ;
        
    }
    
    public boolean isOperand( String operand ) {
        if ( operand.equals("+") || operand.equals("-") || operand.equals("*") || operand.equals("/") ) return true ;
        return false ;
        
    }
    public int evaluate_expression( String operator, String operand1, String operand2 ) {
        
        int op1 = Integer.parseInt(operand1) ;
        int op2 = Integer.parseInt(operand2) ;

        if ( operator.equals("+")) {
            return op1+op2 ;
        }
        
        else if ( operator.equals("-")) {
            return op1-op2 ;
        }
        
        else if ( operator.equals("*")) {
            return op1*op2 ;
        }
        
        else if ( operator.equals("/")) {
            return (int)(op1/op2) ;
        }
        
        return 0 ;
    }
}
