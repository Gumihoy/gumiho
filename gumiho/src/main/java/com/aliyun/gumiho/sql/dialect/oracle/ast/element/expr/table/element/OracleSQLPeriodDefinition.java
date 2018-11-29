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
package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.table.element;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.SQLTableElement;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * PERIOD FOR valid_time_column [ ( start_time_column, end_time_column ) ]
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang onCondition 2018/3/28.
 */
public class OracleSQLPeriodDefinition extends AbstractOracleSQLExpr implements SQLTableElement {

    protected SQLExpr validTimeColumn;

    protected SQLName startTimeColumn;

    protected SQLName endTimeColumn;


    public OracleSQLPeriodDefinition() {
    }

    public OracleSQLPeriodDefinition(SQLExpr validTimeColumn) {
        setValidTimeColumn(validTimeColumn);
    }

    public static OracleSQLPeriodDefinition of(SQLExpr validTimeColumn) {
        return new OracleSQLPeriodDefinition(validTimeColumn);
    }


    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, validTimeColumn);
            this.acceptChild(visitor, startTimeColumn);
            this.acceptChild(visitor, endTimeColumn);
        }
    }

    @Override
    public OracleSQLPeriodDefinition clone() {
        OracleSQLPeriodDefinition x = new OracleSQLPeriodDefinition();

        return x;
    }


    public SQLExpr getValidTimeColumn() {
        return validTimeColumn;
    }

    public void setValidTimeColumn(SQLExpr validTimeColumn) {
        setChildParent(validTimeColumn);
        this.validTimeColumn = validTimeColumn;
    }

    public SQLName getStartTimeColumn() {
        return startTimeColumn;
    }

    public void setStartTimeColumn(SQLName startTimeColumn) {
        setChildParent(startTimeColumn);
        this.startTimeColumn = startTimeColumn;
    }

    public SQLName getEndTimeColumn() {
        return endTimeColumn;
    }

    public void setEndTimeColumn(SQLName endTimeColumn) {
        setChildParent(endTimeColumn);
        this.endTimeColumn = endTimeColumn;
    }
}
