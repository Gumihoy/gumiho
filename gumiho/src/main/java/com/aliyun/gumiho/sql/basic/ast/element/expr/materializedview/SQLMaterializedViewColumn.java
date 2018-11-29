package com.aliyun.gumiho.sql.basic.ast.element.expr.materializedview;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLEncryptClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * column_alias [ENCRYPT [encryption_spec]
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-MATERIALIZED-VIEW.html#GUID-EE262CA4-01E5-4618-B659-6165D993CA1B
 *
 * @author kongtong.ouyang on 2018/6/25.
 */
public class SQLMaterializedViewColumn extends AbstractSQLExpr {

    protected SQLExpr column;
    protected SQLEncryptClause encryptClause;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, column);
            this.acceptChild(visitor, encryptClause);
        }
    }

    @Override
    public SQLMaterializedViewColumn clone() {
        SQLMaterializedViewColumn x = new SQLMaterializedViewColumn();

        SQLExpr columnClone = this.column.clone();
        x.setColumn(columnClone);

        if (this.encryptClause != null) {
            SQLEncryptClause encryptClauseClone = this.encryptClause.clone();
            x.setEncryptClause(encryptClauseClone);
        }
        return x;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == column) {
            setColumn(target);
            return true;
        }
        return false;
    }

    public SQLExpr getColumn() {
        return column;
    }

    public void setColumn(SQLExpr column) {
        setChildParent(column);
        this.column = column;
    }

    public SQLEncryptClause getEncryptClause() {
        return encryptClause;
    }

    public void setEncryptClause(SQLEncryptClause encryptClause) {
        setChildParent(encryptClause);
        this.encryptClause = encryptClause;
    }
}
