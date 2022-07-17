package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private Scanner sc;
    private int wiseSayingLastIndexId;
    private List<WiseSaying> wiseSayings;
    private Rq rq;

    public App(Scanner sc) {
        this.sc = sc;
        wiseSayingLastIndexId = 0;
        wiseSayings = new ArrayList<>();
    }

    public void run() {
        System.out.println("== 명언 SSG ==");

        outer:
        while(true) {
            System.out.print("명령) ");
            rq = new Rq(sc.nextLine().trim());

            switch(rq.getPath()) {
                case "등록" :
                    int id = ++wiseSayingLastIndexId;

                    System.out.print("명언 : ");
                    String content = sc.nextLine();

                    System.out.print("작가 : ");
                    String author = sc.nextLine();

                    System.out.printf("%d번 명언이 등록되었습니다.\n", id);

                    wiseSayings.add(new WiseSaying(id, content, author));
                    break;
                case "목록" :
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------------");

                    for(int i = wiseSayings.size() - 1; i >= 0; i--) {
                        WiseSaying wiseSaying = wiseSayings.get(i);
                        System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent());
                    }
                    break;
                case "삭제" :
                    id = rq.getIntParam("id", 0);

                    if(id == 0) {
                        System.out.print("번호를 입력해주세요.");
                        continue;
                    }

                    WiseSaying wiseSaying = findById(id);

                    if(wiseSaying == null) {
                        System.out.printf("%d번 명언이 존재하지 않습니다.", id);
                    }

                    wiseSayings.remove(wiseSaying);
                    System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
                    break;
                case "종료" :
                    System.out.print("명언 SSG가 종료되었습니다.");
                    break outer;
            }
        }
    }

    private WiseSaying findById(int id) {
        for(WiseSaying wiseSaying : wiseSayings) {
            if(wiseSaying.getId() == id) {
                return wiseSaying;
            }
        }
        return null;
    }

}
