package com.ll.exam;

import java.util.Scanner;

public class App {

    private Scanner sc;
    private int wiseSayingLastIndexId;

    public App(Scanner sc) {
        this.sc = sc;
        wiseSayingLastIndexId = 0;
    }

    public void run() {
        System.out.println("== 명언 SSG ==");

        outer:
        while(true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();

            switch(cmd) {
                case "등록" :
                    int id = ++wiseSayingLastIndexId;

                    System.out.print("명언 : ");
                    String content = sc.nextLine();

                    System.out.print("작가 : ");
                    String author = sc.nextLine();

                    System.out.printf("%d번 명언이 등록되었습니다.", id);
                    break;
                case "종료" :
                    System.out.print("명언 SSG가 종료되었습니다.");
                    break outer;
            }
        }
    }

}
