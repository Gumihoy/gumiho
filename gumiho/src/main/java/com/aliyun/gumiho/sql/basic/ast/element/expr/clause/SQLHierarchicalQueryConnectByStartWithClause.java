package com.aliyun.gumiho.sql.basic.ast.element.expr.clause;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * CONNECT BY [ NOCYCLE ] condition [ START WITH condition ]
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SELECT.html#GUID-CFA006CA-6FF1-4972-821E-6996142A51C6
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Hierarchical-Queries.html#GUID-0118DF1D-B9A9-41EB-8556-C6E7D6A5A84E
 *
 * @author kongtong.ouyang on 2018/5/7.
 */
public class SQLHierarchicalQueryConnectByStartWithClause extends AbstractSQLHierarchicalQueryClause implements SQLHierarchicalQueryClause {


    @Override
    public void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, connectByCondition);
            this.acceptChild(visitor, startWithCondition);
        }
    }

    @Override
    public SQLHierarchicalQueryConnectByStartWithClause clone() {
        SQLHierarchicalQueryConnectByStartWithClause x = new SQLHierarchicalQueryConnectByStartWithClause();
        this.cloneTo(x);
        return x;
    }
}
