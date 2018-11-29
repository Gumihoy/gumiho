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
package com.aliyun.gumiho.sql.exception;

/**
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public class SQLParserException extends RuntimeException {

    public SQLParserException() {
    }

    public SQLParserException(String message) {
        super(message);
    }

    public SQLParserException(int line, int col, String message) {
        super("line " + line + ", col " + col + ", " + message);
    }

    public SQLParserException(int line, int col, String message, Throwable cause) {
        super("line " + line + ", col " + col + ", " + message, cause);
    }

}
