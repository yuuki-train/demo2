package com.example.demo2.model;

//計算処理を行うインターフェース。calculateメソッドは実装クラスでオーバーライドする。
public interface Calculator {
    public int calculate(int firstNumber, int secondNumber) throws Exception;
}
