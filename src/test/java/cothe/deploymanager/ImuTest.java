package cothe.deploymanager;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Jeongjin Kim
 * @since 2019-10-16
 */
@SpringBootTest
public class ImuTest {
    @Test
    public void stringTest() {
        String a = "a";
        System.out.println(System.identityHashCode(a));
        a = "b";
        System.out.println(System.identityHashCode(a));

        new String("ff");


    }
}
