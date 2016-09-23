package com.herazade.sachalert.com.config;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import com.herazade.sachalert.core.AlertConfiguration;

@Import(AlertConfiguration.class)
@ImportResource({"classpath:alertSample.xml", "classpath:scenarii.xml"})
public class TestAlertConfiguration {

}
