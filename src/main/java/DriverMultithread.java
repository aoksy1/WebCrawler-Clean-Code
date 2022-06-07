import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class DriverMultithread extends Thread{
    LinkedList<String> output = new LinkedList<>();
    WebCrawler webCrawler;
    @Override
    public void run(){

        getInput();

        webCrawler = new WebCrawler(input.getSourceLanguage(),input.getTargetLanguage());

        try {
            webCrawler.crawl(input.getWebsite(),input.getDepth());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            output = webCrawler.getOutputCacheList();
        }
    }
    Input input;
    final static Object syncObject = new Object();
    public void getInput(){
        Scanner scanner = new Scanner(System.in);
        input=new Input();
        synchronized (syncObject){
            System.out.println("Enter the website URL :");
            input.setWebsite(scanner.next());
            System.out.println("Enter the depth to crawl to :");
            input.setDepth(scanner.nextInt());
            System.out.println("What is the source language of the website :");
            input.setSourceLanguage(scanner.next());
            System.out.println("To which language do you wish to translate :");
            input.setTargetLanguage(scanner.next());
        }

    }

    public LinkedList<String> getOutputFromThread(){
        return output;
    }


}
