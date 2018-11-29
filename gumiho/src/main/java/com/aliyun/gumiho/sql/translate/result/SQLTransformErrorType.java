package com.aliyun.gumiho.sql.translate.result;

/**
 * @author kongtong.ouyang on 2018/7/3.
 */
public enum SQLTransformErrorType implements SQLTransformIssueType {

    Syntax_Error("ADAM_UN_00001", "Syntax Error"),

    // DataType
    Data_Type_BFILE_UnSupport("010009", "不支持 BFILE 数据类型"),

    Data_Type_AnyData_UnSupport("ADAM_UN_010008", "不支持 SYS.AnyData 数据类型"),
    Data_Type_AnyType_UnSupport("ADAM_UN_010008", "不支持 SYS.AnyType 数据类型"),
    Data_Type_URIType_UnSupport("ADAM_UN_010008", "不支持 SYS.AnyDataSet 数据类型"),

    Data_Type_Percent_Type("010001", "Data Type %type UnSupport"),
    Data_Type_TIMESTAMP_UNCONSTRAINED_UnSupport("010002", "不支持 TIMESTAMP_UNCONSTRAINED 数据类型"),
    Data_Type_dbms_sql_varchar2_table_UnSupport("010003", "不支持 dbms_sql.varchar2_table 数据类型"),
    Data_Type_dbms_sql_varchar2a_UnSupport("010004", "不支持 dbms_sql.varchar2a 数据类型"),
    Data_Type_dbms_sql_varchar2s_UnSupport("010005", "不支持 dbms_sql.varchar2s 数据类型"),
    Data_Type_dbms_sql_number_UnSupport("010006", "不支持 dbms_sql.number_table 数据类型"),
    Data_Type_dbms_sql_desc_tab2_UnSupport("010007", "不支持 dbms_sql.desc_tab2 数据类型"),
    Data_Type_XMLPARSER_PARSER_UnSupport("010008", "不支持 XMLPARSER.PARSER 数据类型"),




    // Literal
    Literal__UnSupport("020001", ""),

    // Operators
    Operator__UnSupport("030001", ""),

    // Condition
    Condition__UnSupport("040001", ""),


    // Function
    Function_LAST_VALUE_UnSupport("050001", ""),
    Function_LEAD_UnSupport("", ""),
    Function_LEAST_UnSupport("", ""),
    Function_LENGTH_UnSupport("", ""),
    Function_LISTAGG_UnSupport("", ""),
    Function_LN_UnSupport("", ""),
    Function_LNNVL_UnSupport("", ""),

    // Column Constraint

    // Table Constraint
    Table_Constraint_Column_Size_Too_Many("070001", ""),



    // ------ statement --------------------------

    // comment     100001

    // database    110001

    // schema      120001

    // table       130001

    // sequence    140001

    // synonym     150001

    // view        160001

    // materialized view  170001

    // index   180001
    Create_Index_Cluster_Index_UnSupport("", ""),
    Create_Index_Bitmap_UnSupport("Create_Index_1", "Create Index Bitmap UnSupport"),

    // type  190001

    // type body  200001

    // package    210001

    // package body  220001

    // procedure   230001

    // function  240001

    // trigger 250001

    // role    260001

    // user  270001




    // delete    600001

    // insert   610001

    // select into  620001

    // select  630001
    Hierarchical_Query_UnSupport("", ""),
    Order_By_Siblings_UnSupport("",  ""),
    Order_By_Null_Ordering_UnSupport("",  ""),

    // update 640001


    ;


    protected String code;
    protected String desc;

    SQLTransformErrorType(String code, String desc) {
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
