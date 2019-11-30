package com.das.cartservice.common;

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
    public enum ORDER_STATUS {
        CREATED(1),
        IN_PREPARED(2),
        SHIPPED(3),
        CANCELLED(0);

        public final int value;

        ORDER_STATUS(int type) {
            value = type;
        }

        public static ORDER_STATUS getType(int type) {
            if (type == CREATED.value) {
                return CREATED;
            }else if (type == IN_PREPARED.value) {
                return IN_PREPARED;
            }else if(type == SHIPPED.value){
                return SHIPPED;
            }
            return CANCELLED;
        }
    }
}
