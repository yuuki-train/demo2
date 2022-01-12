package com.example.demo2.controller;

import com.example.demo2.model.CalculationFactory;
import com.example.demo2.model.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class Demo2Controller {
    //localhost:8080にアクセスした場合に、calculator.htmlを表示するメソッド
    @RequestMapping("/")
    public String startPage(){
        return "calculator";
    }

    //calculator.htmlで計算ボタンを押し、/calculate宛にPOST送信された後に実行されるメソッド
    @PostMapping("/calculate")
    public String calculation(@RequestParam Map<String, String> requestParams, Model model) throws Exception {
        //リクエストパラメータを取得する
        int firstNumber = Integer.parseInt(requestParams.get("firstNumber"));
        int secondNumber = Integer.parseInt(requestParams.get("secondNumber"));
        //modelへ登録する（前回の入力値を画面表示するため）
        model.addAttribute("pastFirstNumber", firstNumber);
        model.addAttribute("pastSecondNumber", secondNumber);

        //CalculatorFactoryクラスをインスタンス化する。
        CalculationFactory factory = new CalculationFactory();
        //getCalculatorメソッドを呼び出し、演算種類に応じた適切なCalculatorインターフェースを実装したクラスのインスタンスを取得する。
        Calculator calculator = factory.getCalculator(requestParams.get("operator"));
        //calculateメソッドを呼び出し、計算結果を取得する。
        int result = calculator.calculate(firstNumber, secondNumber);
        //modelへ登録する（計算結果を画面表示するため）
        model.addAttribute("result", result);

        //calculator.htmlを表示する。
        return "calculator";
    }
}
