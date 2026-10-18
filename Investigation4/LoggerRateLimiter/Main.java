package Investigation4.LoggerRateLimiter;
import java.util.Map;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Logger logger = new Logger();
        System.out.println(logger.shouldPrintMessage(1, "foo"));
        System.out.println(logger.shouldPrintMessage(2, "bar"));
        System.out.println(logger.shouldPrintMessage(3, "foo"));
        System.out.println(logger.shouldPrintMessage(8, "bar"));
        System.out.println(logger.shouldPrintMessage(10, "foo"));
        System.out.println(logger.shouldPrintMessage(11, "foo"));
    }
}

class Logger {

    private final Map<String, Integer> messageTimestamps;

    public Logger() {
        this.messageTimestamps = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer lastTimestamp = messageTimestamps.get(message);

        if (lastTimestamp != null) {

            if (timestamp - lastTimestamp >= 10) {
                messageTimestamps.put(message, timestamp);
                return true;
            }
            return false;
        }

        return messageTimestamps.putIfAbsent(message, timestamp) == null;
    }
}