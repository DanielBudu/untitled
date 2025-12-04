package e1.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EventLogger {

    private static final String FILE_NAME = "thermostat.log";
    private static final List<String> log = new ArrayList<>();

    public static void write(String msg) {
        log.add(msg);

        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            fw.write(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + " - " + msg + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Error guardando log: " + e.getMessage());
        }
    }
}
