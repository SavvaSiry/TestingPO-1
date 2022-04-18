package part3;

import org.junit.Assert;
import org.junit.Test;

public class HeadTest {

    @Test
    public void headNameTest(){
        String name = "Арчи";
        Head head = new Head(name);
        Assert.assertEquals(head.getName(), name);
    }

    @Test
    public void headJawTest(){
        String name = "Арчи";
        Head head = new Head(name);
        Assert.assertFalse(head.getJaw().isDropped());
        head.getJaw().drop();
        Assert.assertTrue(head.getJaw().isDropped());
    }
}
