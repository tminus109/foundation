Two children, Lily and Ron, want to share a chocolate bar.
Each of the squares has an integer on it.
Lily decides to share a contiguous segment of the bar selected such that:
the length of the segment matches Ron's birth month, and,
the sum of the integers on the squares is equal to his birthday.
Determine how many ways she can divide the chocolate.

Example:
s = [2, 2, 1, 3, 2]
d = 4
m 2

Lily wants to find segments summing to Ron's birthday, d = 4 with a length equalling his
birth month, m = 2. In this case, there are two segments meeting her criteria: [2, 2] and [1, 3].

Function Description: complete the birthday function.

birthday has the following parameter(s):
int s[n]: the numbers on each of the squares of chocolate
int d: Ron's birthday
int m: Ron's birth month

Returns int: the number of ways the bar can be divided.

Input Format:
The first line contains an integer n, the number of squares in the chocolate bar.
The second line contains n space-separated integers s[i],
the numbers on the chocolate squares where 0 <= i < n.
The third line contains two space-separated integers, d and m,
Ron's birthday and his birth month.

Constraints:
1 <= n <= 100
1 <= s[i] <= 5 where 0 <= i < n
1 <= d <= 31
1 <= m <= 12

Sample Input 0:
5
1 2 1 3 2
3 2

Sample Output 0:
2

Sample Input 1:
6
1 1 1 1 1 1
3 2

Sample Output 1:
0

Sample Input 2:
1
4
4 1

Sample Output 2:
1
