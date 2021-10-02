#include<iostream>
#include<vector>
#include<algorithm>

class CareHouse;

class Person{
    private:
        std::string name;
        std::string nic;
        std::string address;
        int age;
        CareHouse* related_care_house;
        enum contact_type:char{LAND = 0, MOBILE};
        std::vector<std::string> land_contacts;
        std::vector<std::string> mobile_contacts;
    public:
        enum Gender:char{MALE=0,FEMALE};
        const Gender gender;                    // is this safe? is the desing ok?
        
        Person(const std::string& name, const std::string& nic, const std::string& address, 
            const int& age, Gender gender, CareHouse* related_care_house);
        
        //setters
        void change_address(const std::string& new_address);
        void change_related_care_house(CareHouse& care_house);
        void add_contact(contact_type contact_type, const std::string& contact);
        void remove_contact(contact_type contact_type, const std::string& contact);

        //getters
        const std::string& get_name() const;
        const std::string& get_nic() const;
        const std::string& get_address() const;
        const int& get_age() const;
        const int& get_gender() const;
        const CareHouse& get_related_care_house() const;
        const std::vector<std::string>& Person::get_contacts(contact_type contact_type) const;
};