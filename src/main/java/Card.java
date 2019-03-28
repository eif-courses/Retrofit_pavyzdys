import com.google.gson.annotations.SerializedName;

public class Card {
    private String name;
    private String type;
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
