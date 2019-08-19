# Two Directional Binary Search

As we know, binary search can only apply to a (somewhat) ordered array, which limited its usability.
Say you're given an array which either ascending or descending(can't be any array other than that), how are you
going to binary search it using same method?

The idea is to add a `boolean ascending` variable to mark whether the array is ascending or not.(Even it's not given, it's
easy to determine). In the traditional `val[mid] > target` part, we add a `XOR` with `boolean ascending`. The point is:

  
 |ascending|val[mid] < target|`!ascending ^ val[mid] < target` |go        |
 |:-------:|:----------------:|:------------------------------:|:--------:|
 | T       |      T           |    T                           |    left  |
 | F       |      T           |    F                           |     right|
 
 ## code 
 [leetcode 1095](https://leetcode.com/problems/find-in-mountain-array/)
 
 [source code(not the same)](https://github.com/jianghoy/Inspiring-Problems/blob/master/src/BitonicBinarySearch.java)
 