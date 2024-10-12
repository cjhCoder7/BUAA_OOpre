import org.junit.Test;

import static org.junit.Assert.*;

public class FragmentTest {
    @Test
    public void getName() {
        Fragment fragment = new Fragment(1, "fragment");
        assertEquals("fragment", fragment.getName());
    }
}