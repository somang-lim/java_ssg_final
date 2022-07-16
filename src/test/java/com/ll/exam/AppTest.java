package com.ll.exam;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {

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
