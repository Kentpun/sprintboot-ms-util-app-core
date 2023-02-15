package com.deloitte.core.utils;

import com.deloitte.core.entity.CdeId;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

//@Configuration
//@EntityScan("com.deloitte.core.entity.CdeId")
//@EnableJpaRepositories("com.deloitte.core.redis.CdeIdRepository")
@AllArgsConstructor
public class CdeIdUtil {

    private final CrudRepository<CdeId, String> cdeIdRepository;

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
        String uuid = cdeId.substring(14);
        Optional<CdeId> storedCdeIdObj = cdeIdRepository.findById(uuid);
        return storedCdeIdObj.isPresent();
    }
}
