package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLColumnProperty;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLLocalType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * COLUMN column substitutable_column_clause
 * <p>
 * <p>
 * object_type_col_properties
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-MATERIALIZED-VIEW.html#GUID-EE262CA4-01E5-4618-B659-6165D993CA1B
 *
 * @author kongtong.ouyang on 2018/6/22.
 */
public class OracleSQLObjectTypeColProperty extends AbstractOracleSQLExpr implements SQLColumnProperty {

    protected SQLExpr column;
    protected IOracleSQLSubstitutableColumnClause substitutableColumnClause;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, column);
            this.acceptChild(visitor, substitutableColumnClause);
        }
    }

    @Override
    public OracleSQLObjectTypeColProperty clone() {
        OracleSQLObjectTypeColProperty x = new OracleSQLObjectTypeColProperty();

        return x;
    }


    public SQLExpr getColumn() {
        return column;
    }

    public void setColumn(SQLExpr column) {
        setChildParent(column);
        this.column = column;
    }

    public IOracleSQLSubstitutableColumnClause getSubstitutableColumnClause() {
        return substitutableColumnClause;
    }

    public void setSubstitutableColumnClause(IOracleSQLSubstitutableColumnClause substitutableColumnClause) {
        setChildParent(substitutableColumnClause);
        this.substitutableColumnClause = substitutableColumnClause;
    }
}
