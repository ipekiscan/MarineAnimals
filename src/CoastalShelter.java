public class CoastalShelter extends Shelter{
    private int surfaceArea;

    @Override
    public String toString() {
        return super.toString() + " - SurfaceArea : " + surfaceArea + "m2";
    }

    public CoastalShelter(String ID, int volume, boolean availability, int surfaceArea) {
        super(ID, volume, availability, "Cool Eutrophic", "Temperate");
        this.surfaceArea = surfaceArea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CoastalShelter that = (CoastalShelter) o;
        return surfaceArea == that.surfaceArea;
    }

    public int getSurfaceArea() {
        return surfaceArea;
    }
}
