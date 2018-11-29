package com.aliyun.gumiho.sql.basic.ast.element.expr.table.partitionset;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.values.ISQLPartitionValues;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * range_partitionset_desc/list_partitionset_desc
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/CREATE-TABLE.html
 *
 * @author kongtong.ouyang onCondition 2018/4/9.
 */
public class SQLPartitionsetDefinition extends AbstractSQLExpr {

    protected SQLName name;

    protected ISQLPartitionValues values;

    protected final List<SQLExpr> options = new ArrayList<>();


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, values);
            this.acceptChild(visitor, options);
        }
    }

    @Override
    public SQLPartitionsetDefinition clone() {
        SQLPartitionsetDefinition x = new SQLPartitionsetDefinition();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLPartitionsetDefinition x) {
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
        return false;
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        this.name = name;
    }

    public ISQLPartitionValues getValues() {
        return values;
    }

    public void setValues(ISQLPartitionValues values) {
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
}
