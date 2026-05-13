package br.com.storepcs.controller;


import br.com.storepcs.Service.PCService;
import br.com.storepcs.dto.PCDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdimnController {


    private PCService s;

    @Autowired
    public AdimnController(PCService s)
    {
        this.s = s;
    }


    @GetMapping("/admin")
    public String adimnHome(Model m)
    {
     m.addAttribute("PCDTO", new PCDTO());

        return "Home";
    }

    @PostMapping("/admin/pcs")
    public String createPC(PCDTO PC)
    {

        if(PC.getId() != null && !PC.getId().isBlank())
        {
            s.update(PC.getId(),PC);

        }

        else
        {

            s.save(PC);

        }

        return "redirect:/admin/pcs";

    }


    @GetMapping("/admin/pcs")
    public String getpc(Model m)
    {
        List<PCDTO> pcs = s.findAll();
        m.addAttribute("PCS",pcs);
                return "DashboardADM";

    }


    @GetMapping("/admin/pcs/atualizar")
    public String atualizar(@RequestParam("id") String id, Model m)
    {
        PCDTO pc = s.findyById(id);

        if(pc == null)
        {

            return "redirect:/admin/pcs";
        }

        m.addAttribute("PCDTO", pc);

        return "Home";


    }

    @GetMapping("/admin/pcs/deletar")
    public String deletePC(@RequestParam("id")  String id, Model m)
    {
        s.deleteByID(id);

        List<PCDTO>

    }






}
