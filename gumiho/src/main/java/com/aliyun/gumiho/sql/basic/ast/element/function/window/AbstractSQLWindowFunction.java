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
package com.aliyun.gumiho.sql.basic.ast.element.function.window;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.function.AbstractSQLFunction;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;

/**
 *
 * function ( argument [inSideNullsOption], [argument...])  [fromOption] [outsideNullsOption] [overClause]
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#window%20function
 * <p>
 * https://dev.mysql.com/doc/refman/8.0/en/window-function-descriptions.html
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Analytic-Functions.html
 * <p>
 * https://www.postgresql.org/docs/devel/static/tutorial-window.html
 *
 * @author kongtong.ouyang onCondition 2018/3/20.
 */
public abstract class AbstractSQLWindowFunction extends AbstractSQLFunction implements ISQLWindowFunction {

    protected OracleSQLNullsOption insideNullsOption;

    protected OracleSQLFromOption fromOption;

    protected OracleSQLNullsOption outsideNullsOption;

    protected ISQLOverClause overClause;

    public AbstractSQLWindowFunction(String name) {
        super(name);
    }

    public AbstractSQLWindowFunction(SQLExpr name) {
        super(name);
    }

    @Override
    public AbstractSQLWindowFunction clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }


    public void cloneTo(AbstractSQLWindowFunction x) {
        super.cloneTo(x);

        if (overClause != null) {
            ISQLOverClause overClauseClone = this.overClause.clone();
            x.setOverClause(overClauseClone);
        }
    }


    public OracleSQLNullsOption getInsideNullsOption() {
        return insideNullsOption;
    }

    public void setInsideNullsOption(OracleSQLNullsOption insideNullsOption) {
        this.insideNullsOption = insideNullsOption;
    }

    public OracleSQLFromOption getFromOption() {
        return fromOption;
    }

    public void setFromOption(OracleSQLFromOption fromOption) {
        this.fromOption = fromOption;
    }

    public OracleSQLNullsOption getOutsideNullsOption() {
        return outsideNullsOption;
    }

    public void setOutsideNullsOption(OracleSQLNullsOption outsideNullsOption) {
        this.outsideNullsOption = outsideNullsOption;
    }

    public ISQLOverClause getOverClause() {
        return overClause;
    }

    public void setOverClause(ISQLOverClause overClause) {
        setChildParent(overClause);
        this.overClause = overClause;
    }


    /**
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/NTH_VALUE.html#GUID-F8A0E88C-67E5-4AA6-9515-95D03A7F9EA0
     */
    public enum OracleSQLFromOption {

        FROM_FIRST(SQLReserved.FROM_FIRST),
        FROM_LAST(SQLReserved.FROM_LAST);

        public final SQLReserved name;

        OracleSQLFromOption(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }

    /**
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/NTH_VALUE.html#GUID-F8A0E88C-67E5-4AA6-9515-95D03A7F9EA0
     */
    public enum OracleSQLNullsOption {

        RESPECT_NULLS(SQLReserved.RESPECT_NULLS),
        IGNORE_NULLS(SQLReserved.IGNORE_NULLS);

        public final SQLReserved name;

        OracleSQLNullsOption(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }


}
