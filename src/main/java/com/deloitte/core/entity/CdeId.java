package com.deloitte.core.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import java.io.Serializable;
import java.util.Date;

@RedisHash("cdeId")
@AllArgsConstructor
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
