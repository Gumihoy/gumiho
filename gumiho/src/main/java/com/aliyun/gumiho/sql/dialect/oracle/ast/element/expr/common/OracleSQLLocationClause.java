package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * LOCATION
 * ([ directory: ] 'location_specifier'
 * [, [ directory: ] 'location_specifier' ]...
 * )
 *
 * @author kongtong.ouyang on 2018/6/26.
 */
public class OracleSQLLocationClause extends AbstractOracleSQLExpr {

    protected final List<SQLExpr> items = new ArrayList<>();

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, items);
        }
    }

    @Override
    public OracleSQLLocationClause clone() {
        OracleSQLLocationClause x = new OracleSQLLocationClause();
        this.cloneTo(x);

        for (SQLExpr item : this.items) {
            SQLExpr itemClone = item.clone();
            x.addItem(itemClone);
        }
        return x;
    }

    public List<SQLExpr> getItems() {
        return items;
    }

    public void addItem(SQLExpr item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.items.add(item);
    }


    /**
     * [ directory: ] 'location_specifier'
     */
    public static class LocationItem extends AbstractOracleSQLExpr {

        protected SQLExpr directory;
        protected SQLExpr location;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, directory);
                this.acceptChild(visitor, location);
            }
        }

        @Override
        public LocationItem clone() {
            LocationItem x = new LocationItem();
            this.cloneTo(x);

            if (this.directory != null) {
                SQLExpr directoryClone = this.directory.clone();
                x.setDirectory(directoryClone);
            }

            SQLExpr locationClone = this.location.clone();
            x.setLocation(locationClone);
            return x;
        }

        public SQLExpr getDirectory() {
            return directory;
        }

        public void setDirectory(SQLExpr directory) {
            setChildParent(directory);
            this.directory = directory;
        }

        public SQLExpr getLocation() {
            return location;
        }

        public void setLocation(SQLExpr location) {
            setChildParent(location);
            this.location = location;
        }
    }
}
