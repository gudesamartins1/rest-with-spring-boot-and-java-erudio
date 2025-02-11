package br.com.gustavo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrettingController {
	
	public final static String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/gretting")
	public Gretting gretting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Gretting(counter.incrementAndGet(), String.format(template, name));
	}

}
