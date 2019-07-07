package com.mycclee.entity;

import javax.persistence.*;

/**
 * @author mycclee
 * @createTime 2019/7/7 11:24
 */
@Cacheable
@Table(name = "SSSP_DEPARTMENTS")
@Entity
public class Department {
    private Integer id;
    private String departName;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departName='" + departName + '\'' +
                '}';
    }
}
