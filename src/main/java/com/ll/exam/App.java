package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private Scanner sc;
    private WiseSayingController wiseSayingController;
    private Rq rq;

    public App(Scanner sc) {
        this.sc = sc;
        wiseSayingController = new WiseSayingController(sc);
    }

    public void run() {
        System.out.println("== 명언 SSG ==");

        outer:
        while(true) {
            System.out.print("명령) ");
            rq = new Rq(sc.nextLine().trim());

            switch(rq.getPath()) {
                case "등록" :
                    wiseSayingController.write();
                    break;
                case "목록" :
                    wiseSayingController.list();
                    break;
                case "수정" :
                    wiseSayingController.modify(rq);
                    break;
                case "삭제" :
                    wiseSayingController.delete(rq);
                    break;
                case "종료" :
                    System.out.print("명언 SSG가 종료되었습니다.");
                    break outer;
            }
        }
    }
}
