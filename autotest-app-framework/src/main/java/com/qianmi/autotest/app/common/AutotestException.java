package com.qianmi.autotest.app.common;

import lombok.*;

/**
 * 异常基类
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class AutotestException extends RuntimeException {
    /**
     * 异常码
     */
    private int code;

    /**
     * 异常信息
     */
    @NonNull
    private String message;

}
