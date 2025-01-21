//Neetcode 150

class Solution {

    public String encode(List<String> strs) {

        if(strs.size() == 0)
            return "";
        
        StringBuilder encoded = new StringBuilder();
    
        for(String s : strs){
            
            try{
            byte[] byteArr = s.getBytes("UTF-8");
            
            //for each elem in byte array
            for(byte b : byteArr){
                String byteStr = Integer.toString(b & 0xFF);

                if(byteStr.length() == 2)
                    byteStr = "0" + byteStr;
                else if(byteStr.length() == 1)
                    byteStr = "00" + byteStr;
                
                //pad begining with 0s until 3 digit, ifreq

                encoded.append(byteStr);
                //append it to stringbuilder
            }

            encoded.append('x');
            //append 'x' to stringbuilder
            }catch( Exception e){
                e.printStackTrace(System.out);
            }
     
        }

        //return .toStirng()
        System.out.println(encoded);
        return encoded.toString();
             
    }

    public List<String> decode(String str) {

        if(str.length() == 0)  
            return new ArrayList<String>();

        //new list of strings
        List<String> decList = new ArrayList<>();
    
        //split it by x to get arr of byte strings
        String[] strArr = str.split("x");
    
        // for each byte string
        for( String byteStr : strArr){
            //create a byte array of size -> byte str len / 3
            byte[] byteArr = new byte[byteStr.length()/3]; 

            int i = 0;
            int j = 3;

            int k =0;

            while( j <= byteStr.length() ){
            //for each substr of 3 chars
                int unsignedByte = Integer.parseInt(byteStr.substring(i, j));
                byte b = (byte) unsignedByte; // Cast back to signed byte
                //Byte.parseByte(substr)
                
                byteArr[k] = b;
                //append it to bytearr

                i += 3;
                j += 3;
                k += 1;

            }
            
            //convert to str -> new String(byte[], StandardCharsets.UTF_8)
            try{
            String decoded = new String(byteArr, "UTF-8");

            //append str to list of strs
            decList.add(decoded);
            }catch( Exception e){
                e.printStackTrace(System.out);
            }
        }

        if(decList.size() == 0){
            decList.add("");
            return decList;
        }

        return decList;
        //return list of strs
    }
}
