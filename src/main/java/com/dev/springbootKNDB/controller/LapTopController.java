package com.dev.springbootKNDB.controller;

import com.dev.springbootKNDB.dto.LapTopRequest;
import com.dev.springbootKNDB.dto.LapTopResponse;
import com.dev.springbootKNDB.entity.LapTop;
import com.dev.springbootKNDB.service.LapTopService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LapTopController {
    @Autowired
    private LapTopService lapTopService;

    @PostMapping("/create")
    public LapTopResponse createLapTop(@RequestBody @Valid LapTopRequest request){
        return lapTopService.createLapTop(request);
    }
    @GetMapping("/data")
    public List<LapTop> getAll(){
        return lapTopService.getAll();
    }

    @GetMapping("/data/{id}")
    public LapTop getOne(@PathVariable String id){
        return lapTopService.getOne(id);
    }

    @DeleteMapping("/data/{id}")
    public void deleteLapTop(@PathVariable String id){
        lapTopService.deleteLapTop(id);
    }

    @PutMapping("/data/{id}")
    public LapTop updateLapTop(@PathVariable String id, @RequestBody LapTopRequest request){
        return lapTopService.updateLapTop(id,request);
    }

    @GetMapping("/laptops")
    public Page<LapTop> getAllLaptops(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "3") int size) {
        return lapTopService.getLapTops(page, size);
    }
}
