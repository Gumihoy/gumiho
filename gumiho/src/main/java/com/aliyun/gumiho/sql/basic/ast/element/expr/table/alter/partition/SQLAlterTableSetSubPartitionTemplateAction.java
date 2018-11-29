package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLStoreInClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.sub.SQLSubPartitionDefinition;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * SET SUBPARTITION TEMPLATE { ( range_subpartition_desc [, range_subpartition_desc]... ) | ( list_subpartition_desc [, list_subpartition_desc]... ) | ( individual_hash_subparts [, individual_hash_subparts]... ) | () | hash_subpartition_quantity }
 *
 * set_subpartition_template
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/7/11.
 */
public class SQLAlterTableSetSubPartitionTemplateAction extends AbstractSQLExpr implements ISQLAlterTablePartitionAction {

    protected SQLExpr partitionsNum;
    protected SQLStoreInClause storeInClause;

    protected final List<SQLSubPartitionDefinition> subPartitions = new ArrayList<>();

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, partitionsNum);
            this.acceptChild(visitor, storeInClause);
            this.acceptChild(visitor, subPartitions);
        }
    }

    @Override
    public SQLAlterTableSetSubPartitionTemplateAction clone() {
        SQLAlterTableSetSubPartitionTemplateAction x = new SQLAlterTableSetSubPartitionTemplateAction();

        if (this.partitionsNum != null) {
            SQLExpr partitionsNumClone = this.partitionsNum.clone();
            x.setPartitionsNum(partitionsNumClone);
        }

        if (this.storeInClause != null) {
            SQLStoreInClause storeInClauseClone = this.storeInClause.clone();
            x.setStoreInClause(storeInClauseClone);
        }

        for (SQLSubPartitionDefinition subPartition : this.subPartitions) {
            SQLSubPartitionDefinition subPartitionClone = subPartition.clone();
            x.addSubPartition(subPartitionClone);
        }
        return x;
    }

    public SQLExpr getPartitionsNum() {
        return partitionsNum;
    }

    public void setPartitionsNum(SQLExpr partitionsNum) {
        setChildParent(partitionsNum);
        this.partitionsNum = partitionsNum;
    }

    public SQLStoreInClause getStoreInClause() {
        return storeInClause;
    }

    public void setStoreInClause(SQLStoreInClause storeInClause) {
        setChildParent(storeInClause);
        this.storeInClause = storeInClause;
    }

    public List<SQLSubPartitionDefinition> getSubPartitions() {
        return subPartitions;
    }

    public void addSubPartition(SQLSubPartitionDefinition subPartition) {
        if (subPartition == null) {
            return;
        }
        setChildParent(subPartition);
        this.subPartitions.add(subPartition);
    }
}
