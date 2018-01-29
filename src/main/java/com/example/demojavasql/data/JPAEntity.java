package com.example.demojavasql.data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * JPAEntity to declare fields to be in each entity table like id
 * and creational timestamps
 *
 * Created by Antonio Redondo on 28/01/2018.
 */
@MappedSuperclass
public abstract class JPAEntity<T extends Serializable> implements Entity {




    public JPAEntity() {

    }


    /**
     * To make XStream deserialization assign values to
     * base class fields of createdAt and updatedAt
     *
     * @return
     */
    public Object readResolve() {

        return this;
    }




}
