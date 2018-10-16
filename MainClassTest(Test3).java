import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass
{
    @Test
    public void testGetClassString() {
       String  a = this.getClassString();
        Assert.assertTrue( "Выражение не содержит hello и Hello",a.contains("hello")||a.contains("Hello"));
    }
}
