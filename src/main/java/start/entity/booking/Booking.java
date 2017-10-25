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

	private Long propertyId;

	@ManyToOne
	private Booker booker;

	public Booking() {//for JPA
	}

	public Booking(Booker booker, Long propertyId) {
		this.booker = booker;
		this.propertyId = propertyId;
	}

	//will print the id of each booking
//	public Long getId() {
//		return id;
//	}

	public Booker getBooker() {
		return booker;
	}

	public Long getPropertyId() {
		return propertyId;
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
				Objects.equals(propertyId, booking.propertyId) &&
				Objects.equals(booker, booking.booker);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, propertyId, booker);
	}

	@Override
	public String toString() {
		return "Booking{" +
				"id=" + id +
				", propertyId=" + propertyId +
				", booker=" + booker +
				'}';
	}
}
