In many problems dealing with an array (or a LinkedList), we are asked to find or calculate something among all the contiguous subarrays (or sublists) of a given size. For example, take a look at this problem:

Given an array, find the average of all contiguous subarrays of size ‘K’ in it.

Let’s understand this problem with a real input:

```avro protocol
Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
```
Here, we are asked to find the average of all contiguous subarrays of size ‘5’ in the given array. Let’s solve this:

- For the first 5 numbers (subarray from index 0-4), the average is:(1+3+2+6−1)/5=>2.2
- The average of next 5 numbers (subarray from index 1-5) is:(3+2+6−1+4)/5=>2.8
- For the next 5 numbers (subarray from index 2-6), the average is: (2+6−1+4+1)/5=>2.4

Here is the final output containing the averages of all contiguous subarrays of size 5:

```
Output: [2.2, 2.8, 2.4, 3.6, 2.8]
```

![img.png](img.png)

- [My Code](MyCode.java)
- [Solution](Solution.java)

