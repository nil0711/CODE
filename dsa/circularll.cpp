#include<iostream>  
#include<stdio.h>  
// #include<stdlib.h>  
using namespace std;
struct node   
{  
    int data;  
    struct node *next;   
};  
struct node *head;  
  
void beginsert ();     
 
void begin_delete();   
void display();  
void search();  
 main ()  
{  
    int choice =0;  
    while(choice != 5)   
    {  
         cout<<"\n********Main Menu********\n";  
         cout<<"\nChoose one option from the following list ...\n";  
         cout<<"\n===============================================\n";  
         cout<<"\n1.Insert in begining\n2.Delete from Beginning\n3.Search for an element\n4.Show\n5.Exit\n";  
        cout<<"\nEnter your choice?\n";         
        cin>>choice;  
        switch(choice)  
        {  
            case 1:  
            beginsert();      
            break;  
            case 2:  
            begin_delete();       

            break;  
            case 3:  
            search();         
            break;  
            case 4:  
            display();        
            break;  
            case 5:  
            exit(0);  
            break;  
            default:  
             cout<<"Please enter valid choice..";  
        }  
    }  
}  
void beginsert()  
{  
    struct node *ptr,*temp;   
    int item;   
    ptr = (struct node *)malloc(sizeof(struct node));  
    if(ptr == NULL)  
    {  
         cout<<"\nOVERFLOW";  
    }  
    else   
    {  
         cout<<"\nEnter the node data?";  
        cin>>item;
        ptr -> data = item;  
        if(head == NULL)  
        {  
            head = ptr;  
            ptr -> next = head;  
        }  
        else   
        {     
            temp = head;  
            while(temp->next != head)  
                temp = temp->next;  
            ptr->next = head;   
            temp -> next = ptr;   
            head = ptr;  
        }   
         cout<<"\nnode inserted\n";  
    }             
}  
void begin_delete()  
{  
    struct node *ptr;   
    if(head == NULL)  
    {  
         cout<<"\nUNDERFLOW";    
    }  
    else if(head->next == head)  
    {  
        head = NULL;  
        free(head);  
         cout<<"\nnode deleted\n";  
    }      
    else  
    {   ptr = head;   
        while(ptr -> next != head)  
            ptr = ptr -> next;   
        ptr->next = head->next;  
        free(head);  
        head = ptr->next;  
         cout<<"\nnode deleted\n";  
    }  
}  
void search()  
{  
    struct node *ptr;  
    int item,i=0,flag=1;  
    ptr = head;   
    if(ptr == NULL)  
    {  
         cout<<"\nEmpty List\n";  
    }  
    else  
    {   
         cout<<"\nEnter item which you want to search?\n";   
        cin>>item;  
        if(head ->data == item)  
        {  
         cout<<"item found at location", i+1;  
        flag=0;  
        }  
        else   
        {  
        while (ptr->next != head)  
        {  
            if(ptr->data == item)  
            {  
                 cout<<"item found at location  ",i+1;  
                flag=0;  
                break;  
            }   
            else  
            {  
                flag=1;  
            }  
            i++;  
            ptr = ptr -> next;  
        }  
        }  
        if(flag != 0)  
        {  
             cout<<"Item not found\n";  
        }  
    }     
          
}  
  
void display()  
{  
    struct node *ptr;  
    ptr=head;  
    if(head == NULL)  
    {  
         cout<<"\nnothing to print";  
    }     
    else  
    {  
         cout<<"\n printing values ... \n";  
          
        while(ptr -> next != head)  
        {  
          
             cout<< ptr -> data;  
            ptr = ptr -> next;  
        }  
        cout<< ptr -> data;  
   
    }  
}