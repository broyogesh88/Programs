#include <bits/stdc++.h>
using namespace std;

int main()
{
  int m, n;
  std::cout << "Enter m: " << '\n';
  std::cin >> m;
  std::cout << "Enter m: " << '\n';
  std::cin >> n;
  vector<vector<int> > v( n , vector<int> (m)); ;


  std::cout << "Enter elements in vetor : " << '\n';
  for(int i = 0; i < m; i++)
  {
    for(int j = 0; j < n; j++)
    {
      int num;
      std::cin >> num;
      v[i][j] = num;
    }
  }

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < v[i].size(); j++)
            cout << v[i][j] << " ";
        cout << endl;
    }
}
