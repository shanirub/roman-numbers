import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;

import java.util.*;

import static org.junit.Assert.*;


/* assuming legal string of a roman number:
* I - V - I
* I - X - I
* X - L - X
* X - C - X
* C - D - C
* C - M - C
* */

@RunWith(Parameterized.class)
public class Tests {

    @Parameterized.Parameter(0)
    public String roman;

    @Parameterized.Parameter(1)
    public int dec;

    @Parameterized.Parameters(name= "{index}: roman {0} => decimal {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "", 0 },
                { "I", 1 },
                { "IV", 4 },
                { "VI", 6 },
                { "IX", 9 },
                { "XI", 11},
                { "XL", 40 },
                { "LX", 60 },
                { "MDC", 1600 },
                { "CMV", 905 },
                { "XLII", 42 },
                { "XCIX", 99 },
                { "MMXIII", 2013 },
                { "MCDXCII", 1492 },
                { "MCMLXXXIV", 1984 }
        });
    }

    @Test
    public void checkOne() {
        assertEquals(dec, RomanNumbers.romanToDec(roman));
    }


}
