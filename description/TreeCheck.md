# TreeCheck

Given an array of int array `relation` representing edges and int `n` representing number of vertices from `0...n`. 
Outputs are: 
1. Successful: its a tree: output its pre-order traversal wrapped up with brackets, e.g.:

`relation`:

|parent|child|
|:----:|:---:|
|0     |  1  |
|  1   |  2  |

`n`:3

output: `(0(1(2)))`

2. Error `E1`: more than 2 children; output `E1`, e.g.:

`relation`:

|parent|child|
|:----:|:---:|
|0     |  1  |
|  0   |  2  |
|  0   |  3  |

`n`:4

output: `E1`

3. Error `E2`: duplicate edges; output `E2`, e.g.:

`relation`:

|parent|child|
|:----:|:---:|
|0     |  1  |
|  0   |  1  |
|  0   |  1 |

`n`:2

output: `E2`

4. Error `E3`: cycle, in this case its definition is **node is direct descendents of 2 or more parents** 
; output `E3`, e.g.:

`relation`:

|parent|child|
|:----:|:---:|
|0     |  1  |
|  2   |  1  |


`n`:3

output: `E3`

5. Error `E4`: more than one tree; output `E4`, e.g.:

`relation`:

|parent|child|
|:----:|:---:|
|0     |  1  |
|  3   |  2  |


`n`:4

output: `E4`

6. Other errors: ;I included self-cycling error into this; output `E5`, e.g.:

`relation`:

|parent|child|
|:----:|:---:|
|1     |  1  |



`n`:1

output: `E5`

# Links
[source code](https://github.com/jianghoy/Inspiring-Problems/blob/master/src/TreeCheck.java)

[unit tests](https://github.com/jianghoy/Inspiring-Problems/blob/master/src/TestTreeCheck.java)
 
