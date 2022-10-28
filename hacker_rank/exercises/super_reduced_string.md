Reduce a string of lowercase characters in range ascii[‘a’..’z’]
by doing a series of operations.
In each operation, select a pair of adjacent letters that match, and delete them.
Delete as many characters as possible using this method and return the resulting string.
If the final string is empty, return "Empty String".

Examples:

s = "aab"

"aab" shortens to "b" in one operation: remove the adjacent "a" character.

s = "abba"

Remove the two "b" characters leaving "aa". Remove the two "a" characters to leave "".
Return "Empty String".

Function Description: complete the superReducedString function.

superReducedString has the following parameter(s): string s, a string to reduce.

Returns string: the reduced string or "Empty String".

Input Format: A single string, s.

Constraints: 1 <= length of s <= 100

Sample Input: "aaabccddd"

Sample Output: "abd"

Sample Input: "aa"

Sample Output: "Empty String"

Sample Input: "baab"

Sample Output: "Empty String"

https://www.hackerrank.com/challenges/reduced-string/problem
