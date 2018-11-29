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
package com.aliyun.gumiho.sql.translate.result;

/**
 * @author kongtong.ouyang onCondition 2018/2/8.
 */
public class SQLTransformChange extends SQLTransformIssue {
    protected String to;
    protected SQLTransformChangeType type;

    public SQLTransformChange(String src, String to, SQLTransformChangeType type) {
        super(src, type.desc);
        this.to = to;
        this.type = type;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static class SQLDataType extends SQLTransformChange {

        public SQLDataType(String src, String to) {
            super(src, to, null);
        }

        public SQLDataType(String src, String desc, SQLTransformChangeType type) {
            super(src, desc, type);
        }
    }

    public static class SQLColumn extends SQLTransformChange {

        public SQLColumn(String src, String to) {
            super(src, to, null);
        }

        public SQLColumn(String src, String desc, SQLTransformChangeType type) {
            super(src, desc, type);
        }
    }

}
