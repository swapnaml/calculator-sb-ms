package com.lowes.swapna.controller;

import com.lowes.swapna.model.AirthOp;
import com.lowes.swapna.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    @Autowired
    CalculatorService cs;

    @GetMapping("/add")
    public Double add(@RequestParam("value1") Double value1, @RequestParam("value2") Double value2) {
      return cs.storeData(value1, value2, '+');
    }

    @GetMapping("/sub")
    public Double sub(@RequestParam("value1") Double value1, @RequestParam("value2") Double value2) {
       return cs.storeData(value1, value2, '-');
    }

    @GetMapping("/multiply")
    public Double multiply(@RequestParam("value1") Double value1, @RequestParam("value2") Double value2) {
        return cs.storeData(value1, value2, '*');
    }

    @GetMapping("/divide")
    public Double divide(@RequestParam("value1") Double value1, @RequestParam("value2") Double value2) throws Exception {
        if(value2==0) {
            System.out.println("Not able to download by zero");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Can't divide by zero");
        }

       return cs.storeData(value1, value2, '/');
    }

    @GetMapping("/data")
    public List<AirthOp> getData() throws Exception {

       return cs.getAllTheData();
    }

    @GetMapping("/healthCheck")
    public String healthCheck() {
        return "Connectivity Success";
    }

}
