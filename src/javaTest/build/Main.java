package javaTest.build;

public class Main {
    public static void main(String[] args) {
//        SmartFactory factory = SmartFactory.builder("Future Factory 3.0")
//                .addProductionLine(SmartFactory.ProductionLine.builder("Line-A1")
//                        .addDevice(SmartFactory.IndustrialDevice.builder("CNC-001")
//                                .type(SmartFactory.DeviceType.CNC_MACHINE)
//                                .maintenance(new SmartFactory.MaintenanceSchedule())
//                                .build())
//                        .addDevice(SmartFactory.IndustrialDevice.builder("Robot-202")
//                                .type(SmartFactory.DeviceType.ROBOTIC_ARM)
//                                .build())
//                        .schedule(new SmartFactory.ProductionSchedule())
//                        .build())
//                .energyManagement()
//                .enableSolarPower(true)
//                .maxPowerConsumption(2000.0)
//                .and() // 返回上级builder的语法需要额外实现
//                .build();
        SmartFactory builder = SmartFactory.builder("Future Factory 3.0")
                .addProductionLine(SmartFactory.ProductionLine.builder("Line-A1")
                        .addDevice(SmartFactory.IndustrialDevice.builder("CNC-001")
                                .type(SmartFactory.DeviceType.CNC_MACHINE)
                                .maintenance(new SmartFactory.MaintenanceSchedule())
                                .build())
                        .addDevice(SmartFactory.IndustrialDevice.builder("Robot-202")
                                .type(SmartFactory.DeviceType.ROBOTIC_ARM)
                                .build())
                        .schedule(new SmartFactory.ProductionSchedule())
                        .build())
                .build();
    }
}