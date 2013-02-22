package pl.itcrowd.jsf.tutorial.appUser.view;

import pl.itcrowd.jsf.tutorial.appUser.domain.AppUser;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * Created with IntelliJ IDEA.
 * User: misiek
 * Date: 2/18/13
 * Time: 1:44 PM
 * To change this template use File | Settings | File Templates.
 */
/*@SessionScoped*/
@ViewScoped
@ManagedBean
public class AppUserListView {
    private List<AppUser> appUserList = new ArrayList<AppUser>();
    private AppUser selectedUser = new AppUser();
    private int counter = 1;

    private Converter converter = new Converter() {
        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
            Integer i;
            try{
                i = Integer.parseInt(value);
            }catch (NumberFormatException nfe){
                return null;
            }
            for(AppUser u : appUserList){
                if(u.getId().equals(i)) return u;
            }
            return null;
        }

        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            return ((AppUser) value).getId().toString();
        }
    };

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
        if (selectedUser != null) {
            this.appUserList.add(selectedUser);
            return "successfully_added";
        }
        return "";
    }
    public String moveToPage2(){
        return "page2"; //outcome
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Converter getConverter() {
        return converter;
    }
}
