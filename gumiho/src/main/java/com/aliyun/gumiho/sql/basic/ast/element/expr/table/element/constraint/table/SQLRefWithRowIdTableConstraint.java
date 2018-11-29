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
package com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.table;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.AbstractSQLConstraint;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * REF ({ ref_col | ref_attr }) WITH ROWID
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/constraint.html#GUID-1055EA97-BA6F-4764-A15F-1024FD5B6DFE
 *
 * @author kongtong.ouyang onCondition 2018/3/13.
 */
public class SQLRefWithRowIdTableConstraint extends AbstractSQLConstraint implements ISQLCheckTableConstraint {

    private SQLExpr ref;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, ref);
        }
    }

    @Override
    public SQLRefWithRowIdTableConstraint clone() {
        SQLRefWithRowIdTableConstraint x = new SQLRefWithRowIdTableConstraint();
        SQLExpr refClone = this.ref.clone();
        x.setRef(refClone);
        return x;
    }

    public SQLExpr getRef() {
        return ref;
    }

    public void setRef(SQLExpr ref) {
        setChildParent(ref);
        this.ref = ref;
    }
}
