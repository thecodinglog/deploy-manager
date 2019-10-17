package cothe.deploymanager.sample;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Jeongjin Kim
 * @since 2019-10-16
 */
public class SavingInterfaceTest {
    @Test
    public void templateMethod() {
        SavingInterface saveTemplate;

        int a = 0;
        if (a == 1)
            saveTemplate = new SingleSaving();
        else
            saveTemplate = new MultiSaving();

        doSomething(saveTemplate);

    }

    public void doSomething(SavingInterface saveTemplate) {
        saveTemplate.detailProc("ff");
    }

}