class Solution {
    public String convert(String str, int numRows) {
        if(str.length()<=numRows || numRows==1){
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char[][] image = new char[numRows][str.length()];

        for(char[] c: image){
            Arrays.fill(c, '*');
        }
        int i=0,j=0;
        boolean goingDown=true;
        for(int t=0;t<str.length();t++){
            image[i][j] = str.charAt(t);
            if(goingDown){
                if(i==numRows-1){
                    goingDown=false;
                    i--;
                    j++;

                }else{
                    i++;
                }
            }else{
                if(i==0){
                    goingDown=true;
                    i++;
                }else{
                    i--;
                    j++;
                }
            }
        }
        for( i=0;i<numRows;i++){
            for( j=0;j<str.length();j++){
                if(image[i][j]!='*'){
                    sb.append(image[i][j]);
                }
            }
        }
        return sb.toString();
    }
}