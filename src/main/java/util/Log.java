package util;

import java.text.SimpleDateFormat;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.io.BufferedWriter;

public class Log {

    private static java.util.Date date;
    private static SimpleDateFormat sdf;

    public static void WriteLine(MessageType mType, String text) throws IOException {

        date = new java.util.Date();
        sdf = new SimpleDateFormat("HH:mm:ss");
        var logFile = "robot.log";

        try (var writer = new FileWriter(logFile, StandardCharsets.UTF_8, true);
             var buffer = new BufferedWriter(writer)) {

            switch(mType) {
                case INFO:
                    System.out.println("[INFO] [" + sdf.format(date) + "] " + text);
                    buffer.write("[INFO] [" + sdf.format(date) + "] " + text);
                break;
        
                case ERROR:
                    System.out.println("[ERROR] [" + sdf.format(date) + "] " + text);
                    buffer.write("[ERROR] [" + sdf.format(date) + "] " + text);
                break;
            }
        }
    }
}
