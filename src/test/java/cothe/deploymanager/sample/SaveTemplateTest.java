package cothe.deploymanager.sample;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Jeongjin Kim
 * @since 2019-10-16
 */
public class SaveTemplateTest {
    @Test
    public void templateMethod() {
        SaveTemplate saveTemplate;

        int a = 0;
        if (a == 1)
            saveTemplate = new MultiSave();
        else
            saveTemplate = new SingleSave();

        doSomething(saveTemplate);

    }

    public void doSomething(SaveTemplate saveTemplate) {
        saveTemplate.detailProc("ff");
    }

}