/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        long s=1;
        
        while(s<=n){
            int mid=(int) ((s+n)/2);
            int x= guess(mid);
            if(x==-1)
                n=mid-1;
            else if(x==1)
                s=mid+1;
            else
                return mid;
        }
        return -1;
        
    }
}