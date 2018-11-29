package com.aliyun.gumiho.sql.basic.ast.element.expr.table;

import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.materializedview.ISQLUsingIndexClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.materializedview.SQLUsingIndexClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.option.SQExceptionsClause;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLKeepIndexType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLValidateType;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * { ENABLE | DISABLE } [ VALIDATE | NOVALIDATE ] { UNIQUE (column [, column ]...) | PRIMARY KEY | CONSTRAINT constraint_name } [ using_index_clause ]  [ exceptions_clause ] [ CASCADE ] [ { KEEP | DROP } INDEX ]
 * <p>
 * enable_disable_clause
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/7/10.
 */
public interface ISQLEnableDisableClause extends SQLExpr {
    @Override
    ISQLEnableDisableClause clone();


    abstract class AbstractSQLEnableDisableClause extends AbstractSQLExpr implements ISQLEnableDisableClause {
        protected SQLValidateType validate;
        protected ISQLUsingIndexClause usingIndexClause;
        protected SQExceptionsClause exceptionsClause;
        protected boolean cascade;
        protected SQLKeepIndexType keepIndex;

        @Override
        public AbstractSQLEnableDisableClause clone() {
            throw new UnsupportedOperationException(getClass().getName());
        }

        @Override
        public void cloneTo(SQLObject x) {
            super.cloneTo(x);
        }

        public SQLValidateType getValidate() {
            return validate;
        }

        public void setValidate(SQLValidateType validate) {
            this.validate = validate;
        }

        public ISQLUsingIndexClause getUsingIndexClause() {
            return usingIndexClause;
        }

        public void setUsingIndexClause(ISQLUsingIndexClause usingIndexClause) {
            setChildParent(usingIndexClause);
            this.usingIndexClause = usingIndexClause;
        }

        public SQExceptionsClause getExceptionsClause() {
            return exceptionsClause;
        }

        public void setExceptionsClause(SQExceptionsClause exceptionsClause) {
            this.exceptionsClause = exceptionsClause;
        }

        public boolean isCascade() {
            return cascade;
        }

        public void setCascade(boolean cascade) {
            this.cascade = cascade;
        }

        public SQLKeepIndexType getKeepIndex() {
            return keepIndex;
        }

        public void setKeepIndex(SQLKeepIndexType keepIndex) {
            this.keepIndex = keepIndex;
        }
    }


    /**
     * ENABLE validateType? UNIQUE LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN
     */
    class SQLEnableUniqueClause extends AbstractSQLEnableDisableClause {
        protected final List<SQLExpr> columns = new ArrayList<>();

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, columns);
                this.acceptChild(visitor, usingIndexClause);
                this.acceptChild(visitor, exceptionsClause);
            }
        }

        @Override
        public AbstractSQLEnableDisableClause clone() {
            return super.clone();
        }

        @Override
        public boolean replace(SQLExpr source, SQLExpr target) {
            boolean replace = replaceInList(columns, source, target, this);
            if (replace) {
                return true;
            }
            return false;
        }

        public List<SQLExpr> getColumns() {
            return columns;
        }

        public void addColumn(SQLExpr column) {
            if (column == null) {
                return;
            }
            setChildParent(column);
            this.columns.add(column);
        }
    }


    /**
     * ENABLE validateType? PRIMARY KEY
     */
    class SQLEnablePrimaryKeyClause extends AbstractSQLEnableDisableClause {

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, usingIndexClause);
                this.acceptChild(visitor, exceptionsClause);
            }
        }

        @Override
        public AbstractSQLEnableDisableClause clone() {
            return super.clone();
        }
    }


    /**
     * ENABLE validateType? CONSTRAINT nameIdentifier [ using_index_clause ]  [ exceptions_clause ] [ CASCADE ] [ { KEEP | DROP } INDEX ]
     */
    class SQLEnableConstraintClause extends AbstractSQLEnableDisableClause {
        protected SQLExpr name;

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, name);
                this.acceptChild(visitor, usingIndexClause);
                this.acceptChild(visitor, exceptionsClause);
            }
        }

        @Override
        public AbstractSQLEnableDisableClause clone() {
            return super.clone();
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
    }



    /**
     * DISABLE validateType? UNIQUE LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN
     */
    class SQLDisableUniqueClause extends AbstractSQLEnableDisableClause {
        protected final List<SQLExpr> columns = new ArrayList<>();

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, columns);
                this.acceptChild(visitor, usingIndexClause);
                this.acceptChild(visitor, exceptionsClause);
            }
        }

        @Override
        public AbstractSQLEnableDisableClause clone() {
            return super.clone();
        }

        @Override
        public boolean replace(SQLExpr source, SQLExpr target) {
            boolean replace = replaceInList(columns, source, target, this);
            if (replace) {
                return true;
            }
            return false;
        }

        public List<SQLExpr> getColumns() {
            return columns;
        }

        public void addColumn(SQLExpr column) {
            if (column == null) {
                return;
            }
            setChildParent(column);
            this.columns.add(column);
        }
    }


    /**
     * DISABLE validateType? PRIMARY KEY
     */
    class SQLDisablePrimaryKeyClause extends AbstractSQLEnableDisableClause {

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, usingIndexClause);
                this.acceptChild(visitor, exceptionsClause);
            }
        }

        @Override
        public AbstractSQLEnableDisableClause clone() {
            return super.clone();
        }
    }


    /**
     * DISABLE validateType? CONSTRAINT nameIdentifier
     */
    class SQLDisableConstraintClause extends AbstractSQLEnableDisableClause {
        protected SQLExpr name;

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, name);
                this.acceptChild(visitor, usingIndexClause);
                this.acceptChild(visitor, exceptionsClause);
            }
        }

        @Override
        public AbstractSQLEnableDisableClause clone() {
            return super.clone();
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
    }
}
