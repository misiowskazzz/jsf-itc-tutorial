package pl.itcrowd.jsf.tutorial.appUser.view;

import pl.itcrowd.jsf.tutorial.appUser.domain.AppUser;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: misiek
 * Date: 2/18/13
 * Time: 1:44 PM
 * To change this template use File | Settings | File Templates.
 */
@ViewScoped
@ManagedBean
public class AppUserListView {
    public AppUserListView() {
    }

    private List<AppUser> appUserList=new ArrayList<AppUser>();

    public List<AppUser> getAppUserList() {
        return appUserList;
    }

    public void setAppUserList(List<AppUser> appUserList) {
        this.appUserList = appUserList;
    }

    @PostConstruct

    public void postConstruct()
    {
        appUserList.add(new AppUser(1,"Lukasz", "aaa"));
        appUserList.add(new AppUser(2,"Rafal", "bbb"));
        appUserList.add(new AppUser(3,"Piotrek", "ccc"));
        appUserList.add(new AppUser(4,"Rafal", "ddd"));
        appUserList.add(new AppUser(5,"Marcin", "eee"));
    }
}
