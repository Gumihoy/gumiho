package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLColumnProperty;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * VARRAY varray_item { [ substitutable_column_clause ] varray_storage_clause | substitutable_column_clause }
 *
 * varray_col_properties
 * https://docs.oracle.com/cd/B28359_01/server.111/b28286/statements_6002.htm#i2116664
 * @author kongtong.ouyang on 2018/6/28.
 */
public class OracleSQLVarrayColProperty extends AbstractOracleSQLExpr implements SQLColumnProperty {

    protected SQLExpr item;

    protected IOracleSQLSubstitutableColumnClause substitutableColumnClause;

    protected OracleSQLVarrayStorageClause varrayStorageClause;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, item);
            this.acceptChild(visitor, substitutableColumnClause);
            this.acceptChild(visitor, varrayStorageClause);
        }
    }

    @Override
    public OracleSQLVarrayColProperty clone() {
        return null;
    }

    public SQLExpr getItem() {
        return item;
    }

    public void setItem(SQLExpr item) {
        setChildParent(item);
        this.item = item;
    }

    public IOracleSQLSubstitutableColumnClause getSubstitutableColumnClause() {
        return substitutableColumnClause;
    }

    public void setSubstitutableColumnClause(IOracleSQLSubstitutableColumnClause substitutableColumnClause) {
        setChildParent(substitutableColumnClause);
        this.substitutableColumnClause = substitutableColumnClause;
    }

    public OracleSQLVarrayStorageClause getVarrayStorageClause() {
        return varrayStorageClause;
    }

    public void setVarrayStorageClause(OracleSQLVarrayStorageClause varrayStorageClause) {
        setChildParent(varrayStorageClause);
        this.varrayStorageClause = varrayStorageClause;
    }
}
