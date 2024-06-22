class Solution:
    def reverseWords(self, s: str) -> str:
        s=s.split(" ")
        s=[x for x in s if(x!="")]
        
        return " ".join(s[::-1])
        