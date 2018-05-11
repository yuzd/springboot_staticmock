package com.example.demo.dao;

import com.example.demo.bean.ConsumeRecord;

import java.util.List;

public interface ConsumeRecordDAO {
  public List<ConsumeRecord> findConsumeRecordByUserId(String userId);
}
