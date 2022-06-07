import Multithreading.MultithreadedWebCrawler;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Driver{
    public static void main(String[] args) throws Exception {
        MultithreadedWebCrawler firstThread = new MultithreadedWebCrawler();
        MultithreadedWebCrawler secondThread = new MultithreadedWebCrawler();
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/output/output.md"));

        firstThread.start();
        secondThread.start();
        firstThread.join();
        secondThread.join();

        for (String heading : firstThread.getOutputFromThread()) {
            writer.write(heading+"\n");
        }
        for (String heading : secondThread.getOutputFromThread()) {
            writer.write(heading+"\n");
        }
        writer.close();
    }
}
