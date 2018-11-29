package com.aliyun.gumiho.sql.translate.result;

/**
 * @author kongtong.ouyang on 2018/7/3.
 */
public enum SQLTransformChangeType implements SQLTransformIssueType {


    // DataType
    DataType("01001", "DataType Transform"),

    // Literal
    Literal("02001", "DataType Transform"),

    // Operators
    Operators("03001", "Operator Transform"),

    // Condition
    Condition("04001", "Condition Transform"),

    // Function
    Function("05001", "Function Transform"),


    // Database
    Database("06001", "Function Transform"),


    // Type
    Type("07001", "Function Transform"),

    // Type body
    Type_body("08001", "Function Transform"),

    // package
    Package("09001", "Function Transform"),

    // package body
    Package_Body("10001", "Function Transform"),

    // Table

    // sequence

    // synonym

    // View

    // Materialized View

    // procedure

    // trigger


    // Insert

    // Delete

    // Update

    // Select


    Remove_Group_By_Null("1062", "Remove Group By Null"),

    Remove_Table_Alias_In_Insert_Column("1", "移除Insert SQL字段中的表名or别名");


    protected String code;
    protected String desc;
    protected String chineseDesc;

    SQLTransformChangeType(String code, String desc) {
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
