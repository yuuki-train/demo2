package com.example.demo2.controller;

import com.example.demo2.aspect.Aspect;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//エラー発生時に、任意の画面に遷移させるためのクラス。Spring AOPと共に活用すると便利かも。
//ErrorControllerインターフェースを実装する。
@Controller
public class CustomErrorController implements ErrorController {
    //通常はエラー発生時に/errorに飛ぶので、これをコントロールして、calculator.htmlを返している。
    @RequestMapping(value = "/error", produces ="text/html")
    public String errorHtml(Model model){
        //Aspectクラスで発生したエラーメッセージをmodelに登録して、エラーメッセージを画面表示できるようにする。
        model.addAttribute("error", Aspect.errorMessage);
        return "calculator";
    }

}
