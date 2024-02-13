package com.tambola.mysql.models;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;

public class TicketConverter implements AttributeConverter<Ticket, String> {

    private static final ObjectMapper MAPPER = new ObjectMapper().configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS, true);

    @Override
    public String convertToDatabaseColumn(Ticket attribute) {
        try {
            if(attribute == null) {
                return null;
            }
            return MAPPER.writeValueAsString(attribute);
        } catch (Exception exception) {
            return null;
        }
    }

    @Override
    public Ticket convertToEntityAttribute(String dbData) {
        try {
            if(dbData == null) {
                return null;
            }
            return MAPPER.readValue(dbData, Ticket.class);
        } catch (Exception exception) {
            return null;
        }
    }
}
