class Solution:
    def validWordAbbreviation(self, word: str, abbr: str) -> bool:
        a1 = 0
        i1 = 0
        while a1 < len(abbr):
            num = 0
            if abbr[a1].isdigit():
                
                if abbr[a1] == '0':
                    return False
                while a1 < len(abbr) and abbr[a1].isdigit():

                    num = num * 10 + int(abbr[a1])
                    a1 += 1
                
                if num + i1 > len(word):
                    return False
                i1 += num
            else:
                if i1 >=len(word) or abbr[a1] != word[i1]:
                    return False
                i1 += 1
                a1 += 1
        return a1 == len(abbr) and i1 == len(word)




            
            

        