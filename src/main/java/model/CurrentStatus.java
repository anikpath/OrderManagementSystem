package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrentStatus {
    public static final CurrentStatus CREATED = new CurrentStatus("CREATED");
    public static final CurrentStatus PROCESSING = new CurrentStatus("PROCESSING");
    public static final CurrentStatus COMPLETED = new CurrentStatus("COMPLETED");
    public static final CurrentStatus CANCELLED = new CurrentStatus("CANCELLED");

    private String value;

    private CurrentStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
