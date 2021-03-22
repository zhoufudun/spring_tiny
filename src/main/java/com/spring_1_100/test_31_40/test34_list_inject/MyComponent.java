package com.spring_1_100.test_31_40.test34_list_inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyComponent {
    @Autowired(required = false)
    private List<Plugins> pluginsList;

    public List<Plugins> getPluginsList() {
        return pluginsList;
    }

    public void setPluginsList(List<Plugins> pluginsList) {
        this.pluginsList = pluginsList;
    }
}
