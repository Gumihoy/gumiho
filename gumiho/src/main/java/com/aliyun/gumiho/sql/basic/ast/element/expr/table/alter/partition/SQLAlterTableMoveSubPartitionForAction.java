package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.ISQLAlterTableAction;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * MOVE SUBPARTITION FOR LEFT_PAREN nameIdentifier (COMMA nameIdentifier)* RIGHT_PAREN
 indexingClause? partitioningStorageClause? updateIndexClause? filterCondition? parallelClause? allowDisallowClustering? ONLINE?
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/6/4.
 */
public class SQLAlterTableMoveSubPartitionForAction extends AbstractSQLMoveSubPartitionAction implements ISQLAlterTableAction {

    protected final List<SQLExpr> names = new ArrayList<>();

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, names);
        }
    }

    @Override
    public SQLAlterTableMoveSubPartitionForAction clone() {
        SQLAlterTableMoveSubPartitionForAction x = new SQLAlterTableMoveSubPartitionForAction();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLAlterTableMoveSubPartitionForAction x) {
        super.cloneTo(x);
        for (SQLExpr name : this.names) {
            SQLExpr nameClone = name.clone();
            x.addName(nameClone);
        }
    }

    public List<SQLExpr> getNames() {
        return names;
    }

    public void addName(SQLExpr name) {
        if (name == null) {
            return;
        }
        setChildParent(name);
        this.names.add(name);
    }

}
