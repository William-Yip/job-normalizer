import static org.junit.jupiter.api.Assertions.*;

import com.jobnormalizer.LevenshteinScoreText;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LevenshteinScoreTextTest {

    private LevenshteinScoreText levenshteinScoreText;

    @BeforeEach
    public void setUp() {
        levenshteinScoreText = new LevenshteinScoreText();
    }

    @Test
    public void testCompare_SameStrings() {
        String str1 = "hello";
        String str2 = "hello";
        int result = levenshteinScoreText.compare(str1, str2);
        assertEquals(0, result, "Comparing identical strings should return 0");
    }

    @Test
    public void testCompare_DifferentStrings() {
        String str1 = "kitten";
        String str2 = "sitting";
        int result = levenshteinScoreText.compare(str1, str2);
        assertEquals(3, result, "Comparing 'kitten' and 'sitting' should return 3");
    }

    @Test
    public void testCompare_EmptyString1() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> levenshteinScoreText.compare("", "test"));
        assertEquals("str1 and str2 args cannot be null or empty.", exception.getMessage());
    }

    @Test
    public void testCompare_EmptyString2() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> levenshteinScoreText.compare("test", ""));
        assertEquals("str1 and str2 args cannot be null or empty.", exception.getMessage());
    }

    @Test
    public void testCompare_NullString1() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> levenshteinScoreText.compare(null, "test"));
        assertEquals("str1 and str2 args cannot be null or empty.", exception.getMessage());
    }

    @Test
    public void testCompare_NullString2() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> levenshteinScoreText.compare("test", null));
        assertEquals("str1 and str2 args cannot be null or empty.", exception.getMessage());
    }

    @Test
    public void testCompare_CompletelyDifferentStrings() {
        String str1 = "abcd";
        String str2 = "wxyz";
        int result = levenshteinScoreText.compare(str1, str2);
        assertEquals(4, result, "Comparing 'abcd' and 'wxyz' should return 4");
    }

    @Test
    public void testCompare_CaseSensitivity() {
        String str1 = "Hello";
        String str2 = "hello";
        int result = levenshteinScoreText.compare(str1, str2);
        assertEquals(1, result, "Comparing 'Hello' and 'hello' should return 1 due to case difference");
    }
}
