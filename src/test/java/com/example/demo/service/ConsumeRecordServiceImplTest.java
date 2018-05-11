package com.example.demo.service;

import com.example.demo.bean.ConsumeRecord;
import com.example.demo.dao.ConsumeRecordDAOImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.powermock.api.mockito.PowerMockito.when;

/***
 * 例子： 用Mockito 去 Mock Service 中的 DAO 成员
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumeRecordServiceImplTest {
  @InjectMocks
  private ConsumeRecordServiceImpl consumeRecordService;

  @Mock
  private ConsumeRecordDAOImpl consumeRecordDAO;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void findConsumeRecordForUser() {
    when(consumeRecordDAO.findConsumeRecordByUserId("A")).thenReturn(null);
    List<ConsumeRecord> resList = new ArrayList<>();
    resList.add(new ConsumeRecord());
    resList.add(new ConsumeRecord());
    when(consumeRecordDAO.findConsumeRecordByUserId("B")).thenReturn(resList);

    List<ConsumeRecord> listA = consumeRecordService.findConsumeRecordForUser("A");
    List<ConsumeRecord> listB = consumeRecordService.findConsumeRecordForUser("B");

    Assert.assertTrue(listA == null);
    Assert.assertEquals(2, listB.size());

  }
}