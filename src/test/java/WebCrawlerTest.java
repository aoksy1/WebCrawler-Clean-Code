import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebCrawlerTest {

    @Test
    public void getPageLinks() throws IOException {
        WebCrawler webCrawler = new WebCrawler("english","german");
        assertEquals(webCrawler.crawl("https://forbes.com", 3).get(1),"https://www.forbes.com/");
    }

    @Test
    public void getPageHeadings() throws IOException {
        WebCrawler webCrawler = new WebCrawler("english","german");
        assertEquals(webCrawler.getHeading("https://forbes.com","h3").get(0),"###  BREAKING 1.1.1");
    }

}