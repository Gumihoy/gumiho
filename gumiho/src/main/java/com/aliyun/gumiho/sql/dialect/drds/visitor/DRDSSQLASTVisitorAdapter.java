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
package com.aliyun.gumiho.sql.dialect.drds.visitor;

import com.aliyun.gumiho.sql.dialect.drds.ast.element.expr.table.partition.*;
import com.aliyun.gumiho.sql.dialect.mysql.visitor.MySQLSQLASTVisitorAdapter;

/**
 * @author kongtong.ouyang onCondition 2018/2/8.
 */
public class DRDSSQLASTVisitorAdapter extends MySQLSQLASTVisitorAdapter implements DRDSSQLASTVisitor {

    // ------------------ Table Details Start ----------------------

    @Override
    public boolean visit(DRDSSQLDBPartitionByHash x) {
        return true;
    }

    @Override
    public boolean visit(DRDSSQLDBPartitionByRangeHash x) {
        return true;
    }

    @Override
    public boolean visit(DRDSSQLTBPartitionByHash x) {
        return true;
    }

    @Override
    public boolean visit(DRDSSQLTBPartitionByRangeHash x) {
        return true;
    }

    @Override
    public boolean visit(DRDSSQLTBPartitionByMM x) {
        return true;
    }

    @Override
    public boolean visit(DRDSSQLTBPartitionByDD x) {
        return true;
    }

    @Override
    public boolean visit(DRDSSQLTBPartitionByWeek x) {
        return true;
    }

    @Override
    public boolean visit(DRDSSQLTBPartitionByMMDD x) {
        return true;
    }

    // ------------------ Table Details End ----------------------
}
