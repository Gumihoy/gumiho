parser grammar DRDSSQLStatementParser;

options {tokenVocab=DRDSSQLStatementLexer;}

// Top Level Description

parse
    : ((statement | expr | MINUSMINUS) SEMI?)* MINUSMINUS? EOF
    ;

statement
    : ddlStatement | dmlStatement | transactionStatement
    | replicationStatement | preparedStatement | compoundStatement
    | administrationStatement | utilityStatement
    ;

ddlStatement
    : createDatabaseStatement | alterDatabaseStatement | dropDatabaseStatement
    | createSchemaStatement | alterSchemaStatement | dropSchemaStatement
    | createEventStatement | alterEventStatement | dropEventStatement
    | createFunctionStatement | alterFunctionStatement | dropFunctionStatement
    | createIndexStatement | dropIndexStatement
    | createLogfileGroupStatement | alterLogfileGroupStatement | dropLogfileGroupStatement
    | createProcedureStatement | alterProcedureStatement | dropProcedureStatement
    | createServerStatement | alterServerStatement | dropServerStatement
    | createTableStatement | alterTableStatement | dropTableStatement
    | createTablespaceStatement | alterTablespaceStatement | dropTablespaceStatement
    | createTriggerStatement | dropTriggerStatement
    | createViewStatement | alterViewStatement | dropViewStatement

    | alterInstanceStatement

    | createUserStatement | alterUserStatement | dropUserStatement

    | renameTableStatement | truncateTableStatement
    ;


dmlStatement
    : selectStatement | selectIntoStatement | insertStatement | updateStatement
    | deleteStatement | replaceStatement | callStatement
    | loadDataInfileStatement | loadXmlStatement | doStatement
    | handlerStatement
    ;

transactionStatement
    : startTransaction
    | beginWork | commitWork | rollbackWork
    | savepointStatement | rollbackStatement
    | releaseStatement | lockTablesStatement | unlockTablesStatement
    | xaStartTransaction | xaEndTransaction | xaPrepareStatement
    | xaCommitWork | xaRollbackWork | xaRecoverWork
    ;

replicationStatement
    : changeMaster | changeReplicationFilter | purgeBinaryLogs
    | resetMaster | resetSlave | startSlave | stopSlave
    | startGroupReplication | stopGroupReplication
    ;

preparedStatement
    : prepareStatement | executeStatement | deallocatePrepare
    ;

// remark: NOT INCLUDED IN sqlStatement, but include in body
//  ofExpr routine's statements
compoundStatement
    : body
    | caseStatement | ifStatement | leaveStatement
    | loopStatement | repeatStatement | whileStatement
    | iterateStatement | returnStatement | cursorStatement
    ;

administrationStatement
    : alterUserStatement | createUserStatement | dropUserStatement | grantStatement
    | grantProxy | renameUser | revokeStatement
    | revokeProxy | analyzeTable | checkTable
    | checksumTable | optimizeTable | repairTable
    | createUdfunction | installPlugin | uninstallPlugin
    | setStatement | showStatement | binlogStatement
    | cacheIndexStatement | flushStatement | killStatement
    | loadIndexIntoCache | resetStatement
    | shutdownStatement
    ;

utilityStatement
    : simpleDescribeStatement | fullDescribeStatement
    | helpStatement | useStatement
    ;


// Data Definition Language

//    Create statements

createDatabaseStatement
    : CREATE DATABASE ifNotExists? nameIdentifier createDatabaseOption*
    ;
createSchemaStatement
    : CREATE SCHEMA ifNotExists? nameIdentifier createDatabaseOption*
    ;

createEventStatement
    : CREATE definerOptionExpr? EVENT ifNotExists? nameIdentifier
      ON SCHEDULE scheduleexpr (ON COMPLETION NOT? PRESERVE)? enableType?
      (COMMENT expr)? DO statement
    ;

// -----Create Index Statement Start ----------------------
createIndexStatement
    : CREATE intimeAction? indexCategory? INDEX nameIdentifier indexType? ON iTableReference
        LEFT_PAREN createIndexStatementColumn (COMMA createIndexStatementColumn)* RIGHT_PAREN createIndexStatementOption*
    ;

// Details
createIndexStatementColumn
	: column=expr (LEFT_PAREN len=expr RIGHT_PAREN)? orderingSpecification?
	;
createIndexStatementOption
	: indexOption
	| algorithmOptionExpr
	| lockOptionExpr
	;
algorithmOptionExpr
	: ALGORITHM EQUALS_OP? algType=(DEFAULT | INPLACE | COPY | UNDEFINED | MERGE | TEMPTABLE)
	;
lockOptionExpr
	: LOCK EQUALS_OP? lockType=(DEFAULT | NONE | SHARED | EXCLUSIVE)
	;
// -----Create Index Statement End ----------------------


createLogfileGroupStatement
    : CREATE LOGFILE GROUP nameIdentifier
      ADD UNDOFILE undoFile=expr
      (INITIAL_SIZE EQUALS_OP? initSize=expr)?
      (UNDO_BUFFER_SIZE EQUALS_OP? undoSize=expr)?
      (REDO_BUFFER_SIZE EQUALS_OP? redoSize=expr)?
      (NODEGROUP EQUALS_OP? nameIdentifier)?
      WAIT?
      (COMMENT EQUALS_OP? comment=expr)?
      ENGINE EQUALS_OP? engineName
    ;

createProcedureStatement
    : CREATE definerOptionExpr? PROCEDURE nameIdentifier
      LEFT_PAREN parameterDeclaration? (COMMA parameterDeclaration)* RIGHT_PAREN
      routineOption* statement
    ;

createFunctionStatement
    : CREATE definerOptionExpr? FUNCTION nameIdentifier
      LEFT_PAREN parameterDeclaration? (COMMA parameterDeclaration)* RIGHT_PAREN
      RETURNS dataType routineOption* statement
    ;

// ------create server Statement Start -------------------
createServerStatement
    : CREATE SERVER name=nameIdentifier FOREIGN DATA WRAPPER wrapper=nameIdentifier
        OPTIONS LEFT_PAREN serverOption (COMMA serverOption)* RIGHT_PAREN
    ;
serverOption
    : HOST expr         #serverHostOption
    | DATABASE expr     #serverDatabaseOption
    | USER expr         #serverUserOption
    | PASSWORD expr     #serverPasswordOption
    | SOCKET expr       #serverSocketOption
    | OWNER expr        #serverOwnerOption
    | PORT expr         #serverPortOption
    ;
// ------create server Statement end -------------------

// ------create Table Statement Start -------------------
createTableStatement
    : CREATE TEMPORARY? TABLE ifNotExists? nameIdentifier (tableElementsParen=LEFT_PAREN? tableElement (COMMA tableElement)* RIGHT_PAREN?)?
		(tableOption (COMMA? tableOption)*)? iDBPartitionBy? (AS? iSelectQuery)?
    ;

// details
tableElement
	: columnDefinition
	| likeClause
	| tableConstraint
	;
columnDefinition
	: nameIdentifier dataType? columnConstraint*
	;
likeClause
	: LIKE nameIdentifier
	;

columnConstraint
    : null_                                                                                                             #nullColumnConstraint
    | notNull                                                                                                           #notNullColumnConstraint
    | defaultClause                                                                                                     #defaultColumnConstraint
    | AUTO_INCREMENT                                                                                                    #autoIncrementColumnConstraint
    | PRIMARY? KEY                                                                                                      #primaryKeyColumnConstraint
    | UNIQUE KEY?                                                                                                       #uniqueColumnConstraint
    | COMMENT expr                                                                                                      #commentClause
    | COLUMN_FORMAT colformat=(FIXED | DYNAMIC | DEFAULT)                                                               #formatColumnConstraint
    | STORAGE storageval=(DISK | MEMORY | DEFAULT)                                                                      #storageColumnConstraint
    | REFERENCES nameIdentifier LEFT_PAREN constraintColumn (COMMA constraintColumn)* RIGHT_PAREN
        (MATCH matchType)? referenceTriggerAction*                                                                      #referencesColumnConstraint
    ;

tableConstraint
    : (CONSTRAINT name=nameIdentifier?)? PRIMARY KEY indexType?
        LEFT_PAREN constraintColumn (COMMA constraintColumn)* RIGHT_PAREN indexOption*                                  #primaryKeyTableConstraint
    | INDEX nameIdentifier? indexType? LEFT_PAREN constraintColumn (COMMA constraintColumn)* RIGHT_PAREN indexOption*   #indexTableConstraint
	| KEY nameIdentifier? indexType? LEFT_PAREN constraintColumn (COMMA constraintColumn)* RIGHT_PAREN indexOption*     #keyTableConstraint
    | (CONSTRAINT name=nameIdentifier?)? UNIQUE indexFormat? index=nameIdentifier? indexType?
        LEFT_PAREN constraintColumn (COMMA constraintColumn)* RIGHT_PAREN indexOption*                                  #uniqueTableConstraint
	| FULLTEXT indexFormat? nameIdentifier?
		LEFT_PAREN constraintColumn (COMMA constraintColumn)* RIGHT_PAREN indexOption*                                  #fullTextTableConstraint
	| SPATIAL indexFormat? nameIdentifier?
	    LEFT_PAREN constraintColumn (COMMA constraintColumn)* RIGHT_PAREN indexOption*                                  #spatialTableConstraint
    | (CONSTRAINT name=nameIdentifier?)? FOREIGN KEY index=nameIdentifier?
        LEFT_PAREN referencingColumns+=constraintColumn (COMMA referencingColumns+=constraintColumn)*
        RIGHT_PAREN REFERENCES referencedTable=nameIdentifier
		LEFT_PAREN referencedColumns+=constraintColumn (COMMA referencedColumns+=constraintColumn)* RIGHT_PAREN
        (MATCH matchType)? referenceTriggerAction*                                                                      #foreignKeyTableConstraint
    | CHECK LEFT_PAREN expr RIGHT_PAREN                                                                                 #checkTableConstraint
    ;
constraintColumn
	: name=expr (LEFT_PAREN length=expr RIGHT_PAREN)? orderingSpecification?
	;
matchType
	: FULL
	| PARTIAL
	| SIMPLE
	;
referenceTriggerAction
    : ON DELETE referenceControlType    #onDeleteAction
    | ON UPDATE referenceControlType    #onUpdateAction
    ;

referenceControlType
    : RESTRICT | CASCADE | SET NULL_LITERAL | NO ACTION
    ;

tableOption
    : autoIncrementOptionExpr
    | avgRowLengthOptionExpr
    | characterSetOptionExpr
    | charsetOptionExpr
    | checksumOptionExpr
    | collateOptionExpr
    | commentOptionExpr
    | compressionOptionExpr
    | connectionOptionExpr
    | dataDirectoryOptionExpr
    | indexDirectoryOptionExpr
    | delayKeyWriteOptionExpr
	| encryptionOptionExpr
	| engineOptionExpr
    | insertMethodOptionExpr
    | keyBlockSizeOptionExpr
    | maxRowsOptionExpr
    | minRowsOptionExpr
    | packKeysOptionExpr
    | passwordOptionExpr
    | rowFormatOptionExpr
	| statsAutoRecalcOptionExpr
	| statsPersistentOptionExpr
    | statsSamplePageOptionExpr
    | tablespaceOptionExpr
    | unionOptionExpr
    | broadcastExpr
    ;

iDBPartitionBy
	: DBPARTITION BY HASH LEFT_PAREN columns+=expr RIGHT_PAREN iTBPartitionBy?                                          #dBPartitionByHash
	| DBPARTITION BY RANGE_HASH LEFT_PAREN columns+=expr RIGHT_PAREN iTBPartitionBy?                                    #dBPartitionByRangeHash
	;
iTBPartitionBy
	: TBPARTITION BY HASH LEFT_PAREN columns+=expr RIGHT_PAREN (TBPARTITIONS tbPartitionsNum=expr)?                     #tBPartitionByHash
	| TBPARTITION BY RANGE_HASH LEFT_PAREN columns+=expr RIGHT_PAREN (TBPARTITIONS tbPartitionsNum=expr)?               #tBPartitionByRangeHash
	| TBPARTITION BY MM LEFT_PAREN columns+=expr RIGHT_PAREN (TBPARTITIONS tbPartitionsNum=expr)?                       #tBPartitionByMM
	| TBPARTITION BY DD LEFT_PAREN columns+=expr RIGHT_PAREN (TBPARTITIONS tbPartitionsNum=expr)?                       #tBPartitionByDD
	| TBPARTITION BY WEEK LEFT_PAREN columns+=expr RIGHT_PAREN (TBPARTITIONS tbPartitionsNum=expr)?                     #tBPartitionByWeek
	| TBPARTITION BY MMDD LEFT_PAREN columns+=expr RIGHT_PAREN (TBPARTITIONS tbPartitionsNum=expr)?                     #tBPartitionByMMDD
	;

// ------create Table Statement End -------------------

createTablespaceStatement
    : createTablespaceInnodb | createTablespaceNdb
    ;

createTablespaceInnodb
    : CREATE TABLESPACE nameIdentifier
      ADD DATAFILE datafile=expr
      (FILE_BLOCK_SIZE EQUALS_OP fileBlockSize=expr)?
      (ENGINE EQUALS_OP? engineName)?
    ;

createTablespaceNdb
    : CREATE TABLESPACE nameIdentifier
      ADD DATAFILE datafile=expr
      USE LOGFILE GROUP nameIdentifier
      (EXTENT_SIZE EQUALS_OP? extentSize=expr)?
      (INITIAL_SIZE EQUALS_OP? initialSize=expr)?
      (AUTOEXTEND_SIZE EQUALS_OP? autoextendSize=expr)?
      (MAX_SIZE EQUALS_OP? maxSize=expr)?
      (NODEGROUP EQUALS_OP? nameIdentifier)?
      WAIT? (COMMENT EQUALS_OP? comment=expr)?
      ENGINE EQUALS_OP? engineName
    ;

createTriggerStatement
    : CREATE definerOptionExpr? TRIGGER name=nameIdentifier triggerTime=(BEFORE | AFTER)
      triggerEvent=(INSERT | UPDATE | DELETE) ON onExpr=nameIdentifier FOR EACH ROW
      triggerOrderingClause? statement
    ;

// details
definerOptionExpr
	: DEFINER EQUALS_OP (CURRENT_USER (LEFT_PAREN RIGHT_PAREN)? | nameIdentifier)
	;
triggerOrderingClause
	: (FOLLOWS | PRECEDES) nameIdentifier
	;

createViewStatement
    : CREATE orReplace? algorithmOptionExpr? definerOptionExpr?
      (SQL SECURITY secContext=(DEFINER | INVOKER))?
      VIEW nameIdentifier (LEFT_PAREN columnDefinition (COMMA columnDefinition)* RIGHT_PAREN)? AS iSelectQuery withCheckOption?
    ;

withCheckOption
	: WITH levels=(CASCADED | LOCAL)? CHECK OPTION
	;


// details
createDatabaseOption
    : characterSetOptionExpr
    | collateOptionExpr
    ;

scheduleexpr
    : AT timestampValue expr*                               #preciseSchedule
    | EVERY (expr | expr) intervalType
        (
          STARTS start=timestampValue
          (startIntervals+=expr)*
        )?
        (
          ENDS end=timestampValue
          (endIntervals+=expr)*
        )?                                                          #intervalSchedule
    ;

timestampValue
    : CURRENT_TIMESTAMP
    | expr
    | expr
    | expr
    ;

enableType
    : ENABLE | DISABLE | DISABLE ON SLAVE
    ;


indexOption
    : indexOptionKeyBlockSize
    | indexOptionUsingBtree
    | indexOptionUsingHash
    | indexOptionWithParser
    | indexAttributeVisible
    | indexAttributeInvisible
    | indexOptionCommentOption
    ;
indexOptionKeyBlockSize
	: KEY_BLOCK_SIZE EQUALS_OP? expr
	;
indexOptionUsingBtree
	: USING BTREE
	;
indexOptionUsingHash
	: USING HASH
	;
indexOptionWithParser
	: WITH PARSER nameIdentifier
	;
indexAttributeVisible
	: VISIBLE
	;
indexAttributeInvisible
	: INVISIBLE
	;
indexOptionCommentOption
	: COMMENT expr
	;

parameterDeclaration
    : parameterModel=(IN | OUT | INOUT)? nameIdentifier dataType
    ;

routineOption
    : COMMENT expr                                                  #routineComment
    | LANGUAGE SQL                                                  #routineLanguage
    | NOT? DETERMINISTIC                                            #routineBehavior
    | (
        CONTAINS SQL | NO SQL | READS SQL DATA
        | MODIFIES SQL DATA
      )                                                             #routineData
    | SQL SECURITY context=(DEFINER | INVOKER)                      #routineSecurity
    ;


//    Alter statements

alterDatabaseStatement
    : ALTER DATABASE nameIdentifier?    createDatabaseOption+       #alterSimpleDatabase
    | ALTER DATABASE nameIdentifier UPGRADE DATA DIRECTORY NAME     #alterUpgradeName
    ;
alterSchemaStatement
    : ALTER SCHEMA nameIdentifier?  createDatabaseOption+       #alterSimpleSchema
    | ALTER SCHEMA nameIdentifier UPGRADE DATA DIRECTORY NAME     #alterSchemaUpgradeName
    ;

alterEventStatement
    : ALTER definerOptionExpr? EVENT nameIdentifier
      (ON SCHEDULE scheduleexpr)?
      (ON COMPLETION NOT? PRESERVE)?
      (RENAME TO nameIdentifier)? enableType?
      (COMMENT expr)? (DO statement)?
    ;

alterFunctionStatement
    : ALTER FUNCTION nameIdentifier routineOption*
    ;

alterInstanceStatement
    : ALTER INSTANCE ROTATE INNODB MASTER KEY
    ;

alterLogfileGroupStatement
    : ALTER LOGFILE GROUP nameIdentifier
      ADD UNDOFILE expr
      (INITIAL_SIZE EQUALS_OP? expr)?
      WAIT? ENGINE EQUALS_OP? engineName
    ;

alterProcedureStatement
    : ALTER PROCEDURE nameIdentifier routineOption*
    ;

alterServerStatement
    : ALTER SERVER nameIdentifier OPTIONS LEFT_PAREN serverOption (COMMA serverOption)* RIGHT_PAREN
    ;


// ----- alter table ---------------------
alterTableStatement
    : ALTER intimeAction? IGNORE? TABLE nameIdentifier alterTableItem (COMMA alterTableItem)* iDBPartitionBy?
    ;

// details
alterTableItem
    : tableOption                                                                                                       #alterByTableOption

    | ADD COLUMN? columnDefinition (FIRST | AFTER nameIdentifier)?                                                      #alterTableAddColumnAction
    | ADD COLUMN? LEFT_PAREN columnDefinition (COMMA columnDefinition)* RIGHT_PAREN                                     #alterTableAddColumnAction
    | ADD tableConstraint                                                                                               #alterTableAddTableConstraintAction

    | ALGORITHM EQUALS_OP? algType=(DEFAULT | INPLACE | COPY)                                                           #alterTableAlgorithmAction

    | ALTER COLUMN? nameIdentifier alterColumnAction                                                                    #alterTableAlterColumnAction

    | ALTER INDEX nameIdentifier visibleType                                                                            #alterTableAlterIndexConstraintAction
    | CHANGE COLUMN? name=nameIdentifier columnDefinition ()?                                                           #alterTableChangeColumnAction

    | DEFAULT? CHARACTER SET EQUALS_OP expr (COLLATE EQUALS_OP expr)?                                                   #alterTableDefaultCharsetAction

    | CONVERT TO CHARACTER SET expr (COLLATE expr)?                                                                     #alterTableConvertCharsetAction

    | DISABLE KEYS                                                                                                      #alterTableDisableKeysAction
    | ENABLE KEYS                                                                                                       #alterTableEnableKeysAction

    | DISCARD TABLESPACE                                                                                                #alterTableDiscardTablespaceAction
    | IMPORT TABLESPACE                                                                                                 #alterTableImportTablespaceAction

    | DROP COLUMN? nameIdentifier                                                                                       #alterTableDropColumnAction
    | DROP INDEX nameIdentifier                                                                                         #alterTableDropIndexConstraintAction
    | DROP KEY nameIdentifier                                                                                           #alterTableDropKeyConstraintAction
    | DROP PRIMARY KEY                                                                                                  #alterTableDropPrimaryKeyConstraintAction
    | DROP FOREIGN KEY nameIdentifier                                                                                   #alterTableDropForeignKeyConstraintAction

    | FORCE                                                                                                             #alterTableForceAction
    | LOCK EQUALS_OP? lockType=(DEFAULT | NONE | SHARED | EXCLUSIVE)                                                    #alterTableLockAction

    | MODIFY COLUMN? columnDefinition (FIRST | AFTER nameIdentifier)?                                                   #alterTableModifyColumnAction
    | ORDER BY expr (COMMA expr)*                                                                                       #alterTableOrderByColumnAction
    | RENAME COLUMN nameIdentifier TO nameIdentifier                                                                    #alterTableRenameColumnAction
    | RENAME INDEX nameIdentifier TO nameIdentifier                                                                     #alterTableRenameIndexConstraintAction
    | RENAME KEY nameIdentifier TO nameIdentifier                                                                       #alterTableRenameKeyConstraintAction
    | RENAME renameFormat=(TO | AS)? nameIdentifier                                                                     #alterTableRenameTableAction

    | WITHOUT VALIDATION                                                                                                #alterTableWithoutValidateAction
    | WITH VALIDATION                                                                                                   #alterTableWithValidateAction


    | DROP PARTITION expr (COMMA expr)*                                                                                 #alterTableDropPartitionAction
    | DISCARD PARTITION alterTablePartitionItem (COMMA alterTablePartitionItem)* TABLESPACE                             #alterTableDiscardPartitionAction
    | IMPORT PARTITION alterTablePartitionItem (COMMA alterTablePartitionItem)* TABLESPACE                              #alterTableImportPartitionAction
    | TRUNCATE PARTITION alterTablePartitionItem (COMMA alterTablePartitionItem)*                                       #alterTableTruncatePartitionAction
    | COALESCE PARTITION expr                                                                                           #alterTableCoalescePartitionAction

    | EXCHANGE PARTITION name=nameIdentifier WITH TABLE table=nameIdentifier (withType VALIDATION)?                     #alterTableExchangePartitionAction
    | ANALYZE PARTITION alterTablePartitionItem (COMMA alterTablePartitionItem)*                                        #alterTableAnalyzePartitiionAction
    | CHECK PARTITION alterTablePartitionItem (COMMA alterTablePartitionItem)*                                          #alterTableCheckPartitionAction
    | OPTIMIZE PARTITION alterTablePartitionItem (COMMA alterTablePartitionItem)*                                       #alterTableOptimizePartitionAction
    | REBUILD PARTITION alterTablePartitionItem (COMMA alterTablePartitionItem)*                                        #alterTableRebuildPartitionAction
    | REPAIR PARTITION alterTablePartitionItem (COMMA alterTablePartitionItem)*                                         #alterTableRepairPartitionAction
    | REMOVE PARTITIONING                                                                                               #alterTableRemovePartitioningAction
    | UPGRADE PARTITIONING                                                                                              #alterTableUpgradePartitioningAction
    ;

alterColumnAction
	: SET DEFAULT expr              #alterColumnSetDefaultAction
	| DROP DEFAULT                  #alterColumnDropDefaultAction
	;
alterTablePartitionItem
	: allLiteral
	| expr
	;

// ----- alter table ---------------------



alterTablespaceStatement
    : ALTER TABLESPACE nameIdentifier objectAction=(ADD | DROP) DATAFILE expr
      (INITIAL_SIZE EQUALS_OP expr)? WAIT? ENGINE EQUALS_OP? engineName
    ;

alterViewStatement
    : ALTER (ALGORITHM EQUALS_OP algType=(UNDEFINED | MERGE | TEMPTABLE))?
      definerOptionExpr?
      (SQL SECURITY secContext=(DEFINER | INVOKER))?
      VIEW nameIdentifier (LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN)? AS selectStatement
      (WITH checkOpt=(CASCADED | LOCAL)? CHECK OPTION)?
    ;


//    Drop statements
dropDatabaseStatement
    : DROP DATABASE ifExists? nameIdentifier
    ;
dropSchemaStatement
    : DROP SCHEMA ifExists? nameIdentifier
    ;

dropEventStatement
    : DROP EVENT ifExists? nameIdentifier
    ;

// ---------drop index statement ----------------------------------------
dropIndexStatement
    : DROP INDEX intimeAction? index=nameIdentifier ON table=nameIdentifier dropIndexStatementOption*
    ;
dropIndexStatementOption
	: algorithmOptionExpr
	| lockOptionExpr
	;
// ---------drop index statement ----------------------------------------


dropLogfileGroupStatement
    : DROP LOGFILE GROUP nameIdentifier ENGINE EQUALS_OP engineName
    ;

dropProcedureStatement
    : DROP PROCEDURE ifExists? nameIdentifier
    ;

dropFunctionStatement
    : DROP FUNCTION ifExists? nameIdentifier
    ;

dropServerStatement
    : DROP SERVER ifExists? nameIdentifier
    ;

dropTableStatement
    : DROP TEMPORARY? TABLE ifExists? nameIdentifier (COMMA nameIdentifier)* dropType=(RESTRICT | CASCADE)?
    ;

dropTablespaceStatement
    : DROP TABLESPACE nameIdentifier (ENGINE EQUALS_OP? engineName)?
    ;

dropTriggerStatement
    : DROP TRIGGER ifExists? nameIdentifier
    ;

dropViewStatement
    : DROP VIEW ifExists? nameIdentifier (COMMA nameIdentifier)* dropType=(RESTRICT | CASCADE)?
    ;


//    Other DDL statements

renameTableStatement
    : RENAME TABLE renameTableClause (COMMA renameTableClause)*
    ;
renameTableClause
    : nameIdentifier TO nameIdentifier
    ;

truncateTableStatement
    : TRUNCATE TABLE? nameIdentifier
    ;


// Data Manipulation Language

// select Statement
selectStatement
    : iSelectQuery
    ;
iSelectQuery
	: selectQueryBasic | selectUnionQuery
	;
selectQueryBasic
	: selectQuery | selectParenQuery
	;
selectQuery
	: SELECT setQuantifier? HIGH_PRIORITY? STRAIGHT_JOIN? SQL_SMALL_RESULT? SQL_BIG_RESULT? SQL_BUFFER_RESULT?
		selectQueryCache? SQL_CALC_FOUND_ROWS? selectItem (COMMA selectItem)* fromClause?
		whereClause? groupByClause? orderByClause? limitOffsetClause? iSelectQueryIntoClause? iLockClause?
	;
selectQueryCache
	: SQL_CACHE | SQL_NO_CACHE
	;
selectParenQuery
	: LEFT_PAREN iSelectQuery RIGHT_PAREN orderByClause? limitOffsetClause? iLockClause?
	;
selectUnionQuery
    : selectQueryBasic (unionOperator selectQueryBasic)+ orderByClause? limitOffsetClause? iLockClause?
    ;
setQuantifier
	: ALL | DISTINCT | DISTINCTROW
	;
unionOperator
	: UNION (ALL|DISTINCT)?
	;

// select statement details
selectItem
	: column=expr (AS? alias=selectItemAlias)?
	;
selectItemAlias
	: nameIdentifier
    | literal
	;

fromClause
    : FROM iTableReference
    ;
iTableReference
	: tableReferenceBasic
	| joinTableReference
	;
tableReferenceBasic
	: tableName=nameIdentifier partitionClause?
		(AS? alias=nameIdentifier (indexes+=iIndexHint (COMMA indexes+=iIndexHint)*)?)?                                 #objectNameTableReference
	| LEFT_PAREN iSelectQuery RIGHT_PAREN AS? alias=nameIdentifier
		(LEFT_PAREN columns+=expr (COMMA columns+=expr)* RIGHT_PAREN)?                                                  #subQueryTableReference
	| LEFT_BRACE OJ iTableReference RIGHT_BRACE                                                                         #ojTableReference
    | LEFT_PAREN iTableReference RIGHT_PAREN                                                                            #parenTableReference
	;
joinTableReference
	: tableReferenceBasic rightJoinClause+
	;
partitionClause
	: PARTITION LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN
	;
iIndexHint
    : USE INDEX (FOR indexHintType)? LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN          #useIndexHint
    | USE KEY (FOR indexHintType)? LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN            #useKeyHint
    | IGNORE INDEX (FOR indexHintType)? LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN       #ignoreIndexHint
    | IGNORE KEY (FOR indexHintType)? LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN         #ignoreKeyHint
    | FORCE INDEX (FOR indexHintType)? LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN        #forceIndexHint
    | FORCE KEY (FOR indexHintType)? LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN          #forceKeyHint
    ;
indexHintType
    : JOIN | ORDER BY | GROUP BY
    ;
joinType
	: COMMA
	| INNER_JOIN
	| CROSS_JOIN
	| NATURAL_JOIN
	| NATURAL_INNER_JOIN

	| STRAIGHT_JOIN

	| LEFT_JOIN
	| LEFT_OUTER_JOIN
	| NATURAL_LEFT_JOIN
	| NATURAL_LEFT_OUTER_JOIN

	| RIGHT_JOIN
	| RIGHT_OUTER_JOIN
	| NATURAL_RIGHT_JOIN
    | NATURAL_RIGHT_OUTER_JOIN

    | JOIN
	;
rightJoinClause
	: joinType tableReferenceBasic iJoinCondition?
	;
iJoinCondition
	: ON expr                                                           #joinOnCondition
	| USING LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN                   #joinUsingCondition
	;

whereClause
	: WHERE expr
	;
groupByClause
	: (GROUP BY groupByItem (COMMA groupByItem)* withRollup?)? havingClause?
	;
havingClause
	: HAVING expr
	;
groupByItem
    : expr
    ;

orderByClause
    : ORDER BY orderByItem (COMMA orderByItem)* withRollup?
    ;
orderByItem
	: sortKey=expr orderingSpecification?
	;
limitOffsetClause
    : LIMIT ((offset=expr COMMA)? limit=expr | limit=expr OFFSET offset=expr)
    ;

iSelectQueryIntoClause
    : INTO expr (COMMA expr )*                                      #selectQueryIntoClause
    | INTO DUMPFILE expr                                  #selectQueryIntoDumpFileClause
    | INTO OUTFILE filename=expr characterSetOptionExpr?
        (fieldsFormat=(FIELDS | COLUMNS) selectFieldsInto+)?
        (LINES selectLinesInto+)?                                   #selectIntoTextFile
    ;
iLockClause
    : FOR (UPDATE|SHARE) (OF expr (COMMA expr)*)? forUpdateOption?              #forUpdateClause
    | LOCK IN SHARE MODE                                                        #lockInShareModeClause
    ;
forUpdateOption
    : SKIP_ LOCKED              #forUpdateSkipLockedOption
    | NOWAIT                    #forUpdateNoWaitOption
    ;
// ------- Select Statement End ------------

// ------- Select into Statement Start ------------
selectIntoStatement
	: SELECT setQuantifier? HIGH_PRIORITY? STRAIGHT_JOIN? SQL_SMALL_RESULT? SQL_BIG_RESULT? SQL_BUFFER_RESULT?
        selectQueryCache? SQL_CALC_FOUND_ROWS? selectItem (COMMA selectItem)* INTO selectTargetItem (COMMA selectTargetItem)*
        fromClause? whereClause? groupByClause? orderByClause? limitOffsetClause? iSelectQueryIntoClause? iLockClause?
	;
selectTargetItem
	: expr
	;
// ------- Select into Statement End ------------

// ------- insert Statement Start ------------
insertStatement
    : INSERT priority? IGNORE? INTO? iTableReference
        (LEFT_PAREN columns+=expr (COMMA columns+=expr)* RIGHT_PAREN)?
        iValueClause onDuplicateKeyUpdateClause?
    ;

// details
iValueClause
    : valuesClause
    | updateSetClause
    | iSelectQuery
    ;
valuesClause
    : (VALUES|VALUE) valuesClauseItem (COMMA valuesClauseItem)*
    ;
valuesClauseItem
    : LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN
	;
onDuplicateKeyUpdateClause
	: ON DUPLICATE KEY UPDATE assignmentExpr (COMMA assignmentExpr)*
	;
// ------- insert Statement End ------------


// ------- update Statement Start ------------
updateStatement
    : UPDATE LOW_PRIORITY? IGNORE? iTableReference updateSetClause? whereClause? orderByClause? limitOffsetClause?
    ;

// details
updateSetClause
	: SET updateSetItemClause (COMMA updateSetItemClause)*
	;
updateSetItemClause
	: column=expr EQUALS_OP value=expr
	;
// ------- update Statement End ------------


// ------- delete Statement Start ------------
deleteStatement
    : DELETE LOW_PRIORITY? QUICK? IGNORE? FROM iTableReference
        deleteStatementUsingClause? whereClause? orderByClause? limitOffsetClause?
    ;
// details
deleteStatementUsingClause
	: USING iTableReference
	;
// ------- delete Statement End ------------


// ------- replace Statement End ------------
replaceStatement
    : REPLACE priority? INTO? iTableReference
      (LEFT_PAREN columns+=expr (COMMA columns+=expr)* RIGHT_PAREN)? replaceStatementValuseClause
    ;
// details
replaceStatementValuseClause
	: valuesClause
	| updateSetClause
	| iSelectQuery
	;
// ------- replace Statement End ------------


// ------- call Statement Start ------------
callStatement
    : CALL expr
    ;
// ------- call Statement End ------------


// ------- load data infile Statement Start ------------
loadDataInfileStatement
    : LOAD DATA priority? LOCAL? INFILE fileName=expr
      violation=(REPLACE | IGNORE)?
      INTO TABLE nameIdentifier
      (PARTITION LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN )?
      (CHARACTER SET charset=expr)?
      (fieldsFormat=(FIELDS | COLUMNS) selectFieldsInto+)?
      (LINES selectLinesInto+)?
      (IGNORE expr linesFormat=(LINES | ROWS))?
      (LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN)?
      updateSetClause?
    ;
// ------- load data infile Statement End ------------


// ------- load xml Statement Start ------------
loadXmlStatement
    : LOAD XML priority? LOCAL? INFILE filename=expr violation=(REPLACE | IGNORE)?
      INTO TABLE nameIdentifier (CHARACTER SET charset=expr)?
      (ROWS IDENTIFIED BY '<' tag=expr '>')?
      (IGNORE expr linesFormat=(LINES | ROWS) )?
      (LEFT_PAREN columns+=expr (COMMA columns+=expr)* RIGHT_PAREN )?
      updateSetClause?
    ;

// ------- load xml Statement End ------------

// ------- DO Statement Start ------------
doStatement
    : DO expr (COMMA expr)*
    ;
// ------- load xml Statement End ------------

// ------- handler Statement Start ------------
handlerStatement
    : handlerOpenStatement
    | handlerReadStatement
    | handlerCloseStatement
    ;

// details
handlerOpenStatement
    : HANDLER name=nameIdentifier OPEN (AS? alias=nameIdentifier)?
    ;

handlerReadStatement
    : HANDLER name=nameIdentifier READ index=nameIdentifier?
      (comparisonOp LEFT_PAREN values+=expr (COMMA values+=expr)* RIGHT_PAREN)?
      moveOrder=(FIRST | NEXT | PREV | LAST)?
      whereClause? limitOffsetClause?
    ;

handlerCloseStatement
    : HANDLER nameIdentifier CLOSE
    ;
// ------- load xml Statement End ------------


// details
selectFieldsInto
    : TERMINATED BY terminationField=expr
    | OPTIONALLY? ENCLOSED BY enclosion=expr
    | ESCAPED BY escaping=expr
    ;

selectLinesInto
    : STARTING BY starting=expr
    | TERMINATED BY terminationLine=expr
    ;


// Transaction's Statements
startTransaction
    : START TRANSACTION (transactionMode (COMMA transactionMode)* )?
    ;
transactionMode
    : WITH CONSISTENT SNAPSHOT
    | READ WRITE
    | READ ONLY
    ;

beginWork
    : BEGIN WORK?
    ;

commitWork
    : COMMIT WORK?
      (AND nochain=NO? CHAIN)?
      (norelease=NO? RELEASE)?
    ;

rollbackWork
    : ROLLBACK WORK?
      (AND nochain=NO? CHAIN)?
      (norelease=NO? RELEASE)?
    ;

savepointStatement
    : SAVEPOINT nameIdentifier
    ;

rollbackStatement
    : ROLLBACK WORK? TO SAVEPOINT? nameIdentifier
    ;

releaseStatement
    : RELEASE SAVEPOINT nameIdentifier
    ;

lockTablesStatement
    : LOCK TABLES lockTableItem (COMMA lockTableItem)*
    ;
lockTableItem
    : name=nameIdentifier (AS? alias=nameIdentifier)? lockAction
    ;
lockAction
    : READ LOCAL? | LOW_PRIORITY? WRITE
    ;

unlockTablesStatement
    : UNLOCK TABLES
    ;


// details

setAutoCommitStatement
    : SET AUTOCOMMIT EQUALS_OP expr
    ;

transactionOption
    : ISOLATION LEVEL transactionLevel
    | READ WRITE
    | READ ONLY
    ;

transactionLevel
    : REPEATABLE READ
    | READ COMMITTED
    | READ UNCOMMITTED
    | SERIALIZABLE
    ;


// Replication's Statements

//    Base Replication

changeMaster
    : CHANGE MASTER TO
      masterOption (COMMA masterOption)* channelOption?
    ;

changeReplicationFilter
    : CHANGE REPLICATION FILTER
      replicationFilter (COMMA replicationFilter)*
    ;

purgeBinaryLogs
    : PURGE purgeFormat=(BINARY | MASTER) LOGS
       (
           TO fileName=expr
           | BEFORE timeValue=expr
       )
    ;

resetMaster
    : RESET MASTER
    ;

resetSlave
    : RESET SLAVE ALL? channelOption?
    ;

startSlave
    : START SLAVE (threadType (COMMA threadType)*)?
      (UNTIL untilOption)?
      connectionOption* channelOption?
    ;

stopSlave
    : STOP SLAVE (threadType (COMMA threadType)*)?
    ;

startGroupReplication
    : START GROUP_REPLICATION
    ;

stopGroupReplication
    : STOP GROUP_REPLICATION
    ;

// details

masterOption
    : stringMasterOption EQUALS_OP expr                         #masterStringOption
    | decimalMasterOption EQUALS_OP expr                        #masterDecimalOption
    | boolMasterOption EQUALS_OP expr                      #masterBoolOption
    | MASTER_HEARTBEAT_PERIOD EQUALS_OP expr                      #masterRealOption
    | IGNORE_SERVER_IDS EQUALS_OP LEFT_PAREN (nameIdentifier (COMMA nameIdentifier)*)? RIGHT_PAREN               #master
    ;

stringMasterOption
    : MASTER_BIND | MASTER_HOST | MASTER_USER | MASTER_PASSWORD
    | MASTER_LOG_FILE | RELAY_LOG_FILE | MASTER_SSL_CA
    | MASTER_SSL_CAPATH | MASTER_SSL_CERT | MASTER_SSL_CRL
    | MASTER_SSL_CRLPATH | MASTER_SSL_KEY | MASTER_SSL_CIPHER
    | MASTER_TLS_VERSION
    ;
decimalMasterOption
    : MASTER_PORT | MASTER_CONNECT_RETRY | MASTER_RETRY_COUNT
    | MASTER_DELAY | MASTER_LOG_POS | RELAY_LOG_POS
    ;

boolMasterOption
    : MASTER_AUTO_POSITION | MASTER_SSL
    | MASTER_SSL_VERIFY_SERVER_CERT
    ;

channelOption
    : FOR CHANNEL expr
    ;

replicationFilter
    : REPLICATE_DO_DB EQUALS_OP LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN                           #doDbReplication
    | REPLICATE_IGNORE_DB EQUALS_OP LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN                       #ignoreDbReplication
    | REPLICATE_DO_TABLE EQUALS_OP LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN                         #doTableReplication
    | REPLICATE_IGNORE_TABLE EQUALS_OP LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN                     #ignoreTableReplication
    | REPLICATE_WILD_DO_TABLE EQUALS_OP LEFT_PAREN simpleStrings RIGHT_PAREN             #wildDoTableReplication
    | REPLICATE_WILD_IGNORE_TABLE
       EQUALS_OP LEFT_PAREN simpleStrings RIGHT_PAREN                                    #wildIgnoreTableReplication
    | REPLICATE_REWRITE_DB EQUALS_OP
      LEFT_PAREN tablePair (COMMA tablePair)* RIGHT_PAREN                            #rewriteDbReplication
    ;

tablePair
    : LEFT_PAREN firstTable=nameIdentifier COMMA secondTable=nameIdentifier RIGHT_PAREN
    ;

threadType
    : IO_THREAD | SQL_THREAD
    ;

untilOption
    : gtids=(SQL_BEFORE_GTIDS | SQL_AFTER_GTIDS)
      EQUALS_OP gtnameIdentifierSet                                                  #gtidsUntilOption
    | MASTER_LOG_FILE EQUALS_OP expr
      COMMA MASTER_LOG_POS EQUALS_OP expr                         #masterLogUntilOption
    | RELAY_LOG_FILE EQUALS_OP expr
      COMMA RELAY_LOG_POS EQUALS_OP expr                          #relayLogUntilOption
    | SQL_AFTER_MTS_GAPS                                            #sqlGapsUntilOption
    ;

connectionOption
    : USER EQUALS_OP conOptUser=expr                            #userConnectionOption
    | PASSWORD EQUALS_OP conOptPassword=expr                    #passwordConnectionOption
    | DEFAULT_AUTH EQUALS_OP conOptDefAuth=expr                 #defaultAuthConnectionOption
    | PLUGIN_DIR EQUALS_OP conOptPluginDir=expr                 #pluginDirConnectionOption
    ;

gtnameIdentifierSet
    : unameIdentifierSet (COMMA unameIdentifierSet)*
    | expr
    ;


//    XA Transactions

xaStartTransaction
    : XA xaStart=(START | BEGIN) xid xaAction=(JOIN | RESUME)?
    ;

xaEndTransaction
    : XA END xid (SUSPEND (FOR MIGRATE)?)?
    ;

xaPrepareStatement
    : XA PREPARE xid
    ;

xaCommitWork
    : XA COMMIT xid (ONE PHASE)?
    ;

xaRollbackWork
    : XA ROLLBACK xid
    ;

xaRecoverWork
    : XA RECOVER (CONVERT xid)?
    ;


// Prepared Statements

prepareStatement
    : PREPARE nameIdentifier FROM expr
    ;

executeStatement
    : EXECUTE nameIdentifier (USING userVariables)?
    ;

deallocatePrepare
    : dropFormat=(DEALLOCATE | DROP) PREPARE nameIdentifier
    ;


// Compound Statements
statementItem
	: statement (SEMI | EOF)
	;
// details
body
    : (beginName=nameIdentifier COLON)? BEGIN bodyItem* END endName=nameIdentifier?
    ;
bodyItem
	: bodyItemStatement (SEMI | EOF)
	;
bodyItemStatement
    : statement
    ;

caseStatement
	: CASE expr? caseStatementWhenItem+  caseStatementElseClause? END CASE
	;
caseStatementWhenItem
    : WHEN expr THEN statementItem
    ;
caseStatementElseClause
    : ELSE statementItem+
    ;

ifStatement
    : IF expr THEN then+=statementItem+ elseIf* (ELSE else_+=statementItem+)? END IF
    ;
elseIf
    : ELSEIF expr THEN statementItem+
    ;

iterateStatement
    : ITERATE nameIdentifier
    ;

leaveStatement
    : LEAVE nameIdentifier
    ;

loopStatement
    : (beginLabel=nameIdentifier COLON)? LOOP bodyItem+
      END LOOP endLabel=nameIdentifier?
    ;

repeatStatement
    : (beginLabel=nameIdentifier COLON)? REPEAT bodyItem+
        UNTIL expr
      END REPEAT endLabel=nameIdentifier?
    ;

returnStatement
    : RETURN expr
    ;

whileStatement
    : (beginLabel=nameIdentifier COLON)? WHILE expr
        DO bodyItem+
      END WHILE endLabel=nameIdentifier?
    ;

cursorStatement
    : CLOSE nameIdentifier                                                     #CloseCursor
    | FETCH (NEXT? FROM)? nameIdentifier INTO expr (COMMA expr)*                          #FetchCursor
    | OPEN nameIdentifier                                                      #OpenCursor
    ;

conditionHandling
	: declareVariable
	| declareCondition
	| declareCursor
	| declareHandler
	;
// details
declareVariable
    : DECLARE expr (COMMA expr)* dataType defaultClause
    ;

declareCondition
    : DECLARE nameIdentifier CONDITION FOR (expr | SQLSTATE VALUE? expr)
    ;

declareCursor
    : DECLARE nameIdentifier CURSOR FOR selectStatement
    ;

declareHandler
    : DECLARE handlerAction=(CONTINUE | EXIT | UNDO)
      HANDLER FOR handlerConditionValue (COMMA handlerConditionValue)* statement
    ;

handlerConditionValue
    : expr                                                #handlerConditionCode
    | SQLSTATE VALUE? expr                                #handlerConditionState
    | nameIdentifier                                                           #handlerConditionName
    | SQLWARNING                                                    #handlerConditionWarning
    | NOT FOUND                                                     #handlerConditionNotfound
    | SQLEXCEPTION                                                  #handlerConditionException
    ;


// Administration Statements

//    Account management statements

alterUserStatement
    : ALTER USER ifExists? userSpecification (COMMA userSpecification)*                    #alterUserMysqlV56
    | ALTER USER ifExists?
        userAuthOption (COMMA userAuthOption)*
        (
          REQUIRE
          (tlsNone=NONE | tlsOption (AND? tlsOption)* )
        )?
        (WITH userResourceOption+)?
        (userPasswordOption | userLockOption)*                      #alterUserMysqlV57
    ;

createUserStatement
    : CREATE USER ifNotExists? userAuthOption (COMMA userAuthOption)*
        (REQUIRE (tlsNone=NONE | tlsOption (AND? tlsOption)* ))?
        (WITH userResourceOption+)? (userPasswordOption | userLockOption)*
    ;

dropUserStatement
    : DROP USER ifExists? nameIdentifier (COMMA nameIdentifier)*
    ;

grantStatement
    : GRANT privelegeClause (COMMA privelegeClause)*
      ON
      privilegeObject=(TABLE | FUNCTION | PROCEDURE)?
      privilegeLevel
      TO userAuthOption (COMMA userAuthOption)*
      (
          REQUIRE
          (tlsNone=NONE | tlsOption (AND? tlsOption)* )
        )?
      (WITH (GRANT OPTION | userResourceOption)* )?
    ;

grantProxy
    : GRANT PROXY ON fromFirst=nameIdentifier
      TO toFirst=nameIdentifier (COMMA toOther+=nameIdentifier)*
      (WITH GRANT OPTION)?
    ;

renameUser
    : RENAME USER
      renameUserClause (COMMA renameUserClause)*
    ;

revokeStatement
    : REVOKE privelegeClause (COMMA privelegeClause)*
      ON
      privilegeObject=(TABLE | FUNCTION | PROCEDURE)?
      privilegeLevel
      FROM nameIdentifier (COMMA nameIdentifier)*                                 #detailRevoke
    | REVOKE ALL PRIVILEGES? COMMA GRANT OPTION
      FROM nameIdentifier (COMMA nameIdentifier)*                                 #shortRevoke
    ;

revokeProxy
    : REVOKE PROXY ON onUser=nameIdentifier
      FROM fromFirst=nameIdentifier (COMMA fromOther+=nameIdentifier)*
    ;

// details

userSpecification
    : nameIdentifier userPasswordOption
    ;

userAuthOption
    : nameIdentifier IDENTIFIED BY PASSWORD hashed=expr         #passwordAuthOption
    | nameIdentifier
      IDENTIFIED (WITH authPlugin)? BY expr               #stringAuthOption
    | nameIdentifier  IDENTIFIED WITH authPlugin (AS expr)?                                          #hashAuthOption
    | nameIdentifier                                                      #simpleAuthOption
    ;

tlsOption
    : SSL
    | X509
    | CIPHER expr
    | ISSUER expr
    | SUBJECT expr
    ;

userResourceOption
    : MAX_QUERIES_PER_HOUR expr
    | MAX_UPDATES_PER_HOUR expr
    | MAX_CONNECTIONS_PER_HOUR expr
    | MAX_USER_CONNECTIONS expr
    ;

userPasswordOption
    : PASSWORD EXPIRE
      (expireType=DEFAULT
      | expireType=NEVER
      | expireType=INTERVAL expr DAY
      )?
    ;

userLockOption
    : ACCOUNT lockType=(LOCK | UNLOCK)
    ;

privelegeClause
    : privilege ( LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN )?
    ;

privilege
    : ALL PRIVILEGES?
    | ALTER ROUTINE?
    | CREATE
      (TEMPORARY TABLES | ROUTINE | VIEW | USER | TABLESPACE)?
    | DELETE | DROP | EVENT | EXECUTE | FILE | GRANT OPTION
    | INDEX | INSERT | LOCK TABLES | PROCESS | PROXY
    | REFERENCES | RELOAD
    | REPLICATION (CLIENT | SLAVE)
    | SELECT
    | SHOW (VIEW | DATABASES)
    | SHUTDOWN | SUPER | TRIGGER | UPDATE | USAGE
    ;

privilegeLevel
    : '*'                                                           #currentSchemaPriviLevel
    | '*' '.' '*'                                                   #globalPrivLevel
    | nameIdentifier '.' '*'                                                   #definiteSchemaPrivLevel
    | nameIdentifier '.' nameIdentifier                                                   #definiteFullTablePrivLevel
    | nameIdentifier                                                           #definiteTablePrivLevel
    ;

renameUserClause
    : fromFirst=nameIdentifier TO toFirst=nameIdentifier
    ;

//    Table maintenance statements

analyzeTable
    : ANALYZE actionOption=(NO_WRITE_TO_BINLOG | LOCAL)?
       TABLE expr (COMMA expr)*
    ;

checkTable
    : CHECK TABLE expr (COMMA expr)* checkTableOption*
    ;

checksumTable
    : CHECKSUM TABLE expr (COMMA expr)* actionOption=(QUICK | EXTENDED)?
    ;

optimizeTable
    : OPTIMIZE actionOption=(NO_WRITE_TO_BINLOG | LOCAL)?
      TABLE expr (COMMA expr)*
    ;

repairTable
    : REPAIR actionOption=(NO_WRITE_TO_BINLOG | LOCAL)?
      TABLE expr (COMMA expr)*
      QUICK? EXTENDED? USE_FRM?
    ;

// details

checkTableOption
    : FOR UPGRADE | QUICK | FAST | MEDIUM | EXTENDED | CHANGED
    ;


//    Plugin and udf statements

createUdfunction
    : CREATE AGGREGATE? FUNCTION nameIdentifier
      RETURNS returnType=(STRING | INTEGER | REAL | DECIMAL)
      SONAME expr
    ;

installPlugin
    : INSTALL PLUGIN nameIdentifier SONAME expr
    ;

uninstallPlugin
    : UNINSTALL PLUGIN nameIdentifier
    ;


//    Set statements
setStatement
    : SET DEFAULT ROLE setDefaultRole (COMMA setDefaultRole)* TO expr (COMMA expr)*         #setDefaultRoleStatement
    | SET PASSWORD (FOR user=expr)? EQUALS_OP password=expr (REPLACE replace=expr)?         #setPasswordStatement
    | SET assignmentExpr (COMMA assignmentExpr)*                                            #setVariableStatement
    | SET CHARACTER SET expr                                                                #setCharacterSetStatement
    | SET CHARSET expr                                                                      #setCharsetStatement
    | SET NAMES expr                                                                        #setNamesStatement
    | SET priori=(GLOBAL | SESSION)? TRANSACTION
            transactionOption (COMMA transactionOption)*                                    #setTransactionStatement
    | setAutoCommitStatement                                                                #setAutocommit
    ;
setDefaultRole
	: allLiteral
	| noneLiteral
	| expr
	;


// show statements
showStatement
    : SHOW logFormat=(BINARY | MASTER) LOGS                         #showMasterLogs
    | SHOW logFormat=(BINLOG | RELAYLOG)
      EVENTS (IN filename=expr)?
        (FROM fromPosition=expr)?
        (LIMIT
          (offset=expr COMMA)?
          rowCount=expr
        )?                                                          #showLogEvents
    | SHOW showCommonEntity showFilter?                             #showObjectFilter
    | SHOW FULL? columnsFormat=(COLUMNS | FIELDS)
      tableFormat=(FROM | IN) nameIdentifier
        (schemaFormat=(FROM | IN) nameIdentifier)? showFilter?                 #showColumns
    | SHOW CREATE schemaFormat=(DATABASE | SCHEMA)
      ifNotExists? nameIdentifier                                              #showCreateDb
    | SHOW CREATE
        namedEntity=(
          EVENT | FUNCTION | PROCEDURE
          | TABLE | TRIGGER | VIEW
        )
        nameIdentifier                                                      #showCreatenameIdentifierObject
    | SHOW CREATE USER nameIdentifier                                     #showCreateUser
    | SHOW ENGINE engineName engineOption=(STATUS | MUTEX)          #showEngine
    | SHOW showGlobalInfoClause                                     #showGlobalInfo
    | SHOW errorFormat=(ERRORS | WARNINGS)
        (LIMIT
          (offset=expr COMMA)?
          rowCount=expr
        )                                                           #showErrors
    | SHOW COUNT LEFT_PAREN '*' RIGHT_PAREN errorFormat=(ERRORS | WARNINGS)        #showCountErrors
    | SHOW showSchemaEntity
        (schemaFormat=(FROM | IN) nameIdentifier)? showFilter?                 #showSchemaFilter
    | SHOW routine=(FUNCTION | PROCEDURE) CODE nameIdentifier               #showRoutine
    | SHOW GRANTS (FOR nameIdentifier)?                                   #showGrants
    | SHOW INDEX tableFormat=(FROM | IN) nameIdentifier (schemaFormat=(FROM | IN) nameIdentifier)? (WHERE expr)?        #showIndexes
    | SHOW KEY tableFormat=(FROM | IN) nameIdentifier (schemaFormat=(FROM | IN) nameIdentifier)? (WHERE expr)?          #showIndexes
    | SHOW KEYS tableFormat=(FROM | IN) nameIdentifier (schemaFormat=(FROM | IN) nameIdentifier)? (WHERE expr)?         #showIndexes
    | SHOW OPEN TABLES ( schemaFormat=(FROM | IN) nameIdentifier)?
      showFilter?                                                   #showOpenTables
    | SHOW PROFILE showProfileType (COMMA showProfileType)*
        (FOR QUERY queryCount=expr)?
        (LIMIT
          (offset=expr COMMA)?
          rowCount=expr
        )                                                           #showProfile
    | SHOW SLAVE STATUS (FOR CHANNEL expr)?               #showSlaveStatus
    ;

// details
showCommonEntity
    : CHARACTER SET | COLLATION | DATABASES | SCHEMAS
    | FUNCTION STATUS | PROCEDURE STATUS
    | (GLOBAL | SESSION)? (STATUS | VARIABLES)
    ;

showFilter
    : LIKE expr
    | WHERE expr
    ;

showGlobalInfoClause
    : STORAGE? ENGINES | MASTER STATUS | PLUGINS
    | PRIVILEGES | FULL? PROCESSLIST | PROFILES
    | SLAVE HOSTS | AUTHORS | CONTRIBUTORS
    ;

showSchemaEntity
    : EVENTS | TABLE STATUS | FULL? TABLES | TRIGGERS
    ;

showProfileType
    : ALL | BLOCK IO | CONTEXT SWITCHES | CPU | IPC | MEMORY
    | PAGE FAULTS | SOURCE | SWAPS
    ;


//    Other administrative statements

binlogStatement
    : BINLOG expr
    ;

cacheIndexStatement
    : CACHE INDEX tableIndexes (COMMA tableIndexes)*
      ( PARTITION LEFT_PAREN (expr (COMMA expr)* | ALL) RIGHT_PAREN )?
      IN schema=nameIdentifier
    ;

flushStatement
    : FLUSH flushFormat=(NO_WRITE_TO_BINLOG | LOCAL)?
      flushOption (COMMA flushOption)*
    ;

killStatement
    : KILL connectionFormat=(CONNECTION | QUERY)?
      expr+
    ;

loadIndexIntoCache
    : LOAD INDEX INTO CACHE
      loadedTableIndexes (COMMA loadedTableIndexes)*
    ;

// remark reset (maser | slave) describe in replication's
//  statements section
resetStatement
    : RESET QUERY CACHE
    ;

shutdownStatement
    : SHUTDOWN
    ;

// details

tableIndexes
    : nameIdentifier (indexFormat? LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN )?
    ;

flushOption
    : (
        DES_KEY_FILE | HOSTS
        | (
            BINARY | ENGINE | ERROR | GENERAL | RELAY | SLOW
          )? LOGS
        | OPTIMIZER_COSTS | PRIVILEGES | QUERY CACHE | STATUS
        | USER_RESOURCES | TABLES (WITH READ LOCK)?
       )                                                            #simpleFlushOption
    | RELAY LOGS channelOption?                                     #channelFlushOption
    | TABLES expr (COMMA expr)* flushTableOption?                               #tableFlushOption
    ;

flushTableOption
    : WITH READ LOCK
    | FOR EXPORT
    ;

loadedTableIndexes
    : nameIdentifier
      ( PARTITION LEFT_PAREN (partitionList=expr (COMMA expr)* | ALL) RIGHT_PAREN )?
      ( indexFormat? LEFT_PAREN indexList=expr (COMMA expr)* RIGHT_PAREN )?
      (IGNORE LEAVES)?
    ;


// Utility Statements


simpleDescribeStatement
    : command=(EXPLAIN | DESCRIBE | DESC) nameIdentifier
      (column=nameIdentifier | pattern=expr)?
    ;

fullDescribeStatement
    : command=(EXPLAIN | DESCRIBE | DESC)
      (
        formatType=(EXTENDED | PARTITIONS | FORMAT )
        EQUALS_OP
        formatValue=(TRADITIONAL | JSON)
      )?
      describeObjectClause
    ;

helpStatement
    : HELP expr
    ;

useStatement
    : USE nameIdentifier
    ;

// details

describeObjectClause
    : (
        selectStatement | deleteStatement | insertStatement
        | replaceStatement | updateStatement
      )                                                             #describeStatements
    | FOR CONNECTION nameIdentifier                                            #describeConnection
    ;


// Common Clauses

engineName
    : ARCHIVE | BLACKHOLE | CSV | FEDERATED | INNODB | MEMORY
    | MRG_MYISAM | MYISAM | NDB | NDBCLUSTER | PERFOMANCE_SCHEMA
    ;

unameIdentifierSet
    : expr '-' expr '-' expr
      '-' expr '-' expr
      (':' expr '-' expr)+
    ;

xid
    : globalnameIdentifierIdentifier=xnameIdentifierStringId
      (
        COMMA qualifier=xnameIdentifierStringId
        (COMMA idFormat=expr)?
      )?
    ;

xnameIdentifierStringId
    : expr
    | BIT_STRING
    | HEXADECIMAL_LITERAL+
    ;

authPlugin
    : nameIdentifier | expr
    ;

null_:          NULL_LITERAL | NULL_SPEC_LITERAL;
notNull:        NOT null_;

convertedDataType
    : typeName=(BINARY| NCHAR) lengthOneDimension?
    | typeName=CHAR lengthOneDimension? characterSetOptionExpr?
    | typeName=(DATE | DATETIME | TIME)
    | typeName=DECIMAL lengthTwoDimension?
    | (SIGNED | UNSIGNED) INTEGER?
    ;

lengthOneDimension
    : LEFT_PAREN expr RIGHT_PAREN
    ;

lengthTwoDimension
    : LEFT_PAREN expr COMMA expr RIGHT_PAREN
    ;

lengthTwoOptionalDimension
    : LEFT_PAREN expr (COMMA expr)? RIGHT_PAREN
    ;


//    Common Lists

simpleStrings
    : expr (COMMA expr)*
    ;

userVariables
    : LOCAL_ID (COMMA LOCAL_ID)*
    ;


//    Common Expressons

levelsInWeightString
    : LEVEL levelInWeightListElement
      (COMMA levelInWeightListElement)*                               #levelWeightList
    | LEVEL firstLevel=expr '-' lastLevel=expr        #levelWeightRange
    ;

levelInWeightListElement
    : expr orderType=(ASC | DESC | REVERSE)?
    ;

aggregateWindowedFunction
    : (AVG | MAX | MIN | SUM)
      LEFT_PAREN aggregator=(ALL | DISTINCT)? expr (COMMA expr)* RIGHT_PAREN
    | COUNT LEFT_PAREN (starArg='*' | aggregator=ALL? expr (COMMA expr)*) RIGHT_PAREN
    | COUNT LEFT_PAREN aggregator=DISTINCT expr (COMMA expr)* RIGHT_PAREN
    | (
        BIT_AND | BIT_OR | BIT_XOR | STD | STDDEV | STDDEV_POP
        | STDDEV_SAMP | VAR_POP | VAR_SAMP | VARIANCE
      ) LEFT_PAREN aggregator=ALL? expr (COMMA expr)* RIGHT_PAREN
    | GROUP_CONCAT LEFT_PAREN
        aggregator=DISTINCT? expr (COMMA expr)*
        orderByClause? (SEPARATOR separator=expr)?
      RIGHT_PAREN
    ;



// Add in ASTVisitor nullNotnull in constant


//    Simple id sets
charsetNameBase
    : ARMSCII8 | ASCII | BIG5 | CP1250 | CP1251 | CP1256 | CP1257
    | CP850 | CP852 | CP866 | CP932 | DEC8 | EUCJPMS | EUCKR
    | GB2312 | GBK | GEOSTD8 | GREEK | HEBREW | HP8 | KEYBCS2
    | KOI8R | KOI8U | LATIN1 | LATIN2 | LATIN5 | LATIN7 | MACCE
    | MACROMAN | SJIS | SWE7 | TIS620 | UCS2 | UJIS | UTF16
    | UTF16LE | UTF32 | UTF8 | UTF8MB3 | UTF8MB4
    ;

transactionLevelBase
    : REPEATABLE | COMMITTED | UNCOMMITTED | SERIALIZABLE
    ;

privilegesBase
    : TABLES | ROUTINE | EXECUTE | FILE | PROCESS
    | RELOAD | SHUTDOWN | SUPER | PRIVILEGES
    ;

dataTypeBase
    : DATE | TIME | TIMESTAMP | DATETIME | YEAR | ENUM | TEXT
    ;

keywordsCanBeId
    : ACCOUNT
    | ACTION
    | AFTER
    | AGGREGATE
    | ALGORITHM
    | ANY
    | AT
    | AUTHORS
    | AUTOCOMMIT
    | AUTOEXTEND_SIZE
    | AUTO_INCREMENT
    | AVG_ROW_LENGTH
    | BEGIN
    | BINLOG
    | BIT
    | BLOCK
    | BOOL
    | BOOLEAN
    | BTREE
    | CASCADED
    | CHAIN
    | CHANNEL
    | CHECKSUM
    | CIPHER
    | CLIENT
    | COALESCE
    | CODE
    | COLUMNS
    | COLUMN_FORMAT
    | COMMENT | COMMIT | COMPACT
    | COMPLETION | COMPRESSED | COMPRESSION | CONCURRENT
    | CONNECTION | CONSISTENT | CONTAINS | CONTEXT
    | CONTRIBUTORS | COPY | CPU | DATA | DATAFILE | DEALLOCATE
    | DEFAULT_AUTH | DEFINER | DELAY_KEY_WRITE | DIRECTORY
    | DISABLE | DISCARD | DISK | DO | DUMPFILE | DUPLICATE
    | DYNAMIC | ENABLE | ENCRYPTION | ENDS | ENGINE | ENGINES
    | ERROR | ERRORS | ESCAPE | EVEN | EVENT | EVENTS | EVERY
    | EXCHANGE | EXCLUSIVE | EXPIRE | EXTENT_SIZE | FAULTS
    | FIELDS | FILE_BLOCK_SIZE | FILTER | FIRST | FIXED
    | FOLLOWS | FULL | FUNCTION | GLOBAL | GRANTS
    | GROUP_REPLICATION | HASH | HOST
    | IDENTIFIED
    | IGNORE_SERVER_IDS
    | IMPORT
    | INDEXES
    | INITIAL_SIZE
    | INPLACE
    | INSERT_METHOD
    | INSTANCE | INVOKER
    | IO
    | IO_THREAD | IPC | ISOLATION | ISSUER | KEY_BLOCK_SIZE
    | LANGUAGE | LAST | LEAVES | LESS | LEVEL | LIST | LOCAL
    | LOGFILE | LOGS | MASTER | MASTER_AUTO_POSITION
    | MASTER_CONNECT_RETRY | MASTER_DELAY
    | MASTER_HEARTBEAT_PERIOD | MASTER_HOST | MASTER_LOG_FILE
    | MASTER_LOG_POS | MASTER_PASSWORD | MASTER_PORT
    | MASTER_RETRY_COUNT | MASTER_SSL | MASTER_SSL_CA
    | MASTER_SSL_CAPATH | MASTER_SSL_CERT | MASTER_SSL_CIPHER
    | MASTER_SSL_CRL | MASTER_SSL_CRLPATH | MASTER_SSL_KEY
    | MASTER_TLS_VERSION | MASTER_USER
    | MAX_CONNECTIONS_PER_HOUR | MAX_QUERIES_PER_HOUR
    | MAX_ROWS
    | MAX_SIZE
    | MAX_UPDATES_PER_HOUR
    | MAX_USER_CONNECTIONS
    | MEMORY
    | MERGE
    | MID
    | MIGRATE
    | MIN_ROWS
    | MODIFY
    | MUTEX | MYSQL
    | NAME | NAMES
    | NCHAR | NEVER | NO | NODEGROUP | NONE | OFFLINE | OFFSET
    | OJ | OLD_PASSWORD | ONE | ONLINE | ONLY | OPTIMIZER_COSTS
    | OPTIONS | OWNER | PACK_KEYS | PAGE | PARSER | PARTIAL
    | PARTITIONING | PARTITIONS | PASSWORD | PHASE | PLUGINS
    | PLUGIN_DIR | PORT | PRECEDES | PREPARE | PRESERVE | PREV
    | PROCESSLIST | PROFILE | PROFILES | PROXY | QUERY | QUICK
    | REBUILD | RECOVER | REDO_BUFFER_SIZE | REDUNDANT
    | RELAYLOG | RELAY_LOG_FILE | RELAY_LOG_POS | REMOVE
    | REORGANIZE | REPAIR | REPLICATE_DO_DB | REPLICATE_DO_TABLE
    | REPLICATE_IGNORE_DB | REPLICATE_IGNORE_TABLE
    | REPLICATE_REWRITE_DB | REPLICATE_WILD_DO_TABLE
    | REPLICATE_WILD_IGNORE_TABLE | REPLICATION | RESUME
    | RETURNS | ROLLBACK | ROLLUP | ROTATE | ROW | ROWS
    | ROW_FORMAT | SAVEPOINT | SCHEDULE | SECURITY | SERVER
    | SESSION | SHARE | SHARED | SIGNED | SIMPLE | SLAVE
    | SNAPSHOT | SOCKET | SOME | SOUNDS | SOURCE
    | SQL_AFTER_GTIDS | SQL_AFTER_MTS_GAPS | SQL_BEFORE_GTIDS
    | SQL_BUFFER_RESULT | SQL_CACHE | SQL_NO_CACHE | SQL_THREAD
    | START | STARTS | STATS_AUTO_RECALC | STATS_PERSISTENT
    | STATS_SAMPLE_PAGES
    | STATUS | STOP | STORAGE | STRING
    | SUBJECT
    | SUBPARTITION
    | SUBPARTITIONS
    | SUM
    | SUSPEND
    | SWAPS
    | SWITCHES
    | TABLESPACE
    | TEMPORARY
    | TEMPTABLE
    | THAN
    | TRANSACTION
    | TRUNCATE
    | UNDEFINED
    | UNDOFILE
    | UNDO_BUFFER_SIZE
    | UNKNOWN
    | UPGRADE
    | USER
    | VALIDATION
    | VALUE
    | VARIABLES
    | VIEW
    | WAIT
    | WARNINGS
    | WITHOUT
    | WORK
    | WRAPPER
    | X509
    | XA
    | XML
    ;

// string
allTokens
	: charsetNameBase
	| transactionLevelBase
	| engineName
	| privilegesBase
	| dataTypeBase
	| keywordsCanBeId
	| INSERT
	| LEFT
	| MOD
	| REPLACE
	| REVERSE
	| RIGHT
	| SUBSTR
	| SUBSTRING
	;
// Data Type
// https://dev.mysql.com/doc/refman/8.0/en/data-types.html
dataType
    : iStringDataType | iNumericDatatype | iDateTimeDataType
    | spatialDataType
    | iBoolDataType
    | iJsonDataType
    | otherDataType
    ;

iNumericDatatype
	: BIT (LEFT_PAREN expr RIGHT_PAREN)?                                                    #bitDataType
	| TINYINT (LEFT_PAREN expr RIGHT_PAREN)? UNSIGNED? ZEROFILL?                            #tinyintDataType
	| SMALLINT (LEFT_PAREN expr RIGHT_PAREN)? UNSIGNED? ZEROFILL?                           #smallintDataType
	| MEDIUMINT (LEFT_PAREN expr RIGHT_PAREN)? UNSIGNED? ZEROFILL?                          #mediumintDataType
	| INT (LEFT_PAREN expr RIGHT_PAREN)? UNSIGNED? ZEROFILL?                                #intDataType
	| INTEGER (LEFT_PAREN expr RIGHT_PAREN)? UNSIGNED? ZEROFILL?                            #integerDataType
	| BIGINT (LEFT_PAREN expr RIGHT_PAREN)? UNSIGNED? ZEROFILL?                             #bigintDataType
	| DECIMAL (LEFT_PAREN expr (COMMA expr)? RIGHT_PAREN)? UNSIGNED? ZEROFILL?              #decimalDataType
	| DEC (LEFT_PAREN expr (COMMA expr)? RIGHT_PAREN)? UNSIGNED? ZEROFILL?                  #decDataType
	| NUMERIC (LEFT_PAREN expr (COMMA expr)? RIGHT_PAREN)? UNSIGNED? ZEROFILL?              #numericDataType
	| FIXED (LEFT_PAREN expr (COMMA expr)? RIGHT_PAREN)? UNSIGNED? ZEROFILL?                #fixedDataType
	| FLOAT (LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN)? UNSIGNED? ZEROFILL?                #floatDataType
	| DOUBLE (LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN)? UNSIGNED? ZEROFILL?               #doubleDataType
	| DOUBLE PRECISION (LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN)? UNSIGNED? ZEROFILL?     #doublePrecisionDataType
	| REAL (LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN)? UNSIGNED? ZEROFILL?                 #realDataType
	;
iStringDataType
	: CHAR (LEFT_PAREN expr RIGHT_PAREN)? characterSetOptionExpr? collateOptionExpr?                    #charDataType
	| NATIONAL CHAR (LEFT_PAREN expr RIGHT_PAREN)? characterSetOptionExpr? collateOptionExpr?           #nationalCharDataType
	| VARCHAR (LEFT_PAREN expr RIGHT_PAREN)? characterSetOptionExpr? collateOptionExpr?                 #varcharDataType
	| NATIONAL VARCHAR (LEFT_PAREN expr RIGHT_PAREN)? characterSetOptionExpr? collateOptionExpr?        #nationalVarcharDataType
	| BINARY (LEFT_PAREN expr RIGHT_PAREN)?                                                 #binaryDataType
	| VARBINARY (LEFT_PAREN expr RIGHT_PAREN)?                                              #varBinaryDataType
	| TINYBLOB                                                                              #tinyBlobDataType
	| TINYTEXT characterSetOptionExpr? collateOptionExpr?                                               #tinyTextDataType
	| BLOB (LEFT_PAREN expr RIGHT_PAREN)?                                                   #blobDataType
	| TEXT (LEFT_PAREN expr RIGHT_PAREN)? characterSetOptionExpr? collateOptionExpr?                    #textDataType
	| MEDIUMBLOB                                                                            #mediumBlobDataType
	| MEDIUMTEXT characterSetOptionExpr? collateOptionExpr?                                             #mediumTextDataType
	| LONGBLOB                                                                              #longBlobDataType
	| LONGTEXT characterSetOptionExpr? collateOptionExpr?                                               #longTextDataType
	| ENUM (LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN)? characterSetOptionExpr? collateOptionExpr?      #enumDataType
	| SET (LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN)? characterSetOptionExpr? collateOptionExpr?       #setDataType
	;

iDateTimeDataType
	: DATE                                                                      #dateDataType
	| DATETIME (LEFT_PAREN expr RIGHT_PAREN)?                                   #datetimeDataType
	| TIMESTAMP (LEFT_PAREN expr RIGHT_PAREN)?                                  #timestampDataType
	| TIME (LEFT_PAREN expr RIGHT_PAREN)?                                       #timeDataType
	| YEAR (LEFT_PAREN expr RIGHT_PAREN)?                                       #yearDataType
	;
spatialDataType
	: GEOMETRY                              #geometryDataType
	| POINT                                 #pointDataType
	| LINESTRING                            #lineStringDataType
	| POLYGON                               #polygonDataType
	| MULTIPOINT                            #multiPointDataType
	| MULTILINESTRING                       #multiLineStringDataType
	| MULTIPOLYGON                          #multiPolygonDataType
	| GEOMETRYCOLLECTION                    #geometryCollectionDataType
	;

iBoolDataType
	: BOOL                          #boolDataType
	| BOOLEAN                       #booleanDataType
	;
iJsonDataType
	: JSON                          #jsonDataType
	;
otherDataType
	: name=nameIdentifier (LEFT_PAREN expr? (COMMA expr)* RIGHT_PAREN)?
	;


// Identifier
identifier
	: ASTERISK                                                      #asteriskIdentifier
	| REGULAR_ID                                                    #normalIdentifier
	| allTokens                                                     #normalIdentifier
	| REVERSE_QUOTE_ID                                              #reverseQuoteIdentifier
	| CHARSET_REVERSE_QOUTE_STRING                                  #reverseQuoteIdentifier
	| DELIMITED_ID                                                  #doubleQuoteIdentifier1
	;

nameIdentifier
	: identifier                                                    #identifier1
    | identifier (PERIOD identifier)+                               #propertyIdentifier1
	;

// Literals
literal
	: NCHAR_STRING                                                                          #nCharLiteral
	| CHAR_STRING                                                                           #charLiteral
	| DELIMITED_ID                                                                          #doubleQuoteIdentifier2
	| STRING_CHARSET_NAME CHAR_STRING                                                       #charsetNamChareLiteral
	| MINUS_SIGN? UNSIGNED_INTEGER                                                          #integerLiteral
	| MINUS_SIGN? APPROXIMATE_NUM_LIT                                                       #numberLiteral

	| DATE expr                                                                             #dateLiteral
	| TIME expr                                                                             #timeLiteral
	| TIMESTAMP value=expr                                                                  #timestampLiteral
	
	| INTERVAL expr intervalType                                                            #intervalLiteral

	| HEXADECIMAL_LITERAL                                                                   #hexadecimalLiteral
	| BIT_STRING                                                                            #bitLiteral

	| FALSE                                                                                 #falseLiteral
    | TRUE                                                                                  #trueLiteral
    | NULL_LITERAL                                                                          #nullLiteral

	;


intervalType
    : MICROSECOND | SECOND | MINUTE | HOUR | DAY | WEEK | MONTH | QUARTER | YEAR
    | SECOND_MICROSECOND | MINUTE_MICROSECOND | MINUTE_SECOND
    | HOUR_MICROSECOND | HOUR_SECOND | HOUR_MINUTE
    | DAY_MICROSECOND | DAY_SECOND | DAY_MINUTE	| DAY_HOUR
    | YEAR_MONTH
    ;

// --------- Operators Start ---------------
unaryOperatorExpr
	: LEFT_PAREN? unaryOperator expr RIGHT_PAREN?
	;
unaryOperator
	: PLUS_SIGN
	| MINUS_SIGN
	| EXCLAMATION_OP
	| BIT_NOT_OP
	| BINARY
	;

// --------- Operators End ---------------

// --------- exprs Start ---------------

variableExpr:                                   QUESTION_MARK;
localVariableExpr:                              AT_SIGN identifier;
globalVariableExpr:                             AT_SIGN AT_SIGN identifier;

globalGlobalVariableExpr:                       (AT_SIGN AT_SIGN GLOBAL PERIOD | GLOBAL) identifier;
sessionGlobalVariableExpr:                      (AT_SIGN AT_SIGN SESSION PERIOD | SESSION) identifier;
persistGlobalVariableExpr:                      (AT_SIGN AT_SIGN PERSIST PERIOD| PERSIST) identifier;
persistOnlyGlobalVariableExpr:                  (AT_SIGN AT_SIGN PERSIST_ONLY PERIOD| PERSIST_ONLY) identifier;

rowExpr
	: ROW LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN
	;

selectQueryExpr
	: LEFT_PAREN? iSelectQuery RIGHT_PAREN?
	;

matchExpr
	: MATCH LEFT_PAREN matchs+=expr (COMMA matchs+=expr)* RIGHT_PAREN AGAINST LEFT_PAREN against+=expr searchModifier? RIGHT_PAREN
	;
searchModifier
	: IN NATURAL LANGUAGE MODE
	| IN NATURAL LANGUAGE MODE WITH QUERY EXPANSION
	| IN BOOLEAN MODE
	| WITH QUERY EXPANSION
	;

caseExpr
	: CASE expr? caseExprWhenItem+ caseExprElseClause? END
	;
caseExprWhenItem
	: WHEN when=expr? THEN then=expr
	;
caseExprElseClause
	: ELSE expr
	;

listExpr
    : LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN
	;

exprBasic
	: variableExpr
    | localVariableExpr
    | globalVariableExpr
    | globalGlobalVariableExpr
    | sessionGlobalVariableExpr
    | persistGlobalVariableExpr
    | persistOnlyGlobalVariableExpr

	| function
	| literal

	| unaryOperatorExpr

	| nameIdentifier

	| rowExpr
	| matchExpr
	| caseExpr
	| selectQueryExpr
	| listExpr
	;

expr
	: CURSOR LEFT_PAREN iSelectQuery RIGHT_PAREN                                                                        #cursorExpr

    | ANY LEFT_PAREN expr RIGHT_PAREN                                                                                   #anyExpr
	| ALL LEFT_PAREN expr RIGHT_PAREN                                                                                   #allExpr
	| SOME LEFT_PAREN expr RIGHT_PAREN                                                                                  #someExpr

	| NEW PERIOD nameIdentifier                                                                                         #newVariableRefExpr
	| OLD PERIOD nameIdentifier                                                                                         #oldVariableRefExpr

	| noArgumentFunctionName (LEFT_PAREN (arguments+=expr (COMMA arguments+=expr)*)? RIGHT_PAREN)?                      #methodInvocation1


	| name=expr LEFT_PAREN (setQuantifier? arguments+=expr (COMMA arguments+=expr)*)? RIGHT_PAREN                       #methodInvocation2
	| expr TO expr                                                                                                      #exprToExprExpr

	| LEFT_PAREN expr operator=BIT_XOR_OP expr RIGHT_PAREN                                                              #binaryOperatorExpr
	| LEFT_PAREN expr operator=(ASTERISK | DIVIDE | MOD | PERCENT | DIV) expr RIGHT_PAREN                               #binaryOperatorExpr
	| LEFT_PAREN expr operator=(PLUS_SIGN | MINUS_SIGN) expr RIGHT_PAREN                                                #binaryOperatorExpr
	| LEFT_PAREN expr operator=(PLUS_SIGN | MINUS_SIGN) expr RIGHT_PAREN                                                #binaryOperatorExpr
	| LEFT_PAREN expr operator=(LESS_THAN_LESS_THAN_OP | GREATER_THAN_GREATER_THAN_OP) expr RIGHT_PAREN                 #binaryOperatorExpr
	| LEFT_PAREN expr operator=BIT_AND_OP expr RIGHT_PAREN                                                              #binaryOperatorExpr
	| LEFT_PAREN expr operator=BIT_OR_OP expr RIGHT_PAREN                                                               #binaryOperatorExpr
	| LEFT_PAREN expr comparisonOp expr RIGHT_PAREN                                                                     #comparisonBinaryOperatorExpr

	| expr operator=BIT_XOR_OP expr                                                                                     #binaryOperatorExpr
	| expr operator=(ASTERISK | DIVIDE | MOD | PERCENT| DIV) expr                                                       #binaryOperatorExpr
    | expr operator=(PLUS_SIGN | MINUS_SIGN) expr                                                                       #binaryOperatorExpr
    | expr operator=(LESS_THAN_LESS_THAN_OP | GREATER_THAN_GREATER_THAN_OP) expr                                        #binaryOperatorExpr
    | expr operator=BIT_AND_OP expr                                                                                     #binaryOperatorExpr
    | expr operator=BIT_OR_OP expr                                                                                      #binaryOperatorExpr
    | expr comparisonOp expr                                                                                            #comparisonBinaryOperatorExpr

	| expr IS NOT? (TRUE|FALSE|UNKNOWN)                                                                                 #isBooleanLiteralCondition
	| name=expr NOT? IN LEFT_PAREN values+=expr (COMMA values+=expr)* RIGHT_PAREN                                       #inCondition
    | value=expr SOUNDS LIKE pattern=expr                                                                               #soundsLikeCondition
    | value=expr NOT? operator=LIKE pattern=expr (ESCAPE escape=expr)?                                                  #likeCondition
    | value=expr NOT? operator=RLIKE pattern=expr                                                                       #rlikeCondition
    | value=expr NOT? REGEXP pattern=expr                                                                               #regexpCondition
    | expr IS NOT? NULL_LITERAL                                                                                         #isNullCondition
	| name=expr NOT? BETWEEN between=expr AND and=expr                                                                  #betweenCondition
	| condition                                                                                                         #iCondition
	| exprBasic                                                                                                         #basicExpr

	| expr PERIOD nameIdentifier                                                                                        #propertyIdentifier2

	| LEFT_PAREN expr operator=COLLATE expr RIGHT_PAREN                                                                 #binaryOperatorExpr
	| expr operator=COLLATE expr
	                                                                                                                    #binaryOperatorExpr
	| LEFT_PAREN expr operator=(LOGIC_AND_OP|AND) expr RIGHT_PAREN                                                      #binaryOperatorExpr
	| LEFT_PAREN expr operator=XOR expr RIGHT_PAREN                                                                     #binaryOperatorExpr
	| LEFT_PAREN expr operator=(LOGIC_OR_OP|OR) expr RIGHT_PAREN                                                        #binaryOperatorExpr
	| LEFT_PAREN expr operator=ASSIGN_OP expr RIGHT_PAREN                                                               #binaryOperatorExpr
	| expr operator=(LOGIC_AND_OP|AND) expr                                                                             #binaryOperatorExpr
	| expr operator=XOR expr                                                                                            #binaryOperatorExpr
	| expr operator=(LOGIC_OR_OP|OR) expr                                                                               #binaryOperatorExpr
	| expr operator=ASSIGN_OP expr                                                                                      #binaryOperatorExpr
	;


comparisonOp
	: EQUALS_OP

	| LESS_THAN_OR_EQUAL_OR_GREATER_THAN_OP
	| NOT_EQUAL_OP
	| EXCLAMATION_OP EQUALS_OP
	| LESS_THAN_OP GREATER_THAN_OP

	| GREATER_THAN_OP

	| GREATER_THAN_OR_EQUALS_OP
	| GREATER_THAN_OP EQUALS_OP

	| LESS_THAN_OP

	| LESS_THAN_OR_EQUALS_OP
	| LESS_THAN_OP EQUALS_OP
	;

defaultClause
	: DEFAULT expr
	;
autoIncrementOptionExpr
	: AUTO_INCREMENT EQUALS_OP? expr
 	;
avgRowLengthOptionExpr
	: AVG_ROW_LENGTH EQUALS_OP? expr
	;
characterSetOptionExpr
	: DEFAULT? CHARACTER SET EQUALS_OP? nameIdentifier
	;
charsetOptionExpr
	: DEFAULT? CHARSET EQUALS_OP? nameIdentifier
	;
checksumOptionExpr
	: CHECKSUM EQUALS_OP? expr
	;
collateOptionExpr
	: DEFAULT? COLLATE EQUALS_OP? nameIdentifier
	;
commentOptionExpr
	: COMMENT EQUALS_OP? expr
	;
compressionOptionExpr
	: COMPRESSION EQUALS_OP? expr
	;
connectionOptionExpr
	: CONNECTION EQUALS_OP? expr
	;
dataDirectoryOptionExpr
	: DATA DIRECTORY EQUALS_OP? expr
	;
indexDirectoryOptionExpr
	: INDEX DIRECTORY EQUALS_OP? expr
	;
delayKeyWriteOptionExpr
	: DELAY_KEY_WRITE EQUALS_OP? expr
	;
encryptionOptionExpr
	: ENCRYPTION EQUALS_OP? expr
	;
engineOptionExpr
	: ENGINE EQUALS_OP? expr
	;
insertMethodOptionExpr
	: INSERT_METHOD EQUALS_OP? insertMethod=(NO | FIRST | LAST)
	;
keyBlockSizeOptionExpr
	: KEY_BLOCK_SIZE EQUALS_OP? expr
	;
maxRowsOptionExpr
	: MAX_ROWS EQUALS_OP? expr
	;
minRowsOptionExpr
	: MIN_ROWS EQUALS_OP? expr
	;
packKeysOptionExpr
	: PACK_KEYS EQUALS_OP? expr
	;
passwordOptionExpr
	: PASSWORD EQUALS_OP? expr
	;
rowFormatOptionExpr
	: ROW_FORMAT EQUALS_OP? rowFormat=(DEFAULT | DYNAMIC | FIXED | COMPRESSED| REDUNDANT | COMPACT)
	;
statsAutoRecalcOptionExpr
	: STATS_AUTO_RECALC EQUALS_OP? expr
	;
statsPersistentOptionExpr
	: STATS_PERSISTENT EQUALS_OP? expr
	;
statsSamplePageOptionExpr
	: STATS_SAMPLE_PAGES EQUALS_OP? expr
	;
tablespaceOptionExpr
	: TABLESPACE nameIdentifier (STORAGE (DISK | MEMORY | DEFAULT))?
	;
unionOptionExpr
	: UNION EQUALS_OP? expr
	;
broadcastExpr
	: BROADCAST
	;

assignmentExpr
	: name=expr EQUALS_OP value=expr
	;

defaultLiteral
	: DEFAULT
	;
allLiteral
	: ALL
	;
noneLiteral
	: NONE
	;
maxValueLiteral
	: MAXVALUE
	;
// --------- exprs End ---------------


// --------- Conditions Start ---------------
condition
	: notCondition
	| existsCondition
	;

notCondition
	: NOT expr
	;

formatJson
	: FORMAT JSON
	;

exprAsObjectExpr
	: expr AS? (expr | dataType)
	;

existsCondition
	: EXISTS LEFT_PAREN iSelectQuery RIGHT_PAREN
	;

// --------- Conditions End ---------------

// --------- Functions Start ---------------

specificFunction
    : CAST LEFT_PAREN expr AS dataType RIGHT_PAREN          #castFunction
    | CHAR LEFT_PAREN expr (COMMA expr)*  (USING expr)? RIGHT_PAREN #charFunction
    | CONVERT LEFT_PAREN expr separator=COMMA convertedDataType RIGHT_PAREN    #dataTypeFunctionCall
    | CONVERT LEFT_PAREN expr USING expr RIGHT_PAREN                  #dataTypeFunctionCall
    | VALUES LEFT_PAREN expr RIGHT_PAREN                                 #valuesFunctionCall
    | POSITION
      LEFT_PAREN expr IN ( inString=expr | inexpr=expr)RIGHT_PAREN     #positionFunctionCall
    | (SUBSTR | SUBSTRING)
      LEFT_PAREN expr FROM expr (FOR expr)? RIGHT_PAREN                            #substrFunctionCall
    | TRIM LEFT_PAREN positioinForm=(BOTH | LEADING | TRAILING) expr? FROM expr RIGHT_PAREN   #trimFunctionCall
    | TRIM LEFT_PAREN expr FROM expr RIGHT_PAREN                                              #trimFunctionCall
    | WEIGHT_STRING
      LEFT_PAREN expr (AS stringFormat=(CHAR | BINARY) LEFT_PAREN expr RIGHT_PAREN )?  levelsInWeightString? RIGHT_PAREN   #weightFunctionCall
    | GET_FORMAT LEFT_PAREN datetimeFormat=(DATE | TIME | DATETIME)  COMMA expr RIGHT_PAREN       #getFormatFunctionCall
    ;


function
	: specificFunction
    | trimFunction
	| extractFunction
	| treatFunction
	| convertUsingFunction

	| jsonFunction
	| aggregateFunction
	| firstFunction
	| lastFunction
	| listAggFunction
	| cubeTableFunction
	| windowFunction
	;

noArgumentFunctionName
	: CURRENT_DATE
	| CURRENT_TIME
	| CURRENT_TIMESTAMP
	| CURRENT_USER
	| LOCALTIME
    | LOCALTIMESTAMP
    | UTC_DATE
    | UTC_TIME
    | UTC_TIMESTAMP
	;

positionFunction
	: POSITION LEFT_PAREN expr IN expr RIGHT_PAREN
	;
subStrFromFunction
	: SUBSTR LEFT_PAREN expr FROM expr (FOR expr)? RIGHT_PAREN
	;
subStringFunction
	: SUBSTRING LEFT_PAREN expr FROM expr (FOR expr)? RIGHT_PAREN
	;
trimFunction
	: TRIM LEFT_PAREN((LEADING | TRAILING | BOTH)? character=expr? FROM)? source=expr RIGHT_PAREN
	;
weightStringFunction
	: WEIGHT_STRING LEFT_PAREN expr (AS dataType)? RIGHT_PAREN
	;


extractFunction
	: EXTRACT LEFT_PAREN intervalType FROM expr RIGHT_PAREN
	;

treatFunction
	: TREAT LEFT_PAREN expr AS REF? dataType RIGHT_PAREN
	;

convertUsingFunction
	: CONVERT LEFT_PAREN expr USING nameIdentifier RIGHT_PAREN
	;

costMatrixClause
	: COST MODEL AUTO?
	| COST LEFT_PAREN classValues+=expr (COMMA classValues+=expr)* RIGHT_PAREN
		VALUES LEFT_PAREN  costValues+=expr (COMMA  costValues+=expr)*
	;

jsonFunction
    : jsonFunctionName LEFT_PAREN expr (COMMA expr)* orderByClause?
        jsonOnNullClause? jsonReturningClause? STRICT? withUniqueKeys? jsonWrapperClause? jsonOnErrorClause? jsonOnEmptyClause? jsonColumnsClause? RIGHT_PAREN
    ;
jsonFunctionName
	: JSON_TABLE
	| JSON_ARRAY
	| JSON_ARRAYAGG
	| JSON_OBJECT
	| JSON_OBJECTAGG
	;
jsonFunctionArgument
	: expr
	| jsonFormatJsonArgumentExpr
	| jsonKeyValueArgumentExpr
	;
jsonFormatJsonArgumentExpr
	: expr formatJson
	;
jsonKeyValueArgumentExpr
	: KEY? key=expr VALUE val=expr
	;
jsonOnNullClause
	: (NULL | ABSENT) ON NULL
	;
jsonReturningClause
	: (RETURNING dataType)? PRETTY? ASCII?
	;
withUniqueKeys
	: WITH UNIQUE KEYS
	;
jsonWrapperClause
	: WITHOUT ARRAY? WRAPPER
    | WITH (UNCONDITIONAL | CONDITIONAL)? ARRAY? WRAPPER
	;
jsonOnErrorClause
	: (ERROR
      | NULL
      | EMPTY
      | EMPTY ARRAY
      | EMPTY OBJECT
      | DEFAULT expr
      ) ON ERROR
	;
jsonOnEmptyClause
	: ( ERROR
      | NULL
      | EMPTY
      | EMPTY ARRAY
      | EMPTY OBJECT
      | DEFAULT expr
      ) ON EMPTY
	;
jsonColumnsClause
	: COLUMNS LEFT_PAREN jsonColumnDefinition (COMMA jsonColumnDefinition)* RIGHT_PAREN
	;
jsonColumnDefinition
	: nameIdentifier dataType EXISTS (PATH path=expr)? jsonOnErrorClause?                                               #jsonExistsColumn
	| nameIdentifier dataType formatJson jsonWrapperClause? (PATH path=expr)? jsonOnErrorClause?                        #jsonQueryColumn
	| nameIdentifier dataType EXISTS (PATH path=expr)? jsonOnErrorClause?                                               #jsonValueColumn
	| NESTED PATH? path=expr jsonColumnsClause                                                                          #jsonNestedPathColumn
	| nameIdentifier FOR ORDINALITY                                                                                     #jsonOrdinalityColumn
	;


aggregateFunction
	: aggregateFunctionName LEFT_PAREN (setQuantifier? expr DETERMINISTIC? partitionByClause? orderByClause?)? (COMMA expr)*
		withinGroupSpecification? overClause? RIGHT_PAREN
	;
aggregateFunctionName
	: APPROX_COUNT
    | APPROX_COUNT_DISTINCT
	| APPROX_COUNT_DISTINCT_AGG
	| APPROX_COUNT_DISTINCT_DETAIL
	| APPROX_MEDIAN
	| APPROX_PERCENTILE
	| APPROX_PERCENTILE_AGG
	| APPROX_PERCENTILE_DETAIL
	| APPROX_RANK
	| APPROX_SUM
	| AVG
	| COLLECT
	| CORR
	| CORR_S
	| CORR_K
	| COUNT
	| COVAR_POP
	| COVAR_SAMP
	| CUME_DIST
	| DENSE_RANK
	| GROUP_ID
	| GROUPING
	| GROUPING_ID
	| MAX
	| MEDIAN
	| MIN
	| PERCENT_RANK
	| PERCENTILE_CONT
	| PERCENTILE_DISC
	| RANK
	| REGR_SLOPE
	| REGR_INTERCEPT
	| REGR_COUNT
	| REGR_R2
	| REGR_AVGX
	| REGR_AVGY
	| REGR_SXX
	| REGR_SYY
	| REGR_SXY
	| STATS_BINOMIAL_TEST
	| STATS_CROSSTAB
	| STATS_F_TEST
	| STATS_KS_TEST
	| STATS_MODE
	| STATS_MW_TEST
	| STATS_ONE_WAY_ANOVA
	| STATS_T_TEST_ONE
	| STATS_T_TEST_PAIRED
	| STATS_T_TEST_INDEP
	| STATS_T_TEST_INDEPU
	| STATS_WSR_TEST
	| STDDEV
	| STDDEV_POP
	| STDDEV_SAMP
	| SUM
	| SYS_OP_ZONE_ID
	| SYS_XMLAGG
	| TO_APPROX_COUNT_DISTINCT
	| TO_APPROX_PERCENTILE
	| VAR_POP
	| VAR_SAMP
	| VARIANCE
	| XMLAGG
	;
withinGroupSpecification
	:  WITHIN GROUP LEFT_PAREN orderByClause RIGHT_PAREN
	;

firstFunction
	: aggregateFunction KEEP LEFT_PAREN DENSE_RANK FIRST orderByClause RIGHT_PAREN overClause?
	;
lastFunction
	: aggregateFunction KEEP LEFT_PAREN DENSE_RANK LAST orderByClause RIGHT_PAREN overClause?
	;
listAggFunction
	: LISTAGG LEFT_PAREN setQuantifier? expr (COMMA expr)? listaggOverflowClause? RIGHT_PAREN
		withinGroupSpecification overClause?
	;
listaggOverflowClause
	: ON OVERFLOW ERROR                                         #onOverflowErrorClause
    | ON OVERFLOW TRUNCATE expr? ((WITH | WITHOUT) COUNT)?      #onOverflowTruncateClause
	;

windowFunction
	: name=nameIdentifier LEFT_PAREN (setQuantifier? expr inside=windowFunctionNullsOption? (COMMA expr)*)? RIGHT_PAREN
		windowFunctionFromOption? outside=windowFunctionNullsOption? overClause
	;
windowFunctionNullsOption
	: (RESPECT | IGNORE) NULLS
	;
windowFunctionFromOption
 	: FROM (FIRST | LAST)
	;

overClause
    : OVER LEFT_PAREN analyticClause RIGHT_PAREN
    ;
analyticClause
	: partitionByClause? (orderByClause windowFrameClause?)?
	;
partitionByClause
    : PARTITION BY expr (COMMA expr)*
    ;
windowFrameClause
    : windowFrameUnit windowFrameExtent
    ;
windowFrameUnit
    : ROWS
    | RANGE
    ;
windowFrameExtent
	: BETWEEN between=windowFrameExtentItem AND and=windowFrameExtentItem
	| extent=windowFrameExtentItem
	;
windowFrameExtentItem
    : UNBOUNDED PRECEDING
    | CURRENT ROW
    | expr (PRECEDING|FOLLOWING)
    ;
// OLAP Functions
cubeTableFunction
	: CUBE_TABLE LEFT_PAREN SINGLE_QUOTE cube=nameIdentifier cubeTableOptionExpr* SINGLE_QUOTE RIGHT_PAREN
	;
cubeTableOptionExpr
	: (HIERARCHY | HRR) dimension=nameIdentifier? hierarchy=nameIdentifier
	;


// --------- Functions End ---------------


// Common Details
orReplace:                          OR REPLACE;
ifExists:                           IF EXISTS;
ifNotExists:                        IF NOT EXISTS;
withRollup:                         WITH ROLLUP;
orderingSpecification:              ASC | DESC;
intimeAction:                       ONLINE | OFFLINE;
indexCategory:                      UNIQUE | FULLTEXT | SPATIAL;
indexFormat:                        INDEX | KEY | KEYS;
indexType:                          USING (BTREE | HASH);
withType:                           WITH | WITHOUT;
visibleType:                        VISIBLE | INVISIBLE;

priority:                           LOW_PRIORITY | DELAYED | CONCURRENT | HIGH_PRIORITY;