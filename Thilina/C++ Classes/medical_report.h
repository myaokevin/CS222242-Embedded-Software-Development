#include<iostream>

class MedicalReport{
    private:
        float pulse_rate;
        float blood_oxygen_level;
        float temperature;
        float sugar_level;
        float skin_moisture;
    public:
        //default constructor is used
        // getters
        const float& get_pulse_rate() const;
        const float& get_blood_oxygen_level() const;
        const float& get_temperature() const;
        const float& get_sugar_level() const;
        const float& get_skin_moisture() const;
};