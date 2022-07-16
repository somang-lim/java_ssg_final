package com.ll.exam;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {

    // 종료
    @Test
    void 프로그램_시작할_때_타이틀_출력_그리고_종료() {
        String rs = AppTestRunner.run("종료");

        assertTrue(rs.contains("== 명언 SSG =="));
        assertTrue(rs.contains("명령) "));
        assertTrue(rs.contains("명언 SSG가 종료되었습니다."));
    }

    // 등록
    @Test
    void 등록을_하면_명언과_작가를_물어본다() {
        String rs = AppTestRunner.run("""
                등록
                나의 죽음을 적들에게 알리지 마라
                이순신
                종료
                """);

        assertTrue(rs.contains("명언 : "));
        assertTrue(rs.contains("작가 : "));
    }

    @Test
    void 등록을_하면_생성된_명언번호가_보여진다() {
        String rs = AppTestRunner.run("""
                등록
                나의 죽음을 적들에게 알리지 마라
                이순신
                종료
                """);

        assertTrue(rs.contains("1번 명언이 등록되었습니다."));
    }

    // TEST
    @Test
    void 테스트() {
        assertTrue(1 == 1);
        assertEquals(1, 1);
    }

    @Test
    void 스캐너에_키보드가_아닌_문자열을_입력으로_설정() {
        Scanner sc = TestUtil.genScanner("안녕");
        String cmd = sc.nextLine();

        assertEquals("안녕", cmd);
    }

    @Test
    void 출력을_모니터에_하지_않고_문자열로_어디() {
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();
        System.out.print("안녕");
        String rs = output.toString();
        TestUtil.clearSetOutToByteArray(output);

        assertEquals("안녕", rs);
    }
}
