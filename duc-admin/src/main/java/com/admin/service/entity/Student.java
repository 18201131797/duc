package com.admin.service.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@Builder
@Table(name = "t_student")
public class Student implements Serializable {

    private static final long serialVersionUID = 3238240651578897231L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private Integer id;

    private String name;
}