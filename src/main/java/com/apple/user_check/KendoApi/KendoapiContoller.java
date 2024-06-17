package com.apple.user_check.KendoApi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:63342")
public class KendoapiContoller {

    @GetMapping("/random-data")
    public List<Kendoapi.Data> getRandomData() {
        List<Kendoapi.Data> dataList = new ArrayList<>();
        dataList.add(new Kendoapi.Data(1, "Tom", 25));
        dataList.add(new Kendoapi.Data(2, "John", 30));
        dataList.add(new Kendoapi.Data(3, "Annie", 28));

        Kendoapi data = new Kendoapi(3, dataList, null);

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS); // 빈 객체 직렬화 허용

        try {
            String json = mapper.writeValueAsString(data);
            System.out.println(json); // JSON 문자열 출력
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return dataList;
    }
}
