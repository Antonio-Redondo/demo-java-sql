package com.example.demojavasql.repository.impl;

import com.example.demojavasql.data.BaseHibernateJPARepository;
import com.example.demojavasql.model.entity.Access;
import com.example.demojavasql.repository.AccessRepository;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arm on 28/01/2018.
 */
@Repository
public class EmployeeRepositoryImpl  extends BaseHibernateJPARepository<Access, Long> implements AccessRepository {

    @Override
    public Access findIp(String startDate, String endDate) {
        List<Access> list = new ArrayList<>();
        Query query = sessionFactory.getCurrentSession()
                .createSQLQuery("SELECT ip,COUNT(*) AS repetitions FROM ACCESS" +
                        " WHERE STARTDATE BETWEEN :startDate AND :endDate " +
                        " GROUP BY IP" +
                        " ORDER BY repetitions DESC" +
                        " LIMIT 1");

        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);

        return buildAcccessResposnse((Object[])query.uniqueResult());

    }

    /**
     * Method responsible of conveting the response from database as expected
     * @param obj object from database
     * @return Access access
     */
    private Access buildAcccessResposnse(Object[] obj) {
        Access access = new Access();
        if(obj != null){
            if(obj[0] != null){
                String ip = (String)obj[0];
                access.setIp(ip);
            }
            if(obj[1] != null){
                BigInteger repetitions = (BigInteger)obj[1];
                access.setRepetitions(repetitions.longValue());
            }
        }

        return  access;


    }


    }
