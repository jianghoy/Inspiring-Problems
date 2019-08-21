# Eulerian Path

## Background
![graph of Königsberg Bridges](http://mathworld.wolfram.com/images/gifs/koenigsb.gif)![graph of bridges in graph theory form](http://mathworld.wolfram.com/images/eps-gif/KoenigsbergBridges_901.gif)

The Königsberg bridge problem asks if the seven bridges of the city of Königsberg can all be traversed in a single trip without doubling back, with the additional requirement that the trip ends in the same place it began.

## Eulerian cycle vs Eulerian path

Eulerian cycle requiers to traverse all edges of a [multigraph](http://mathworld.wolfram.com/Multigraph.html) and go back to same starting vertice; Eulerian path requiers to traverse all edges of a multigraph but can end at another vertice.

e.g. the [leetcode 332](https://leetcode.com/problems/reconstruct-itinerary/) requires to find a valid Eulerian path because it does not ask the path to go back to JFK.

## How to know if a undirected graph has Eulerian Cycle?

All vertices have even edges.

## How to know if a directed graph has Eulerian Cycle?

All vertices have the same indegree and outdegree.

## How to know if a undirected graph has Eulerian Path?

i. It has Eulerian Cycle.

ii. Two vertices have odd degrees.

## How to know if a directed graph has Eulerian Path?

2 cases :
 
 i. It has Eulerian Cycle.

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

[solution](https://github.com/jianghoy/Inspiring-Problems/blob/master/src/FindItinery.java)

[testcase](https://github.com/jianghoy/Inspiring-Problems/blob/master/src/TestFindItinery.java)
 
## Reference

[Königsberg Bridge Problem Wolframe MathWorld](http://mathworld.wolfram.com/KoenigsbergBridgeProblem.html)

[Algorithmus von Hierholzer](https://www-m9.ma.tum.de/graph-algorithms/hierholzer/index_en.html)
