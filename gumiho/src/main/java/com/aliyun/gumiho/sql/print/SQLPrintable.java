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
package com.aliyun.gumiho.sql.print;

import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;

import java.util.Date;
import java.util.List;

/**
 * @author kongtong.ouyang onCondition 2018/3/7.
 */
public interface SQLPrintable {

    boolean isLowerCase();

    void print(char value);

    void print(int value);

    void print(long value);

    void print(float value);

    void print(double value);

    void print(Date value);

    void print(CharSequence value);

    void print(SQLReserved value);

    void print(ISQLEnum value);

    void print(List<? extends ISQLEnum> values, String separator);

    void print(SQLObject value);

    void printAccept(List<? extends SQLObject> values, String separator);

    void printAccept(List<? extends SQLObject> values, String separator, boolean paren);


    void printSpace();

    void printSpaceAfterValue(CharSequence value);

    void printSpaceAfterValue(SQLReserved value);

    void printSpaceAfterValue(ISQLEnum value);

    void printSpaceAfterValue(List<? extends ISQLEnum> values, String separator);

    void printSpaceAfterAccept(SQLObject value);

    void printSpaceAfterAccept(List<? extends SQLObject> values, String separator);



    void println();

    void printlnAfterValue(CharSequence value);

    void printlnAfterValue(SQLReserved value);

    void printlnAfterValue(ISQLEnum value);
    void printlnAfterValue(List<? extends ISQLEnum> values);
    void printlnAfterValue(List<? extends ISQLEnum> values, String separator, boolean paren);


    void printlnAndAccept(SQLObject value);

    void printlnAndAccept(List<? extends SQLObject> values);

    void printlnAndAccept(List<? extends SQLObject> values, String separator);

    void printlnAndAccept(List<? extends SQLObject> values, String separator, boolean paren);



    void printSpaceAndLnAfterValue(List<? extends ISQLEnum> values, String separator, boolean paren);

    void printIndent();
}
