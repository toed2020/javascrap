package ws.scraping.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import ws.scraping.dto.bean.TestDto;
import ws.scraping.dto.request.TestRequest;
import ws.scraping.dto.response.TestResponse;
import ws.scraping.mapper.TestMapper;
import ws.scraping.model.Test;
import ws.scraping.repository.TestRepository;
import ws.scraping.service.TestService;

import java.util.List;
import java.util.Objects;

import static ws.scraping.dto.response.base.BaseResponse.GENERAL_ERROR;
import static ws.scraping.dto.response.base.BaseResponse.VALIDATION_ERROR;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository repository;

    @Override
    public TestResponse getTestInfoById(Integer testId) {
        TestResponse response;
        Test test = repository.findById(testId)
                .orElse(null);
        if (Objects.nonNull(test)) {
            response = TestMapper.toResponse(TestMapper.toDto(test));
        } else {
            response = new TestResponse(GENERAL_ERROR,
                    "Error get test info by id: " + testId);
        }
        return response;
    }

    @Override
    public TestResponse getTestInfoByTestField(String field) {
        TestResponse response;
        List<Test> testList = repository.findAllByTestField(field);
        if (Objects.nonNull(testList) && !CollectionUtils.isEmpty(testList)) {
            response = TestMapper.toResponse(TestMapper.toDto(
                    testList.stream()
                            .filter(Objects::nonNull)
                            .findFirst().orElse(null)
            ));
        } else {
            response = new TestResponse(GENERAL_ERROR,
                    "Error get test info by test field");
        }
        return response;
    }

    @Override
    public TestResponse saveTestInfo(TestRequest request) {
        TestResponse response;
        if (Objects.nonNull(request) && Objects.nonNull(request.getTestField())) {
            TestDto testDto = TestMapper.toDto(repository.save(new Test(request.getTestField())));
            response = TestMapper.toResponse(testDto);
        } else {
            response = new TestResponse(VALIDATION_ERROR,
                    "Saved field is incorrect.");
        }
        return response;
    }
}
