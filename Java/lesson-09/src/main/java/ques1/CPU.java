package ques1;

public class CPU {
    private double price;

    public double getPrice() {
        return price;
    }

    public class Processor {
        private double coreAmount;
        private String menufacturer;

        public double getCoreAmount() {
            return coreAmount;
        }

        public String getMenufacturer() {
            return menufacturer;
        }

        public double getCache(){
            return 4.3 ;
        }
    }

    public class Ram {
        private String memory;
        private String menufacturer;

        public String getMemory() {
            return memory;
        }

        public String getMenufacturer() {
            return menufacturer;
        }

        public double getClockSpeed(){
            return 5.5;
        }
    }

    public static void main(String[] args) {
        CPU cpu = new CPU();
        CPU.Processor processor = cpu.new Processor();
        System.out.println( processor.getCache());

        CPU.Ram ram = cpu.new Ram();
        System.out.println(ram.getClockSpeed());

    }
}
