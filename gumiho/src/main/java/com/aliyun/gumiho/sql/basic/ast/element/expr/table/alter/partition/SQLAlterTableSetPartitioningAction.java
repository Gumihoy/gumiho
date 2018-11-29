package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.ISQLAlterTableAction;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * SET PARTITIONING { AUTOMATIC | MANUAL }
 * <p>
 * alter_automatic_partitioning
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/6/4.
 */
public class SQLAlterTableSetPartitioningAction extends AbstractSQLExpr implements ISQLAlterTableAction {

    protected SQLType setPartition;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLAlterTableSetPartitioningAction clone() {
        SQLAlterTableSetPartitioningAction x = new SQLAlterTableSetPartitioningAction();
        this.cloneTo(x);
        x.setPartition = this.setPartition;
        return x;
    }


    public SQLType getSetPartition() {
        return setPartition;
    }

    public void setSetPartition(SQLType setPartition) {
        this.setPartition = setPartition;
    }





    public enum SQLType implements ISQLEnum {
        AUTOMATIC(SQLReserved.AUTOMATIC),
        MANUAL(SQLReserved.MANUAL);

        public final SQLReserved name;

        SQLType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public SQLReserved getName() {
            return name;
        }
    }
}
