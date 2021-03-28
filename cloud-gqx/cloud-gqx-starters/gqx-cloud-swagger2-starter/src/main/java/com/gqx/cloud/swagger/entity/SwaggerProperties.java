package com.gqx.cloud.swagger.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 */
@ConfigurationProperties(prefix = "cloud.gqx.swagger")
public class SwaggerProperties {

    private String basePackage = "com.gqx.cloud";

    private String title = "swagger-bootstrap-ui很棒~~~！！！";

    private String description = "<div style='font-size:14px;color:red;'>swagger-bootstrap-ui-demo RESTful APIs</div>";

    private String termsOfServiceUrl = "http://www.baidu.com/";

    private String version = "1.0";


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTermsOfServiceUrl() {
        return termsOfServiceUrl;
    }

    public void setTermsOfServiceUrl(String termsOfServiceUrl) {
        this.termsOfServiceUrl = termsOfServiceUrl;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }
}
