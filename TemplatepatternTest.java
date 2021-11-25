/*
Problem :
We observe that we need to fetch details of each Care takers and Patients fom the desktop application.
If we select a caretaker, we need to generate the caretaker's details  and if we select a patient, we need to generate the 
Patient's details. Some details of the caretaker and patient are not common, so we need
to seperately fetch the details. Seperately fetching the details would less efficicent. 

Solution :
The template method is an efficient and effective way to ensure that an operation or an algorithm is implemented
always according to some predefined criteria but leaving the specifics of certain implementation detail to be decided at
runtime. So that, the common details could be fetched using a predifined method which  
invokes a different method that is decided at run time depending on whether it is a 
CareTaker or a Patient.
*/

import java.util.ArrayList;
import java.util.List;

abstract class Person{
  private String name,nic,address,gender;
  private int age;
  private CareHouse relatedCareHouse;
  private  List<String> contactDetails = new ArrayList<>();
  
  public Person(String name, String nic){
    this.name = name;
    this.nic = nic;
  }
  
  public void setAddress(String address) {
    this.address = address;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }


  public void setAge(int age) {
    this.age = age;
  }

  public void setRelatedCareHouse(CareHouse relatedCareHouse) {
    this.relatedCareHouse = relatedCareHouse;
  }

  public String getContactDetails() {
    String contacts="";
    for (String cd:contactDetails){
      contacts+=cd+" ";
    }
    return contacts;
  }

  public void addContactDetails(String contact) {
    this.contactDetails.add(contact);
  }
  
  public String getDetails(){
    // we get the whole details and find what we need
    String basicDetails = name+"\n"+nic+"\n"+ address+"\n" +age+"\n"+gender+"\n"+relatedCareHouse.getName()+"\n";
    String fullDetails = basicDetails+"\n"+getOtherDetails();
    return fullDetails;
  }
  abstract String getOtherDetails();
   

}
class CareHouse{
  private String name;
  CareHouse(String name){
    this.name = name;
  }
  public String getName() {
      return name;
  }
  // other attributes and methods are available
}

class CareTaker extends Person{
  private String role,userName;

  CareTaker(String name,String nic){
    super(name, nic);
  }

  @Override
  String getOtherDetails() {
      return "Role: "+role+"\n"+"Username: "+userName;
  }
  public void setRole(String role) {
    this.role = role;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }
}
class Patient extends Person{
  // other attributes and methods available


  Patient(String name,String nic){
    super(name, nic);
  }
  @Override
  String getOtherDetails() {
    return "Medical Report No. and Wheel Chair No";
  }

  

}


public class TemplatepatternTest{
  public static void main(String[] args) {
    CareHouse ch = new CareHouse("Carehouse01");

    CareTaker c = new CareTaker("CareTaker1","11111");
    
    c.setUserName("CT1");
    c.setRelatedCareHouse(ch);
    c.setRole("nurse");
    
    System.out.println(c.getDetails());
    System.out.println("...........................");

    Patient p = new Patient("Patient1", "00001");
    p.setRelatedCareHouse(ch);

    System.out.println(p.getDetails());


    

  }
}