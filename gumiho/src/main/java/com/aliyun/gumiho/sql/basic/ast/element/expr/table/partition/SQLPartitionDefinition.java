package com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLStoreInClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.sub.SQLSubPartitionDefinition;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.values.ISQLPartitionValues;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * partition_definition: https://dev.mysql.com/doc/refman/5.7/en/create-table.html
 * <p>
 * <p>
 * <p>
 * <p>
 * PARTITION [partition]
 * range_values_clause
 * table_partition_description
 * [ ( { range_subpartition_desc [, range_subpartition_desc] ...
 * | list_subpartition_desc [, list_subpartition_desc] ...
 * | individual_hash_subparts [, individual_hash_subparts] ...
 * }
 * ) | hash_subparts_by_quantity ]
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/CREATE-TABLE.html
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang onCondition 2018/4/9.
 */
public class SQLPartitionDefinition extends AbstractSQLExpr {

    protected SQLName name;

    protected ISQLPartitionValues values;

    protected final List<SQLExpr> options = new ArrayList<>();

    protected SQLExpr subpartitionsNum;

    protected SQLStoreInClause storeInClause;

    protected final List<SQLSubPartitionDefinition> subPartitions = new ArrayList<>();

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, values);
            this.acceptChild(visitor, options);

            this.acceptChild(visitor, subpartitionsNum);
            this.acceptChild(visitor, storeInClause);

            this.acceptChild(visitor, subPartitions);
        }
    }

    @Override
    public SQLPartitionDefinition clone() {
        SQLPartitionDefinition x = new SQLPartitionDefinition();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLPartitionDefinition x) {
        super.cloneTo(x);

        if (this.name != null) {
            SQLName nameClone = this.name.clone();
            x.setName(nameClone);
        }

        if (this.values != null) {
            ISQLPartitionValues valuesClone = this.values.clone();
            x.setValues(valuesClone);
        }

        for (SQLExpr option : options) {
            SQLExpr optionClone = option.clone();
            x.addOption(optionClone);
        }
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name
                && target instanceof SQLName) {
            setName((SQLName) target);
            return true;
        }

        if (source == values
                && target instanceof ISQLPartitionValues) {
            setValues((ISQLPartitionValues) target);
            return true;
        }

        boolean replace = replaceInList(options, source, target, this);
        if (replace) {
            return true;
        }

        if (source == subpartitionsNum) {
            setSubpartitionsNum(target);
            return true;
        }


        return false;
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }

    public ISQLPartitionValues getValues() {
        return values;
    }

    public void setValues(ISQLPartitionValues values) {
        setChildParent(values);
        this.values = values;
    }

    public List<SQLExpr> getOptions() {
        return options;
    }

    public void addOption(SQLExpr option) {
        if (option == null) {
            return;
        }
        setChildParent(option);
        this.options.add(option);
    }

    public SQLExpr getSubpartitionsNum() {
        return subpartitionsNum;
    }

    public void setSubpartitionsNum(SQLExpr subpartitionsNum) {
        setChildParent(subpartitionsNum);
        this.subpartitionsNum = subpartitionsNum;
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
