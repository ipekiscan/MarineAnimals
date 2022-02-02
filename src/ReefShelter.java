import java.util.Objects;

public class ReefShelter extends Shelter{
    private int surfaceArea;

    @Override
    public String toString() {
        return super.toString() + " - SurfaceArea : " + surfaceArea + "m2";
    }

    public int getSurfaceArea() {
        return surfaceArea;
    }

    public ReefShelter(String ID, int volume, boolean availability, int surfaceArea) {
        super(ID, volume, availability, "Warm Trophic", "Tropical");
        this.surfaceArea = surfaceArea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ReefShelter that = (ReefShelter) o;
        return surfaceArea == that.surfaceArea;
    }
}
