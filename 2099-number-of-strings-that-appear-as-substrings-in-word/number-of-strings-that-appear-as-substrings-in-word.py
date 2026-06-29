class Solution(object):
    def numOfStrings(self, patterns, word):
        cnt = 0
        for pattern in patterns:
            if pattern in word:
                cnt += 1
        return cnt

        