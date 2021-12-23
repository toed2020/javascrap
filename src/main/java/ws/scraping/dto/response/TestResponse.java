package ws.scraping.dto.response;

import lombok.*;
import lombok.experimental.Accessors;
import ws.scraping.dto.response.base.BaseResponse;

import java.time.LocalDate;



@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TestResponse extends BaseResponse {
    private Integer id;
    private LocalDate createDate;
    private Boolean isActive;
    private String testField;

    public TestResponse(Integer status, String validationMessage) {
        super(status, validationMessage);
    }

}
