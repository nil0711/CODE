#include <iostream>
#include <stack>
using namespace std;
struct Node {
  int data;
  Node* left;
  Node* right;
};

Node* newNode(int data) {
  Node* node = new Node();
  node->data = data;
  node->left = node->right = nullptr;
  return node;
}

void postOrder(Node* node) {
  if (node == nullptr) return;

  postOrder(node->left);
  postOrder(node->right);
  cout << node->data << " ";
}

void inOrder(Node* node) {
  if (node == nullptr) return;

  inOrder(node->left);
  cout << node->data << " ";
  inOrder(node->right);
}

void preOrder(Node* node) {
  if (node == nullptr) return;

  cout << node->data << " ";
  preOrder(node->left);
  preOrder(node->right);
}

int main() {
  Node* root = newNode(1);
  root->left = newNode(2);
  root->right = newNode(3);
  // root->left->left = newNode(4);
  // root->left->right = newNode(5);
  // root->right->left = newNode(6);
  // root->right->right = newNode(7);

 cout << "Post-order traversal: ";
  postOrder(root);
  cout << "\n";

  cout << "In-order traversal: ";
  inOrder(root);
  cout << "\n";

  cout << "Pre-order traversal: ";
  preOrder(root);
  cout << "\n";
}