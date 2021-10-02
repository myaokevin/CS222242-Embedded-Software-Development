#include<iostream>
#include<vector>
#include<algorithm> //"remove" function to remove an element from a vector

class Hospital;     // forward declaration

class CareHouse{    
    private:
        std::string name;
        const std::string id;
        std::string location;
        enum contact_type:char{LAND = 0, MOBILE};
        std::vector<std::string> land_contacts;
        std::vector<std::string> mobile_contacts;
        int chair_count;
        Hospital* related_hospital;     /*the hospital may be accessed through this pointer. therefore we do not create a getter that can
        get to the hospital. the getter will return a const Hospital. check if there are any risks involved. make this property constant.*/
        // std::vector<CareTaker> care_takers;
        // std::vector<Patient> patients;
    public:
        CareHouse(const std::string name, const std::string id, const std::string location, const int chair_count);

        //setters
        void set_related_hospital(Hospital& hospital);
        void add_contact(contact_type contact_type, const std::string& contact);
        void remove_contact(contact_type contact_type, const std::string& contact);
        // void add_care_taker(const CareTaker care_taker);
        // void remove_care_taker(const CareTaker care_taker);
        // void add_patient(const Patient patient);
        // void remove_patient(const Patient patient);

        //getters
        const std::string& get_name() const;
        const std::string& get_id() const;
        const std::string& get_location() const;
        const int& get_chair_count() const;
        const Hospital& get_related_hospital() const;
        const std::vector<std::string>& get_contacts(contact_type contact_type) const;
        // const std::vector<CareTaker>& list_care_takers() const;
        // const Patient& find_patient() const;
        // const std::vector<Patient> list_patients() const;
};