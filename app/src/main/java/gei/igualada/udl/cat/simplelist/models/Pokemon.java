package gei.igualada.udl.cat.simplelist.models;

public class Pokemon {

    private String name;
    private int id;
    private int height;
    private int weight;

    public Pokemon(String name, int id, int height, int weight) {
        this.name = name;
        this.id = id;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }


}
