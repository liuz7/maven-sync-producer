package com.dianping.maven.sync.producer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by georgeliu on 2017/5/24.
 */
public class Attributes {

    @JsonProperty(value = "repository.name")
    private String repositoryName;
    private String format;
    private String name;

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Attributes{" +
                "repositoryName='" + repositoryName + '\'' +
                ", format='" + format + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
