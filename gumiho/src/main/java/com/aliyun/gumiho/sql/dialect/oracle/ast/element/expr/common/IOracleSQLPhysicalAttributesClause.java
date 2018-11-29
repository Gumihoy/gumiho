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

import com.aliyun.gumiho.sql.basic.ast.element.expr.ISQLSegmentAttributesClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.index.attribute.ISQLIndexAttribute;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.OracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * physical_attributes_clause
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang onCondition 2018/3/16.
 */
public interface IOracleSQLPhysicalAttributesClause extends OracleSQLExpr, ISQLSegmentAttributesClause, ISQLIndexAttribute {
    @Override
    IOracleSQLPhysicalAttributesClause clone();

    /**
     * USAGE QUEUE
     */
    class OracleSQLUsageQueueClause extends AbstractOracleSQLExpr implements IOracleSQLPhysicalAttributesClause {
        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public OracleSQLUsageQueueClause clone() {
            return new OracleSQLUsageQueueClause();
        }
    }

    /**
     * PCTFREE integer
     * <p>
     * physical_attributes_clause
     * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
     *
     * @author kongtong.ouyang onCondition 2018/3/16.
     */
    class OracleSQLPctfreeClause extends AbstractOracleSQLExpr implements IOracleSQLPhysicalAttributesClause {

        protected SQLExpr value;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, value);
            }
        }

        @Override
        public OracleSQLPctfreeClause clone() {
            OracleSQLPctfreeClause x = new OracleSQLPctfreeClause();
            SQLExpr valueClone = this.value.clone();
            x.setValue(valueClone);
            return x;
        }

        public SQLExpr getValue() {
            return value;
        }

        public void setValue(SQLExpr value) {
            setChildParent(value);
            this.value = value;
        }
    }


    /**
     * PCTUSED integer
     * <p>
     * physical_attributes_clause
     * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
     *
     * @author kongtong.ouyang onCondition 2018/3/16.
     */
    class OracleSQLPctusedClause extends AbstractOracleSQLExpr implements IOracleSQLPhysicalAttributesClause {

        protected SQLExpr value;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, value);
            }
        }

        @Override
        public OracleSQLPctusedClause clone() {
            OracleSQLPctusedClause x = new OracleSQLPctusedClause();
            SQLExpr valueClone = this.value.clone();
            x.setValue(valueClone);
            return x;
        }

        public SQLExpr getValue() {
            return value;
        }

        public void setValue(SQLExpr value) {
            setChildParent(value);
            this.value = value;
        }
    }


    /**
     * INITRANS integer
     * <p>
     * physical_attributes_clause
     * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
     *
     * @author kongtong.ouyang onCondition 2018/3/16.
     */
    class OracleSQLInitransClause extends AbstractOracleSQLExpr implements IOracleSQLPhysicalAttributesClause {

        protected SQLExpr value;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, value);
            }
        }

        @Override
        public OracleSQLInitransClause clone() {
            OracleSQLInitransClause x = new OracleSQLInitransClause();
            SQLExpr valueClone = this.value.clone();
            x.setValue(valueClone);
            return x;
        }

        public SQLExpr getValue() {
            return value;
        }

        public void setValue(SQLExpr value) {
            setChildParent(value);
            this.value = value;
        }
    }

    /**
     * MAXTRANS integer
     * <p>
     * physical_attributes_clause
     * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
     *
     * @author kongtong.ouyang onCondition 2018/3/16.
     */
    class OracleSQLMaxTransClause extends AbstractOracleSQLExpr implements IOracleSQLPhysicalAttributesClause {

        protected SQLExpr value;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, value);
            }
        }

        @Override
        public OracleSQLMaxTransClause clone() {
            OracleSQLMaxTransClause x = new OracleSQLMaxTransClause();
            SQLExpr valueClone = this.value.clone();
            x.setValue(valueClone);
            return x;
        }

        public SQLExpr getValue() {
            return value;
        }

        public void setValue(SQLExpr value) {
            setChildParent(value);
            this.value = value;
        }
    }
}
