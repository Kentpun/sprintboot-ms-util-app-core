package com.deloitte.core.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class TxnLogEntity implements Serializable {

    // String Serialized Data
    private String dataString;

    // Transaction Action
    private String txnAction;

    // Microservice Name
    private String service;
}
