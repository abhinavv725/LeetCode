class Solution {
    public String pushDominoes(String s) {
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='.'){
                q.add(i);
            }
        }
        int n=s.length();

        StringBuilder sb = new StringBuilder(s);
        while(!q.isEmpty()){
            int size = q.size();
            String temp = sb.toString();

            while(size-- >0){
                int i = q.poll();
                if(temp.charAt(i)=='L'){
                    if(i-1>=0 && temp.charAt(i-1) == '.'){
                        if(i-2>=0 && temp.charAt(i-2)=='R'){
                            continue;
                        }else{
                            sb.setCharAt(i-1, 'L');
                            q.add(i-1);
                        }
                    }

                }else{
                    if(i+1<n && temp.charAt(i+1) == '.'){
                        if(i+2<n && temp.charAt(i+2)=='L'){
                            continue;
                        }else{
                            sb.setCharAt(i+1, 'R');
                            q.add(i+1);
                        }
                    }

                }

            }

        }
        return sb.toString();
    }
}