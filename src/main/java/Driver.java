import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws IOException {
        Input input = new Input();
        Scanner scanner = new Scanner(System.in);

        input.setWebsite(scanner.next());
        input.setDepth(scanner.nextInt());
        input.setSourceLanguage(scanner.next());
        input.setTargetLanguage(scanner.next());

        WebCrawler webCrawler = new WebCrawler(input.getSourceLanguage(), input.getTargetLanguage());
        webCrawler.crawl(input.getWebsite(),input.getDepth());
    }
}
