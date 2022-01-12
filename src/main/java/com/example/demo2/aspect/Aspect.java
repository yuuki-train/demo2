package com.example.demo2.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.stereotype.Component;

//クラスをまたがる横断的な処理を行うAspectクラス。
//AspectアノテーションでspringAOPの導入を宣言する。クラスの属性にはComponentアノテーションを指定する。
@org.aspectj.lang.annotation.Aspect
@Component
public class Aspect {
    //各例外処理メソッドのエラーメッセージを格納するフィールド
    public static String errorMessage = "";

    //空白・文字・小数点を含む数を入力した場合
    //引数のvalueには、所定の書式によって処理の対象メソッドを記述する。PointCutと呼ばれ、35行目以降記載の各処理においても利用する。
    //このアプリではexecution型書式の、型名フリー(*)、calculationメソッド、引数フリー(..)を表している。詳細は下記参考文献を参照。
    //throwingには、例外の仮引数(e)を記述する。AfterThrowingアノテーションのみで必要となる。
    @AfterThrowing(value = "execution(* calculation(..))", throwing = "e")
    public void inputCheck(NumberFormatException e) {
        errorMessage = "入力値が不正です。数値を入力してください。";
    }
    //0で割る計算を行った場合
    @AfterThrowing(value = "execution(* calculation(..))", throwing = "e")
    public void divideCheck(ArithmeticException e){
        errorMessage = "0で割る計算はできません。";
    }
    //その他の例外が発生した場合
    @AfterThrowing(value = "execution(* calculation(..))", throwing = "e")
    public void errorCheck(Exception e){
        if(errorMessage.equals("")){
            errorMessage = "エラーが発生しました。やり直してください。";
        }
    }

    /*
    Aspect処理を行うには、プラグインの追加が必要となる。Gradleの場合は、このアプリの「build.gradle」内のdependenciesを参照。
    Mavenの場合は、下記参考文献のはじめてのSpring AOPの記事を参照。（中ほどの使い方の部分に、pom.xmlについての記載があります。）
    今回は例外発生時のみ実行されるAfterThrowingアノテーションを利用したが、その他にも以下の横断的処理が行える。
    ・Beforeアノテーション：対象メソッド実行前に必ず実行される処理。複数クラスで共通のコンストラクタを作りたい時等に便利。
    ・Afterアノテーション：対象メソッド実行後に、処理結果によらず必ず実行される処理。dbコネクションをcloseする時等に便利？
    ・AfterReturningアノテーション：対象メソッド実行後、正常処理で完了した場合に必ず実行される処理。
    ・Aroundアノテーション：対象メソッド前後に挟まれる処理。
    //参考文献
    ・はじめてのSpring AOP：https://qiita.com/daisuzz/items/de937816a5d7c9210469
    ・Spring AOPについて：https://qiita.com/nullponn/items/85bd761d6d3f6bb0c078
    ・Spring AOPのポイントカット指定子の書き方について：https://qiita.com/rubytomato@github/items/de1019aeaaab51c8784d
     */


}
