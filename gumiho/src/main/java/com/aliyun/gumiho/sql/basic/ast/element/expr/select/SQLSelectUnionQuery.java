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
package com.aliyun.gumiho.sql.basic.ast.element.expr.select;

import com.aliyun.gumiho.sql.basic.ast.SQLReplaceable;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLUnionOperator;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#cursor%20specification
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SELECT.html#GUID-CFA006CA-6FF1-4972-821E-6996142A51C6
 *
 * @author kongtong.ouyang onCondition 2018/3/20.
 */
public class SQLSelectUnionQuery extends AbstractSQLSelectQuery implements ISQLSelectQuery {

    protected ISQLSelectQuery left;

    protected SQLUnionOperator operator = SQLUnionOperator.UNION;

    protected ISQLSelectQuery right;


    public SQLSelectUnionQuery(ISQLSelectQuery left, SQLUnionOperator operator, ISQLSelectQuery right) {
        setLeft(left);
        this.operator = operator;
        setRight(right);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, left);
            this.acceptChild(visitor, right);
            this.acceptChild(visitor, orderByClause);
            this.acceptChild(visitor, limitClause);
        }
    }

    @Override
    public SQLSelectUnionQuery clone() {

        ISQLSelectQuery leftClone = this.left.clone();
        ISQLSelectQuery rightClone = this.right.clone();
        SQLSelectUnionQuery x = new SQLSelectUnionQuery(leftClone, this.operator, rightClone);

        super.cloneTo(x);
        return x;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {

        if (left == source) {
            if (target == null) {
                if (parent instanceof SQLReplaceable) {
                    return ((SQLReplaceable) parent).replace(this, right);
                }
                return false;
            }
            if (target instanceof ISQLSelectQuery) {
                this.setLeft((ISQLSelectQuery) target);
                return true;
            }
            return false;
        }

        if (right == source) {
            if (target == null) {
                if (parent instanceof SQLReplaceable) {
                    return ((SQLReplaceable) parent).replace(this, left);
                }
                return false;
            }
            if (target instanceof ISQLSelectQuery) {
                this.setRight((ISQLSelectQuery) target);
                return true;
            }
            return false;
        }

        return false;
    }

    public ISQLSelectQuery getLeft() {
        return left;
    }

    public void setLeft(ISQLSelectQuery left) {
        setChildParent(left);
        this.left = left;
    }

    public SQLUnionOperator getOperator() {
        return operator;
    }

    public void setOperator(SQLUnionOperator operator) {
        this.operator = operator;
    }

    public ISQLSelectQuery getRight() {
        return right;
    }

    public void setRight(ISQLSelectQuery right) {
        setChildParent(right);
        this.right = right;
    }


}
