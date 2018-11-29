package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.ISQLSelectQuery;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * ACCESS PARAMETERS { (opaque_format_spec) | USING CLOB subquery }
 *
 * external_table_data_props
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 * @author kongtong.ouyang on 2018/6/28.
 */
public class OracleSQLAccessParametersClause extends AbstractOracleSQLExpr {

    protected SQLExpr item;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, item);
        }
    }

    @Override
    public OracleSQLAccessParametersClause clone() {
        OracleSQLAccessParametersClause x = new OracleSQLAccessParametersClause();
        SQLExpr itemClone = this.item.clone();
        x.setItem(itemClone);
        return x;
    }

    public SQLExpr getItem() {
        return item;
    }

    public void setItem(SQLExpr item) {
        setChildParent(item);
        this.item = item;
    }

    /**
     * USING CLOB subquery
     */
    public static class UsingClobClause extends AbstractOracleSQLExpr {

        protected ISQLSelectQuery subQuery;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, subQuery);
            }
        }

        @Override
        public UsingClobClause clone() {
            UsingClobClause x = new UsingClobClause();
            return x;
        }

        public ISQLSelectQuery getSubQuery() {
            return subQuery;
        }

        public void setSubQuery(ISQLSelectQuery subQuery) {
            setChildParent(subQuery);
            this.subQuery = subQuery;
        }
    }
}
