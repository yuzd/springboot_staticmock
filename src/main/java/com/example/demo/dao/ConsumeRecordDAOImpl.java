package com.example.demo.dao;

import com.example.demo.bean.ConsumeRecord;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class ConsumeRecordDAOImpl implements ConsumeRecordDAO {
  @Override
  public List<ConsumeRecord> findConsumeRecordByUserId(String userId) {
    List<ConsumeRecord> consumeRecords = new ArrayList<>();
    consumeRecords.add(new ConsumeRecord(userId,"买可乐，消费3元。",new Date()));
    consumeRecords.add(new ConsumeRecord(userId,"买薯条，消费12元。",new Date()));
    consumeRecords.add(new ConsumeRecord(userId,"看电影，消费150元。",new Date()));
    return consumeRecords;
  }
}
