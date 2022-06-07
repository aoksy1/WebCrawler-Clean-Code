package Multithreading;

import Input.Input;
import WebCrawler.WebCrawler;
import java.util.LinkedList;
import java.util.Scanner;

public class MultithreadedWebCrawler extends Thread{
    LinkedList<String> output = new LinkedList<>();
    WebCrawler webCrawler;

    @Override
    public void run(){
        getInput();
        webCrawler = new WebCrawler(input.getSourceLanguage(),input.getTargetLanguage());

        try {
            webCrawler.crawl(input.getWebsite(),input.getDepth());
        } catch (Exception e) {
            System.out.println("Cannot crawl on given website!");
        }
        finally {
            output = webCrawler.getOutputCacheList();
        }
    }

    private final Scanner scanner = new Scanner(System.in);
    final static Object syncObject = new Object();
    private Input input;

    private void getInput(){
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
