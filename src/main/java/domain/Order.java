package domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderDate;

    @ManyToOne
    private User user;

    @ManyToMany
    private List<Product> products;

    private String status;

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }

    public BigDecimal calculateTotal() {
        return products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void processOrder() {
        this.status = "InBearbeitung";
        // Weitere Logik zur Verarbeitung der Bestellung
    }

    public void shipOrder() {
        this.status = "Versendet";
        // Weitere Logik zum Versenden der Bestellung
    }

    public void deliverOrder() {
        this.status = "Geliefert";
        // Weitere Logik zur Lieferung der Bestellung
    }

    public void completeOrder() {
        this.status = "Abgeschlossen";
        // Weitere Logik zum Abschluss der Bestellung
    }

    public void cancelOrder() {
        this.status = "Storniert";
        // Weitere Logik zur Stornierung der Bestellung
    }

    public void requestReturn() {
        this.status = "Rücksendung";
        // Weitere Logik zur Anforderung der Rücksendung
    }

    public void processReturn() {
        this.status = "RücksendungInBearbeitung";
        // Weitere Logik zur Bearbeitung der Rücksendung
    }

    public void refundOrder() {
        this.status = "Rückerstattet";
        // Weitere Logik zur Rückerstattung
    }
}

