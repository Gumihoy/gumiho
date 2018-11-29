package com.aliyun.gumiho.sql.basic.ast.element.function;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.clause.SQLPartitionByClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.order.SQLOrderByClause;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLFunctionType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLSetQuantifier;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.hash.FNVHash;
import com.aliyun.gumiho.sql.util.SQLUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * function [( [[ DISTINCT | ALL ] argument [DEFAULT return_value ON CONVERSION ERROR] [, argument, ...]])]
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#method%20invocation
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#static%20method%20invocation
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#aggregate%20function
 * <p>
 * <p>
 * https://dev.mysql.com/doc/refman/5.7/en/func-op-summary-ref.html
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Functions.html
 * <p>
 * https://www.postgresql.org/docs/devel/static/functions.html
 *
 * @author kongtong.ouyang on 2018/4/24.
 */
public abstract class AbstractSQLFunction extends AbstractSQLExpr implements ISQLFunction {

    protected SQLExpr nameExpr;

    protected String name;
    protected long nameHashCode64;
    protected long lowerNameHashCode64;

    protected boolean paren = true;
    protected SQLSetQuantifier setQuantifier;
    protected final List<SQLExpr> arguments = new ArrayList<>();

    protected boolean deterministic;

    protected SQLDefaultOnConversionError defaultOnConversionError;

    protected SQLPartitionByClause partitionClause;

    protected SQLOrderByClause orderByClause;

    protected List<SQLFunctionType> functionTypes = new ArrayList<>();

    public AbstractSQLFunction(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name is null");
        }
        setName(SQLUtils.ofName(name));
    }

    public AbstractSQLFunction(SQLExpr name) {
        if (name == null) {
            throw new IllegalArgumentException("name is null");
        }
        setName(name);
    }

    @Override
    public AbstractSQLFunction clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }

    public void cloneTo(AbstractSQLFunction x) {
        super.cloneTo(x);

        x.name = this.name;
        x.nameHashCode64 = this.nameHashCode64;
        x.lowerNameHashCode64 = this.lowerNameHashCode64;

        SQLExpr nameExprClone = this.nameExpr.clone();
        x.setName(nameExprClone);

        for (SQLExpr argument : x.arguments) {
            SQLExpr argumentClone = argument.clone();
            x.addArgument(argumentClone);
        }
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        boolean replace = replaceInList(this.arguments, source, target, this);
        if (replace) {
            return true;
        }

        return false;
    }

    @Override
    public SQLExpr getNameExpr() {
        return nameExpr;
    }

    public void setName(SQLExpr nameExpr) {
        if (nameExpr != null) {
            nameExpr.setParent(this);
        }
        clear();
        this.nameExpr = nameExpr;
    }

    public void clear() {
        this.name = null;
        this.nameHashCode64 = 0;
        this.lowerNameHashCode64 = 0;
    }

    @Override
    public String getName() {
        if (name == null) {
            this.name = nameExpr.toString();
        }
        return name;
    }

    @Override
    public long hash() {
        if (this.nameHashCode64 == 0) {
            this.nameHashCode64 = FNVHash.fnv1a_64(getName());
        }
        return nameHashCode64;
    }

    @Override
    public long lowerHash() {
        if (this.lowerNameHashCode64 == 0) {
            this.lowerNameHashCode64 = FNVHash.fnv1a_64_lower(getName());
        }
        return lowerNameHashCode64;
    }

    @Override
    public boolean isParen() {
        return paren;
    }

    @Override
    public void setParen(boolean paren) {
        this.paren = paren;
    }

    public SQLSetQuantifier getSetQuantifier() {
        return setQuantifier;
    }

    public void setSetQuantifier(SQLSetQuantifier setQuantifier) {
        this.setQuantifier = setQuantifier;
    }

    @Override
    public List<SQLExpr> getArguments() {
        return arguments;
    }

    public void addArgument(SQLExpr argument) {
        if (argument == null) {
            return;
        }
        argument.setParent(this);
        this.arguments.add(argument);
    }

    public boolean isDeterministic() {
        return deterministic;
    }

    public void setDeterministic(boolean deterministic) {
        this.deterministic = deterministic;
    }

    public SQLDefaultOnConversionError getDefaultOnConversionError() {
        return defaultOnConversionError;
    }

    public void setDefaultOnConversionError(SQLDefaultOnConversionError defaultOnConversionError) {
        setChildParent(defaultOnConversionError);
        this.defaultOnConversionError = defaultOnConversionError;
    }

    public SQLPartitionByClause getPartitionClause() {
        return partitionClause;
    }

    public void setPartitionClause(SQLPartitionByClause partitionClause) {
        setChildParent(partitionClause);
        this.partitionClause = partitionClause;
    }

    public SQLOrderByClause getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(SQLOrderByClause orderByClause) {
        setChildParent(orderByClause);
        this.orderByClause = orderByClause;
    }


    @Override
    public List<SQLFunctionType> getFunctionType() {
        return functionTypes;
    }

    public void addFunctionType(SQLFunctionType functionType) {
        if (functionType == null) {
            return;
        }
        this.functionTypes.add(functionType);
    }


    /**
     * DEFAULT return_value ON CONVERSION ERROR
     */
    public static class SQLDefaultOnConversionError extends AbstractSQLExpr {

        protected SQLExpr value;

        public SQLDefaultOnConversionError(SQLExpr value) {
            setValue(value);
        }

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, value);
            }
        }

        public SQLExpr getValue() {
            return value;
        }

        public void setValue(SQLExpr value) {
            setChildParent(value);
            this.value = value;
        }
    }
}
