package com.deloitte.core.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import java.io.Serializable;
import java.util.Date;

@RedisHash("cdeId")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class CdeId implements Serializable {

    /*
        CDE Transaction Types:
        1. PY: payment
        2. TK: tokenization
     */
    public enum Type {
        payment("PY"), tokenization("TK");

        private final String type;

        /**
         * @param text
         */
        Type(final String text) {
            this.type = text;
        }

        @Override
        public String toString() {
            return type;
        }
    }

    private Type type;

    private String dateTimeString;

    @Id
    private String uuid;

    public CdeId(Type type, String dateTimeString) {
        this.type = type;
        this.dateTimeString = dateTimeString;
    }

}
