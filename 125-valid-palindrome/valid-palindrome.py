class Solution:
    def isPalindrome(self, s: str) -> bool:
        if(s==""):return True
        n=len(s)-1
        l,r=0,n
        while(l<=r):
            if(not s[l].isalnum()):
                l+=1
            elif(not s[r].isalnum()):
                r-=1
            else:
                if(s[l].lower()!=s[r].lower()):
                    return False
                l+=1
                r-=1
            
        return True
        
        