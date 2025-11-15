Report: Rabin–Karp String Matching Algorithm

Author: Suleymenov Nurbolat

1. Introduction

The purpose of this bonus project is to implement a classical string matching algorithm in Java and analyze its performance under different input sizes. For this work, I selected the Rabin–Karp algorithm, which is widely used for fast pattern matching using polynomial rolling hash.

The algorithm is efficient, elegant, and demonstrates the combination of hashing with sliding windows.

2. Algorithm Overview

Rabin–Karp converts each substring of the text into a numerical hash value.
Instead of comparing the whole substring with the pattern, the algorithm compares only hash values.
This drastically improves performance.

Key ideas:

Compute hash of the pattern.

Compute hash of the first window in the text.

Slide the window and update the hash in O(1) time.

If hashes match, perform exact string comparison to avoid collisions.

3. Implementation

The implementation uses:

BASE = 131

MOD = 1e9+7, a large prime to reduce collisions

Efficient rolling hash formula

Sliding window over the text

The code is structured into one class RabinKarp.java and a test class RabinKarpTest.java.

4. Testing

Three test categories were used:

Short string: "hello" vs "ll"

Medium string: "abacabadabacaba" vs "aba"

Long string: 5000 repeated characters "aaaa..."

All tests passed successfully and demonstrate correct and stable behavior.

5. Complexity Analysis
Complexity	Value
Time	O(n + m) average
Worst-case	O(n * m) (rare hash collisions)
Space	O(1) extra space + O(k) for found indices

The algorithm scales linearly with input size and performs extremely well in practice.

6. Conclusion

The Rabin–Karp implementation works correctly across all tested input sizes.
It efficiently handles both simple and repetitive patterns due to its rolling hash mechanism.

This project demonstrates:

Understanding of hashing

Efficient text processing

Clean Java implementation

Proper testing and analysis
