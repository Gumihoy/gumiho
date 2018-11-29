package com.aliyun.gumiho.sql.basic.ast.element.expr;

/**
 * segment_attributes_clause
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/6/21.
 */
public interface ISQLSegmentAttributesClause extends SQLExpr, ISQLPhysicalProperty {
    @Override
    ISQLSegmentAttributesClause clone();
}
