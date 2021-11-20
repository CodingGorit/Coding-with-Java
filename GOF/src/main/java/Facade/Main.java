package Facade;

import Facade.pagemaker.PageMaker;

/**
 * @Author Gorit
 * @Date 2021/11/21
 *
 * mockData:
 * hyuki@hyuki.com=Hiroshi Yuki
 * hanako@hyuki.com=Hanako Stao
 * tomura@hyuki.com=Tomura
 * manoru@hyuki.com=Mamoru Takahashi
 **/
public class Main {
    public static void main(String[] args) {
        PageMaker.makeWelcomePage("hanako@hyuki.com", "welcome.html");
    }
}
