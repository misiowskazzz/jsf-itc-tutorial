package pl.itcrowd.jsf.tutorial.phases;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: misiek
 * Date: 2/18/13
 * Time: 12:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class PhaseListener implements javax.faces.event.PhaseListener{

    private static final Logger LOGGER = Logger.getLogger(PhaseListener.class.getCanonicalName());

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

    @Override
    public void beforePhase(PhaseEvent phaseEvent) {
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        ExpressionFactory expressionFactory =
                FacesContext.getCurrentInstance().getApplication().getExpressionFactory();

        if(phaseEvent.getPhaseId()==PhaseId.RESTORE_VIEW)
        {

        }
        LOGGER.info("BEFORE:" + phaseEvent.getPhaseId());
    }

    @Override
    public void afterPhase(PhaseEvent phaseEvent) {
        LOGGER.info("AFTER:" + phaseEvent.getPhaseId());
        if (phaseEvent.getPhaseId().equals(PhaseId.RENDER_RESPONSE)) {
            LOGGER.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
    }

}