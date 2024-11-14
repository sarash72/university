package com.example.university.controller;

import com.example.university.controller.dto.MasterDto;
import com.example.university.service.MasterService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;


/**
 * Created by shirdel on 9/15/2024.
 */

@RestController
@RequestMapping(path = "/Master")
public class MasterController {

    MasterService masterService;

    @PostMapping("/addMaster")
    public void addAppointmentService(@RequestParam MasterDto masterDto) throws ParseException {
        masterService.addMasterService(masterDto);
    }

}