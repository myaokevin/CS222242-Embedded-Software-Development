#include"care_house.h"

CareHouse::CareHouse(const std::string name, const std::string id, const std::string location, const int chair_count)
:name(name), id(id), location(location), chair_count(chair_count){

}

//setters
void CareHouse::set_related_hospital(Hospital& hospital){
    related_hospital = &hospital;
}
void CareHouse::add_contact(contact_type contact_type, const std::string& contact){
    switch(contact_type){
        case(LAND):
            land_contacts.push_back(contact);
        case(MOBILE):
            mobile_contacts.push_back(contact);
    }
}
void CareHouse::remove_contact(contact_type contact_type, const std::string& contact){
    switch(contact_type){
        case(LAND):
            remove(land_contacts.begin(),land_contacts.end(), contact);
            break;
        case(MOBILE):
            remove(mobile_contacts.begin(), mobile_contacts.end(), contact);
    }
}
// void CareHouse::add_care_taker(const CareTaker care_taker){}
// void CareHouse::remove_care_taker(const CareTaker care_taker){}
// void CareHouse::add_patient(const Patient patient){}
// void CareHouse::remove_patient(const Patient patient){}

//getters
const std::string& CareHouse::get_name() const{
    return name;
}
const std::string& CareHouse::get_id() const{
    return id;
}
const std::string& CareHouse::get_location() const{
    return location;
}
const int& CareHouse::get_chair_count() const{
    return chair_count;
}
const Hospital& CareHouse::get_related_hospital() const{
    return *related_hospital;
}
const std::vector<std::string>& CareHouse::get_contacts(contact_type contact_type) const{
    switch(contact_type){
        case(LAND):
            return land_contacts;
        case(MOBILE):
            return mobile_contacts;
    }
}
// const std::vector<CareTaker>& CareHouse::list_care_takers() const{}
// const Patient& CareHouse::find_patient() const{}
// const std::vector<Patient> CareHouse::list_patients() const{}