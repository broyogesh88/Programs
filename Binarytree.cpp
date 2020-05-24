#include<iostream>
using namespace std;

int count1, count2;
struct Node
{
	int data;
	Node *left,*right;

	Node(int data)
	{
		this->data = data;
		left = right = NULL;
	}
};

Node *temp;

Node* Insertion(Node *ptr, int data)
{
	if(ptr == NULL)
		return new Node(data);
	else if(ptr->left == NULL)
		ptr->left = new Node(data);
	else if(ptr->right == NULL)
		ptr->right = new Node(data);
	else
	{	
		if(ptr->left != NULL)
		{
			count1++;
			temp = Insertion(ptr->left, data);
		}
		if(ptr->right != NULL)
		{
			count2++;
			temp = Insertion(ptr->right, data);
		}
	}
	if(count1 <= count2)
		ptr->left = temp;
	else
		ptr->right = temp;
	return ptr;
}

void inorder(Node *root)
{
	if(!root)
		return;
	else
	{
		inorder(root->left);
		cout << root->data << ", ";
		inorder(root->right);
	}
}

int main()
{
	int n, num, newnum;
	cout << "Enter the number of elements you want to insert in Binary Tree: ";
	cin >> n;
	cout << "Enter the numbers in Binary Tree: ";
	struct Node *root = NULL;
	while(n > 0)
	{
		cin >> num;
		count1 = count2 = 0;
		root = Insertion(root, num);
		n--;
	}
	cout << "Inorder traversal before insertion: "; 
    	inorder(root);
	cout << "Insert a new number: ";
	cin >> newnum;
	root = Insertion(root, newnum);
	cout << "Inorder traversal after insertion: "; 
   	inorder(root); 
	cout << root->data <<  endl;	
}
