package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingService {

    private Scanner sc;
    private int wiseSayingLastIndexId;
    private List<WiseSaying> wiseSayings;

    public WiseSayingService(Scanner sc) {
        wiseSayingLastIndexId = 0;
        wiseSayings = new ArrayList<>();
    }

    public WiseSaying write(String content, String author) {
        int id = ++wiseSayingLastIndexId;
        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayings.add(wiseSaying);

        return wiseSaying;
    }

    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    public WiseSaying findById(int id) {
        for(WiseSaying wiseSaying : wiseSayings) {
            if(wiseSaying.getId() == id) {
                return wiseSaying;
            }
        }
        return null;
    }

    public boolean modify(int id, String content, String author) {
        WiseSaying wiseSaying = findById(id);

        if(wiseSaying == null) {
            return false;
        }

        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);

        return true;
    }

    public boolean remove(int id) {
        WiseSaying wiseSaying = findById(id);

        if(wiseSaying == null) {
            return false;
        }

        wiseSayings.remove(wiseSaying);

        return true;
    }
}
