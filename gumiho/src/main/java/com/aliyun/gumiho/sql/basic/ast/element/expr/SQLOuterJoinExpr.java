package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * name(+)
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Joins.html#GUID-29A4584C-0741-4E6A-A89B-DCFAA222994A
 *
 * @author kongtong.ouyang on 2018/5/16.
 */
public class SQLOuterJoinExpr extends AbstractSQLExpr {

    protected SQLName name;

    public SQLOuterJoinExpr(SQLName name) {
        setName(name);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
        }
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        this.name = name;
    }
}
