import java.util.Comparator;

public class AnimalComparator implements Comparator<Animal> {
    public int compare(Animal o1, Animal o2) {
        int especies = o1.getEspecie().compareTo(o2.getEspecie()) * 1000000;
        int edades = o2.getEdad() - o1.getEdad();
        return especies + edades;
    }
}
