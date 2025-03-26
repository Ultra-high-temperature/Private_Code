package javaTest.build;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// 最终产品类
public class SmartFactory {
    private final String factoryName;
    private final List<ProductionLine> productionLines;
    private final EnergyManagement energyManagement;

    private SmartFactory(Builder builder) {
        this.factoryName = builder.factoryName;
        this.productionLines = (builder.productionLines);
        this.energyManagement = builder.energyManagementBuilder.build();
    }

    public static Builder builder(String factoryName) {
        return new Builder(factoryName);
    }

    // Builder类
    public static class Builder {
        private final String factoryName;
        private final List<ProductionLine> productionLines = new ArrayList<>();
        private EnergyManagement.Builder energyManagementBuilder = EnergyManagement.builder();

        private Builder(String factoryName) {
            if (factoryName == null || factoryName.trim().isEmpty()) {
                throw new IllegalArgumentException("Factory name cannot be empty");
            }
            this.factoryName = factoryName;
        }

        public Builder addProductionLine(ProductionLine line) {
            this.productionLines.add(Objects.requireNonNull(line, "Production line cannot be null"));
            return this;
        }

        public EnergyManagement.Builder energyManagement() {
            return this.energyManagementBuilder;
        }

        public SmartFactory build() {
            if (productionLines.isEmpty()) {
                throw new IllegalStateException("At least one production line is required");
            }
            return new SmartFactory(this);
        }
    }

    // 生产线类
    static class ProductionLine {
        private final String lineId;
        private final List<IndustrialDevice> devices;
        private final ProductionSchedule schedule;

        private ProductionLine(String lineId, List<IndustrialDevice> devices, ProductionSchedule schedule) {
            this.lineId = lineId;
            this.devices = (devices);
            this.schedule = schedule;
        }

        public static ProductionLineBuilder builder(String lineId) {
            return new ProductionLineBuilder(lineId);
        }

        // 生产线Builder
        static class ProductionLineBuilder {
            private final String lineId;
            private final List<IndustrialDevice> devices = new ArrayList<>();
            private ProductionSchedule schedule;

            public ProductionLineBuilder(String lineId) {
                if (lineId == null || lineId.trim().isEmpty()) {
                    throw new IllegalArgumentException("Line ID cannot be empty");
                }
                this.lineId = lineId;
            }

            public ProductionLineBuilder addDevice(IndustrialDevice device) {
                devices.add(Objects.requireNonNull(device, "Device cannot be null"));
                return this;
            }

            public ProductionLineBuilder schedule(ProductionSchedule schedule) {
                this.schedule = Objects.requireNonNull(schedule, "Schedule cannot be null");
                return this;
            }

            public ProductionLine build() {
                if (devices.isEmpty()) {
                    throw new IllegalStateException("At least one device required for production line");
                }
                if (schedule == null) {
                    throw new IllegalStateException("Production schedule is required");
                }
                return new ProductionLine(lineId, devices, schedule);
            }
        }
    }

    // 设备类
    static class IndustrialDevice {
        private final String deviceId;
        private final DeviceType type;
        private final MaintenanceSchedule maintenance;

        private IndustrialDevice(String deviceId, DeviceType type, MaintenanceSchedule maintenance) {
            this.deviceId = deviceId;
            this.type = type;
            this.maintenance = maintenance;
        }

        public static DeviceBuilder builder(String deviceId) {
            return new DeviceBuilder(deviceId);
        }

        // 设备Builder
        static class DeviceBuilder {
            private final String deviceId;
            private DeviceType type;
            private MaintenanceSchedule maintenance;

            public DeviceBuilder(String deviceId) {
                if (deviceId == null || deviceId.trim().isEmpty()) {
                    throw new IllegalArgumentException("Device ID cannot be empty");
                }
                this.deviceId = deviceId;
            }

            public DeviceBuilder type(DeviceType type) {
                this.type = Objects.requireNonNull(type, "Device type cannot be null");
                return this;
            }

            public DeviceBuilder maintenance(MaintenanceSchedule maintenance) {
                this.maintenance = maintenance;
                return this;
            }

            public IndustrialDevice build() {
                if (type == null) {
                    throw new IllegalStateException("Device type is required");
                }
                return new IndustrialDevice(deviceId, type, maintenance);
            }
        }
    }

    // 其他辅助类
    enum DeviceType { CNC_MACHINE, ROBOTIC_ARM, CONVEYOR_BELT }

    static class ProductionSchedule { /* 排产计划详情 */ }
    static class MaintenanceSchedule { /* 维护计划详情 */ }

    static class EnergyManagement {
        private final boolean solarPowerEnabled;
        private final double maxPowerConsumption;

        private EnergyManagement(boolean solarPowerEnabled, double maxPowerConsumption) {
            this.solarPowerEnabled = solarPowerEnabled;
            this.maxPowerConsumption = maxPowerConsumption;
        }

        public static EnergyManagement.Builder builder() {
            return new EnergyManagement.Builder();
        }

//        public static SmartFactory.Builder and() {
//            return SmartFactory.this;
//        }

        static class Builder {
            private boolean solarPowerEnabled = false;
            private double maxPowerConsumption = 1000.0; // 默认值

            public Builder enableSolarPower(boolean enable) {
                this.solarPowerEnabled = enable;
                return this;
            }

            public Builder maxPowerConsumption(double max) {
                if (max <= 0) throw new IllegalArgumentException("Invalid power consumption");
                this.maxPowerConsumption = max;
                return this;
            }

            public EnergyManagement build() {
                return new EnergyManagement(solarPowerEnabled, maxPowerConsumption);
            }
        }
    }
}

// 使用示例

