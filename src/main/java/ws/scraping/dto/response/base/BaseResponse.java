package ws.scraping.dto.response.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class BaseResponse {

    public final static int GENERAL_ERROR = 500;

    public final static int DATA_NOT_AVAILABLE_ERROR = 503;

    public final static int NOT_FOUND_ERROR = 404;

    public final static int VALIDATION_ERROR = 400;

    public final static int FORBIDDEN_ERROR = 403;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer code;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object errorDetails;

    public BaseResponse(final int pCode, final String pMessage) {
        code = pCode;
        message = pMessage;
    }

    public BaseResponse(final int pCode, final String pMessage, final Object pErrorDetails) {
        code = pCode;
        message = pMessage;
        errorDetails = pErrorDetails;
    }
}
