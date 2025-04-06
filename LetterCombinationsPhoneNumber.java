// You are given a string digits made up of digits from 2 through 9 inclusive.
// Each digit (not including 1) is mapped to a set of characters as shown below:
// A digit could represent any one of the characters it maps to.
// Return all possible letter combinations that digits could represent. You may return the answer in any order.

class Solution {

    String[] digitToStr= {"+", "", "abc", "def", "ghi", "jkl","mno",
        "pqrs", "tuv", "wxyz"};

    List<String> combos = new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {

        if( digits.length() == 0 )
            return new ArrayList<>();

        recurse( digits, 0, new String() );

        return combos;

    }

    public void recurse(String digits, int index, String temp  ){
        
        if( temp.length() == digits.length() ){
            combos.add( new String(temp) );
            return;
        }

        String s = digitToStr[digits.charAt(index) - '0'];

        for(int i = 0; i < s.length() ; i++ ){            
            recurse(digits, index + 1, temp + s.charAt(i));
        }
        
        return;
      
    }

}
