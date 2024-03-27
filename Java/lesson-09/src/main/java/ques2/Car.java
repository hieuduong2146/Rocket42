package ques2;

public class Car {
    private String name;
    private String type;

    public Car(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public class Engine {
        private  String engineType;

        public String getEngineType() {
            return engineType;
        }

        public void setEngineType(String engineType) {
            this.engineType = engineType;
        }



    }

    public static void main(String[] args) {
        Car car = new Car("Mazda","8WD");
        Car.Engine engine = car.new Engine();
         engine.setEngineType("Crysler.");
        System.out.println(engine.getEngineType());
    }
}
