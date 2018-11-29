package com.aliyun.gumiho.sql.translate.result;

/**
 * @author kongtong.ouyang on 2018/7/3.
 */
public enum SQLTransformWarnningType implements SQLTransformIssueType {
    ;

    public final String code;
    public final String desc;

    SQLTransformWarnningType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        return desc;
    }

}
