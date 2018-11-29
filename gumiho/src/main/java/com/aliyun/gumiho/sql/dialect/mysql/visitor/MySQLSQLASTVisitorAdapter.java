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
package com.aliyun.gumiho.sql.dialect.mysql.visitor;


import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitorAdapter;
import com.aliyun.gumiho.sql.dialect.mysql.ast.element.expr.MySQLSQLMatchExpr;
import com.aliyun.gumiho.sql.dialect.mysql.ast.element.expr.select.MySQLSQLOJTableReference;
import com.aliyun.gumiho.sql.dialect.mysql.ast.element.expr.select.MySQLSQLSelectQuery;
import com.aliyun.gumiho.sql.dialect.mysql.ast.statement.utility.MySQLSQLHelpStatement;
import com.aliyun.gumiho.sql.translate.SQLTransformConfig;
import com.aliyun.gumiho.sql.translate.result.SQLTransformChange;
import com.aliyun.gumiho.sql.translate.result.SQLTransformError;
import com.aliyun.gumiho.sql.translate.result.SQLTransformWarnning;

import java.util.LinkedHashSet;
import java.util.Set;

public class MySQLSQLASTVisitorAdapter extends SQLASTVisitorAdapter implements MySQLSQLASTVisitor {




    @Override
    public boolean visit(MySQLSQLHelpStatement x) {
        return true;
    }

    // ------------------------- Comment Start ----------------------------------------

    // ------------------------- Comment End ----------------------------------------

    // ------------------------- Hint Start ----------------------------------------
    // ------------------------- Hint End ----------------------------------------


    // ------------------------- Commons Expr Start ----------------------------------------
    @Override
    public boolean visit(MySQLSQLMatchExpr x) {
        return true;
    }


    // ------------------------- Commons Expr End ----------------------------------------


    // ------------------ Details ----------------------


    // ------------------ Select Details Start ----------------------

    @Override
    public boolean visit(MySQLSQLSelectQuery x) {
        return true;
    }

    @Override
    public boolean visit(MySQLSQLSelectQuery.MySQLSQLIntoOutFileClause x) {
        return true;
    }

    @Override
    public boolean visit(MySQLSQLSelectQuery.MySQLSQLIntoDumpFileClause x) {
        return true;
    }

    @Override
    public boolean visit(MySQLSQLSelectQuery.MySQLSQLIntoClause x) {
        return true;
    }

    @Override
    public boolean visit(MySQLSQLOJTableReference x) {
        return true;
    }
    // ------------------ Select Details End ----------------------
}
