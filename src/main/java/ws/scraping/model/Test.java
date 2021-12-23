package ws.scraping.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ws_test")
public class Test {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "local_date")
    private final LocalDate crateDate = LocalDate.now();

    @Column(name = "is_active")
    private final boolean isActive = true;

    @Column(name = "test_field")
    private String testField;

    public Test(String testField) {
        this.testField = testField;
    }
}


