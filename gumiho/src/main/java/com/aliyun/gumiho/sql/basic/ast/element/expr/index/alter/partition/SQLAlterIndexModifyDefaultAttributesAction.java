package com.aliyun.gumiho.sql.basic.ast.element.expr.index.alter.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * MODIFY DEFAULT ATTRIBUTES [ FOR PARTITION partition ] { physical_attributes_clause | TABLESPACE { tablespace | DEFAULT } | logging_clause }...
 * <p>
 * <p>
 * modify_index_default_attrs
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-INDEX.html#GUID-D8F648E7-8C07-4C89-BB71-862512536558
 *
 * @author kongtong.ouyang on 2018/7/10.
 */
public class SQLAlterIndexModifyDefaultAttributesAction extends AbstractSQLExpr implements ISQLAlterIndexPartitionAction {

    protected SQLExpr partition;
    protected final List<SQLExpr> items = new ArrayList<>();

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, partition);
            this.acceptChild(visitor, items);
        }
    }

    @Override
    public SQLAlterIndexModifyDefaultAttributesAction clone() {
        SQLAlterIndexModifyDefaultAttributesAction x = new SQLAlterIndexModifyDefaultAttributesAction();
        return x;
    }


    public SQLExpr getPartition() {
        return partition;
    }

    public void setPartition(SQLExpr partition) {
        setChildParent(partition);
        this.partition = partition;
    }

    public List<SQLExpr> getItems() {
        return items;
    }

    public void addItem(SQLExpr item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.items.add(item);
    }
}
