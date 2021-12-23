package ws.scraping.dto.bean;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class TestDto {
    private Integer id;
    private LocalDate createDate;
    private Boolean isActive;
    private String testField;
}
