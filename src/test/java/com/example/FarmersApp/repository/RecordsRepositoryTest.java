package com.example.FarmersApp.repository;

import com.example.FarmersApp.model.Records;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class RecordsRepositoryTest {

    @Autowired
    private RecordsRepository recordRepo;

    @Test
    @Order(1)
    public void saveRecordTest(){
        Records records= new Records(
                "Hendry", 2,"freshian",150);
       Records savedRecord=recordRepo.save(records);
        assertThat(savedRecord.getId()).isGreaterThan(0);
    }
    @Test
    @Order(2)
    public void getRecordTest(){
        Records records= recordRepo.findRecordById(1L).get();
        assertThat(records.getId()).isEqualTo(1);
    }
    @Test
    @Order(3)
    public void getAllRecordsTest(){
        List<Records> recordsList=recordRepo.findAll();
        assertThat(recordsList.size()).isGreaterThan(0);
    }
    @Test
    @Order(4)
    public  void updateRecordTest(){
        Records records=recordRepo.findRecordById(1L).get();
        records.setName("mchilu");
        Records updateRecord=recordRepo.save(records);
        assertThat(updateRecord.getName()).isEqualTo("mchilu");
    }

    @Test
    @Order(5)
    public void deleteRecordTest(){
        Records records=recordRepo.findRecordById(1L).get();
        recordRepo.delete(records);

        Records records1=null;

        Optional<Records> optionalRecord= recordRepo.findByName("mchilu");
        if (optionalRecord.isPresent()){
            records1=optionalRecord.get();
        }
        assertThat(records1).isNull();
    }
    @Test
    void ItShouldFindRecordById() {
        //given

        Records records = new Records(
                "mrembo",
                20,
                "freshian",
                200
        );
       recordRepo.save(records);

//       // when
//       boolean expected =recordRepo.findById(1);
//       // then
//        assertThat(expected).isTrue();
    }
}