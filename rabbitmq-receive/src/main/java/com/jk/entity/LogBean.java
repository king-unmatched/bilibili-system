package com.jk.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collation = "t_aop")
@ToString
public class LogBean {

    private String id;

    private String className;

    private String methodName;

    private String requestParam;

    private String responseParam;
}
