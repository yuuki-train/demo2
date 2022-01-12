package com.example.demo2.model;

//Calculatorインターフェースを実装したクラスのインスタンスを作成するFactoryクラス
public class CalculationFactory {
    //演算種類に応じて適切なクラスを、newでインスタンス化して返す。
    public Calculator getCalculator (String operator){
        Calculator calculator = null;
        if(operator.equals("＋")){
            calculator = new Addition();
        }
        if(operator.equals("－")){
            calculator = new Subtraction();
        }
        if(operator.equals("×")){
            calculator = new Multiplication();
        }
        if(operator.equals("÷")){
            calculator = new Division();
        }
        return calculator;
    }


}
