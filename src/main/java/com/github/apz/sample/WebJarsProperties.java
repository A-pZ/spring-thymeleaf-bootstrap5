package com.github.apz.sample;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "webjars")
@Data
public class WebJarsProperties {
	private String bootstrap;
}
