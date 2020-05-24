#include <bits/stdc++.h>
using namespace std;
#include <vector>
int main()
{
  vector<int> v;
  for(int i = 0; i < 6; i++)
  {
    int num;
    cin >> num;
    v.push_back(num);
  }
  sort(v.rbegin(),v.rend());

  cout << "Output of begin and end: ";
  for (auto i = v.begin(); i != v.end(); ++i)
    cout << *i << " ";
}
