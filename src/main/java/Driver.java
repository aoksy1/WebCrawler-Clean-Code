import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class Driver {
    public static void main(String[] args) throws IOException {

        WebCrawler webCrawler = new WebCrawler();

        webCrawler.crawl("https://forbes.com",3);
        //webCrawler.getHeading("https://forbes.com","h3");

        LinkedList<String> list = new LinkedList<String>();
        list=webCrawler.crawl("https://forbes.com",3);

    }
}
