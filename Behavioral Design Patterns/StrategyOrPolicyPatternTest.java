// https://github.com/MichalFab/Strategy-design-pattern
 
 /*
Problem : 
The instance where we generate a medical report could be generated in differenet formats
like : HTML ,Text files.
Here, we could generate each format based on selection within a class itself, but this would not
abide the open-close principle. The software entities (classes, modules, functions, etc.) should be open for
extension, but closed for modification. When a new format needs to be generated, 
we would need to modify the code and make changes.

Solution :
The strategy pattern uses composition instead of inheritance with different behaviours 
defined as separate interfaces with specific classes implementing these interfaces.
Thus, the changes could be made to the respective concrete strategy classes (HTMLGenerator, TXTGenerator), but not the context class (ReportSaver)
and new file format generators could be added easily by creating a new class implementing the interface.
 */


class MedicalReportBuilder{
    String temperature,pulse,bloodO2,bloodSugar,skinMoisture;

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
    public MedicalReport getMedicalReport(){
        return new MedicalReport(temperature,pulse,bloodO2,bloodSugar,skinMoisture);
    }
}

class MedicalReport{
    String temperature,pulse,bloodO2,bloodSugar,skinMoisture; 
    public MedicalReport(String temperature, String pulse, String bloodO2, String bloodSugar,String skinMoisture) {
        this.temperature = temperature;
        this.pulse = pulse;
        this.bloodO2=bloodO2;
        this.bloodSugar=bloodSugar;
        this.skinMoisture=skinMoisture;
    }
    @Override
    public String toString() {
        return "Temperature: "+temperature+"\n"+"Pulse Rate: "+pulse+"\n"+"Blood O2 Level: "+bloodO2+"\n"+"Blood Sugar Level: "+bloodSugar+"\n"+"Skin Moisture: "+skinMoisture+"\n"; 
    }
    public void save(Generator generator,String fileName){
        String extension = generator.generate();
        System.out.println("File saved as : "+fileName+"."+ extension);
        System.out.println("\nDetails in saved file :\n"+this);
        System.out.println("..................................");

    }
 
}


interface Generator{ // Strategy
    public String generate();
}
class HTMLGenerator implements Generator{ // Concrete Strategy
    private String extension = "html";

    @Override
    public String generate() {
        System.out.println("Generating HTML File");
        return  extension;
        
    }

}
class TXTGenerator implements Generator{ // Concrete Strategy
    private String extension = "txt";
   
    @Override
    public String generate() {
        System.out.println("Generating TXT File");
        return  extension;

        
    }

}

public class StrategyOrPolicyPatternTest{
    public static void main(String[] args) {
        Generator html = new HTMLGenerator();
        
        MedicalReportBuilder mrb1 = new MedicalReportBuilder();
        mrb1 = mrb1.setTemperature("36.9 Degree Celcius");
        mrb1 = mrb1.setBloodSugar("7.8 mmol/L");
        MedicalReport mr1 = mrb1.getMedicalReport();
        mr1.save(html,"Report_01");
        
        Generator txt = new TXTGenerator();
        MedicalReportBuilder mrb2 = new MedicalReportBuilder();
        mrb2 = mrb2.setTemperature("37.4 Degree Celcius");
        MedicalReport mr2 = mrb2.getMedicalReport(); 
        mr2.save(txt,"Report_02");

    }
}
