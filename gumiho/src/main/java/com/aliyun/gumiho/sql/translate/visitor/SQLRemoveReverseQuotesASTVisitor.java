package com.aliyun.gumiho.sql.translate.visitor;

import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLIdentifierImpl;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLReverseQuoteIdentifier;
import com.aliyun.gumiho.sql.translate.SQLTransformConfig;
import com.aliyun.gumiho.sql.util.SQLUtils;

/**
 * Remove Reverse visitor
 * 移除 反引号(`)
 *
 * @author kongtong.ouyang on 2018/5/18.
 */
public class SQLRemoveReverseQuotesASTVisitor extends SQLASTTransformVisitor {

    public SQLRemoveReverseQuotesASTVisitor() {
    }

    public SQLRemoveReverseQuotesASTVisitor(SQLTransformConfig config) {
        super(config);
    }

    @Override
    public boolean visit(SQLReverseQuoteIdentifier x) {
        SQLIdentifierImpl target = new SQLIdentifierImpl(x.getName());
        SQLUtils.replaceInParent(x, target);
        return false;
    }
}
