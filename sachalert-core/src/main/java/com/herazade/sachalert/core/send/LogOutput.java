package com.herazade.sachalert.core.send;

import java.io.IOException;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.herazade.sachalert.api.AlertSender;
import com.herazade.sachalert.api.PokemonAlert;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class LogOutput implements AlertSender {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private String messageTemplate = "";


	/**
	 * Freemarker Config
	 */
	private Configuration cfg;

	private static final String POKEMONTEMPLATE = "pokemon";

	public LogOutput() {
		cfg = new Configuration(Configuration.VERSION_2_3_0);
		StringTemplateLoader templateLoader = new StringTemplateLoader();
		templateLoader.putTemplate(POKEMONTEMPLATE, messageTemplate);
		cfg.setTemplateLoader(templateLoader);
	}

	public boolean send(PokemonAlert alert) {

		try {
			Template template = cfg.getTemplate(POKEMONTEMPLATE);
			StringWriter sringWriter = new StringWriter();
			template.process(alert, sringWriter);

			logger.info("Alert : {}", sringWriter.toString());
			return true;

		} catch (IOException | TemplateException e) {
			logger.error("Error", e);
			return false;
		}

	}

	public void setMessageTemplate(String messageTemplate) {
		StringTemplateLoader templateLoader = StringTemplateLoader.class.cast(cfg.getTemplateLoader());
		templateLoader.putTemplate(POKEMONTEMPLATE, messageTemplate);
	}

	public String getMessageTemplate() {
		return messageTemplate;
	}

}
