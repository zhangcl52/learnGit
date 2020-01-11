package xin.smoon.springwater.wechatapi.framework.util;

import java.math.BigDecimal;

/**
 *
 */
public class BigDecimalUtils {

    /**
     * target是否大于compareSource
     *
     * @param target        原始待比较数值
     * @param compareSource 比较数值
     * @return 大于:小于或等于
     */
    public static Boolean greaterThan(BigDecimal target, BigDecimal compareSource) {
        return target.compareTo(compareSource) == 1 ? Boolean.TRUE : Boolean.FALSE;
    }

    /**
     * target是否小于compareSource
     *
     * @param target        原始待比较数值
     * @param compareSource 比较数值
     * @return 小于:大于或等于
     */
    public static Boolean lessThan(BigDecimal target, BigDecimal compareSource) {
        return target.compareTo(compareSource) == -1 ? Boolean.TRUE : Boolean.FALSE;
    }

    /**
     * target是否等于compareSource
     *
     * @param target        原始待比较数值
     * @param compareSource 比较数值
     * @return 等于
     */
    public static Boolean equalsNum(BigDecimal target, BigDecimal compareSource) {
        return target.compareTo(compareSource) == 0;
    }

}
