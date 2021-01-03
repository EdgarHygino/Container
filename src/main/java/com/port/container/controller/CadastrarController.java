package com.port.container.controller;

import com.port.container.model.Event;
import com.port.container.repository.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CadastrarController {

    @Autowired
    private EventRepository er;

    @RequestMapping(value="/cadastrarContainer", method = RequestMethod.GET)
    public String form(){
        return "event/formCadastro";
    }

    @RequestMapping(value="/cadastrarContainer", method = RequestMethod.POST)
    public String form(Event event){

        er.save(event);

        return "redirect:/cadastrarContainer";
    }
    @RequestMapping("/events")
    public ModelAndView listEvents(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<Event> events = er.findAll();
        mv.addObject("events", events);
        return mv;
    }

}
