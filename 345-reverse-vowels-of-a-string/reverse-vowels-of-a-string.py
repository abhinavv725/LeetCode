class Solution:
    def reverseVowels(self, s: str) -> str:
        l,r=0,len(s)-1
        s=list(s)
        vow=["a","e","i","o","u"]
        while(l<=r):
            if(s[l].lower() not in vow):
                l+=1
            elif(s[r].lower() not in vow):
                r-=1
            else:
                s[l],s[r]=s[r],s[l]
                l+=1
                r-=1
        return "".join(s)
        