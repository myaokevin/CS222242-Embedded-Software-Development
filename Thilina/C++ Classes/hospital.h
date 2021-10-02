#include<iostream>
#include<vector>
#include"care_house.h"
#include<algorithm> //"remove" function to remove an element from a vector

class Hospital{
    private:
        const std::string name;
        std::string location;
        enum contact_type:char {LAND = 0, MOBILE};
        std::vector<std::string> land_contacts;
        std::vector<std::string> mobile_contacts;
        std::vector<CareHouse> care_houses;
        int patients_count;

    public:
        Hospital(const std::string name, const std::string location);

        //setters
        void add_contact(contact_type contact_type, const std::string& contact);
        void remove_contact(contact_type contact_type, const std::string& contact);     //this might need to be converted into remove by index.
        void add_care_house(const CareHouse& care_house);
        void remove_care_house(const CareHouse& care_house);
        void change_location_to(const std::string& location);

        //getters
        const std::string& get_name() const;
        const std::string& get_location() const;
            // list_care_houses() const;
        const int& get_patient_count() const;
        const std::vector<std::string>& get_contacts(contact_type contact_type) const;
            //below two functions are for testing purposes
        void show_land_contacts() const;
        void show_mobile_contacts() const;
};