package com.aliyun.gumiho.sql.basic.ast.element.function.xml;

import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.function.AbstractSQLFunction;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * XMLSERIALIZE( { DOCUMENT | CONTENT } value_expr [ AS datatype ]
 * [ ENCODING xml_encoding_spec ][ VERSION string_literal ]
 * [ NO INDENT | { INDENT [SIZE = number] } ] [ { HIDE | SHOW } DEFAULTS ])
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/XMLCAST.html#GUID-06563B93-1247-4F0C-B6BE-42DB3B1DB069
 *
 * @author kongtong.ouyang on 2018/5/24.
 */
public class SQLXmlSerializeFunction extends AbstractSQLFunction {

    protected SQLReserved content;
    protected SQLExpr encoding;
    protected SQLExpr version;

    protected SQLReserved indent;
    protected SQLExpr size;

    protected SQLReserved defaults;


    public SQLXmlSerializeFunction() {
        super(SQLReserved.XMLSERIALIZE.ofExpr());
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, arguments);
        }
    }


    public SQLReserved getContent() {
        return content;
    }

    public void setContent(SQLReserved content) {
        this.content = content;
    }

    public SQLExpr getEncoding() {
        return encoding;
    }

    public void setEncoding(SQLExpr encoding) {
        this.encoding = encoding;
    }

    public SQLExpr getVersion() {
        return version;
    }

    public void setVersion(SQLExpr version) {
        this.version = version;
    }

    public SQLReserved getIndent() {
        return indent;
    }

    public void setIndent(SQLReserved indent) {
        this.indent = indent;
    }

    public SQLExpr getSize() {
        return size;
    }

    public void setSize(SQLExpr size) {
        this.size = size;
    }

    public SQLReserved getDefaults() {
        return defaults;
    }

    public void setDefaults(SQLReserved defaults) {
        this.defaults = defaults;
    }
}
