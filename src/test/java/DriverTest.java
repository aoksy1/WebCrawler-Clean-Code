import org.junit.jupiter.api.Test;

import java.io.IOException;

public class DriverTest {
    @Test
    public void driverTest() throws IOException {
        Input input = new Input();
        input.setWebsite("www.forbes.com");
        input.setDepth(3);
        input.setSourceLanguage("english");
        input.setTargetLanguage("german");
        WebCrawler webCrawler = new WebCrawler(input.getSourceLanguage(),input.getTargetLanguage());

        webCrawler.crawl(input.getWebsite(),input.getDepth());
    }
}
