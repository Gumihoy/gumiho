package com.aliyun.gumiho.sql.basic.ast.element.datatype.collection;

import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.AbstractSQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.List;

/**
 * <data type> ARRAY [ <left bracket or trigraph> <unsigned integer> <right bracket or trigraph> ]
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#array%20type
 * <p>
 * Varrays : https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/Data-Types.html#GUID-EAA3885B-06AA-4F0D-85E7-C43352E5E2AC
 *
 * @author kongtong.ouyang on 2018/4/20.
 */
public class SQLArrayDataType extends AbstractSQLDataType implements SQLDataType {

    protected SQLDataType dataType;

    @Override
    protected void accept0(SQLASTVisitor visitor) {

    }


    @Override
    public SQLArrayDataType clone() {
        SQLArrayDataType x = new SQLArrayDataType();
        return x;
    }

    @Override
    public void cloneTo(SQLObject x) {
        super.cloneTo(x);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public long hash() {
        return 0;
    }

    @Override
    public long lowerHash() {
        return 0;
    }

    @Override
    public boolean isParen() {
        return false;
    }

    @Override
    public void setParen(boolean paren) {

    }

    @Override
    public List<SQLExpr> getArguments() {
        return null;
    }

    @Override
    public void addArgument(SQLExpr argument) {

    }


}
