package com.aliyun.gumiho.sql.translate.visitor;

import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLDoubleQuoteIdentifier;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLIdentifierImpl;
import com.aliyun.gumiho.sql.util.SQLUtils;

/**
 * Remove Double Quotes
 *
 * @author kongtong.ouyang on 2018/5/18.
 */
public class SQLRemoveDoubleQuotesASTVisitor extends SQLASTTransformVisitor {

    @Override
    public boolean visit(SQLDoubleQuoteIdentifier x) {
        SQLIdentifierImpl target = new SQLIdentifierImpl(x.getName());
        boolean replaceInParent = SQLUtils.replaceInParent(x, target);
        return true;
    }
}
