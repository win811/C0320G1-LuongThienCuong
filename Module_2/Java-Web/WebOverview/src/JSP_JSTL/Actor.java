package JSP_JSTL;

public class Actor {
    private String name;
    private String age;
    private String nation;
    private String description;
    private String image;

    public Actor() {
    }

    public Actor(String name, String age, String nation, String description, String image) {
        this.name = name;
        this.age = age;
        this.nation = nation;
        this.description = description;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getNation() {
        return nation;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }
}
