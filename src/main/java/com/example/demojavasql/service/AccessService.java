package com.example.demojavasql.service;

import com.example.demojavasql.data.BaseService;
import com.example.demojavasql.dto.AccessDTO;
import com.example.demojavasql.model.entity.Access;


import java.text.ParseException;
import java.util.List;

/**
 * Created by arm on 28/01/2018.
 */
public interface AccessService extends BaseService<Access, Long> {


    /**
     * Method responsible of getting the particular ip
     * @param startDate
     * @param time
     * @param duration
     * @param threshold
     */
    public AccessDTO findIp(String startDate, String time, long duration, long threshold) throws ParseException;






}
