package com.example.demojavasql.service.impl;

import com.example.demojavasql.data.BaseJPAServiceImpl;
import com.example.demojavasql.dto.AccessDTO;
import com.example.demojavasql.model.entity.Access;
import com.example.demojavasql.repository.AccessRepository;
import com.example.demojavasql.service.AccessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by arm on 28/01/2018.
 */
@Service
@Transactional
public class AccessServiceImpl extends BaseJPAServiceImpl<Access, Long> implements AccessService{

    private static Logger LOG = LoggerFactory.getLogger(AccessServiceImpl.class);

    @Autowired
    private AccessRepository accessRepository;


    @Override
    public AccessDTO findIp(String startDate, String time, long duration, long threshold) throws ParseException {
        String[] startAndEndDate = calculateDates(startDate, time, duration);
        Access access = accessRepository.findIp(startAndEndDate[0], startAndEndDate[1]);
        return this.convertAccessToAccessDTO(access,threshold);
    }

    @Override
    public void setupService() {

    }

    private static AccessDTO convertAccessToAccessDTO(Access access,long threshold){
        AccessDTO accessDTO = new AccessDTO();
        if(access.getRepetitions()>=threshold){
            accessDTO.setMessage(access.getIp());
        }else if (access.getRepetitions() == 0){
            accessDTO.setMessage("There is no result for this particular request");
        }else {
            accessDTO.setMessage("The repeated ip for this range of time does not reach the minimum threshold");

        }
                return accessDTO;

    }

    private String[] calculateDates(String startDate, String time, long duration) throws ParseException{

        String[] startAndEndDates = new String[2];

        String completeTime = startDate + " " + time + ":00";
        String dateInString = completeTime;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = formatter.parse(dateInString);
        LocalDateTime ldt = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());


        LocalDateTime nextTime = ldt.plusHours(duration-1);
        Instant instant2 = nextTime.toInstant(ZoneOffset.UTC);
        Date expiryDate = Date.from(instant2);

        startAndEndDates[0] = formatter.format(date);
        startAndEndDates[1] = formatter.format(expiryDate);


        return startAndEndDates;
    }
}
