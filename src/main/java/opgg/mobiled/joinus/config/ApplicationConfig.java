package opgg.mobiled.joinus.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"opgg.mobiled.joinus.dao", "opgg.mobiled.joinus.service", "opgg.mobiled.joinus.controller"})
@Import({ DBConfig.class })
public class ApplicationConfig {

}
