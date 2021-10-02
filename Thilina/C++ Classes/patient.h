#include<iostream>
#include"care_taker.h"
#include"medical_report.h"
#include"wheel_chair.h"

class Patient: Person{
    private:
        MedicalReport medical_report;
        WheelChair wheel_chair;
        CareTaker care_taker;
    public:
        Patient(const std::string& name, const std::string& nic, const std::string& address, const int& age, 
        Gender gender, const CareHouse* related_care_house, const CareTaker& care_taker, const WheelChair& wheel_chair);

        //setters
        void change_wheel_chair(const WheelChair& new_wheel_chair);
        void change_care_taker(const CareTaker& new_care_taker);

        //getters
        const MedicalReport& get_medical_report() const;
        const WheelChair& get_wheel_chair() const;
        const CareTaker& get_care_taker() const;
};