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
    LinkedList<String> foundUrl = new LinkedList<>();
    public LinkedList<String> crawl(String pageUrl, int crawlDepth) throws IOException {
        Document htmlFile = Jsoup.connect(pageUrl).get();
        Elements availableLinksOnPage = htmlFile.select("a[href]");

        if(!urlLinks.contains(pageUrl) && depth<crawlDepth){
            foundUrl.add(pageUrl);
            System.out.println(foundUrl.get(i));
            getHeading(foundUrl.get(i),"h1");
            getHeading(foundUrl.get(i),"h2");
            getHeading(foundUrl.get(i),"h3");
            getHeading(foundUrl.get(i),"h4");
            getHeading(foundUrl.get(i),"h5");
            getHeading(foundUrl.get(i),"h6");
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
        int numberOfHeading1 = 1;
        int numberOfHeading2 = 1;
        int numberOfHeading3 = 1;
        int numberOfHeading4 = 1;
        int numberOfHeading5 = 1;
        int numberOfHeading6 = 1;

        for (Element heading : headingsOnPage){
            switch (requestedHeading) {
                case "h1" -> {
                    headingOutput[i] = "# " + arrowBuilder(depth*2) + " " + heading.text() + " " + numberOfHeading1;
                    numberOfHeading1++;

                    System.out.println(headingOutput[i]);
                }
                case "h2" -> {
                    headingOutput[i] = "## " + arrowBuilder(depth*2) + " " + heading.text() + " " + numberOfHeading1 + "." + numberOfHeading2;
                    numberOfHeading2++;

                    System.out.println(headingOutput[i]);
                }
                case "h3" -> {
                    headingOutput[i] = "### " + arrowBuilder(depth*2) + " " + heading.text() + " " + numberOfHeading1 + "." + numberOfHeading2 + "." + numberOfHeading3;
                    numberOfHeading3++;

                    System.out.println(headingOutput[i]);
                }
                case "h4" -> {
                    headingOutput[i] = "#### " + arrowBuilder(depth*2) + " " + heading.text() + " " + numberOfHeading1 + "." + numberOfHeading2 + "." + numberOfHeading3 + "." + numberOfHeading4;
                    numberOfHeading4++;

                    System.out.println(headingOutput[i]);
                }
                case "h5" -> {
                    headingOutput[i] = "##### " + arrowBuilder(depth*2) + " " + heading.text() + " " + numberOfHeading1 + "." + numberOfHeading2 + "." + numberOfHeading3 + "." + numberOfHeading4 + "." + numberOfHeading5;
                    numberOfHeading5++;

                    System.out.println(headingOutput[i]);
                }
                case "h6" -> {
                    headingOutput[i] = "###### " + arrowBuilder(depth*2) + " " + heading.text() + " " + numberOfHeading1 + "." + numberOfHeading2 + "." + numberOfHeading3 + "." + numberOfHeading4 + "." + numberOfHeading5 + "." + numberOfHeading6;
                    numberOfHeading6++;

                    System.out.println(headingOutput[i]);
                }
            }
            i++;
        }
        return headingOutput;
    }

    public String arrowBuilder(int countOfMinuses){
        StringBuilder stringBuffer = new StringBuilder();
        String arrow = "";

        for(int i=1;i<countOfMinuses;i++){
            if(depth==1) arrow=">";
            stringBuffer.append("-");
            stringBuffer.append(arrow);
            arrow=stringBuffer.toString();
        }
        return arrow;
    }

}

//TODO --> Fix output lines so that at crawl depth 2 output is like # ----> Something 1.1.1