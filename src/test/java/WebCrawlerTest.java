import WebCrawler.WebCrawler;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebCrawlerTest {
    @Test
    public void getPageLinks(){
        WebCrawler webCrawler = new WebCrawler("english","german");
        assertEquals("https://www.forbes.com/",webCrawler.crawl("https://forbes.com", 3).get(1));
    }

    @Test
    public void getPageHeadings(){
        WebCrawler webCrawler = new WebCrawler("english","german");
        assertEquals("###  BREAKING 1.1.1",webCrawler.getHeading("https://forbes.com","h3").get(0));
    }
}