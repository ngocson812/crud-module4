package codegym.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idcate;
    private String namecate;

    public Category() {
    }

    public Category(long idcate, String namecate) {
        this.idcate = idcate;
        this.namecate = namecate;
    }

    public long getIdcate() {
        return idcate;
    }

    public void setIdcate(long idcate) {
        this.idcate = idcate;
    }

    public String getNamecate() {
        return namecate;
    }

    public void setNamecate(String namecate) {
        this.namecate = namecate;
    }
}
