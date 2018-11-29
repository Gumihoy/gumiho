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
package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.table;

import com.aliyun.gumiho.sql.basic.ast.element.expr.ISQLLobParameter;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLBasicFileType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.OracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.enums.OracleSQLStoreAllVarraysAsType;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * STORE AS OBJECT RELATIONAL
 * | STORE AS basicFileType? CLOB segName=expr? (LEFT_PAREN lobParameter* RIGHT_PAREN)?
 * | STORE AS basicFileType? BINARY XML segName=expr? (LEFT_PAREN lobParameter* RIGHT_PAREN)?
 * | STORE AS ALL VARRAYS AS (LOBS | TABLES)
 *
 * XMLType_storage
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang onCondition 2018/3/25.
 */
public interface OracleSQLXmlTypeStorage extends OracleSQLExpr {


    /**
     * STORE AS OBJECT RELATIONAL
     */
    class OracleSQLXmlTypeStorageAsObjectRelational extends AbstractOracleSQLExpr implements OracleSQLXmlTypeStorage {
        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public OracleSQLXmlTypeStorageAsObjectRelational clone() {
            return new OracleSQLXmlTypeStorageAsObjectRelational();
        }
    }

    /**
     * STORE AS basicFileType? CLOB segName=expr? (LEFT_PAREN lobParameter* RIGHT_PAREN)?
     */
    class OracleSQLXmlTypeStorageAsClob extends AbstractOracleSQLExpr implements OracleSQLXmlTypeStorage {

        protected SQLBasicFileType fileType;
        protected SQLExpr lobSegName;
        // LOB_parameters
        protected final List<ISQLLobParameter> parameters = new ArrayList<>();


        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, lobSegName);
                this.acceptChild(visitor, parameters);
            }
        }

        public SQLBasicFileType getFileType() {
            return fileType;
        }

        public void setFileType(SQLBasicFileType fileType) {
            this.fileType = fileType;
        }

        public SQLExpr getLobSegName() {
            return lobSegName;
        }

        public void setLobSegName(SQLExpr lobSegName) {
            setChildParent(lobSegName);
            this.lobSegName = lobSegName;
        }

        public List<ISQLLobParameter> getParameters() {
            return parameters;
        }
        public void addParameter(ISQLLobParameter parameter) {
            if (parameter == null) {
                return;
            }
            setChildParent(parameter);
            this.parameters.add(parameter);
        }
    }


    /**
     * STORE AS basicFileType? BINARY XMl segName=expr? (LEFT_PAREN lobParameter* RIGHT_PAREN)?
     */
    class OracleSQLXmlTypeStorageAsBinaryXml extends AbstractOracleSQLExpr implements OracleSQLXmlTypeStorage {

        protected SQLBasicFileType fileType;
        protected SQLExpr lobSegName;
        // LOB_parameters
        protected final List<ISQLLobParameter> parameters = new ArrayList<>();


        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, lobSegName);
                this.acceptChild(visitor, parameters);
            }
        }
        public SQLBasicFileType getFileType() {
            return fileType;
        }

        public void setFileType(SQLBasicFileType fileType) {
            this.fileType = fileType;
        }

        public SQLExpr getLobSegName() {
            return lobSegName;
        }

        public void setLobSegName(SQLExpr lobSegName) {
            setChildParent(lobSegName);
            this.lobSegName = lobSegName;
        }

        public List<ISQLLobParameter> getParameters() {
            return parameters;
        }
        public void addParameter(ISQLLobParameter parameter) {
            if (parameter == null) {
                return;
            }
            setChildParent(parameter);
            this.parameters.add(parameter);
        }
    }


    /**
     * STORE AS ALL VARRAYS AS (LOBS | TABLES)
     */
    class OracleSQLXmlTypeStorageAsAllVarrays extends AbstractOracleSQLExpr implements OracleSQLXmlTypeStorage {

        private OracleSQLStoreAllVarraysAsType type;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            visitor.visit(this);
        }

        public OracleSQLStoreAllVarraysAsType getType() {
            return type;
        }

        public void setType(OracleSQLStoreAllVarraysAsType type) {
            this.type = type;
        }
    }


    enum LobCacheType implements ISQLEnum {

        CACHE(SQLReserved.CACHE),
        NOCACHE(SQLReserved.NOCACHE),
        CACHE_READS(SQLReserved.CACHE_READS);

        public final SQLReserved name;

        LobCacheType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public SQLReserved getName() {
            return name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }

}
