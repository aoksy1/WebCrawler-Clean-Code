import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;

public class WebCrawler {

    private final HashSet<String> urlLinks;

    public WebCrawler() {
        urlLinks = new HashSet<>();
    }

    private int depth=0;
    private int i=0;
    LinkedList<String> foundUrl = new LinkedList<String>();
    public LinkedList<String> crawl(String pageUrl, int crawlDepth) throws IOException {
        Document htmlFile = Jsoup.connect(pageUrl).get();
        Elements availableLinksOnPage = htmlFile.select("a[href]");

        if(!urlLinks.contains(pageUrl) && depth<crawlDepth){
            foundUrl.add(pageUrl);
            System.out.println(foundUrl.get(i));
            getHeading(foundUrl.get(i),"h2");
            urlLinks.add(pageUrl);
            depth++;
            i++;

            for (Element link : availableLinksOnPage){
                if(depth<crawlDepth)
                crawl(link.attr("abs:href"), crawlDepth);
                else break;
            }
        }
        return foundUrl;
    }

    public String[] getHeading(String url,String requestedHeading) throws IOException {
        Document htmlFile = Jsoup.connect(url).get();
        Elements headingsOnPage = htmlFile.select(requestedHeading);
        String[] headingOutput = new String[headingsOnPage.size()];
        int i=0;
        for (Element heading : headingsOnPage){
            System.out.println(heading.text());
            headingOutput[i] = heading.text();
            i++;
        }
        return headingOutput;
    }

}