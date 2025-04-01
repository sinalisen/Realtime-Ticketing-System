package lk.iit.ticket_system_example.Service;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class JsonReader {

    public JsonNode readConfigFromJsonFile() throws IOException {
        File jsonFile = new File("config.json");
        if (!jsonFile.exists()) {
            throw new IOException("Config file not found.");
        }

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readTree(jsonFile);
    }
}

