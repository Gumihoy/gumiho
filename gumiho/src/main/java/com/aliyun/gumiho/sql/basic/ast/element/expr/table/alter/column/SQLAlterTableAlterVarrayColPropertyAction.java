package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.column;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * MODIFY VARRAY varray_item ( modify_LOB_parameters )
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/7/11.
 */
public class SQLAlterTableAlterVarrayColPropertyAction extends AbstractSQLExpr implements ISQLAlterTableDropColumnAction {

    protected SQLExpr name;
    protected final List<SQLExpr> parameters = new ArrayList<>();

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if(visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, parameters);
        }
    }

    @Override
    public SQLAlterTableAlterVarrayColPropertyAction clone() {
        SQLAlterTableAlterVarrayColPropertyAction x = new SQLAlterTableAlterVarrayColPropertyAction();

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
        setChildParent(name);
        this.name = name;
    }

    public List<SQLExpr> getParameters() {
        return parameters;
    }
}
