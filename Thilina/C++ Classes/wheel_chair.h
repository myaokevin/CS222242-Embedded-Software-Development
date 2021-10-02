#include<iostream>

class Patient;

class WheelChair{
    private:
        std::string id;
        Patient* patient;
        std::string default_location;
        std::string current_location;
    public:
        WheelChair(const std::string& id, const std::string& default_location);

        //setters
        void change_patient(const Patient& new_patient);
        void change_default_location(const std::string& new_default_location);
        void chage_current_location(const std::string& current_location);

        //getters
        const std::string& get_id() const;
        const Patient& get_patient() const;
        const std::string& get_default_location() const;
        const std::string& get_current_location() const;
};