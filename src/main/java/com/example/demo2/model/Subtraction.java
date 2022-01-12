package com.example.demo2.model;

//引き算を行うクラス。calculateメソッドをインターフェースからオーバーライドしている。
//ここでは簡略化のため、入力値が整数のもの以外は考慮していない。
public class Subtraction implements Calculator {
    @Override
    public int calculate(int firstNumber, int secondNumber) throws Exception {
        return firstNumber - secondNumber;
    }
}
