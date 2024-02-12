package com.pmp.springapi.enums;

public enum DepartmentCode {
    E001("CSE"),
    E002("ISE"),
    E003("ECE");

    private final String value;

    private DepartmentCode(String value) {
        this.value = value;
    }

    public String getDepartmentCode() {
        return this.value;
    }
}
