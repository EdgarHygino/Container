package com.port.container.controller;

import com.port.container.model.Event;
import com.port.container.model.Category;
import com.port.container.repository.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;

import javax.validation.Valid;

@Controller
public class CadastrarController {

    @Autowired
    private EventRepository er;

    @RequestMapping(value="/cadastrarContainer", method = RequestMethod.GET)
    public ModelAndView novo(Event event){
        ModelAndView mv = new ModelAndView("event/formCadastro");
        mv.addObject("categorys", Arrays.asList(Category.values()));
        return mv;
    }

    @RequestMapping(value="/cadastrarContainer", method = RequestMethod.POST)
    public ModelAndView salvar(@Valid Event event, BindingResult result,RedirectAttributes attributes){
        if (result.hasErrors()){
            return novo(event);
        }

        ModelAndView mv = new ModelAndView("redirect:/cadastrarContainer");
        attributes.addFlashAttribute("mensagem", "Container cadastrado com Sucesso.");
        return mv;
    }

    @RequestMapping("/events")
    public ModelAndView listEvents(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<Event> events = er.findAll();
        mv.addObject("events", events);
        return mv;
    }

    @RequestMapping("/{id}")
    public ModelAndView registerMovement (@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("event/registerMovement");
        Event event = er.findById(id);
        mv.addObject("Event", event);
        return mv;
    }

}

