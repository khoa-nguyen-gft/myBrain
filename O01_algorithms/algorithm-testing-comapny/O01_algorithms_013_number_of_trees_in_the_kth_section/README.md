# Number of trees in the K-th section 

A garden is divided into N sections numbered from 0 to N-1. 
It is described by an array A, where A[k] denotes the number of trees in the K-th section. To make the garden look more organized, we want the number of trees in every section to be the same. As we don't want to cut any trees down, we can perform either of the following actions:

    • planting a new tree in one of the sections;
    • replanting an existing tree, moving it from one section to another.
We want to minimize the number of actions performed.

Write a function:
```java
class Solution{
    public static int solution(int[] array){
        return 0;
    }
}
```

that, given an array A consisting of N integers describing the garden, returns the minimum number of actions we need to perform in order to make all sections of the garden contain the same number of trees.

Examples:
1. Given A = [1, 2, 2, 4] the function should return 4. We can move
   one tree from A|3] to A[1] and obtain A = [1, 3, 2, 3]. Then we can
   plant two trees in A[0] and one tree in A[2] to make every section contain three trees
2. Given A = (4, 2, 4, 6], the function should return 2. We can move
   two trees from A[3] to A[1]. This way, every section in the garden will contain four trees.
3. Given A = [1, 1, 2, 1], the function should return 3. We can plant
   one tree in A[0], A[1] and A[3] so that each section in the garden contains two trees.