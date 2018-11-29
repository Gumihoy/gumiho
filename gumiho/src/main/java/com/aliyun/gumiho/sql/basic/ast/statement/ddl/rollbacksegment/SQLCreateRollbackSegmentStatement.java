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
package com.aliyun.gumiho.sql.basic.ast.statement.ddl.rollbacksegment;


import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLCreateStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-ROLLBACK-SEGMENT.html#GUID-14AE3104-5B33-4E53-8E6F-6B2F037B52E9
 *
 * @author kongtong.ouyang on 2018/6/23.
 */
public class SQLCreateRollbackSegmentStatement extends AbstractSQLStatement implements SQLCreateStatement {

    protected boolean public_;

    protected SQLName name;

    protected final List<SQLExpr> segmentAttributes = new ArrayList<>();


    public SQLCreateRollbackSegmentStatement(DBType dbType) {
        super(dbType);
    }


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, segmentAttributes);
        }
    }


    @Override
    public SQLCreateRollbackSegmentStatement clone() {
        SQLCreateRollbackSegmentStatement x = new SQLCreateRollbackSegmentStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLCreateRollbackSegmentStatement x) {
        super.cloneTo(x);
    }


    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.CREATE_ROLLBACK_SEGMENT;
    }



    public boolean isPublic_() {
        return public_;
    }

    public void setPublic_(boolean public_) {
        this.public_ = public_;
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        this.name = name;
    }

    public List<SQLExpr> getSegmentAttributes() {
        return segmentAttributes;
    }

    public void addSegmentAttribute(SQLExpr segmentAttribute) {
        if (segmentAttribute == null) {
            return;
        }
        setChildParent(segmentAttribute);
        this.segmentAttributes.add(segmentAttribute);
    }


}
