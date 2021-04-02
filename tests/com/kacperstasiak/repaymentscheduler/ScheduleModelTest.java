package tests.com.kacperstasiak.repaymentscheduler;

import com.kacperstasiak.repaymentscheduler.ScheduleItem;
import com.kacperstasiak.repaymentscheduler.ScheduleModel;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kacper Stasiak
 */
public class ScheduleModelTest {
    
    public ScheduleModelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addDebt method, of class ScheduleModel.
     */
    @Test
    public void testAddDebt() {
        System.out.println("addDebt");
        ScheduleModel instance = new ScheduleModel();
        instance.addDebt();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeDebt method, of class ScheduleModel.
     */
    @Test
    public void testRemoveDebt() {
        System.out.println("removeDebt");
        ScheduleModel instance = new ScheduleModel();
        instance.removeDebt();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDebtDetails method, of class ScheduleModel.
     */
    @Test
    public void testGetDebtDetails() {
        System.out.println("getDebtDetails");
        ScheduleModel instance = new ScheduleModel();
        instance.getDebtDetails();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDebtDetails method, of class ScheduleModel.
     */
    @Test
    public void testSetDebtDetails() {
        System.out.println("setDebtDetails");
        ScheduleModel instance = new ScheduleModel();
        instance.setDebtDetails();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSchedule method, of class ScheduleModel.
     */
    @Test
    public void testGetSchedule() {
        System.out.println("getSchedule");
        ScheduleModel instance = new ScheduleModel();
        ArrayList<ScheduleItem> expResult = null;
        ArrayList<ScheduleItem> result = instance.getSchedule();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
