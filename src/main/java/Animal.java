import java.util.Objects;

public class Animal implements Comparable<Animal> {

    private String nombre;
    private int edad;
    private String especie;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return edad == animal.edad &&
                Objects.equals(nombre, animal.nombre) &&
                Objects.equals(especie, animal.especie);
    }

    @Override

    public int hashCode() {

        return Objects.hash(nombre, edad, especie);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", especie='" + especie + '\'' +
                '}';
    }

    public int compareTo(Animal o) {
        if(o == this) return 0;
        int e = especie.compareTo(o.especie) * 10000;
        int edades = edad - o.edad;
        return e + edades;
    }
}
