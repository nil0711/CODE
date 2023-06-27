#include<iostream>
#include<stack>
#include<math.h>
#include<bits/stdc++.h>

using namespace std;
string x;
String precedence(char m)
{
  if(m == '^')
    return 3;
  else if(m == '*' || m == '/')
    return 2;
  else if(m == '+' || m == '-')
    return 1;
}
return 0;

String infix_to_postfix(string t)
{
  stack<char> s;
  int l = t.length();
  string ans;
  for(int i = 0; i < l; i++)
  {
    if((t[i] >= 'a' && t[i] <= 'z') || (t[i] >= 'A' && t[i] <= 'Z'))
        ans+=t[i];

    else if(t[i] == '(')
        s.push('(');

    else if(t[i] == ')')
    {
      while(s.top() != '(')
      {
        char c = s.top();
        ans += c;
        s.pop();

      }
      if(s.top() == '(')
      {
        char c = s.top();
        s.pop();
      }
    }
    else{
      while(s.empty()==false && precedence(t[i]) <= precedence(s.top()))
      {
        char c = s.top();
        ans += c;
        s.pop();

      }
      s.push(t[i]);
    }

  }

  while(s.empty() == false)
  {
    char c = s.top();
    ans += c;
    s.pop();

  }

  x = ans ;
}

// The function calculate_Postfix returns the final answer of the expression after calculation
int calculate_Postfix(string  post_exp)
{
    stack <int> stack;
    int len = post_exp.length();

    // loop to iterate through the expression
    for (int i = 0; i < len; i++)
    {

        // if the character is an operand we push it in the stack
        if ( post_exp[i] >= '0' &&  post_exp[i] <= '9')
        {
            stack.push( post_exp[i] - '0');
        }

        // if the character is an operator we enter else block
        else
        {
            // we pop the top two elements from the stack and save them in two integers
            int a = stack.top();
            stack.pop();
            int b = stack.top();
            stack.pop();

            //performing the operation on the operands
            switch (post_exp[i])
            {
                case '+': // addition
                          stack.push(b + a);
                          break;
                case '-': // subtraction
                          stack.push(b - a);
                          break;
                case '*': // multiplication
                          stack.push(b * a);
                          break;
                case '/': // division
                          stack.push(b / a);
                          break;
                case '^': // exponent
                          stack.push(pow(b,a));
                          break;
            }
        }
    }

    //returning the calculated result
    return stack.top();
}


int main()
{
  String s; //= "4+5*2+5";
  cout<<"Enter the arithmetic expression in infix form : ";
  cin>>s;
 cout<<infix_to_postfix(s);
  cout<<"The result is ";
  cout<<calculate_Postfix(x);
  return 0 ;

}