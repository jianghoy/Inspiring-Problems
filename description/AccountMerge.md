# Account Merge
[leetcode 721](https://leetcode.com/problems/accounts-merge/)

## Binary Search
Idea: merge 2 sorted int array if there're same int element;

e.g.: `[1 3 5]` and `[2 3 4]` can merge because they have same element `3`;
`[1 3 5]` and `[2 4 6]` cannot merge because they don't have the same element.

Method: for each element in array ii use binary search to find element in 
array i. overall  time complexity: `O(nlgn)`. n:# of all emails in all lists.


merge time complexity: `O(n)`.

Pseudo code:
```pseudo
for List:l of (all lists with same name) {
  for every List:m (before l and has same name with l) {
    for every String:email in l {
      if (binarySearchStringExist(String email, List m)) {  
        merge(l,m) 
      }
    }
  }
}
```
[sample code](https://github.com/jianghoy/Inspiring-Problems/blob/master/src/AccountMerge.java)

*This code can pass all but one test case in leetcode due to some optimization issues though time
complexity analysis show this is of same order compare with others.* 

