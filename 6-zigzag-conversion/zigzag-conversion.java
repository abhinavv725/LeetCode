class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1 || s.length()<=numRows)
            return s;
        char[][] matrix = new char[numRows][s.length()/2+2];
        for(char[] m: matrix){
            Arrays.fill(m, '*');
        }
        int i=0, j=0;
        boolean down=true;
        for(int t=0;t<s.length();t++){
            char c = s.charAt(t);
            matrix[i][j]=c;
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
                    i--;j++;
                }

            }
        }
        StringBuilder sb = new StringBuilder();
        for( i=0;i<numRows;i++){
            for( j=0;j<s.length()/2+2;j++){
                if(matrix[i][j]!='*')
                    sb.append(matrix[i][j]);
            }
        }
        return sb.toString();
    }
}