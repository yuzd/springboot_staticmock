package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

  private FinalValidator finalValidator;

  public void setFinalValidator(FinalValidator finalValidator) {
    this.finalValidator = finalValidator;
  }

  @Override
  public boolean login(String name, String psd) throws Exception {
    String value = finalValidator.getFinalValue();
    if (value.equals(name)) {
      return true;
    }
    return false;
  }


}
