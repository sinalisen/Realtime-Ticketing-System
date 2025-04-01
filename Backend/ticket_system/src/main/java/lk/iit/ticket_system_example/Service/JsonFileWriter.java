package lk.iit.ticket_system_example.Service;


import java.io.FileWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lk.iit.ticket_system_example.database.ConfigurationRepository;
import lk.iit.ticket_system_example.model.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class JsonFileWriter {

    @Autowired
    private ConfigurationRepository configurationRepository;

    public void writeConfigToJsonFile() throws IOException {
        List<Configuration> configurations = configurationRepository.findAll();

        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode arrayNode = objectMapper.createArrayNode();

        for (Configuration config : configurations) {
            ObjectNode configNode = objectMapper.createObjectNode();
            configNode.put("configName", config.getConfigName());
            configNode.put("configParameter", config.getConfigParameter());
            arrayNode.add(configNode);
        }

        File jsonFile = new File("config.json");
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, arrayNode);
    }
}
