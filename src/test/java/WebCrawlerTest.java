import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WebCrawlerTest {

    @Test

    public void getPageLinks(){
        WebCrawler webCrawler = new WebCrawler();
        Assertions.assertEquals(webCrawler.crawl("https://forbes.com",2),"https://www.forbes.com/");
    }

}