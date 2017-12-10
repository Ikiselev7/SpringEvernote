package com.epam.entity;

import javax.persistence.AttributeConverter;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimestampPersistenceConverter implements AttributeConverter<ZonedDateTime, Timestamp> {
    @Override
    public Timestamp convertToDatabaseColumn(ZonedDateTime attribute) {
        return Timestamp.from(Instant.from(attribute));
    }

    @Override
    public ZonedDateTime convertToEntityAttribute(Timestamp dbData) {
        LocalDateTime localDateTime = dbData.toLocalDateTime();
        return ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
    }
}
