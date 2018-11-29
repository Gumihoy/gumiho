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
package com.aliyun.gumiho.sql.basic.ast.element.datatype.interval;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLIntervalUnit;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * INTERVAL  (YEAR | MONTH | DAY | HOUR | MINUTE | SECOND) [(precision, ..)]  [ TO (YEAR | MONTH | DAY | HOUR | MINUTE | SECOND) [(precision...)] ]
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#interval%20type
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/Data-Types.html#GUID-A3C0D836-BADB-44E5-A5D4-265BA5968483
 *
 * @author kongtong.ouyang onCondition 2018/3/11.
 */
public class SQLIntervalDataType extends AbstractSQLIntervalDataType {

    protected SQLIntervalUnit toUnit;
    protected List<SQLExpr> toPrecisions;

    public SQLIntervalDataType() {
    }

    public SQLIntervalDataType(SQLReserved name) {
        super(name.ofExpr());
    }

    public SQLIntervalDataType(SQLName name) {
        super(name);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, arguments);
            this.acceptChild(visitor, toPrecisions);
        }
    }

    @Override
    public SQLIntervalDataType clone() {

        SQLIntervalDataType x = new SQLIntervalDataType();

        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLIntervalDataType x) {
        super.cloneTo(x);

        x.toUnit = this.toUnit;

        if (toPrecisions != null) {
            for (SQLExpr toPrecision : toPrecisions) {
                SQLExpr toPrecisionClone = toPrecision.clone();
                x.addToPrecision(toPrecisionClone);
            }
        }

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
