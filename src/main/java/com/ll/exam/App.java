package com.ll.exam;

import java.util.Scanner;

public class App {

    private Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {

        outer:
        while(true) {
            System.out.println("== 명언 SSG ==");
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();

            switch(cmd) {
                case "종료" :
                    System.out.print("명언 SSG가 종료되었습니다.");
                    break outer;
            }
        }
    }

}
