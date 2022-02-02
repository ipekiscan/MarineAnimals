import java.util.Objects;

public abstract class Shelter {
    private String ID;
    private boolean availability;
    private int volume;
    private final String waterType;
    private final String climate;

    public Shelter(String ID, int volume, boolean availability, String waterType, String climate) {
        this.ID = ID;
        this.availability = availability;
        this.waterType = waterType;
        this.climate = climate;
        this.volume = volume;
    }

    public String getID() {
        return ID;
    }

    public boolean isAvailable() {
        return availability;
    }

    public String getWaterType() {
        return waterType;
    }

    public int getVolume() {
        return volume;
    }

    public String getClimate() {
        return climate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shelter shelter = (Shelter) o;
        return availability == shelter.availability && Objects.equals(ID, shelter.ID) && Objects.equals(waterType, shelter.waterType) && Objects.equals(climate, shelter.climate);
    }

    @Override
    public String toString() {
        return "ID : " + ID + " - Volume : " + volume + " m3 - Available u " + (availability ? "True" : "False");
    }

    public static Shelter createNewShelterFromEntry(String entry){
        String[] fields = entry.split(" ");
        String type = fields[0];
        String id = fields[1];
        int volume = Integer.parseInt(fields[2]);
        boolean availability = Boolean.parseBoolean(fields[3]);
        if(type.equals("Tundra")){
            return new TundraShelter(id, volume, availability);
        }
        int surfaceArea = Integer.parseInt(fields[4]);

        if(type.equals("Coastal")){
            return new CoastalShelter(id, volume, availability, surfaceArea);
        }else{
            return new ReefShelter(id, volume, availability, surfaceArea);
        }
    }
}