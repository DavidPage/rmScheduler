package start.entity.booking;

import start.entity.booker.Registrant;

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
	private Registrant registrant;

	public Booking() {//for JPA
	}

	public Booking(Registrant registrant, Long propertyId) {
		this.registrant = registrant;
		this.propertyId = propertyId;
	}

	public Registrant getRegistrant() {
		return registrant;
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
				Objects.equals(registrant, booking.registrant);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, propertyId, registrant);
	}

	@Override
	public String toString() {
		return "Booking{" +
				"id=" + id +
				", propertyId=" + propertyId +
				", booker=" + registrant +
				'}';
	}
}
