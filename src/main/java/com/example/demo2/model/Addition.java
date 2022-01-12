package com.example.demo2.model;

//足し算を行うクラス。calculateメソッドをインターフェースからオーバーライドしている。
//ここでは簡略化のため、入力値が整数のもの以外は考慮していない。
public class Addition implements Calculator {
    @Override
    public int calculate(int firstNumber, int secondNumber) throws Exception {
        return firstNumber + secondNumber;
    }
}
