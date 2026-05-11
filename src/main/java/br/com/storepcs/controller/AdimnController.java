package br.com.storepcs.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdimnController {


    @GetMapping("/admin")
    public String adimn(){return "Home";}



}
