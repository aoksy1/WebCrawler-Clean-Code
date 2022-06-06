import java.io.BufferedWriter;
import java.io.FileWriter;

public class Driver{
    public static void main(String[] args) throws Exception {
        DriverMultithread firstThread = new DriverMultithread();
        DriverMultithread secondThread = new DriverMultithread();

        firstThread.start();
        secondThread.start();

        firstThread.join();
        secondThread.join();

        BufferedWriter writer = new BufferedWriter(new FileWriter("src/output/output.md"));

        for (String heading : firstThread.getOutputFromThread()) {
            writer.write(heading+"\n");
        }

        for (String heading : secondThread.getOutputFromThread()) {
            writer.write(heading+"\n");
        }
        writer.close();
    }
}
