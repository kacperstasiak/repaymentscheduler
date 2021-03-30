package com.kacperstasiak.repaymentscheduler;

import com.kacperstasiak.repaymentscheduler.mvc.*;

/**
 * The Schedule controller, controls the model and view.
 * @author Kacper Stasiak
 */
public class ScheduleController extends AbstractController {
    public ScheduleController(ScheduleModel model, ScheduleView view) {
        super(model, view);
    }
    
    @Override
    public void shutdown() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
