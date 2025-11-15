package stringalgo;

import java.util.ArrayList;
import java.util.List;

/**
 * Rabin–Karp substring search using Polynomial Rolling Hash.
 * Searches for all occurrences of pattern in text.
 */
public class RabinKarp {

    private static final long MOD = (long)1e9 + 7;
    private static final long BASE = 131;

    public static List<Integer> search(String text, String pattern) {
        List<Integer> result = new ArrayList<>();

        int n = text.length();
        int m = pattern.length();
        if (m > n) return result;

        long pHash = 0;     // hash of pattern
        long tHash = 0;     // rolling hash of text window
        long power = 1;     // BASE^(m-1)

        // precompute BASE^(m-1)
        for (int i = 0; i < m - 1; i++) {
            power = (power * BASE) % MOD;
        }

        // compute initial hashes
        for (int i = 0; i < m; i++) {
            pHash = (pHash * BASE + pattern.charAt(i)) % MOD;
            tHash = (tHash * BASE + text.charAt(i)) % MOD;
        }

        // sliding window
        for (int i = 0; i <= n - m; i++) {

            // compare hashes
            if (pHash == tHash) {
                // verify with normal comparison to avoid collisions
                if (text.substring(i, i + m).equals(pattern)) {
                    result.add(i);
                }
            }

            if (i < n - m) {
                // remove left char, add new right char
                tHash = (tHash - text.charAt(i) * power % MOD + MOD) % MOD;
                tHash = (tHash * BASE + text.charAt(i + m)) % MOD;
            }
        }

        return result;
    }
}
