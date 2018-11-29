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
package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.OracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/lnpls/call-specification.html#GUID-C5F117AE-E9A2-499B-BA6A-35D072575BAD
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/call-specification.html#GUID-C5F117AE-E9A2-499B-BA6A-35D072575BAD
 *
 * @author kongtong.ouyang onCondition 2018/3/22.
 */
public interface OracleSQLCallSpec extends OracleSQLExpr {

    @Override
    OracleSQLCallSpec clone();

    class OracleSQLJavaDeclaration extends AbstractOracleSQLExpr implements OracleSQLCallSpec {

        private SQLName name;

        public OracleSQLJavaDeclaration(SQLName name) {
            setName(name);
        }

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, name);
            }
        }

        @Override
        public OracleSQLJavaDeclaration clone() {

            SQLName nameClone = this.name.clone();

            OracleSQLJavaDeclaration x = new OracleSQLJavaDeclaration(nameClone);

            return x;
        }

        public SQLName getName() {
            return name;
        }

        public void setName(SQLName name) {
            setChildParent(name);
            this.name = name;
        }
    }

    class OracleSQLCDeclaration extends AbstractOracleSQLExpr implements OracleSQLCallSpec {

        private OracleSQLCDeclarationType type;

        private final List<SQLExpr> names = new ArrayList<>();

        private final List<SQLExpr> agentInArguments = new ArrayList<>();

        private boolean withContext;

        private final List<OracleSQLExternalParameter> parameters = new ArrayList<>();


        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, names);
                this.acceptChild(visitor, agentInArguments);
                this.acceptChild(visitor, parameters);
            }
        }

        @Override
        public OracleSQLCDeclaration clone() {
            OracleSQLCDeclaration x = new OracleSQLCDeclaration();

            x.type = this.type;

            for (SQLExpr name : this.names) {
                SQLExpr nameClone = name.clone();
                x.addName(nameClone);
            }

            for (SQLExpr agentInArgument : this.agentInArguments) {
                SQLExpr agentInArgumentClone = agentInArgument.clone();
                x.addAgentInArgument(agentInArgumentClone);
            }

            x.withContext = this.withContext;

            for (OracleSQLExternalParameter parameter : this.parameters) {
                OracleSQLExternalParameter parameterClone = parameter.clone();
                x.addParameter(parameterClone);
            }


            return x;
        }


        public OracleSQLCDeclarationType getType() {
            return type;
        }

        public void setType(OracleSQLCDeclarationType type) {
            this.type = type;
        }

        public List<SQLExpr> getNames() {
            return names;
        }

        public void addName(SQLExpr name) {
            if (name == null) {
                return;
            }
            setChildParent(name);
            this.names.add(name);
        }

        public List<SQLExpr> getAgentInArguments() {
            return agentInArguments;
        }

        public void addAgentInArgument(SQLExpr agentInArgument) {
            if (agentInArgument == null) {
                return;
            }
            setChildParent(agentInArgument);
            this.agentInArguments.add(agentInArgument);
        }

        public boolean isWithContext() {
            return withContext;
        }

        public void setWithContext(boolean withContext) {
            this.withContext = withContext;
        }

        public List<OracleSQLExternalParameter> getParameters() {
            return parameters;
        }

        public void addParameter(OracleSQLExternalParameter parameter) {
            if (parameter == null) {
                return;
            }
            setChildParent(parameter);
            this.parameters.add(parameter);
        }
    }


    enum OracleSQLCDeclarationType {

        LANGUAGE_C(SQLReserved.LANGUAGE_C),
        EXTERNAL(SQLReserved.EXTERNAL),;

        public final SQLReserved name;

        OracleSQLCDeclarationType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }

    /**
     * NAME name
     */
    class LanguageCNameExpr extends AbstractOracleSQLExpr {
        protected SQLExpr name;

        public LanguageCNameExpr(SQLExpr name) {
            setName(name);
        }

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, name);
            }
        }


        public SQLExpr getName() {
            return name;
        }

        public void setName(SQLExpr name) {
            setChildParent(name);
            this.name = name;
        }
    }

    /**
     * LIBRARY lib_name
     */
    class LanguageCLibraryExpr extends AbstractOracleSQLExpr {
        protected SQLExpr name;

        public LanguageCLibraryExpr(SQLExpr name) {
            setName(name);
        }

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, name);
            }
        }


        public SQLExpr getName() {
            return name;
        }

        public void setName(SQLExpr name) {
            setChildParent(name);
            this.name = name;
        }
    }

    interface OracleSQLExternalParameter extends OracleSQLExpr {
        @Override
        OracleSQLExternalParameter clone();
    }

    class OracleSQLContextExternalParameter extends AbstractOracleSQLExpr implements OracleSQLExternalParameter {

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public OracleSQLContextExternalParameter clone() {
            return new OracleSQLContextExternalParameter();
        }
    }

    /**
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/call-specification.html#GUID-C5F117AE-E9A2-499B-BA6A-35D072575BAD
     */
     class OracleSQLSelfExternalParameter extends AbstractOracleSQLExpr implements OracleSQLExternalParameter {

        protected OracleSQLExternalParameterProperty property;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public OracleSQLSelfExternalParameter clone() {
            OracleSQLSelfExternalParameter x= new OracleSQLSelfExternalParameter();
            x.setProperty(this.property);
            return x;
        }

        public OracleSQLExternalParameterProperty getProperty() {
            return property;
        }

        public void setProperty(OracleSQLExternalParameterProperty property) {
            this.property = property;
        }
    }

    /**
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/call-specification.html#GUID-C5F117AE-E9A2-499B-BA6A-35D072575BAD
     */
     class OracleSQLReturnExternalParameter extends AbstractOracleSQLExpr implements OracleSQLExternalParameter {

        protected SQLName name;

        protected OracleSQLExternalParameterProperty property;

        protected boolean byReference;

        protected SQLDataType dataType;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, name);
                this.acceptChild(visitor, dataType);
            }
        }

        @Override
        public OracleSQLReturnExternalParameter clone() {
            OracleSQLReturnExternalParameter x= new OracleSQLReturnExternalParameter();
            x.setProperty(this.property);
            x.setByReference(this.byReference);

            if (this.dataType != null) {
                SQLDataType dataTypeClone = this.dataType.clone();
                x.setDataType(dataTypeClone);
            }

            return x;
        }

        public SQLName getName() {
            return name;
        }

        public void setName(SQLName name) {
            setChildParent(name);
            this.name = name;
        }

        public OracleSQLExternalParameterProperty getProperty() {
            return property;
        }

        public void setProperty(OracleSQLExternalParameterProperty property) {
            this.property = property;
        }

        public boolean isByReference() {
            return byReference;
        }

        public void setByReference(boolean byReference) {
            this.byReference = byReference;
        }

        public SQLDataType getDataType() {
            return dataType;
        }

        public void setDataType(SQLDataType dataType) {
            setChildParent(dataType);
            this.dataType = dataType;
        }
    }


     enum OracleSQLExternalParameterProperty {
        TDO(SQLReserved.TDO),
        INDICATOR(SQLReserved.INDICATOR),
        INDICATOR_STRUCT(SQLReserved.INDICATOR_STRUCT),
        INDICATOR_TDO(SQLReserved.INDICATOR_TDO),
        LENGTH(SQLReserved.LENGTH),
        DURATION(SQLReserved.DURATION),
        MAXLEN(SQLReserved.MAXLEN),
        CHARSETID(SQLReserved.CHARSETID),
        CHARSETFORM(SQLReserved.CHARSETFORM),;

        public final SQLReserved name;

        OracleSQLExternalParameterProperty(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }


}
