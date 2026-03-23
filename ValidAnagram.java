// Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.

// An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
  
class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length())
            return false;

        // HashMap<Character, Integer> cmap = new HashMap<>();

        // for(char c: s.toCharArray()){
        //     cmap.put(c,cmap.getOrDefault(c,0)+1);
        // }

        // for(char c: t.toCharArray()){
        //     int count = cmap.getOrDefault(c,0)-1;
        //     cmap.put(c,count);
        //     if( count < 0 ){
        //         return false;
        //     }else{
        //         continue;
        //     }
        // }

        int[] charset = new int[26];

        for(char c : s.toCharArray()){
            charset[c - 'a'] += 1;
        }

        for(char c : t.toCharArray()){
            charset[c - 'a'] -= 1;
            if( charset[c - 'a'] < 0 )
                return false;
        }


        return true;
    }
}
