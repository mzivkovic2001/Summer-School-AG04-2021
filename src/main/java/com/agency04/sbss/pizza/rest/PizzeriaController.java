package com.agency04.sbss.pizza.rest;
import com.agency04.sbss.pizza.model.forms.PizzeriaInfoForm;
import com.agency04.sbss.pizza.model.forms.PizzeriaMenuForm;
import com.agency04.sbss.pizza.service.IPizzeriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pizzeria")
public class PizzeriaController {
    private IPizzeriaService pizzeriaService;

    public PizzeriaController(IPizzeriaService pizzeriaService) {
        this.pizzeriaService = pizzeriaService;
    }

    @GetMapping("/menu")
    public ResponseEntity<PizzeriaMenuForm> getMenu() {
        return new ResponseEntity<>(pizzeriaService.getPizzeriaMenu(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<PizzeriaInfoForm> getPizzeriaInfo() {
        return new ResponseEntity<>(pizzeriaService.getPizzeriaInfo(), HttpStatus.OK);
    }

}
