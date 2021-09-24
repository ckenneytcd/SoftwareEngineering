// Code is from geeksforgeeks: https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
//anotated by Caitlin Kenney based on Java comparison
#include <iostream>
#include <vector>

using namespace std;

//Node is a structure not a class
//Nodes left and right are not nodes but the addresses to nodes (assuming you cannot just assign a node to another and be able to refrence it)
struct Node 
{
	int key;
	struct Node *left, *right;
};

//Function creates a new node assigning the value of k and setting L&R to null without having to name a whole node
//Essentially the same as java new Node(k)
Node * newNode(int k)
{
	Node *temp = new Node;
	temp->key = k;
	temp->left = temp->right = NULL;
	return temp;
}

//Same as in java but in c++ vectors use push and pop instead of add and remove
bool findPath(Node *root, vector<int> &path, int k)
{
	if (root == NULL) return false;

	path.push_back(root->key);

	if (root->key == k)
		return true;

	if ( (root->left && findPath(root->left, path, k)) ||
		(root->right && findPath(root->right, path, k)) )
		return true;

	path.pop_back();
	return false;
}

//Need to use vector instead of list in order to refrence specific nodes
int findLCA(Node *root, int n1, int n2)
{
	vector<int> path1, path2;

	if ( !findPath(root, path1, n1) || !findPath(root, path2, n2))
		return -1;

	int i;
	for (i = 0; i < path1.size() && i < path2.size() ; i++)
		if (path1[i] != path2[i])
			break;
	return path1[i-1];
}

// Main function must return int
int main()
{
	//Create the first refrenceable node root
	Node * root = newNode(1);
	root->left = newNode(2);
	//Same as java giving a path to each node
	root->right = newNode(3);
	root->left->left = newNode(4);
	root->left->right = newNode(5);
	root->right->left = newNode(6);
	root->right->right = newNode(7);
	//print statements in c++
	cout << "LCA(4, 5) = " << findLCA(root, 4, 5);
	cout << "nLCA(4, 6) = " << findLCA(root, 4, 6);
	cout << "nLCA(3, 4) = " << findLCA(root, 3, 4);
	cout << "nLCA(2, 4) = " << findLCA(root, 2, 4);

	return 0;
}
//Run using sudo g++ -o LCA LCA.cpp then ./LCA