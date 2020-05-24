#include <bits/stdc++.h>
using namespace std;

int len1, len2;
int memo[len1 + 1][len2 + 1];
int longestSubsequence(string str1, string str2, int m, int n)
{
  if(memo[m][n] != -1)
    return memo[m][n];
  if(m == 0 || n == 0)
    memo[m][n] = 0;
  if(str1[m] == str2[n])
    memo[m][n] = 1 + longestSubsequence(str1, str2, m - 1, n - 1);
  else
    memo[m][n] = max((longestSubsequence(str1, str2, m - 1, n)), (longestSubsequence(str1, str2, m , n - 1)));
}

int main()
{
  string str1, str2;
  cin >> str1 >> str2;
  len1 = str1.length();
  len2 = str2.length();

  int memo[len1 + 1][len2 + 1];

  for(int i = 0; i < len1; i++)
  {
    for(int j = 0; j < len2; j++)
      memo[i][j] = -1;
  }

  int res = longestSubsequence(str1, str2, len1, len2);
  std::cout << "Length of longest subsequence is : " << res << '\n';
  return 0;
}



int max(int a, int b)
{
  if( a > b)
    return a;
  else
    return b;
}
