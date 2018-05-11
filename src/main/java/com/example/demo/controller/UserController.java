package com.example.demo.controller;

import com.example.demo.bean.ConsumeRecord;
import com.example.demo.service.ConsumeRecordService;
import com.example.demo.service.LoginService;
import com.example.demo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
  @Resource
  private LoginService loginService;

  @Resource
  private ConsumeRecordService consumeRecordService;

  @GetMapping("/login")
  public String login(@RequestParam("name") String userName, @RequestParam("psd") String psd) {
    return validateUserMsg(userName, psd);
  }

  private String validateUserMsg(String userName, String psd) {
    if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(psd)) {
      return "error";
    }

    if (psd.trim().length() < 6) {
      return "short";
    }

    return "success";

  }

  public Date getTomorrowIfAfterTargerDate(String tarDateStr) throws ParseException {
    Date tmr = DateUtil.addDay(null, 1);
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date targetDate = format.parse(tarDateStr);
    if (targetDate.compareTo(tmr) <= 0) {
      return tmr;
    }
    return null;
  }

  @GetMapping("/info/{userId}/cr")
  public List<ConsumeRecord> getConsumeRecord(@PathVariable("userId") String userId) {
    return this.consumeRecordService.findConsumeRecordForUser(userId);
  }

}
