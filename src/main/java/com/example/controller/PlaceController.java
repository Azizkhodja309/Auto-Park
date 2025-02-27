package com.example.controller;

import com.example.model.DTO.placeDTO.PlaceDto;
import com.example.model.entity.Place;
import com.example.service.AutoParkService;
import com.example.service.FloorService;
import com.example.service.PlaceService;
import org.springframework.boot.autoconfigure.web.client.RestTemplateBuilderConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/place")
public class PlaceController {

    private final PlaceService placeService;
    private final FloorService floorService;

    public PlaceController(PlaceService placeService, FloorService floorService) {
        this.placeService = placeService;
        this.floorService = floorService;
    }

    @GetMapping("/{floorId}")
    public String places(@PathVariable Long floorId, Model model) {
        List<PlaceDto> placeList = placeService.getAllByFloorId(floorId);
        Long parkId = floorService.getById(floorId);
        model.addAttribute("floorId", floorId);
        model.addAttribute("parkId", parkId);
        model.addAttribute("placeList", placeList);
        return "place/places";
    }

    @GetMapping("/create/{floorId}")
    public String createPlace(@PathVariable Long floorId, Model model) {
        model.addAttribute("floorId", floorId);
        return "place/create";
    }

    @PostMapping("/create")
    public String createPlace(@ModelAttribute PlaceDto placeDto) {
        placeService.create(placeDto);
        return "redirect:/place/"+placeDto.getFloorId();
    }
}
