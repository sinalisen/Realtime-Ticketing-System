package lk.iit.ticket_system_example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "config_info")
public class Configuration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "config_name")
    private String configName;

    @Column(name = "config_parameter")
    private String configParameter;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public String getConfigParameter() {
        return configParameter;
    }

    public void setConfigParameter(String configParameter) {
        this.configParameter = configParameter;
    }
}