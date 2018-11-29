package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.select;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExprAsObjectExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.clause.SQLPartitionByClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.order.SQLOrderByClause;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.OracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * MATCH_RECOGNIZE ( [ row_pattern_partition_by ] [ row_pattern_order_by ] [ MEASURES measuresItems]
 * [ row_pattern_rows_per_match ] [ row_pattern_skip_to ] PATTERN (row_pattern) [ row_pattern_subset_clause ]
 * DEFINE expr (,expr)...)
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SELECT.html#GUID-CFA006CA-6FF1-4972-821E-6996142A51C6
 *
 * @author kongtong.ouyang on 2018/5/18.
 */
public class OracleSQLRowPatternClause extends AbstractOracleSQLExpr {

    protected SQLPartitionByClause partitionByClause;

    protected SQLOrderByClause orderByClause;

    protected final List<SQLExprAsObjectExpr> measuresItems = new ArrayList<>();

    protected OracleSQLRowPatternRowsPerMatch rowsPerMatch;

    protected OracleSQLRowPatternSkipToOption skipToOption;

    protected SQLExpr pattern;

    protected OracleSQLRowPatternSubsetClause patternSubsetClause;

    protected final List<SQLExprAsObjectExpr> defineItems = new ArrayList<>();


    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, partitionByClause);
            this.acceptChild(visitor, orderByClause);
            this.acceptChild(visitor, measuresItems);
            this.acceptChild(visitor, skipToOption);
            this.acceptChild(visitor, pattern);
            this.acceptChild(visitor, patternSubsetClause);
            this.acceptChild(visitor, defineItems);
        }
    }


    public SQLPartitionByClause getPartitionByClause() {
        return partitionByClause;
    }

    public void setPartitionByClause(SQLPartitionByClause partitionByClause) {
        setChildParent(partitionByClause);
        this.partitionByClause = partitionByClause;
    }

    public SQLOrderByClause getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(SQLOrderByClause orderByClause) {
        setChildParent(orderByClause);
        this.orderByClause = orderByClause;
    }

    public List<SQLExprAsObjectExpr> getMeasuresItems() {
        return measuresItems;
    }

    public void addMeasuresItem(SQLExprAsObjectExpr item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        measuresItems.add(item);
    }

    public OracleSQLRowPatternRowsPerMatch getRowsPerMatch() {
        return rowsPerMatch;
    }

    public void setRowsPerMatch(OracleSQLRowPatternRowsPerMatch rowsPerMatch) {
        this.rowsPerMatch = rowsPerMatch;
    }

    public OracleSQLRowPatternSkipToOption getSkipToOption() {
        return skipToOption;
    }

    public void setSkipToOption(OracleSQLRowPatternSkipToOption skipToOption) {
        setChildParent(skipToOption);
        this.skipToOption = skipToOption;
    }

    public SQLExpr getPattern() {
        return pattern;
    }

    public void setPattern(SQLExpr pattern) {
        setChildParent(pattern);
        this.pattern = pattern;
    }

    public OracleSQLRowPatternSubsetClause getPatternSubsetClause() {
        return patternSubsetClause;
    }

    public void setPatternSubsetClause(OracleSQLRowPatternSubsetClause patternSubsetClause) {
        setChildParent(patternSubsetClause);
        this.patternSubsetClause = patternSubsetClause;
    }

    public List<SQLExprAsObjectExpr> getDefineItems() {
        return defineItems;
    }

    public void addColumn(SQLExprAsObjectExpr defineItem) {
        if (defineItem == null) {
            return;
        }
        setChildParent(defineItem);
        this.defineItems.add(defineItem);
    }

    /**
     * MEASURES expr as alias [, expr as alias ]...
     */
    public static class OracleSQLRowPatternMeasures extends AbstractOracleSQLExpr {

        protected final List<SQLExprAsObjectExpr> measureColumns = new ArrayList<>();

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, measureColumns);
            }
        }

        public List<SQLExprAsObjectExpr> getMeasureColumns() {
            return measureColumns;
        }

        public void addColumn(SQLExprAsObjectExpr column) {
            if (column == null) {
                return;
            }
            setChildParent(column);
            this.measureColumns.add(column);
        }
    }


    /**
     * ONE ROW PER MATCH | ALL ROWS PER MATCH
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/img_text/row_pattern_rows_per_match.html
     */
    public enum OracleSQLRowPatternRowsPerMatch {
        ONE_ROW_PER_MATCH(SQLReserved.ONE_ROW_PER_MATCH),
        ALL_ROWS_PER_MATCH(SQLReserved.ALL_ROWS_PER_MATCH),;

        public final SQLReserved name;

        OracleSQLRowPatternRowsPerMatch(SQLReserved name) {
            this.name = name;
        }
    }

    public interface OracleSQLRowPatternSkipToOption extends OracleSQLExpr {
        @Override
        OracleSQLRowPatternSkipToOption clone();
    }

    /**
     * AFTER MATCH SKIP TO NEXT ROW
     */
    public static class OracleSQLRowPatternSkipToNextRowOption extends AbstractOracleSQLExpr implements OracleSQLRowPatternSkipToOption {
        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public OracleSQLRowPatternSkipToNextRowOption clone() {
            return new OracleSQLRowPatternSkipToNextRowOption();
        }
    }

    /**
     * AFTER MATCH SKIP PAST LAST ROW
     */
    public static class OracleSQLRowPatternSkipPastLastRowOption extends AbstractOracleSQLExpr implements OracleSQLRowPatternSkipToOption {
        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public OracleSQLRowPatternSkipPastLastRowOption clone() {
            return new OracleSQLRowPatternSkipPastLastRowOption();
        }
    }

    /**
     * AFTER MATCH SKIP TO FIRST variable_name
     */
    public static class OracleSQLRowPatternSkipToFirstVarOption extends AbstractOracleSQLExpr implements OracleSQLRowPatternSkipToOption {

        protected SQLExpr name;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, name);
            }
        }

        @Override
        public OracleSQLRowPatternSkipToLastVarOption clone() {
            OracleSQLRowPatternSkipToLastVarOption x = new OracleSQLRowPatternSkipToLastVarOption();
            return x;
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
     * AFTER MATCH SKIP TO LAST variable_name
     */
    public static class OracleSQLRowPatternSkipToLastVarOption extends AbstractOracleSQLExpr implements OracleSQLRowPatternSkipToOption {
        protected SQLExpr name;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, name);
            }
        }

        @Override
        public OracleSQLRowPatternSkipToLastVarOption clone() {
            OracleSQLRowPatternSkipToLastVarOption x = new OracleSQLRowPatternSkipToLastVarOption();
            return x;
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
     * AFTER MATCH SKIP TO variable_name
     */
    public static class OracleSQLRowPatternSkipToVarOption extends AbstractOracleSQLExpr implements OracleSQLRowPatternSkipToOption {
        protected SQLExpr name;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, name);
            }
        }

        @Override
        public OracleSQLRowPatternSkipToLastVarOption clone() {
            OracleSQLRowPatternSkipToLastVarOption x = new OracleSQLRowPatternSkipToLastVarOption();
            return x;
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
     * SUBSET row_pattern_subset_item [, row_pattern_subset_item ]...
     */
    public static class OracleSQLRowPatternSubsetClause extends AbstractOracleSQLExpr {

        protected final List<OracleSQLRowPatternSubsetItem> items = new ArrayList<>();

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, items);
            }
        }

        @Override
        public OracleSQLRowPatternSkipToLastVarOption clone() {
            OracleSQLRowPatternSkipToLastVarOption x = new OracleSQLRowPatternSkipToLastVarOption();

            for (OracleSQLRowPatternSubsetItem item : items) {

            }

            return x;
        }

        public List<OracleSQLRowPatternSubsetItem> getItems() {
            return items;
        }

        public void addItem(OracleSQLRowPatternSubsetItem item) {
            if (item == null) {
                return;
            }
            setChildParent(item);
            this.items.add(item);
        }
    }

    /**
     * variable_name = ( variable_name [, variable_name ] )
     */
    public static class OracleSQLRowPatternSubsetItem extends AbstractOracleSQLExpr {

        protected SQLExpr name;
        protected final List<SQLExpr> items = new ArrayList<>();

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, name);
                this.acceptChild(visitor, items);
            }
        }

        @Override
        public OracleSQLRowPatternSkipToLastVarOption clone() {
            OracleSQLRowPatternSkipToLastVarOption x = new OracleSQLRowPatternSkipToLastVarOption();
            return x;
        }

        public SQLExpr getName() {
            return name;
        }

        public void setName(SQLExpr name) {
            setChildParent(name);
            this.name = name;
        }

        public List<SQLExpr> getItems() {
            return items;
        }

        public void addItem(SQLExpr item) {
            if (item == null) {
                return;
            }
            setChildParent(item);
            this.items.add(item);
        }
    }
}
