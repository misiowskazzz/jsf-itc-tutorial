package pl.itcrowd.jsf.tutorial.appUser.domain;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: misiek
 * Date: 2/18/13
 * Time: 1:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class AppUser implements Serializable {
    private Integer id;
    private String name;
    private String msg;

    public AppUser() {
    }

    public AppUser(Integer id, String name, String msg) {
        this.id = id;
        this.name = name;
        this.msg = msg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}


