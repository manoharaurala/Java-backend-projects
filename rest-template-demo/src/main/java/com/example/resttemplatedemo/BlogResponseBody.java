package com.example.resttemplatedemo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BlogResponseBody implements Serializable {
    private String title;
    private String auther;
    private String content;
    private Date publisheddate;
}
