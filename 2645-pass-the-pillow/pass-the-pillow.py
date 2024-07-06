class Solution:
    def passThePillow(self, n: int, time: int) -> int:
        x=time%(n-1)
        y=time//(n-1)
        if(y%2==0):
            return x+1
        return (n-x)
        
        
        # return x+1 if n%2!=0 else x
        