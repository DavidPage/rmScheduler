package start.web.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class WebBooking {

	private Long propertyId;
	private Long registrantId;
	private Long timestamp;

	@JsonCreator
	public WebBooking(
			@JsonProperty("propertyId") Long propertyId,
			@JsonProperty("registrantId") Long registrantId,
			@JsonProperty("timestamp") Long timestamp
	) {
		this.propertyId = propertyId;
		this.registrantId = registrantId;
		this.timestamp = timestamp;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		WebBooking that = (WebBooking) o;
		return Objects.equals(propertyId, that.propertyId) &&
				Objects.equals(registrantId, that.registrantId) &&
				Objects.equals(timestamp, that.timestamp);
	}

	@Override
	public int hashCode() {
		return Objects.hash(propertyId, registrantId, timestamp);
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public Long getPropertyId() {
		return propertyId;
	}

	public Long getRegistrantId() {
		return registrantId;
	}
}
