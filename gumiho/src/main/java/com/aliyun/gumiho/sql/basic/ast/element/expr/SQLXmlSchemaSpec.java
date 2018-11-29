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
package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * [ XMLSCHEMA XMLSchema_URL ] ELEMENT { element | XMLSchema_URL # element } [ STORE ALL VARRAYS AS { LOBS | TABLES } ] [ { ALLOW | DISALLOW } NONSCHEMA ] [ { ALLOW | DISALLOW } ANYSCHEMA ]
 * <p>
 * XMLSchema_spec
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang onCondition 2018/3/25.
 */
public class SQLXmlSchemaSpec extends AbstractSQLExpr {

    private SQLExpr xmlSchemaUrl;

    private SQLExpr elementXmlSchemaUrl;

    private SQLExpr element;

//    private OracleSQLStoreAllVarraysAsType storeAllVarraysAsType;

    private SQLAllowType nonschemaType;

    private SQLAllowType anyschemaType;


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, xmlSchemaUrl);
            this.acceptChild(visitor, elementXmlSchemaUrl);
            this.acceptChild(visitor, element);
            this.acceptChild(visitor, xmlSchemaUrl);
        }
    }


    public SQLExpr getXmlSchemaUrl() {
        return xmlSchemaUrl;
    }

    public void setXmlSchemaUrl(SQLExpr xmlSchemaUrl) {
        this.xmlSchemaUrl = xmlSchemaUrl;
    }

    public SQLExpr getElementXmlSchemaUrl() {
        return elementXmlSchemaUrl;
    }

    public void setElementXmlSchemaUrl(SQLExpr elementXmlSchemaUrl) {
        this.elementXmlSchemaUrl = elementXmlSchemaUrl;
    }

    public SQLExpr getElement() {
        return element;
    }

    public void setElement(SQLExpr element) {
        this.element = element;
    }

//    public OracleSQLStoreAllVarraysAsType getStoreAllVarraysAsType() {
//        return storeAllVarraysAsType;
//    }
//
//    public void setStoreAllVarraysAsType(OracleSQLStoreAllVarraysAsType storeAllVarraysAsType) {
//        this.storeAllVarraysAsType = storeAllVarraysAsType;
//    }

    public SQLAllowType getNonschemaType() {
        return nonschemaType;
    }

    public void setNonschemaType(SQLAllowType nonschemaType) {
        this.nonschemaType = nonschemaType;
    }

    public SQLAllowType getAnyschemaType() {
        return anyschemaType;
    }

    public void setAnyschemaType(SQLAllowType anyschemaType) {
        this.anyschemaType = anyschemaType;
    }

    public enum SQLAllowType implements ISQLEnum {
        ALLOW(SQLReserved.ALLOW),
        DISALLOW(SQLReserved.DISALLOW);

        public final SQLReserved name;

        SQLAllowType(SQLReserved name) {
            this.name = name;
        }


        @Override
        public SQLReserved getName() {
            return name;
        }
    }

}
