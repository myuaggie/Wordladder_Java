package com.wordladder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;

@Controller
public class WordladderController {
	@RequestMapping(value = "/input", method = RequestMethod.GET)
	   public ModelAndView wl() {
	      return new ModelAndView("input", "command", new Wordladder());
	   }   
	@RequestMapping(value = "/output", method = RequestMethod.POST)
	   public String wlr(@ModelAttribute("command")Wordladder wl, 
	   ModelMap model) {
	      model.addAttribute("res", wl.getRes());
	     
	      return "result";
		}
}
