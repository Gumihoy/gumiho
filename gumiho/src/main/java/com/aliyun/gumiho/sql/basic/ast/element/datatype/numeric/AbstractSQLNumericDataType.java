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
package com.aliyun.gumiho.sql.basic.ast.element.datatype.numeric;

import com.aliyun.gumiho.sql.basic.ast.element.datatype.AbstractSQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#numeric%20type
 * <p>
 * https://dev.mysql.com/doc/refman/5.7/en/numeric-types.html
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/Data-Types.html#GUID-A3C0D836-BADB-44E5-A5D4-265BA5968483
 *
 * @author kongtong.ouyang onCondition 2018/3/11.
 */
public abstract class AbstractSQLNumericDataType extends AbstractSQLDataType implements ISQLNumericDataType {

    protected boolean unsigned;
    protected boolean zerofill;


    public AbstractSQLNumericDataType(String name) {
        super(name);
    }

    public AbstractSQLNumericDataType(SQLName name) {
        super(name);
    }

    public void cloneTo(ISQLNumericDataType x) {
        super.cloneTo(x);

        x.setUnsigned(unsigned);
        x.setZerofill(zerofill);

    }

    @Override
    public boolean isUnsigned() {
        return unsigned;
    }

    @Override
    public void setUnsigned(boolean unsigned) {
        this.unsigned = unsigned;
    }

    @Override
    public boolean isZerofill() {
        return zerofill;
    }

    @Override
    public void setZerofill(boolean zerofill) {
        this.zerofill = zerofill;
    }
}
