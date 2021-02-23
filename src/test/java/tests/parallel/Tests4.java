package tests.parallel;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Tests4 {


    @BeforeEach
    void beforeEach() {
        System.out.println(logThreadId() + ", beforeEach()");
    }

    @AfterEach
    void afterEach() {
        System.out.println(logThreadId() + ", afterEach()");
    }

    @Test
    void test1() {
        doLongAction("test1()");
    }

    @Test
    void test2() {
        doLongAction("test2()");
    }

    @Test
    void test3() {
        doLongAction("test3()");
    }

    @Test
    void test4() {
        doLongAction("test4()");
    }

    @Test
    void test5() {
        doLongAction("test5()");
    }


    private void doLongAction(String testId) {
        System.out.println(logThreadId() + ", " + testId + "-start");
        for (int step = 1; step <= 5; step++) {
            System.out.println(logThreadId() + ", " + testId + ", step=" + step);
            try {
                Thread.sleep(200); // imitate long action
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(logThreadId() + ", " + testId + "-end");
    }

    private String logThreadId() {
        long id = Thread.currentThread().getId();
        return "Tests4:thread-id=" + id;
    }

}
