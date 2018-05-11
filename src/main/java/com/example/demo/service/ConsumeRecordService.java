package com.example.demo.service;

import com.example.demo.bean.ConsumeRecord;

import java.util.List;

public interface ConsumeRecordService {
  public List<ConsumeRecord> findConsumeRecordForUser(String userId);
}
