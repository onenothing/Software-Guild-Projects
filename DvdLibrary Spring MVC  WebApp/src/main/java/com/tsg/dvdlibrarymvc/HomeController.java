/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.dvdlibrarymvc;

import static org.aspectj.weaver.MemberImpl.method;
import static org.springframework.http.RequestEntity.method;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Adam Coate <adamcoate1@gmail.com>
 */

@Controller
public class HomeController {
    @RequestMapping(value={"/","/home"}, method=RequestMethod.GET)
    public String displayHomePage(){
        return "home";
        
    }
    
    @RequestMapping(value = "/rest", method = RequestMethod.GET)
    public String displayRestPage() {
        return "rest";
    }
}
