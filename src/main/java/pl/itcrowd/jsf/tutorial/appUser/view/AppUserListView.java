package pl.itcrowd.jsf.tutorial.appUser.view;

import pl.itcrowd.jsf.tutorial.appUser.domain.AppUser;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: misiek
 * Date: 2/18/13
 * Time: 1:44 PM
 * To change this template use File | Settings | File Templates.
 */
@SessionScoped
@ManagedBean
public class AppUserListView {
    private List<AppUser> appUserList = new ArrayList<AppUser>();
    private AppUser selectedUser = new AppUser();

    public AppUserListView() {
    }

    @PostConstruct
    public void postConstruct() {
        appUserList.add(new AppUser(1, "Lukasz", "aaa"));
        appUserList.add(new AppUser(2, "Rafal", "bbb"));
        appUserList.add(new AppUser(3, "Piotrek", "ccc"));
        appUserList.add(new AppUser(4, "Rafal", "ddd"));
        appUserList.add(new AppUser(5, "Marcin", "eee"));
    }

    public List<AppUser> getAppUserList() {
        return appUserList;
    }

    public void setAppUserList(List<AppUser> appUserList) {
        this.appUserList = appUserList;
    }

    public void deleteUser(AppUser appUser) {
        if (this.appUserList.contains(appUser)) {
            this.appUserList.remove(appUser);
        }
    }

    public AppUser getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(AppUser selectedUser) {
        this.selectedUser = selectedUser;
    }

    public void selectAppUser(AppUser appUser) {
        this.selectedUser = appUser;
    }

    public void addNewAppUser() {
        this.selectedUser = new AppUser();
    }

    public void saveUser() {
        if (selectedUser != null) {
            this.appUserList.add(selectedUser);
        }
    }

    public String saveAndTestNavigation() {
        String msg = "";
        if (selectedUser != null) {
            this.appUserList.add(selectedUser);
            msg = "successfully_added";
        }
        return msg;
    }
}
