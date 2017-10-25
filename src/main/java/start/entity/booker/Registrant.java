package start.entity.booker;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Registrant {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String email;


	Registrant() { // Needed for JPA!
	}

	public Registrant(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Registrant registrant = (Registrant) o;

		if (id != null ? !id.equals(registrant.id) : registrant.id != null) {
			return false;
		}
		return email != null ? email.equals(registrant.email) : registrant.email == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (email != null ? email.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Booker{" +
				"id=" + id +
				", email=" + email +
				'}';
	}
}
