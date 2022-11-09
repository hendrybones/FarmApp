package com.example.FarmersApp.service;

import com.example.FarmersApp.model.Records;
import com.example.FarmersApp.repository.RecordsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
//@ExtendWith(MockitoAnnotations.class)
class RecordsServiceTest {
@Mock
    private RecordsRepository recordsRepository;
    private AutoCloseable autoCloseable;
    private RecordsService underTest;

    // for each repository we are going to have a fresh instance of
    //RecordService
    @BeforeEach
    void setUp() {
//        AutoCloseable autoCloseable=MockitoAnnotations.openMocks(this);
//        underTest = new RecordsService(recordsRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllRecords() {
        //when
        underTest.findAllRecords();
        //then
        verify(recordsRepository).findAll();
    }

    @Test
    @Disabled
    void canCreateRecord() {
        Records records=new Records(
                "hendry",26,"jarzy",67
        );
        //when
        underTest.addRecords(records);
        //then
        ArgumentCaptor<Records>recordsArgumentCaptor=
                ArgumentCaptor.forClass(Records.class);
        // we capture the actual record that was saved
        verify(recordsRepository)
                .save(recordsArgumentCaptor.capture());

         Records capturedRecords= recordsArgumentCaptor.getValue();
         assertThat(capturedRecords).isEqualTo(records);
    }

    @Test
    @Disabled
    void deleteAllRecord() {
    }

    @Test
    void deleteRecordById() {
    }

    @Test
    void updateRecord() {
    }
}