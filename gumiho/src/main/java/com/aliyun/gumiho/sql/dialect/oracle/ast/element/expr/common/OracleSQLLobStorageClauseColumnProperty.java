package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLColumnProperty;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * LOB_storage_clause [ (LOB_partition_storage [, LOB_partition_storage ]...) ]
 *
 * https://docs.oracle.com/cd/B28359_01/server.111/b28286/statements_6002.htm#i2116664
 * @author kongtong.ouyang on 2018/6/28.
 */
public class OracleSQLLobStorageClauseColumnProperty extends AbstractOracleSQLExpr implements SQLColumnProperty {

    protected OracleSQLLobStorageClause lobStorageClause;

    protected final List<OracleSQLLobPartitionStorage> lobPartitionStorages = new ArrayList<>();

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, lobStorageClause);
            this.acceptChild(visitor, lobPartitionStorages);
        }
    }

    @Override
    public OracleSQLLobStorageClauseColumnProperty clone() {
        return null;
    }

    public OracleSQLLobStorageClause getLobStorageClause() {
        return lobStorageClause;
    }

    public void setLobStorageClause(OracleSQLLobStorageClause lobStorageClause) {
        setChildParent(lobStorageClause);
        this.lobStorageClause = lobStorageClause;
    }

    public List<OracleSQLLobPartitionStorage> getLobPartitionStorages() {
        return lobPartitionStorages;
    }

    public void addLobPartitionStorage (OracleSQLLobPartitionStorage lobPartitionStorage) {
        if (lobPartitionStorage == null) {
            return;
        }
        setChildParent(lobPartitionStorage);
        this.lobPartitionStorages.add(lobPartitionStorage);
    }
}
