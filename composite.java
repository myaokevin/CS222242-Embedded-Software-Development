

// Prepare a report on the identified design improvements in the following format for each improvement scenario.
// A brief description of the component(s)/area(s) that the review identified for improvement.
// The specific structural design pattern being proposed for use. Briefly and clearly specify the problem and the solution.
// A class diagram and system sequence diagram to illustrate the use of the design pattern in solving the problem.
// Optionally, you may provide an example code snippet to explain any areas that require further elaboration.


/*
In the smart wheelchair system we observe the CareHouse and CareTakers to be important Components of the system
A carehouse consists of number of caretakers and we observe  that the a need to merge carehouses to a single one could occur
In this situation a need to treat individual objects( CareTaker objects) and compositions of Objects( CareHouse Objects) to betreated uniformly.
So,
    we use the composite pattern for this purpose.
*/

/*
In the above scenario we observe that the need to get details about a carehouse needs to
get details about each caretaker object as well. If we implement this need without using a composite pattern
we would need to explicitly check whether an object is instance of which class and need to 
invoke the getDetails() mehod of the respective class .
But, by using this design pattern , we need not do so. 
*/

/*
CLASS DIAGRAM
USE CASE DIAGRAM

*/
import java.util.ArrayList;
import java.util.List;

interface ResourceComponent {
    void getDetails();
}

class CareTaker implements ResourceComponent {
    private String nameOfCareTaker;

    CareTaker(String nameOfCareTaker) {
        this.nameOfCareTaker = nameOfCareTaker;
    }

    @Override
    public void getDetails() {
        System.out.println("CareTaker name: " + nameOfCareTaker);

    }

}

class CareHouse implements ResourceComponent { // Composite Collection

    private String nameOfCareHouse;

    CareHouse(String nameOfCareHouse) {
        this.nameOfCareHouse = nameOfCareHouse;
    }

    private List<ResourceComponent> caretakers = new ArrayList<ResourceComponent>();

    @Override
    public void getDetails() {
        System.out.println(nameOfCareHouse);
        for (ResourceComponent caretaker : caretakers) {
            caretaker.getDetails();
        }

    }

    public void add(ResourceComponent institute) {
        caretakers.add(institute);
    }

}

public class composite {
    public static void main(String[] args) {

        CareHouse ch1 = new CareHouse("CareHouse 01");

        ch1.add(new CareTaker("CareTaker 1"));
        ch1.add(new CareTaker("CareTaker 2"));

        CareHouse ch2 = new CareHouse("CareHouse 02");

        ch2.add(new CareTaker("CareTaker 3"));
        ch2.add(new CareTaker("CareTaker 4"));

        //Eg:  merging 2 carehouses into a single carehouse with a new name
        CareHouse merged = new CareHouse("CareHouse 03");
        merged.add(ch1);
        merged.add(ch2);

        merged.getDetails();
    }

}

