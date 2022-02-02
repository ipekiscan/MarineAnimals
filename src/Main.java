import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Animal> readAnimals(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        List<Animal> animals = new ArrayList<>();
        while(line != null){
            animals.add(Animal.createNewAnimalFromEntry(line));
            line = reader.readLine();
        }
        return animals;
    }

    public static List<Shelter> readShelters(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        List<Shelter> shelters = new ArrayList<>();
        while(line != null){
            shelters.add(Shelter.createNewShelterFromEntry(line));
            line = reader.readLine();
        }
        return shelters;
    }

    public static void main(String[] args) {
        String prompt = " \n" +
                "Please make your choice:  \n" +
                "1 – Show all shelters \n" +
                "2 – Show all animals \n" +
                "3 – Show all shelters suitable for a specific animal \n" +
                "4 – Show the optimal shelters for a specific animal \n" +
                "5 – Show the constant properties per shelter type \n" +
                "6 – Stop the program ";

        Scanner input = new Scanner(System.in);
        System.out.print("What file has the shelter information: ");
        String shelterFile = input.next();

        System.out.print("What file has the animal information: ");
        String animalFile = input.next();

        List<Shelter> shelters;
        List<Animal> animals;

        try (BufferedReader shelterReader = new BufferedReader(new FileReader(shelterFile))) {
            shelters = readShelters(shelterReader);
        }catch (IOException e){
            System.err.println("Can't open file "+shelterFile);
            return;
        }

        try (BufferedReader animalReader = new BufferedReader(new FileReader(animalFile))) {
            animals = readAnimals(animalReader);
        }catch (IOException e){
            System.err.println("Can't open file " + animalFile);
            return;
        }

        int option = 0;

        while(option != 6){
            System.out.println(prompt);
            option = input.nextInt();
            switch (option){
                case 1:
                    for(Shelter s : shelters)
                        System.out.println(s.toString());
                    break;
                case 2:
                    for(Animal a : animals)
                        System.out.println(a.toString());
                    break;
                case 3:
                    System.out.println("What animal would you like to check?");
                    String animalsearch = input.next();
                    Animal animal = null;
                    for(Animal a : animals){
                        if(a.getName().equals(animalsearch)){
                            animal = a;
                            break;
                        }
                    }
                    if(animal == null){
                        System.err.println("That animal is not on the system.");
                        break;
                    }
                    for(Shelter s : shelters){
                        if(animal.isShelterSuitable(s)){
                            System.out.println(s.toString());
                        }
                    }
                    break;

                case 4:
                    break;

                case 5:
                    System.out.println("Please enter shelter type: ");
                    break;

                case 6:
                    break;
                default:
                    System.out.println("Please select a valid option!");
            }
        }
    }
}