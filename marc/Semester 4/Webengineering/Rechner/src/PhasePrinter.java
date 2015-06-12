import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 * Created by Marc on 11/06/2015.
 */
public class PhasePrinter implements PhaseListener {

    @Override
    public void beforePhase(PhaseEvent e){
        System.err.println("Before: " + e.getPhaseId());
    }

    @Override
    public void afterPhase(PhaseEvent e){
        System.err.println("After: " + e.getPhaseId());
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

}
