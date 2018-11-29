package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.select;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExprToExprExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * USING  { [schema.]base_av_name [hierarchies_clause] [filter_clauses] [add_calcs_clause] }
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SELECT.html#GUID-CFA006CA-6FF1-4972-821E-6996142A51C6
 *
 * @author kongtong.ouyang on 2018/5/10.
 */
public class OracleSQLSubAvClause extends AbstractOracleSQLExpr {

    protected SQLName name;

    protected OracleSQLHierarchiesClause hierarchiesClause;

    protected final List<SQLExprToExprExpr> filterClauses = new ArrayList<>();

    protected final List<OracleSQLCalcMeasClause> calcMeasClauses = new ArrayList<>();

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, hierarchiesClause);
            this.acceptChild(visitor, filterClauses);
            this.acceptChild(visitor, calcMeasClauses);
        }
    }

    @Override
    public OracleSQLSubAvClause clone() {
        OracleSQLSubAvClause x = new OracleSQLSubAvClause();

        if (this.name != null) {
            SQLName nameClone = this.name.clone();
            x.setName(nameClone);
        }

        if (this.hierarchiesClause != null) {
            OracleSQLHierarchiesClause hierarchiesClauseClone = this.hierarchiesClause.clone();
            x.setHierarchiesClause(hierarchiesClauseClone);
        }

        for (SQLExprToExprExpr item : filterClauses) {
            SQLExprToExprExpr clone = item.clone();
            x.addFilterClause(clone);
        }

        for (OracleSQLCalcMeasClause item : calcMeasClauses) {
            OracleSQLCalcMeasClause clone = item.clone();
            x.addCalcMeasClause(clone);
        }
        return x;
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }

    public OracleSQLHierarchiesClause getHierarchiesClause() {
        return hierarchiesClause;
    }

    public void setHierarchiesClause(OracleSQLHierarchiesClause hierarchiesClause) {
        setChildParent(hierarchiesClause);
        this.hierarchiesClause = hierarchiesClause;
    }

    public List<SQLExprToExprExpr> getFilterClauses() {
        return filterClauses;
    }

    public void addFilterClause(SQLExprToExprExpr item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.filterClauses.add(item);
    }

    public List<OracleSQLCalcMeasClause> getCalcMeasClauses() {
        return calcMeasClauses;
    }

    public void addCalcMeasClause(OracleSQLCalcMeasClause item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.calcMeasClauses.add(item);
    }

    /**
     * meas_name AS (expression)
     */
    public static class OracleSQLCalcMeasClause extends AbstractOracleSQLExpr {

        protected SQLExpr name;
        protected SQLExpr expr;


        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, name);
                this.acceptChild(visitor, expr);
            }
        }

        @Override
        public OracleSQLCalcMeasClause clone() {
            OracleSQLCalcMeasClause x = new OracleSQLCalcMeasClause();

            SQLExpr nameClone = name.clone();
            x.setName(nameClone);

            SQLExpr exprClone = this.expr.clone();
            x.setExpr(exprClone);
            return x;
        }

        public SQLExpr getName() {
            return name;
        }

        public void setName(SQLExpr name) {
            setChildParent(name);
            this.name = name;
        }

        public SQLExpr getExpr() {
            return expr;
        }

        public void setExpr(SQLExpr expr) {
            setChildParent(expr);
            this.expr = expr;
        }
    }
}
