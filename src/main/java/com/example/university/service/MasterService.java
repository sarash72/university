package com.example.university.service;

import com.example.university.controller.dto.MasterDto;
import com.example.university.model.repository.MasterRepository;
import com.example.university.service.mapper.MasterMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;


@Service
@Transactional
public class MasterService {
    private final Logger logger = LoggerFactory.getLogger(MasterService.class);

    @Autowired
    private MasterRepository masterRepository;

    @Autowired
    private MasterMapper masterMapper;

    public void addMasterService(MasterDto masterDto) throws ParseException {
        masterRepository.save(masterMapper.convertMasterDtoToMaster(masterDto));
        logger.info("added new master :{}", masterDto.toString());

    }
}
