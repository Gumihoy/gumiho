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
package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.select;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.ISQLWithClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.SQLWithClause;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.OracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/SELECT.html#GUID-CFA006CA-6FF1-4972-821E-6996142A51C6
 *
 * @author kongtong.ouyang onCondition 2018/3/21.
 */
public class OracleSQLWithClause extends SQLWithClause implements OracleSQLExpr, ISQLWithClause {

    protected final List<SQLExpr> plsqlDeclarations = new ArrayList<>();

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor instanceof OracleSQLASTVisitor) {
            this.accept0((OracleSQLASTVisitor) visitor);
        } else {
            throw new UnsupportedOperationException(getClass().getName());
        }
    }

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, plsqlDeclarations);
            this.acceptChild(visitor, withElements);
        }
    }

    @Override
    public OracleSQLWithClause clone() {
        OracleSQLWithClause x = new OracleSQLWithClause();
        return x;
    }

    public List<SQLExpr> getPlsqlDeclarations() {
        return plsqlDeclarations;
    }

    public void addDeclaration(SQLExpr declaration) {
        if (declaration == null) {
            return;
        }
        setChildParent(declaration);
        this.plsqlDeclarations.add(declaration);
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        throw new UnsupportedOperationException(getClass().getName());
    }


    /**
     * subav_name ANALYTIC VIEW AS (subav_clause)
     * <p>
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SELECT.html#GUID-CFA006CA-6FF1-4972-821E-6996142A51C6
     */
    public static class OracleSQLSubAvFactoringClause extends AbstractOracleSQLExpr implements SQLWithElement {

        protected SQLName name;

        protected OracleSQLSubAvClause subAvClause;

        public OracleSQLSubAvFactoringClause() {
        }

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, name);
                this.acceptChild(visitor, subAvClause);
            }
        }

        @Override
        public OracleSQLSubAvFactoringClause clone() {
            OracleSQLSubAvFactoringClause x = new OracleSQLSubAvFactoringClause();
            this.cloneTo(x);
            return x;
        }

        public void cloneTo(OracleSQLSubAvFactoringClause x) {
            super.cloneTo(x);

            SQLName nameClone = this.name.clone();
            x.setName(nameClone);

            OracleSQLSubAvClause subAvClauseClone = this.subAvClause.clone();
            x.setSubAvClause(subAvClauseClone);
        }

        public SQLName getName() {
            return name;
        }

        public void setName(SQLName name) {
            setChildParent(name);
            this.name = name;
        }

        public OracleSQLSubAvClause getSubAvClause() {
            return subAvClause;
        }

        public void setSubAvClause(OracleSQLSubAvClause subAvClause) {
            setChildParent(subAvClause);
            this.subAvClause = subAvClause;
        }
    }


}
