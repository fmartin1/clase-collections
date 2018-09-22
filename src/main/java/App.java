import java.util.*;
import java.util.stream.Collectors;

public class App {

    public static void main(String args[]) {
        Animal fido = new Animal();
        fido.setEdad(2);
        fido.setNombre("Fido");
        fido.setEspecie("Perro");

        Animal frido = new Animal();
        frido.setEdad(2);
        frido.setNombre("Frido");
        frido.setEspecie("Perro");

  //      System.out.println("Frido y fido son iguales? " + frido.equals(fido));

        Animal spike = new Animal();
        spike.setEspecie("Perro");
        spike.setEdad(4);
        spike.setNombre("Spike");

        List<Animal> animales = new ArrayList<Animal>();
        animales.add(frido);
        animales.add(spike);
        animales.add(fido);

        Animal tulio = new Animal();
        tulio.setNombre("Tulio");
        tulio.setEdad(79);
        tulio.setEspecie("Ave");

        animales.add(tulio);

        Collections.sort(animales, new AnimalComparator());

        for (Animal a : animales) {
            System.out.println(a);
        }

        Set<Animal> animalesUnicos = new HashSet<Animal>();
        animalesUnicos.add(tulio);
        animalesUnicos.add(spike);
        animalesUnicos.add(fido);

        Animal tuluoImpostor = new Animal();
        tuluoImpostor.setNombre("Tulio");
        tuluoImpostor.setEspecie("Ave");
        tuluoImpostor.setEdad(79);

        if (!animalesUnicos.add(tuluoImpostor)) {
            System.out.println("Impostor detectado");
        }

        System.out.println("En mi set hay " + animalesUnicos.size() + " animales.");

        Map<String, Animal> enciclopedia = new HashMap<String, Animal>();
        enciclopedia.put("A02", tulio);
        enciclopedia.put("Fido", fido);

        System.out.println("Dame a Tulio " + enciclopedia.get("A02"));

        if(enciclopedia.containsKey("Fido")){
            //
        }

        Animal anterior = enciclopedia.put("Fido", frido);

        System.out.println(anterior);

        animales.stream()
                .filter(a-> "Perro".equals(a.getEspecie()))
                .map(Animal::getNombre)
                .forEach(a-> System.out.println(a));


        Animal[] animalArr = new Animal[5];

        if (animales.stream().anyMatch(a-> 100 < a.getEdad()))
            System.out.println("Hay animales muy viejos aqui");

        System.out.println(animales.stream().filter(a-> "Ave".equals(a.getEspecie())).count());

    }
}
