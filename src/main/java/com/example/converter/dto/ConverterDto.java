package com.example.converter.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ConverterDto {
    private String conversionId;
    private String status;
    private String pdfUrl;
    private String convertedPath;
    private String createdTime;
    private String modifiedTime;
}
