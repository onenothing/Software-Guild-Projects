package com.tsg.musicpagemvc;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adam Coate <adamcoate1@gmail.com>
 */
@Controller
public class musicController {
    
    @RequestMapping(value={"/", "home"}, method=RequestMethod.GET)
    public String displayHomePage(){
        return "home";
    }
}
