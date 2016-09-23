package com.herazade.sachalert.web.controller;

import java.util.Locale;

import org.jboss.logging.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.herazade.sachalert.web.dto.MessageHook;
import com.herazade.sachalert.web.dto.PokemonHook;

@RestController
@RequestMapping("/webhook")
public class HookController {

	private Logger logger = LoggerFactory.getLogger(getClass());


	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void pokemonWebHook(@RequestBody PokemonHook hook) {

		if (hook.getType().equals("pokemon")) {

			MessageHook msg = hook.getMessage();
			if (msg != null) {

			}
		}

	}


}
