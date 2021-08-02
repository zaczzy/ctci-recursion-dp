# Recursion

## when to use recursion
- "compute the nth"
- "list the first n"
- "compute all ... "

## dividing into subproblems
1. bottom-up:
starting from one two three, think on how one case builds off previous case.
2. top-down:
how to divide case N into subproblems.
3. half-and-half:
divide the data set in half. binary search, merge sort.

## iterative and recursive
recursive require at least O(n) space.
iterative complex.
Trade-off.

## DP & memoization
some call top-down dp memoization, only bottom-up dp.

When not sure how DP runtime goes with real call tree, imagine a tree that fills as wide as possible first before going deep. It's not the real call tree but it is a good estimate.