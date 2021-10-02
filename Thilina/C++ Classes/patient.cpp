#include"patient.h"

Patient::Patient(const std::string& name, const std::string& nic, const std::string& address, const int& age, 
Gender gender, const CareHouse* related_care_house, const CareTaker& care_taker, const WheelChair& wheel_chair)
:Person(name, nic,  address, age, gender, related_care_house), care_taker(care_taker), wheel_chair(wheel_chair){

}

//setters
void Patient::change_wheel_chair(const WheelChair& new_wheel_chair){
    wheel_chair = new_wheel_chair;
}
void Patient::change_care_taker(const CareTaker& new_care_taker){
    care_taker = new_care_taker;
}

//getters
const MedicalReport& Patient::get_medical_report() const{
    return medical_report;
}
const WheelChair& Patient::get_wheel_chair() const{}
const CareTaker& Patient::get_care_taker() const{}