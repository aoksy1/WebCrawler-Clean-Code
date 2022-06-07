import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class WebCrawler{

    private final HashSet<String> urlLinks;
    private final String sourceLanguage;
    private final String targetLanguage;
    private int currentDepth = 0, indexOfUrlList = 0;

    LinkedList<String> foundUrls = new LinkedList<>();
    LinkedList<String> foundHeadings = new LinkedList<>();
    Translator translator = new Translator();


    public WebCrawler(String inputSourceLanguage, String inputTargetLanguage){
        urlLinks = new HashSet<>();
        sourceLanguage = inputSourceLanguage;
        targetLanguage = inputTargetLanguage;
    }

    public LinkedList<String> crawl(String pageUrl, int crawlDepth){
        if(!urlLinks.contains(pageUrl) && currentDepth<crawlDepth){
            foundUrls.add(pageUrl);

            addHeadingZero();

            switchHeaders();

            urlLinks.add(pageUrl);

            increaseCurrentDepth();
            increaseIndexOfUrlList();

            outputCacher();

            getLinksFromList(pageUrl, crawlDepth);
        }
        return foundUrls;
    }

    private void addHeadingZero(){
        if(indexOfUrlList>0) foundHeadings.add("\n<br>"+arrowBuilder(currentDepth)+" link to <a>" + foundUrls.get(indexOfUrlList) + " </a>\n");
    }

    private void switchHeaders(){
        for (String heading : Arrays.asList("h1", "h2", "h3", "h4", "h5", "h6")) {
            getHeading(foundUrls.get(indexOfUrlList), heading);
        }
    }

    private void increaseCurrentDepth(){
        currentDepth++;
    }

    private void increaseIndexOfUrlList(){
        indexOfUrlList++;
    }

    private void getLinksFromList(String url, int crawlDepth)  {
        Elements availableLinksOnPage = getAllLinksFromHtmlFile(url);

        for (Element link : availableLinksOnPage){
            if(currentDepth<crawlDepth)
                crawl(link.attr("abs:href"), crawlDepth);
            else break;
        }
    }

    private Document getHtmlFile(String url) {
        try {
            return Jsoup.connect(url).get();
        }
        catch (Exception e){
            System.out.println("Please check the URL");
            return null;
        }
    }

    private Elements getAllLinksFromHtmlFile(String url) {
        Document htmlFile = getHtmlFile(url);

        return htmlFile.select("a[href]");
    }
    public LinkedList<String> getHeading(String url, String requestedHeading) {

        Elements headingsOnPage = getHeadingsFromHtmlFile(url, requestedHeading);

        addHeadingsToList(headingsOnPage, requestedHeading);

        return foundHeadings;
    }

    private Document createHtmlFile(String url)  {
        try{
            return Jsoup.connect(url).get();
        }
        catch (Exception e){
            System.out.println("URL Error. Please double-check the input");
            return null;
        }
    }

    private Elements getHeadingsFromHtmlFile(String url, String requestedHeading)  {
        Document htmlFile = createHtmlFile(url);

        return htmlFile.select(requestedHeading);
    }

    private int numberOfHeading1 = 1, numberOfHeading2 = 1, numberOfHeading3 = 1, numberOfHeading4 = 1, numberOfHeading5 = 1, numberOfHeading6 = 1;

    private void addHeadingsToList(Elements headingsOnPage, String requestedHeading) {
        for (Element heading : headingsOnPage){
            switch (requestedHeading) {
                case "h1" -> foundHeadings.add("# "+ headingBuilder(heading) + numberOfHeading1++);
                case "h2" -> foundHeadings.add("## " + headingBuilder(heading) + numberOfHeading1 + "." + numberOfHeading2++);
                case "h3" -> foundHeadings.add("### " + headingBuilder(heading) + numberOfHeading1 + "." + numberOfHeading2 + "." + numberOfHeading3++);
                case "h4" -> foundHeadings.add("#### " + headingBuilder(heading) + numberOfHeading1 + "." + numberOfHeading2 + "." + numberOfHeading3 + "." + numberOfHeading4++);
                case "h5" -> foundHeadings.add("##### " + headingBuilder(heading) + numberOfHeading1 + "." + numberOfHeading2 + "." + numberOfHeading3 + "." + numberOfHeading4 + "." + numberOfHeading5++);
                case "h6" -> foundHeadings.add("###### " + headingBuilder(heading) + numberOfHeading1 + "." + numberOfHeading2 + "." + numberOfHeading3 + "." + numberOfHeading4 + "." + numberOfHeading5 + "." + numberOfHeading6++);
            }
        }
    }

    private String headingBuilder(Element headingElement)  {
        return arrowBuilder(currentDepth) + " " + translator.translate(headingElement.text(),sourceLanguage,targetLanguage) + " ";
    }

    LinkedList<String> outputCacheList = new LinkedList<>();
    private void outputCacher(){
        outputCacheList.add("input: <a>" + foundUrls.get(0) + " </a>\n");
        outputCacheList.add("<br>depth: " + currentDepth + "\n");
        outputCacheList.add("<br>source language: " + sourceLanguage + "\n");
        outputCacheList.add("<br>target language: " + targetLanguage + "\n");
        outputCacheList.add("<br>summary: " + "\n");
        for (String heading : foundHeadings) {
            outputCacheList.add(heading+"\n");
        }
    }

    public LinkedList<String> getOutputCacheList(){
        return outputCacheList;
    }
    private String arrow = "";
    private String arrowBuilder(int crawlDepth){
        StringBuilder stringBuffer = new StringBuilder();
        if(crawlDepth>0)arrow=">";
        stringBuffer.append("--".repeat(Math.max(0, crawlDepth)));
        stringBuffer.append(arrow);
        arrow=stringBuffer.toString();
        return arrow;
    }
}