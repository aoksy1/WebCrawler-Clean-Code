import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebCrawlerTest {
    WebCrawler webCrawler = new WebCrawler("english","german");

    @Test
    public void getPageLinks() throws IOException {
        assertEquals(webCrawler.crawl("https://forbes.com", 3).get(1),"https://www.forbes.com/");
    }

    @Test
    public void getPageHeadings() throws IOException {
        assertEquals(webCrawler.getHeading("https://forbes.com","h3").get(0),"###  BREAKING 1.1.1");
    }

}