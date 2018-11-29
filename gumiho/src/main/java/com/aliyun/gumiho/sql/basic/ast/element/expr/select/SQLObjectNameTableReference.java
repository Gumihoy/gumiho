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

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.hint.SQLIndexHint;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLIdentifier;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLPropertyExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.hash.FNVHash;
import com.aliyun.gumiho.sql.util.SQLUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <tableName> option [ [ AS ] <correlation name> [ <left paren> <derived column list> <right paren> ] [ <sample clause> ]
 * [ONLY] (  )
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#table%20primary
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#table%20reference
 * <p>
 * tbl_name [PARTITION (partition_names)] [[AS] alias] [index_hint_list]
 * https://dev.mysql.com/doc/refman/5.7/en/join.html
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SELECT.html#GUID-CFA006CA-6FF1-4972-821E-6996142A51C6
 *
 * @author kongtong.ouyang onCondition 2018/3/20.
 */
public class SQLObjectNameTableReference extends AbstractSQLTableReference {

    protected boolean only;

    protected SQLName name;

    protected SQLExpr option;

    protected final List<SQLIndexHint> indexHints = new ArrayList<>();


    public SQLObjectNameTableReference() {
    }

    public SQLObjectNameTableReference(String name) {
        setName(SQLUtils.ofName(name));
    }

    public SQLObjectNameTableReference(SQLName name) {
        setName(name);
    }

    public SQLObjectNameTableReference(String name, String alias) {
        setName(SQLUtils.ofName(name));
        setAlias(SQLUtils.ofName(alias));
    }

    public SQLObjectNameTableReference(String name, boolean as, String alias) {
        setName(SQLUtils.ofName(name));
        setAs(as);
        setAlias(SQLUtils.ofName(alias));
    }

    public SQLObjectNameTableReference(SQLName name, SQLIdentifier alias) {
        setName(name);
        setAlias(alias);
    }

    public static final SQLObjectNameTableReference of(String name) {
        return new SQLObjectNameTableReference(name);
    }

    public static final SQLObjectNameTableReference of(String name, String alias) {
        return of(name, false, alias);
    }

    public static final SQLObjectNameTableReference of(String name, boolean as, String alias) {
        return new SQLObjectNameTableReference(name, as, alias);
    }

    public static final SQLObjectNameTableReference of(SQLName name) {
        return new SQLObjectNameTableReference(name);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, option);
            this.acceptChild(visitor, alias);
            this.acceptChild(visitor, columns);
            this.acceptChild(visitor, indexHints);
        }
    }

    @Override
    public SQLObjectNameTableReference clone() {
        SQLName nameClone = this.name.clone();
        SQLObjectNameTableReference x = new SQLObjectNameTableReference(nameClone);

        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLObjectNameTableReference x) {
        super.cloneTo(x);
        x.only = this.only;
        SQLName nameClone = this.name.clone();
        x.setName(nameClone);

        if (this.option != null) {
            SQLExpr optionClone = option.clone();
            x.setOption(optionClone);
        }

        for (SQLIndexHint indexHint : indexHints) {
            SQLIndexHint indexHintClone = indexHint.clone();
            x.addIndexHint(indexHintClone);
        }
    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        boolean replace = super.replace(source, target);
        if (replace) {
            return true;
        }

        if (source == name
                && target instanceof SQLName) {
            setName((SQLName) target);
            return true;
        }

        return false;
    }


    @Override
    public SQLName computeAlias() {
        SQLName computeAlias = getAlias();
        if (computeAlias == null) {
            computeAlias = SQLUtils.ofName(name.getName());
        }
        return computeAlias;
    }

    @Override
    public boolean containsAlias(String alias) {
        long aliasLowerHash = FNVHash.fnv1a_64_lower(alias);
        return containsAlias(aliasLowerHash);
    }

    @Override
    public boolean containsAlias(long aliasLowerHash) {
        boolean containsAlias = super.containsAlias(aliasLowerHash);
        if (containsAlias) {
            return true;
        }
        if (name == null) {
            return false;
        }
        return name.lowerHash() == aliasLowerHash;
    }

    public boolean isOnly() {
        return only;
    }

    public void setOnly(boolean only) {
        this.only = only;
    }

    public SQLName getName() {
        return name;
    }

    public String getTableName() {
        if (name != null) {
            return name.getName();
        }
        return null;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }

    public void setName(String name) {
        if (name == null) {
            return;
        }
        setName(SQLUtils.ofName(name));
    }

    public void setName(String owner, String tableName) {
        if (tableName == null) {
            return;
        }
        SQLName name;
        if (owner == null) {
            name = SQLUtils.ofName(tableName);
        } else {
            name = new SQLPropertyExpr(owner, tableName);
        }
        setName(name);
    }

    public SQLExpr getOption() {
        return option;
    }

    public void setOption(SQLExpr option) {
        setChildParent(option);
        this.option = option;
    }


    public List<SQLIndexHint> getIndexHints() {
        return indexHints;
    }

    public void addIndexHint(SQLIndexHint indexHint) {
        if (indexHint == null) {
            return;
        }
        setChildParent(indexHint);
        this.indexHints.add(indexHint);
    }

}
