import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class WebCrawler {

    private final HashSet<String> urlLinks;
    private String sourceLanguage = "english";
    private String targetLanguage = "german";

    public WebCrawler(){
        urlLinks = new HashSet<>();
    }

    private int depth = 0, i = 0;
    LinkedList<String> foundUrl = new LinkedList<>();
    LinkedList<String> foundHeadings = new LinkedList<>();
    Translator translator = new Translator();


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
            depth++; i++;

            for (Element link : availableLinksOnPage){
                if(depth<crawlDepth)
                crawl(link.attr("abs:href"), crawlDepth);
                else break;
            }
        }
        return foundUrl;
    }

    public String[] getHeading(String url, String requestedHeading) throws IOException {
        Document htmlFile = Jsoup.connect(url).get();
        Elements headingsOnPage = htmlFile.select(requestedHeading);
        String[] headingOutput = new String[headingsOnPage.size()];

        int i = 0, numberOfHeading1 = 1, numberOfHeading2 = 1, numberOfHeading3 = 1, numberOfHeading4 = 1, numberOfHeading5 = 1, numberOfHeading6 = 1;

        for (Element heading : headingsOnPage){
            switch (requestedHeading) {
                case "h1" -> headingOutput[i] = "# " + "-->" + " " + translator.translate(heading.text(),sourceLanguage,targetLanguage) + " " + numberOfHeading1++;
                case "h2" -> headingOutput[i] = "## " + "-->" + " " + translator.translate(heading.text(),sourceLanguage,targetLanguage) + " " + numberOfHeading1 + "." + numberOfHeading2++;
                case "h3" -> headingOutput[i] = "### " + "-->" + " " + translator.translate(heading.text(),sourceLanguage,targetLanguage) + " " + numberOfHeading1 + "." + numberOfHeading2 + "." + numberOfHeading3++;
                case "h4" -> headingOutput[i] = "#### " + "-->" + " " + translator.translate(heading.text(),sourceLanguage,targetLanguage) + " " + numberOfHeading1 + "." + numberOfHeading2 + "." + numberOfHeading3 + "." + numberOfHeading4++;
                case "h5" -> headingOutput[i] = "##### " + "-->" + " " + translator.translate(heading.text(),sourceLanguage,targetLanguage) + " " + numberOfHeading1 + "." + numberOfHeading2 + "." + numberOfHeading3 + "." + numberOfHeading4 + "." + numberOfHeading5++;
                case "h6" -> headingOutput[i] = "###### " + "-->" + " " + translator.translate(heading.text(),sourceLanguage,targetLanguage) + " " + numberOfHeading1 + "." + numberOfHeading2 + "." + numberOfHeading3 + "." + numberOfHeading4 + "." + numberOfHeading5 + "." + numberOfHeading6++;
            }
            i++;
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/output/output.md"));
        for(String heading:headingOutput){
            writer.write(heading);
        }
        writer.write(Arrays.toString(headingOutput));
        writer.close();
        return headingOutput;
    }

    public String sentenceBuilder(String heading, int depthOfCrawl, String requestedHeading){
        StringBuilder stringBuffer = new StringBuilder();
        String arrow = "";
        if(depth==1) arrow=">";
        for(int i=0;i<2;i++){
            stringBuffer.append("-");
            stringBuffer.append(arrow);
            arrow=stringBuffer.toString();
        }
        return arrow;
    }
}

//TODO --> Fix output lines so that at crawl depth 2 output is like # ----> Something 1.1.1