package com.bear.boot.restful.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-03-10 19:03
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reader implements Serializable {

    
    private String name;
    private Integer age;

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(Reader.builder().name("radical").age(11).build());
    }
}
