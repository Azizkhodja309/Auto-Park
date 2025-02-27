package com.example.controller;

import com.example.model.entity.AutoPark;
import com.example.model.DTO.parkDTO.ParkCreateDto;
import com.example.service.AutoParkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/park")
public class ParkController {

    private final AutoParkService autoParkService;

    public ParkController(AutoParkService autoParkService) {
        this.autoParkService = autoParkService;
    }

    @GetMapping("/")
    public String park(Model model){
        List<AutoPark> parkList = autoParkService.getAll();
        parkList.sort(Comparator.comparing(AutoPark::getId).reversed());
        model.addAttribute("parkList", parkList);

        return "park/parks";
    }

    @GetMapping("/create")
    public String create(){
        return "/park/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute ParkCreateDto parkDto) {
        autoParkService.create(parkDto);
        return "redirect:/park";
    }
}
