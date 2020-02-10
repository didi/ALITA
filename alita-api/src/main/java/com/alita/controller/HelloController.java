package com.alita.controller;

import com.alita.service.AlitaDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lydia
 * @version V1.0
 * @since 2019-11-07 20:28:11
 */
@RestController
public class HelloController {

    @Autowired
    private AlitaDataService alitaDataService;

    @RequestMapping("/index")
    public String index() {
        return "Greetings!";
    }

}
