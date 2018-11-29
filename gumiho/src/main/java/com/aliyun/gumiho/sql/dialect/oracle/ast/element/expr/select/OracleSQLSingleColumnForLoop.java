package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.select;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.OracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * single_column_for_loop
 * FOR dimension_column { IN ( { literal [, literal ]... | subquery } ) | [ LIKE pattern ] FROM literal TO literal { INCREMENT | DECREMENT } literal }
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SELECT.html#GUID-CFA006CA-6FF1-4972-821E-6996142A51C6
 *
 * @author kongtong.ouyang on 2018/6/11.
 */
public class OracleSQLSingleColumnForLoop extends AbstractOracleSQLExpr {

    protected SQLName name;

    protected OracleSQLSingleColumnForLoopConditionExpr condition;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
        }
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }

    public OracleSQLSingleColumnForLoopConditionExpr getCondition() {
        return condition;
    }

    public void setCondition(OracleSQLSingleColumnForLoopConditionExpr condition) {
        setChildParent(condition);
        this.condition = condition;
    }

    public interface OracleSQLSingleColumnForLoopConditionExpr extends OracleSQLExpr {
        @Override
        OracleSQLSingleColumnForLoopConditionExpr clone();
    }

    /**
     * IN ( expr ...)
     */
    public static class OracleSQLSingleColumnForLoopInConditionExpr extends AbstractOracleSQLExpr implements OracleSQLSingleColumnForLoopConditionExpr {

        protected final List<SQLExpr> arguments = new ArrayList<>();

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, arguments);
            }
        }

        @Override
        public OracleSQLSingleColumnForLoopInConditionExpr clone() {
            OracleSQLSingleColumnForLoopInConditionExpr x = new OracleSQLSingleColumnForLoopInConditionExpr();
            for (SQLExpr argument : arguments) {
                SQLExpr argumentClone = argument.clone();
                x.addArgument(argumentClone);
            }
            return x;
        }

        public List<SQLExpr> getArguments() {
            return arguments;
        }

        public void addArgument(SQLExpr argument) {
            if (argument == null) {
                return;
            }
            setChildParent(argument);
            this.arguments.add(argument);
        }
    }

    /**
     * [LIKE pattern] FROM expr TO expr  (INCREMENT | DECREMENT) expr
     */
    public static class OracleSQLSingleColumnForLoopFromToConditionExpr extends AbstractOracleSQLExpr implements OracleSQLSingleColumnForLoopConditionExpr {

        protected SQLExpr pattern;
        protected SQLExpr from;
        protected SQLExpr to;
        protected SQLReserved increment;
        protected SQLExpr incrementVal;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, pattern);
                this.acceptChild(visitor, from);
                this.acceptChild(visitor, to);
                this.acceptChild(visitor, incrementVal);
            }
        }

        @Override
        public OracleSQLSingleColumnForLoopFromToConditionExpr clone() {
            OracleSQLSingleColumnForLoopFromToConditionExpr x = new OracleSQLSingleColumnForLoopFromToConditionExpr();
            return x;
        }

        public SQLExpr getPattern() {
            return pattern;
        }

        public void setPattern(SQLExpr pattern) {
            setChildParent(pattern);
            this.pattern = pattern;
        }

        public SQLExpr getFrom() {
            return from;
        }

        public void setFrom(SQLExpr from) {
            setChildParent(from);
            this.from = from;
        }

        public SQLExpr getTo() {
            return to;
        }

        public void setTo(SQLExpr to) {
            setChildParent(to);
            this.to = to;
        }

        public SQLReserved getIncrement() {
            return increment;
        }

        public void setIncrement(SQLReserved increment) {
            this.increment = increment;
        }

        public SQLExpr getIncrementVal() {
            return incrementVal;
        }

        public void setIncrementVal(SQLExpr incrementVal) {
            setChildParent(incrementVal);
            this.incrementVal = incrementVal;
        }
    }
}
