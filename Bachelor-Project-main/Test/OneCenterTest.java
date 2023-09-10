import org.junit.Test;
import org.junit.*;
import org.junit.jupiter.api.BeforeEach;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class OneCenterTest {
    private OneCenterAlgorithm alg;

    @BeforeEach
    public void setUp() {
        alg = new OneCenterAlgorithm();
    }

    @Test
    public void TestFor2Dimensions() {
        double[][] testArr =  {{1, 1}, {2, 2}};
        double[] resArr = {1,1};
        alg.setDimension(2);
        alg.setP(testArr);
        N_sphere h = alg.Algorithm(5);
        //assertThat(h.getCenter(), is(resArr));
        assertThat(h.getRadius(), is(0.5));
    }
    
}
