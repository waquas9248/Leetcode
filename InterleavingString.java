// You are given three strings s1, s2, and s3. Return true if s3 is formed by interleaving s1 and s2 together or false otherwise.
// Interleaving two strings s and t is done by dividing s and t into n and m substrings respectively, where the following conditions are met
// |n - m| <= 1, i.e. the difference between the number of substrings of s and t is at most 1.
// s = s1 + s2 + ... + sn
// t = t1 + t2 + ... + tm
// Interleaving s and t is s1 + t1 + s2 + t2 + ... or t1 + s1 + t2 + s2 + ...
// You may assume that s1, s2 and s3 consist of lowercase English letters.

class Solution {

    //avoid repetition by saving paths traversed
    HashMap<String, Boolean> traversed;

    public boolean isInterleave(String s1, String s2, String s3) {

        traversed = new HashMap<>();
        
        //recurse(String s1, String s2, String s3, int i1, int i2, int i3, int subs1, int subs2, boolean turn1)
        //i1, i2, i3 -> curr S1, S2, S3 char index
        //subs1, subs2 -> curr S1, S2 substring count
        //turn1 -> S1's turn
        return recurse(s1,s2,s3,0,0,0,0,0,true) || recurse(s1,s2,s3,0,0,0,0,0,false);

    }

    public boolean recurse(String s1, String s2, String s3, int i1, int i2, int i3, int subs1, int subs2, boolean turn1){

        //every char in S1, S2 used and S3 complete
        if( i3 >= s3.length() && !( i1 < s1.length() ) && !( i2 < s2.length() ) )
            return true;

        if( i3 >= s3.length() || (i1 >= s1.length() && turn1) || (i2 >= s2.length() && !turn1) || (Math.abs(subs1 - subs2) > 1) )
            return false;

        String slug = "";

        if( turn1 )
            slug = "1-" + i1 + "-" + i3;
        else
            slug = "2-" + i2 + "-" + i3;
        
        if ( traversed.containsKey(slug) )
            return traversed.get(slug);

        boolean result = false;

        if( turn1 ){     
            if( ( s3.charAt(i3) == s1.charAt(i1) ) && ( recurse(s1,s2,s3,i1+1,i2,i3+1,subs1,subs2,true) || recurse(s1,s2,s3,i1+1,i2,i3+1,subs1+1,subs2,false) ) ){
                traversed.put(slug, true);
                result = true;
            }else{
                traversed.put(slug, false);              
            }
        }else{
            if( ( s3.charAt(i3) == s2.charAt(i2) ) && ( recurse(s1,s2,s3,i1,i2+1,i3+1,subs1,subs2,false) || recurse(s1,s2,s3,i1,i2+1,i3+1,subs1,subs2+1,true) ) ){
                traversed.put(slug, true);
                result = true;
            }else{
                traversed.put(slug, false);              
            }
        }

        return result;
    
    }

}
