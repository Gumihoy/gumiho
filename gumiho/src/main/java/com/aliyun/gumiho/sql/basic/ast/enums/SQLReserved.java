/*
 * Copyright (C) 2017-2018 kent(kent.bohai@gmail.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.aliyun.gumiho.sql.basic.ast.enums;

import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLReservedIdentifier;
import com.aliyun.gumiho.sql.hash.FNVHash;

/**
 * @author kongtong.ouyang onCondition 2018/3/20.
 */
public enum SQLReserved {

    // -------- DDL ------------------------
    COMMENT_ON("comment on", "COMMENT ON"),

    CREATE("create", "CREATE"),
    ALTER("alter", "ALTER"),
    DROP("drop", "DROP"),

    DATABASE("database", "DATABASE"),
    PLUGGABLE_DATABASE("pluggable database", "PLUGGABLE DATABASE"),
    SCHEMA("schema", "SCHEMA"),
    DATABASE_LINK("database link", "DATABASE LINK"),
    FUNCTION("function", "FUNCTION"),
    INDEX("index", "INDEX"),
    ROLE("role", "ROLE"),
    ROLLBACK_SEGMENT("rollback segment", "ROLLBACK SEGMENT"),
    SEQUENCE("sequence", "SEQUENCE"),
    SERVER("server", "SERVER"),

    MATERIALIZED_VIEW("materialized view", "MATERIALIZED VIEW"),
    MATERIALIZED_VIEW_LOG("materialized view log", "MATERIALIZED VIEW LOG"),

    OPERATOR("operator", "OPERATOR"),

    PACKAGE("package", "PACKAGE"),
    PACKAGE_BODY("package body", "PACKAGE BODY"),

    PROCEDURE("procedure", "PROCEDURE"),
    SYNONYM("synonym", "SYNONYM"),
    TABLE("table", "TABLE"),
    TABLESPACE("tablespace", "TABLESPACE"),
    TRIGGER("trigger", "TRIGGER"),

    TYPE("type", "TYPE"),
    TYPE_BODY("type body", "TYPE BODY"),

    USER("user", "USER"),
    VIEW("view", "VIEW"),


    // -------- dml ------------------------
    SELECT("select", "SELECT"),
    INSERT("insert", "INSERT"),
    UPDATE("update", "UPDATE"),
    DELETE("delete", "DELETE"),

    // -------- tcl ------------------------
    COMMIT("commit", "COMMIT"),
    ROLLBACK("rollback", "ROLLBACK"),
    SAVEPOINT("savepoint", "SAVEPOINT"),
    SET_TRANSACTION("set transaction", "SET TRANSACTION"),
    SET_CONSTRAINT("set constraint", "SET CONSTRAINT"),
    SET_CONSTRAINTS("set constraints", "SET CONSTRAINTS"),

    // -------- scl ------------------------
    ALTER_SESSION("alter session", "ALTER SESSION"),
    SET_ROLE("set role", "SET ROLE"),


    // -------- or replace ------------------------
    OR_REPLACE("or replace", "OR REPLACE"),
    OR_ALTER("or alter", "OR ALTER"),


    IF("if", "IF"),
    END_IF("end if", "END IF"),
    ELSEIF("elseif", "ELSEIF"),
    ELSIF("elsif", "ELSIF"),


    IF_EXISTS("if exists", "IF EXISTS"),

    // -------- if not exists ------------------------
    IF_NOT_EXISTS("if not exists", "IF NOT EXISTS"),


    // -------- invoker_rights_clause ------------------------
    AUTHID_CURRENT_USER("authid current_user", "AUTHID CURRENT_USER"),
    AUTHID_DEFINER("authid definer", "AUTHID DEFINER"),

    // -------- Null Call ------------------------
    RETURNS_NULL_ON_NULL_INPUT("returns null onCondition null input", "RETURNS NULL ON NULL INPUT"),
    CALLED_ON_NULL_INPUT("called onCondition null input", "CALLED ON NULL INPUT"),

    // -------- Data Access Indication ------------------------
    NO_SQL("no sql", "NO SQL"),
    CONTAINS_SQL("contains sql", "CONTAINS SQL"),
    READS_SQL_DATA("reads sql data", "READS SQL DATA"),
    MODIFIES_SQL_DATA("modifies sql data", "MODIFIES SQL DATA"),

    // -------- OVERRIDING ------------------------
    OVERRIDING("overriding", "OVERRIDING"),
    NOT_OVERRIDING("not overriding", "NOT OVERRIDING"),

    // -------- final ------------------------
    FINAL("final", "FINAL"),
    NOT_FINAL("not final", "NOT FINAL"),

    // -------- instantiable ------------------------
    INSTANTIABLE("instantiable", "INSTANTIABLE"),
    NOT_INSTANTIABLE("not instantiable", "NOT INSTANTIABLE"),

    // -------- persistable ------------------------
    PERSISTABLE("persistable", "PERSISTABLE"),
    NOT_PERSISTABLE("not persistable", "NOT PERSISTABLE"),

    // -------- EDITIONABLE ------------------------
    EDITIONING("editioning", "EDITIONING"),
    EDITIONABLE("editionable", "EDITIONABLE"),
    EDITIONABLE_EDITIONING("editionable editioning", "EDITIONABLE EDITIONING"),
    NONEDITIONABLE("noneditionable", "NONEDITIONABLE"),

    // -------- IS/AS ------------------------
    IS("is", "IS"),
    AS("as", "AS"),

    OBJECT("object", "OBJECT"),

    ACCESSIBLE_BY("accessible by", "ACCESSIBLE BY"),

    AGGREGATE("aggregate", "AGGREGATE"),
    PIPELINED("pipelined", "PIPELINED"),
    USING("using", "USING"),
    AGGREGATE_USING("aggregate using", "AGGREGATE USING"),
    PIPELINED_USING("pipelined using", "PIPELINED USING"),

    PIPE_ROW("pipe row", "PIPE ROW"),

    SHARING("sharing", "SHARING"),


    METADATA("metadata", "METADATA"),
    DATA("data", "DATA"),
    EXTENDED_DATA("extended data", "EXTENDED DATA"),
    NONE("none", "NONE"),

    CHARACTER_SET("character set", "CHARACTER SET"),
    CHARSET("charset", "CHARSET"),
    COLLATE("collate", "COLLATE"),

    DEFAULT("default", "DEFAULT"),

    OF("of", "OF"),

    XMLTYPE("xmltype", "XMLTYPE"),
    ENUM("ENUM", "ENUM"),

    VIRTUAL_COLUMNS("virtual columns", "VIRTUAL COLUMNS"),


    AUDIT_POLICY("audit policy", "AUDIT POLICY"),
    COLUMN("column", "COLUMN"),
    EDITION("edition", "EDITION"),
    INDEXTYPE("indextype", "INDEXTYPE"),
    MINING_MODEL("mining model", "MINING MODEL"),

    ALLOCATE_EXTENT("allocate extent", "ALLOCATE EXTENT"),
    SIZE("size", "SIZE"),
    DATAFILE("datafile", "DATAFILE"),
    INSTANCE("instance", "INSTANCE"),


    DEALLOCATE_UNUSED("deallocate unused", "DEALLOCATE UNUSED"),

    KEEP("keep", "KEEP"),
    NOKEEP("nokeep", "NOKEEP"),

    CURRENT_USER("current_user", "CURRENT_USER"),
    CURRENT_ROLE("current_role", "CURRENT_ROLE"),
    SESSION_USER("session_user", "SESSION_USER"),
    SYSTEM_USER("system_user", "SYSTEM_USER"),
    CURRENT_PATH("current_path", "CURRENT_PATH"),

    OR("or", "OR"),
    OTHERS("others", "OTHERS"),

    DEFERRABLE("deferrable", "DEFERRABLE"),
    NOT_DEFERRABLE("not deferrable", "NOT DEFERRABLE"),

    INITIALLY_IMMEDIATE("initially immediate", "INITIALLY IMMEDIATE"),
    INITIALLY_DEFERRED("initially deferred", "INITIALLY DEFERRED"),

    RELY("rely", "RELY"),
    NORELY("NORELY", "NORELY"),

    ENABLE("enable", "ENABLE"),
    DISABLE("disable", "DISABLE"),

    VALIDATE("validate", "VALIDATE"),
    NOVALIDATE("novalidate", "NOVALIDATE"),


    DEFERRED_INVALIDATION("deferred invalidation", "DEFERRED INVALIDATION"),
    IMMEDIATE_INVALIDATION("immediate invalidation", "IMMEDIATE INVALIDATION"),

    USABLE("usable", "USABLE"),
    UNUSABLE("unusable", "UNUSABLE"),

    ENGINE("engine", "ENGINE"),
    COMMENT("comment", "COMMENT"),

    START("start", "START"),
    WITH("with", "WITH"),
    WITHOUT("without", "WITHOUT"),
    START_WITH("start with", "START WITH"),

    RESTART("restart", "RESTART"),
    RESTART_WITH("restart with", "RESTART WITH"),


    INCREMENT("increment", "INCREMENT"),
    DECREMENT("decrement", "DECREMENT"),

    BY("by", "BY"),
    INCREMENT_BY("increment by", "INCREMENT BY"),

    MAXVALUE("maxvalue", "MAXVALUE"),
    NOMAXVALUE("no maxvalue", "NOMAXVALUE"),
    NO_MAXVALUE("no maxvalue", "NO MAXVALUE"),

    MINVALUE("minvalue ", "MINVALUE"),
    NOMINVALUE("nominvalue", "NOMINVALUE"),
    NO_MINVALUE("no minvalue", "NO MINVALUE"),

    CYCLE("cycle", "CYCLE"),
    NOCYCLE("nocycle", "NOCYCLE"),
    NO_CYCLE("no cycle", "NO CYCLE"),

    CACHE("cache", "CACHE"),
    CACHE_READS("cache reads", "CACHE READS"),
    NOCACHE("nocache", "NOCACHE"),

    ORDER("order", "ORDER"),
    NOORDER("noorder", "NOORDER"),

    SESSION("session", "SESSION"),
    GLOBAL("global", "GLOBAL"),

    OWNED_BY("owned by", "OWNED BY"),


    OWNED_TO("owned to", "OWNED TO"),
    RENAME_TO("rename to", "RENAME TO"),
    SET_SCHEMA("set schema", "SET SCHEMA"),

    COMPILE("compile", "COMPILE"),


    PUBLIC("public", "PUBLIC"),
    FORCE("force", "FORCE"),
    NOFORCE("noforce", "NOFORCE"),


    FOR("for", "FOR"),

    RETURN("RETURN", "RETURN"),
    COLON_NEW(":new", ":NEW"),
    COLON_OLD(":old", ":OLD"),
    NEW("NEW", "NEW"),
    OLD("OLD", "OLD"),
    PARENT("PARENT", "PARENT"),


    MERGE_INTO("merge into", "MERGE INTO"),
    WHEN_MATCHED_THEN("when matched then", "WHEN MATCHED THEN"),
    WHEN_NOT_MATCHED_THEN("when not matched then", "WHEN NOT MATCHED THEN"),

    CASCADE("cascade", "CASCADE"),
    RESTRICT("restrict", "RESTRICT"),
    CASCADE_CONSTRAINTS("cascade constraints", "CASCADE CONSTRAINTS"),

    PRESERVE("preserve", "PRESERVE"),
    PURGE("purge", "PURGE"),

    TEMP("temp", "TEMP"),
    TEMPORARY("temporary", "TEMPORARY"),
    GLOBAL_TEMP("global temp", "GLOBAL TEMP"),
    LOCAL_TEMP("local temp", "LOCAL TEMP"),
    GLOBAL_TEMPORARY("global temporary", "GLOBAL TEMPORARY"),
    LOCAL_TEMPORARY("local temporary", "LOCAL TEMPORARY"),
    PRIVATE_TEMPORARY("private temporary", "PRIVATE TEMPORARY"),
    SHARDED("sharded", "SHARDED"),
    DUPLICATED("duplicated", "DUPLICATED"),
    UNLOGGED("unlogged", "UNLOGGED"),

    F("f", "F"),
    D("d", "D"),


    NULLS_FIRST("nulls first", "NULLS FIRST"),
    NULLS_LAST("nulls last", "NULLS LAST"),

    SIBLINGS("siblings", "SIBLINGS"),

    ASC("asc", "ASC"),
    DESC("desc", "DESC"),

    // override clause
    OVERRIDING_USER_VALUE("overriding user value", "OVERRIDING USER VALUE"),
    OVERRIDING_SYSTEM_VALUE("overriding system value", "OVERRIDING SYSTEM VALUE"),

    DEFAULT_VALUES("default values", "DEFAULT VALUES"),

    // collation_option
    USING_NLS_COMP("using_nls_comp", "USING_NLS_COMP"),

    DECLARE("declare", "DECLARE"),
    BEGIN("begin", "BEGIN"),
    END("end", "END"),

    EXCEPTION("exception", "EXCEPTION"),
    WHEN("when", "WHEN"),
    THEN("then", "THEN"),
    ELSE("else", "ELSE"),

    EXCEPTIONS_INTO("exceptions into", "EXCEPTIONS INTO"),

    SUBTYPE("subtype", "SUBTYPE"),

    NOT_NULL("not null", "NOT NULL"),


    PERCENT("%", "%"),
    AMPERSAND("&", "&"),
    EXCLAMATION_SYMBOL("!", "!"),
    QUESTION_MARK("?", "?"),

    DOUBLE_ASTERISK("**", "**"),
    ASTERISK("*", "*"),
    SOLIDUS("/", "/"),
    PLUS_SIGN("+", "+"),
    MINUS_SIGN("-", "-"),

    LOGIC_AND_OP("&&", "&&"),
    LOGIC_OR_OP("||", "||"),

    BIT_NOT_OP("~", "~"),
    BIT_OR_OP("|", "|"),
    BIT_AND_OP("&", "&"),
    BIT_XOR_OP("^", "^"),

    QUOTE("'", "'"),
    REVERSE_QUOTE("`", "`"),
    DOUBLE_QUOTE("\"", "\""),

    EQUALS_OP("=", "="),
    EQUALS_GREATER_THAN_OP("=>", "=>"),
    LESS_THAN_OP("<", "<"),
    LESS_THAN_OR_EQUALS_OP("<=", "<="),
    GREATER_THAN_OP(">", ">"),
    GREATER_THAN_OR_EQUALS_OP(">=", ">="),
    LESS_THAN_OR_EQUAL_OR_GREATER_THAN_OP("<=>", "<=>"),

    LESS_THAN_LESS_THAN_OP("<<", "<<"),
    GREATER_THAN_GREATER_THAN_OP(">>", ">>"),

    OUTER_JOIN_OP("(+)", "(+)"),

    PERIOD(".", "."),
    DOUBLE_PERIOD("..", ".."),
    COMMA(",", ","),

    COLON(":", ":"),
    DOUBLE_COLON("::", "::"),


    VAR_ASSIGN_OP(":=", ":="),
    PLUS_ASSIGN_OP("+=", "+="),
    MINUS_ASSIGN("-=", "-="),
    MULTI_ASSIGN("*=", "-="),
    DIV_ASSIGN("/=", "/="),
    MOD_ASSIGN("%=", "%="),
    AND_ASSIGN("&=", "&="),
    XOR_ASSIGN("^=", "^="),
    OR_ASSIGN("|=", "|="),

    NOT_EQUAL_OP("!=", "!="),
    LESS_THAN_OR_GREATER("<>", "<>"),
    NOT_EQUAL_OP2("~=", "~="),

    DOLLAR("$", "$"),
    AT_SIGN("@", "@"),
    AT_SIGN_AT_SIGN("@@", "@@"),
    SHARP("#", "#"),

    LEFT_PAREN("(", "("),
    RIGHT_PAREN(")", ")"),

    LEFT_BRACKET("[", "["),
    RIGHT_BRACKET("]", "]"),

    LEFT_BRACE("{", "{"),
    RIGHT_BRACE("}", "}"),
    SPACE(" ", " "),


    RECORD("record", "RECORD"),

    REF_CURSOR("ref cursor", "REF CURSOR"),


    TABLE_OF("table of", "TABLE OF"),

    INDEX_BY("index by", "INDEX BY"),

    VARRAY("varray", "VARRAY"),

    VARYING_ARRAY("varying array", "VARYING ARRAY"),

    MULTISET("multiset", "MULTISET"),

    UNKNOWN("unknown", "UNKNOWN"),

    NULL("null", "NULL"),

    TRUE("true", "TRUE"),

    FALSE("false", "FALSE"),

    BEFORE("before", "BEFORE"),

    AFTER("after", "AFTER"),

    INSTEAD_OF("instead of", "INSTEAD OF"),

    FOLLOWS("follows", "FOLLOWS"),

    PRECEDES("precedes", "PRECEDES"),
    EACH("each", "EACH"),
    STATEMENT("statement", "STATEMENT"),

    MEMBER("member", "MEMBER"),

    STATIC("static", "STATIC"),

    CONSTRUCTOR_FUNCTION("constructor function", "CONSTRUCTOR FUNCTION"),

    SELF_IN_OUT("self in out", "SELF IN OUT"),

    SELF_AS_RESULT("self as result", "SELF AS RESULT"),
    RETURN_SELF_AS_RESULT("return self as result", "RETURN SELF AS RESULT"),

    MAP("map", "MAP"),

    PRAGMA("pragma", "PRAGMA"),

    RESTRICT_UNDERLINE_REFERENCES("restrict_references", "RESTRICT_REFERENCES"),

    LANGUAGE_C("language c", "LANGUAGE C"),

    EXTERNAL("external", "EXTERNAL"),

    WITH_CONTEXT("with context", "WITH CONTEXT"),

    PARAMETERS("parameters", "PARAMETERS"),

    REFERENCE("reference", "REFERENCE"),
    BY_REFERENCE("by reference", "BY REFERENCE"),


    LANGUAGE_JAVA_NAME("language java name", "LANGUAGE JAVA NAME"),
    LANGUAGE_JAVA_USING("language java using", "LANGUAGE JAVA USING"),


    TDO("tdo", "TDO"),

    INDICATOR("indicator", "INDICATOR"),

    INDICATOR_STRUCT("indicator struct", "INDICATOR STRUCT"),

    INDICATOR_TDO("indicator tdo", "INDICATOR TDO"),

    LENGTH("length", "LENGTH"),
    LENGTHB("lengthb", "LENGTHB"),
    LENGTHC("lengthc", "LENGTHC"),
    LENGTH2("length2", "LENGTH2"),
    LENGTH4("length4", "LENGTH4"),

    DURATION("duration", "DURATION"),

    MAXLEN("maxlen", "MAXLEN"),

    CHARSETID("charsetid", "CHARSETID"),

    CHARSETFORM("charsetform", "CHARSETFORM"),

    ROWS("rows", "ROWS"),

    RANGE("range", "RANGE"),

    // window frame exclusion
    EXCLUDE_CURRENT_ROW("exclude current row", "EXCLUDE CURRENT ROW"),

    EXCLUDE_GROUP("exclude group", "EXCLUDE GROUP"),

    EXCLUDE_TIES("exclude ties", "EXCLUDE TIES"),

    EXCLUDE_NO_OTHERS("exclude no others", "EXCLUDE NO OTHERS"),


    BETWEEN("between", "BETWEEN"),

    AND("and", "AND"),

    UNBOUNDED_PRECEDING("UNBOUNDED PRECEDING", "UNBOUNDED PRECEDING"),

    CURRENT_ROW("current row", "CURRENT ROW"),

    PRECEDING("preceding", "PRECEDING"),

    FOLLOWING("following", "FOLLOWING"),

    DISTINCT("distinct", "DISTINCT"),

    ALL("all", "ALL"),

    UNIQUE("unique", "UNIQUE"),
    BITMAP("bitmap", "BITMAP"),
    FULLTEXT("fulltext", "FULLTEXT"),
    SPATIAL("spatial", "SPATIAL"),

    DISTINCTROW("distinctrow", "DISTINCTROW"),


    // -------------------------- DataType name Start --------------------------

    // String DataType
    STRING("string", "STRING"),
    TINYTEXT("tinytext", "TINYTEXT"),
    TEXT("text", "TEXT"),
    MEDIUMTEXT("MEDIUMTEXT", "MEDIUMTEXT"),
    LONGTEXT("longtext", "LONGTEXT"),

    CHARACTER("character", "CHARACTER"),
    CHAR("char", "CHAR"),

    CHARACTER_VARYING("character varying", "CHARACTER VARYING"),
    CHAR_VARYING("CHAR VARYING", "CHAR VARYING"),

    VARCHAR("varchar", "VARCHAR"),
    VARCHAR2("varchar2", "VARCHAR2"),
    NVARCHAR("nvarchar", "NVARCHAR"),
    NVARCHAR2("nvarchar2", "NVARCHAR2"),

    CHARACTER_LARGE_OBJECT("CHARACTER LARGE OBJECT", "CHARACTER LARGE OBJECT"),
    CHAR_LARGE_OBJECT("CHAR LARGE OBJECT", "CHAR LARGE OBJECT"),


    LONG("LONG", "LONG"),
    LONG_RAW("LONG RAW", "LONG RAW"),
    RAW("RAW", "RAW"),

    NATIONAL_CHARACTER("NATIONAL CHARACTER", "NATIONAL CHARACTER"),
    NATIONAL_CHAR("NATIONAL CHAR", "NATIONAL CHAR"),
    NCHAR("NCHAR", "NCHAR"),
    NATIONAL_CHARACTER_VARYING("NATIONAL CHARACTER VARYING", "NATIONAL CHARACTER VARYING"),
    NATIONAL_CHAR_VARYING("NATIONAL CHAR VARYING", "NATIONAL CHAR VARYING"),
    NCHAR_VARYING("NCHAR VARYING", "NCHAR VARYING"),
    NATIONAL_CHARACTER_LARGE_OBJECT("NATIONAL CHARACTER LARGE OBJECT", "NATIONAL CHARACTER LARGE OBJECT"),
    NCHAR_LARGE_OBJECT("NCHAR LARGE OBJECT", "NCHAR LARGE OBJECT"),

    BINARY_LARGE_OBJECT("binary large object", "BINARY LARGE OBJECT"),

    TINYBLOB("tinyblob", "TINYBLOB"),
    BLOB("blob", "BLOB"),
    MEDIUMBLOB("mediumblob", "MEDIUMBLOB"),
    LONGBLOB("longblob", "LONGBLOB"),

    CLOB("clob", "CLOB"),
    NCLOB("nclob", "NCLOB"),
    BFILE("bfile", "BFILE"),
    BCLOB("bclob", "BCLOB"),


    ROWID("rowid", "ROWID"),
    UROWID("urowid", "UROWID"),


    // Numeric DataType

    NUMERIC("numeric", "NUMERIC"),

    BIT("bit", "BIT"),
    TINYINT("tinyint", "TINYINT"),
    SMALLINT("smallint", "SMALLINT"),
    MEDIUMINT("mediumint", "MEDIUMINT"),
    INT1("int1", "INT1"),
    INT2("in2", "INT2"),
    INT3("in3", "INT3"),
    INT4("int4", "INT4"),
    INT8("int8", "INT8"),
    INT("int", "INT"),
    INTEGER("integer", "INTEGER"),
    BIGINT("bigint", "BIGINT"),

    FIXED("fixed", "FIXED"),

    DECIMAL("decimal", "DECIMAL"),
    DEC("dec", "DEC"),
    FLOAT("float", "FLOAT"),
    DOUBLE("double", "DOUBLE"),
    DOUBLE_PRECISION("double precision", "DOUBLE PRECISION"),
    BINARY_FLOAT("binary_float", "BINARY_FLOAT"),
    BINARY_DOUBLE("binary_double", "BINARY_DOUBLE"),
    SIMPLE_FLOAT("simple_float", "SIMPLE_FLOAT"),
    SIMPLE_DOUBLE("simple_double", "SIMPLE_DOUBLE"),

    BINARY_FLOAT_NAN("binary_float_nan", "BINARY_FLOAT_NAN"),
    BINARY_FLOAT_INFINITY("binary_float_infinity", "BINARY_FLOAT_INFINITY"),
    BINARY_FLOAT_MAX_NORMAL("binary_float_max_normal", "BINARY_FLOAT_MAX_NORMAL"),
    BINARY_FLOAT_MIN_NORMAL("binary_float_min_normal", "BINARY_FLOAT_MIN_NORMAL"),
    BINARY_FLOAT_MAX_SUBNORMAL("binary_float_max_subnormal", "BINARY_FLOAT_MAX_SUBNORMAL"),
    BINARY_FLOAT_MIN_SUBNORMAL("binary_float_min_subnormal", "BINARY_FLOAT_MIN_SUBNORMAL"),
    BINARY_DOUBLE_NAN("binary_double_nan", "BINARY_DOUBLE_NAN"),
    BINARY_DOUBLE_INFINITY("binary_double_infinity", "BINARY_DOUBLE_INFINITY"),
    BINARY_DOUBLE_MAX_NORMAL("binary_double_max_normal", "BINARY_DOUBLE_MAX_NORMAL"),
    BINARY_DOUBLE_MIN_NORMAL("binary_double_min_normal", "BINARY_DOUBLE_MIN_NORMAL"),
    BINARY_DOUBLE_MAX_SUBNORMAL("binary_double_max_subnormal", "BINARY_DOUBLE_MAX_SUBNORMAL"),
    BINARY_DOUBLE_MIN_SUBNORMAL("binary_double_min_subnormal", "BINARY_DOUBLE_MIN_SUBNORMAL"),


    REAL("real", "REAL"),

    SMALLSERIAL("smallserial", "SMALLSERIAL"),
    SERIAL("serial", "SERIAL"),
    BIGSERIAL("bigserial", "BIGSERIAL"),

    NUMBER("number", "NUMBER"),

    BYTEA("bytea", "BYTEA"),

    BOOL("bool", "BOOL"),
    BOOLEAN("boolean", "BOOLEAN"),


    // DATE DataType
    DATE("date", "DATE"),
    TIME("time", "TIME"),
    DATETIME("datetime", "DATETIME"),
    TIMESTAMP("timestamp", "TIMESTAMP"),

    INTERVAL("interval", "INTERVAL"),
    INTERVAL_YEAR("interval year", "INTERVAL YEAR"),
    INTERVAL_MONTH("interval month", "INTERVAL MONTH"),
    INTERVAL_DAY("interval day", "INTERVAL DAY"),
    INTERVAL_HOUR("interval hour", "INTERVAL HOUR"),
    INTERVAL_MINUTE("interval minute", "INTERVAL MINUTE"),
    INTERVAL_SECOND("interval second", "INTERVAL SECOND"),


    REF("ref", "REF"),

    MONEY("money", "MONEY"),

    ROW("row", "ROW"),


    // AnyType
    AnyData("AnyData", "AnyData"),
    AnyType("AnyType", "AnyType"),
    AnyDataSet("AnyDataSet", "AnyDataSet"),

    // xml
    XML("xml", "XML"),
    XMLType("xmltype", "XMLType"),
    URIType("uritype", "URIType"),


    // spatial_types
    GEOMETRY("geometry", "GEOMETRY"),
    POINT("point", "POINT"),
    LINESTRING("linestring", "LINESTRING"),
    POLYGON("polygon", "POLYGON"),
    MULTIPOINT("multipoint", "MULTIPOINT"),
    MULTILINESTRING("multilinestring", "MULTILINESTRING"),
    MULTIPOLYGON("multipolygon", "MULTIPOLYGON"),
    GEOMETRYCOLLECTION("geometrycollection", "GEOMETRYCOLLECTION"),

    SDO_Geometry("sdo_geometry", "SDO_Geometry"),
    SDO_Topo_Geometry("sdo_topo_geometry", "SDO_Topo_Geometry"),
    SDO_GeoRaster("sdo_georaster", "SDO_GeoRaster"),


    // media_types
    ORDAudio("ORDAudio", "ORDAudio"),
    ORDImage("ORDImage", "ORDImage"),
    ORDVideo("ORDVideo", "ORDVideo"),
    ORDDoc("ORDDoc", "ORDDoc"),
    ORDDicom("ORDDicom", "ORDDicom"),


    // still_image_object_types
    SI_StillImage("SI_StillImage", "SI_StillImage"),
    SI_AverageColor("SI_AverageColor", "SI_AverageColor"),
    SI_PositionalColor("SI_PositionalColor", "SI_PositionalColor"),
    SI_ColorHistogram("SI_ColorHistogram", "SI_ColorHistogram"),
    SI_Texture("SI_Texture", "SI_Texture"),
    SI_FeatureList("SI_FeatureList", "SI_FeatureList"),
    SI_Color("SI_Color", "SI_Color"),


    // PLS
    PLS_INTEGER("PLS_INTEGER", "PLS_INTEGER"),
    NATURAL("NATURAL", "NATURAL"),
    NATURALN("NATURALN", "NATURALN"),
    POSITIVE("POSITIVE", "POSITIVE"),
    POSITIVEN("POSITIVEN", "POSITIVEN"),
    SIGNTYPE("SIGNTYPE", "SIGNTYPE"),
    SIMPLE_INTEGER("SIMPLE_INTEGER", "SIMPLE_INTEGER"),

    BINARY_INTEGER("BINARY_INTEGER", "BINARY_INTEGER"),

    PERCENT_TYPE("%type", "%TYPE"),
    PERCENT_ROWTYPE("%rowtype", "%ROWTYPE"),

    // -------------------------- DataType name End --------------------------


    // -------------------------- functions name
    // ------ Numeric Functions
    ABS("abs", "ABS"),

    ACOS("acos", "ACOS"),

    ASIN("asin", "ASIN"),

    ATAN("atan", "ATAN"),

    ATAN2("atan2", "ATAN2"),

    BITAND("bitand", "BITAND"),

    CEIL("ceil", "CEIL"),

    COS("cos", "COS"),

    COSH("cosh", "COSH"),

    EXP("exp", "EXP"),

    FLOOR("floor", "FLOOR"),

    LN("ln", "LN"),

    LOG("log", "LOG"),

    MOD("mod", "MOD"),

    POWER("power", "POWER"),

    REMAINDER("remainder", "REMAINDER"),

    ROUND("round", "ROUND"),

    SIGN("sign", "SIGN"),

    SIN("sin", "SIN"),

    SINH("sinh", "SINH"),

    SQRT("sqrt", "SQRT"),

    TAN("tan", "TAN"),

    TANH("tanh", "TANH"),

    TRUNC("trunc", "TRUNC"),

    WIDTH_BUCKET("width_bucket", "WIDTH_BUCKET"),

    // ------ Oracle String Functions
    CHR("chr", "CHR"),
    CONCAT("concat", "CONCAT"),
    INITCAP("initcap", "INITCAP"),
    LOWER("lower", "LOWER"),
    LPAD("lpad", "LPAD"),
    LTRIM("ltrim", "LTRIM"),
    NCHR("nchr", "NCHR"),
    NLS_INITCAP("nls_initcap", "NLS_INITCAP"),
    NLS_LOWER("nls_lower", "NLS_LOWER"),
    NLS_UPPER("nls_upper", "NLS_UPPER"),
    NLSSORT("nlssort", "NLSSORT"),
    REGEXP_REPLACE("REGEXP_REPLACE", "REGEXP_REPLACE"),
    REGEXP_SUBSTR("REGEXP_SUBSTR", "REGEXP_SUBSTR"),
    REPLACE("replace", "REPLACE"),
    RPAD("rpad", "RPAD"),
    RTRIM("rtrim", "RTRIM"),
    SOUNDEX("soundex", "SOUNDEX"),
    SUBSTR("substr", "SUBSTR"),
    SUBSTRING("substring", "SUBSTRING"),
    TRANSLATE("translate", "TRANSLATE"),
    TRIM("trim", "TRIM"),
    UPPER("upper", "UPPER"),
    ASCII("ascii", "ASCII"),
    INSTR("instr", "INSTR"),
    REGEXP_COUNT("regexp_count", "REGEXP_COUNT"),
    REGEXP_INSTR("regexp_instr", "REGEXP_INSTR"),
    NLS_CHARSET_DECL_LEN("nls_charset_decl_len", "NLS_CHARSET_DECL_LEN"),
    NLS_CHARSET_ID("nls_charset_id", "NLS_CHARSET_ID"),
    NLS_CHARSET_NAME("nls_charset_name", "NLS_CHARSET_NAME"),


    // ------ MySQL Functions
    UUID("uuid", "UUID"),

    // ------ MySQL String Functions
    BIN("BIN", "BIN"), //	Return a string containing binary representation of a number
    BIT_LENGTH("BIT_LENGTH", "BIT_LENGTH"), //	Return length of argument in bits
    CHAR_LENGTH("CHAR_LENGTH", "CHAR_LENGTH"), //	Return number of characters in argument
    CHARACTER_LENGTH("CHARACTER_LENGTH", "CHARACTER_LENGTH"), //	Synonym for CHAR_LENGTH("", ""), //
    CONCAT_WS("CONCAT_WS", "CONCAT_WS"), //	Return concatenate with separator
    ELT("ELT", "ELT"), //	Return string at index number
    EXPORT_SET("EXPORT_SET", "EXPORT_SET"), //	Return a string such that for every bit set in the value bits, you get an on string and for every unset bit, you get an off string
    FIELD("FIELD", "FIELD"), //	Return the index (position) of the first argument in the subsequent arguments
    FIND_IN_SET("FIND_IN_SET", "FIND_IN_SET"), //	Return the index position of the first argument within the second argument
    FORMAT("FORMAT", "FORMAT"), //	Return a number formatted to specified number of decimal places
    FROM_BASE64("FROM_BASE64", "FROM_BASE64"), //	Decode base64 encoded string and return result
    HEX("HEX", "HEX"), //	Return a hexadecimal representation of a decimal or string value
    LCASE("LCASE", "LCASE"), //	Synonym for LOWER("", ""), //
    LEFT("LEFT", "LEFT"), //	Return the leftmost number of characters as specified
    LOAD_FILE("LOAD_FILE", "LOAD_FILE"), //	Load the named file
    LOCATE("LOCATE", "LOCATE"), //	Return the position of the first occurrence of substring
    MAKE_SET("MAKE_SET", "MAKE_SET"), //	Return a set of comma-separated strings that have the corresponding bit in bits set
    MID("MID", "MID"), //	Return a substring starting from the specified position
    OCT("OCT", "OCT"), //	Return a string containing octal representation of a number
    OCTET_LENGTH("OCTET_LENGTH", "OCTET_LENGTH"), //	Synonym for LENGTH("", ""), //
    ORD("ORD", "ORD"), //	Return character code for leftmost character of the argument
    QUOTE_LITERAL("quote", "QUOTE"), //	Escape the argument for use in an SQL statement
    REPEAT("REPEAT", "REPEAT"),
    RIGHT("RIGHT", "RIGHT"),
    SPACE_LITERAL("space", "SPACE"),
    STRCMP("STRCMP", "STRCMP"),
    SUBSTRING_INDEX("SUBSTRING_INDEX", "SUBSTRING_INDEX"),
    TO_BASE64("TO_BASE64", "TO_BASE64"),
    UCASE("UCASE", "UCASE"),
    UNHEX("UNHEX", "UNHEX"),

    // ------ Collation Functions
    COLLATION("collation", "COLLATION"),

    DIRECTORY("DIRECTORY", "DIRECTORY"),

    NLS_COLLATION_ID("nls_collation_id", "NLS_COLLATION_ID"),

    NLS_COLLATION_NAME("nls_collation_name", "NLS_COLLATION_NAME"),


    // ------ ORACLE Datetime Functions
    ADD_MONTHS("add_months", "ADD_MONTHS"),
    CURRENT_DATE("current_date", "CURRENT_DATE"),
    CURRENT_TIMESTAMP("current_timestamp", "CURRENT_TIMESTAMP"),
    DBTIMEZONE("dbtimezone", "DBTIMEZONE"),
    EXTRACT("extract", "EXTRACT"),
    FROM_TZ("from_tz", "FROM_TZ"),
    LAST_DAY("last_day", "LAST_DAY"),
    LOCALTIMESTAMP("localtimestamp", "LOCALTIMESTAMP"),
    MONTHS_BETWEEN("months_between", "MONTHS_BETWEEN"),
    NEW_TIME("new_time", "NEW_TIME"),
    NEXT_DAY("next_day", "NEXT_DAY"),
    ORA_DST_AFFECTED("ora_dst_affected", "ORA_DST_AFFECTED"),
    ORA_DST_CONVERT("ora_dst_convert", "ORA_DST_CONVERT"),
    ORA_DST_ERROR("ora_dst_error", "ORA_DST_ERROR"),
    SESSIONTIMEZONE("sessiontimezone", "SESSIONTIMEZONE"),
    SYS_EXTRACT_UTC("sys_extract_utc", "SYS_EXTRACT_UTC"),
    SYSDATE("sysdate", "SYSDATE"),
    SYSTIMESTAMP("systimestamp", "SYSTIMESTAMP"),
    TZ_OFFSET("tz_offset", "TZ_OFFSET"),


    // ------ MySQL Control Flow Functions
    IFNULL("ifnull", "IFNULL"),

    // ------ MySQL Datetime Functions
    ADDDATE("adddate", "ADDDATE"),
    ADDTIME("addtime", "ADDTIME"),
    CONVERT_TZ("convert_tz", "CONVERT_TZ"),
    CURDATE("curdate", "CURDATE"),
    CURRENT_TIME("current_time", "CURRENT_TIME"),
    CURTIME("curtime", "CURTIME"),
    DATE_ADD("date_add", "DATE_ADD"),
    DATE_FORMAT("date_format", "DATE_FORMAT"),
    DATE_SUB("date_sub", "DATE_SUB"),
    DATEDIFF("datediff", "DATEDIFF"),
    DAYNAME("dayname", "DAYNAME"),
    DAYOFMONTH("dayofmonth", "DAYOFMONTH"),
    DAYOFWEEK("dayofweek", "DAYOFWEEK"),
    DAYOFYEAR("dayofyear", "DAYOFYEAR"),
    FROM_DAYS("from_days", "FROM_DAYS"),
    FROM_UNIXTIME("from_unixtime", "FROM_UNIXTIME"),
    GET_FORMAT("get_format", "GET_FORMAT"),
    LOCALTIME("localtime", "LOCALTIME"),
    MAKEDATE("makedate", "MAKEDATE"),
    MAKETIME("maketime", "MAKETIME"),
    MONTHNAME("monthname", "MONTHNAME"),
    NOW("now", "NOW"),
    PERIOD_ADD("period_add", "PERIOD_ADD"),
    PERIOD_DIFF("period_diff", "PERIOD_DIFF"),
    SEC_TO_TIME("sec_to_time", "SEC_TO_TIME"),
    STR_TO_DATE("str_to_date", "STR_TO_DATE"),
    SUBDATE("subdate", "SUBDATE"),
    SUBTIME("subtime", "SUBTIME"),
    TIME_FORMAT("time_format", "TIME_FORMAT"),
    TIME_TO_SEC("time_to_sec", "TIME_TO_SEC"),
    TIMEDIFF("timediff", "TIMEDIFF"),
    TIMESTAMPADD("timestampadd", "TIMESTAMPADD"),
    TIMESTAMPDIFF("timestampdiff", "TIMESTAMPDIFF"),
    TO_DAYS("to_days", "TO_DAYS"),
    TO_SECONDS("to_seconds", "TO_SECONDS"),
    UNIX_TIMESTAMP("unix_timestamp", "UNIX_TIMESTAMP"),
    UTC_DATE("utc_date", "UTC_DATE"),
    UTC_TIME("utc_time", "UTC_TIME"),
    UTC_TIMESTAMP("utc_timestamp", "UTC_TIMESTAMP"),
    WEEKDAY("weekday", "WEEKDAY"),
    WEEKOFYEAR("weekofyear", "WEEKOFYEAR"),
    YEARWEEK("yearweek", "YEARWEEK"),


    // ------ Comparison Functions
    GREATEST("greatest", "GREATEST"),

    LEAST("least", "LEAST"),

    // ------ Conversion Functions
    ASCIISTR("ASCIISTR", "ASCIISTR"),

    BIN_TO_NUM("BIN_TO_NUM", "BIN_TO_NUM"),

    CAST("CAST", "CAST"),

    CHARTOROWID("CHARTOROWID", "CHARTOROWID"),

    COMPOSE("COMPOSE", "COMPOSE"),

    CONVERT("CONVERT", "CONVERT"),

    DECOMPOSE("DECOMPOSE", "DECOMPOSE"),

    HEXTORAW("HEXTORAW", "HEXTORAW"),

    NUMTODSINTERVAL("NUMTODSINTERVAL", "NUMTODSINTERVAL"),

    NUMTOYMINTERVAL("NUMTOYMINTERVAL", "NUMTOYMINTERVAL"),

    RAWTOHEX("RAWTOHEX", "RAWTOHEX"),

    RAWTONHEX("RAWTONHEX", "RAWTONHEX"),

    ROWIDTOCHAR("ROWIDTOCHAR", "ROWIDTOCHAR"),

    ROWIDTONCHAR("ROWIDTONCHAR", "ROWIDTONCHAR"),

    SCN_TO_TIMESTAMP("SCN_TO_TIMESTAMP", "SCN_TO_TIMESTAMP"),

    TIMESTAMP_TO_SCN("TIMESTAMP_TO_SCN", "TIMESTAMP_TO_SCN"),

    TO_BINARY_DOUBLE("TO_BINARY_DOUBLE", "TO_BINARY_DOUBLE"),

    TO_BINARY_FLOAT("TO_BINARY_FLOAT", "TO_BINARY_FLOAT"),

    TO_BLOB("to_blob", "TO_BLOB"),

    TO_CHAR("to_char", "TO_CHAR"),

    TO_CLOB("to_clob", "TO_CLOB"),

    TO_DATE("to_date", "TO_DATE"),

    TO_DSINTERVAL("to_dsinterval", "TO_DSINTERVAL"),

    TO_LOB("to_lob", "TO_LOB"),

    TO_MULTI_BYTE("to_multi_byte", "TO_MULTI_BYTE"),

    TO_NCHAR("to_nchar", "TO_NCHAR"),

    TO_NCLOB("TO_NCLOB", "TO_NCLOB"),

    TO_NUMBER("TO_NUMBER", "TO_NUMBER"),

    TO_SINGLE_BYTE("TO_SINGLE_BYTE", "TO_SINGLE_BYTE"),

    TO_TIMESTAMP("TO_TIMESTAMP", "TO_TIMESTAMP"),

    TO_TIMESTAMP_TZ("TO_TIMESTAMP_TZ", "TO_TIMESTAMP_TZ"),

    TO_YMINTERVAL("TO_YMINTERVAL", "TO_YMINTERVAL"),

    TREAT("TREAT", "TREAT"),

    UNISTR("UNISTR", "UNISTR"),

    VALIDATE_CONVERSION("VALIDATE_CONVERSION", "VALIDATE_CONVERSION"),

    // ------ Large Object Functions
    BFILENAME("BFILENAME", "BFILENAME"),

    EMPTY_BLOB("EMPTY_BLOB", "EMPTY_BLOB"),

    EMPTY_CLOB("EMPTY_CLOB", "EMPTY_CLOB"),

    // ------ Collection Functions
    CARDINALITY("CARDINALITY", "CARDINALITY"),

    COLLECT("COLLECT", "COLLECT"),

    POWERMULTISET("POWERMULTISET", "POWERMULTISET"),

    POWERMULTISET_BY_CARDINALITY("POWERMULTISET_BY_CARDINALITY", "POWERMULTISET_BY_CARDINALITY"),

    SET("set", "SET"),


    // ------ Hierarchical Functions
    SYS_CONNECT_BY_PATH("SYS_CONNECT_BY_PATH", "SYS_CONNECT_BY_PATH"),

    // ------ Data Mining Functions
    CLUSTER_DETAILS("CLUSTER_DETAILS", "CLUSTER_DETAILS"),

    CLUSTER_DISTANCE("CLUSTER_DISTANCE", "CLUSTER_DISTANCE"),

    CLUSTER_ID("CLUSTER_ID", "CLUSTER_ID"),

    CLUSTER_PROBABILITY("CLUSTER_PROBABILITY", "CLUSTER_PROBABILITY"),

    CLUSTER_SET("CLUSTER_SET", "CLUSTER_SET"),

    FEATURE_COMPARE("FEATURE_COMPARE", "FEATURE_COMPARE"),

    FEATURE_DETAILS("FEATURE_DETAILS", "FEATURE_DETAILS"),

    FEATURE_ID("FEATURE_ID", "FEATURE_ID"),

    FEATURE_SET("FEATURE_SET", "FEATURE_SET"),

    FEATURE_VALUE("FEATURE_VALUE", "FEATURE_VALUE"),

    ORA_DM_PARTITION_NAME("ORA_DM_PARTITION_NAME", "ORA_DM_PARTITION_NAME"),

    PREDICTION("PREDICTION", "PREDICTION"),

    PREDICTION_BOUNDS("PREDICTION_BOUNDS", "PREDICTION_BOUNDS"),

    PREDICTION_COST("PREDICTION_COST", "PREDICTION_COST"),

    PREDICTION_DETAILS("PREDICTION_DETAILS", "PREDICTION_DETAILS"),

    PREDICTION_PROBABILITY("PREDICTION_PROBABILITY", "PREDICTION_PROBABILITY"),

    PREDICTION_SET("PREDICTION_SET", "PREDICTION_SET"),

    // ------ XML Functions
    DEPTH("depth", "DEPTH"),

    EXISTSNODE("EXISTSNODE", "EXISTSNODE"),

    EXTRACTVALUE("EXTRACTVALUE", "EXTRACTVALUE"),

    PATH("PATH", "PATH"),

    SYS_DBURIGEN("SYS_DBURIGEN", "SYS_DBURIGEN"),

    SYS_XMLAGG("SYS_XMLAGG", "SYS_XMLAGG"),

    SYS_XMLGEN("SYS_XMLGEN", "SYS_XMLGEN"),

    XMLAGG("XMLAGG", "XMLAGG"),

    XMLCAST("XMLCAST", "XMLCAST"),

    XMLCDATA("XMLCDATA", "XMLCDATA"),

    XMLCOLATTVAL("XMLCOLATTVAL", "XMLCOLATTVAL"),

    XMLCOMMENT("XMLCOMMENT", "XMLCOMMENT"),

    XMLCONCAT("XMLCONCAT", "XMLCONCAT"),

    XMLDIFF("XMLDIFF", "XMLDIFF"),

    XMLELEMENT("XMLELEMENT", "XMLELEMENT"),

    XMLEXISTS("XMLEXISTS", "XMLEXISTS"),

    XMLFOREST("XMLFOREST", "XMLFOREST"),

    XMLISVALID("XMLISVALID", "XMLISVALID"),

    XMLPARSE("XMLPARSE", "XMLPARSE"),

    XMLPATCH("XMLPATCH", "XMLPATCH"),

    XMLPI("XMLPI", "XMLPI"),

    XMLQUERY("XMLQUERY", "XMLQUERY"),

    XMLROOT("XMLROOT", "XMLROOT"),

    XMLSEQUENCE("XMLSEQUENCE", "XMLSEQUENCE"),

    XMLSERIALIZE("XMLSERIALIZE", "XMLSERIALIZE"),

    XMLTABLE("XMLTABLE", "XMLTABLE"),

    XMLTRANSFORM("XMLTRANSFORM", "XMLTRANSFORM"),

    // ------ JSON Functions
    JSON_QUERY("JSON_QUERY", "JSON_QUERY"),

    JSON_TABLE("JSON_TABLE", "JSON_TABLE"),

    JSON_VALUE("JSON_VALUE", "JSON_VALUE"),

    JSON_ARRAY("JSON_ARRAY", "JSON_ARRAY"),

    JSON_ARRAYAGG("JSON_ARRAYAGG", "JSON_ARRAYAGG"),

    JSON_OBJECT("JSON_OBJECT", "JSON_OBJECT"),

    JSON_OBJECTAGG("JSON_OBJECTAGG", "JSON_OBJECTAGG"),

    JSON_DATAGUIDE("JSON_DATAGUIDE", "JSON_DATAGUIDE"),

    // ------ Encoding and Decoding Functions
    DECODE("DECODE", "DECODE"),
    DUMP("DUMP", "DUMP"),
    ORA_HASH("ORA_HASH", "ORA_HASH"),
    STANDARD_HASH("STANDARD_HASH", "STANDARD_HASH"),
    VSIZE("VSIZE", "VSIZE"),

    // ------ NULL-Related Functions
    COALESCE("COALESCE", "COALESCE"),
    LNNVL("LNNVL", "LNNVL"),
    NANVL("NANVL", "NANVL"),
    NULLIF("NULLIF", "NULLIF"),
    NVL("NVL", "NVL"),
    NVL2("NVL2", "NVL2"),

    // ------ Environment and Identifier Functions
    CON_DBID_TO_ID("CON_DBID_TO_ID", "CON_DBID_TO_ID"),
    CON_GUID_TO_ID("CON_GUID_TO_ID", "CON_GUID_TO_ID"),
    CON_NAME_TO_ID("CON_NAME_TO_ID", "CON_NAME_TO_ID"),
    CON_UID_TO_ID("CON_UID_TO_ID", "CON_UID_TO_ID"),
    ORA_INVOKING_USER("ORA_INVOKING_USER", "ORA_INVOKING_USER"),
    ORA_INVOKING_USERID("ORA_INVOKING_USERID", "ORA_INVOKING_USERID"),
    SYS_CONTEXT("SYS_CONTEXT", "SYS_CONTEXT"),
    SYS_GUID("SYS_GUID", "SYS_GUID"),
    SYS_TYPEID("SYS_TYPEID", "SYS_TYPEID"),
    UID("UID", "UID"),

    USERENV("USERENV", "USERENV"),

    // ------ Aggregate Functions
    APPROX_COUNT("APPROX_COUNT", "APPROX_COUNT"),

    APPROX_COUNT_DISTINCT("APPROX_COUNT_DISTINCT", "APPROX_COUNT_DISTINCT"),

    APPROX_COUNT_DISTINCT_AGG("APPROX_COUNT_DISTINCT_AGG", "APPROX_COUNT_DISTINCT_AGG"),

    APPROX_COUNT_DISTINCT_DETAIL("APPROX_COUNT_DISTINCT_DETAIL", "APPROX_COUNT_DISTINCT_DETAIL"),

    APPROX_MEDIAN("APPROX_MEDIAN", "APPROX_MEDIAN"),

    APPROX_PERCENTILE("APPROX_PERCENTILE", "APPROX_PERCENTILE"),

    APPROX_PERCENTILE_AGG("APPROX_PERCENTILE_AGG", "APPROX_PERCENTILE_AGG"),

    APPROX_PERCENTILE_DETAIL("APPROX_PERCENTILE_DETAIL", "APPROX_PERCENTILE_DETAIL"),

    APPROX_RANK("APPROX_RANK", "APPROX_RANK"),

    APPROX_SUM("APPROX_SUM", "APPROX_SUM"),

    AVG("AVG", "AVG"),

    CORR("CORR", "CORR"),

    CORR_K("CORR_K", "CORR_K"),

    CORR_S("CORR_S", "CORR_S"),

    COUNT("COUNT", "COUNT"),

    COVAR_POP("COVAR_POP", "COVAR_POP"),

    COVAR_SAMP("COVAR_SAMP", "COVAR_SAMP"),

    CUME_DIST("CUME_DIST", "CUME_DIST"),

    DENSE_RANK("DENSE_RANK", "DENSE_RANK"),

    FIRST("FIRST", "FIRST"),

    GROUP_ID("GROUP_ID", "GROUP_ID"),

    GROUPING("GROUPING", "GROUPING"),

    GROUPING_ID("GROUPING_ID", "GROUPING_ID"),

    LAST("LAST", "LAST"),

    LISTAGG("LISTAGG", "LISTAGG"),

    MAX("MAX", "MAX"),

    MEDIAN("MEDIAN", "MEDIAN"),

    MIN("MIN", "MIN"),

    PERCENT_RANK("PERCENT_RANK", "PERCENT_RANK"),

    PERCENTILE_CONT("PERCENTILE_CONT", "PERCENTILE_CONT"),

    PERCENTILE_DISC("PERCENTILE_DISC", "PERCENTILE_DISC"),

    RANK("RANK", "RANK"),

    REGR_SLOPE("REGR_SLOPE", "REGR_SLOPE"),

    REGR_INTERCEPT("REGR_INTERCEPT", "REGR_INTERCEPT"),

    REGR_COUNT("REGR_COUNT", "REGR_COUNT"),

    REGR_R2("REGR_R2", "REGR_R2"),

    REGR_AVGX("REGR_AVGX", "REGR_AVGX"),

    REGR_AVGY("REGR_AVGY", "REGR_AVGY"),

    REGR_SXX("REGR_SXX", "REGR_SXX"),

    REGR_SYY("REGR_SYY", "REGR_SYY"),

    REGR_SXY("REGR_SXY", "REGR_SXY"),

    STATS_BINOMIAL_TEST("STATS_BINOMIAL_TEST", "STATS_BINOMIAL_TEST"),

    STATS_CROSSTAB("STATS_CROSSTAB", "STATS_CROSSTAB"),

    STATS_F_TEST("STATS_F_TEST", "STATS_F_TEST"),

    STATS_KS_TEST("STATS_KS_TEST", "STATS_KS_TEST"),

    STATS_MODE("STATS_MODE", "STATS_MODE"),

    STATS_MW_TEST("STATS_MW_TEST", "STATS_MW_TEST"),

    STATS_ONE_WAY_ANOVA("STATS_ONE_WAY_ANOVA", "STATS_ONE_WAY_ANOVA"),

    STATS_T_TEST_ONE("STATS_T_TEST_ONE", "STATS_T_TEST_ONE"),

    STATS_T_TEST_PAIRED("STATS_T_TEST_PAIRED", "STATS_T_TEST_PAIRED"),

    STATS_T_TEST_INDEP("STATS_T_TEST_INDEP", "STATS_T_TEST_INDEP"),

    STATS_T_TEST_INDEPU("STATS_T_TEST_INDEPU", "STATS_T_TEST_INDEPU"),

    STATS_WSR_TEST("STATS_WSR_TEST", "STATS_WSR_TEST"),

    STDDEV("STDDEV", "STDDEV"),

    STDDEV_POP("STDDEV_POP", "STDDEV_POP"),

    STDDEV_SAMP("STDDEV_SAMP", "STDDEV_SAMP"),

    SUM("SUM", "SUM"),

    SYS_OP_ZONE_ID("SYS_OP_ZONE_ID", "SYS_OP_ZONE_ID"),

    TO_APPROX_COUNT_DISTINCT("TO_APPROX_COUNT_DISTINCT", "TO_APPROX_COUNT_DISTINCT"),

    TO_APPROX_PERCENTILE("TO_APPROX_PERCENTILE", "TO_APPROX_PERCENTILE"),

    VAR_POP("VAR_POP", "VAR_POP"),

    VAR_SAMP("VAR_SAMP", "VAR_SAMP"),

    VARIANCE("VARIANCE", "VARIANCE"),

    // ------ Analytic Functions
    FIRST_VALUE("FIRST_VALUE", "FIRST_VALUE"),

    LAG("LAG", "LAG"),

    LEAD("LEAD", "LEAD"),

    NTH_VALUE("NTH_VALUE", "NTH_VALUE"),

    NTILE("ntile", "NTILE"),

    RATIO_TO_REPORT("ratio_to_report", "RATIO_TO_REPORT"),

    ROW_NUMBER("row_number", "ROW_NUMBER"),

    // ------ Object Reference Functions
    DEREF("deref", "DEREF"),
    MAKE_REF("make_ref", "MAKE_REF"),
    REFTOHEX("reftohex", "REFTOHEX"),
    VALUE("value", "VALUE"),

    // ------ Model Functions
    CV("CV", "CV"),
    ITERATION_NUMBER("ITERATION_NUMBER", "ITERATION_NUMBER"),
    PRESENTNNV("PRESENTNNV", "PRESENTNNV"),
    PRESENTV("PRESENTV", "PRESENTV"),
    PREVIOUS("PREVIOUS", "PREVIOUS"),

    // ------ OLAP Functions
    CUBE_TABLE("CUBE_TABLE", "CUBE_TABLE"),

    // ------ Data Cartridge Functions
    DATAOBJ_TO_MAT_PARTITION("DATAOBJ_TO_MAT_PARTITION", "DATAOBJ_TO_MAT_PARTITION"),

    DATAOBJ_TO_PARTITION("DATAOBJ_TO_PARTITION", "DATAOBJ_TO_PARTITION"),


    LIKE("like", "LIKE"),
    LIKEC("likec", "LIKEC"),
    LIKE2("like2", "LIKE2"),
    LIKE4("like4", "LIKE4"),

    NOT_LIKE("not like", "NOT LIKE"),
    REGEXP("regexp", "REGEXP"),
    NOT_REGEXP("not regexp", "NOT REGEXP"),
    RLIKE("rlike", "RLIKE"),
    SOUNDS_LIKE("sounds like", "SOUNDS LIKE"),

    MICROSECOND("microsecond", "MICROSECOND"),
    SECOND("second", "SECOND"),
    MINUTE("minute", "MINUTE"),
    HOUR("hour", "HOUR"),
    DAY("day", "DAY"),
    DAYS("days", "DAYS"),
    WEEK("week", "WEEK"),
    MONTH("month", "MONTH"),
    MONTHS("months", "MONTHS"),

    QUARTER("quarter", "QUARTER"),

    YEAR("YEAR", "YEAR"),
    YEARS("YEARS", "YEARS"),

    SECOND_MICROSECOND("SECOND_MICROSECOND", "SECOND_MICROSECOND"),

    MINUTE_MICROSECOND("MINUTE_MICROSECOND", "MINUTE_MICROSECOND"),

    MINUTE_SECOND("MINUTE_SECOND", "MINUTE_SECOND"),

    HOUR_MICROSECOND("HOUR_MICROSECOND", "HOUR_MICROSECOND"),

    HOUR_MINUTE("HOUR_MINUTE", "HOUR_MINUTE"),

    HOUR_SECOND("HOUR_SECOND", "HOUR_SECOND"),

    DAY_MICROSECOND("DAY_MICROSECOND", "DAY_MICROSECOND"),

    DAY_SECOND("DAY_SECOND", "DAY_SECOND"),

    DAY_MINUTE("DAY_MINUTE", "DAY_MINUTE"),

    DAY_HOUR("DAY_HOUR", "DAY_HOUR"),

    YEAR_MONTH("YEAR_MONTH", "YEAR_MONTH"),

    TIMEZONE_HOUR("TIMEZONE_HOUR", "TIMEZONE_HOUR"),

    TIMEZONE_MINUTE("TIMEZONE_MINUTE", "TIMEZONE_MINUTE"),

    TIMEZONE_REGION("TIMEZONE_REGION", "TIMEZONE_REGION"),

    TIMEZONE_ABBR("TIMEZONE_ABBR", "TIMEZONE_ABBR"),

    ONLY("only", "ONLY"),

    WITH_TIES("with ties", "WITH TIES"),

    LIMIT("limit", "LIMIT"),

    OFFSET("offset", "OFFSET"),

    FETCH("fetch", "FETCH"),

    PERCENT_KEYWORD("percent", "PERCENT"),

    ORDER_BY("order by", "ORDER BY"),
    GROUP_BY("group by", "GROUP BY"),

    HAVING("having", "HAVING"),

    LOAD_DATA("load data", "LOAD DATA"),
    LOAD_XML("load xml", "LOAD XML"),

    LOW_PRIORITY("low_priority", "LOW_PRIORITY"),
    QUICK("quick", "QUICK"),
    DELAYED("delayed", "DELAYED"),

    CONCURRENT("concurrent", "CONCURRENT"),

    LOCAL("local", "LOCAL"),
    MASTER("master", "MASTER"),

    INFILE("infile", "INFILE"),

    IGNORE("ignore", "IGNORE"),

    INTO_TABLE("into table", "INTO TABLE"),

    PARTITION("partition", "PARTITION"),
    SUBPARTITION("subpartition", "SUBPARTITION"),

    OPTIONALLY("optionally", "OPTIONALLY"),

    TERMINATED_BY("terminated by", "TERMINATED BY"),

    ENCLOSED_BY("enclosed by", "ENCLOSED BY"),

    ESCAPED_BY("escaped by", "ESCAPED BY"),

    LINES("lines", "LINES"),

    STARTING_BY("starting by", "STARTING BY"),

    TABLESAMPLE("tablesample", "TABLESAMPLE"),

    REPEATABLE("repeatable", "REPEATABLE"),

    SAMPLE("sample", "SAMPLE"),

    BLOCK("block", "BLOCK"),

    SEED("seed", "SEED"),

    CORRESPONDING("corresponding", "CORRESPONDING"),

    OJ("oj", "OJ"),

    VERSIONS("versions", "VERSIONS"),

    AS_OF("as of", "AS OF"),
    SCN("scn", "SCN"),
    PERIOD_FOR("period for", "PERIOD FOR"),

    LATERAL("lateral", "LATERAL"),

    KEY_UPDATE("key update", "KEY UPDATE"),
    NO_KEY_UPDATE("no key update", "NO KEY UPDATE"),

    SHARE("share", "SHARE"),

    KEY_SHARE("key share", "KEY SHARE"),

    CONNECT_BY("connect by", "CONNECT BY"),

    UNION("union", "UNION"),

    UNION_ALL("union all", "UNION ALL"),

    UNION_DISTINCT("union distinct", "UNION DISTINCT"),

    MINUS("minus", "MINUS"),

    EXCEPT("except", "EXCEPT"),

    EXCEPT_ALL("except all", "EXCEPT ALL"),

    EXCEPT_DISTINCT("except distinct", "EXCEPT DISTINCT"),

    INTERSECT("intersect", "INTERSECT"),

    INTERSECT_ALL("intersect all", "INTERSECT ALL"),

    INTERSECT_DISTINCT("intersect distinct", "INTERSECT DISTINCT"),

    HIGH_PRIORITY("high_priority", "HIGH_PRIORITY"),

    STRAIGHT_JOIN("straight_join", "STRAIGHT_JOIN"),

    SQL_SMALL_RESULT("sql_small_result", "SQL_SMALL_RESULT"),

    SQL_BIG_RESULT("sql_big_result", "SQL_BIG_RESULT"),

    SQL_BUFFER_RESULT("sql_buffer_result", "SQL_BUFFER_RESULT"),

    SQL_CALC_FOUND_ROWS("sql_calc_found_rows", "SQL_CALC_FOUND_ROWS"),

    FROM("from", "FROM"),

    RECURSIVE("recursive", "RECURSIVE"),

    BREADTH("breadth", "BREADTH"),

    SEARCH("search", "SEARCH"),

    FIRST_BY("first by", "FIRST BY"),

    TO("to", "TO"),

    WHERE("where", "WHERE"),

    ANALYTIC_VIEW("analytic view", "ANALYTIC VIEW"),

    CURRENT_OF("current of", "CURRENT OF"),

    CHAR_CS("CHAR_CS", "CHAR_CS"),

    NCHAR_CS("NCHAR_CS", "NCHAR_CS"),
    NOT("not", "NOT"),
    PRIOR("prior", "PRIOR"),
    CONNECT_BY_ROOT("connect_by_root", "CONNECT_BY_ROOT"),

    MULTISET_EXCEPT("multiset except", "MULTISET EXCEPT"),
    MULTISET_EXCEPT_ALL("multiset except all", "MULTISET EXCEPT ALL"),
    MULTISET_EXCEPT_DISTINCT("multiset except distinct", "MULTISET EXCEPT DISTINCT"),

    MULTISET_INTERSECT("multiset intersect", "MULTISET INTERSECT"),
    MULTISET_INTERSECT_ALL("multiset intersect all", "MULTISET INTERSECT ALL"),
    MULTISET_INTERSECT_DISTINCT("multiset intersect distinct", "MULTISET INTERSECT DISTINCT"),

    MULTISET_UNION("multiset union", "MULTISET UNION"),
    MULTISET_UNION_ALL("multiset union all", "MULTISET UNION ALL"),
    MULTISET_UNION_DISTINCT("multiset union distinct", "MULTISET UNION DISTINCT"),

    A("a", "A"),
    ANY("any", "ANY"),
    SOME("some", "SOME"),

    EMPTY("EMPTY", "EMPTY"),
    PRESENT("PRESENT", "PRESENT"),

    STRICT("STRICT", "STRICT"),
    LAX("LAX", "LAX"),

    WITH_UNIQUE_KEYS("WITH UNIQUE KEYS", "WITH UNIQUE KEYS"),
    WITHOUT_UNIQUE_KEYS("WITHOUT UNIQUE KEYS", "WITHOUT UNIQUE KEYS"),

    ESCAPE("ESCAPE", "ESCAPE"),
    REGEXP_LIKE("regexp_like", "REGEXP_LIKE"),
    EQUALS_PATH("equals_path", "EQUALS_PATH"),
    INFINITE("INFINITE", "INFINITE"),

    JSON("json", "JSON"),

    FORMAT_JSON("FORMAT JSON", "FORMAT JSON"),

    NAN("NAN", "NAN"),
    JSON_UNDERLINE_EXISTS("JSON_EXISTS", "JSON_EXISTS"),
    JSON_UNDERLINE_TEXTCONTAINS("JSON_TEXTCONTAINS", "JSON_TEXTCONTAINS"),
    PASSING("PASSING", "PASSING"),
    SUBMULTISET("SUBMULTISET", "SUBMULTISET"),
    UNDER_UNDERLINE_PATH("UNDER_PATH", "UNDER_PATH"),

    BYTE("byte", "BYTE"),

    UNSIGNED("unsigned", "UNSIGNED"),
    ZEROFILL("zerofill", "ZEROFILL"),

    AT_LOCAL("at local", "AT LOCAL"),
    AT_TIME_ZONE("at time zone", "AT TIME ZONE"),

    EXISTS("exists", "EXISTS"),
    IN("in", "IN"),
    OUT("out", "OUT"),
    INOUT("inout", "INOUT"),
    IN_OUT("in out", "IN OUT"),

    ROWNUM("rownum", "ROWNUM"),
    CURSOR("cursor", "CURSOR"),

    CASE("case", "CASE"),
    END_CASE("end case", "END CASE"),

    CURRVAL("currval", "CURRVAL"),
    NEXTVAL("nextval", "NEXTVAL"),


    ERROR_ON_ERROR("ERROR ON ERROR", "ERROR ON ERROR"),
    TRUE_ON_ERROR("TRUE ON ERROR", "TRUE ON ERROR"),
    FALSE_ON_ERROR("FALSE ON ERROR", "FALSE ON ERROR"),
    NULL_ON_ERROR("NULL ON ERROR", "NULL ON ERROR"),
    EMPTY_ON_ERROR("EMPTY ON ERROR", "EMPTY ON ERROR"),
    EMPTY_ARRAY_ON_ERROR("EMPTY ARRAY ON ERROR", "EMPTY ARRAY ON ERROR"),
    EMPTY_OBJECT_ON_ERROR("EMPTY OBJECT ON ERROR", "EMPTY OBJECT ON ERROR"),

    ERROR_ON_EMPTY("ERROR ON EMPTY", "ERROR ON EMPTY"),
    NULL_ON_EMPTY("NULL ON EMPTY", "NULL ON EMPTY"),
    EMPTY_ON_EMPTY("EMPTY ON EMPTY", "EMPTY ON EMPTY"),
    EMPTY_ARRAY_ON_EMPTY("EMPTY ARRAY ON EMPTY", "EMPTY ARRAY ON EMPTY"),
    EMPTY_OBJECT_ON_EMPTY("EMPTY OBJECT ON EMPTY", "EMPTY OBJECT ON EMPTY"),

    UNNEST("unnest", "UNNEST"),

    WITH_ORDINALITY("with ordinality", "WITH ORDINALITY"),

    OVER("over", "OVER"),

    PARTITION_BY("partition by", "PARTITION BY"),
    PARTITIONSET_BY("partitionset by", "PARTITIONSET BY"),
    FILTER("filter", "FILTER"),
    WITHIN_GROUP("within group", "WITHIN GROUP"),

    DBPARTITION_BY("dbpartition by", "DBPARTITION BY"),
    TBPARTITION_BY("tbpartition by", "TBPARTITION BY"),

    DETERMINISTIC("deterministic", "DETERMINISTIC"),

    ON_OVERFLOW_ERROR("on overflow error", "ON OVERFLOW ERROR"),
    ON_OVERFLOW_TRUNCATE("on overflow truncate", "ON OVERFLOW TRUNCATE"),

    LEADING("leading", "LEADING"),
    TRAILING("trailing", "TRAILING"),
    BOTH("both", "BOTH"),

    HRR("HRR", "HRR"),
    HIERARCHY("HIERARCHY", "HIERARCHY"),

    WITH_COUNT("with count", "WITH COUNT"),
    WITHOUT_COUNT("without count", "WITHOUT COUNT"),

    CALL("call", "CALL"),

    INTO("into", "INTO"),

    ON_CONVERSION_ERROR("on conversion error", "ON CONVERSION ERROR"),

    KEY("key", "KEY"),
    RETURNING("RETURNING", "RETURNING"),
    PRETTY("PRETTY", "PRETTY"),

    ON_ERROR("on error", "ON ERROR"),
    ON_EMPTY("on empty", "ON EMPTY"),

    COLUMNS("COLUMNS", "COLUMNS"),

    NESTED("NESTED", "NESTED"),
    NESTED_TABLE("NESTED TABLE", "NESTED TABLE"),

    FOR_ORDINALITY("FOR ORDINALITY", "FOR ORDINALITY"),

    ON_NULL("on null", "ON NULL"),
    NULL_ON_NULL("null on null", "NULL ON NULL"),
    ABSENT_ON_NULL("absent on null", "ABSENT ON NULL"),

    WITHOUT_WRAPPER("without wrapper", "WITHOUT WRAPPER"),
    WITHOUT_ARRAY_WRAPPER("without array wrapper", "WITHOUT ARRAY WRAPPER"),

    WITH_WRAPPER("with wrapper", "WITH WRAPPER"),
    WITH_UNCONDITIONAL_WRAPPER("with unconditional wrapper", "WITH UNCONDITIONAL WRAPPER"),
    WITH_CONDITIONAL_WRAPPER("with conditional wrapper", "WITH CONDITIONAL WRAPPER"),
    WITH_ARRAY_WRAPPER("with array wrapper", "WITH ARRAY WRAPPER"),
    WITH_UNCONDITIONAL_ARRAY_WRAPPER("with unconditional array wrapper", "WITH UNCONDITIONAL ARRAY WRAPPER"),
    WITH_CONDITIONAL_ARRAY_WRAPPER("with conditional array wrapper", "WITH CONDITIONAL ARRAY WRAPPER"),

    X("x", "X"),
    ZERO_X("0x", "0x"),

    WITH_TIME_ZONE("WITH TIME ZONE", "WITH TIME ZONE"),
    WITHOUT_TIME_ZONE("WITHOUT TIME ZONE", "WITHOUT TIME ZONE"),
    WITH_LOCAL_TIME_ZONE("WITH LOCAL TIME ZONE", "WITH LOCAL TIME ZONE"),

    COST("cost", "COST"),
    VALUES("values", "VALUES"),

    OF_ANOMALY("of anomaly", "OF ANOMALY"),

    COST_MODEL("cost model", "COST MODEL"),
    COST_MODEL_AUTO("cost model auto", "COST MODEL AUTO"),

    ENTITYESCAPING("entityescaping", "ENTITYESCAPING"),
    NOENTITYESCAPING("noentityescaping", "NOENTITYESCAPING"),

    NAME("name", "NAME"),
    EVALNAME("evalname", "EVALNAME"),

    SCHEMACHECK("schemacheck", "SCHEMACHECK"),
    NOSCHEMACHECK("noschemacheck", "NOSCHEMACHECK"),

    NO_VALUE("no value", "NO VALUE"),

    CONTENT("content", "CONTENT"),
    DOCUMENT("document", "DOCUMENT"),

    NO_INDENT("no indent", "NO INDENT"),
    INDENT("indent", "INDENT"),

    HIDE("hide", "HIDE"),
    SHOW("show", "SHOW"),

    STANDALONE_YES("standalone yes", "STANDALONE YES"),
    STANDALONE_NO("standalone no", "STANDALONE NO"),
    STANDALONE_NO_VALUE("standalone no value", "STANDALONE NO VALUE"),

    XMLATTRIBUTES("xmlattributes", "XMLATTRIBUTES"),

    WELLFORMED("wellformed", "WELLFORMED"),

    RETURNING_CONTENT("returning content", "RETURNING CONTENT"),

    ENCODING("encoding", "ENCODING"),
    VERSION("version", "VERSION"),

    XMLNAMESPACES("xmlnamespaces", "XMLNAMESPACES"),

    RETURNING_SEQUENCE_BY_REF("returning sequence by ref", "RETURNING SEQUENCE BY REF"),

    BY_VALUE("by value", "BY VALUE"),

    RESULT("result", "RESULT"),

    NOCOPY("nocopy", "NOCOPY"),

    PARALLEL_ENABLE("PARALLEL_ENABLE", "PARALLEL_ENABLE"),

    HASH("hash", "HASH"),
    RANGE_HASH("rang_hash", "RANG_HASH"),
    CONSISTENT_HASH("consistent hash", "CONSISTENT HASH"),
    CLUSTER("cluster", "CLUSTER"),

    RESULT_CACHE("RESULT_CACHE", "RESULT_CACHE"),
    RELIES_ON("RELIES_ON", "RELIES_ON"),

    AGENT_IN("agent in", "AGENT IN"),
    LIBRARY("library", "LIBRARY"),

    CONTEXT("context", "CONTEXT"),

    SELF("self", "SELF"),
    CONSTANT("constant", "CONSTANT"),

    HELP("help", "HELP"),
    USE("use", "USE"),
    EXPLAIN("explain", "EXPLAIN"),

    RENAME("rename", "RENAME"),
    RENAME_TABLE("rename table", "RENAME TABLE"),

    BULK_COLLECT("bulk collect", "BULK COLLECT"),

    INCLUDE_NULLS("include nulls", "INCLUDE NULLS"),
    EXCLUDE_NULLS("exclude nulls", "EXCLUDE NULLS"),

    WITH_READ_ONLY("with read only", "WITH READ ONLY"),
    WITH_CHECK_OPTION("with check option", "WITH CHECK OPTION"),


    JOIN("join", "JOIN"),
    NATURAL_JOIN("natural join", "NATURAL JOIN"),
    INNER_JOIN("inner join", "INNER JOIN"),
    NATURAL_INNER_JOIN("natural inner join", "NATURAL INNER JOIN"),

    CROSS_JOIN("cross join", "CROSS JOIN"),

    LEFT_JOIN("left join", "LEFT JOIN"),
    LEFT_OUTER_JOIN("left outer join", "LEFT OUTER JOIN"),
    NATURAL_LEFT_JOIN("natural left join", "NATURAL LEFT JOIN"),
    NATURAL_LEFT_OUTER_JOIN("natural left outer join", "NATURAL LEFT OUTER JOIN"),

    LEFT_SEMI_JOIN("left semi join", "LEFT SEMI JOIN"),
    LEFT_ANTI_JOIN("left anti join", "LEFT ANTI JOIN"),

    RIGHT_JOIN("right join", "RIGHT JOIN"),
    RIGHT_OUTER_JOIN("right outer join", "RIGHT OUTER JOIN"),
    NATURAL_RIGHT_JOIN("natural right join", "NATURAL RIGHT JOIN"),
    NATURAL_RIGHT_OUTER_JOIN("natural right outer join", "NATURAL RIGHT OUTER JOIN"),

    FULL_JOIN("full join", "FULL JOIN"),
    FULL_OUTER_JOIN("full outer join", "FULL OUTER JOIN"),
    NATURAL_FULL_JOIN("natural full join", "NATURAL FULL JOIN"),
    NATURAL_FULL_OUTER_JOIN("natural full outer join", "NATURAL FULL OUTER JOIN"),

    UNION_JOIN("union join", "UNION JOIN"),

    STRAIGHT_UNDERLINE_JOIN("straight_join", "STRAIGHT_JOIN"),
    OUTER_APPLY("outer apply", "OUTER APPLY"),
    CROSS_APPLY("cross apply", "CROSS APPLY"),

    UNLIMITED("unlimited", "UNLIMITED"),

    ONE_ROW_PER_MATCH("one row per match", "ONE ROW PER MATCH"),
    ALL_ROWS_PER_MATCH("all rows per match", "ALL ROWS PER MATCH"),

    MATCH_RECOGNIZE("match_recognize", "MATCH_RECOGNIZE"),
    PATTERN("pattern", "PATTERN"),
    DEFINE("define", "DEFINE"),
    MEASURES("measures", "MEASURES"),
    AFTER_MATCH_SKIP_TO("after match skip to", "AFTER MATCH SKIP TO"),
    AFTER_MATCH_SKIP_PAST("after match skip past", "AFTER MATCH SKIP PAST"),
    NEXT_ROW("after match skip", "AFTER MATCH SKIP"),
    LAST_ROW("last row", "LAST ROW"),
    SUBSET("subset", "SUBSET"),

    CUBE("cube", "CUBE"),
    ROLLUP("rollup", "ROLLUP"),

    NO("no", "NO"),
    YES("yes", "YES"),

    WAIT("wait", "WAIT"),
    NOWAIT("nowait", "NOWAIT"),
    SKIP_LOCKED("skip locked", "SKIP LOCKED"),


    PRAGMA_AUTONOMOUS_TRANSACTION("pragma autonomous_transaction", "PRAGMA AUTONOMOUS_TRANSACTION"),
    PRAGMA_COVERAGE("pragma coverage", "PRAGMA COVERAGE"),
    PRAGMA_DEPRECATE("pragma deprecate", "PRAGMA DEPRECATE"),
    PRAGMA_EXCEPTION_INIT("pragma exception_init", "PRAGMA EXCEPTION_INIT"),
    PRAGMA_INLINE("pragma inline", "PRAGMA INLINE"),
    PRAGMA_RESTRICT_REFERENCES("pragma restrict_references", "PRAGMA RESTRICT_REFERENCES"),
    PRAGMA_SERIALLY_REUSABLE("pragma serially_reusable", "PRAGMA SERIALLY_REUSABLE"),
    PRAGMA_UDF("pragma udf", "PRAGMA UDF"),

    INDICES_OF("indices of", "INDICES OF"),
    VALUES_OF("values of", "VALUES OF"),

    FORALL("forall", "FORALL"),
    SAVE_EXCEPTIONS("save exceptions", "SAVE EXCEPTIONS"),

    REVERSE("reverse", "REVERSE"),
    NOREVERSE("noreverse", "NOREVERSE"),
    LOOP("loop", "LOOP"),
    END_LOOP("end loop", "END LOOP"),

    HIERARCHIES("hierarchies", "HIERARCHIES"),

    FILTER_FACT("filter fact", "FILTER FACT"),
    ADD_MEASURES("add measures", "ADD MEASURES"),

    GROUPING_SETS("grouping sets", "GROUPING SETS"),

    DIMENSION("dimension", "DIMENSION"),
    SINGLE_REFERENCE("single reference", "SINGLE REFERENCE"),

    RETURN_UPDATED_ROWS("return updated rows", "RETURN UPDATED ROWS"),
    RETURN_ALL_ROWS("return all rows", "RETURN ALL ROWS"),

    RULES("rules", "RULES"),
    UPSERT("upsert", "UPSERT"),
    UPSERT_ALL("upsert all", "UPSERT ALL"),

    AUTOMATIC_ORDER("automatic order", "AUTOMATIC ORDER"),
    SEQUENTIAL_ORDER("sequential order", "SEQUENTIAL ORDER"),

    MODEL("model", "MODEL"),
    NAV("nav", "NAV"),
    MAIN("main", "MAIN"),
    ITERATE("iterate", "ITERATE"),
    UNTIL("until", "UNTIL"),
    ON("on", "ON"),

    PIVOT("pivot", "PIVOT"),
    UNPIVOT("unpivot", "UNPIVOT"),

    RESPECT_NULLS("respect nulls", "RESPECT NULLS"),
    IGNORE_NULLS("ignore nulls", "IGNORE NULLS"),

    FROM_FIRST("from first", "FROM FIRST"),
    FROM_LAST("from last", "FROM LAST"),

    LOG_ERRORS("log errors", "LOG ERRORS"),

    REJECT_LIMIT("reject limit", "REJECT LIMIT"),

    CONSTRAINT("constraint", "CONSTRAINT"),

    CONTAINERS("containers", "CONTAINERS"),
    SHARDS("shards", "SHARDS"),

    SPECIFICATION("specification", "SPECIFICATION"),
    BODY("body", "BODY"),

    DEBUG("debug", "DEBUG"),
    REUSE_SETTINGS("reuse settings", "REUSE SETTINGS"),

    GOTO("goto", "GOTO"),

    OPEN("open", "OPEN"),
    CLOSE("close", "CLOSE"),
    CONTINUE("continue", "CONTINUE"),

    RAISE("raise", "RAISE"),

    WHILE("while", "WHILE"),
    DO("do", "DO"),
    END_WHILE("end while", "END WHILE"),

    EXECUTE_IMMEDIATE("execute immediate", "EXECUTE IMMEDIATE"),

    EXTEND("extend", "EXTEND"),
    NOEXTEND("noextend", "NOEXTEND"),
    NEXT("next", "NEXT"),

    // oracle Predefined Exceptions
    ACCESS_INTO_NULL("ACCESS_INTO_NULL", "ACCESS_INTO_NULL"),
    CASE_NOT_FOUND("CASE_NOT_FOUND", "CASE_NOT_FOUND"),
    COLLECTION_IS_NULL("COLLECTION_IS_NULL", "COLLECTION_IS_NULL"),
    CURSOR_ALREADY_OPEN("CURSOR_ALREADY_OPEN", "CURSOR_ALREADY_OPEN"),
    DUP_VAL_ON_INDEX("DUP_VAL_ON_INDEX", "DUP_VAL_ON_INDEX"),
    INVALID_CURSOR("INVALID_CURSOR", "INVALID_CURSOR"),
    INVALID_NUMBER("INVALID_NUMBER", "INVALID_NUMBER"),
    LOGIN_DENIED("LOGIN_DENIED", "LOGIN_DENIED"),
    NO_DATA_FOUND("NO_DATA_FOUND", "NO_DATA_FOUND"),
    NO_DATA_NEEDED("NO_DATA_NEEDED", "NO_DATA_NEEDED"),
    NOT_LOGGED_ON("NOT_LOGGED_ON", "NOT_LOGGED_ON"),
    PROGRAM_ERROR("PROGRAM_ERROR", "PROGRAM_ERROR"),
    ROWTYPE_MISMATCH("ROWTYPE_MISMATCH", "ROWTYPE_MISMATCH"),
    SELF_IS_NULL("SELF_IS_NULL", "SELF_IS_NULL"),
    STORAGE_ERROR("STORAGE_ERROR", "STORAGE_ERROR"),
    SUBSCRIPT_BEYOND_COUNT("SUBSCRIPT_BEYOND_COUNT", "SUBSCRIPT_BEYOND_COUNT"),
    SUBSCRIPT_OUTSIDE_LIMIT("SUBSCRIPT_OUTSIDE_LIMIT", "SUBSCRIPT_OUTSIDE_LIMIT"),
    SYS_INVALID_ROWID("SYS_INVALID_ROWID", "SYS_INVALID_ROWID"),
    TIMEOUT_ON_RESOURCE("TIMEOUT_ON_RESOURCE", "TIMEOUT_ON_RESOURCE"),
    TOO_MANY_ROWS("TOO_MANY_ROWS", "TOO_MANY_ROWS"),
    VALUE_ERROR("VALUE_ERROR", "VALUE_ERROR"),
    ZERO_DIVIDE("ZERO_DIVIDE", "ZERO_DIVIDE"),

    DELETING("DELETING", "DELETING"),
    INSERTING("INSERTING", "INSERTING"),
    UPDATING("UPDATING", "UPDATING"),

    ANALYZE("ANALYZE", "ANALYZE"),
    ASSOCIATE_STATISTICS("ASSOCIATE STATISTICS", "ASSOCIATE STATISTICS"),
    AUDIT("AUDIT", "AUDIT"),
    DISASSOCIATE_STATISTICS("DISASSOCIATE STATISTICS", "DISASSOCIATE STATISTICS"),
    GRANT("GRANT", "GRANT"),
    NOAUDIT("NOAUDIT", "NOAUDIT"),
    REVOKE("REVOKE", "REVOKE"),
    TRUNCATE("TRUNCATE", "TRUNCATE"),
    DDL("DDL", "DDL"),

    STARTUP("STARTUP", "STARTUP"),
    SHUTDOWN("SHUTDOWN", "SHUTDOWN"),
    DB_ROLE_CHANGE("DB_ROLE_CHANGE", "DB_ROLE_CHANGE"),
    SERVERERROR("SERVERERROR", "SERVERERROR"),
    LOGON("LOGON", "LOGON"),
    LOGOFF("LOGOFF", "LOGOFF"),
    SUSPEND("SUSPEND", "SUSPEND"),
    CLONE("CLONE", "CLONE"),
    UNPLUG("UNPLUG", "UNPLUG"),
    SET_CONTAINER("SET CONTAINER", "SET CONTAINER"),

    PLUGGABLE("PLUGGABLE", "PLUGGABLE"),

    COMPOUND_TRIGGER("COMPOUND TRIGGER", "COMPOUND TRIGGER"),

    REFERENCING("REFERENCING", "REFERENCING"),

    UNDER("under", "UNDER"),

    IDENTIFIED("IDENTIFIED", "IDENTIFIED"),
    NO_IDENTIFIED("NO IDENTIFIED", "NO IDENTIFIED"),
    EXTERNALLY("EXTERNALLY", "EXTERNALLY"),
    GLOBALLY("GLOBALLY", "GLOBALLY"),
    PASSWORD("PASSWORD", "PASSWORD"),
    NO_AUTHENTICATION("NO AUTHENTICATION", "NO AUTHENTICATION"),
    IDENTIFIED_BY("IDENTIFIED BY", "IDENTIFIED BY"),

    OID("OID", "OID"),
    EXTERNAL_NAME("EXTERNAL NAME", "EXTERNAL NAME"),

    SCOPE("SCOPE", "SCOPE"),
    SCOPE_IS("SCOPE IS", "SCOPE IS"),
    SCOPE_FOR("SCOPE FOR", "SCOPE FOR"),

    SCALE("scale", "SCALE"),
    NOSCALE("noscale", "NOSCALE"),

    PRESERVE_TABLE("preserve table", "PRESERVE TABLE"),

    IMMEDIATE("immediate", "IMMEDIATE"),
    DEFERRED("deferred", "DEFERRED"),

    BATCH("batch", "BATCH"),

    VISIBLE("visible", "VISIBLE"),
    INVISIBLE("invisible", "INVISIBLE"),

    STORAGE("storage", "STORAGE"),
    INITIAL("initial", "INITIAL"),
    MINEXTENTS("minextents", "MINEXTENTS"),
    MAXEXTENTS("maxextents", "MAXEXTENTS"),
    MAXSIZE("maxsize", "MAXSIZE"),
    PCTINCREASE("pctincrease", "PCTINCREASE"),
    FREELISTS("freelists", "FREELISTS"),
    FREELIST_GROUPS("freelist groups", "FREELIST GROUPS"),
    RECYCLE("recycle", "RECYCLE"),
    OPTIMAL("optimal", "OPTIMAL"),
    BUFFER_POOL("buffer_pool", "BUFFER_POOL"),
    FLASH_CACHE("flash_cache", "FLASH_CACHE"),
    CELL_FLASH_CACHE("cell_flash_cache", "CELL_FLASH_CACHE"),
    ENCRYPT("encrypt", "ENCRYPT"),

    SALT("salt", "SALT"),
    NO_SALT("no salt", "NO SALT"),

    AUTO_INCREMENT("auto_increment", "AUTO_INCREMENT"),
    PRIMARY("primary", "PRIMARY"),
    PRIMARY_KEY("primary key", "PRIMARY KEY"),
    FOREIGN_KEY("foreign key", "FOREIGN KEY"),
    SYSTEM_GENERATED("system generated", "SYSTEM GENERATED"),

    BASIC("BASIC", "BASIC"),
    ADVANCED("ADVANCED", "ADVANCED"),

    FOR_QUERY("FOR QUERY", "FOR QUERY"),
    FOR_QUERY_LOW("FOR QUERY LOW", "FOR QUERY LOW"),
    FOR_QUERY_HIGH("FOR QUERY HIGH", "FOR QUERY HIGH"),
    FOR_ARCHIVE("FOR ARCHIVE", "FOR ARCHIVE"),
    FOR_ARCHIVE_LOW("FOR ARCHIVE LOW", "FOR ARCHIVE LOW"),
    FOR_ARCHIVE_HIGH("FOR ARCHIVE HIGH", "FOR ARCHIVE HIGH"),

    ROW_LEVEL_LOCKING("ROW LEVEL LOCKING", "ROW LEVEL LOCKING"),
    NO_ROW_LEVEL_LOCKING("NO ROW LEVEL LOCKING", "NO ROW LEVEL LOCKING"),

    BASICFILE("basicfile", "BASICFILE"),
    SECUREFILE("securefile", "SECUREFILE"),

    REFRESH("REFRESH", "REFRESH"),
    NEVER_REFRESH("never refresh", "NEVER REFRESH"),

    FAST("fast", "FAST"),
    COMPLETE("COMPLETE", "COMPLETE"),
    ON_DEMAND("ON DEMAND", "ON DEMAND"),
    ON_COMMIT("ON COMMIT", "ON COMMIT"),
    ON_STATEMENT("ON STATEMENT", "ON STATEMENT"),
    WITH_PRIMARY_KEY("with primary key", "WITH PRIMARY KEY"),
    WITH_ROWID("with rowid", "WITH ROWID"),
    USING_ENFORCED_CONSTRAINTS("using enforced constraints", "USING ENFORCED CONSTRAINTS"),
    USING_TRUSTED_CONSTRAINTS("using trusted constraints", "USING TRUSTED CONSTRAINTS"),

    CURRENT_EDITION("current edition", "CURRENT EDITION"),
    NULL_EDITION("null edition", "NULL EDITION"),

    HIGH("high", "HIGH"),
    MEDIUM("medium", "MEDIUM"),
    LOW("low", "LOW"),

    STORAGE_IN_ROW("STORAGE IN ROW", "STORAGE IN ROW"),

    LOB("LOB", "LOB"),
    STORE_AS("STORE AS", "STORE AS"),
    CHUNK("CHUNK", "CHUNK"),
    PCTVERSION("PCTVERSION", "PCTVERSION"),
    FREEPOOLS("FREEPOOLS", "FREEPOOLS"),
    DECRYPT("DECRYPT", "DECRYPT"),
    RETENTION("RETENTION", "RETENTION"),

    KEEP_DUPLICATES("keep_duplicates", "KEEP_DUPLICATES"),
    DEDUPLICATE("deduplicate", "DEDUPLICATE"),

    COMPRESS("COMPRESS", "COMPRESS"),
    NOCOMPRESS("NOCOMPRESS", "NOCOMPRESS"),

    PCTFREE("pctfree", "PCTFREE"),
    PCTUSED("pctused", "PCTUSED"),
    INITRANS("initrans", "INITRANS"),
    MAXTRANS("maxtrans", "MAXTRANS"),

    QUERY_REWRITE("QUERY REWRITE", "QUERY REWRITE"),

    UNUSABLE_BEFORE("UNUSABLE BEFORE", "UNUSABLE BEFORE"),
    UNUSABLE_BEGINNING_WITH("UNUSABLE BEGINNING WITH", "UNUSABLE BEGINNING WITH"),

    ON_PREBUILT_TABLE("ON PREBUILT TABLE", "ON PREBUILT TABLE"),
    REDUCED_PRECISION("REDUCED PRECISION", "REDUCED PRECISION"),

    DML("DML", "DML"),
    QUERY("QUERY", "QUERY"),
    QUERY_LOW("QUERY LOW", "QUERY LOW"),
    QUERY_HIGH("QUERY HIGH", "QUERY HIGH"),
    CAPACITY("CAPACITY", "CAPACITY"),
    CAPACITY_LOW("CAPACITY LOW", "CAPACITY LOW"),
    CAPACITY_HIGH("CAPACITY HIGH", "CAPACITY HIGH"),

    SEGMENT("SEGMENT", "SEGMENT"),
    GROUP("GROUP", "GROUP"),

    NO_ACCESS("NO ACCESS", "NO ACCESS"),
    NO_MODIFICATION("NO MODIFICATION", "NO MODIFICATION"),
    CREATION("CREATION", "CREATION"),

    CRITICAL("CRITICAL", "CRITICAL"),
    AUTO("AUTO", "AUTO"),
    BY_ROWID_RANGE("BY ROWID RANGE", "BY ROWID RANGE"),
    BY_PARTITION("BY PARTITION", "BY PARTITION"),
    BY_SUBPARTITION("BY SUBPARTITION", "BY SUBPARTITION"),

    ORGANIZATION_HEAP("organization heap", "ORGANIZATION HEAP"),
    ORGANIZATION_INDEX("organization index", "ORGANIZATION INDEX"),
    ORGANIZATION_EXTERNAL("organization external", "ORGANIZATION EXTERNAL"),

    READ_ONLY("READ ONLY", "READ ONLY"),
    READ_WRITE("READ WRITE", "READ WRITE"),

    REFERENCES("references", "REFERENCES"),
    CHECK("check", "CHECK"),

    LINEAR("linear", "LINEAR"),
    PARTITIONS("partitions", "PARTITIONS"),
    SUBPARTITIONS("subpartitions", "SUBPARTITIONS"),
    LIST("list", "LIST"),
    LIST_COLUMNS("list columns", "LIST COLUMNS"),
    RANGE_COLUMNS("range columns", "RANGE COLUMNS"),
    SYSTEM("system", "SYSTEM"),
    PARTITIONS_AUTO("partitions auto", "PARTITIONS AUTO"),
    PARTITIONSET("partitionset", "PARTITIONSET"),
    SUBPARTITION_BY("subpartition by", "SUBPARTITION BY"),
    SUBPARTITION_TEMPLATE("subpartition template", "SUBPARTITION TEMPLATE"),

    TBPARTITIONS("tbpartitions", "TBPARTITIONS"),
    MM("mm", "MM"),
    DD("dd", "DD"),
    MMDD("mmdd", "MMDD"),

    VALUES_LESS_THAN("values less than", "VALUES LESS THAN"),
    VALUES_IN("values in", "VALUES IN"),

    STORE_IN("STORE IN", "STORE IN"),
    OVERFLOW_STORE_IN("OVERFLOW STORE IN", "OVERFLOW STORE IN"),
    SUBPARTITIONSET_STORE_IN("SUBPARTITIONSET STORE IN", "SUBPARTITIONSET STORE IN"),

    REUSE("reuse", "REUSE"),
    BLOCKSIZE("blockSize", "BLOCKSIZE"),

    LOGGING("logging", "LOGGING"),
    NOLOGGING("nologging", "NOLOGGING"),
    FILESYSTEM_LIKE_LOGGING("filesystem_like_logging", "FILESYSTEM_LIKE_LOGGING"),
    NOPARALLEL("noparallel", "NOPARALLEL"),
    PARALLEL("parallel", "PARALLEL"),

    ROW_STORE_COMPRESS("row store compress", "ROW STORE COMPRESS"),
    COLUMN_STORE_COMPRESS("column store compress", "COLUMN STORE COMPRESS"),

    WITH_DATA("WITH DATA", "WITH DATA"),
    WITH_NO_DATA("WITH NO DATA", "WITH NO DATA"),

    TABLESPACE_SET("TABLESPACE SET", "TABLESPACE SET"),
    COMPRESS_ADVANCED("compress advanced", "COMPRESS ADVANCED"),

    INMEMORY("inmemory", "INMEMORY"),
    NO_INMEMORY("no inmemory", "NO INMEMORY"),

    ELEMENT("element", "ELEMENT"),
    SUBSTITUTABLE_AT_ALL_LEVELS("substitutable at all levels", "SUBSTITUTABLE AT ALL LEVELS"),

    COLUMN_VALUE("column_value", "COLUMN_VALUE"),

    RETURN_LOCATOR("RETURN LOCATOR", "RETURN LOCATOR"),
    RETURN_AS_LOCATOR("RETURN AS LOCATOR", "RETURN AS LOCATOR"),
    RETURN_VALUE("RETURN VALUE", "RETURN VALUE"),
    RETURN_AS_VALUE("RETURN AS VALUE", "RETURN AS VALUE"),

    INCLUDING("including", "INCLUDING"),
    EXCLUDING("excluding", "EXCLUDING"),
    OVERFLOW("overflow", "OVERFLOW"),

    ACCESS_PARAMETERS("ACCESS PARAMETERS", "ACCESS PARAMETERS"),

    USING_CLOB("USING CLOB", "USING CLOB"),

    MAPPING_TABLE("MAPPING TABLE", "MAPPING TABLE"),
    NOMAPPING("NOMAPPING", "NOMAPPING"),
    PCTTHRESHOLD("PCTTHRESHOLD", "PCTTHRESHOLD"),

    BUILD("BUILD", "BUILD"),
    EVALUATE_USING("EVALUATE USING", "EVALUATE USING"),

    ALWAYS("ALWAYS", "ALWAYS"),
    BY_DEFAULT("by default", "BY DEFAULT"),
    BY_DEFAULT_ON_NULL("by default on null", "BY DEFAULT ON NULL"),

    GENERATED("generated", "GENERATED"),
    AS_IDENTITY("as identity", "AS IDENTITY"),

    SUPPLEMENTAL_LOG_GROUP("SUPPLEMENTAL LOG GROUP", "SUPPLEMENTAL LOG GROUP"),
    NOT_LOG("not log", "NOT LOG"),
    SUPPLEMENTAL_LOG_DATA("supplemental log data", "SUPPLEMENTAL LOG DATA"),

    ALLOW("ALLOW", "ALLOW"),
    DISALLOW("DISALLOW", "DISALLOW"),

    DIRECT_LOAD("DIRECT_LOAD", "DIRECT_LOAD"),
    OPERATIONS("OPERATIONS", "OPERATIONS"),

    K("K", "K"),
    M("M", "M"),
    G("G", "G"),
    T("T", "T"),
    P("P", "P"),
    E("E", "E"),

    EXIT("exit", "EXIT"),
    WORK("WORK", "WORK"),
    TRANSACTION("TRANSACTION", "TRANSACTION"),

    SERIALIZABLE("SERIALIZABLE", "SERIALIZABLE"),
    REPEATABLE_READ("REPEATABLE READ", "REPEATABLE READ"),
    READ_COMMITTED("READ COMMITTED", "READ COMMITTED"),
    READ_UNCOMMITTED("READ UNCOMMITTED", "READ UNCOMMITTED"),

    WRITE("WRITE", "WRITE"),
    LOW_PRIORITY_WRITE("low_priority write", "LOW_PRIORITY WRITE"),
    CHAIN("CHAIN", "CHAIN"),
    RELEASE("RELEASE", "RELEASE"),

    ISOLATION_LEVEL("ISOLATION LEVEL", "ISOLATION LEVEL"),
    USE_ROLLBACK_SEGMENT("USE ROLLBACK SEGMENT", "USE ROLLBACK SEGMENT"),
    SNAPSHOT("SNAPSHOT", "SNAPSHOT"),

    ACCESS_SHARE("ACCESS SHARE", "ACCESS SHARE"),
    ROW_SHARE("ROW SHARE", "ROW SHARE"),
    ROW_EXCLUSIVE("ROW EXCLUSIVE", "ROW EXCLUSIVE"),
    SHARE_UPDATE_EXCLUSIVE("SHARE UPDATE EXCLUSIVE", "SHARE UPDATE EXCLUSIVE"),
    SHARE_UPDATE("SHARE UPDATE", "SHARE UPDATE"),
    SHARE_ROW_EXCLUSIVE("SHARE ROW EXCLUSIVE", "SHARE ROW EXCLUSIVE"),
    EXCLUSIVE("EXCLUSIVE", "EXCLUSIVE"),
    ACCESS_EXCLUSIVE("ACCESS EXCLUSIVE", "ACCESS EXCLUSIVE"),

    LOCK("LOCK", "LOCK"), MODE("MODE", "MODE"),


    PERCENT_ISOPEN("%ISOPEN", "%ISOPEN"),
    PERCENT_FOUND("%FOUND", "%FOUND"),
    PERCENT_NOTFOUND("%NOTFOUND", "%NOTFOUND"),
    PERCENT_ROWCOUNT("%ROWCOUNT", "%ROWCOUNT"),
    PERCENT_BULK_ROWCOUNT("%BULK_ROWCOUNT", "%BULK_ROWCOUNT"),
    PERCENT_BULK_EXCEPTIONS("%BULK_EXCEPTIONS", "%BULK_EXCEPTIONS"),

    ERROR_CODE("ERROR_CODE", "ERROR_CODE"),
    ERROR_INDEX("ERROR_INDEX", "ERROR_INDEX"),

    SQL("SQL", "SQL"), NEXT_FROM("NEXT FROM", "NEXT FROM"),

    N("n", "N"), Q("q", "Q"), NQ("nq", "NQ"),

    VIRTUAL("virtual", "VIRTUAL"),
    STORED("stored", "STORED"),

    INCLUDING_IDENTITY("including identity", "INCLUDING IDENTITY"),
    EXCLUDING_IDENTITY("excluding identity", "EXCLUDING IDENTITY"),

    INCLUDING_DEFAULTS("including defaults", "INCLUDING DEFAULTS"),
    EXCLUDING_DEFAULTS("excluding defaults", "EXCLUDING DEFAULTS"),

    INCLUDING_CONSTRAINTS("including constraints", "INCLUDING CONSTRAINTS"),
    EXCLUDING_CONSTRAINTS("excluding constraints", "EXCLUDING CONSTRAINTS"),

    INCLUDING_INDEXES("including indexes", "INCLUDING INDEXES"),
    EXCLUDING_INDEXES("excluding indexes", "EXCLUDING INDEXES"),

    INCLUDING_STORAGE("including storage", "INCLUDING STORAGE"),
    EXCLUDING_STORAGE("excluding storage", "EXCLUDING STORAGE"),

    INCLUDING_COMMENTS("including comments", "INCLUDING COMMENTS"),
    EXCLUDING_COMMENTS("excluding comments", "EXCLUDING COMMENTS"),

    INCLUDING_ALL("INCLUDING ALL", "INCLUDING ALL"),
    EXCLUDING_ALL("EXCLUDING ALL", "EXCLUDING ALL"),

    CONCURRENTLY("concurrently", "CONCURRENTLY"),
    ONLINE("online", "ONLINE"),
    OFFLINE("offline", "OFFLINE"),
    SORT("SORT", "SORT"),
    NOSORT("NOSORT", "NOSORT"),

    INDEXING_FULL("indexing full", "INDEXING FULL"),
    INDEXING_PARTIAL("indexing partial", "INDEXING PARTIAL"),

    MONITORING_USAGE("MONITORING USAGE", "MONITORING USAGE"),
    NOMONITORING_USAGE("NOMONITORING USAGE", "NOMONITORING USAGE"),
    UPDATE_BLOCK_REFERENCES("UPDATE BLOCK REFERENCES", "UPDATE BLOCK REFERENCES"),

    SHRINK_SPACE("SHRINK SPACE", "SHRINK SPACE"),
    COMPACT("COMPACT", "COMPACT"), ADD("ADD", "ADD"),

    MODIFY("MODIFY", "MODIFY"),
    MODIFY_DEFAULT_ATTRIBUTES("MODIFY DEFAULT ATTRIBUTES", "MODIFY DEFAULT ATTRIBUTES"),

    FOR_PARTITION("FOR PARTITION", "FOR PARTITION"),
    SPLIT("SPLIT", "SPLIT"),

    AT("AT", "AT"),
    COMPUTE_STATISTICS("compute statistics", "COMPUTE STATISTICS"),

    ON_COMMIT_PRESERVE_ROWS("on commit preserve rows", "ON COMMIT PRESERVE ROWS"),
    ON_COMMIT_DELETE_ROWS("on commit delete rows", "ON COMMIT DELETE ROWS"),

    ON_COMMIT_DROP_DEFINITION("on commit drop definition", "ON COMMIT DROP DEFINITION"),
    ON_COMMIT_PRESERVE_DEFINITION("on commit preserve definition", "ON COMMIT PRESERVE DEFINITION"),

    INTERLEAVED("interleaved", "INTERLEAVED"),

    MEMOPTIMIZE_FOR_READ("memoptimize for read", "MEMOPTIMIZE FOR READ"),
    NO_MEMOPTIMIZE_FOR_READ("NO MEMOPTIMIZE FOR READ", "NO MEMOPTIMIZE FOR READ"),
    INVALIDATE("invalidate", "INVALIDATE"),

    LOCATOR("locator", "LOCATOR"),

    AUTOMATIC("AUTOMATIC", "AUTOMATIC"),
    MANUAL("MANUAL", "MANUAL"),

    CASCADED("cascaded", "CASCADED"),

    CONTAINER_MAP("container_map", "CONTAINER_MAP"),
    CONTAINERS_DEFAULT("containers_default", "CONTAINERS_DEFAULT"),

    BEQUEATH_CURRENT_USER("bequeath current_user", "BEQUEATH CURRENT_USER"),
    BEQUEATH_DEFINER("bequeath definer", "BEQUEATH DEFINER"),

    NOT_VALID("not valid", "NOT VALID"),

    KEEP_INDEX("keep index", "KEEP INDEX"),
    DROP_INDEX("drop index", "DROP INDEX"),

    INDEXING_ON("indexing on", "INDEXING ON"),
    INDEXING_OFF("indexing off", "INDEXING OFF"),

    ALLOW_CLUSTERING("allow_clustering", "ALLOW CLUSTERING"),
    DISALLOW_CLUSTERING("disallow clustering", "DISALLOW CLUSTERING"),

    ALLOW_ANYSCHEMA("allow anyschema", "ALLOW ANYSCHEMA"),
    ALLOW_NONSCHEMA("allow nonschema", "ALLOW NONSCHEMA"),
    DISALLOW_NONSCHEMA("disallow nonschema", "DISALLOW NONSCHEMA"),

    ON_QUERY_COMPUTATION("on query computation", "ON QUERY COMPUTATION"),

    XMLSCHEMA("xmlschema", "XMLSCHEMA"),
    NONSCHEMA("nonschema", "NONSCHEMA"),
    ANYSCHEMA("anyschema", "ANYSCHEMA"),

    LOBS("lobs", "LOBS"),
    TABLES("tables", "TABLES"),
    STORE_ALL_VARRAYS_AS("store all varrays as", "STORE ALL VARRAYS AS"),
    REBUILD("rebuild", "REBUILD"),

    WITH_OBJECT_ID("with object id", "WITH OBJECT ID"),
    WITH_OBJECT_IDENTIFIER("with object identifier", "WITH OBJECT IDENTIFIER"),

    FOR_ROW("for row", "FOR ROW"),
    FOR_EACH_ROW("for each row", "FOR EACH ROW"),
    FOR_STATEMENT("for statement", "FOR STATEMENT"),
    FOR_EACH_STATEMENT("for each statement", "FOR EACH STATEMENT"),

    CROSSEDITION("crossedition", "CROSSEDITION"),
    FORWARD_CROSSEDITION("forward crossedition", "FORWARD CROSSEDITION"),
    REVERSE_CROSSEDITION("reverse crossedition", "REVERSE CROSSEDITION"),

    ROWDEPENDENCIES("rowdependencies", "ROWDEPENDENCIES"),
    NOROWDEPENDENCIES("norowdependencies", "NOROWDEPENDENCIES"),

    BINARY("binary", "BINARY"),
    VARBINARY("varbinary", "VARBINARY"),

    NATIONAL_VARCHAR("national varchar", "NATIONAL VARCHAR"),

    VARIABLE_NAME("variable name", "VARIABLE NAME"),

    SQLData("SQLData", "SQLData"),
    CustomDatum("CustomDatum", "CustomDatum"),
    OraData("OraData", "OraData"),

    B("b", "B"),
    ZERO_B("0b", "0b"),

    SQL_CACHE("sql_cache", "SQL_CACHE"),
    SQL_NO_CACHE("sql_no_cache", "SQL_NO_CACHE"),

    WITH_ROLLUP("with rollup", "WITH ROLLUP"),

    LOCK_IN_SHARE_MODE("lock in share mode", "LOCK IN SHARE MODE"),

    IN_NATURAL_LANGUAGE_MODE("in natural language mode", "IN NATURAL LANGUAGE MODE"),
    IN_NATURAL_LANGUAGE_MODE_WITH_QUERY_EXPANSION("in natural language mode with query expansion", "IN NATURAL LANGUAGE MODE WITH QUERY EXPANSION"),
    IN_BOOLEAN_MODE("in boolean mode", "IN BOOLEAN MODE"),
    WITH_QUERY_EXPANSION("with query expansion", "WITH QUERY EXPANSION"),

    POSITION("position", "POSITION"),
    WEIGHT_STRING("weight_string", "WEIGHT_STRING"),

    DIV("div", "DIV"),
    XOR("xor", "XOR"),

    PERSIST("persist", "PERSIST"),
    PERSIST_ONLY("persist_only", "PERSIST_ONLY"),

    AT_SIGN_AT_SIGN_GLOBAL("@@global", "@@global"),
    AT_SIGN_AT_SIGN_SESSION("@@session", "@@session"),
    AT_SIGN_AT_SIGN_PERSIST("@@persist", "@@persist"),
    AT_SIGN_AT_SIGN_PERSIST_ONLY("@@persist_only", "@@persist_only"),

    USING_BTREE("using btree", "USING BTREE"),
    USING_HASH("using hash", "USING HASH"),

    CHANGE("change", "CHANGE"),

    AVG_ROW_LENGTH("avg_row_length", "AVG_ROW_LENGTH"),
    CHECKSUM("checksum", "CHECKSUM"),
    CONNECTION("connection", "CONNECTION"),
    DATA_DIRECTORY("data directory", "DATA DIRECTORY"),
    INDEX_DIRECTORY("index directory", "INDEX DIRECTORY"),
    DELAY_KEY_WRITE("DELAY_KEY_WRITE", "DELAY_KEY_WRITE"),
    INSERT_METHOD("insert_method", "INSERT_METHOD"),

    STORAGE_DISK("storage disk", "STORAGE DISK"),
    STORAGE_MEMORY("storage memory", "STORAGE MEMORY"),
    STORAGE_DEFAULT("storage default", "STORAGE DEFAULT"),

    REPAIR("repair", "REPAIR"),
    EXCHANGE("exchange", "EXCHANGE"),
    INDEXES("indexes", "INDEXES"),
    VALIDATION("validation", "VALIDATION"),

    KEY_BLOCK_SIZE("key_block_size", "KEY_BLOCK_SIZE"),
    WITH_PARSER("WITH PARSER", "WITH PARSER"),
    ALGORITHM("algorithm", "ALGORITHM"),

    HOST("host", "HOST"),
    SOCKET("socket", "SOCKET"),
    OWNER("owner", "OWNER"),
    PORT("port", "PORT"),

    FOREIGN_DATA_WRAPPER("foreign data wrapper", "FOREIGN DATA WRAPPER"),
    OPTIONS("options", "OPTIONS"),
    SHARED("shared", "SHARED"),
    INPLACE("inplace", "INPLACE"),
    COPY("copy", "COPY"),

    SET_NULL("set null", "SET NULL"),
    SET_DEFAULT("set default", "SET DEFAULT"),
    NO_ACTION("no action", "NO ACTION"),

    FULL("full", "FULL"),
    PARTIAL("partial", "PARTIAL"),
    SIMPLE("simple", "SIMPLE"),

    DYNAMIC("dynamic", "DYNAMIC"),
    COLUMN_FORMAT("column_format", "COLUMN_FORMAT"),
    USAGE_QUEUE("usage queue", "USAGE QUEUE"),
    OPAQUE_TYPE("opaque type", "OPAQUE TYPE"),
    ROW_ARCHIVAL("row archival", "ROW ARCHIVAL"),
    CLUSTERING("clustering", "CLUSTERING"),

    ON_LOAD("on load", "ON LOAD"),
    ON_DATA_MOVEMENT("on data movement", "ON DATA MOVEMENT"),

    WITH_MATERIALIZED_ZONEMAP("with materialized zonemap", "WITH MATERIALIZED ZONEMAP"),
    WITHOUT_MATERIALIZED_ZONEMAP("without materialized zonemap", "WITHOUT MATERIALIZED ZONEMAP"),

    DUAL("dual", "DUAL"),
    DEFINER("definer", "DEFINER"),

    SQL_SECURITY_DEFINER("sql security definer", "SQL SECURITY DEFINER"),
    SQL_SECURITY_INVOKER("sql security invoker", "SQL SECURITY INVOKER"),

    HANDLER("handler", "HANDLER"),
    READ("read", "READ"),
    READ_LOCAL("read local", "READ LOCAL"),

    UNLOCK("unlock", "UNLOCK"),
    BROADCAST("broadcast", "BROADCAST"),

    KEEP_DATAFILES("keep datafiles", "KEEP DATAFILES"),
    INCLUDING_DATAFILES("including datafiles", "INCLUDING DATAFILES"),

    LOGFILE("logfile", "LOGFILE"),

    LIMIT_VALUE("limit value", "LIMIT VALUE"),
    IDENTIFIER("identifier", "IDENTIFIER"),
    OIDINDEX("oidindex", "OIDINDEX"),

    RELATIONAL("relational", "RELATIONAL"),

    BINARY_XMl("binary xml", "BINARY XMl"), VARRAYS("varrays", "VARRAYS"),

    UNUSED("unused", "UNUSED"),
    CHECKPOINT("checkpoint", "CHECKPOINT"),
    MOVE("move", "MOVE"),
    MERGE("merge", "MERGE"),
    TRIGGERS("triggers", "TRIGGERS"),

    REMOVE("remove", "REMOVE"),
    PARTITIONING("partitioning", "PARTITIONING"),
    UPGRADE("upgrade", "UPGRADE"),
    REORGANIZE("reorganize", "REORGANIZE"),

    OPAQUE("opaque", "OPAQUE"),
    STORE("store", "STORE"),
    UNPACKED("unpacked", "UNPACKED"),
    MAPPING("mapping", "MAPPING"),
    TEMPLATE("template", "TEMPLATE"),

    INCLUDING_DATA("including data", "INCLUDING DATA"),
    NOT_INCLUDING_DATA("not including data", "NOT INCLUDING DATA"),

    UNUSABLE_LOCAL_INDEXES("unusable local indexes", "UNUSABLE LOCAL INDEXES"),

    DROP_STORAGE("drop storage", "DROP STORAGE"),
    DROP_ALL_STORAGE("drop all storage", "DROP ALL STORAGE"),
    REUSE_STORAGE("reuse storage", "REUSE STORAGE"),

    CONNECT_BY_ISCYCLE("connect_by_iscycle", "CONNECT_BY_ISCYCLE"),
    CONNECT_BY_ISLEAF("connect_by_isleaf", "CONNECT_BY_ISLEAF"),
    LEVEL("level", "LEVEL"),
    OBJECT_ID("object_id", "OBJECT_ID"),
    OBJECT_VALUE("object_value", "OBJECT_VALUE"),
    ORA_ROWSCN("ora_rowscn", "ORA_ROWSCN"),
    VERSIONS_ENDSCN("versions_endscn", "VERSIONS_ENDSCN"),
    VERSIONS_ENDTIME("versions_endtime", "VERSIONS_ENDTIME"),
    VERSIONS_OPERATION("versions_operation", "VERSIONS_OPERATION"),
    VERSIONS_STARTSCN("versions_startscn", "VERSIONS_STARTSCN"),
    VERSIONS_STARTTIME("versions_starttime", "VERSIONS_STARTTIME"),
    VERSIONS_XID("versions_xid", "VERSIONS_XID"),
    XMLDATA("xmldata", "XMLDATA"),

    CLEANUP("cleanup", "CLEANUP"),
    ATTRIBUTE("attribute", "ATTRIBUTE"),

    INCLUDING_TABLE_DATA("including table data", "INCLUDING TABLE DATA"),
    NOT_INCLUDING_TABLE_DATA("not including table data", "NOT INCLUDING TABLE DATA"),
    CONVERT_TO_SUBSTITUTABLE("convert to substitutable", "CONVERT TO SUBSTITUTABLE"),

    RESET("reset", "RESET"),

    PRESERVE_MATERIALIZED_VIEW_LOG("preserve materialized view log", "PRESERVE MATERIALIZED VIEW LOG"),
    PURGE_MATERIALIZED_VIEW_LOG("purge materialized view log", "PURGE MATERIALIZED VIEW LOG"),

    CONNECT_TO("connect to", "CONNECT TO"),
    AUTHENTICATED_BY("authenticated by", "AUTHENTICATED BY");


    public final long lowerHashCode64;
    public final String lower;
    public final String upper;

    SQLReserved(String lower, String upper) {
        this.lowerHashCode64 = FNVHash.fnv1a_64_lower(lower);
        this.lower = lower;
        this.upper = upper;
    }

    public static SQLReserved of(long lowerHashCode64) {
        SQLReserved[] reserveds = SQLReserved.values();
        for (SQLReserved reserved : reserveds) {
            if (reserved.lowerHashCode64 != lowerHashCode64) {
                continue;
            }
            return reserved;
        }
        return null;
    }

    public static SQLReserved of(String text) {
        long lowerHashCode64 = FNVHash.fnv1a_64_lower(text);
        return of(lowerHashCode64);
    }

    public SQLReservedIdentifier ofExpr() {
        return new SQLReservedIdentifier(this);
    }

    @Override
    public String toString() {
        return upper;
    }

}
