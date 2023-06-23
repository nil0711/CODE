#include<iostream>
#include<cstdio>
#include<cstdlib>
using namespace std;
struct node{
	struct node* pre;
	int data;
	struct node* next;
};
struct node* head=NULL;
void insert(){
	struct node* temp,*ptr;
	temp=(struct node*)malloc(sizeof(struct node*));
	int value,pos;

	if(temp==NULL){
		cout<<"overflow";
	}
	else
 {
		cout<<"Enter Node Data-:";
		cin>>value;
		temp->data=value;
		if(head==NULL){
			temp->next=NULL;
			temp->pre=NULL;
			head=temp;
			cout<<"Inserted Value";
		}
		else{
			temp->next=ptr->next;
			ptr->next=temp;
			cout<<"Inserted Value";
		}
			}
}
void del(){
	struct node* temp,*ptr;
	int x;
	cout<<"Enter Deletion Node Postion ";
	cin>>x;
	if(head==NULL){
		cout<<"Node are Empty";
	}
	else{
		ptr=head;
		for(int i=0;i<x;i++){
			temp=ptr;
			ptr=ptr->next;
		}
		temp->next=ptr->next;
		free(ptr);
	}
}
void show(){
	struct node*ptr,*temp;
	temp=head;
	if(temp==NULL)
	cout<<"Empty List-:";
	else{
	while(temp->next!=NULL){
			ptr=temp;
		temp=temp->next;
	
		cout<<ptr->data<<"->";
	}
	cout<<ptr->data<<"->";
}
}
main(){
	int choice =0;  
    while(choice != 9)   
    {  
        printf("\n\n********Main Menu********\n");  
        printf("\nChoose one option from the following list ...\n");  
        printf("\n===============================================\n");  
        printf("\n1.Insert\n2.Delete\n3.Show\n4.Exit");  
        printf("\nEnter your choice?\n");         
        scanf("\n%d",&choice);  
        switch(choice)  
        {  
            case 1:
            	insert();
            	break;
            	case 2:
            		del();
            		break;
            		case 3:
            			show();
            			break;
            case 4:  
            exit(0);  
            break;  
            default:  
            printf("Please enter valid choice..");  
}

	}
}