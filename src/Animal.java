import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Animal {
    private String name;
    private int volumeNeeded;
    private List<String> shelterOptions;

    public String getName() {
        return name;
    }

    public int getVolumeNeeded() {
        return volumeNeeded;
    }

    public List<String> getShelterOptions() {
        return shelterOptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return volumeNeeded == animal.volumeNeeded && name.equals(animal.name) && shelterOptions.equals(animal.shelterOptions);
    }

    public Animal(String name, int volumeNeeded, List<String> shelterOptions) {
        this.name = name;
        this.volumeNeeded = volumeNeeded;
        this.shelterOptions = shelterOptions;
    }

    @Override
    public String toString() {
        return name + " - Requires: " + volumeNeeded + "m3 - Preferred shelter: " + String.join(", ", this.shelterOptions);
    }


    public static Animal createNewAnimalFromEntry(String entry){
        String[] fields = entry.split("; ");
        return new Animal(fields[0], Integer.parseInt(fields[1]), Arrays.asList(fields[2].split(", ")));
    }

    public boolean isShelterSuitable(Shelter s){
        if(s instanceof TundraShelter) {
            return this.shelterOptions.contains("Tundra");
        }else if(s instanceof CoastalShelter){
            return this.shelterOptions.contains("Coastal");
        }else if(s instanceof ReefShelter){
            return this.shelterOptions.contains("Reef");
        }
        return false;
    }
}
