package forimpatient.chapter05;

/**
 * Created by Iryna Kharaborkina on 8/3/16.
 * <p>
 * Solution to the Chapter 05 Exercise 09 'Scala for the Impatient' by Horstmann C.S.
 *
 *
 */
class Exercise09 {
    public static void main(String[] args) {
        println("Chapter 05 Exercise 09");

        Car a = new Car("tesla", "fdf445", 2015, "dfdfdf");

        println(a.getManufacturer());
        println(a.getModelName());
        println(a.getModelYear());
        println(a.getLicense());

        a.setLicense("retrtr");
        println(a.getLicense());

        Car b = new Car("ford", "fdsfds");

        println(b.getManufacturer());
        println(b.getModelName());
        println(b.getModelYear());
        println(b.getLicense());

        b.setLicense("tytyty");
        println(b.getLicense());
    }

    static class Car {
        private final String manufacturer;
        private final String modelName;
        private final int modelYear;
        private String license;

        Car(String manufacturer, String modelName, int modelYear, String license) {
            this.manufacturer = manufacturer;
            this.modelName = modelName;
            this.modelYear = modelYear;
            this.license = license;
        }

        Car(String manufacturer, String modelName, int modelYear) {
            this(manufacturer, modelName, modelYear, "");
        }

        Car(String manufacturer, String modelName, String license) {
            this(manufacturer, modelName, -1, license);
        }

        Car(String manufacturer, String modelName) {
            this(manufacturer, modelName, -1, "");
        }

        String getManufacturer() {
            return manufacturer;
        }

        String getModelName() {
            return modelName;
        }

        int getModelYear() {
            return modelYear;
        }

        String getLicense() {
            return license;
        }

        void setLicense(String license) {
            this.license = license;
        }
    }

    private static void println(Object txt) {
        System.out.println(txt);
    }
}
