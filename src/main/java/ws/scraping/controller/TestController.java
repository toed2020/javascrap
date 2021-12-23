package ws.scraping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ws.scraping.dto.request.TestRequest;
import ws.scraping.dto.response.TestResponse;
import ws.scraping.service.TestService;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private TestService service;


    @GetMapping(value = "/get-test/{id}")
    public TestResponse getTestById(@PathVariable Integer id) {
        return service.getTestInfoById(id);
    }

    @PostMapping(value = "/save")
    public TestResponse saveTestField(@RequestBody TestRequest request) {
        return service.saveTestInfo(request);
    }

    @GetMapping(value = "/get/{field}")
    public TestResponse getTestByField(@PathVariable String field) {
        return service.getTestInfoByTestField(field);
    }
}
