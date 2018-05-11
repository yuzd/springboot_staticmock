package com.example.demo.controller;

import com.example.demo.util.DateUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

/**
 * 测试用 PowerMock 将 Controller层的静态方法mock 掉
 */
@SpringBootTest
// step1
@RunWith(PowerMockRunner.class)
// step2
@PrepareForTest(DateUtil.class)
public class UserControllerTestForMockStaticMethod {

  //step3
  @InjectMocks
  private UserController userController;

  /**
   * Mock了 静态方法之前
   *
   * @throws Exception
   */
  @Test
  public void testWithoutMockStaticMethod() throws ParseException {
    Date resDate = userController.getTomorrowIfAfterTargerDate("2018-05-04 01:01:01");
    Assert.assertTrue(resDate != null);
  }

  /**
   * Mock了 静态方法之后
   *
   * @throws Exception
   */
  @Test
  public void testMockStaticMethod() throws Exception {
    //    step4
    PowerMockito.mockStatic(DateUtil.class);
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date tmr = format.parse("2018-05-02 00:00:00");
    //    setp5
    PowerMockito.when(DateUtil.addDay(any(), eq(1))).thenReturn(tmr);

    Date resDate = userController.getTomorrowIfAfterTargerDate("2018-05-04 01:01:01");
    Assert.assertTrue(resDate == null);
    PowerMockito.verifyStatic(DateUtil.class, times(1));
  }

  @Test
  public void test02() {
    UserController userControllerMock = mock(UserController.class);

    userControllerMock.login("A","123456");
    userControllerMock.login("B","123456");

    /// 一般，验证是否被执行了一次
//    Mockito.verify(userControllerMock).login(anyString(),anyString());
    /// 验证是否被执行了2次
    Mockito.verify(userControllerMock, times(2)).login(anyString(),anyString());
    /// 验证是否从未执行
    Mockito.verify(userControllerMock, never()).login(anyString(),eq("123"));
    /// 验证至少
    Mockito.verify(userControllerMock, atLeast(1)).login("A","123456");
    /// 验证至多
    Mockito.verify(userControllerMock, atMost(2)).login(anyString(),eq("123456"));
  }

}
