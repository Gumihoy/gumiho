package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.ISQLSegmentAttributesClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * ORGANIZATION INDEX
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-MATERIALIZED-VIEW.html#GUID-EE262CA4-01E5-4618-B659-6165D993CA1B
 *
 * @author kongtong.ouyang on 2018/6/22.
 */
public class OracleSQLPhysicalPropertyOrganizationIndexClause  extends AbstractOracleSQLExpr implements IOracleSQLPhysicalPropertyOrganizationClause {

    protected final List<SQLExpr> items = new ArrayList<>();


    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, items);
        }
    }

    @Override
    public OracleSQLPhysicalPropertyOrganizationIndexClause clone() {
        OracleSQLPhysicalPropertyOrganizationIndexClause x = new OracleSQLPhysicalPropertyOrganizationIndexClause();
        return x;
    }


    public List<SQLExpr> getItems() {
        return items;
    }

    public void addItem (SQLExpr item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.items.add(item);
    }

}
