package br.com.storepcs.controller;


import br.com.storepcs.Service.PCService;
import br.com.storepcs.dto.PCDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {


    private PCService s;


    @Autowired
    public HomeController(PCService s)
    {
        this.s = s;

    }


    @GetMapping("/")
    public String Home()
    {
        return "redirect:/PCS";
    }

    @GetMapping("/PCS")
    public String getPCS(Model model)
    {
        List<PCDTO> allPCS = s.findAll();
        model.addAttribute("PCS", allPCS);
        return "Dashboard";

    }






}
