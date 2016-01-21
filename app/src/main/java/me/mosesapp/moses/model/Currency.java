package me.mosesapp.moses.model;

/**
 * Created by thiago on 1/18/16.
 */
public class Currency {
    private String prefix;
    private String description;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return prefix;
    }
}
