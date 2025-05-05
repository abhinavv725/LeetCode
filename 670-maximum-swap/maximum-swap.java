class Solution {
    private void replace(char[] arr, HashMap<Character, Integer> map){
        for(int i=0;i<arr.length;i++){
            for(int d=9;d>=0;d--){
                char rep = (char)(d +'0');
                if(arr[i] < rep && map.containsKey(rep) && map.get(rep)>i){
                    int currInd = i;
                    int replaced = map.get(rep);

                    char temp = arr[currInd];
                    arr[currInd] = arr[replaced];
                    arr[replaced] = temp;
                    return;
                }
            }
        }
    }
    public int maximumSwap(int num) {
        char[] arr = Integer.toString(num).toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            map.put(arr[i], i);
        }
        replace(arr, map);
        return Integer.parseInt(new String(arr));

        
        
        
    }
}