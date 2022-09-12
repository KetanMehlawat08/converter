package com.example.converter.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "Converter")
public class Converter {
    @Id
    private String conversionId;
    private String status;
    private String pdfUrl;
    private String convertedPath;
    private String createdTime;
    private String modifiedTime;
}
