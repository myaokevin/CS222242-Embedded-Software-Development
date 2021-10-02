#include "hospital.h"

//helper function declarations
void print_vector(const std::vector<std::string> vect);

//=============================================================================================================

Hospital::Hospital(const std::string name, const std::string location):
name(name), location(location){
    // this->land_contacts = NULL;
    // this->mobile_contacts = NULL;
}

//setters
void Hospital::add_contact(contact_type contact_type, const std::string& contact){
    switch (contact_type){
        case (LAND):
            land_contacts.push_back(contact);
            break;
        case (MOBILE):
            mobile_contacts.push_back(contact);
    }
}
void Hospital::remove_contact(contact_type contact_type, const std::string& contact){
    switch (contact_type){
        case (LAND):
            remove(land_contacts.begin(),land_contacts.end(),contact);
            break;
        case (MOBILE):
            remove(mobile_contacts.begin(),mobile_contacts.end(),contact);
    }
}
void Hospital::add_care_house(const CareHouse& care_house){
    care_houses.push_back(care_house);
}
void Hospital::remove_care_house(const CareHouse& care_house){
    // remove(care_houses.begin(),care_houses.end(),care_house);        // define '==' operator for CareHouse class
}
void Hospital::change_location_to(const std::string& location){
    this->location = location;
}

//getters
const std::string& Hospital::get_name() const{
    return name;
}
const std::string& Hospital::get_location() const{
    return location;
}
    // list_care_houses() const;
const int& Hospital::get_patient_count() const{
    return patients_count;
}
const std::vector<std::string>& Hospital::get_contacts(contact_type contact_type) const{
    switch(contact_type){
        case(LAND):
            return land_contacts;
        case(MOBILE):
            return mobile_contacts;
    }
}

    // below two functions are for testing purposes
void Hospital::show_land_contacts() const{
    print_vector(land_contacts);
}
void Hospital::show_mobile_contacts() const{
    print_vector(mobile_contacts);
}

//=============================================================================================================

//helper function definitions
void print_vector(const std::vector<std::string> vect){
    int len = vect.size();
    for (int i=0; i<len; i++) std::cout << vect[i] << std::endl;
}

