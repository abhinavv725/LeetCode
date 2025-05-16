import java.util.HashMap;
import java.util.Map;

public class Logger {

    private final Map<String, Integer> messageTimestamps;

    public Logger() {
        messageTimestamps = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!messageTimestamps.containsKey(message)) {
            messageTimestamps.put(message, timestamp);
            return true;
        }

        int lastPrinted = messageTimestamps.get(message);
        if (timestamp - lastPrinted >= 10) {
            messageTimestamps.put(message, timestamp);
            return true;
        }

        return false;
    }
}
