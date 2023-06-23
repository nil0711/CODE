#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<int> adj[10];
bool visited[10];

void DFS(int s) {
    visited[s] = true;
    cout << s << " ";
    for (int i = 0; i < adj[s].size(); i++) {
        if (!visited[adj[s][i]])
            DFS(adj[s][i]);
    }
}

void BFS(int s) {
    queue<int> q;
    q.push(s);
    visited[s] = true;
    while (!q.empty()) {
        int f = q.front();
        cout << f << " ";
        q.pop();
        for (int i = 0; i < adj[f].size(); i++) {
            if (!visited[adj[f][i]]) {
                q.push(adj[f][i]);
                visited[adj[f][i]] = true;
            }
        }
    }
}

int main() {
    int nodes, edges, x, y, source;
    int choice;
    cout << "Enter the number of nodes: ";
    cin >> nodes;
    cout << "Enter the number of edges: ";
    cin >> edges;
    cout<<"enter the edges values now";
    for (int i = 0; i < edges; i++) {
        cin >> x >> y;
        adj[x].push_back(y);
        adj[y].push_back(x);
    }
    do{
    cout << "Enter the source node: ";
    cin >> source;
    cout << "Enter your choice of traversal (1. DFS, 2. BFS): ";
    cin >> choice;
    switch(choice) {
        case 1:
            cout << "DFS: ";
            DFS(source);
            break;
        case 2:
            cout << "BFS: ";
            BFS(source);
            break;
        default:
            cout << "Invalid choice.";
    }
      }  while(choice!=3);
    
  return 0;
}