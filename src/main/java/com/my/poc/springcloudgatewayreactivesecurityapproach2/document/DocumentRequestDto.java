package com.my.poc.springcloudgatewayreactivesecurityapproach2.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentRequestDto {
    String documentId;
    String bearerToken;
}
