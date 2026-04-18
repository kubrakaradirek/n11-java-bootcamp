package n11.bootcamp.homework01.log;

public class ConsoleLogger implements ILogger {
    @Override
    public void log(String message) {
        // İlerleyen zamanlarda başka formatlar eklenebilir.
        System.out.println("[SİSTEM LOG] : " + message);
    }
}