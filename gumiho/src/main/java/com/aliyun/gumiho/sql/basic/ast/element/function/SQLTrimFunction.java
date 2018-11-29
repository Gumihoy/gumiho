package com.aliyun.gumiho.sql.basic.ast.element.function;

import static com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved.TRIM;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * TRIM([ { { LEADING | TRAILING | BOTH } [ trim_character ] | trim_character } FROM ] trim_source)
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#trim%20operands
 * <p>
 * TRIM([remstr FROM] str)
 * TRIM([{BOTH | LEADING | TRAILING} [remstr] FROM] str)
 * https://dev.mysql.com/doc/refman/8.0/en/string-functions.html#function_trim
 * <p>
 * https://www.postgresql.org/docs/10/static/functions-string.html
 * <p>
 * TRIM([ { { LEADING | TRAILING | BOTH } [ trim_character ]| trim_character}FROM]trim_source)
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/TRIM.html#GUID-00D5C77C-19B1-4894-828F-066746235B03
 *
 * @author kongtong.ouyang on 2018/4/28.
 */
public class SQLTrimFunction extends AbstractSQLFunction {

    protected SQLTrimSpecification specification;
    protected SQLExpr character;

    public SQLTrimFunction() {
        super(TRIM.ofExpr());
    }

    public SQLTrimFunction(SQLExpr argument) {
        super(TRIM.ofExpr());
        this.addArgument(argument);
    }

    public SQLTrimFunction(SQLExpr character, SQLExpr argument) {
        super(TRIM.ofExpr());
        setCharacter(character);
        this.addArgument(argument);
    }

    public SQLTrimFunction(SQLTrimSpecification specification, SQLExpr character, SQLExpr argument) {
        super(TRIM.ofExpr());
        setSpecification(specification);
        setCharacter(character);
        this.addArgument(argument);
    }


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, nameExpr);
            this.acceptChild(visitor, character);
            this.acceptChild(visitor, arguments);
        }
    }


    public SQLTrimSpecification getSpecification() {
        return specification;
    }

    public void setSpecification(SQLTrimSpecification specification) {
        this.specification = specification;
    }

    public SQLExpr getCharacter() {
        return character;
    }

    public void setCharacter(SQLExpr character) {
        setChildParent(character);
        this.character = character;
    }

    public enum SQLTrimSpecification implements ISQLEnum {

        LEADING(SQLReserved.LEADING),
        TRAILING(SQLReserved.TRAILING),
        BOTH(SQLReserved.BOTH);

        public final SQLReserved name;

        SQLTrimSpecification(SQLReserved name) {
            this.name = name;
        }

        @Override
        public SQLReserved getName() {
            return null;
        }
    }
}
