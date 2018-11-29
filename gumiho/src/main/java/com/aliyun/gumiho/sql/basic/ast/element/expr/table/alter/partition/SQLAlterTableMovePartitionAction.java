package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * MOVE PARTITION nameIdentifier
 * [ MAPPING TABLE ]
 * [ table_partition_description ]
 * [ filter_condition]
 * [ update_index_clauses ]
 * [ parallel_clause ]
 * [ allow_disallow_clustering ]
 * [ ONLINE ]

 * <p>
 * move_table_partition
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/6/4.
 */
public class SQLAlterTableMovePartitionAction extends AbstractSQLMovePartitionAction implements ISQLAlterTablePartitionAction {

    protected SQLExpr name;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
        }
    }

    @Override
    public SQLAlterTableMovePartitionAction clone() {
        SQLAlterTableMovePartitionAction x = new SQLAlterTableMovePartitionAction();
        this.cloneTo(x);
//        for (SQLExpr item : this.items) {
//            SQLExpr itemClone = item.clone();
//            x.addItem(itemClone);
//        }
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


    public SQLExpr getName() {
        return name;
    }

    public void setName(SQLExpr name) {
        this.name = name;
    }

}
