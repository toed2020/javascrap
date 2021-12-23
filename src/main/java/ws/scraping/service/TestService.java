package ws.scraping.service;

import ws.scraping.dto.request.TestRequest;
import ws.scraping.dto.response.TestResponse;

public interface TestService {
    TestResponse getTestInfoById(final Integer testId);
    TestResponse getTestInfoByTestField(final String field);
    TestResponse saveTestInfo(TestRequest request);
}
