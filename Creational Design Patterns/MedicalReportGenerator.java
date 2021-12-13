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
    TemperatureComp temperature;
    PulseComp pulse;
    BloodO2Comp bloodO2;
    BloodSugarComp bloodSugar;
    SkinMoistureComp skinMoisture;

    public MedicalReportBuilder setTemperature(TemperatureComp temperature) {
        this.temperature = temperature;
        return this;
    }

    public MedicalReportBuilder setPulse(PulseComp pulse) {
        this.pulse = pulse;
        return this;
    }

    public MedicalReportBuilder setBloodO2(BloodO2Comp bloodO2) {
        this.bloodO2 = bloodO2;
        return this;
    }

    public MedicalReportBuilder setBloodSugar(BloodSugarComp bloodSugar) {
        this.bloodSugar = bloodSugar;
        return this;
    }

    public MedicalReportBuilder setSkinMoisture(SkinMoistureComp skinMoisture) {
        this.skinMoisture = skinMoisture;
        return this;
    }

    public MedicalReport getMedicalReport() {
        return new MedicalReport(temperature, pulse, bloodO2, bloodSugar, skinMoisture);
    }
}

class MedicalReport {
    TemperatureComp temperature;
    PulseComp pulse;
    BloodO2Comp bloodO2;
    BloodSugarComp bloodSugar;
    SkinMoistureComp skinMoisture;

    public MedicalReport(TemperatureComp temperature, PulseComp pulse, BloodO2Comp bloodO2, BloodSugarComp bloodSugar,
            SkinMoistureComp skinMoisture) {
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

class TemperatureComp {
    private String temp;

    public TemperatureComp(String temp) {
        setTemp(temp);
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return temp;
    }
}

class PulseComp {
    private String pulse;

    public PulseComp(String pulse) {
        setPulse(pulse);
    }

    public String getPulse() {
        return pulse;
    }

    public void setPulse(String pulse) {
        this.pulse = pulse;
    }

    @Override
    public String toString() {
        return pulse;
    }
}

class BloodO2Comp {
    private String O2;

    public BloodO2Comp(String O2) {
        setO2(O2);
    }

    public String getO2() {
        return O2;
    }

    public void setO2(String o2) {
        this.O2 = o2;
    }

    @Override
    public String toString() {
        return O2;
    }
}

class BloodSugarComp {
    private String sugar;

    public BloodSugarComp(String sugar) {
        setSugar(sugar);
    }

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }

    @Override
    public String toString() {
        return sugar;
    }
}

class SkinMoistureComp {
    private String moisture;

    public SkinMoistureComp(String mositure) {
        setMoisture(moisture);
    }

    public String getMoisture() {
        return moisture;
    }

    public void setMoisture(String moisture) {
        this.moisture = moisture;
    }

    @Override
    public String toString() {
        return moisture;
    }
}

class MedicalReportGenerator {
    public static void main(String[] args) {
        MedicalReportBuilder mrb = new MedicalReportBuilder();
        MedicalReport mr = mrb.setTemperature(new TemperatureComp("36.9 Degree Celcius")).getMedicalReport();
        MedicalReport mr2 = mrb.setBloodSugar(new BloodSugarComp("7.8 mmol/L")).getMedicalReport();
        System.out.println(mr);
        System.out.println(mr2);

    }
}