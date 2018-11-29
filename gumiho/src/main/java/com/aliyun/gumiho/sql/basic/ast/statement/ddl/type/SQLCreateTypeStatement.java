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
package com.aliyun.gumiho.sql.basic.ast.statement.ddl.type;


import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.sub.SQLObjectSubDataType;
import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLCollationExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLSharingClause;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLASType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLEditionAbleType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLCreateStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.ArrayList;
import java.util.List;

/**
 * CREATE TYPE name [ <subtype clause> ] [AS dataType]
 * <p>
 * [options]
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#user-defined%20type%20definition
 * <p>
 * <p>
 * CREATE [OR REPLACE] [ EDITIONABLE | NONEDITIONABLE ] TYPE
 * [ schema. ] type_name [ FORCE ] [ OID 'object_identifier' ]
 * [ sharing_clause ] [ default_collation_clause ] { [ invoker_rights_clause ] |  [ accessible_by_clause ] }...
 * { object_base_type_def | object_subtype_def } ;
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/CREATE-TYPE-statement.html#GUID-389D603D-FBD0-452A-8414-240BBBC57034
 * <p>
 * https://www.postgresql.org/docs/10/static/sql-createtype.html
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLCreateTypeStatement extends AbstractSQLStatement implements SQLCreateStatement {

    protected boolean orReplace = false;

    protected SQLEditionAbleType editionAbleType;

    protected SQLName name;

    protected boolean force;

    protected SQLExpr oidLiteral;

    protected SQLSharingClause sharingClause;

    protected SQLCollationExpr collationExpr;

    protected final List<SQLExpr> properties = new ArrayList<>();

    protected SQLObjectSubDataType objectSubDataType;

    protected SQLASType as;

    protected SQLDataType asDataType;

    protected SQLExternalNameClause externalNameClause;

    protected final List<SQLExpr> attributeDefinitions = new ArrayList<>();

    protected final List<SQLExpr> options = new ArrayList<>();


    public SQLCreateTypeStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, oidLiteral);
            this.acceptChild(visitor, sharingClause);
            this.acceptChild(visitor, collationExpr);
            this.acceptChild(visitor, properties);
            this.acceptChild(visitor, objectSubDataType);
            this.acceptChild(visitor, asDataType);
            this.acceptChild(visitor, attributeDefinitions);
            this.acceptChild(visitor, options);
        }
    }

    @Override
    public SQLCreateTypeStatement clone() {
        SQLCreateTypeStatement x = new SQLCreateTypeStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLCreateTypeStatement x) {
        super.cloneTo(x);

        x.orReplace = this.orReplace;
        x.editionAbleType = this.editionAbleType;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name) {
            this.setName((SQLName) target);
            return true;
        }

        if (source == oidLiteral) {
            this.setOidLiteral(target);
            return true;
        }

        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.CREATE_TYPE;
    }


    public boolean isOrReplace() {
        return orReplace;
    }

    public void setOrReplace(boolean orReplace) {
        this.orReplace = orReplace;
    }

    public SQLEditionAbleType getEditionAbleType() {
        return editionAbleType;
    }

    public void setEditionAbleType(SQLEditionAbleType editionAbleType) {
        this.editionAbleType = editionAbleType;
    }

    public SQLName getName() {
        return name;
    }

    public String getTypeName() {
        return name.getName();
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }

    public boolean isForce() {
        return force;
    }

    public void setForce(boolean force) {
        this.force = force;
    }

    public SQLExpr getOidLiteral() {
        return oidLiteral;
    }

    public void setOidLiteral(SQLExpr oidLiteral) {
        setChildParent(oidLiteral);
        this.oidLiteral = oidLiteral;
    }

    public SQLSharingClause getSharingClause() {
        return sharingClause;
    }

    public void setSharingClause(SQLSharingClause sharingClause) {
        setChildParent(sharingClause);
        this.sharingClause = sharingClause;
    }

    public SQLCollationExpr getCollationExpr() {
        return collationExpr;
    }

    public void setCollationExpr(SQLCollationExpr collationExpr) {
        setChildParent(collationExpr);
        this.collationExpr = collationExpr;
    }

    public List<SQLExpr> getProperties() {
        return properties;
    }

    public void addProperty(SQLExpr property) {
        if (property == null) {
            return;
        }
        setChildParent(property);
        this.properties.add(property);
    }

    public SQLObjectSubDataType getObjectSubDataType() {
        return objectSubDataType;
    }

    public void setObjectSubDataType(SQLObjectSubDataType objectSubDataType) {
        this.objectSubDataType = objectSubDataType;
    }

    public SQLASType getAs() {
        return as;
    }

    public void setAs(SQLASType as) {
        this.as = as;
    }

    public SQLDataType getAsDataType() {
        return asDataType;
    }

    public void setAsDataType(SQLDataType asDataType) {
        this.asDataType = asDataType;
    }

    public SQLExternalNameClause getExternalNameClause() {
        return externalNameClause;
    }

    public void setExternalNameClause(SQLExternalNameClause externalNameClause) {
        setChildParent(externalNameClause);
        this.externalNameClause = externalNameClause;
    }

    public List<SQLExpr> getAttributeDefinitions() {
        return attributeDefinitions;
    }

    public void addAttributeDefinition(SQLExpr attributeDefinition) {
        if (attributeDefinition == null) {
            return;
        }
        setChildParent(attributeDefinition);
        this.attributeDefinitions.add(attributeDefinition);
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


    /**
     * EXTERNAL NAME java_ext_name LANGUAGE JAVA USING (SQLData | CustomDatum | OraData)
     *
     * sqlj_object_type
     * https://docs.oracle.com/cd/B28359_01/appdev.111/b28370/create_type.htm#LNPLS01375
     */
    public static class SQLExternalNameClause extends AbstractSQLExpr {
        protected SQLExpr name;
        protected SQLLanguageJavaUsingType usingType;
        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, name);
            }
        }

        @Override
        public SQLExternalNameClause clone() {
            SQLExternalNameClause x = new SQLExternalNameClause();
            return x;
        }

        public SQLExpr getName() {
            return name;
        }

        public void setName(SQLExpr name) {
            setChildParent(name);
            this.name = name;
        }

        public SQLLanguageJavaUsingType getUsingType() {
            return usingType;
        }

        public void setUsingType(SQLLanguageJavaUsingType usingType) {
            this.usingType = usingType;
        }
    }


    public enum SQLLanguageJavaUsingType implements ISQLEnum {
        SQLData(SQLReserved.SQLData),
        CustomDatum(SQLReserved.CustomDatum),
        OraData(SQLReserved.OraData),;

        public final SQLReserved name;

        SQLLanguageJavaUsingType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }

        @Override
        public SQLReserved getName() {
            return name;
        }
    }
}
