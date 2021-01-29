package ru.job4j.stream;

public class Computer {

    private String motherboard;
    private String cpu;
    private int cpuSpeed;
    private String gpu;
    private int gpuTakt;
    private String ssd;
    private int ssdCapacity;

    public static class Builder {
        private String motherboard;
        private String cpu;
        private int cpuSpeed;
        private String gpu;
        private int gpuTakt;
        private String ssd;
        private int ssdCapacity;

        Builder buildMotherboard(String motherboard) {
            this.motherboard = motherboard;
            return this;
        }

        Builder buildCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        Builder buildCpuSpeed(int cpuSpeed) {
            this.cpuSpeed = cpuSpeed;
            return this;
        }

        Builder buildGpuTakt(int gpuTakt) {
            this.gpuTakt = gpuTakt;
            return this;
        }

        Builder buildGpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        Builder buildSsd(String ssd) {
            this.ssd = ssd;
            return this;
        }

        Builder buildSsdCapacity(int ssdCapacity) {
            this.ssdCapacity = ssdCapacity;
            return this;
        }

        Computer build() {
            Computer comp = new Computer();
            comp.motherboard = motherboard;
            comp.cpu = cpu;
            comp.cpuSpeed = cpuSpeed;
            comp.gpu = gpu;
            comp.gpuTakt = gpuTakt;
            comp.ssd = ssd;
            comp.ssdCapacity = ssdCapacity;
            return comp;
        }
    }

    @Override
    public String toString() {
        return "Computer{"
                + "motherboard='" + motherboard + '\''
                + ", cpu='" + cpu + '\''
                + ", cpuSpeed=" + cpuSpeed
                + ", gpu='" + gpu + '\''
                + ", gpuTakt=" + gpuTakt
                + ", ssd='" + ssd + '\''
                + ", ssdCapacity=" + ssdCapacity
                + '}';
    }

    public static void main(String[] args) {
        Computer computer = new Builder().buildMotherboard("qwe")
                .buildCpu("asd")
                .buildCpuSpeed(3700)
                .buildGpu("zxc")
                .buildGpuTakt(1500)
                .buildSsd("fgh")
                .buildSsdCapacity(2048)
                .build();
        System.out.println(computer);
    }
}
