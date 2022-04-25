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

        System.out.println("Enter the website URL :");
        input.setWebsite(scanner.next());
        System.out.println("Enter the depth to crawl to :");
        input.setDepth(scanner.nextInt());
        System.out.println("What is the source language of the website :");
        input.setSourceLanguage(scanner.next());
        System.out.println("To which language do you wish to translate :");
        input.setTargetLanguage(scanner.next());

        WebCrawler webCrawler = new WebCrawler(input.getSourceLanguage(), input.getTargetLanguage());
        webCrawler.crawl(input.getWebsite(),input.getDepth());
    }
}
