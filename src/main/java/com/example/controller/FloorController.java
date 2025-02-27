package com.example.controller;

import com.example.model.DTO.floorDTO.FloorCreateDTO;
import com.example.model.DTO.floorDTO.FloorDTO;
import com.example.service.FloorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/floor")
public class FloorController {
    private final FloorService floorService;

    public FloorController(FloorService floorService) {
        this.floorService = floorService;
    }

    @GetMapping("/{parkId}")
    public String floors(@PathVariable Long parkId, Model model) {
        List<FloorDTO> floors = floorService.getAllByParkId(parkId);
        model.addAttribute("parkId", parkId);
        model.addAttribute("floors", floors);
        return "floor/floors";
    }

    @GetMapping("/create")
    public String create(@RequestParam("parkId") Long parkId, Model model) {
        model.addAttribute("parkId", parkId);
        return "floor/create";
    }

    @PostMapping("/create")
    public String create(@RequestParam long parkId, @ModelAttribute FloorCreateDTO createDTO) {
        floorService.create(parkId, createDTO);
        return "redirect:/floor/"+parkId;
    }
}
