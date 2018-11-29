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
package com.aliyun.gumiho.sql.basic.ast.statement.dml;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLCharacterSetOptionExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLSetOptionExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.element.literal.numeric.SQLIntegerLiteral;
import com.aliyun.gumiho.sql.basic.ast.element.literal.text.SQLCharLiteral;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.SQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.ArrayList;
import java.util.List;

/**
 * https://dev.mysql.com/doc/refman/5.7/en/load-data.html
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLLoadDataStatement extends AbstractSQLStatement implements SQLDMLStatement {

    protected SQLPriority priority;

    protected boolean local;

    protected SQLCharLiteral name;

    //  [REPLACE | IGNORE]
    protected SQLReserved option;

    protected SQLName tableName;

    protected final List<SQLName> partitionNames = new ArrayList<>();

    protected SQLCharacterSetOptionExpr characterSetExpr;


    protected SQLReserved fieldsType;
    // TERMINATED BY 'string'
    protected SQLCharLiteral terminatedBy;

    protected boolean optionally = false;
    // ENCLOSED BY 'char'
    protected SQLCharLiteral enclosedBy;

    // ESCAPED BY 'char'
    protected SQLCharLiteral escapedBy;


    protected boolean lines;
    // STARTING BY 'string'
    protected SQLCharLiteral linesStartingBy;
    // TERMINATED BY 'string'
    protected SQLCharLiteral linesTerminatedBy;


    protected SQLIntegerLiteral ignoreCount;
    // LINES | ROWS
    protected SQLReserved ignoreType;

    protected final List<SQLExpr> colNameOrUserVar = new ArrayList<>();


    protected final List<SQLSetOptionExpr> setElements = new ArrayList<>();

    public SQLLoadDataStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, tableName);
            this.acceptChild(visitor, partitionNames);
            this.acceptChild(visitor, characterSetExpr);
            this.acceptChild(visitor, terminatedBy);
            this.acceptChild(visitor, enclosedBy);
            this.acceptChild(visitor, escapedBy);
            this.acceptChild(visitor, linesStartingBy);
            this.acceptChild(visitor, linesTerminatedBy);
            this.acceptChild(visitor, ignoreCount);
            this.acceptChild(visitor, colNameOrUserVar);
            this.acceptChild(visitor, setElements);
        }
    }


    @Override
    public SQLStatement clone() {
        return null;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.LOAD_DATA;
    }



    public SQLPriority getPriority() {
        return priority;
    }

    public void setPriority(SQLPriority priority) {
        this.priority = priority;
    }

    public boolean isLocal() {
        return local;
    }

    public void setLocal(boolean local) {
        this.local = local;
    }

    public SQLCharLiteral getName() {
        return name;
    }

    public void setName(SQLCharLiteral name) {
        setChildParent(name);
        this.name = name;
    }

    public SQLReserved getOption() {
        return option;
    }

    public void setOption(SQLReserved option) {
        this.option = option;
    }

    public SQLName getTableName() {
        return tableName;
    }

    public void setTableName(SQLName tableName) {
        setChildParent(tableName);
        this.tableName = tableName;
    }

    public List<SQLName> getPartitionNames() {
        return partitionNames;
    }

    public void addPartitionName(SQLName partitionName) {
        if (partitionName == null) {
            return;
        }
        setChildParent(partitionName);
        this.partitionNames.add(partitionName);
    }

    public SQLCharacterSetOptionExpr getCharacterSetExpr() {
        return characterSetExpr;
    }

    public void setCharacterSetExpr(SQLCharacterSetOptionExpr characterSetExpr) {
        setChildParent(characterSetExpr);
        this.characterSetExpr = characterSetExpr;
    }

    public SQLReserved getFieldsType() {
        return fieldsType;
    }

    public void setFieldsType(SQLReserved fieldsType) {
        this.fieldsType = fieldsType;
    }

    public SQLCharLiteral getTerminatedBy() {
        return terminatedBy;
    }

    public void setTerminatedBy(SQLCharLiteral terminatedBy) {
        setChildParent(terminatedBy);
        this.terminatedBy = terminatedBy;
    }

    public boolean isOptionally() {
        return optionally;
    }

    public void setOptionally(boolean optionally) {
        this.optionally = optionally;
    }

    public SQLCharLiteral getEnclosedBy() {
        return enclosedBy;
    }

    public void setEnclosedBy(SQLCharLiteral enclosedBy) {
        setChildParent(enclosedBy);
        this.enclosedBy = enclosedBy;
    }

    public SQLCharLiteral getEscapedBy() {
        return escapedBy;
    }

    public void setEscapedBy(SQLCharLiteral escapedBy) {
        setChildParent(escapedBy);
        this.escapedBy = escapedBy;
    }

    public boolean isLines() {
        return lines;
    }

    public void setLines(boolean lines) {
        this.lines = lines;
    }

    public SQLCharLiteral getLinesStartingBy() {
        return linesStartingBy;
    }

    public void setLinesStartingBy(SQLCharLiteral linesStartingBy) {
        setChildParent(linesStartingBy);
        this.linesStartingBy = linesStartingBy;
    }

    public SQLCharLiteral getLinesTerminatedBy() {
        return linesTerminatedBy;
    }

    public void setLinesTerminatedBy(SQLCharLiteral linesTerminatedBy) {
        setChildParent(linesTerminatedBy);
        this.linesTerminatedBy = linesTerminatedBy;
    }

    public SQLIntegerLiteral getIgnoreCount() {
        return ignoreCount;
    }

    public void setIgnoreCount(SQLIntegerLiteral ignoreCount) {
        setChildParent(ignoreCount);
        this.ignoreCount = ignoreCount;
    }

    public SQLReserved getIgnoreType() {
        return ignoreType;
    }

    public void setIgnoreType(SQLReserved ignoreType) {
        this.ignoreType = ignoreType;
    }

    public List<SQLExpr> getColNameOrUserVar() {
        return colNameOrUserVar;
    }

    public void addColNameOrUserVar(SQLExpr colNameOrUserVar) {
        if (colNameOrUserVar == null) {
            return;
        }
        setChildParent(colNameOrUserVar);
        this.colNameOrUserVar.add(colNameOrUserVar);
    }

    public List<SQLSetOptionExpr> getSetElements() {
        return setElements;
    }

    public void addSetElement(SQLSetOptionExpr setElementExpr) {
        if (setElementExpr == null) {
            return;
        }
        setChildParent(setElementExpr);
        this.setElements.add(setElementExpr);
    }


    /**
     * https://dev.mysql.com/doc/refman/8.0/en/load-data.html
     */
    public enum SQLPriority implements ISQLEnum {
        LOW_PRIORITY(SQLReserved.LOW_PRIORITY),
        CONCURRENT(SQLReserved.CONCURRENT),;
        public final SQLReserved name;

        SQLPriority(SQLReserved name) {
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
