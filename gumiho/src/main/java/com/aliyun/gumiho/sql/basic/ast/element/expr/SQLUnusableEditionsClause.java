package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * [ UNUSABLE BEFORE  unusableBeforeAction={ CURRENT EDITION | EDITION edition } ]
 * [ UNUSABLE BEGINNING WITH unusableBeginningWithAction={ CURRENT EDITION | EDITION edition | NULL EDITION } ]
 * <p>
 * unusable_editions_clause
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/6/23.
 */
public class SQLUnusableEditionsClause extends AbstractSQLExpr {

    protected SQLExpr unusableBeforeAction;
    protected SQLExpr unusableBeginningWithAction;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, unusableBeforeAction);
            this.acceptChild(visitor, unusableBeginningWithAction);
        }
    }

    @Override
    public SQLUnusableEditionsClause clone() {
        SQLUnusableEditionsClause x = new SQLUnusableEditionsClause();

        if (unusableBeforeAction != null) {
            SQLExpr unusableBeforeActionClone = this.unusableBeforeAction.clone();
            x.setUnusableBeforeAction(unusableBeforeActionClone);
        }

        if (unusableBeginningWithAction != null) {
            SQLExpr unusableBeginningWithActionClone = this.unusableBeginningWithAction.clone();
            x.setUnusableBeginningWithAction(unusableBeginningWithActionClone);
        }
        return x;
    }


    public SQLExpr getUnusableBeforeAction() {
        return unusableBeforeAction;
    }

    public void setUnusableBeforeAction(SQLExpr unusableBeforeAction) {
        setChildParent(unusableBeforeAction);
        this.unusableBeforeAction = unusableBeforeAction;
    }

    public SQLExpr getUnusableBeginningWithAction() {
        return unusableBeginningWithAction;
    }

    public void setUnusableBeginningWithAction(SQLExpr unusableBeginningWithAction) {
        setChildParent(unusableBeginningWithAction);
        this.unusableBeginningWithAction = unusableBeginningWithAction;
    }

    /**
     * CURRENT EDITION
     */
    public static class SQLUnusableBeforeCurrentEditionAction extends AbstractSQLExpr {
        @Override
        protected void accept0(SQLASTVisitor visitor) {
            visitor.visit(this);
        }
        @Override
        public SQLUnusableBeforeCurrentEditionAction clone() {
            SQLUnusableBeforeCurrentEditionAction x = new SQLUnusableBeforeCurrentEditionAction();
            return x;
        }
    }

    /**
     * EDITION expr
     */
    public static class SQLUnusableBeforeEditionAction extends AbstractSQLExpr {
        protected SQLExpr expr;
        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if(visitor.visit(this)) {
                this.acceptChild(visitor, expr);
            }
        }
        @Override
        public SQLUnusableBeforeEditionAction clone() {
            SQLUnusableBeforeEditionAction x = new SQLUnusableBeforeEditionAction();
            SQLExpr exprClone = this.expr.clone();
            x.setExpr(exprClone);
            return x;
        }

        public SQLExpr getExpr() {
            return expr;
        }

        public void setExpr(SQLExpr expr) {
            setChildParent(expr);
            this.expr = expr;
        }
    }



    /**
     * CURRENT EDITION
     */
    public static class SQLUnusableBeginningWithCurrentEditionAction extends AbstractSQLExpr {
        @Override
        protected void accept0(SQLASTVisitor visitor) {
            visitor.visit(this);
        }
        @Override
        public SQLUnusableBeginningWithCurrentEditionAction clone() {
            SQLUnusableBeginningWithCurrentEditionAction x = new SQLUnusableBeginningWithCurrentEditionAction();
            return x;
        }
    }

    /**
     * EDITION expr
     */
    public static class SQLUnusableBeginningWithEditionAction extends AbstractSQLExpr {

        protected SQLExpr expr;
        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if(visitor.visit(this)) {
                this.acceptChild(visitor, expr);
            }
        }
        @Override
        public SQLUnusableBeginningWithEditionAction clone() {
            SQLUnusableBeginningWithEditionAction x = new SQLUnusableBeginningWithEditionAction();
            SQLExpr exprClone = this.expr.clone();
            x.setExpr(exprClone);
            return x;
        }

        public SQLExpr getExpr() {
            return expr;
        }

        public void setExpr(SQLExpr expr) {
            setChildParent(expr);
            this.expr = expr;
        }
    }

    /**
     * NULL EDITION
     */
    public static class SQLUnusableBeginningWithNullEditionAction extends AbstractSQLExpr {
        @Override
        protected void accept0(SQLASTVisitor visitor) {
            visitor.visit(this);
        }
        @Override
        public SQLUnusableBeginningWithNullEditionAction clone() {
            SQLUnusableBeginningWithNullEditionAction x = new SQLUnusableBeginningWithNullEditionAction();
            return x;
        }
    }
}
