package diploma.utils;

import diploma.entity.Specialty;

public class SpecialtyUtils {

    public static Specialty generateSpecialty() {
        Specialty specialty = new Specialty();
        specialty.setUkrName("Тест комп науки");
        specialty.setUkrSpecialization("Тест информ системы");
        specialty.setEngName("Test comp science");
        specialty.setEngSpecialization("Test inform systems");
        specialty.setYear(2007);
        return specialty;
    }

}