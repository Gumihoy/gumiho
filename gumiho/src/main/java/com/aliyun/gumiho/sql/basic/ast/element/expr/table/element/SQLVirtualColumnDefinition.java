package com.aliyun.gumiho.sql.basic.ast.element.expr.table.element;

import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.expr.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.column.ISQLColumnConstraint;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.column.SQLReferencesColumnConstraint;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLVirtualType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLVisibleType;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * column data_type [GENERATED ALWAYS] AS (expression) [VIRTUAL | STORED] [NOT NULL | NULL] [UNIQUE [KEY]] [[PRIMARY] KEY] [COMMENT 'string']
 * https://dev.mysql.com/doc/refman/8.0/en/create-table.html
 *
 * column [ datatype [ COLLATE column_collation_name ] ] [ VISIBLE | INVISIBLE ] [ GENERATED ALWAYS ] AS (column_expression) [ VIRTUAL ] [ evaluation_edition_clause ] [ unusable_editions_clause ] [ inline_constraint [ inline_constraint ]... ]
 * virtual_column_definition
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/7/6.
 */
public class SQLVirtualColumnDefinition extends AbstractSQLExpr implements ISQLColumnDefinition {

    protected SQLExpr column;
    protected SQLDataType dataType;
    protected SQLCollateOptionExpr collateClause;
    protected SQLVisibleType visible;
    protected boolean generatedAlways;
    protected SQLExpr expr;
    protected SQLVirtualType virtual;
    protected SQLEvaluationEditionClause evaluationEditionClause;
    protected SQLUnusableEditionsClause unusableEditionsClause;
    protected final List<ISQLColumnConstraint> columnConstraints = new ArrayList<>();


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, column);
            this.acceptChild(visitor, dataType);
            this.acceptChild(visitor, collateClause);
            this.acceptChild(visitor, evaluationEditionClause);
            this.acceptChild(visitor, unusableEditionsClause);
            this.acceptChild(visitor, columnConstraints);
        }
    }

    @Override
    public SQLVirtualColumnDefinition clone() {
        SQLVirtualColumnDefinition x = new SQLVirtualColumnDefinition();

        SQLExpr columnClone = this.column.clone();
        x.setColumn(columnClone);

        if (this.dataType != null) {
            SQLDataType dataTypeClone = this.dataType.clone();
            x.setDataType(dataTypeClone);
        }



        return x;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == column) {
            setColumn(target);
            return true;
        }

        if (source == dataType
                && target instanceof SQLDataType) {
            setDataType((SQLDataType)target);
            return true;
        }

        return false;
    }

    @Override
    public boolean isReferencesColumn() {
        for (ISQLColumnConstraint columnConstraint : columnConstraints) {
            if (columnConstraint instanceof SQLReferencesColumnConstraint) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<SQLName> referencedTables() {
        List<SQLName> referencedTables = new ArrayList<>();
        for (ISQLColumnConstraint columnConstraint : columnConstraints) {
            if (columnConstraint instanceof SQLReferencesColumnConstraint) {
                referencedTables.add(((SQLReferencesColumnConstraint) columnConstraint).getReferencedTable());
            }
        }
        return referencedTables;
    }

    public SQLExpr getColumn() {
        return column;
    }

    public void setColumn(SQLExpr column) {
        setChildParent(column);
        this.column = column;
    }

    public SQLDataType getDataType() {
        return dataType;
    }

    public void setDataType(SQLDataType dataType) {
        this.dataType = dataType;
    }

    public SQLCollateOptionExpr getCollateClause() {
        return collateClause;
    }

    public void setCollateClause(SQLCollateOptionExpr collateClause) {
        this.collateClause = collateClause;
    }

    public SQLVisibleType getVisible() {
        return visible;
    }

    public void setVisible(SQLVisibleType visible) {
        this.visible = visible;
    }

    public boolean isGeneratedAlways() {
        return generatedAlways;
    }

    public void setGeneratedAlways(boolean generatedAlways) {
        this.generatedAlways = generatedAlways;
    }

    public SQLExpr getExpr() {
        return expr;
    }

    public void setExpr(SQLExpr expr) {
        setChildParent(expr);
        this.expr = expr;
    }

    public SQLVirtualType getVirtual() {
        return virtual;
    }

    public void setVirtual(SQLVirtualType virtual) {
        this.virtual = virtual;
    }

    public SQLEvaluationEditionClause getEvaluationEditionClause() {
        return evaluationEditionClause;
    }

    public void setEvaluationEditionClause(SQLEvaluationEditionClause evaluationEditionClause) {
        this.evaluationEditionClause = evaluationEditionClause;
    }

    public SQLUnusableEditionsClause getUnusableEditionsClause() {
        return unusableEditionsClause;
    }

    public void setUnusableEditionsClause(SQLUnusableEditionsClause unusableEditionsClause) {
        this.unusableEditionsClause = unusableEditionsClause;
    }

    @Override
    public List<ISQLColumnConstraint> getColumnConstraints() {
        return columnConstraints;
    }

    public void addColumnConstraint(ISQLColumnConstraint columnConstraint) {
        if (columnConstraint == null) {
            return;
        }
        setChildParent(columnConstraint);
        this.columnConstraints.add(columnConstraint);
    }
}
