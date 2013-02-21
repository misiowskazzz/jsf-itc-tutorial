package pl.itcrowd.jsf.tutorial.phases;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import java.util.logging.Logger;


@ManagedBean
@RequestScoped
public class SimpleBean {
    private final static Logger LOGGER = Logger.getLogger(SimpleBean.class.getCanonicalName());

    public SimpleBean() {
        //customInput.addValidator(FacesContext.getCurrentInstance().getApplication().createValidator("javax.faces.Integer"));
//        final Application application = FacesContext.getCurrentInstance().getApplication();
//        final Validator validator = application.createValidator("javax.faces.LongRange");
//        customInput.addValidator(validator);
//        customInput.setConverter(application.createConverter(Integer.class));

    }

    private UIInput customInput = new UIInput() {
        @Override
        public void setSubmittedValue(Object submittedValue)
        {
            System.out.println("setSubmittedValue:"+submittedValue);
            super.setSubmittedValue(submittedValue);
        }

        @Override
        public void setLocalValueSet(boolean localValueSet)
        {
            System.out.println("setLocalValueSet:"+localValueSet);
            super.setLocalValueSet(localValueSet);
        }

        @Override
        public void setRequiredMessage(String message)
        {
            System.out.println("setRequiredMessage:"+message);
            super.setRequiredMessage(message);
        }

        @Override
        public void setConverterMessage(String message)
        {
            System.out.println("setConverterMessage:"+message);
            super.setConverterMessage(message);
        }

        @Override
        public void setValidatorMessage(String message)
        {
            System.out.println("setValidatorMessage:"+message);
            super.setValidatorMessage(message);
        }

        @Override
        public void setValid(boolean valid)
        {
            System.out.println("setValid:"+valid);
            super.setValid(valid);
        }

        @Override
        public void setRequired(boolean required)
        {
            System.out.println("setRequired:"+required);
            super.setRequired(required);
        }

        @Override
        public void setImmediate(boolean immediate)
        {
            System.out.println("setImmediate:"+immediate);
            super.setImmediate(immediate);
        }

        @Override
        public void processDecodes(FacesContext context)
        {
            System.out.println("processDecodes");
            super.processDecodes(context);
        }

        @Override
        public void processValidators(FacesContext context)
        {
            System.out.println("processValidators");
            super.processValidators(context);
        }

        @Override
        public void processUpdates(FacesContext context)
        {
            System.out.println("processUpdates");
            super.processUpdates(context);
        }

        @Override
        public void decode(FacesContext context)
        {
            System.out.println("decode");
            super.decode(context);
        }

        @Override
        public void updateModel(FacesContext context)
        {
            System.out.println("updateModel");
            super.updateModel(context);
        }

        @Override
        public void validate(FacesContext context)
        {
            System.out.println("validate");
            super.validate(context);
        }

        @Override
        public Object saveState(FacesContext context)
        {
            System.out.println("saveState");
            return super.saveState(context);
        }

        @Override
        public void restoreState(FacesContext context, Object state)
        {
            System.out.println("restoreState");
            super.restoreState(context, state);
        }
    };


    public String getTree(){
        final UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        appendStr(viewRoot, stringBuilder, "");
        //LOGGER.info(stringBuilder.toString());
        return stringBuilder.toString();
    }

    private void appendStr(UIComponent uiComponent, StringBuilder stringBuilder, String prefix){
        stringBuilder.append(prefix).append(uiComponent.getClientId()).append(":").append(uiComponent.getClass()).append("\n");
        prefix+="   ";
        for(UIComponent component : uiComponent.getChildren()){
           appendStr(component, stringBuilder.append(" "), prefix);
        }
    }

    public void addComponent(){
        final UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
        final UIComponent uiComponent = viewRoot.findComponent("form");

        UIInput e = new UIInput();
        uiComponent.getChildren().add(uiComponent.getChildren().size(),e);
    }

    public UIInput getCustomInput() {
        return customInput;
    }

    public void setCustomInput(UIInput customInput) {
        this.customInput = customInput;
    }
}
