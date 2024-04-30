package model;

import lombok.*;

import java.util.List;

@Data
@Setter

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Order {
    private Long id;
    private List<OrderDetails> items;
    private CurrentStatus status;

    public Order(int i, List<OrderDetails> items, CurrentStatus status) {
        this.id = id;
        this.items = items;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderDetails> getItems() {
        return items;
    }

    public void setItems(List<OrderDetails> items) {
        this.items = items;
    }

    public CurrentStatus getStatus() {
        return status;
    }

    public void setStatus(CurrentStatus status) {
        this.status = status;
    }
}
