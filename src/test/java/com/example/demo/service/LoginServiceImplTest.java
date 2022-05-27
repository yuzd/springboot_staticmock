package com.example.demo.service;

import com.example.demo.bean.ConsumeRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.powermock.api.mockito.PowerMockito.when;

@SpringBootTest
@RunWith(PowerMockRunner.class)
@PrepareForTest({FinalValidator.class})
@PowerMockRunnerDelegate(SpringRunner.class) //将powermock整合到spring容器中
@PowerMockIgnore({"javax.*.*", "com.sun.*", "org.xml.*", "org.apache.*"})
public class LoginServiceImplTest {

    @Autowired
    private ConsumeRecordServiceImpl consumeRecordService;

    @InjectMocks
    LoginServiceImpl loginService;

    @Test
    public void testMockFinalMethod() throws Exception {
        //    FinalValidator finalValidatorMock = Mockito.mock(FinalValidator.class);
        PowerMockito.mockStatic(FinalValidator.class);
        when(FinalValidator.testStatic()).thenReturn("dadada");

        List<ConsumeRecord> b = consumeRecordService.findConsumeRecordForUser("B");
    }
}