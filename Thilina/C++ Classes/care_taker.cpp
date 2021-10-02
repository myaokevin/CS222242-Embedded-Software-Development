#include"care_taker.h"

CareTaker::CareTaker(const std::string& name, const std::string& nic, const std::string& address, 
                    const int& age, Gender gender, CareHouse* related_care_house, const std::string& roll)
:Person(name, nic,  address, age, gender, related_care_house), roll(roll){

}

const std::string& CareTaker::get_roll() const{
    return roll;
}