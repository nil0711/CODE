#include<iostream>  
// #include<stdlib>
using namespace std;  
  
struct node  
{  
    int data;  
    struct node *left;  
    struct node *right;  
}; 
struct node *root = NULL; 
struct node *getNode(int val)  
{  
    struct node *newNode;  
    newNode = (struct node*)malloc(sizeof(struct node));  
    newNode->data   = val;  
    newNode->left  = NULL;  
    newNode->right = NULL;  
    return newNode;  
}
struct node *insertNode(struct node *root, int val)  
{  
     if(root == NULL)  
         return getNode(val);  
        if(root->data > val)  
         root->left = insertNode(root->left,val); 

            if(root->data < val)  
         root->right = insertNode(root->right,val);  
  
      
  
     return root;  
}   
void inorder(struct node *root)  
{  
    if(root == NULL)  
        return;  
    inorder(root->left);   
   cout<<root->data;  
    inorder(root->right);  
    
} 

void preorder(struct node *root)  
{  
    if(root == NULL)  
        return;
   cout<<root->data;
    preorder(root->left);
    preorder(root->right);  
}

void postorder(struct node *root)  
{  
    if(root == NULL)  
        return;
    
    postorder(root->left);
    postorder(root->right); 
    cout<<root->data;
} 
  
int main()  
{  
   struct node *root = NULL;  
    int data,ch;  
    cout<<"\n1.To insert a new node.";  
   cout<<"\n2.Inorder Traversal."; 
  cout<<"\n3.Preorder Traversal.";
    cout<<"\n4.Postorder Traversal.";
    cout<<"\n5.Exit";
        do      
        {  
           cout<<"\nSelect one of the operations:";
            
          cin>>ch;              
            switch (ch)  
            {  
            case 1 :   
                cout<<"\nEnter the value to be inserted\n";  
                cin>>data;  
                root = insertNode(root,data);                    
                break;                            
            case 2 :   
                cout<<"\nInorder Traversal of the Binary Tree:";  
                inorder(root);  
                break;
            case 3 :   
              cout<<"\nPreorder Traversal of the Binary Tree:";  
                preorder(root);  
                break;
            case 4 :   
               cout<<"\nPostorder Traversal of the Binary Tree:";  
                postorder(root);  
                break;
            case 5:
                 cout<<"Thank You...";
                 break;
          default :   
                cout<<"Wrong Choice\n";  
                break;     
            }  
        } while(ch != 5);  
  
   return 0;  
}  




