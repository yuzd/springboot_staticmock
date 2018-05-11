package com.example.demo.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.powermock.api.mockito.PowerMockito.when;

//@SpringBootTest
@RunWith(PowerMockRunner.class)
@PrepareForTest({ FinalValidator.class })
public class LoginServiceImplTest {

  @InjectMocks
  LoginServiceImpl loginService;

  @Test
  public void testMockFinalMethod() throws Exception {
    //    FinalValidator finalValidatorMock = Mockito.mock(FinalValidator.class);
    FinalValidator finalValidatorMock = PowerMockito.mock(FinalValidator.class);
    when(finalValidatorMock.getFinalValue()).thenReturn("B");
    loginService.setFinalValidator(finalValidatorMock);

    Assert.assertEquals(true, loginService.login("B", "123456"));
  }
}