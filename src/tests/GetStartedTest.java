package tests;

import lib.CoreTestCase;
import org.junit.Test;

public class GetStartedTest extends CoreTestCase
{
    @Test
    public void testPassThroughWelcome()
    {
        if (this.Platform.isAndroid()) {
            return;
        }
    }
}
