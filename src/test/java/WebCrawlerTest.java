import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WebCrawlerTest {
    WebCrawler webCrawler = new WebCrawler();

    @Test
    public void getPageLinks() throws IOException {
        assertEquals(webCrawler.crawl("https://forbes.com", 3).get(1),"https://www.forbes.com/  ");
    }

    @Test
    public void getPageHeadings() throws IOException {
        assertEquals(webCrawler.getHeading("https://forbes.com","h3")[1],"Breaking");
    }

}