package br.com.storepcs.controller;


import br.com.storepcs.Service.PCService;
import br.com.storepcs.dto.PCDTO;
import br.com.storepcs.dto.PCResponsyBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private final PCService PC;

    public RestController(PCService service) {
        this.PC = service;
    }

    @GetMapping("/api/pcs")
    public ResponseEntity<PCResponsyBody> home() {
        List<PCDTO> allpcs = PC.findAll();
        PCResponsyBody pc1 = new PCResponsyBody(allpcs);
        return ResponseEntity.ok(pc1);
    }

    @PostMapping("/api/pcs")
    public ResponseEntity<PCDTO> createPc(@RequestBody PCDTO pc) {
        this.PC.save(pc);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/pcs/{id}")
    public ResponseEntity<PCDTO> deletePC(@PathVariable String id) {
        this.PC.deleteByID(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/pcs/{id}")
    public ResponseEntity<PCDTO> updatePC(@PathVariable String id, @RequestBody PCDTO pc) {
        this.PC.update(id, pc);
        return ResponseEntity.ok(pc);
    }

}
