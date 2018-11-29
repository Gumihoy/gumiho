package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.partition;

import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * EXCHANGE PARTITION partition_name WITH TABLE tbl_name [{WITH|WITHOUT} VALIDATION]
 * https://dev.mysql.com/doc/refman/5.6/en/alter-table.html
 * <p>
 * EXCHANGE PARTITION partition_name WITH TABLE [ schema. ] table [ { INCLUDING | EXCLUDING } INDEXES ] [ { WITH | WITHOUT } VALIDATION ] [ exceptions_clause ] [ update_index_clauses [ parallel_clause ] ] [ CASCADE ]
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/7/12.
 */
public class SQLAlterTableExchangePartitionAction extends AbstractSQLAlterTableExchangePartitionAction implements ISQLAlterTablePartitionAction {

    protected SQLName name;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, table);
            this.acceptChild(visitor, exceptionsClause);
            this.acceptChild(visitor, updateIndexClause);
            this.acceptChild(visitor, parallelClause);
        }
    }

    @Override
    public SQLAlterTableExchangePartitionAction clone() {
        SQLAlterTableExchangePartitionAction x = new SQLAlterTableExchangePartitionAction();
        super.cloneTo(x);
        return x;
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }
}
