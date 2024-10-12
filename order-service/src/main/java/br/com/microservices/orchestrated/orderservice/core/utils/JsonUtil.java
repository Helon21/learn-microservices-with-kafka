package br.com.microservices.orchestrated.orderservice.core.utils;

import br.com.microservices.orchestrated.orderservice.core.document.Event;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class JsonUtil {

    private final ObjectMapper objectMapper;

    public String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception ex) {
            log.error("Error converting object to JSON: {}", ex.getMessage(), ex);
            throw new RuntimeException("Failed to convert object to JSON", ex);
        }
    }

    public Event toEvent(String json) {
        try {
            return objectMapper.readValue(json, Event.class);
        } catch (Exception ex) {
            log.error("Error converting JSON to Event: {}", ex.getMessage(), ex);
            throw new RuntimeException("Failed to convert object to JSON", ex);
        }
    }
}