package Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class EventLogger {

    private static final String FILE_NAME = "thermostat.log";

    public void write(String msg) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            fw.write(LocalDateTime.now() + " - " + msg + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Error guardando log: " + e.getMessage());
        }
    }
}
