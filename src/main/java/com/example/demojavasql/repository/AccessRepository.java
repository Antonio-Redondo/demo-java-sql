package com.example.demojavasql.repository;

import com.example.demojavasql.data.BaseJPARepository;
import com.example.demojavasql.model.entity.Access;
import java.util.List;

/**
 * Created by arm on 28/01/2018.
 */
public interface AccessRepository extends BaseJPARepository<Access, Long> {

    /**
     * Method in charge of getting all the employees from the database
     * @return List<Employee>
     */
    public Access findIp(String startDate, String endDate);


}
