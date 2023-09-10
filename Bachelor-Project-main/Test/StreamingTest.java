import org.junit.Test;
import org.junit.*;
import org.junit.jupiter.api.BeforeEach;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class StreamingTest {
    private StreamAlgorithm alg;

    @BeforeEach
    public void setUp() {
        alg = new StreamAlgorithm();
    }

    @Test
    public void TestFor2Dimensions() {
        alg = new StreamAlgorithm();
        double[][] testArr =  {{1, 1}, {2, 2}};
        double[] resArr = {1,1};
        alg.setDimensions(2);
        alg.SetP(testArr);
        N_sphere h = alg.SimpleStreaming();
        assertThat(h.getCenter(), is(resArr));
        assertThat(h.getRadius(), is(0.5));
    }
}