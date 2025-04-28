class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1 || s.length()<=numRows)
            return s;
        StringBuilder sb = new StringBuilder();
        char[][] mat = new char[numRows][s.length()+1];
        for(char[] a: mat){
            Arrays.fill(a, '*');
        }
        int i=0, j=0;
        boolean down=true;

        for(int t=0;t<s.length() && i>=0 && i< numRows && j<s.length()+1;t++){
            mat[i][j]=s.charAt(t);
            if(down){
                if(i==numRows-1){
                    down=false;
                    i--;
                    j++;
                }else{
                    i++;
                }
                
            }else{
                if(i==0){
                    down=true;
                    i++;
                }else{
                    i--;
                j++;

                }
                
                
            }

        }
        for( i=0;i<numRows;i++){
            for( j=0;j<s.length()+1;j++){
                if(mat[i][j]!='*'){
                    sb.append(mat[i][j]);
                }
            }
        }
        return sb.toString();
    }
}