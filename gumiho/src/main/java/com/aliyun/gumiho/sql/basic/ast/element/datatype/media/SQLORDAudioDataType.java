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
package com.aliyun.gumiho.sql.basic.ast.element.datatype.media;

import com.aliyun.gumiho.sql.basic.ast.element.datatype.AbstractSQLSysDataType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * ORDAudio
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/Data-Types.html#GUID-A3C0D836-BADB-44E5-A5D4-265BA5968483
 *
 * @author kongtong.ouyang onCondition 2018/3/11.
 */
public class SQLORDAudioDataType extends AbstractSQLSysDataType implements SQLMediaDataType {

    public SQLORDAudioDataType() {
        super(SQLReserved.ORDAudio.ofExpr());
    }

    public SQLORDAudioDataType(boolean sysOwner) {
        super(sysOwner, SQLReserved.ORDAudio.ofExpr());
    }

    @Override
    public void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }
}
