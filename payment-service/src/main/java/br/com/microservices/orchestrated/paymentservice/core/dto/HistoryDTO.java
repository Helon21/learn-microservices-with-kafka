package br.com.microservices.orchestrated.paymentservice.core.dto;

import br.com.microservices.orchestrated.paymentservice.core.enums.ESagaStatus;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HistoryDTO {

    private String source;
    private ESagaStatus status;
    private String message;
    private LocalDateTime createdAt;
}