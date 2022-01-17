package codegym.model;


import javax.persistence.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String time;
    private String img;
    private String descrep;
    private String vid;

    @ManyToOne
    private Category categories;

    public Movie() {
    }

    public Movie(int id, String name, String time, String img, String descrep, String vid, Category categories) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.img = img;
        this.descrep = descrep;
        this.vid = vid;
        this.categories = categories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescrep() {
        return descrep;
    }

    public void setDescrep(String descrep) {
        this.descrep = descrep;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public Category getCategories() {
        return categories;
    }

    public void setCategories(Category categories) {
        this.categories = categories;
    }
}
