package com.coverity.testsuite;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    // By default we go to the EL tests.
    @GetMapping(value = "/")
    public String index(Model model) {
        return "test-el";
    }

    @GetMapping(value = "/el")
    public String testEL(Model model) {
        return "test-el";
    }
    
    @GetMapping(value = "/scriptlet")
    public String testJSP(Model model) {
        return "test-jsp";
    }
}
 
