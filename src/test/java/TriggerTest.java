import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TriggerTest {

    @Test
    public void logic() {
        assertThat(new Trigger().logic(), is(1));
    }
}