#include <bits/stdc++.h>

using namespace std;


//1 ===================  Graph Traversal  ===================

/*
	5=============================   Concept    ===========================

	1. If we find the farthest end from any random node it will be one of the end of the diameter.
	2. If we find the farthest point from one end of diameter it will be the other end of diameter.
	3. Combine both we got our answers.

*/

class Solution {

	private:

	//{Node, distance}
	pair<int, int> farthestDistanceNode(vector<vector<int>> &adj, int sourceNode, int n){

		queue<int> que;

		// keep track of the visited nodes.
		vector<int> visited(n , 0);

		//maximum distance from the source node
		int maxDistance = 0;

		// the last/farthest node from the sourceNode.
		int lastNode = sourceNode;
		que.push(sourceNode);
		visited[sourceNode] = 1;

		while(!que.empty()){
			int s = que.size();

			while(s--){
				int front = que.front();
				que.pop();
				lastNode = front;

				for(auto neighbour: adj[front]){
					if(!visited[neighbour]){
						que.push(neighbour);
						visited[neighbour] = 1;
					}
				}
			}

			if(!que.empty()) maxDistance++;
		}

		return {lastNode, maxDistance};

	}

	int findDiameter(vector<vector<int>> &adj, int n){

		// first traversal where we find the diameter farthest distance node from 0.
		int farthestNode = farthestDistanceNode(adj, 0, n).first;

		//second traversal where we find the farthest node from the diameter one end.
		int farthestDistance = farthestDistanceNode(adj, farthestNode, n).second;

		return farthestDistance;
	}



	public:
	int treeDiameter(vector<vector<int>> &edges){

		// Build the adjacency matrix
		int n = edges.size()+1;
		vector<vector<int>> adj(n, vector<int>());

		for(auto &edge: edges){
			adj[edge[0]].push_back(edge[1]);
			adj[edge[1]].push_back(edge[0]);
		}

		return findDiameter(adj, n);
	}

};