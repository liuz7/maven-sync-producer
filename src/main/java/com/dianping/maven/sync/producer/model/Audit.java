package com.dianping.maven.sync.producer.model;

/**
 * Created by georgeliu on 2017/5/24.
 */
public class Audit {

    private String domain;
    private String type;
    private String context;
    private Attributes attributes;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "Audit{" +
                "domain='" + domain + '\'' +
                ", type='" + type + '\'' +
                ", context='" + context + '\'' +
                ", attributes=" + attributes +
                '}';
    }
}
