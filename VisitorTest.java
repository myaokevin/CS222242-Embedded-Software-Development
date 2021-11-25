/*
Problem : 
The need to fetch details is needed in the desktop application system. Here, the details needed is of many type.
For eg:
    Only basic details  : name,address etc..
    Advanced Details : Medical/Professional/Other history and other details
    etc...
In such an instance we would need to be able to add many other types of details to be fetched from the system without modifying the code.

Solution: 
The visitor design pattern solves this by separating an operation that operate on a structure in an object from the object itself. Here,
fetch operations are operated on the care house, care taker, and patient objects. So that, the open-closed principle is abided.
The addition of new operation(a collection of details operation shown here) could be done and by creating a new class and implementing the
vistor interface (Collector) and provide the algorithm for the operation.



*/


interface Component{ // Element
    void getDetails(Collector collector);

}
// Concrete Elements
class CareHouse implements Component{

    @Override
    public void getDetails(Collector collector) {
        collector.fetch(this);
        
    }

}
class CareTaker implements Component{

    @Override
    public void getDetails(Collector collector) {
        collector.fetch(this);
        
    }

}
class Patient implements Component{

    @Override
    public void getDetails(Collector collector) {
        collector.fetch(this);
    }

}
//Abstract Visitor
interface Collector{
    void fetch(CareHouse careHouse);
    void fetch(CareTaker careTaker);
    void fetch(Patient patient);
}

// Concrete Visitors
class BasicDetailsCollector implements Collector{

    @Override
    public void fetch(CareHouse careHouse) {
       System.out.println("Basic Details of CareHouse");
        
    }

    @Override
    public void fetch(CareTaker careTaker) {
        System.out.println("Basic Details of CareTaker");
        
    }

    @Override
    public void fetch(Patient patient) {
        System.out.println("Basic Details of Patient");
        
    }

}

class AdvancedDetailsCollector implements Collector{
    // private BasicDetailsCollector basicDetailsCollector= new BasicDetailsCollector();


    @Override
    public void fetch(CareHouse careHouse) {
        // basicDetailsCollector.fetch(careHouse);
        System.out.println("Basic+Extra  =  Advanced  Details of CareHouse");
        
    }

    @Override
    public void fetch(CareTaker careTaker) {
        // basicDetailsCollector.fetch(careTaker);
        System.out.println("Basic+Extra  =  Advanced  Details of CareTaker");
    }

    @Override
    public void fetch(Patient patient) {
        // basicDetailsCollector.fetch(patient);
        System.out.println("Basic+Extra  =  Advanced  Details of Patient");
        
    }

}

// Client
public class VisitorTest{
    public static void main(String[] args) {
        Component careHouse = new CareHouse();
        Component careTaker = new CareTaker();
        Component patient = new Patient();

        System.out.println("..............................");

        Collector basic = new BasicDetailsCollector();
        careHouse.getDetails(basic);
        careTaker.getDetails(basic);
        patient.getDetails(basic);
        System.out.println("..............................");

        Collector advanced = new AdvancedDetailsCollector();
        careHouse.getDetails(advanced);
        careTaker.getDetails(advanced);
        patient.getDetails(advanced);

    }

}