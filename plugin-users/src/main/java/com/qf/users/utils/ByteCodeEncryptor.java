package com.qf.users.utils;

public class ByteCodeEncryptor {
  static{
//    System.loadLibrary("ByteCodeEncryptor");
//    System.load("C:\\encryptor.dll");
    System.loadLibrary("encryptor");
  }
  
  public native static byte[] encrypt(byte[] text);
  
}