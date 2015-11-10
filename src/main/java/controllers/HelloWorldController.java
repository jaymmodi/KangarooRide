package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jmmodi on 11/9/2015.
 */

@Controller
public class HelloWorldController {

    @RequestMapping("/hello")
    public String goToHelloPage(Model model) {

        return "hello";

    }
}
