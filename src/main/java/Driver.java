public class Driver{
    public static void main(String[] args) throws Exception {
        DriverMultithread firstThread = new DriverMultithread();
        DriverMultithread secondThread = new DriverMultithread();

        firstThread.start();
        secondThread.start();
    }
}
