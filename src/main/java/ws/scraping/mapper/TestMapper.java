package ws.scraping.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ws.scraping.dto.bean.TestDto;
import ws.scraping.dto.response.TestResponse;
import ws.scraping.model.Test;

import java.util.Objects;

@Component
public class TestMapper {

    public static TestDto toDto(Test model){
        return Objects.nonNull(model) ?
                TestDto.builder()
                        .id(model.getId())
                        .createDate(model.getCrateDate())
                        .isActive(model.isActive())
                        .testField(model.getTestField())
                        .build() : null;
    }

    public static TestResponse toResponse(TestDto testDto) {
        return Objects.nonNull(testDto) ?
                TestResponse.builder()
                        .id(testDto.getId())
                        .createDate(testDto.getCreateDate())
                        .testField(testDto.getTestField())
                        .isActive(testDto.getIsActive())
                        .build() : null;
    }

}
