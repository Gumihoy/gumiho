
package com.aliyun.gumiho.sql.basic.ast;




import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;

import java.util.List;

public interface SQLReplaceable {

    boolean replace(SQLExpr source, SQLExpr target);

    default <T extends SQLExpr> boolean replaceInList(List<T> exprList, SQLExpr source, T target, SQLObject parent) {
        if (exprList == null) {
            return false;
        }

        if (target == null) {
            for (int i = exprList.size() - 1; i >= 0; i--) {
                if (source == exprList.get(i)) {
                    exprList.remove(i);
                    return true;
                }
            }
            return false;
        }

        for (int i = 0; i < exprList.size(); i++) {
            if (exprList.get(i) == source) {
                target.setParent(parent);
                exprList.set(i, target);
                return true;
            }
        }
        return false;
    }
}
