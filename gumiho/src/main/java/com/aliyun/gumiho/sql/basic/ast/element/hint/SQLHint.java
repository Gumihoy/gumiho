package com.aliyun.gumiho.sql.basic.ast.element.hint;

import com.aliyun.gumiho.sql.basic.ast.SQLObject;

/**
 * @author kongtong.ouyang on 2018/8/28.
 */
public interface SQLHint extends SQLObject {
    @Override
    SQLHint clone();
}
