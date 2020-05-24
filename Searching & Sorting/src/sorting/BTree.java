package sorting;

import java.util.*;
import java.util.Map.Entry;

class Node
{
	int data;
	Node left, right;
	Node parent;
	int hd;
	Node(int val)
	{
		this.data = val;
		left = right = parent = null;
	}	
}





public class BTree {
	
	Node root;
    BTree(int key) 
    { 
        root = new Node(key); 
        root.hd = 0;
    } 
  
    BTree() 
    { 
        root = null; 
    }
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no. of elements in tree: ");
		int total = sc.nextInt();
		BTree tree = new BTree();
		while(total-- > 0)
		{
			int val = sc.nextInt();
			tree.root = tree.insertion(tree.root, val);
			
		}
		while(true)
		{
			System.out.println("1: Level Order");
			System.out.println("2: Inorder");
			System.out.println("3: Check Balance");
			System.out.println("4: Create Minimal BST");
			System.out.println("5: Check Binary Search Tree.");
			System.out.println("6: Find Successor.");
			System.out.println("7: Vertical Order");
			//System.out.println("");
			//System.out.println();
			//System.out.println();
			//System.out.println("");
			//System.out.println();
			System.out.println("10: Exit");
			int entry = sc.nextInt();
			switch(entry)
			{
			case 1:
				tree.printLevelOrder(tree.root);
				System.out.println();
				break;
			case 2:
				tree.printInorder(tree.root);
				System.out.println();
				break;
			case 3:
				if(tree.checkBalance(tree.root))
					System.out.println("The tree is balanced.");
				else
					System.out.println("Tree is not balanced.");
				break;
			case 4:
				System.out.println("Enter the size of array: ");
				int n = sc.nextInt();
				int[] arr = new int[n];
				System.out.println("Enter the elements of array: ");
				for(int i = 0; i < n; i++)
					arr[i] = sc.nextInt();
				Arrays.sort(arr);
				Node newRoot = null;
				newRoot = tree.createMinBST(newRoot, arr, 0, n - 1);
				System.out.println("New tree Levelorderr traversal is ");
				tree.printLevelOrder(newRoot);
				System.out.println();
				break;
			case 5:
				tree.checkValidBST(tree.root);
				System.out.println();
				break;
			case 6:
				System.out.println("Enter the number whose successor you want to find : ");
				int num = sc.nextInt();
				Node node = tree.findNode(tree.root, num);
				Node Successor = tree.inorderSuccessor(node);
				if(Successor != null)
					System.out.println("Successor is " + Successor.data);
				else
					System.out.println("No Successor exist.");
				break;
			case 7:
				tree.printVerticalOrder(tree.root);
				break;
			case 8:
				break;
			case 9:
				break;
			case 10:
				System.exit(1);
			}
		}
	}
	void printLevelOrder(Node root2)
	{
		int height = getHeight(root2);
		int i;
		for(i = 1; i <= height; i++)
			printLevel(root2, i);
	}
	void checkValidBST(Node root2)
	{
		if(checkBST(root2))
			System.out.println("This is a valid Binary search tree");
		else
			System.out.println("This is not a valid Binary search tree");	
	}
	void printInorder(Node root2) {
		
		if(root2 != null)
		{
			printInorder(root2.left);
			System.out.print(root2.data + " ");
			printInorder(root2.right);
		}	
	}
	
	Node createMinBST(Node newRoot, int[] arr, int start, int end)
	{
		if(end < start)
			return null;
		int mid = (start + end ) / 2;
		newRoot = new Node(arr[mid]);
		newRoot.left = createMinBST(newRoot, arr, start, mid - 1);
		newRoot.right = createMinBST(newRoot, arr, mid + 1, end);
		return newRoot;
		
	}
	
	boolean checkBST(Node root)
	{
		if(root == null)
			return true;
		if(root.left != null)
			if(root.data > root.left.data && checkBST(root.left))
				return true;
			else
				return false;
		if(root.right != null)
			if(root.data > root.right.data && checkBST(root.right))
				return true;
			else
				return false;
		return true;
	}
	
	void printLevel(Node root4, int level)
	{
		if(root4 == null)
			return;
		if(level == 1)
			System.out.print(root4.data + " ");
		
		else if(level > 1)
		{
			printLevel(root4.left, level - 1);
			printLevel(root4.right, level - 1);
		}
				
	}
	
	void printVerticalOrder(Node root4)
	{
		TreeMap<Integer, ArrayList<Integer>> treemap = new TreeMap<>(); 
        int hd =0; 
        printVertical(root4, treemap); 
         
        for (Entry<Integer, ArrayList<Integer>> entry : treemap.entrySet()) 
        { 
            System.out.println(entry.getValue()); 
        }
		
	}
	
	void printVertical(Node root4, TreeMap<Integer, ArrayList<Integer>> treemap)
	{
		if(root4 == null)
			return;
		ArrayList<Integer> list = treemap.get(root4.hd);
		
		if(list == null)
		{
			list = new ArrayList<>();
			list.add(root4.data);
		}
		else
			list.add(root4.data);
		
		treemap.put(root4.hd, list);
		printVertical(root4.left, treemap);
		printVertical(root4.right, treemap);
	}
	
	boolean checkBalance(Node root4)
	{
		return checkHeight(root4) != Integer.MIN_VALUE;		
	}
	
	int checkHeight(Node root4)
	{
		if(root4 == null)
			return -1;
		int leftHeight = checkHeight(root4.left);
		if(leftHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		
		int rightHeight = checkHeight(root4.right);
		if(rightHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		
		int heightDiff = leftHeight - rightHeight;
		if(Math.abs(heightDiff) > 1)
			return Integer.MIN_VALUE;
		else
			return Math.max(leftHeight, rightHeight) + 1;
		
	}

	Node insertion(Node root1, int val)
	{
		if(root1 == null)
		{
			return new Node(val);
		}
		if(root1.data > val)
		{
			root1.left = insertion(root1.left, val);
			root1.left.parent = root1;
			root1.left.hd = root1.left.parent.hd - 1;
		}
		else
		{
			root1.right = insertion(root1.right, val);
			root1.right.parent = root1;
			root1.right.hd = root1.right.parent.hd + 1;
		}
		return root1;
	}
	
	Node findNode(Node N, Integer num)
	{
		 if(N == null)
			 return null;
		 if(N.data == num)
			 return N;
		 if(N.data >= num)
			 return findNode(N.left, num);
		 else
			 return findNode(N.right, num);
	}
	
	Node inorderSuccessor(Node N)
	{
		if(N == null)
			return null;
		if(N.right != null)
			return leftMostChild(N.right);
		else
		{
			Node q = N;
			Node x = N.parent;
			while(x != null && x.left != q)
			{
				q = x;
				x = x.parent;
			}
			return x;	
		}
	}
	
	Node leftMostChild(Node N)
	{
		if(N == null)
			return null;
		while(N.left != null)
			N = N.left;
		return N;
	}
	
	
	
	
	int getHeight(Node root3)
	{
		if(root3 == null)
			return 0;
		else
			return (max(getHeight(root3.left), getHeight(root3.right)) + 1);
	}
	
	
	
	int max(int a, int b)
	{
		if(a > b)
			return a;
		else
			return b;
	}

}
