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
package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.filespecification;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.OracleSQLSizeClause;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * [ 'filename' | 'ASM_filename' ] [ SIZE size_clause ] [ REUSE ] [ autoextend_clause ]
 * <p>
 * datafile_tempfile_spec
 * <p>
 * https://docs.oracle.com/database/121/SQLRF/clauses004.htm#SQLRF01602
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/file_specification.html#GUID-580FA726-F712-4410-90CF-783A2DA89688
 *
 * @author kongtong.ouyang onCondition 2018/3/16.
 */
public class OracleSQLDataFileTempFileSpec extends AbstractOracleSQLExpr implements OracleSQLFileSpecification {


    public SQLExpr fileName;

    public OracleSQLSizeClause sizeClause;

    public boolean reuse = false;

    public OracleSQLAutoExtendClause autoextendClause;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, fileName);
            this.acceptChild(visitor, sizeClause);
            this.acceptChild(visitor, autoextendClause);
        }
    }

    @Override
    public OracleSQLDataFileTempFileSpec clone() {
        OracleSQLDataFileTempFileSpec x = new OracleSQLDataFileTempFileSpec();
        this.cloneTo(x);
        return x;
    }

    public SQLExpr getFileName() {
        return fileName;
    }

    public void setFileName(SQLExpr fileName) {
        setChildParent(fileName);
        this.fileName = fileName;
    }

    public OracleSQLSizeClause getSizeClause() {
        return sizeClause;
    }

    public void setSizeClause(OracleSQLSizeClause sizeClause) {
        setChildParent(sizeClause);
        this.sizeClause = sizeClause;
    }

    public boolean isReuse() {
        return reuse;
    }

    public void setReuse(boolean reuse) {
        this.reuse = reuse;
    }

    public OracleSQLAutoExtendClause getAutoextendClause() {
        return autoextendClause;
    }

    public void setAutoextendClause(OracleSQLAutoExtendClause autoextendClause) {
        setChildParent(autoextendClause);
        this.autoextendClause = autoextendClause;
    }
}
