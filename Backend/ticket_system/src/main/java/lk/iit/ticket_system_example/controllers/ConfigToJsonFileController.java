package lk.iit.ticket_system_example.controllers;



import lk.iit.ticket_system_example.Service.JsonFileWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigToJsonFileController {

    @Autowired
    private JsonFileWriter jsonFileWriter;

    @GetMapping("/save-config-to-json")
    public String saveConfigToJson() {
        try {
            jsonFileWriter.writeConfigToJsonFile();
            return "Configurations saved to config.json successfully!";
        } catch (Exception e) {
            return "Failed to save configurations: " + e.getMessage();
        }
    }
}

