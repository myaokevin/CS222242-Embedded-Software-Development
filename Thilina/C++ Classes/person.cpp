#include"person.h"

Person::Person(const std::string& name, const std::string& nic, const std::string& address,
                const int& age, Gender gender, CareHouse* related_care_house)
:name(name), nic(nic), address(address), age(age), gender(gender), related_care_house(related_care_house){
    
}

//setters
void Person::change_address(const std::string& new_address){
    address = new_address;
}
void Person::change_related_care_house(CareHouse& care_house){
    related_care_house = &care_house;
}
void Person::add_contact(contact_type contact_type, const std::string& contact){
    switch(contact_type){
        case(LAND):
            land_contacts.push_back(contact);
            break;
        case(MOBILE):
            mobile_contacts.push_back(contact);
    }
}
void Person::remove_contact(contact_type contact_type, const std::string& contact){
    switch(contact_type){
        case(LAND):
            remove(land_contacts.begin(),land_contacts.end(), contact);
            break;
        case(MOBILE):
            remove(mobile_contacts.begin(), mobile_contacts.end(), contact);
    }
}

//getters
const std::string& Person::get_name() const{
    return name;
}
const std::string& Person::get_nic() const{
    return nic;
}
const std::string& Person::get_address() const{
    return address;
}
const int& Person::get_age() const{
    return age;
}
const int& Person::get_gender() const{
    switch(gender){
        case(MALE):
            return 0;
        case(FEMALE):
            return 1;
    }
}
const CareHouse& Person::get_related_care_house() const{
    return *related_care_house;
}
const std::vector<std::string>& Person::get_contacts(contact_type contact_type) const{
    switch(contact_type){
        case(LAND):
            return land_contacts;
        case(MOBILE):
            return mobile_contacts;
    }
}