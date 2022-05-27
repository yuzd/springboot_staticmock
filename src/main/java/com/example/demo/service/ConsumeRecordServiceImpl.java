package com.example.demo.service;

import com.example.demo.bean.ConsumeRecord;
import com.example.demo.dao.ConsumeRecordDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ConsumeRecordServiceImpl implements ConsumeRecordService {

  @Resource
  private ConsumeRecordDAO consumeRecordDAO;

  @Override
  public List<ConsumeRecord> findConsumeRecordForUser(String userId) {
    String aa = FinalValidator.testStatic();
    return this.consumeRecordDAO.findConsumeRecordByUserId(userId);
  }
}
