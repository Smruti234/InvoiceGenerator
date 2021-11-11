package Com;


import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.Test;

class InvoiceServiceTest {
    InvoiceGenerator invoiceGenerator;

    @Before
    public void setUp() {
        invoiceGenerator = new InvoiceGenerator();
    }
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare(){
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenLessDistanceorTime_ShouldReturnMinFare(){
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary(){
        Ride[] rides = { new Ride(0.5, 5),
                new Ride(0.1, 1),
                new Ride(2.5, 10)
        };
        InvoiceSummary invoiceSummary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3, 50.0);
        Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }
}