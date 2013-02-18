package pl.itcrowd.jsf.tutorial.appUser.framework;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@SessionScoped
@ManagedBean
public class LocaleSelector implements Serializable {

    private List<Locale> availableLocales = new ArrayList<Locale>();

    private Converter converter = new Converter() {
        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value)
        {
            return new Locale(value);
        }

        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value)
        {
            return value == null ? null : value.toString();
        }
    };

    private Locale selectedLocale;

    public LocaleSelector()
    {
        final FacesContext facesContext = FacesContext.getCurrentInstance();
        final Iterator<Locale> localeIterator = facesContext.getApplication().getSupportedLocales();
        while (localeIterator.hasNext()) {
            availableLocales.add(localeIterator.next());
        }
        final Locale requestLocale = facesContext.getExternalContext().getRequestLocale();
        if (availableLocales.contains(requestLocale)) {
            selectedLocale = requestLocale;
        } else {
            selectedLocale = facesContext.getApplication().getDefaultLocale();
        }
    }

    public List<Locale> getAvailableLocales()
    {
        return availableLocales;
    }

    public Converter getConverter()
    {
        return converter;
    }

    public Locale getSelectedLocale()
    {

        return selectedLocale;
    }

    public void setSelectedLocale(Locale selectedLocale)
    {
        this.selectedLocale = selectedLocale;
    }
}