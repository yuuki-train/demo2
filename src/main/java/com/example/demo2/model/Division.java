package com.example.demo2.model;

//割り算を行うクラス。calculateメソッドをインターフェースからオーバーライドしている。
//ここでは簡略化のため、入力値が整数のもの以外は考慮していない。計算結果に小数点が発生するものは商の部分のみを返す。（余りや小数点は考慮しない。）
//0で割るとArithmeticExceptionが発生し、Aspectクラスの例外処理が実施される。
public class Division implements Calculator {
    @Override
    public int calculate(int firstNumber, int secondNumber) throws Exception {
        return firstNumber / secondNumber;
    }
}
