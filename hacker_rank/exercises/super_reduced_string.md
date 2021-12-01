Reduce a string of lowercase characters in range ascii[‘a’..’z’]
by doing a series of operations.
In each operation, select a pair of adjacent letters that match, and delete them.
Delete as many characters as possible using this method and return the resulting string.
If the final string is empty, return "Empty String".

Examples:
s = "aab"
aab shortens to b in one operation: remove the adjacent a characters.

s = "abba"
Remove the two 'b' characters leaving 'aa'. Remove the two 'a' characters to leave ''.
Return 'Empty String'.

Function Description: complete the superReducedString function.

superReducedString has the following parameter(s): string s, a string to reduce.

Returns string: the reduced string or Empty String.

Input Format: A single string, s.

Constraints:
1 <= length of s <= 100

Sample Input 0:
aaabccddd

Sample Output 0:
abd

Sample Input 1:
aa

Sample Output 1:
Empty String

Sample Input 2:
baab

Sample Output 2:
Empty String

https://www.hackerrank.com/challenges/reduced-string/problem
