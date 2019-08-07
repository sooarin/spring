package org.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
public class HomeController {
 
    @RequestMapping("/")
    public String test(Model model) {
        model.addAttribute("serverTime", "Å×½ºÆ®" );        
        return "home";
    }    
    
}

