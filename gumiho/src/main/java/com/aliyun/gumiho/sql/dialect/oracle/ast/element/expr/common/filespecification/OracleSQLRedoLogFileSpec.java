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

import java.util.ArrayList;
import java.util.List;

/**
 * redo_log_file_spec
 * <p>
 * https://docs.oracle.com/database/121/SQLRF/clauses004.htm#SQLRF01602
 *
 * @author kongtong.ouyang onCondition 2018/3/16.
 */
public class OracleSQLRedoLogFileSpec extends AbstractOracleSQLExpr implements OracleSQLFileSpecification {


    public boolean paren = false;

    public List<SQLExpr> fileNames = new ArrayList<>();

    public OracleSQLSizeClause size;

    public OracleSQLSizeClause blockSize;

    public boolean reuse = false;


    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, fileNames);
            this.acceptChild(visitor, size);
            this.acceptChild(visitor, blockSize);
        }
    }

    @Override
    public OracleSQLRedoLogFileSpec clone() {
        OracleSQLRedoLogFileSpec x = new OracleSQLRedoLogFileSpec();
        return x;
    }


    public boolean isParen() {
        return paren;
    }

    public void setParen(boolean paren) {
        this.paren = paren;
    }

    public List<SQLExpr> getFileNames() {
        return fileNames;
    }

    public void setFileNames(List<SQLExpr> fileNames) {
        this.fileNames = fileNames;
    }

    public OracleSQLSizeClause getSize() {
        return size;
    }

    public void setSize(OracleSQLSizeClause size) {
        this.size = size;
    }

    public OracleSQLSizeClause getBlockSize() {
        return blockSize;
    }

    public void setBlockSize(OracleSQLSizeClause blockSize) {
        this.blockSize = blockSize;
    }

    public boolean isReuse() {
        return reuse;
    }

    public void setReuse(boolean reuse) {
        this.reuse = reuse;
    }
}
