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
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.filespecification.OracleSQLDataFileTempFileSpec;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * default_tablespace
 * <p>
 * https://docs.oracle.com/database/121/SQLRF/statements_5005.htm#i2186919
 *
 * @author kongtong.ouyang onCondition 2018/3/16.
 */
public class OracleSQLDefaultTablespace extends AbstractOracleSQLExpr {

    public SQLIdentifier tablespace;

    public OracleSQLDataFileTempFileSpec dataFile;

    public OracleSQLExtentManagementClause extentManagementClause;


    public OracleSQLDefaultTablespace() {
    }


    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            acceptChild(visitor, tablespace);
            acceptChild(visitor, dataFile);
            acceptChild(visitor, extentManagementClause);
        }
    }

    @Override
    public OracleSQLDefaultTablespace clone() {

        OracleSQLDefaultTablespace x = new OracleSQLDefaultTablespace();
        this.cloneTo(x);

        return x;
    }

    public void cloneTo(OracleSQLDefaultTablespace x) {

    }




    public SQLIdentifier getTablespace() {
        return tablespace;
    }

    public void setTablespace(SQLIdentifier tablespace) {
        this.tablespace = tablespace;
    }

    public OracleSQLDataFileTempFileSpec getDataFile() {
        return dataFile;
    }

    public void setDataFile(OracleSQLDataFileTempFileSpec dataFile) {
        this.dataFile = dataFile;
    }

    public OracleSQLExtentManagementClause getExtentManagementClause() {
        return extentManagementClause;
    }

    public void setExtentManagementClause(OracleSQLExtentManagementClause extentManagementClause) {
        this.extentManagementClause = extentManagementClause;
    }
}
