class Solution {
    public boolean canTransform(String start, String result) {
        int i=0, j=0;
        while(i<start.length() && j<result.length()){
            while(i<start.length() && start.charAt(i)=='X')
                i++;
            while(j<result.length() && result.charAt(j)=='X')
                j++;
            if(i<start.length() && j<result.length()){
                if(start.charAt(i)!=result.charAt(j))
                return false;
            if(start.charAt(i) == 'R' && i>j)
                return false;
            if(start.charAt(i)=='L' && i<j)
                return false;
            i++;j++;

            } 
            
        }
        while(j<result.length() ){
            if(result.charAt(j)!='X')
                return false;
            j++;
        }
        while(i<start.length()){
            if(start.charAt(i)!='X')
                return false;
            i++;
        }
        return true;
        
    }
}