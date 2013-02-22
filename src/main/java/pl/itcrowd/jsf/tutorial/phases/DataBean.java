package pl.itcrowd.jsf.tutorial.phases;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Created with IntelliJ IDEA.
 * User: misiek
 * Date: 2/18/13
 * Time: 12:49 PM
 * To change this template use File | Settings | File Templates.
 */
@ViewScoped
@ManagedBean
public class DataBean {
    private String name;

    public DataBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
