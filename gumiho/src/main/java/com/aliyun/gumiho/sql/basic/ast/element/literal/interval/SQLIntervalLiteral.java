/*
 * Copyright (C) 2017-2018 kent(kent.bohai@gmail.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.aliyun.gumiho.sql.basic.ast.element.literal.interval;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.literal.SQLLiteral;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLIntervalUnit;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * INTERVAL [ <sign> ] <interval string> <interval qualifier>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#interval%20literal
 * <p>
 * INTERVAL expr unit
 * https://dev.mysql.com/doc/refman/8.0/en/expressions.html
 * <p>
 * interval '21 days'  interval '03:30:00'
 * https://www.postgresql.org/docs/10/static/functions-datetime.html
 * <p>
 * INTERVAL 'integer [- integer ]' { YEAR | MONTH } [ (precision) ] [ TO { YEAR | MONTH } ]
 * https://docs.oracle.com/database/121/SQLRF/sql_elements003.htm#SQLRF00221
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/Literals.html#GUID-DC8D1DAD-7D04-45EA-9546-82810CD09A1B
 *
 * @author kongtong.ouyang onCondition 2018/3/20.
 */
public class SQLIntervalLiteral extends AbstractSQLExpr implements SQLLiteral {

    // +: true, -: false;
    protected Boolean sign;

    protected SQLExpr value;

    protected SQLIntervalUnit unit;
    protected List<SQLExpr> precisions;

    protected SQLIntervalUnit toUnit;
    protected List<SQLExpr> toPrecisions;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, value);
            this.acceptChild(visitor, precisions);
            this.acceptChild(visitor, toPrecisions);
        }
    }

    @Override
    public SQLIntervalLiteral clone() {
        SQLIntervalLiteral x = new SQLIntervalLiteral();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLIntervalLiteral x) {
        super.cloneTo(x);
        SQLExpr valueClone = this.value.clone();
        x.setValue(valueClone);

        x.setUnit(this.unit);
        for (SQLExpr precision : this.precisions) {
            SQLExpr precisionClone = precision.clone();
            x.addPrecisions(precisionClone);
        }

        x.setToUnit(this.toUnit);
        for (SQLExpr toPrecision : this.toPrecisions) {
            SQLExpr toPrecisionClone = toPrecision.clone();
            x.addToPrecision(toPrecisionClone);
        }
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {

        if (value == source) {
            setValue(target);
            return true;
        }

        boolean replace = replaceInList(this.precisions, source, target, this);
        if (replace) {
            return true;
        }

        replace = replaceInList(this.toPrecisions, source, target, this);
        if (replace) {
            return true;
        }


        return false;
    }

    public Boolean getSign() {
        return sign;
    }

    public void setSign(Boolean sign) {
        this.sign = sign;
    }

    @Override
    public SQLExpr getValue() {
        return value;
    }

    public void setValue(SQLExpr value) {
        setChildParent(value);
        this.value = value;
    }

    public SQLIntervalUnit getUnit() {
        return unit;
    }

    public void setUnit(SQLIntervalUnit unit) {
        this.unit = unit;
    }

    public List<SQLExpr> getPrecisions() {
        return precisions;
    }

    public void addPrecisions(SQLExpr precision) {
        if (precision == null) {
            return;
        }
        if (this.precisions == null) {
            this.precisions = new ArrayList<>();
        }
        setChildParent(precision);
        this.precisions.add(precision);
    }

    public SQLIntervalUnit getToUnit() {
        return toUnit;
    }

    public void setToUnit(SQLIntervalUnit toUnit) {
        this.toUnit = toUnit;
    }

    public List<SQLExpr> getToPrecisions() {
        return toPrecisions;
    }

    public void addToPrecision(SQLExpr toPrecision) {
        if (toPrecision == null) {
            return;
        }
        if (this.toPrecisions == null) {
            this.toPrecisions = new ArrayList<>();
        }
        setChildParent(toPrecision);
        this.toPrecisions.add(toPrecision);
    }
}
