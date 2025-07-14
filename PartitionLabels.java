// You are given a string s consisting of lowercase english letters.
// We want to split the string into as many substrings as possible, while ensuring that each letter appears in at most one substring.
// Return a list of integers representing the size of these substrings in the order they appear in the string.

class Solution {
    public List<Integer> partitionLabels(String s) {

        HashMap<Character, Integer> charIndexMap = new HashMap<>();

        List<Integer> iList = new ArrayList<>();

        List<Integer> subSizes = new ArrayList<>();

        for( int i = 0 ; i < s.length() ; i++ ){

            char c = s.charAt(i);

            //if new character
            if( !charIndexMap.containsKey(c) ){

                int index = subSizes.size();

                charIndexMap.put(c,index);

                iList.add(index, i);

                subSizes.add(index,1);

            }
        
            else{
            //if existing character

                int index = charIndexMap.get(c);

                subSizes.set(index, i - iList.get(index) + 1 );

                //if( list.size > index + 1 )
                if( subSizes.size() > index + 1 )
                    subSizes = subSizes.subList(0, index+1);

                //if( ilist.size > index + 1 )
                if( iList.size() > index + 1 )
                    iList = iList.subList(0, index+1);

                for( char k: charIndexMap.keySet() ){

                        if( charIndexMap.get(k) > index )
                            charIndexMap.put(k, index);

                }
            
            }

        }
        
        return subSizes;
    }
}
