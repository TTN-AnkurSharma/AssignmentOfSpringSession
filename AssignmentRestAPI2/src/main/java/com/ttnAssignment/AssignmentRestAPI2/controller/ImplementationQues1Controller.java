package com.ttnAssignment.AssignmentRestAPI2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/* Controller for ques 1 to create a GET request which takes "username" as param
and shows a localized message "Hello Username". */
@RestController
public class ImplementationQues1Controller {
    @Autowired
    private MessageSource messageSource;//create message source

    @GetMapping("/greet")
    public String greetMessage(@RequestParam String username)
    {
        Locale locale= LocaleContextHolder.getLocale();//to get locale
       return messageSource.getMessage("bootcamp.greet",
               new String[]{username},
               "Ankur",
               locale);

    }
}
