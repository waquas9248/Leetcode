//Neetcode - 150
//Implement the TimeMap class:
// TimeMap() Initializes the object.
// void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
// String get(String key, int timestamp) Returns the most recent value of key if set was previously called on it and the most recent timestamp for that key prev_timestamp is less than or equal to the given timestamp (prev_timestamp <= timestamp). If there are no values, it returns "".
// Note: For all calls to set, the timestamps are in strictly increasing order.

class TimeMap {

    HashMap<String,LinkedHashMap<Integer, String>> map;

    public TimeMap() {
        //LinkedHashMap is best suited as insertion order is maintained
        map = new HashMap<String, LinkedHashMap<Integer, String>>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new LinkedHashMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {

        Map<Integer, String> keyMap = map.get(key);

        if( keyMap == null )
            return "";
        
        Set<Integer> tSet = keyMap.keySet();

        int low = 0;
        int high = tSet.size() - 1;

        int target = Integer.MAX_VALUE;

        ArrayList<Integer> arr = new ArrayList<Integer>(tSet);

        while( low <= high ){
            
            int mid = (low + high) / 2;
            
            int midVal = arr.get(mid);

            if( midVal == timestamp ){
                return keyMap.get(timestamp);
            }else if( midVal < timestamp ){
                target = midVal;
                low = mid + 1;
                continue;
            }else{
                high = mid - 1;
                continue;
            }
          
        }

        if( target < timestamp )
            return keyMap.get(target);
        else
            return "";

    }
}
