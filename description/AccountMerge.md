# Account Merge
[leetcode 721](https://leetcode.com/problems/accounts-merge/)

## Binary Search
Idea: merge 2 sorted int array if there're same int element;

e.g.: `[1 3 5]` and `[2 3 4]` can merge because they have same element `3`;
`[1 3 5]` and `[2 4 6]` cannot merge because they don't have the same element.

Method: for each element in array ii use binary search to find element in 
array i. overall  time complexity: `O(nlgn)`.
merge time complexity: `O(n)`.