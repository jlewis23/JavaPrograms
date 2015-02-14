

public class Vehicle 
{
    private String name;
    private String make;
    private String model;
    private int year;
    private int numDoors;
    private boolean isConvertible;
    private boolean isManual;
    private boolean powerPackage;
    private String engine;
    private boolean is4By4;
    private boolean isOverdrive;
    private int milesDriven;
    private int numSeats;
    private boolean hasGPS;
    private boolean has8Track;
    
    Vehicle(VehicleBuilder builder)
    {
        make = builder.make;
        model = builder.model;
        year = builder.year;
        numDoors = builder.numDoors;
        isConvertible = builder.isConvertible;
        isManual = builder.isManual;
        powerPackage = builder.powerPackage;
        engine = builder.engine;
        is4By4 = builder.is4By4;
        isOverdrive = builder.isOverdrive;
        milesDriven = builder.milesDriven;
        numSeats = builder.numSeats;
        hasGPS = builder.hasGPS;
        has8Track = builder.has8Track;
    }

    public void drive(int miles)
    {
        milesDriven += miles;
        System.out.println("Total miles driven is " + milesDriven);
    }
    
    @Override
    public String toString()
    {
        return "Vehicle [name=" + name + ", make=" + make + ", modle=" + model
                + ", year=" + year + ", numDoors=" + numDoors
                + ", isConvertible=" + isConvertible + ", isManual=" + isManual
                + ", powerPackage=" + powerPackage + ", engine=" + engine
                + ", is4By4=" + is4By4 + ", isOverdrive=" + isOverdrive
                + ", milesDriven=" + milesDriven + ", numSeats=" + numSeats
                + ", hasGPS=" + hasGPS + ", has8Track=" + has8Track + "]";
    }
    
    public static class VehicleBuilder
    {
        private String make;
        private String model;
        private int year;
        private int numDoors;
        private boolean isConvertible;
        private boolean isManual;
        private boolean powerPackage;
        private String engine;
        private boolean is4By4;
        private boolean isOverdrive;
        private int milesDriven;
        private int numSeats;
        private boolean hasGPS;
        private boolean has8Track;
        
        public VehicleBuilder setMake(String make)
        {
            this.make = make;
            return this;
        }
        
        public VehicleBuilder setModel(String model)
        {
            this.model = model;
            return this;
        }
        
        public VehicleBuilder setYear(int year)
        {
            this.year = year;
            return this;
        }
        
        public VehicleBuilder setNumDoor(int numDoors)
        {
            this.numDoors = numDoors;
            return this;
        }
        
        public Vehicle getResult()
        {
            Vehicle myVehicle = new Vehicle(this);
            return myVehicle;
        }
    }
}