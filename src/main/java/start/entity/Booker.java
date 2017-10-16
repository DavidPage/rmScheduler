package start.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Booker {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String bookerName;

    Booker() { // Needed for JPA!
    }

    public Booker(String bookerName) {
        this.bookerName = bookerName;
    }

    public Long getId() {
        return id;
    }

    public String getBookerName() {
        return bookerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Booker booker = (Booker) o;

        if (id != null ? !id.equals(booker.id) : booker.id != null) return false;
        return bookerName != null ? bookerName.equals(booker.bookerName) : booker.bookerName == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (bookerName != null ? bookerName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Booker{" +
                "id=" + id +
                ", bookerName=" + bookerName +
                '}';
    }
}
