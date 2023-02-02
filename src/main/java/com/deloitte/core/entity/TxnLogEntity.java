package com.deloitte.core.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TxnLogEntity implements Serializable {

    // String Serialized Data
    private String dataString;

    // Transaction Action
    private String txnAction;

    // Microservice Name
    private String service;
}
