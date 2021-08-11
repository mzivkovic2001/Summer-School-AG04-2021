package com.agency04.sbss.pizza.rest;
import com.agency04.sbss.pizza.model.PizzeriaInfo;
import com.agency04.sbss.pizza.model.PizzeriaMenu;
import com.agency04.sbss.pizza.service.IPizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pizzeria")
public class PizzeriaController {
    @Autowired
    private IPizzeriaService pizzeriaService;

    @GetMapping("/menu")
    public ResponseEntity<PizzeriaMenu> getMenu() {
        return new ResponseEntity<>(pizzeriaService.getPizzeriaMenu(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<PizzeriaInfo> getPizzeriaInfo() {
        return new ResponseEntity<>(pizzeriaService.getPizzeriaInfo(), HttpStatus.OK);
    }

}
