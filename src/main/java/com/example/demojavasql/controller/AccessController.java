package com.example.demojavasql.controller;

import com.example.demojavasql.api.APIResponse;
import com.example.demojavasql.dto.AccessDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import  com.example.demojavasql.service.AccessService;
import java.util.List;

/**
 * Created by arm on 29/01/2018.
 */
@Controller
@RequestMapping("/access")
public class AccessController {

    @Autowired
    private AccessService accessService;


    private static Logger LOG = LoggerFactory.getLogger(AccessController.class);
    protected static final String JSON_API_CONTENT_HEADER = "Content-type=application/json";
    public static final String SUCCESS = "SUCCESS";



    @RequestMapping(value = "/findIp", method = RequestMethod.POST, headers = {JSON_API_CONTENT_HEADER})
    public @ResponseBody APIResponse findIp(@RequestBody AccessDTO accessDTO) throws Exception {
        AccessDTO accessDTOResp = accessService.findIp(accessDTO.getStartDateString()
                , accessDTO.getTime(),accessDTO.getDuration(),accessDTO.getThreshold());
        return APIResponse.toOkResponse(accessDTOResp.getMessage());
    }



}
