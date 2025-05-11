class Solution {
    public String pushDominoes(String s) {
        Queue<Integer> q = new LinkedList<>();
        int n = s.length();
        for(int i=0;i<s.length();i++){
            char c =s.charAt(i);
            if(c!='.')
                q.add(i);
        }
        StringBuilder sb = new StringBuilder(s);

        while(!q.isEmpty()){
            int size = q.size();
            while(size-- >0){
                int i = q.poll();
                char c = s.charAt(i);
                if(c=='L'){
                    if(i-1>=0 && s.charAt(i-1)=='.'){
                        if(i-2>=0 && s.charAt(i-2)=='R'){
                            continue;
                        }else{
                            q.add(i-1);
                            sb.setCharAt(i-1, 'L');
                        }
                    }
                }else{
                    if(i+1<n && s.charAt(i+1)=='.'){
                        if(i+2<n && s.charAt(i+2)=='L'){
                            continue;
                        }else{
                            q.add(i+1);
                            sb.setCharAt(i+1, 'R');

                        }
                    }
                }
            }
            s=sb.toString();
        }
        return sb.toString();
    }
}