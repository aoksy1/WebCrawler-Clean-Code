public class Driver {
    public static void main(String[] args) {

        WebCrawler webCrawler = new WebCrawler();

        //String[] links = webCrawler.getPageLinks("https://forbes.com",3);

        webCrawler.crawl("https://forbes.com/",3);

    }
}
