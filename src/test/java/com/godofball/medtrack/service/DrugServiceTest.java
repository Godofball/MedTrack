package com.godofball.medtrack.service;

import com.godofball.medtrack.pojo.Drug;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DrugServiceTest {
    @Autowired
    DrugService drugService;

    @Test
    public void testGetList(){
        List<Drug> list = drugService.list();
        list.forEach(System.out::println);
    }
}
