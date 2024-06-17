package com.apple.user_check.Validation;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Validation {
    private String ip;
    private String userAgent;
    private String browser;
    private String os;
    private String webType;
}
