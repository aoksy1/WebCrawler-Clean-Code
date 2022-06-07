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
        } catch (Exception e) {

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
           try{
               System.out.println("Enter the website URL :");
               input.setWebsite(scanner.next());
               System.out.println("Enter the depth to crawl to :");
               input.setDepth(scanner.nextInt());
               System.out.println("What is the source language of the website :");
               input.setSourceLanguage(scanner.next());
               System.out.println("To which language do you wish to translate :");
               input.setTargetLanguage(scanner.next());
               System.out.println();
           }
           catch (Exception e){
               System.out.println("Please double-check your input and try again");
               getInput();
           }

        }

    }

    public LinkedList<String> getOutputFromThread(){
        return output;
    }


}
