package com.bitcamp.handler;

import java.io.DataInputStream;
import java.io.DataOutputStream;

// 사용자 요청을 다룰 객체의 사용법을 정의한다.
//
public interface Handler {
  void execute(DataInputStream in, DataOutputStream out) throws Exception;
}
