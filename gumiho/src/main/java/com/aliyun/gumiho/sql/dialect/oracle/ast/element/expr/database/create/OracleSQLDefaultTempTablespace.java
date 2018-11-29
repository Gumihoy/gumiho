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
package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.database.create;

import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLIdentifier;
import com.aliyun.gumiho.sql.dialect.oracle.ast.enums.OracleSQLFileType;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.filespecification.OracleSQLFileSpecification;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * default_temp_tablespace
 * <p>
 * https://docs.oracle.com/database/121/SQLRF/statements_5005.htm#i2142113
 *
 * @author kongtong.ouyang onCondition 2018/3/16.
 */
public class OracleSQLDefaultTempTablespace extends AbstractOracleSQLExpr {

    public OracleSQLFileType type;

    public SQLIdentifier tablespace;

    public List<OracleSQLFileSpecification> tempFileFileSpec = new ArrayList<>();






    public OracleSQLDefaultTempTablespace(SQLIdentifier tablespace) {
        this.setTablespace(tablespace);

    }

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            acceptChild(visitor, tablespace);
        }
    }

    @Override
    public OracleSQLDefaultTempTablespace clone() {

        OracleSQLDefaultTempTablespace x = new OracleSQLDefaultTempTablespace(this.tablespace);
        this.cloneTo(x);

        return x;
    }

    public void cloneTo(OracleSQLDefaultTempTablespace x) {

    }


    public OracleSQLFileType getType() {
        return type;
    }

    public void setType(OracleSQLFileType type) {
        this.type = type;
    }

    public SQLIdentifier getTablespace() {
        return tablespace;
    }

    public void setTablespace(SQLIdentifier tablespace) {
        if (tablespace != null) {
            tablespace.setParent(this);
        }
        this.tablespace = tablespace;
    }
}
