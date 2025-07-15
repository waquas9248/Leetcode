// You are given a string s which contains only three types of characters: '(', ')' and '*'.
// Return true if s is valid, otherwise return false.
// A string is valid if it follows all of the following rules:
// Every left parenthesis '(' must have a corresponding right parenthesis ')'.
// Every right parenthesis ')' must have a corresponding left parenthesis '('.
// Left parenthesis '(' must go before the corresponding right parenthesis ')'.
// A '*' could be treated as a right parenthesis ')' character or a left parenthesis '(' character, or as an empty string "".

class Solution {
    public boolean checkValidString(String s) {
        
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();

        int i = 0;

        while( i < s.length() ){
            
            char c = s.charAt(i);

            if( c == '(' ){
                left.push(i);
            }else if( c == '*' ){
                star.push(i);
            }else{
                if( left.isEmpty() && star.isEmpty() )
                    return false;
                
                if( !left.isEmpty() )
                    left.pop();
                else
                    star.pop();
            }

            i++;
        }

        while( !left.isEmpty() && !star.isEmpty() ){
            if( left.pop() > star.pop() )
                return false;
        }

        return left.isEmpty();

    }
}
