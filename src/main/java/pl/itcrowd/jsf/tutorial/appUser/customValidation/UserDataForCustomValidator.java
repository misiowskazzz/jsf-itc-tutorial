package pl.itcrowd.jsf.tutorial.appUser.customValidation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: misiek
 * Date: 2/21/13
 * Time: 10:38 AM
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean(name = "userDataForCustomValidator", eager = true)
@SessionScoped
public class UserDataForCustomValidator implements Serializable {

    private String Data;

    public UserDataForCustomValidator() {
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }
}
