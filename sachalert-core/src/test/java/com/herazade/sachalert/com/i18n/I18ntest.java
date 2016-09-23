package com.herazade.sachalert.com.i18n;

import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class I18ntest {

	@Value("classpath:lang.fr")
	private Resource names;

	@Test
	public void test() {
		YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
		factory.setResources(names);
		Properties prop = factory.getObject();

		Assert.assertEquals("Carapuce", prop.getProperty("pokemon.name.7"));

	}

}
