package com.aliyun.gumiho.sql.basic.ast.element.expr.rollback;

/**
 * @author kongtong.ouyang on 2018/6/29.
 */

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.commit.SQLCommitOption;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * TO [ SAVEPOINT ] savepoint
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ROLLBACK.html#GUID-94551F0C-A47F-43DE-BC68-9B1C1ED38C93
 *
 * @author kongtong.ouyang on 2018/6/29.
 */
public class SQLRollbackToSavepointOption extends AbstractSQLExpr implements SQLRollbackOption {

    protected boolean savepoint;
    protected SQLExpr name;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if(visitor.visit(this)) {
            this.acceptChild(visitor, name);
        }
    }

    @Override
    public SQLRollbackToSavepointOption clone() {
        SQLRollbackToSavepointOption x = new SQLRollbackToSavepointOption();

        x.savepoint = this.savepoint;

        if (this.name != null) {
            SQLExpr nameClone = this.name.clone();
            x.setName(nameClone);
        }

        return x;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name) {
            setName(target);
            return true;
        }

        return false;
    }

    public boolean isSavepoint() {
        return savepoint;
    }

    public void setSavepoint(boolean savepoint) {
        this.savepoint = savepoint;
    }

    public SQLExpr getName() {
        return name;
    }

    public void setName(SQLExpr name) {
        setChildParent(name);
        this.name = name;
    }
}
