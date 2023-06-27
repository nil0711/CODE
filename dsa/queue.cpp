#include <iostream>
using namespace std;
int queue[100], n = 100, front = - 1, rear = - 1;
void Insert() {
   int val;
   if (rear == n - 1)//checks queue is full
   cout<<"Queue Overflow"<<endl;
   else {
      if (front == - 1)
      front = 0;//else front ko 0 banado nd value enter kro
      cout<<"Insert the element in queue : "<<endl;
      cin>>val;
      rear++;
      queue[rear] = val;
   }
}
void Delete() {
   if (front == - 1 ||  front >  rear) {
      cout<<"Queue Underflow ";
      return ;
   } else {
      cout<<"Element deleted from queue is : "<< queue[front] <<endl;
      front++;;
   }
}
void frontelement(){
    if (front == - 1 || front > rear)
      cout<<"Queue Empty";
    else
     cout<<"Element in the front is : "<< queue[front] <<endl;
}
void Display() {
   if (front == - 1)
   cout<<"Queue is empty"<<endl;
   else {
      cout<<"Queue elements are : ";
      for (int i = front; i <= rear; i++)
      cout<<queue[i]<<" ";
         cout<<endl;
   }
}
int main() {
   int ch;
   cout<<"1) Insert element to queue"<<endl;
   cout<<"2) Delete element from queue"<<endl;
   cout<<"3) Front Element in the queue"<<endl;
   cout<<"4) Display all the elements of queue"<<endl;
   cout<<"5) Exit"<<endl;
   do {
      cout<<"Enter your choice : "<<endl;
      cin>>ch;
      switch (ch) {
         case 1: Insert();
         break;
         case 2: Delete();
         break;
         case 3: frontelement();
         break;
         case 4: Display();
         break;
         case 5: cout<<"Exitting the program !"<<endl;
         break;
         default: cout<<"Invalid choice"<<endl;
         break;
      }
   } while(ch!=5);
   return 0;
}