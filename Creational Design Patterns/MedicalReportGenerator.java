/*

Problem :

The construction of the Medical Report needs to be implemented with the medical data available.
The medical report needs to be seperated from the construction allowing the same building process 
to create various report representations

Solution : 
We could use the builder design pattern to solve this problem. Here, we could encapsulate 
creating and assembling the parts of a Medical Report in a separate Builder object.
This pattern would also provide control over steps in the building process of the 
medical report.


*/

interface Builder {
    public MedicalReportBuilder setTemperature(String temperature);

    public MedicalReportBuilder setPulse(String pulse);

    public MedicalReportBuilder setBloodO2(String bloodO2);

    public MedicalReportBuilder setBloodSugar(String bloodSugar);

    public MedicalReportBuilder setSkinMoisture(String skinMoisture);
}

class MedicalReportBuilder {
    String temperature, pulse, bloodO2, bloodSugar, skinMoisture;

    public MedicalReportBuilder setTemperature(String temperature) {
        this.temperature = temperature;
        return this;
    }

    public MedicalReportBuilder setPulse(String pulse) {
        this.pulse = pulse;
        return this;
    }

    public MedicalReportBuilder setBloodO2(String bloodO2) {
        this.bloodO2 = bloodO2;
        return this;
    }

    public MedicalReportBuilder setBloodSugar(String bloodSugar) {
        this.bloodSugar = bloodSugar;
        return this;
    }

    public MedicalReportBuilder setSkinMoisture(String skinMoisture) {
        this.skinMoisture = skinMoisture;
        return this;
    }

    public MedicalReport getMedicalReport() {
        return new MedicalReport(temperature, pulse, bloodO2, bloodSugar, skinMoisture);
    }
}

class MedicalReport {
    String temperature, pulse, bloodO2, bloodSugar, skinMoisture;

    public MedicalReport(String temperature, String pulse, String bloodO2, String bloodSugar, String skinMoisture) {
        this.temperature = temperature;
        this.pulse = pulse;
        this.bloodO2 = bloodO2;
        this.bloodSugar = bloodSugar;
        this.skinMoisture = skinMoisture;
    }

    @Override
    public String toString() {
        return "Temperature: " + temperature + "\n" + "Pulse Rate: " + pulse + "\n" + "Blood O2 Level: " + bloodO2
                + "\n" + "Blood Sugar Level: " + bloodSugar + "\n" + "Skin Moisture" + skinMoisture + "\n";
    }

}

class MedicalReportGenerator {
    public static void main(String[] args) {
        MedicalReportBuilder mrb = new MedicalReportBuilder();
        MedicalReport mr = mrb.setTemperature("36.9 Degree Celcius").getMedicalReport();
        MedicalReport mr2 = mrb.setBloodSugar("7.8 mmol/L").getMedicalReport();
        System.out.println(mr);
        System.out.println(mr2);

    }
}