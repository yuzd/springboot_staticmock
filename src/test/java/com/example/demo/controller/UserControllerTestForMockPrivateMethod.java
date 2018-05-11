package com.example.demo.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;

@SpringBootTest
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserController.class)
public class UserControllerTestForMockPrivateMethod {

  @InjectMocks
  UserController userController;

  @Test
  public void testMockPrivateMethod() throws Exception {
    UserController userControllerPM = PowerMockito.spy(userController);
    PowerMockito.doReturn("yyy").when(userControllerPM, "validateUserMsg", "A", "123456");

    String resA = userControllerPM.login("B", "123456");
    String resB = userControllerPM.login("A", "123456");

    Assert.assertEquals("success", resA);
    Assert.assertEquals("yyy", resB);

    /// 验证：你的private 方法总共被执行了2次
    PowerMockito.verifyPrivate(userControllerPM, times(2)).invoke("validateUserMsg", anyString(), eq("123456"));
  }

}
