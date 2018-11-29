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

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.filespecification.OracleSQLFileSpecification;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * database_logging_clauses
 *
 * LOGFILE [ GROUP integer ] file_specification [, [ GROUP integer ] file_specification ]...
 *
 * https://docs.oracle.com/database/121/SQLRF/statements_5005.htm#i2143359
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-DATABASE.html#GUID-ECE717DF-F116-4151-927C-2E51BB9DD39C
 *
 * @author kongtong.ouyang onCondition 2018/3/16.
 */
public class OracleSQLLogFileClause extends AbstractOracleSQLExpr {

    public final List<SQLItem> items = new ArrayList<>();


    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, items);
        }
    }


    public List<SQLItem> getItems() {
        return items;
    }

    public void addItem(SQLItem item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.items.add(item);
    }

    /**
     * [GROUP integer ] file_specification
     */
    public static class SQLItem extends AbstractOracleSQLExpr {
        protected SQLExpr group;
        protected OracleSQLFileSpecification fileSpecification;
        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, group);
                this.acceptChild(visitor, fileSpecification);
            }
        }

        public SQLExpr getGroup() {
            return group;
        }

        public void setGroup(SQLExpr group) {
            setChildParent(group);
            this.group = group;
        }

        public OracleSQLFileSpecification getFileSpecification() {
            return fileSpecification;
        }

        public void setFileSpecification(OracleSQLFileSpecification fileSpecification) {
            setChildParent(fileSpecification);
            this.fileSpecification = fileSpecification;
        }
    }
}
