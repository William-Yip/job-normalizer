import com.jobnormalizer.Normalizer;
import com.jobnormalizer.ScoreTextCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class NormalizerTest {

    private Normalizer normalizer;

    private ScoreTextCalculator scoreTextCalculator;

    @BeforeEach
    public void setUp() {
        this.scoreTextCalculator = Mockito.mock(ScoreTextCalculator.class);
        this.normalizer = new Normalizer(this.scoreTextCalculator);

        when(scoreTextCalculator.compare(anyString(), anyString())).thenReturn(Integer.MAX_VALUE);
    }

    @Test
    public void testNormalize() {
        String inputStr = "Java engineer";
        String normalizedStr = "Software engineer";
        when(scoreTextCalculator.compare(inputStr.toLowerCase(), normalizedStr.toLowerCase())).thenReturn(1);

        assertEquals(normalizedStr, normalizer.normalize(inputStr));
    }

    @Test
    public void testNormalizeWithEmptyString() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> normalizer.normalize(""));

        assertEquals("Job title cannot be null or empty", ex.getMessage());
    }

    @Test
    public void testNormalizeWithNull() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> normalizer.normalize(null));

        assertEquals("Job title cannot be null or empty", ex.getMessage());
    }

}
