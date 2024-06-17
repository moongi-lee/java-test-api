package com.apple.user_check.KendoApi;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Kendoapi {
    private Integer total;
    private List<Data> data;
    private Aggregates aggregates;


    public static class Data {
        @JsonProperty("ID")
        private int ID;
        @JsonProperty("Name")
        private String Name = ""; // 기본 값 초기화
        @JsonProperty("Age")
        private int Age = 0; // 기본 값 초기화

        // 생성자
        public Data(int ID, String Name, int Age) {
            this.ID = ID;
            this.Name = Name;
            this.Age = Age;
        }
    // Aggregates 객체 클래스
    }
    public static class Aggregates {
        // Aggregates 객체에 필요한 필드 정의 (집계 정보)
        // 예: 총합, 평균, 최대값, 최소값 등
        private int sum;
    }
}
