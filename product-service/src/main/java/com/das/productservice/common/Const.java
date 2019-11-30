package com.das.productservice.common;

public class Const {
    public enum PRODUCT_STATUS {
        ACTIVE(1),
        INACTIVE(0);

        public final int value;

        PRODUCT_STATUS(int type) {
            value = type;
        }

        public static PRODUCT_STATUS getType(int type) {
            if (type == ACTIVE.value) {
                return ACTIVE;
            }
            return INACTIVE;
        }
    }
}
