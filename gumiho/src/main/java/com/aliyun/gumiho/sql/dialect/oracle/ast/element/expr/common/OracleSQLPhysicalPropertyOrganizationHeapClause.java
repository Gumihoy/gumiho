package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.ISQLSegmentAttributesClause;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * [ deferred_segment_creation ] segment_attributes_clause [ table_compression ] [ inmemory_table_clause ] [ ilm_clause ]
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-MATERIALIZED-VIEW.html#GUID-EE262CA4-01E5-4618-B659-6165D993CA1B
 *
 * @author kongtong.ouyang on 2018/6/22.
 */
public class OracleSQLPhysicalPropertyOrganizationHeapClause  extends AbstractOracleSQLExpr implements IOracleSQLPhysicalPropertyOrganizationClause {

    protected final List<ISQLSegmentAttributesClause> segmentAttributesClauses = new ArrayList<>();
    protected OracleSQLHeapOrgTableClause heapOrgTableClause;


    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, segmentAttributesClauses);
            this.acceptChild(visitor, heapOrgTableClause);
        }
    }

    @Override
    public OracleSQLPhysicalPropertyOrganizationHeapClause clone() {
        OracleSQLPhysicalPropertyOrganizationHeapClause x = new OracleSQLPhysicalPropertyOrganizationHeapClause();
        this.cloneTo(x);

        return x;
    }



    public List<ISQLSegmentAttributesClause> getSegmentAttributesClauses() {
        return segmentAttributesClauses;
    }

    public void addSegmentAttributesClause(ISQLSegmentAttributesClause segmentAttributesClause) {
        if (segmentAttributesClause == null) {
            return;
        }
        setChildParent(segmentAttributesClause);
        this.segmentAttributesClauses.add(segmentAttributesClause);
    }

    public OracleSQLHeapOrgTableClause getHeapOrgTableClause() {
        return heapOrgTableClause;
    }

    public void setHeapOrgTableClause(OracleSQLHeapOrgTableClause heapOrgTableClause) {
        setChildParent(heapOrgTableClause);
        this.heapOrgTableClause = heapOrgTableClause;
    }
}
