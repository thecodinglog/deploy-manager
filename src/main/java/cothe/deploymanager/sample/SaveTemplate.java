package cothe.deploymanager.sample;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeongjin Kim
 * @since 2019-10-16
 */
public abstract class SaveTemplate {
    public void proc(){
        String a = "b";
        String c = detailProc(a);
        List<String> strings = new ArrayList<>();
        strings.add(c);
    }

    protected abstract String detailProc(String a);
}
