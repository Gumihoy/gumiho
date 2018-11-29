package com.aliyun.gumiho.sql.translate.result;

/**
 * @author kongtong.ouyang on 2018/7/3.
 */
public abstract class SQLTransformIssue {

    protected final String src;
    protected final String desc;

    public SQLTransformIssue(String src, String desc) {
        this.src = src;
        this.desc = desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SQLTransformIssue that = (SQLTransformIssue) o;

        return src != null ? src.equals(that.src) : that.src == null;
    }

    @Override
    public int hashCode() {
        return src != null ? src.hashCode() : 0;
    }
}
