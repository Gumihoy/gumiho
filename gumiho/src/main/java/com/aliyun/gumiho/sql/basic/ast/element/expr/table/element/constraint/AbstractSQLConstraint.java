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
package com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.option.ISQLConstraintOption;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;

import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/constraint.html#GUID-1055EA97-BA6F-4764-A15F-1024FD5B6DFE
 *
 * @author kongtong.ouyang onCondition 2018/3/13.
 */
public abstract class AbstractSQLConstraint extends AbstractSQLExpr implements SQLConstraint {

    protected boolean constraint;
    protected SQLName name;

    protected final List<SQLExpr> options = new ArrayList<>();


    @Override
    public AbstractSQLConstraint clone() {
        throw new UnsupportedOperationException(this.getClass().getName());
    }

    public void cloneTo(AbstractSQLConstraint x) {
        super.cloneTo(x);

        if (this.name != null) {
            SQLName nameClone = this.name.clone();
            x.setName(nameClone);
        }

        for (SQLExpr option : options) {
            SQLExpr optionClone = option.clone();
            x.addOption(optionClone);
        }
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {

        if (target == null) {
            if (source == name) {
                setName(null);
                return true;
            }

            boolean replace = replaceInList(options, source, null, this);
            if (replace) {
                return true;
            }

            return false;
        }

        if (source == name
                && target instanceof SQLName) {
            setName((SQLName) target);
            return true;
        }

        if (target instanceof ISQLConstraintOption) {
            boolean replace = replaceInList(options, source, (ISQLConstraintOption) target, this);
            if (replace) {
                return true;
            }
        }

        return false;
    }

    public boolean isConstraint() {
        return constraint;
    }

    public void setConstraint(boolean constraint) {
        this.constraint = constraint;
    }

    public SQLName getName() {
        return name;
    }

    public String getConstraintName() {
        if (name != null) {
            return name.getName();
        }
        return null;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
        this.constraint = true;
    }

    public List<SQLExpr> getOptions() {
        return options;
    }

    public void addOption(SQLExpr option) {
        if (option == null) {
            return;
        }
        setChildParent(option);
        this.options.add(option);
    }

    public void addAllOption(List<ISQLConstraintOption> options) {
        if (options == null
                || options.size() == 0) {
            return;
        }
        for (ISQLConstraintOption option : options) {
            setChildParent(option);
        }
        this.options.addAll(options);
    }
}
