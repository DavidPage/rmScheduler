package start.entity.booking;

import start.entity.booker.Booker;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Booking {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Booker booker;

	public Booking() {//for JPA

	}

	public Booking(Booker booker) {
		this.booker = booker;
	}

	public Long getId() {
		return id;
	}

	public Booker getBooker() {
		return booker;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Booking booking = (Booking) o;
		return Objects.equals(id, booking.id) &&
				Objects.equals(booker, booking.booker);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, booker);
	}

	@Override
	public String toString() {
		return "Booking{" +
				"id=" + id +
				", booker=" + booker +
				'}';
	}
}
