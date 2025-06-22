class Solution {
    public String[] divideString(String s, int k, char fill) {
        List<String> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int i=0;
        for(char c: s.toCharArray()){
            sb.append(c);
            i++;
            if(i==k){
                i=0;
                arr.add(sb.toString());
                sb=new StringBuilder();
            }
        }
        if(i!=0 && i!=k){
            while(i!=k){
                sb.append(fill);
                i++;
            }
            arr.add(sb.toString());
        }
        return arr.toArray(new String[arr.size()]);
    }
}