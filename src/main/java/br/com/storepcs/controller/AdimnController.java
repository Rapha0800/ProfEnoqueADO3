package br.com.storepcs.controller;


import br.com.storepcs.Service.PCService;
import br.com.storepcs.dto.PCDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdimnController {


    private PCService s;

//    @Autowired
//    public AdimnController(PCService s)
//    {
//        this.s = s;
//    }


    @GetMapping("/admin")
    public String adimnHome(Model m)
    {
     m.addAttribute("PCDTO", new PCDTO());

        return "Home";
    }






}
