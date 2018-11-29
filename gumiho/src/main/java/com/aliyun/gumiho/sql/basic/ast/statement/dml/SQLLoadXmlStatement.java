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
package com.aliyun.gumiho.sql.basic.ast.statement.dml;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLCharacterSetOptionExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.SQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 *
 * https://dev.mysql.com/doc/refman/8.0/en/load-xml.html
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLLoadXmlStatement extends AbstractSQLStatement implements SQLDMLStatement {

    protected SQLPriority priority;
    protected boolean local;
    protected SQLExpr name;
    protected SQLExpr table;
    protected SQLCharacterSetOptionExpr characterSetExpr;


    public SQLLoadXmlStatement(DBType dbType) {
        super(dbType);
    }


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {

        }
    }


    @Override
    public SQLStatement clone() {
        return null;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.LOAD_XML;
    }




    public enum SQLPriority implements ISQLEnum {
        ;

        @Override
        public SQLReserved getName() {
            return null;
        }
    }
}
