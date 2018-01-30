package com.example.demojavasql.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * Created by arm on 27/01/2018.
 */
@Getter
@Setter
@ToString
public class AccessDTO {




    private String startDateString;

    private String time;

    private long duration;

    private long threshold;

    private String message;

}
