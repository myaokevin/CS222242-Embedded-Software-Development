#include<iostream>
#include"person.h"

class CareTaker: Person{
    private:
        std::string roll;
    public:
        CareTaker(const std::string& name, const std::string& nic, const std::string& address, const int& age,
                Gender gender, CareHouse* related_care_house, const std::string& roll);

        // getters
        const std::string& get_roll() const;
};