package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * EXCHANGE SUBPARTITION partition_name WITH TABLE [ schema. ] table [ { INCLUDING | EXCLUDING } INDEXES ] [ { WITH | WITHOUT } VALIDATION ] [ exceptions_clause ] [ update_index_clauses [ parallel_clause ] ] [ CASCADE ]
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/7/12.
 */
public class SQLAlterTableExchangePartitionForAction extends AbstractSQLAlterTableExchangePartitionAction implements ISQLAlterTablePartitionAction {

    protected final List<SQLExpr> names = new ArrayList<>();

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, names);
            this.acceptChild(visitor, table);
            this.acceptChild(visitor, exceptionsClause);
            this.acceptChild(visitor, updateIndexClause);
            this.acceptChild(visitor, parallelClause);
        }
    }

    @Override
    public SQLAlterTableExchangePartitionForAction clone() {
        SQLAlterTableExchangePartitionForAction x = new SQLAlterTableExchangePartitionForAction();
        super.cloneTo(x);
        return x;
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
