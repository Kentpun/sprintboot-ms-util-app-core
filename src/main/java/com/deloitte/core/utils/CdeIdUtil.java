package com.deloitte.core.utils;

import com.deloitte.core.entity.CdeId;
import com.deloitte.core.redis.CdeIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Configuration
public class CdeIdUtil {

    @Autowired
    private CdeIdRepository cdeIdRepository;

    public String generateCdeId(String type){
        CdeId.Type typeObj = CdeId.Type.valueOf(type);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String dateTimeString = formatter.format(date);
        CdeId cdeIdEntity = new CdeId(typeObj, dateTimeString);
        cdeIdRepository.save(cdeIdEntity);

        Optional<CdeId> storedCdeIdObj = cdeIdRepository.findById(cdeIdEntity.getUuid());
        return storedCdeIdObj.map(cdeId -> cdeId.getType().toString() + cdeId.getDateTimeString() + cdeId.getUuid()).orElse(null);
    }

    public boolean validateCdeId(String cdeId){
//        CdeId.Type type = CdeId.Type.valueOf(cdeId.substring(0, 2));
//        String dateTimeString = cdeId.substring(2, 14);
        String uuid = cdeId.substring(14);
        Optional<CdeId> storedCdeIdObj = cdeIdRepository.findById(uuid);
        return storedCdeIdObj.isPresent();
    }
}
