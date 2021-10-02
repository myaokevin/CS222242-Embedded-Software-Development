#include"wheel_chair.h"

WheelChair::WheelChair(const std::string& id, const std::string& default_location) : id(id), default_location(default_location){

} 

//setters
void WheelChair::change_patient(const Patient& new_patient){}
void WheelChair::change_default_location(const std::string& new_default_location){}
void WheelChair::chage_current_location(const std::string& current_location){}

//getters
const std::string& WheelChair::get_id() const{}
const Patient& WheelChair::get_patient() const{}
const std::string& WheelChair::get_default_location() const{}
const std::string& WheelChair::get_current_location() const{}