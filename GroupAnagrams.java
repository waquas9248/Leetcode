//Neetcode - 150

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> groups = new ArrayList<List<String>>();

        int i = 0;

        HashMap<Character, Integer> charCount = new HashMap<>();

        int[] visited = new int[strs.length];

        int curr = -1;
        // outer loop
        while( i < strs.length ){

            if(visited[i] == 1){
                i++;
                continue;
            }

            String s = strs[i];
            groups.add(new ArrayList<>(Arrays.asList(s)));
            curr++;
            charCount = new HashMap<>();
        
            // build hashmap of char occurences
            for(int j = 0 ; j < s.length() ; j++){        
                char c = s.charAt(j);
                charCount.put(c, charCount.getOrDefault(c,0) + 1);
            }    

            // inner loop
            int k = i+1;
                //
             
            while( k < strs.length ){


                String t = strs[k];
                
                if( visited[k] == 1 || t.length() != s.length()){
                    k++;
                    continue;
                }

                HashMap<Character,Integer> temp = new HashMap<>(charCount);
                
                boolean flag = true;

                for(int j = 0 ; j < t.length() ; j++){

                    char c = t.charAt(j);
                    if( temp.getOrDefault(c,0) == 0 ){
                        flag = false;
                        break;
                    }

                    temp.put(c,temp.getOrDefault(c,0) - 1);

                }

                if(flag == true){
                    
                    visited[k] = 1;
                    List<String> currGroup = groups.get(curr);
                    currGroup.add(t);
                }

                k++;
            }


            i++;
        }


        return groups;

    }
}
