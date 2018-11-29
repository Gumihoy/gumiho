package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.ISQLSegmentAttributesClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * [ INCLUDING column_name ] OVERFLOW [ segment_attributes_clause ]
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/6/25.
 */
public class OracleSQLIndexOrgOverflowClause extends AbstractOracleSQLExpr {

    protected SQLExpr column;

    protected final List<ISQLSegmentAttributesClause> segmentAttributes = new ArrayList<>();

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, column);
            this.acceptChild(visitor, segmentAttributes);
        }
    }

    @Override
    public OracleSQLIndexOrgOverflowClause clone() {
        OracleSQLIndexOrgOverflowClause x = new OracleSQLIndexOrgOverflowClause();

        if (this.column != null) {
            SQLExpr columnClone = this.column.clone();
            x.setColumn(columnClone);
        }

        for (ISQLSegmentAttributesClause segmentAttribute : segmentAttributes) {
            ISQLSegmentAttributesClause segmentAttributeClone = segmentAttribute.clone();
            x.addSegmentAttribute(segmentAttributeClone);
        }
        return x;
    }

    public SQLExpr getColumn() {
        return column;
    }

    public void setColumn(SQLExpr column) {
        setChildParent(column);
        this.column = column;
    }

    public List<ISQLSegmentAttributesClause> getSegmentAttributes() {
        return segmentAttributes;
    }

    public void addSegmentAttribute(ISQLSegmentAttributesClause segmentAttribute) {
        if (segmentAttribute == null) {
            return;
        }
        setChildParent(segmentAttribute);
        this.segmentAttributes.add(segmentAttribute);
    }
}
