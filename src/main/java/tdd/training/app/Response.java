package tdd.training.app;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@JsonAutoDetect(fieldVisibility= JsonAutoDetect.Visibility.ANY)
public class Response {

    private final String status;
    private final String message;

    private Response(String status, String message) {
        this.status = status;
        this.message = message;
    }

    private Response(String status) {
        this(status, null);
    }

    public static Response success() {
        return new Response("Success");
    }
    public static Response failure(String message) {
        return new Response("Failure", message);
    }
    
    @Override
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
    @Override
    public String toString() {
        return String.format("%s - %s", status, message);
    }
}