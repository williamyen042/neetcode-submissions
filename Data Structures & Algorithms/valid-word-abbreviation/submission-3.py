class Solution:
    def validWordAbbreviation(self, word: str, abbr: str) -> bool:
        l1 = 0;
        l2 = 0;
        while l2 < len(abbr):
            num = 0;
            if abbr[l2].isdigit():
                if int(abbr[l2]) == 0:
                    return False
                while l2 < len(abbr) and abbr[l2].isdigit():
                    num = num * 10 + int(abbr[l2])
                    l2 += 1
                if num + l1 > len(word):
                    return False
                l1 += num
            else:
                if l1 >= len(word) or abbr[l2] != word[l1]:
                    return False
                l1 += 1
                l2 += 1

        return l1 == len(word) and l2 == len(abbr)

        