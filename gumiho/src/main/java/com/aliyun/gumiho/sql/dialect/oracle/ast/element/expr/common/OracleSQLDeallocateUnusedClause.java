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
package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * deallocate_unused_clause
 * <p>
 * https://docs.oracle.com/database/121/SQLRF/clauses003.htm#SQLRF30007
 *
 * @author kongtong.ouyang onCondition 2018/3/16.
 */
public class OracleSQLDeallocateUnusedClause extends AbstractOracleSQLExpr {

    public OracleSQLSizeClause keep;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, keep);
        }
    }

    @Override
    public OracleSQLDeallocateUnusedClause clone() {
        OracleSQLDeallocateUnusedClause x = new OracleSQLDeallocateUnusedClause();

        if (keep!=null) {
            OracleSQLSizeClause keepClone = this.keep.clone();
            x.setKeep(keepClone);
        }
        return x;
    }

    public OracleSQLSizeClause getKeep() {
        return keep;
    }

    public void setKeep(OracleSQLSizeClause keep) {
        setChildParent(keep);
        this.keep = keep;
    }
}
