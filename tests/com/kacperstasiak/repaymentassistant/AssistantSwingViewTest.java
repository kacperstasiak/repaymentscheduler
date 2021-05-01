package com.kacperstasiak.repaymentassistant;

import com.kacperstasiak.repaymentassistant.MVC.Controller;
import com.kacperstasiak.repaymentassistant.MVC.Model;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kacper Stasiak
 */
public class AssistantSwingViewTest {

    /**
     * Test of init method, of class AssistantSwingView.
     */
    @Test(expected = IllegalStateException.class)
    public void testInitNoController() {
        System.out.println("init no controller");
        AssistantSwingView instance = new AssistantSwingView();
        instance.init();
    }

    /**
     * Test of init method, of class AssistantSwingView.
     */
    @Test
    public void testInit() {
        System.out.println("init with controller");
        AssistantSwingView instance = new AssistantSwingView();
        Model model = new AssistantModel();
        Controller control = new AssistantController(model, instance);
        instance.init();
    }

    /**
     * Test of update method, of class AssistantSwingView.
     */
    @Test(expected = IllegalStateException.class)
    public void testUpdateBeforeInit() {
        System.out.println("update before init()");
        AssistantSwingView instance = new AssistantSwingView();
        Model model = new AssistantModel();
        Controller control = new AssistantController(model, instance);
        instance.update();
    }

    /**
     * Test of update method, of class AssistantSwingView.
     */
    @Test(expected = IllegalStateException.class)
    public void testUpdateBeforeMainViewFullyInit() {
        System.out.println("update after init() but before Swing initialises main view");
        AssistantSwingView instance = new AssistantSwingView();
        Model model = new AssistantModel();
        Controller control = new AssistantController(model, instance);
        instance.init();
        instance.update();
    }

    /**
     * Test of close method, of class AssistantSwingView.
     */
    @Test
    public void testCloseNoController() {
        System.out.println("close without controller");
        AssistantSwingView instance = new AssistantSwingView();
        instance.close();
    }

    /**
     * Test of close method, of class AssistantSwingView.
     */
    @Test
    public void testCloseWithController() {
        System.out.println("close with controller");
        AssistantSwingView instance = new AssistantSwingView();
        Model model = new AssistantModel();
        Controller control = new AssistantController(model, instance);
        instance.close();
    }

    /**
     * Test of getController method, of class AssistantSwingView.
     */
    @Test(expected = IllegalStateException.class)
    public void testGetControllerNoControllerSetUp() {
        System.out.println("getController without one set up");
        AssistantSwingView instance = new AssistantSwingView();
        Controller expResult = null;
        Controller result = instance.getController();
    }

    /**
     * Test of getController method, of class AssistantSwingView.
     */
    @Test
    public void testGetController() {
        System.out.println("getController with one set up");
        AssistantSwingView instance = new AssistantSwingView();
        Model model = new AssistantModel();
        Controller control = new AssistantController(model, instance);
        Controller expResult = control;
        Controller result = instance.getController();
        assertEquals(expResult, result);
    }

    /**
     * Test of getModel method, of class AssistantSwingView.
     */
    @Test(expected = IllegalStateException.class)
    public void testGetModelNoController() {
        System.out.println("getModel without controller");
        AssistantSwingView instance = new AssistantSwingView();
        Model expResult = null;
        Model result = instance.getModel();
    }

    /**
     * Test of getModel method, of class AssistantSwingView.
     */
    @Test
    public void testGetModel() {
        System.out.println("getModel with controller");
        AssistantSwingView instance = new AssistantSwingView();
        Model model = new AssistantModel();
        Controller control = new AssistantController(model, instance);
        Model expResult = model;
        Model result = instance.getModel();
        assertEquals(expResult, result);
    }

    /**
     * Test of setController method, of class AssistantSwingView.
     */
    @Test
    public void testSetController() {
        System.out.println("setController");
        AssistantSwingView instance = new AssistantSwingView();
        Model model = new AssistantModel();
        Controller control = new AssistantController(model, instance);

        AssistantSwingView view2 = new AssistantSwingView();
        Controller control2 = new AssistantController(model, view2);

        instance.setController(control2);

        assertEquals(control2, instance.getController());
    }

    /**
     * Test of setController method, of class AssistantSwingView.
     */
    @Test
    public void testSetControllerNoControllerSetUpYet() {
        System.out.println("setController");
        AssistantSwingView instance = new AssistantSwingView();

        Model model = new AssistantModel();

        // Set up controller with a different view
        AssistantSwingView view2 = new AssistantSwingView();
        Controller control = new AssistantController(model, view2);

        // Set this view's controller to the same
        instance.setController(control);

        assertEquals(control, instance.getController());
    }

}
