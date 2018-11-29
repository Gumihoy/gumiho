package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.select;

import com.aliyun.gumiho.sql.basic.ast.element.expr.select.SQLSelectQuery;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.OracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SELECT.html#GUID-CFA006CA-6FF1-4972-821E-6996142A51C6
 *
 * @author kongtong.ouyang on 2018/5/7.
 */
public class OracleSQLSelectQuery extends SQLSelectQuery implements OracleSQLExpr {

    protected OracleSQLModelClause modelClause;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor instanceof OracleSQLASTVisitor) {
            accept0((OracleSQLASTVisitor) visitor);
        } else {
            visitor.visit(this);
        }
    }

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, withClause);
            this.acceptChild(visitor, selectItems);
            this.acceptChild(visitor, fromClause);
            this.acceptChild(visitor, whereClause);
            this.acceptChild(visitor, hierarchicalQueryClause);
            this.acceptChild(visitor, groupByClause);
            this.acceptChild(visitor, modelClause);

            this.acceptChild(visitor, orderByClause);
            this.acceptChild(visitor, limitClause);

            this.acceptChild(visitor, lockClause);
        }
    }

    @Override
    public OracleSQLSelectQuery clone() {
        OracleSQLSelectQuery x = new OracleSQLSelectQuery();

        this.cloneTo(x);
        return x;
    }


    public void cloneTo(OracleSQLSelectQuery x) {
        super.cloneTo(x);

        if (this.modelClause != null) {
            OracleSQLModelClause modelClauseClone = this.modelClause.clone();
            x.setModelClause(modelClauseClone);
        }


    }

    public OracleSQLModelClause getModelClause() {
        return modelClause;
    }

    public void setModelClause(OracleSQLModelClause modelClause) {
        setChildParent(modelClause);
        this.modelClause = modelClause;
    }

    public static void main(String[] args) {
        OracleSQLSelectQuery query = new OracleSQLSelectQuery();
        query.getDbType();
    }
}
