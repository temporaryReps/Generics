package compare;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class LengthComparatorTest {

    @Test
    public void testCompare() {
        List<String> s = Arrays.asList("aaa", "b", "cd");
        List<String> testList = Arrays.asList("b", "cd", "aaa");

        Collections.sort(s, new LengthComparator<>());
        assertEquals("Lists must have the same order of elements",
                s, testList);
    }
}