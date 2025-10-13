package junit;

import org.junit.jupiter.api.*;

public class FirstJUitTest {


    @BeforeAll
    static void beforAll() {
        System.out.println("Это метод beforEach ");
    }




    @BeforeEach
    void beforEach() {
        System.out.println("Это метод beforEach ");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Это метод afterEach ");
    }




    @Test
    void firstTest() {
        System.out.println("Это тест 1");
    }

    @Test
    void secondTest() {
        System.out.println("Это тест 2");
    }
}
