import Multithreading.MultithreadedWebCrawler;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MutithreadedWebCrawlerTest {
    @Test
    public void multithreadingTest() throws InterruptedException {
        MultithreadedWebCrawler threadOne = new MultithreadedWebCrawler();
        threadOne.start();
        threadOne.join();
        System.setIn(new ByteArrayInputStream("www.forbes.com".getBytes()));
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        System.setIn(new ByteArrayInputStream("english".getBytes()));
        System.setIn(new ByteArrayInputStream("german".getBytes()));

        assertEquals("Wow",threadOne.getOutputFromThread().get(0));
    }
}
