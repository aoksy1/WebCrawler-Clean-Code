import java.io.IOException;

public class AutoTest {
    public static void main(String[] args) throws IOException {
        InputTest inputTest = new InputTest();

        inputTest.setAndGetInputWebsite();
        inputTest.setAndGetInputDepth();
        inputTest.setAndGetInputSourceLanguage();
        inputTest.setAndGetInputTargetLanguage();

        TranslatorTest translatorTest = new TranslatorTest();

        translatorTest.getTextTranslated();
        translatorTest.getLanguage();

        WebCrawlerTest webCrawlerTest = new WebCrawlerTest();

        webCrawlerTest.getPageHeadings();
        webCrawlerTest.getPageLinks();
    }
}
