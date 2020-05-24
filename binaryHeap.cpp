#include <bits/stdc++.h>
using namespace std;

void heapify(int *array, int i);
int find(int *array, int left, int right, int num);

int main()
{
  std::cout << "Enter the number of elements in heap : ";
  int n;
  std::cin >> n;

  int heap[n];
  int index = -1;
  int num;

  std::cout << "Enter the elements in a heap." << '\n';
  for(int i = 0; i < n; i++)
  {
      std::cin >> heap[i];
  }
  heapify(heap, n);

  while(true)
  {
    std::cout << "1: Get Parent." << '\n';
    std::cout << "2: Get left Child" << '\n';
    std::cout << "3: Get right Child" << '\n';
    std::cout << "4: Exit" << '\n';
    std::cout << "Enter your choice : ";

    int choice;
    std::cin >> choice;

    switch (choice) {
      case 1:
        std::cout << "Enter number : " << '\n';
        std::cin >> num;
        index = find(heap, 0, n, num);
        if(index == 0)
          std::cout << "It is a root node." << '\n';
        else if(index != -1)
        {
          int value = floor((index - 1) / 2);
          std::cout << "Parent is : " << heap[value] << "\n\n";
        }
        else
          std::cout << "No such number exist in heap." << '\n';
        break;
      case 2:
        std::cout << "Enter number : " << '\n';
        std::cin >> num;
        index = find(heap, 0, n, num);
        if(index != -1)
        {
          int value = 2 * index + 1;
          if(value < n)
            std::cout << "Left Child is : " << heap[value] << "\n\n";
          else
            std::cout << "It do not have left children" << '\n';
        }
        else
          std::cout << "No such number exist in heap." << '\n';
        break;
      case 3:
        std::cout << "Enter number : " << '\n';
        std::cin >> num;
        index = find(heap, 0, n, num);
        if(index != -1)
        {
          int value = 2 * index + 2;
          if(value < n)
            std::cout << "Right Child is : " << heap[value] << "\n\n";
          else
            std::cout << "It do not have right children" << '\n';

        }
        else
          std::cout << "No such number exist in heap." << '\n';
        break;
      case 4:
        _Exit(1);
    }
  }
}

int find(int *array, int left, int right, int num)
{
  if(right >= left)
  {
    int mid = (left + right) / 2;
    if(array[mid] == num)
      return mid;
    else if(array[mid] > num)
      return find(array, left, mid - 1, num);
    else
      return find(array, mid + 1, right, num);
  }
  return -1;
}

void heapify(int *array, int i)
{
  sort(array, array + i);
}
