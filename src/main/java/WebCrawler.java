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
    private String sourceLanguage;
    private String targetLanguage;
    private String website;
    private int givenDepth;

    public WebCrawler(Input input){
        urlLinks = new HashSet<>();
        sourceLanguage = input.getSourceLanguage();
        targetLanguage = input.getTargetLanguage();
        website = input.getWebsite();
        givenDepth = input.getDepth();
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
            if(i>0)foundHeadings.add("\n<br>"+arrowBuilder(depth)+" link to <a>" + foundUrl.get(i) + " </a>\n");
            for (String heading : Arrays.asList("h1", "h2", "h3", "h4", "h5", "h6")) {
                getHeading(foundUrl.get(i), heading);
            }
            urlLinks.add(pageUrl);
            depth++; i++;

            outputWriter();

            for (Element link : availableLinksOnPage){
                if(depth<crawlDepth)
                crawl(link.attr("abs:href"), crawlDepth);
                else break;
            }
        }
        return foundUrl;
    }

    public LinkedList<String> getHeading(String url, String requestedHeading) throws IOException {
        Document htmlFile = Jsoup.connect(url).get();
        Elements headingsOnPage = htmlFile.select(requestedHeading);

        int numberOfHeading1 = 1, numberOfHeading2 = 1, numberOfHeading3 = 1, numberOfHeading4 = 1, numberOfHeading5 = 1, numberOfHeading6 = 1;

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
        return foundHeadings;
    }

    private String headingBuilder(Element headingElement) throws IOException {
        return arrowBuilder(depth) + " " + translator.translate(headingElement.text(),sourceLanguage,targetLanguage) + " ";
    }

    private void outputWriter() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/output/output.md"));

        writer.write("input: <a>" + foundUrl.get(0) + " </a>\n");
        writer.write("<br>depth: " + depth + "\n");
        writer.write("<br>source language: " + sourceLanguage + "\n");
        writer.write("<br>target language: " + targetLanguage + "\n");
        writer.write("<br>summary: " + "\n");
        for (String heading : foundHeadings) {
            writer.write(heading+"\n");
        }
        writer.close();
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



//TODO --> Fix output lines so that at crawl depth 2 output is like # ----> Something 1.1.1