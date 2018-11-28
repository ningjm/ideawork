package com.example.demo.pojo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @program: demo
 * @description: 店铺
 * @author: Mr.Ning
 * @create: 2018-11-28 10:38
 **/

@Data
@Document(collection = "shop")
public class Shop implements Serializable {
    private String _id;
    private String category;
    private Double money;
    private Double[] loc;
}
