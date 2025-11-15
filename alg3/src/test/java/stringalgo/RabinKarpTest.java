package stringalgo;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class RabinKarpTest {

    @Test
    public void testShort() {
        String text = "hello";
        String pat = "ll";
        List<Integer> ans = RabinKarp.search(text, pat);
        assertEquals(List.of(2), ans);
    }

    @Test
    public void testMedium() {
        String text = "abacabadabacaba";
        String pat = "aba";
        List<Integer> ans = RabinKarp.search(text, pat);
        assertEquals(List.of(0, 4, 8, 12), ans);
    }

    @Test
    public void testLong() {
        String text = "aaaaa".repeat(1000); // 5000 chars
        String pat = "aaaa";
        List<Integer> ans = RabinKarp.search(text, pat);
        assertEquals(4997, ans.size());
    }
}
