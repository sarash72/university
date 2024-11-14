package com.example.university.service.mapper;

import com.example.university.controller.dto.MasterDto;
import com.example.university.model.entity.Master;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MasterMapper {
    private final Logger logger = LoggerFactory.getLogger(MasterMapper.class);

    public Master convertMasterDtoToMaster(MasterDto masterDto){
        ModelMapper modelMapper = new ModelMapper();

        Master master=modelMapper.map(masterDto, Master.class);
        logger.debug(" masterDto converted to master in convertMasterDtoToMaster function with master :{} ",master.toString());
        return master;

    }
}
