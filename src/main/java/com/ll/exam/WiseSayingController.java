package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {

    private Scanner sc;
    private WiseSayingService wiseSayingService;

    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        wiseSayingService = new WiseSayingService(sc);
    }

    public void write() {
        System.out.print("명언 : ");
        String content = sc.nextLine();

        System.out.print("작가 : ");
        String author = sc.nextLine();

        WiseSaying wiseSaying = wiseSayingService.write(content, author);

        System.out.printf("%d번 명언이 등록되었습니다.\n", wiseSaying.getId());
    }

    public void list() {
        List<WiseSaying> wiseSayings = wiseSayingService.findAll();

        if(wiseSayings.size() == 0) {
            System.out.println("명언이 등록되어 있지 않습니다.");
            System.out.println("먼저 명언을 등록하세요.");
            return;
        }

        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");


        for(int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = wiseSayings.get(i);

            System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent());
        }
    }

    public void modify(Rq rq) {
        int id = rq.getIntParam("id", 0);

        if(id == 0) {
            System.out.print("번호를 입력하세요.\n");
            return;
        }

        WiseSaying wiseSaying = wiseSayingService.findById(id);

        if(wiseSaying == null) {
            System.out.printf("%d번 명언이 존재하지 않습니다.\n", id);
            return;
        }

        System.out.printf("명언(기존) : %s\n", wiseSaying.getContent());
        System.out.print("명언 : ");
        String content = sc.nextLine();

        System.out.printf("작가(기존) : %s\n", wiseSaying.getAuthor());
        System.out.print("작가 : ");
        String author = sc.nextLine();

        wiseSayingService.modify(id, content, author);

        System.out.printf("%d번 명언이 수정되었습니다.\n", id);
    }

    public void delete(Rq rq) {
        int id = rq.getIntParam("id", 0);

        if (id == 0) {
            System.out.print("번호를 입력해주세요.\n");
            return;
        }

        WiseSaying wiseSaying = wiseSayingService.findById(id);

        if (wiseSaying == null) {
            System.out.printf("%d번 명언이 존재하지 않습니다.\n", id);
            return;
        }

        wiseSayingService.remove(id);

        System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
    }

}
