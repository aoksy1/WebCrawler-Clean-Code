import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;

public class WebCrawler {

    private final HashSet<String> urlLinks;

    public WebCrawler() {
        urlLinks = new HashSet<>();
    }

    private int depth=0;
    private String foundUrl="";

    public String crawl(String pageUrl, int crawlDepth){

        if(!urlLinks.contains(pageUrl) && depth<crawlDepth){
            foundUrl = pageUrl;
            System.out.println(foundUrl);
            try {
                urlLinks.add(pageUrl);
                Document htmlFile = Jsoup.connect(pageUrl).get();
                Elements availableLinksOnPage = htmlFile.select("a[href]");
                depth++;
                for (Element link : availableLinksOnPage){
                    crawl(link.attr("abs:href"), crawlDepth);
                }
            }
            catch (IOException exception){
                System.err.println("For "+pageUrl+": "+exception.getMessage());
            }
        }
        return foundUrl;
    }

}