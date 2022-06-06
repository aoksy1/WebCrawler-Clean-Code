import java.io.IOException;
import java.util.Scanner;

public class DriverMultithread extends Thread{

    @Override
    public void run(){
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

        WebCrawler webCrawler = new WebCrawler(input.getSourceLanguage(),input.getTargetLanguage());
        try {
            webCrawler.crawl(input.getWebsite(),input.getDepth());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
