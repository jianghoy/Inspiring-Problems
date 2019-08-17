# Eulerian Path

## What's Eulerian Path?

It's a drawing one line problem in directed graph.

## How to know if a graph has Eulerian Path?

2 cases :
 
i. All points have the same in-degree and out-degree.

ii. All points have the same in-degree and out-degree except two: a starting point
which in-degree minus out-degree equals one; a ending point which out-degree minus in-degree 
is one.

## If it's a Eulerian Graph, how can we get it's Eulerian Path?
Pseudo-code
```pseudo
 // time complexity: O(V+E); space complexity: O(V)
 DFS(u) {
   While (Vertice v has unmarked Edge e:v -> u) {
     mark(e);
     DFS(u);
   }
   // now all edges are marked
   // be aware that path is in reverse order
   path.add(v);
 }  
```

## Sample Question: Reconstruct Itinerary

[leetcode 332](https://leetcode.com/problems/reconstruct-itinerary/)

[solution]()

[testcase]()
