package pl.itcrowd.jsf.tutorial.appUser.customValidation;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created with IntelliJ IDEA.
 * User: misiek
 * Date: 2/21/13
 * Time: 10:31 AM
 * To change this template use File | Settings | File Templates.
 */
@FacesValidator("pl.itcrowd.jsf.tutorial.appUser.customValidation.UrlValidator")
public class UrlValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent component, Object value)
            throws ValidatorException {

        StringBuilder url = new StringBuilder();
        String urlValue = value.toString();

        if(urlValue.startsWith("http://", 0)){
            url.append("http://");
        }
        url.append(urlValue);

        try {
            new URI(url.toString());
        } catch (URISyntaxException e) {
            FacesMessage msg = new FacesMessage("URL validation failed","Invalid URL format");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}