package ru.spring_boot;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class WebController {
//    private static final Logger LOG = LogManager.getLogger(WebController.class);
    private static final Logger LOG = LoggerFactory.getLogger(WebController.class);

    @GetMapping("/")
    public String main() {
        return "Hello world";
    }

    //    <artifactId>spring-boot-starter-thymeleaf</artifactId>
    @GetMapping(value = {"/hello", "/greeting1"})
    public String hello(
            @RequestParam(
                    name = "name",
                    required = false,
                    defaultValue = "World") String name,
            Model model) {
        model.addAttribute("name", name);
        LOG.info("Вызов через Thymeleaf");
        return "greetingThymeleaf";
    }


//    <artifactId>spring-boot-starter-mustache</artifactId>
    @GetMapping("/greeting2")
    public String greeting2(
            @RequestParam(
                    name = "name",
                    required = false,
                    defaultValue = "World") String name,
            Map<String, Object> model) {
        model.put("name", name);
        LOG.info("Вызов через Mustache");
        return "greetingMustache";
    }

}
