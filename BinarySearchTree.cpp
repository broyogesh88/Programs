#include<iostream>
using namespace std;

struct Node
{
	int data;
	struct Node *lchild, *rchild;
	Node(int data)
	{
		this->data = data;
		left = right = NULL;
	}
};

int main()
{
	cout << "Enter the toal number of elements in Binary Search Tree: ";
	int n;
	cin >> n;
	while(n > 0)
	{
		root = 

