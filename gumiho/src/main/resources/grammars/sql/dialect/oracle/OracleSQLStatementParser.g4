parser grammar OracleSQLStatementParser;

options {tokenVocab=OracleSQLStatementLexer;}
@members {boolean version12=true;}

parse
    : ((statement | command) SEMI?)* EOF
    ;

swallow_to_semi
    : ~SEMI+
    ;

emptyStatement
    : SEMI
    ;

statement
	: ddlStatement
    | dmlStatement
    | tclStatement
    | sclStatment
	| plsqlBlock
    ;

ddlStatement
    : createDatabaseLinkStatement | alterDatabaseLinkStatement | dropDatabaseLinkStatement
    | createDatabaseStatement | alterDatabaseStatement | dropDatabaseStatement

	| createIndexStatement | alterIndexStatement | dropIndexStatement

	| createFunctionStatement | alterFunctionStatement | dropFunctionStatement

	| createViewStatement | alterViewStatement | dropViewStatement

    | createMaterializedViewStatement | alterMaterializedViewStatement| dropMaterializedViewStatement

	| createPackageBodyStatement | dropPackageBodyStatement
    | createPackageStatement | alterPackageStatement | dropPackageStatement

    | createPluggableDatabaseStatement | alterPluggableDatabaseStatement | dropPluggableDatabaseStatement

    | createProcedureStatement | alterProcedureStatement | dropProcedureStatement

	| createSequenceStatement | alterSequenceStatement | dropSequenceStatement
	| createSynonymStatement | alterSynonymStatement | dropSynonymStatement
    | createTableStatement | alterTableStatement | dropTableStatement | truncateTableStatement

	| createTriggerStatement | alterTriggerStatement | dropTriggerStatement

	| createTypeBodyStatement | dropTypeBodyStatement
	| createTypeStatement | alterTypeStatement | dropTypeStatement

	| commentOnAuditPolicyStatement | commentOnColumnStatement
	| commentOnEditionStatement | commentOnIndexTypeStatement
	| commentOnMiningModelStatement | commentOnMaterializedViewStatement
	| commentOnOperatorStatement | commentOnTableStatement

    ;

dmlStatement
    : callStatement
    | explainStatement
    | insertStatement
    | multiInsertStatement
    | mergeStatement
    | lockTableStatement
    | deleteStatement
    | selectStatement
    | selectIntoStatement
    | updateStatement
    ;
fclStatement
	: ifStatement
	| caseStatement
	| basicLoopStatement
	| exitStatement
	| continueStatement
	| forLoopStatement
	| whileLoopStatement
	| gotoStatement
	| nullStatement
	;
tclStatement
	: commitStatement
	| rollbackStatement
	| savepointStatement
	| setTransactionStatement
	| setConstraintStatement
	| setConstraintsStatement
	;
sclStatment
	: alterSessionStatement
	| setRoleStatement
	;

command
    : ('/'
    | whenever_command
    | exit_command
    | prompt_command
    | set_command
    | show_errors_command
    | start_command)
    ;

// ---------------------------------------------------------    DDL


// -------------------------------- Database DDLs Start

createDatabaseStatement
	: CREATE DATABASE databaseName=nameIdentifier? createDatabaseStatementItem*
	;
alterDatabaseStatement
	: ALTER DATABASE nameIdentifier? //alterDatabaseStatementItem*
	;
dropDatabaseStatement
	: DROP DATABASE
	;

// Database - Specific Clauses
createDatabaseStatementItem
	: userSysClause
	| userSystemClause
	| controlfileReuseClause
	| maxDataFilesClause
	| maxInstancesClause
	| characterSetOptionExpr
	| nationalCharacterSet
	| setDefaultTablespaceClause
	| databaseLoggingClause
    | extentManagementClause
    | dataFileClause
    | sysauxClause
    | defaultTablespace
    | defaultTempTablespace
    | undoTablespace
    | setTimeZoneClause
    | userDataTablespaceClause
    | enablePluggableDatabase
	;

userSysClause
	: USER SYS IDENTIFIED BY password=nameIdentifier
	;
userSystemClause
	: USER SYSTEM IDENTIFIED BY password=nameIdentifier
	;
controlfileReuseClause
	: CONTROLFILE REUSE
	;
maxDataFilesClause
	: MAXDATAFILES maxDataFiles=UNSIGNED_INTEGER
	;
maxInstancesClause
	: MAXINSTANCES maxInstances=UNSIGNED_INTEGER
	;
characterSetOptionExpr
	: CHARACTER SET charset=nameIdentifier
    ;
nationalCharacterSet
    : NATIONAL CHARACTER SET charset=nameIdentifier
    ;
setDefaultTablespaceClause
	: SET DEFAULT (BIGFILE | SMALLFILE) TABLESPACE
	;

databaseLoggingClause
	: LOGFILE logFileClauseItem (COMMA logFileClauseItem)*                                                              #logFileClause
	| MAXLOGFILES expr                                                                                                  #maxLogFilesClause
	| MAXLOGMEMBERS expr                                                                                                #maxLogMembersClause
	| MAXLOGHISTORY expr                                                                                                #maxLogHistoryClause
	| ARCHIVELOG                                                                                                        #archiveLogExpr
	| NOARCHIVELOG                                                                                                      #noArchiveLogExpr
	| FORCE LOGGING	                                                                                                    #databaseForceLoggingClause
	| SET STANDBY NOLOGGING FOR (DATA AVAILABILITY | LOAD PERFORMANCE)                                                  #setStandbyNologgingForClause
	;
logFileClauseItem
	: (GROUP expr)? fileSpecification
	;

extentManagementClause
	: extentManagementLocalClause
	| extentManagementLocalAutoAllocateClause
	| extentManagementLocalUniformClause
	;
extentManagementLocalClause
	: EXTENT MANAGEMENT LOCAL
	;
extentManagementLocalAutoAllocateClause
	: EXTENT MANAGEMENT LOCAL AUTOALLOCATE
	;
extentManagementLocalUniformClause
	: EXTENT MANAGEMENT LOCAL UNIFORM (SIZE sizeClause)?
	;

dataFileClause
	: DATAFILE fileSpecification (COMMA fileSpecification)*
	;
sysauxClause
	: SYSAUX DATAFILE fileSpecification (COMMA fileSpecification)*
	;
defaultTablespace
	: DEFAULT TABLESPACE tablespace=nameIdentifier (DATAFILE dataFileTempFileSpec)? extentManagementClause?
	;

defaultTempTablespace
	: (BIGFILE | SMALLFILE)? DEFAULT TEMPORARY TABLESPACE tablespace=nameIdentifier
        (TEMPFILE fileSpecification (COMMA fileSpecification )* )? extentManagementClause?
	;
undoTablespace
	: (BIGFILE | SMALLFILE) UNDO TABLESPACE tablespace=nameIdentifier DATAFILE fileSpecification (COMMA fileSpecification)*
	;

setTimeZoneClause
	: SET TIME_ZONE EQUALS_OP expr
	;
userDataTablespaceClause
	: (BIGFILE | SMALLFILE) USER_DATA TABLESPACE tablespaceName=nameIdentifier DATAFILE dataFileTempFileSpec (COMMA dataFileTempFileSpec)*
	;
enablePluggableDatabase
	: ENABLE PLUGGABLE DATABASE (SEED fileNameConvert? (SYSTEM tablespaceDatafileClauses)? (SYSAUX tablespaceDatafileClauses)?)?
	;
fileNameConvert
	: fileNameConvertFile | fileNameConvertNone
	;
fileNameConvertFile
	: FILE_NAME_CONVERT EQUALS_OP LEFT_PAREN filename=literal COMMA replacementFilename=literal
			(filename=literal COMMA replacementFilename=literal)*
		RIGHT_PAREN
	;
fileNameConvertNone
	: FILE_NAME_CONVERT EQUALS_OP NONE
	;
tablespaceDatafileClauses
	: DATAFILES (SIZE sizeClause)? autoExtendClause?
	;


alterDatabaseStatementItem
	: startUpClause
	| recoveryClause
	| dataFileClause
	| iLogFileClause
	| controlfileReuseClause
	| standbyDatabaseClause
	| defaultSettingsClause
	| instanceClause
	| securityClause
	| prepareClause
	| dropMirrorCopy
	| lostWriteProtection
	| cdbFleetClause
	;
startUpClause
	: MOUNT ((STANDBY | CLONE) DATABASE)?                                                                               #startUpClauseMount
    | OPEN (READ (WRITE | ONLY))? (RESETLOGS | NORESETLOGS)? (UPGRADE | DOWNGRADE)?                                     #startUpClauseOpen
	;

recoveryClause
	: generalRecovery
	| managedStandByRecovery
	| BEGIN BACKUP
    | END BACKUP
	;
generalRecovery
	: RECOVER AUTOMATIC? (FROM expr)?
      ( (fullDatabaseRecovery | partialDatabaseRecovery | LOGFILE expr) (TEST | ALLOW expr CORRUPTION| parallelClause)
        | CONTINUE DEFAULT? | CANCEL)
	;
fullDatabaseRecovery
	: STANDBY? DATABASE (UNTIL (CANCEL
                | TIME expr
                | CHANGE expr
                | CONSISTENT
                )
        | USING BACKUP CONTROLFILE
        | SNAPSHOT TIME expr)?

	;
partialDatabaseRecovery
	: TABLESPACE expr (COMMA expr)*
    | DATAFILE expr (COMMA expr)*
	;
managedStandByRecovery
	: RECOVER MANAGED STANDBY DATABASE
          (( USING ARCHIVED LOGFILE
            | DISCONNECT (FROM SESSION)?
            | NODELAY
            | UNTIL CHANGE expr
            | UNTIL CONSISTENT
            | USING INSTANCES (ALL | expr)
            | parallelClause
            )*
          | FINISH
          | CANCEL
          )?
    | RECOVER TO LOGICAL STANDBY (expr | KEEP IDENTITY)

	;
database_file_clauses
	: RENAME FILE names+=expr (COMMA names+=expr) TO newName=expr
    | createDataFileClause
    | alter_datafile_clause
    | alter_tempfile_clause
    | moveDataFileAction
	;
createDataFileClause
	: CREATE DATAFILE expr (COMMA expr)*
         (AS (expr (COMMA expr)* | NEW))?
	;
alter_datafile_clause
	: DATAFILE expr (COMMA expr)*
         ( ONLINE
         | OFFLINE (FOR DROP)?
         | RESIZE sizeClause
         | autoExtendClause
         | END BACKUP
         | ENCRYPT
         | DECRYPT
         )
	;
alter_tempfile_clause
	: TEMPFILE expr (COMMA expr)*
         ( RESIZE sizeClause
         | autoExtendClause
         | DROP (INCLUDING DATAFILES)?
         | ONLINE
         | OFFLINE
         )
	;
moveDataFileAction
	: MOVE DATAFILE expr (TO expr)? REUSE? KEEP?
	;
iLogFileClause
	: ARCHIVELOG MANUAL?
    | NOARCHIVELOG
    | NO? FORCE LOGGING
    | SET STANDBY NOLOGGING FOR (DATA AVAILABILITY | LOAD PERFORMANCE)
    | RENAME FILE names+=expr (COMMA names+=expr)* TO newName=expr
    | CLEAR UNARCHIVED? LOGFILE logFileDescriptor (COMMA logFileDescriptor)* (UNRECOVERABLE DATAFILE)?
    | addLogFileClause
    | dropLogFileClause
    | switchLogFileClause
    | addSupplementalLog
    | dropSupplementalLog
	;
addLogFileClause
	: ADD STANDBY? LOGFILE (INSTANCE expr | THREAD expr)? (GROUP expr redoLogFileSpec (COMMA GROUP expr redoLogFileSpec))?
	| ADD STANDBY? LOGFILE MEMBER addLogFileMemberClauseItem (COMMA addLogFileMemberClauseItem)*
		TO logFileDescriptor (COMMA logFileDescriptor)*
	;
addLogFileMemberClauseItem
	: expr REUSE?
	;
dropLogFileClause
	: DROP STANDBY? LOGFILE logFileDescriptor (COMMA logFileDescriptor)*
    | DROP STANDBY? LOGFILE MEMBER expr (COMMA expr)*
	;
switchLogFileClause
	: SWITCH ALL LOGFILES TO BLOCKSIZE expr
	;
addSupplementalLog
	: ADD SUPPLEMENTAL LOG
	;
dropSupplementalLog
	: DROP SUPPLEMENTAL LOG
	;
logFileDescriptor
	: GROUP expr
    | LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN
    | expr
	;
controlFileClause
	: CREATE (LOGICAL | PHYSICAL)? STANDBY CONTROLFILE AS expr REUSE?
	| CREATE FAR SYNC INSTANCE CONTROLFILE AS expr REUSE?
    | BACKUP CONTROLFILE TO expr REUSE?
	| BACKUP CONTROLFILE TO traceFileClause
	;
traceFileClause
	: TRACE (AS expr REUSE?)? (RESETLOGS | NORESETLOGS)?
	;
standbyDatabaseClause
	: activateStandbyDBClause
	| maximizeStandbyDBClause
	| registerLogFileClause
	| commitSwitchOverClause
	| startStandByClause
	| stopStandbyClause
	| convertDatabaseClause
	| switchoverClause
	| failoverClause
	;
activateStandbyDBClause
	: ACTIVATE (PHYSICAL | LOGICAL)? STANDBY DATABASE (FINISH APPLY)?
	;
maximizeStandbyDBClause
	: SET STANDBY DATABASE TO MAXIMIZE (PROTECTION | AVAILABILITY | PERFORMANCE)
	;
registerLogFileClause
	: REGISTER orReplace? (PHYSICAL | LOGICAL)? LOGFILE (fileSpecification  (COMMA fileSpecification)*) (FOR nameIdentifier)?
	;
switchoverClause
	: SWITCHOVER TO nameIdentifier (VERIFY | FORCE)?
	;
failoverClause
	: FAILOVER TO nameIdentifier FORCE?
	;
commitSwitchOverClause
	: PREPARE TO SWITCHOVER
	| COMMIT TO SWITCHOVER
      (TO (((PHYSICAL | LOGICAL)? PRIMARY |  PHYSICAL? STANDBY) ((WITH | WITHOUT)  SESSION SHUTDOWN (WAIT | NOWAIT))?  | LOGICAL STANDBY )
      | CANCEL)?
	;
startStandByClause
	: START LOGICAL STANDBY APPLY IMMEDIATE? NODELAY? (NEW PRIMARY nameIdentifier | INITIAL expr | (SKIP FAILED TRANSACTION | FINISH))?
	;
stopStandbyClause
	: (STOP | ABORT) LOGICAL STANDBY APPLY
	;
convertDatabaseClause
	: CONVERT TO (PHYSICAL | SNAPSHOT) STANDBY
	;
defaultSettingsClause
	: DEFAULT EDITION EQUALS_OP nameIdentifier
    | SET DEFAULT (BIGFILE | SMALLFILE)? TABLESPACE
    | DEFAULT TABLESPACE nameIdentifier
    | tableSpaceClause
	| DEFAULT LOCAL? TEMPORARY TABLESPACE nameIdentifier
    | RENAME GLOBAL_NAME TO nameIdentifier
    | ENABLE BLOCK CHANGE TRACKING (USING FILE expr REUSE?)?
	| DISABLE BLOCK CHANGE TRACKING
    | NO? FORCE FULL DATABASE CACHING
    | CONTAINERS DEFAULT TARGET EQUALS_OP (LEFT_PAREN nameIdentifier RIGHT_PAREN | NONE)
    | flashbackModeClause
    | undoModeClause
    | setTimeZoneClause
	;
flashbackModeClause
	: FLASHBACK (ON | OFF)
	;
undoModeClause
	: LOCAL UNDO (ON | OFF)
	;
instanceClause
	: (ENABLE | DISABLE) INSTANCE expr
	;
securityClause
	: GUARD (ALL | STANDBY | NONE)
	;
prepareClause
	: PREPARE MIRROR COPY nameIdentifier (WITH (EXTERNAL | NORMAL | HIGH) REDUNDANCY)?
	;
dropMirrorCopy
	: DROP MIRROR COPY nameIdentifier
	;
lostWriteProtection
	: (ENABLE | DISABLE | REMOVE | SUSPEND)? LOST WRITE PROTECTION
	;
cdbFleetClause
	: leadCdbClause
	| leadCdbUriClause
	;
leadCdbClause
	: SET LEAD_CDB EQUALS_OP expr
	;
leadCdbUriClause
	: SET LEAD_CDB_URI EQUALS_OP expr
	;
// -------------------------------- Database DDLs End



// -------------------------------- Database Link DDLs Start
createDatabaseLinkStatement
	: CREATE SHARED? PUBLIC? DATABASE LINK nameIdentifier createDatabaseLinkStatementItem* (USING expr)?
	;
alterDatabaseLinkStatement
	: ALTER SHARED? PUBLIC? DATABASE LINK nameIdentifier createDatabaseLinkStatementItem
	;
dropDatabaseLinkStatement
	: DROP PUBLIC? DATABASE LINK nameIdentifier
	;

// Database Link - Specific Clauses
createDatabaseLinkStatementItem
	: connectToCurrentUser
	| connectToIdentifiedBy
	| dblinkAuthentication
	;

connectToCurrentUser
	: CONNECT TO CURRENT_USER
	;
connectToIdentifiedBy
	: CONNECT TO user=expr IDENTIFIED BY password=expr dblinkAuthentication?
	;
dblinkAuthentication
	: AUTHENTICATED BY user=expr IDENTIFIED BY password=expr
	;

// -------------------------------- Database Link DDLs End



// -------------------------------- Function DDLs Start

createFunctionStatement
    : CREATE orReplace? editionableType? FUNCTION name=nameIdentifier (LEFT_PAREN parameterDeclaration (COMMA parameterDeclaration)* RIGHT_PAREN)?
      RETURN dataType sharingClause? functionOption* (asType (declareSection* body SEMI| callSpec))?
    ;

alterFunctionStatement
    : ALTER FUNCTION nameIdentifier alterFunctionOption
    ;

dropFunctionStatement
    : DROP FUNCTION nameIdentifier
    ;

// Function - Specific Clauses
functionOption
	: invokerRightsClause
	| accessibleByClause
	| collationExpr
	| deterministicClause
	| iParallelEnableClause
	| resultCacheClause
	| aggregateClause
	| iPipelinedClause
	;

alterFunctionOption
	: compileClause
	| editionableClause
	| nonEditionableClause
	;


// -------------------------------- Index DDLs Start
createIndexStatement
	: CREATE (UNIQUE | BITMAP)? INDEX nameIdentifier ON CLUSTER? iTableReference (LEFT_PAREN createIndexStatementColumn (COMMA createIndexStatementColumn)* RIGHT_PAREN)?
		fromClause? whereClause? createIndexStatementOption* (USABLE | UNUSABLE)? invalidationType?
	;
alterIndexStatement
	: ALTER INDEX nameIdentifier alterIndexStatementItem*
	;
dropIndexStatement
	: DROP INDEX nameIdentifier ONLINE? FORCE? invalidationType?
	;

// Index - Specific Clauses
createIndexStatementColumn
	: expr (ASC | DESC)?
	;
createIndexStatementOption
	: indexAttribute
	| indexProperty
	;


indexProperty
	: iGlobalPartitionBy
	| localPartitionIndex
	| indexAttribute
	| indexTypeIsIndexTypeClause
	;
indexTypeIsIndexTypeClause
	: INDEXTYPE IS nameIdentifier localPartitionIndex? parallelClause? parametersClause?
	;

indexAttribute
	: physicalAttributesClause
	| loggingClause
	| indexAttributeOnline
	| indexAttributeComputeStatistics
	| tableSpaceClause
	| indexCompression
	| indexAttributeSort
	| indexAttributeNoSort
	| indexAttributeReverse
	| indexAttributeVisible
	| indexAttributeInvisible
	| partialIndexClause
	| parallelClause
	;


indexAttributeOnline
	: ONLINE
	;
indexAttributeComputeStatistics
	: COMPUTE STATISTICS
	;
indexAttributeSort
	: SORT
	;
indexAttributeNoSort
	: NOSORT
	;
indexAttributeReverse
	: REVERSE
	;
indexAttributeVisible
	: VISIBLE
	;
indexAttributeInvisible
	: INVISIBLE
	;
partialIndexClause
	: INDEXING (PARTIAL | FULL)
	;

parametersClause
	: PARAMETERS LEFT_PAREN expr RIGHT_PAREN
	;

iGlobalPartitionBy
	: GLOBAL PARTITION BY RANGE LEFT_PAREN columns+=expr (COMMA columns+=expr)* RIGHT_PAREN
         LEFT_PAREN partitionDefinition (COMMA partitionDefinition)* RIGHT_PAREN                                        #globalPartitionByRange
    | GLOBAL PARTITION BY HASH LEFT_PAREN columns+=expr (COMMA columns+=expr)* RIGHT_PAREN
		(PARTITIONS partitionsNum=expr)? storeInClause? iCompression? overflowStoreInClause?
        (LEFT_PAREN partitionDefinition (COMMA partitionDefinition)* RIGHT_PAREN)?                                      #globalPartitionByHash
	;

localPartitionIndex
	: LOCAL storeInClause? (LEFT_PAREN partitionDefinition (COMMA partitionDefinition)* RIGHT_PAREN)?
	;


alterIndexStatementItem
	: deallocateUnusedClause
    | allocateExtentClause
    | shrinkClause
    | parallelClause
    | physicalAttributesClause
    | loggingClause
    | partialIndexClause

    | alterIndexRebuildAction
    | parametersClause
    | alterIndexCompileAction
    | alterIndexEnableAction
    | alterIndexDisableAction
    | alterIndexUnusableAction
    | alterIndexVisibleAction
    | alterIndexInvisibleAction
    | alterIndexRenameAction
    | alterIndexCoalesceAction
    | alterIndexMonitoringUsageAction
    | alterIndexNoMonitoringUsageAction
    | alterIndexUpdateBlockReferencesAction
    | alterIndexPartitionAction
	;
shrinkClause
	: SHRINK SPACE_KEYWORD COMPACT? CASCADE?
	;
rebuildClause
	: REBUILD rebuildClauseItem? rebuildClauseProperty*
	;
rebuildClauseItem
	: PARTITION nameIdentifier          #rebuildClausePartitionItem
	| SUBPARTITION nameIdentifier       #rebuildClauseSubPartitionItem
	| REVERSE                           #rebuildClauseReverseItem
	| NOREVERSE                         #rebuildClauseNoReverseItem
	;
rebuildClauseProperty
	: parallelClause
	| tableSpaceClause
	| parametersClause
	| physicalAttributesClause
	| indexCompression
	| loggingClause
	| partialIndexClause
	| rebuildClauseOnlineProperty
	;
rebuildClauseOnlineProperty
	: ONLINE
	;

alterIndexRebuildAction
	: rebuildClause invalidationType?
	;
alterIndexCompileAction
	: COMPILE
	;
alterIndexEnableAction
	: ENABLE
	;
alterIndexDisableAction
	: DISABLE
	;
alterIndexUnusableAction
	: UNUSABLE ONLINE? invalidationType?
	;
alterIndexVisibleAction
	: VISIBLE
	;
alterIndexInvisibleAction
	: INVISIBLE
	;
alterIndexRenameAction
	: RENAME TO nameIdentifier
	;
alterIndexMonitoringUsageAction
	: MONITORING USAGE
	;
alterIndexCoalesceAction
	: COALESCE CLEANUP? parallelClause
	;
alterIndexNoMonitoringUsageAction
	: NOMONITORING USAGE
	;
alterIndexUpdateBlockReferencesAction
	: NOMONITORING USAGE
	;


alterIndexPartitionAction
	: alterIndexModifyDefaultAttrsAction
	| alterIndexAddPartitionAction
	| alterIndexModifyPartitionAction
	| alterIndexRenamePartitionAction
	| alterIndexRenameSubPartitionAction
	| alterIndexDropPartitionAction
	| alterIndexSplitPartitionAction
	| alterIndexCoalescePartitionAction
	| alterIndexModifySubPartitionAction
	;

alterIndexModifyDefaultAttrsAction
	: MODIFY DEFAULT ATTRIBUTES (FOR PARTITION expr)? modifyDefaultAttrItem+
	;
modifyDefaultAttrItem
	: physicalAttributesClause
	| tableSpaceClause
	| loggingClause
	;

alterIndexAddPartitionAction
	: ADD PARTITION nameIdentifier? tableSpaceClause? indexCompression? parallelClause?
	;
alterIndexCoalescePartitionAction
	: COALESCE PARTITION parallelClause?
	;
alterIndexModifyPartitionAction
	: MODIFY PARTITION nameIdentifier alterIndexModifyPartitionActionItem*
    ;
alterIndexModifyPartitionActionItem
	: deallocateUnusedClause
    | allocateExtentClause
    | physicalAttributesClause
    | loggingClause
    | indexCompression
    | alterIndexModifyPartitionActionCoalesceItem
    | alterIndexModifyPartitionActionUpdateBlockReferencesItem
    | alterIndexModifyPartitionActionUnusableItem
	;
alterIndexModifyPartitionActionCoalesceItem
	: COALESCE CLEANUP?
	;
alterIndexModifyPartitionActionUpdateBlockReferencesItem
	: UPDATE BLOCK REFERENCES
	;
alterIndexModifyPartitionActionUnusableItem
	: UNUSABLE
	;


alterIndexRenamePartitionAction
	: RENAME PARTITION name=nameIdentifier TO toName=nameIdentifier
    ;
alterIndexRenameSubPartitionAction
	: RENAME SUBPARTITION name=nameIdentifier TO toName=nameIdentifier
	;
alterIndexDropPartitionAction
	: DROP PARTITION nameIdentifier
    ;
alterIndexSplitPartitionAction
	: SPLIT PARTITION nameIdentifier AT LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN
         (INTO LEFT_PAREN partitionDefinition (COMMA partitionDefinition)* RIGHT_PAREN)?
         parallelClause?
    ;

alterIndexModifySubPartitionAction
	: MODIFY SUBPARTITION nameIdentifier alterIndexModifySubpartitionOption
    ;
alterIndexModifySubpartitionOption
	: modifySubpartitionUnusableOption
	| allocateExtentClause
	| deallocateUnusedClause
	;
modifySubpartitionUnusableOption
	: UNUSABLE
	;
// -------------------------------- Index DDLs End






// -------------------------------- Package DDLs Start

createPackageStatement
    : CREATE orReplace? PACKAGE packageName=nameIdentifier createPackageStatementOption* (IS | AS) createPackageStatementItem* END endName=nameIdentifier?
    ;
alterPackageStatement
    : ALTER PACKAGE nameIdentifier alterPackageStatementOption
    ;
dropPackageStatement
    : DROP PACKAGE nameIdentifier
    ;

createPackageBodyStatement
	: CREATE orReplace? PACKAGE BODY packageName=nameIdentifier (IS | AS) createPackageBodyStatementItem*
		(BEGIN bodyItem+ exceptionClause?)? END endName=nameIdentifier?
    ;
dropPackageBodyStatement
	: DROP PACKAGE BODY nameIdentifier
	;

// Create Package - Specific Clauses
createPackageStatementOption
	: collationExpr
	| invokerRightsClause
	| accessibleByClause
	;
createPackageStatementItem
	: typeDefinition
	| cursorDeclaration
	| itemDeclaration
	| functionDeclaration
	| procedureDeclaration
	;
createPackageBodyStatementItem
	: declareSection
	;

alterPackageStatementOption
	: compileClause
	| editionableClause
	| nonEditionableClause
	;

// -------------------------------- Package DDLs End



// -------------------------------- PLUGGABLE DATABASE DDLs Start
createPluggableDatabaseStatement
	: CREATE PLUGGABLE DATABASE
	;
alterPluggableDatabaseStatement
	: ALTER PLUGGABLE DATABASE
	;
dropPluggableDatabaseStatement
	: DROP PLUGGABLE DATABASE nameIdentifier ((KEEP|INCLUDING) DATAFILES)?
	;

// PLUGGABLE DATABASE - Specific Clauses

// -------------------------------- PLUGGABLE DATABASE DDLs End




// -------------------------------- Procedure DDLs Start
createProcedureStatement
    : CREATE orReplace? editionableType? PROCEDURE nameIdentifier sharingClause? (LEFT_PAREN parameterDeclaration (COMMA parameterDeclaration)* RIGHT_PAREN)?
      createProcedureStatementOption* asType (declareSection* body SEMI | callSpec)
    ;
alterProcedureStatement
    : ALTER PROCEDURE nameIdentifier alterProcedureStatementOption
    ;
dropProcedureStatement
    : DROP PROCEDURE nameIdentifier
    ;

// Procedure - Specific Clauses
createProcedureStatementOption
	: collationExpr
	| invokerRightsClause
	| accessibleByClause
	;
alterProcedureStatementOption
	: compileClause
	| editionableClause
	| nonEditionableClause
	;
// -------------------------------- Sequence DDLs Start
createSequenceStatement
    : CREATE SEQUENCE sequenceName=nameIdentifier sharingClause? createSequenceOption*
    ;
alterSequenceStatement
    : ALTER SEQUENCE sequenceName=nameIdentifier alterSequenceOption+
    ;
dropSequenceStatement
    : DROP SEQUENCE sequenceName=nameIdentifier
    ;

createSequenceOption
	: startWithSequenceOption
	| incrementBySequenceOption
	| maxValueSequenceOption
	| noMaxValueSequenceOption
	| minValueSequenceOption
	| noMinValueSequenceOption
	| cycleSequenceOption
	| noCycleSequenceOption
	| cacheSequenceOption
	| noCacheSequenceOption
	| orderSequenceOption
	| noOrderSequenceOption
	| keepSequenceOption
	| noKeepSequenceOption
	| scaleOption
    | noScaleOption
	| sessionSequenceOption
	| globalSequenceOption
	;
alterSequenceOption
	: incrementBySequenceOption
	| maxValueSequenceOption
	| noMaxValueSequenceOption
	| minValueSequenceOption
	| noMinValueSequenceOption
    | cycleSequenceOption
    | noCycleSequenceOption
    | cacheSequenceOption
    | noCacheSequenceOption
    | orderSequenceOption
    | noOrderSequenceOption
    | keepSequenceOption
    | noKeepSequenceOption
    | scaleOption
    | noScaleOption
    | sessionSequenceOption
    | globalSequenceOption
	;
startWithSequenceOption:    START WITH literal;
incrementBySequenceOption:  INCREMENT BY literal;
maxValueSequenceOption:     MAXVALUE literal;
noMaxValueSequenceOption:   NOMAXVALUE;
minValueSequenceOption:     MINVALUE literal;
noMinValueSequenceOption:   NOMINVALUE;
cycleSequenceOption:        CYCLE;
noCycleSequenceOption:      NOCYCLE;
cacheSequenceOption:        CACHE literal;
noCacheSequenceOption:      NOCACHE;
orderSequenceOption:        ORDER;
noOrderSequenceOption:      NOORDER;
keepSequenceOption:         KEEP;
noKeepSequenceOption:       NOKEEP;
scaleOption:                SCALE (EXTEND | NOEXTEND);
noScaleOption:              NOSCALE;
sessionSequenceOption:      SESSION;
globalSequenceOption:       GLOBAL;

// -------------------------------- Sequence DDLs End


// -------------------------------- Synonym DDLs Start
createSynonymStatement
    : CREATE orReplace? editionableType? PUBLIC? SYNONYM synonymName=nameIdentifier FOR forName=nameIdentifier
    ;
alterSynonymStatement
	: ALTER PUBLIC? SYNONYM synonymName=nameIdentifier (EDITIONABLE | NONEDITIONABLE | COMPILE)
	;
dropSynonymStatement
	: DROP PUBLIC? SYNONYM synonymName=nameIdentifier FORCE?
	;
// -------------------------------- Synonym DDLs End


// -------------------------------- Table DDLs Start
createTableStatement
    : CREATE tableScope? TABLE tableName=nameIdentifier sharingClause?
		(OF ofDataType=dataType)? objectTableSubstitution? (LEFT_PAREN tableElement (COMMA tableElement)* RIGHT_PAREN)?
        collationExpr? (XMLTYPE xmlTypeStorage)? xmlSchemaSpec? xmlTypeVirtualColumns? commitActionDefinition? commitActionRows? oidClause? oidIndexClause?
		physicalProperty* columnProperty* readOnlyClause? indexingClause? tablePartitioningClause? attributeClusteringClause?
        cacheType? parallelClause? (ROWDEPENDENCIES | NOROWDEPENDENCIES)? iEnableDisableClause* rowMovementClause? iFlashbackArchiveClause?
        (ROW ARCHIVAL)? (FOR EXCHANGE WITH TABLE withTable=expr)? (AS iSelectQuery)? memoptimizeForRead? (PARENT parent=nameIdentifier)?
    ;

alterTableStatement
    : ALTER TABLE nameIdentifier memoptimizeReadClause? alterTableItem*
    ;

dropTableStatement
    : DROP TABLE nameIdentifier (CASCADE CONSTRAINTS)? PURGE?
    ;
truncateTableStatement
	: TRUNCATE TABLE nameIdentifier ((PRESERVE | PURGE) MATERIALIZED VIEW LOG)? ((DROP ALL?| REUSE) STORAGE)? CASCADE?
	;

// Table - Specific Clauses
tableScope
	: GLOBAL TEMPORARY
	| PRIVATE TEMPORARY
	| SHARDED
	| DUPLICATED
	;
tableElement
	: iColumnDefinition
	| periodDefinition
	| tableConstraint
	| iSupplementalLog
	;
iColumnDefinition
	: columnDefinition
	| virtualColumnDefinition
	;
memoptimizeForRead
	: MEMOPTIMIZE FOR READ
	;

columnDefinition
	: columnName=nameIdentifier dataType? collateExpr? SORT? visibleType? columnDefinitionDefaultValue? (encryptClause|decryptClause)? columnConstraint*
		lobStorageClause? alterXmlSchemaClause?
	;
columnDefinitionDefaultValue
	: defaultClause
	| defaultOnNullClause
	| identityClause
	;

identityClause
	: GENERATED (ALWAYS | BY DEFAULT onNull?)?
      AS IDENTITY (LEFT_PAREN identityOption* RIGHT_PAREN)?
	;
onNull
	: ON NULL
	;
identityOption
	: identityStartWithOption
	| identityIncrementByOption
	| identityMaxValueOption
	| identityNoMaxValueOption
	| identityMinValueOption
    | identityNoMinValueOption
    | identityCycleOption
    | identityNoCycleOption
    | identityCacheOption
    | identityNoCacheOption
    | identityOrderOption
    | identityNoOrderOption
	;
identityStartWithOption:    START WITH (LIMIT VALUE | expr);
identityIncrementByOption:  INCREMENT BY expr;
identityMaxValueOption:     MAXVALUE expr;
identityNoMaxValueOption:   NOMAXVALUE;
identityMinValueOption:     MINVALUE expr;
identityNoMinValueOption:   NOMINVALUE;
identityCycleOption:        CYCLE;
identityNoCycleOption:      NOCYCLE;
identityCacheOption:        CACHE expr;
identityNoCacheOption:      NOCACHE;
identityOrderOption:        ORDER;
identityNoOrderOption:      NOORDER;

virtualColumnDefinition
	: nameIdentifier dataType? collateExpr? visibleType? (GENERATED ALWAYS)? AS LEFT_PAREN expr RIGHT_PAREN VIRTUAL? evaluationEditionClause? unusableEditionsClause? columnConstraint*
	;
evaluationEditionClause
	: EVALUATE USING evaluationEditionAction
	;

evaluationEditionAction
	: CURRENT EDITION                   #evaluationEditionCurrentEditionAction
	| EDITION expr                      #evaluationEditionEditionAction
	| NULL EDITION                      #evaluationEditionNullEditionAction
	;
unusableEditionsClause
	: (UNUSABLE BEFORE unusableBeforeAction)?
      (UNUSABLE BEGINNING WITH unusableBeginningWithAction)?
	;
unusableBeforeAction
	: CURRENT EDITION                   #unusableBeforeCurrentEditionAction
	| EDITION expr                      #unusableBeforeEditionAction
	;
unusableBeginningWithAction
	: CURRENT EDITION                   #unusableBeginningWithCurrentEditionAction
    | EDITION expr                      #unusableBeginningWithEditionAction
    | NULL EDITION                      #unusableBeginningWithNullEditionAction
	;


periodDefinition
	: PERIOD FOR validTimeColumn=nameIdentifier (LEFT_PAREN startTimeColumn=nameIdentifier COMMA endTimeColumn=nameIdentifier RIGHT_PAREN)?
	;

decryptClause
	: DECRYPT
	;
encryptClause
	: ENCRYPT encryptionSpec?
	;
encryptionSpec
	: (USING encrypt=expr)? (IDENTIFIED BY password=expr)? integrity=expr? (NO? SALT)?
	;
objectTableSubstitution
	: NOT? SUBSTITUTABLE AT ALL LEVELS
	;
objectProperty
	: columnDefinition
	| tableConstraint
	| iSupplementalLog
	;
commitActionDefinition
	: ON COMMIT (DELETE | PRESERVE) DEFINITION
	;
commitActionRows
	: ON COMMIT (DELETE | PRESERVE) ROWS
	;
oidClause
	: OBJECT IDENTIFIER IS (SYSTEM GENERATED | PRIMARY KEY)
	;
oidIndexClause
	: OIDINDEX index=nameIdentifier? LEFT_PAREN oidIndexClauseItem* RIGHT_PAREN
	;
oidIndexClauseItem
	: physicalAttributesClause
	| tableSpaceClause
	;

heapOrgTableClause
	: tableCompression? inMemoryTableClause? ilmClause?
	;
indexOrgTableClause
	: iMappingTableClause
    | pctthresholdClause
    | iPrefixCompression
	| indexOrgOverflowClause
	;
pctthresholdClause
	: PCTTHRESHOLD expr
	;
iMappingTableClause
	: MAPPING TABLE                             #mappingTableClause
	| NOMAPPING                                 #noMappingTableClause
	;
indexCompression
	: iPrefixCompression
	| iAdvancedIndexCompression
	;
iPrefixCompression
	: COMPRESS expr                                     #prefixCompression
	| NOCOMPRESS                                        #prefixNoCompression
	;
iAdvancedIndexCompression
	: COMPRESS ADVANCED (LOW | HIGH)?                   #advancedIndexCompression
	| NOCOMPRESS                                        #advancedIndexNoCompression
	;
indexOrgOverflowClause
	: indexOrgOverflowClauseIncludingClause
	| indexOrgOverflowClauseOverflowExpr
	| segmentAttributesClause
	;
indexOrgOverflowClauseIncludingClause
	: INCLUDING expr
	;
indexOrgOverflowClauseOverflowExpr
	: OVERFLOW
	;
iSupplementalLog
	: SUPPLEMENTAL LOG GROUP nameIdentifier (LEFT_PAREN supplementalLogGrpClauseItem
		(COMMA supplementalLogGrpClauseItem)* RIGHT_PAREN)? ALWAYS?                                                     #supplementalLogGrpClause
	| SUPPLEMENTAL LOG DATA LEFT_PAREN supplementalIdKeyClauseItem (COMMA supplementalIdKeyClauseItem)* COLUMNS         #supplementalIdKeyClause
	;

supplementalLogGrpClauseItem
	: nameIdentifier (NO LOG)?
	;

supplementalIdKeyClauseItem
	: ALL | PRIMARY KEY | UNIQUE | FOREIGN KEY
	;
columnProperty
	: objectTypeColProperty
	| nestedTableColProperty
	| opaqueTypeColumnProperty
	| vArrayColPropertyColumnProperty
	| lobStorageClauseColumnProperty
	| xmlTypeColumnProperty
	;
opaqueTypeColumnProperty
	:  OPAQUE TYPE nameIdentifier varrayStorageClause?
	;
vArrayColPropertyColumnProperty
	: varrayColProperty (LEFT_PAREN lobPartitionStorage (COMMA lobPartitionStorage)* RIGHT_PAREN)?
	;
lobStorageClauseColumnProperty
	: lobStorageClause (LEFT_PAREN lobPartitionStorage (COMMA lobPartitionStorage)* RIGHT_PAREN)?
	;

objectTypeColProperty
	: COLUMN nameIdentifier substitutableColumnClause
	;

buildClause
	: BUILD (IMMEDIATE | DEFERRED)
	;

attributeClusteringClause
	: CLUSTERING clusteringJoin? clusterClause clusteringWhen? zonemapClause?
	;
clusteringJoin
	: nameIdentifier clusteringJoinItem (COMMA clusteringJoinItem)*
	;
clusteringJoinItem
	: JOIN nameIdentifier ON LEFT_PAREN expr RIGHT_PAREN
	;
clusterClause
	: BY (LINEAR | INTERLEAVED)? ORDER LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN
	;
clusteringWhen
	: (onLoad=yesType ON LOAD)?  (onDataMovement=yesType ON DATA MOVEMENT)?
	;
zonemapClause
	: WITH MATERIALIZED ZONEMAP (LEFT_PAREN nameIdentifier RIGHT_PAREN)?            #withMaterializedZonemapClause
	| WITHOUT MATERIALIZED ZONEMAP                                                  #withoutMaterializedZonemapClause
	;

memoptimizeReadClause
	: NOT? MEMOPTIMIZE FOR READ
	;

alterTableItem
	: alterTableProerty
	| alterTableColumnAction
    | iAlterTableConstraintAction
    | iAlterTablePartitionAction
    | alterTableMoveTableAction
    | alterTableModifyToPartitionedAction
    | alterTableModifyOpaqueTypeAction

    | alterTableIotAction
    | alterXmlSchemaClause
    | alterTableEnableDisable
	;

alterTableEnableDisable
	: iEnableDisableClause
	| alterTableEnableTableLockAction
    | alterTableEnableAllTriggersAction
    | alterTableEnableContainerMapAction
    | alterTableEnableContainersDefaultAction
    | alterTableDisableTableLockAction
    | alterTableDisableAllTriggersAction
    | alterTableDisableContainerMapAction
    | alterTableDisableContainersDefaultAction
	;

alterTableProerty
	: physicalAttributesClause
	| loggingClause
	| tableCompression
	| ilmClause
	| iInMemoryClause
    | iInMemoryColumnClause
	| iAlterTableSupplementalLoggingAction
	| allocateExtentClause
	| deallocateUnusedClause

	| alterTableUpgradeTableAction
	| records_per_block_clause
	| parallelClause
	| rowMovementClause
	| iFlashbackArchiveClause
	| alterTableRenameTableAction
	| shrinkClause

	;
alterTableReadOnlyAction
	: READ ONLY
	;
alterTableReadWriteAction
	: READ WRITE
	;
iAlterTableSupplementalLoggingAction
	: ADD iSupplementalLog (COMMA iSupplementalLog)*            #alterTableAddSupplementalLoggingAction
    | DROP iSupplementalLog (COMMA iSupplementalLog)*           #iAlterTableDropSupplementalLoggingAction
	;
alterTableUpgradeTableAction
	: UPGRADE (NOT? INCLUDING DATA)? columnProperty*
	;
records_per_block_clause
	: (MINIMIZE | NOMINIMIZE) RECORDS_PER_BLOCK
	;
rowMovementClause
	: (ENABLE | DISABLE) ROW MOVEMENT
	;

alterTableRenameTableAction
	: RENAME name=nameIdentifier TO newName=nameIdentifier
	;

alterTableIotAction
	: indexOrgTableClause
	| alterTableAddOverflowIotAction
    | alterTableAlterOverflowIotAction
	| alterTableMappingTableIotAction
    | alterTableCoalesceIotAction
	;
alterTableCoalesceIotAction
	: COALESCE
	;

alterTableAlterOverflowIotAction
	: OVERFLOW alterOverflowClauseItem*
	;
alterOverflowClauseItem
	: segmentAttributesClause
	| loggingClause
	| allocateExtentClause
	| deallocateUnusedClause
	| shrinkClause
	;

alterTableAddOverflowIotAction
	: ADD OVERFLOW segmentAttributesClause* (LEFT_PAREN partitionDefinition (COMMA partitionDefinition)* RIGHT_PAREN)?
	;
alterTableMappingTableIotAction
	: MAPPING TABLE alterMappingTableClauseItem
	;
alterMappingTableClauseItem
	: allocateExtentClause
	| deallocateUnusedClause
	;


// column
alterTableColumnAction
	: alterTableAddColumnAction
	| alterTableModifyColumnsAction
	| alterTableModifyColumnAction
	| iAlterTableDropColumnAction
	| alterTableDropPeriodAction
	| alterTableRenameColumnAction
	| alterTableModifyCollectionRetrievalAction
	| alterTableModifyLobStorageAction
	| alterTableAlterVarrayColPropertyAction
	;
alterTableAddColumnAction
	: ADD LEFT_PAREN iColumnDefinition (COMMA iColumnDefinition)* RIGHT_PAREN columnProperty* (LEFT_PAREN partitionDefinition (COMMA partitionDefinition)* RIGHT_PAREN)?
	;
alterTableModifyColumnsAction
	: MODIFY LEFT_PAREN iColumnDefinition (COMMA iColumnDefinition)* RIGHT_PAREN
	;
alterTableModifyColumnAction
	: MODIFY COLUMN columnDefinition objectTableSubstitution FORCE?
	;

iAlterTableDropColumnAction
	: SET UNUSED COLUMN columns+=expr iAlterTableDropColumnActionOption* ONLINE?                                        #alterTableSetUnusedColumnAction
	| SET UNUSED LEFT_PAREN columns+=expr (COMMA columns+=expr)* RIGHT_PAREN
		iAlterTableDropColumnActionOption* ONLINE?                                                                      #alterTableSetUnusedColumnAction
	| DROP COLUMN columns+=expr iAlterTableDropColumnActionOption* (CHECKPOINT checkPoint=expr)?                        #alterTableDropColumnAction
	| DROP LEFT_PAREN columns+=expr (COMMA columns+=expr)* RIGHT_PAREN
		iAlterTableDropColumnActionOption* (CHECKPOINT checkPoint=expr)?                                                #alterTableDropColumnAction
	| DROP UNUSED COLUMNS (CHECKPOINT checkPoint=expr)?                                                                 #alterTableDropUnusedColumnsAction
    | DROP COLUMNS CONTINUE (CHECKPOINT checkPoint=expr)?                                                               #alterTableDropColumnsContinueAction
	;
iAlterTableDropColumnActionOption
	: CASCADE CONSTRAINTS
	| INVALIDATE
	;
alterTableDropPeriodAction
	: DROP LEFT_PAREN PERIOD FOR expr RIGHT_PAREN
	;
alterTableRenameColumnAction
	: RENAME COLUMN name=nameIdentifier TO newName=nameIdentifier
	;
alterTableModifyCollectionRetrievalAction
	: MODIFY NESTED TABLE nameIdentifier RETURN AS (LOCATOR | VALUE)
	;
alterTableModifyLobStorageAction
	: MODIFY LOB LEFT_PAREN nameIdentifier RIGHT_PAREN LEFT_PAREN modifyLobParameter+ RIGHT_PAREN
	;
modifyLobParameter
	: storageClause
	| lobParameter
	| allocateExtentClause
	| shrinkClause
	| deallocateUnusedClause
	;
alterTableAlterVarrayColPropertyAction
	: MODIFY VARRAY nameIdentifier LEFT_PAREN modifyLobParameter RIGHT_PAREN
	;


// Constraint
iAlterTableConstraintAction
	: ADD LEFT_PAREN? tableConstraint+ RIGHT_PAREN?                                             #alterTableAddTableConstraintAction
	| MODIFY CONSTRAINT nameIdentifier                                                          #alterTableModifyTableConstraintAction
	| MODIFY PRIMARY KEY iConstraintState* CASCADE?                                             #alterTableModifyPrimaryKeyConstraintAction
	| MODIFY UNIQUE LEFT_PAREN columns+=expr (COMMA columns+=expr)* RIGHT_PAREN
		iConstraintState* CASCADE?                                                              #alterTableModifyUniqueConstraintAction
	| RENAME CONSTRAINT name=nameIdentifier TO newName=nameIdentifier                           #alterTableRenameTableConstraintAction
	| DROP PRIMARY KEY CASCADE? keepIndexType? ONLINE?                                          #alterTableDropPrimaryKeyConstraintAction
	| DROP UNIQUE LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN
              CASCADE? keepIndexType? ONLINE?                                                   #alterTableDropUniqueConstraintAction
	| DROP CONSTRAINT nameIdentifier CASCADE? ONLINE?                                           #alterTableDropTableConstraintAction
	;

alterXmlSchemaClause
	: ALLOW ANYSCHEMA
    | ALLOW NONSCHEMA
    | DISALLOW NONSCHEMA
	;

// Partition
iAlterTablePartitionAction
	: alterTablePartitionAction invalidationType?
	;
alterTablePartitionAction
	: alterTableModifyDefaultAttrsAction
	| alterTableSetPartitioningAction
	| alterTableSetStoreInAction
	| alterTableSetIntervalAction
	| alterTableSetSubpartitionTemplateAction

	| alterTableModifyPartitionAction
	| alterTableModifyPartitionForAction
	| alterTableModifySubPartitionAction
    | alterTableModifySubPartitionForAction

	| alterTableMovePartitionAction
	| alterTableMovePartitionForAction
	| alterTableMoveSubPartitionAction
    | alterTableMoveSubPartitionForAction

	| alterTableAddPartitionAction

	| alterTableCoalesceTablePartition

	| alterTableDropPartitionAction
	| alterTableDropSubpartitionAction

	| alterTableRenamePartitionAction
	| alterTableRenamePartitionForAction
	| alterTableRenameSubPartitionAction
    | alterTableRenameSubPartitionForAction

	| alterTableTruncatePartitionAction
	| alterTableTruncateSubPartitionAction

	| iAlterTableSplitPartitionAction

	| iAlterTableSubSplitPartitionAction
	| iAlterTableMergePartitionsAction
	| iAlterTableMergeSubPartitionsAction
	| iAlterTableExchangePartitionAction
	| iAlterTableExchangeSubPartitionAction
	;
alterTablePartitionActionForItem
	: FOR LEFT_PAREN nameIdentifier (COMMA nameIdentifier)* RIGHT_PAREN
	;
alterTableModifyDefaultAttrsAction
	: MODIFY DEFAULT ATTRIBUTES iForPartition? readOnlyClause? indexingClause? segmentAttributesClause?
		tableCompression? iInMemoryClause? pctthresholdClause? iPrefixCompression? alterTableAlterOverflowIotAction
		modifyTableDefaultAttrsActionItem*
	;
iForPartition
	: FOR PARTITION nameIdentifier                                                  #forPartition
	| FOR PARTITION FOR LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN                   #forPartitionFor
	;
modifyTableDefaultAttrsActionItem
	: LOB LEFT_PAREN expr RIGHT_PAREN LEFT_PAREN lobParameter (COMMA lobParameter)* RIGHT_PAREN                         #modifyTableDefaultAttrsActionLobItem
	| VARRAY expr LEFT_PAREN lobParameter (COMMA lobParameter)* RIGHT_PAREN                                             #modifyTableDefaultAttrsActionVarrayItem
	;

alterTableSetPartitioningAction
	: SET PARTITIONING (AUTOMATIC | MANUAL)
	;
alterTableSetStoreInAction
	: SET STORE IN LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN
	;
alterTableSetIntervalAction
	: SET INTERVAL LEFT_PAREN expr? RIGHT_PAREN
	;
alterTableSetSubpartitionTemplateAction
 	: SET SUBPARTITION TEMPLATE LEFT_PAREN subPartitionDefinition (COMMA subPartitionDefinition)* RIGHT_PAREN
	;

alterTableModifyPartitionAction
	: MODIFY PARTITION nameIdentifier alterTableModifyPartitionActionItem+
	;
alterTableModifyPartitionForAction
	: MODIFY PARTITION FOR LEFT_PAREN nameIdentifier (COMMA nameIdentifier)* RIGHT_PAREN  alterTableModifyPartitionActionItem+
	;
alterTableModifySubPartitionAction
	: MODIFY SUBPARTITION nameIdentifier alterTableModifyPartitionActionItem+
	;
alterTableModifySubPartitionForAction
	: MODIFY SUBPARTITION FOR LEFT_PAREN nameIdentifier (COMMA nameIdentifier)* RIGHT_PAREN alterTableModifyPartitionActionItem+
	;
alterTableModifyPartitionActionItem
	: partitionAttribute
    | modifyPartitionAddSubPartitionAction
    | modifyPartitionAddValues
	| modifyPartitionDropValues
	| modifyPartitionUnusableLocalIndexes
	| coalesceTableSubpartition
	| alterTableMappingTableIotAction
	| readOnlyClause
	| indexingClause
	;

modifyPartitionAddValues
	: ADD VALUES LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN
	;

modifyPartitionDropValues
	: DROP VALUES LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN
	;

modifyPartitionUnusableLocalIndexes
	: REBUILD? UNUSABLE LOCAL INDEXES
	;

partitionAttribute
	: physicalAttributesClause
	| loggingClause
	| allocateExtentClause
	| deallocateUnusedClause
	| shrinkClause
	| alterTableAlterOverflowIotAction
	| tableCompression
	| iInMemoryClause
	| partitionAttributeLobClause
	| partitionAttributeVarrayClause
	;
partitionAttributeLobClause
	: LOB expr LEFT_PAREN modifyLobParameter (COMMA modifyLobParameter)* RIGHT_PAREN
	;
partitionAttributeVarrayClause
	: VARRAY expr LEFT_PAREN modifyLobParameter (COMMA modifyLobParameter)* RIGHT_PAREN
	;

alterTableMovePartitionAction
	: MOVE PARTITION nameIdentifier (MAPPING TABLE)? alterTableMovePartitionActionProperty*
		filterCondition? updateIndexClause? parallelClause? allowDisallowClustering? ONLINE?
	;
alterTableMovePartitionForAction
	: MOVE PARTITION FOR LEFT_PAREN nameIdentifier (COMMA nameIdentifier)* RIGHT_PAREN (MAPPING TABLE)? alterTableMovePartitionActionProperty*
        filterCondition? updateIndexClause? parallelClause? allowDisallowClustering? ONLINE?
	;
alterTableMovePartitionActionProperty
	: deferredSegmentCreation
    | readOnlyClause
    | indexingClause
    | segmentAttributesClause
    | iCompression
    | iInMemoryClause
    | ilmClause
    | alterTableAlterOverflowIotAction
    | lobStorageClause
    | varrayColProperty
    | nestedTableColProperty
	;

filterCondition
	: INCLUDING ROWS whereClause
	;
allowDisallowClustering
	: (ALLOW | DISALLOW) CLUSTERING
	;

alterTableMoveSubPartitionAction
	: MOVE SUBPARTITION nameIdentifier indexingClause? partitioningStorageClause?
		updateIndexClause? filterCondition? parallelClause? allowDisallowClustering? ONLINE?
	;
alterTableMoveSubPartitionForAction
	: MOVE SUBPARTITION FOR LEFT_PAREN nameIdentifier (COMMA nameIdentifier)* RIGHT_PAREN
		indexingClause? partitioningStorageClause? updateIndexClause? filterCondition? parallelClause? allowDisallowClustering? ONLINE?
	;

alterTableAddPartitionAction
	: ADD partitionDefinition (COMMA partitionDefinition)* (BEFORE expr)? dependentTablesClause?
	;

modifyPartitionAddSubPartitionAction
	: ADD subPartitionDefinition (COMMA subPartitionDefinition)* dependentTablesClause? updateIndexClause?
	;

dependentTablesClause
	: DEPENDENT TABLES LEFT_PAREN dependentTablesClauseItem (COMMA dependentTablesClauseItem)* RIGHT_PAREN
	;
dependentTablesClauseItem
	: nameIdentifier LEFT_PAREN partitionDefinition (COMMA partitionDefinition)* RIGHT_PAREN
	;
alterTableCoalesceTablePartition
	: COALESCE PARTITION  parallelClause? updateIndexClause? parallelClause? allowDisallowClustering?
	;
coalesceTableSubpartition
	: COALESCE SUBPARTITION nameIdentifier updateIndexClause? parallelClause? allowDisallowClustering?
	;

alterTableDropPartitionAction
	: DROP (PARTITION | PARTITIONS) dropPartitionActionItem (COMMA dropPartitionActionItem)*
	;
dropPartitionActionItem
	: nameIdentifier
	| FOR LEFT_PAREN names+=nameIdentifier (COMMA names+=nameIdentifier)
	;

alterTableDropSubpartitionAction
	: DROP (SUBPARTITION | SUBPARTITIONS) dropPartitionActionItem (COMMA dropPartitionActionItem)*
	;

alterTableRenamePartitionAction
	: RENAME PARTITION name=nameIdentifier TO newName=nameIdentifier
	;
alterTableRenamePartitionForAction
	: RENAME PARTITION FOR LEFT_PAREN names+=nameIdentifier (COMMA names+=nameIdentifier) RIGHT_PAREN TO newName=nameIdentifier
	;

alterTableRenameSubPartitionAction
	: RENAME SUBPARTITION name=nameIdentifier TO newName=nameIdentifier
	;
alterTableRenameSubPartitionForAction
	: RENAME SUBPARTITION FOR LEFT_PAREN names+=nameIdentifier (COMMA names+=nameIdentifier) TO newName=nameIdentifier
	;

alterTableTruncatePartitionAction
	: TRUNCATE (PARTITION|PARTITIONS) alterTablePartitionItem (COMMA alterTablePartitionItem)*
		 ((DROP ALL? | REUSE) STORAGE)? updateIndexClause? parallelClause? CASCADE?
	;
alterTableTruncateSubPartitionAction
	: TRUNCATE (SUBPARTITION|SUBPARTITIONS) alterTablePartitionItem (COMMA alterTablePartitionItem)*
		((DROP ALL? | REUSE) STORAGE)? updateIndexClause? parallelClause? CASCADE?
	;
alterTablePartitionItem
	: nameIdentifier
	| alterTablePartitionActionForItem
	;


iAlterTableSplitPartitionAction
	: SPLIT PARTITION name=nameIdentifier iAlterTableSplitPartitionActionItem
        splitNestedTablePart? filterCondition? dependentTablesClause? updateIndexClause?
        parallelClause? allowDisallowClustering? ONLINE?                                                                #alterTableSplitPartitionAction
	| SPLIT PARTITION FOR LEFT_PAREN nameIdentifier (COMMA nameIdentifier)* RIGHT_PAREN
		iAlterTableSplitPartitionActionItem splitNestedTablePart? filterCondition? dependentTablesClause?
		updateIndexClause? parallelClause? allowDisallowClustering? ONLINE?                                             #alterTableSplitPartitionForAction
	;

iAlterTableSplitPartitionActionItem
	: AT LEFT_PAREN atItems+=expr (COMMA atItems+=expr)* RIGHT_PAREN
		(INTO LEFT_PAREN partitionDefinition (COMMA partitionDefinition)* RIGHT_PAREN)?                                 #splitPartitionAtItem
	| VALUES LEFT_PAREN values+=expr (COMMA values+=expr)* RIGHT_PAREN
        (INTO LEFT_PAREN partitionDefinition (COMMA partitionDefinition)* RIGHT_PAREN)?                                 #splitPartitionValuesItem
	| INTO LEFT_PAREN partitionDefinition (COMMA partitionDefinition)* RIGHT_PAREN                                      #splitPartitionIntoItem
	;

splitNestedTablePart
	: NESTED TABLE expr INTO LEFT_PAREN partitionDefinition COMMA partitionDefinition sp1=splitNestedTablePart? RIGHT_PAREN sp2=splitNestedTablePart?
	;


iAlterTableSubSplitPartitionAction
	: SPLIT SUBPARTITION name=nameIdentifier iAlterTableSplitPartitionActionItem
        splitNestedTablePart? filterCondition? dependentTablesClause? updateIndexClause?
        parallelClause? allowDisallowClustering? ONLINE?                                                                #alterTableSplitSubPartitionAction

	| SPLIT SUBPARTITION FOR LEFT_PAREN nameIdentifier (COMMA nameIdentifier)* RIGHT_PAREN
		iAlterTableSplitPartitionActionItem splitNestedTablePart? filterCondition? dependentTablesClause?
		updateIndexClause? parallelClause? allowDisallowClustering? ONLINE?                                             #alterTableSplitSubPartitionForAction
	;

iAlterTableMergePartitionsAction
	: MERGE PARTITIONS alterTablePartitionItem (COMMA alterTablePartitionItem)* (INTO partitionDefinition)? filterCondition?
	    dependentTablesClause? updateIndexClause? parallelClause? ONLINE? allowDisallowClustering?                      #alterTableMergePartitionsAction
	| MERGE PARTITIONS alterTablePartitionItem TO alterTablePartitionItem (INTO partitionDefinition)? filterCondition?
		dependentTablesClause? updateIndexClause? parallelClause? ONLINE? allowDisallowClustering?                      #alterTableMergePartitionsToAction
	;

iAlterTableMergeSubPartitionsAction
	: MERGE SUBPARTITIONS alterTablePartitionItem (COMMA alterTablePartitionItem)* (INTO subPartitionDefinition)?
         filterCondition? dependentTablesClause? updateIndexClause? parallelClause? ONLINE? allowDisallowClustering?    #alterTableMergeSubPartitionsAction
	| MERGE SUBPARTITIONS alterTablePartitionItem TO alterTablePartitionItem (INTO subPartitionDefinition)?
		filterCondition? dependentTablesClause? updateIndexClause? parallelClause? ONLINE? allowDisallowClustering?     #alterTableMergeSubPartitionsToAction
	;

iAlterTableExchangePartitionAction
	: EXCHANGE PARTITION name=nameIdentifier WITH TABLE withTable=nameIdentifier ((INCLUDING | EXCLUDING) INDEXES)?
		((WITH | WITHOUT) VALIDATION)? exceptionsClause? updateIndexClause? parallelClause? CASCADE?                    #alterTableExchangePartitionAction
	| EXCHANGE PARTITION FOR LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN WITH TABLE withTable=nameIdentifier ((INCLUDING | EXCLUDING) INDEXES)?
        ((WITH | WITHOUT) VALIDATION)? exceptionsClause? updateIndexClause? parallelClause? CASCADE?                    #alterTableExchangePartitionForAction
	;
iAlterTableExchangeSubPartitionAction
	: EXCHANGE SUBPARTITION name=nameIdentifier WITH TABLE withTable=nameIdentifier ((INCLUDING | EXCLUDING) INDEXES)?
        ((WITH | WITHOUT) VALIDATION)? exceptionsClause? updateIndexClause? parallelClause? CASCADE?                    #alterTableExchangeSubPartitionAction
    | EXCHANGE PARTITION FOR LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN WITH TABLE withTable=nameIdentifier ((INCLUDING | EXCLUDING) INDEXES)?
        ((WITH | WITHOUT) VALIDATION)? exceptionsClause? updateIndexClause? parallelClause? CASCADE?                    #alterTableExchangeSubPartitionForAction
	;

updateIndexClause
	: updateGlobalIndexClause
	| updateIndexesClause
	;
updateGlobalIndexClause
	: (UPDATE | INVALIDATE) GLOBAL INDEXES
	;
updateIndexesClause
	: UPDATE INDEXES (LEFT_PAREN updateIndexesClauseItem (COMMA updateIndexesClauseItem)* RIGHT_PAREN)?
	;
updateIndexesClauseItem
	: expr LEFT_PAREN updateIndexesClauseItemItem (COMMA updateIndexesClauseItemItem)* RIGHT_PAREN
	;
updateIndexesClauseItemItem
	: partitionDefinition
	| subPartitionDefinition
	;

alterTableMoveTableAction
	: MOVE filterCondition? ONLINE? alterTableMoveTableActionProperty* updateIndexesClause?
	;
alterTableMoveTableActionProperty
	: segmentAttributesClause
	| tableCompression
	| indexOrgTableClause
	| lobStorageClause
	| varrayColProperty
	| parallelClause
	| allowDisallowClustering
	;


alterTableModifyToPartitionedAction
	: MODIFY tablePartitioningClause expr ONLINE? (UPDATE INDEXES LEFT_PAREN alterTableModifyToPartitionedActionUpdateIndexesItem (COMMA alterTableModifyToPartitionedActionUpdateIndexesItem) RIGHT_PAREN)?
	;
alterTableModifyToPartitionedActionUpdateIndexesItem
	: expr (localPartitionIndex|iGlobalPartitionBy|GLOBAL)
	;

alterTableModifyOpaqueTypeAction
	: MODIFY OPAQUE TYPE column=expr STORE LEFT_PAREN names+=expr (COMMA names+=expr)* RIGHT_PAREN UNPACKED
	;
iEnableDisableClause
	: ENABLE validateType? UNIQUE LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN
		iUsingIndexClause? exceptionsClause? CASCADE? keepIndexType?                      #enableUniqueClause
	| ENABLE validateType? PRIMARY KEY
		iUsingIndexClause? exceptionsClause? CASCADE? keepIndexType?                      #enablePrimaryKeyClause
	| ENABLE validateType? CONSTRAINT nameIdentifier
		iUsingIndexClause? exceptionsClause? CASCADE? keepIndexType?                      #enableConstraintClause
	| DISABLE validateType? UNIQUE LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN
		iUsingIndexClause? exceptionsClause? CASCADE? keepIndexType?                      #disableUniqueClause
    | DISABLE validateType? PRIMARY KEY
        iUsingIndexClause? exceptionsClause? CASCADE? keepIndexType?                      #disablePrimaryKeyClause
    | DISABLE validateType? CONSTRAINT nameIdentifier
        iUsingIndexClause? exceptionsClause? CASCADE? keepIndexType?                      #disableConstraintClause

	;

alterTableEnableTableLockAction
	: ENABLE TABLE LOCK
	;
alterTableEnableAllTriggersAction
	: ENABLE ALL TRIGGERS
	;
alterTableEnableContainerMapAction
	: ENABLE CONTAINER_MAP
	;
alterTableEnableContainersDefaultAction
	: ENABLE CONTAINERS_DEFAULT
	;
alterTableDisableTableLockAction
	: DISABLE TABLE LOCK
	;
alterTableDisableAllTriggersAction
	: DISABLE ALL TRIGGERS
	;
alterTableDisableContainerMapAction
	: DISABLE CONTAINER_MAP
	;
alterTableDisableContainersDefaultAction
	: DISABLE CONTAINERS_DEFAULT
	;

// -------------------------------- Table DDLs End


// -------------------------------- Trigger DDLs Start

createTriggerStatement
    : CREATE orReplace? editionableType? TRIGGER triggerName=nameIdentifier collationExpr?
        createTriggerActionTime (createTriggerEvent (OR createTriggerEvent)*)  (ON (NESTED TABLE nestedTable=nameIdentifier OF)? createTriggerOnExpr)?
        (REFERENCING referencingOption+)? forEachRow? triggerEditionClause? triggerOrderingClause? (ENABLE | DISABLE)? (WHEN LEFT_PAREN whenCondition=expr RIGHT_PAREN)? triggerBody
    ;
alterTriggerStatement
    : ALTER TRIGGER nameIdentifier alterTriggerStatementOption
    ;
dropTriggerStatement
    : DROP TRIGGER nameIdentifier
    ;

// Create Trigger - Specific Clauses
createTriggerActionTime
	: BEFORE
	| AFTER
	| INSTEAD OF
	| FOR
	;
createTriggerEvent
	: triggerDmlEvent
	| triggerDDLEvent
	| triggerDatabaseEvent
	;

triggerDmlEvent
	: (DELETE | INSERT | UPDATE) (OF nameIdentifier (COMMA nameIdentifier)*)?
	;
triggerDDLEvent
	: ALTER
	| ANALYZE
	| ASSOCIATE STATISTICS
	| AUDIT
	| COMMENT
	| CREATE
	| DISASSOCIATE STATISTICS
	| DROP
	| GRANT
	| NOAUDIT
	| RENAME
	| REVOKE
	| TRUNCATE
	| DDL
	;
triggerDatabaseEvent
	: STARTUP
	| SHUTDOWN
	| DB_ROLE_CHANGE
	| SERVERERROR
	| LOGON
	| LOGOFF
	| SUSPEND
	| CLONE
	| UNPLUG
	| SET CONTAINER
	;

createTriggerOnExpr
	: createTriggerOnSchemaExpr
	| createTriggerOnDatabaseExpr
	| nameIdentifier
	;
createTriggerOnSchemaExpr
	: (nameIdentifier PERIOD)? SCHEMA
	;
createTriggerOnDatabaseExpr
	: PLUGGABLE? DATABASE
	;

forEachRow
    : FOR EACH ROW
    ;

referencingOption
    : (NEW | OLD | PARENT) (AS? nameIdentifier)?
    ;
triggerEditionClause
	: (FORWARD | REVERSE)? CROSSEDITION
	;
triggerOrderingClause
	: (FOLLOWS | PRECEDES) nameIdentifier (COMMA nameIdentifier)*
	;
compoundTriggerBlock
    : COMPOUND TRIGGER declareSection* timingPointSection+ END nameIdentifier? SEMI
    ;
timingPointSection
    : before=timingPoint IS body after=timingPoint SEMI
    ;
timingPoint
	: BEFORE STATEMENT
	| BEFORE EACH ROW
	| AFTER STATEMENT
	| AFTER EACH ROW
	| INSTEAD OF EACH ROW
	;
triggerBody
    : plsqlBlock
    | callStatement
    | compoundTriggerBlock
    ;

alterTriggerStatementOption
	: compileClause
	| enableClause
	| disableClause
	| renameToClause
	| editionableClause
	| nonEditionableClause
	;

// -------------------------------- Type DDLs Start

// Type DDLs
createTypeStatement
    : CREATE orReplace? editionableType? TYPE nameIdentifier FORCE? (OID literal)? sharingClause?
        collationExpr? createTypeStatementProperty*
        objectSubDataType? (asType dataType)? createTypeExternalNameClause?
        (LEFT_PAREN attributeDefinition (COMMA attributeDefinition)* (COMMA elementSpec)* RIGHT_PAREN)?
        createTypeStatementOption*
    ;

alterTypeStatement
    : ALTER TYPE nameIdentifier alterTypeItem*
    ;
dropTypeStatement
    : DROP TYPE nameIdentifier (FORCE | VALIDATE)?
    ;

// Type - Specific Clauses
createTypeStatementProperty
	: invokerRightsClause
	| accessibleByClause
	;
createTypeExternalNameClause
	: EXTERNAL NAME expr LANGUAGE JAVA USING (SQLDATA | CUSTOMDATUM | ORADATA)
	;

createTypeStatementOption
	: finalClause | instantiableClause | persistableClause
	| notFinalClause | notInstantiableClause | notPersistableClause
	;

alterTypeItem
	: editionableClause
	| nonEditionableClause

	| compileClause
	| replaceClause

	| resetClause
	| finalClause
	| instantiableClause
    | notFinalClause
    | notInstantiableClause

    | alterTypeAddMethodsAction
    | alterTypeDropMethodsAction
    | alterTypeAddAttributeAction
    | alterTypeModifyAttributeAction
    | alterTypeDropAttributeAction
    | alterTypeModifyLimitAction
    | alterTypeElementTypeAction
	| dependentHandlingClause
	;

replaceClause
    : REPLACE replaceClauseOption* AS OBJECT LEFT_PAREN replaceClauseItem (COMMA replaceClauseItem)* RIGHT_PAREN
    ;
replaceClauseOption
	: invokerRightsClause
	| accessibleByClause
	;
replaceClauseItem
	: attributeDefinition
	| elementSpec
	;

alterTypeAddMethodsAction
	: alterTypeAddMethodsActionItem (COMMA alterTypeAddMethodsActionItem)*
	;
alterTypeAddMethodsActionItem
	: ADD elementSpecItem
	;
alterTypeDropMethodsAction
	: alterTypeDropMethodsActionItem (COMMA alterTypeDropMethodsActionItem)*
	;
alterTypeDropMethodsActionItem
	: DROP elementSpecItem
	;

alterTypeAddAttributeAction
	: ADD ATTRIBUTE (attributeDefinition | LEFT_PAREN attributeDefinition (COMMA attributeDefinition)* RIGHT_PAREN)
	;
alterTypeModifyAttributeAction
	: MODIFY ATTRIBUTE (attributeDefinition | LEFT_PAREN attributeDefinition (COMMA attributeDefinition)* RIGHT_PAREN)
	;
alterTypeDropAttributeAction
	: DROP ATTRIBUTE (expr | LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN)
	;
alterTypeModifyLimitAction
	: MODIFY LIMIT expr
	;
alterTypeElementTypeAction
	: MODIFY ELEMENT TYPE dataType
	;

dependentHandlingClause
    : INVALIDATE                                                                                                        #dependentHandlingClauseInvalidate
    | CASCADE (CONVERT TO SUBSTITUTABLE | NOT? INCLUDING TABLE DATA)? (FORCE? exceptionsClause)?                        #dependentHandlingClauseCascade
    ;

// -------------------------------- Type Body DDLs Start
createTypeBodyStatement
    : CREATE orReplace? editionableType? TYPE BODY nameIdentifier asType
        createTypeBodyStatementItem+
        END
    ;
dropTypeBodyStatement
	: DROP TYPE BODY nameIdentifier
	;

// 	Type - Specific Clauses

createTypeBodyStatementItem
	: subProgramDeclaration
	| mapOrderFunctionDeclaration
    | procedureDefinition
    | functionDefinition
    | constructorDefinition
	;

// -------------------------------- Type DDLs End



// -------------------------------- View DDLs Start
createViewStatement
    : CREATE orReplace? forceType? editionableType? VIEW nameIdentifier sharingClause?
        (OF dataType)? xmlSchemaSpec? createViewSubView? (LEFT_PAREN tableElement (COMMA tableElement)* RIGHT_PAREN)?
        collationExpr? (BEQUEATH (CURRENT_USER | DEFINER))?
        AS iSelectQuery iSubQueryRestrictionClause? (CONTAINER_MAP | CONTAINERS_DEFAULT)?
    ;
alterViewStatement
	: ALTER VIEW nameIdentifier alterViewAction
	;
dropViewStatement
    : DROP VIEW nameIdentifier (CASCADE CONSTRAINTS)?
    ;



// view - Specific Clauses
createViewSubView
	: iWithObjectIdClause
	| subViewClause
	;
iWithObjectIdClause
	: WITH OBJECT IDENTIFIER expr           #withObjectIdentifierClause
	| WITH OBJECT ID expr                   #withObjectIdClause
	;
subViewClause
	: UNDER nameIdentifier
	;

alterViewAction
	: ADD tableConstraint                                       #alterViewAddTableConstraintAction
    | MODIFY CONSTRAINT nameIdentifier (RELY | NORELY)          #alterViewModifyConstraintAction
    | DROP CONSTRAINT nameIdentifier                            #alterViewDropConstraintAction
    | DROP PRIMARY KEY                                          #alterViewDropPrimaryKeyConstraintAction
	| DROP UNIQUE LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN     #alterViewDropUniqueConstraintAction
    | COMPILE                                                   #alterViewCompileAction
    | READ ONLY                                                 #alterViewReadOnlyAction
    | READ WRITE                                                #alterViewReadWriteAction
    | EDITIONABLE                                               #alterViewEditionableAction
    | NONEDITIONABLE                                            #alterViewNonEditionableAction
	;
// -------------------------------- View DDLs End


// -------------------------------- Materialized View DDLs Start
createMaterializedViewStatement
    : CREATE MATERIALIZED VIEW materializedView=nameIdentifier (LEFT_PAREN columns+=createMaterializedViewStatementColumn (COMMA columns+=createMaterializedViewStatementColumn)* RIGHT_PAREN)?
        (OF ofDataType=dataType)? (LEFT_PAREN columnConstraints+=iCreateMaterializedViewStatementColumn (COMMA columnConstraints+=iCreateMaterializedViewStatementColumn)* RIGHT_PAREN)?
        collationExpr? createMaterializedViewStatementProperty* iUsingIndexClause? iCreateMVRefresh? evaluationEditionClause?
        forUpdate?  onQueryComputationClause? queryRewriteClause?  AS iSelectQuery
    ;

alterMaterializedViewStatement
	: ALTER MATERIALIZED VIEW nameIdentifier alterMaterializedViewStatementProperty*
	;
dropMaterializedViewStatement
	: DROP MATERIALIZED VIEW nameIdentifier (PRESERVE TABLE)?
	;

// Materialized View - Specific Clauses
iCreateMaterializedViewStatementColumn
	: createMaterializedViewStatementColumn
	| tableConstraint
	;
createMaterializedViewStatementColumn
	: nameIdentifier encryptClause?
	;
createMaterializedViewStatementProperty
	: onPrebuiltTableProperty
	| physicalProperty
	| materializedViewProperty
	;
onPrebuiltTableProperty
	: ON PREBUILT TABLE ((WITH | WITHOUT) REDUCED PRECISION)?
	;
materializedViewProperty
	: columnProperty
	| tablePartitioningClause
	| materializedViewPropertyCacheClause
	| materializedViewPropertyNoCacheClause
	| parallelClause
	| buildClause
	;
materializedViewPropertyCacheClause
	: CACHE
	;
materializedViewPropertyNoCacheClause
	: NOCACHE
	;
iUsingIndexClause
	: USING INDEX usingIndexItem*           #usingIndexClause
	| USING NO INDEX                        #usingNoIndexClause
	;
usingIndexItem
	: physicalAttributesClause
	| tableSpaceClause
	| usingIndexCreateIndexStatementItem
	| indexProperty
	| expr
	;
usingIndexCreateIndexStatementItem
	: LEFT_PAREN createIndexStatement RIGHT_PAREN
	;
iCreateMVRefresh
	: REFRESH createMVRefreshItem+                                              #createMVRefresh
	| NEVER REFRESH                                                             #createMVNeverRefresh
	;
createMVRefreshItem
	: FAST                                                                      #createMVRefreshFastItem
	| COMPLETE                                                                  #createMVRefreshCompleteItem
	| FORCE                                                                     #createMVRefreshForceItem
	| ON DEMAND                                                                 #createMVRefreshOnDemandItem
	| ON COMMIT                                                                 #createMVRefreshOnCommitItem
	| ON STATEMENT                                                              #createMVRefreshOnStatementItem
	| START WITH expr                                                           #createMVRefreshStartWithItem
	| NEXT expr                                                                 #createMVRefreshNextItem
	| WITH PRIMARY KEY                                                          #createMVRefreshWithPrimaryKeyItem
	| WITH ROWID                                                                #createMVRefreshWithRowidItem
	| USING usingRollbackSegmentItem+                                           #createMVRefreshUsingRollbackSegmentItem
	| USING ENFORCED CONSTRAINTS                                                #createMVRefreshUsingEnforcedConstraintsItem
    | USING TRUSTED CONSTRAINTS                                                 #createMVRefreshUsingTrustedConstraintsItem
	;
usingRollbackSegmentItem
	: DEFAULT usingRollbackSegmentOptionType? ROLLBACK SEGMENT                  #usingRollbackSegmentByDefaultItem
	| usingRollbackSegmentOptionType? ROLLBACK SEGMENT nameIdentifier           #usingRollbackSegmentByNoDefaultItem
	;
usingRollbackSegmentOptionType
	: MASTER
	| LOCAL
	;
onQueryComputationClause
	: enableType ON QUERY COMPUTATION
	;
queryRewriteClause
	: enableType QUERY REWRITE unusableEditionsClause?
	;

alterMaterializedViewStatementProperty
	: physicalAttributesClause
	| tableCompression
	;


// -------------------------------- Materialized View DDLs End


// -------------------------------- COMMENT DDLs Start
commentOnAuditPolicyStatement
	: COMMENT ON AUDIT POLICY policy=nameIdentifier IS comment=expr
	;
commentOnColumnStatement
    : COMMENT ON COLUMN column=nameIdentifier IS comment=expr
    ;
commentOnEditionStatement
	: COMMENT ON EDITION edition=nameIdentifier IS comment=expr
	;
commentOnIndexTypeStatement
	: COMMENT ON INDEXTYPE indexType=nameIdentifier IS comment=expr
	;
commentOnMaterializedViewStatement
	: COMMENT ON MATERIALIZED VIEW materializedView=nameIdentifier IS comment=expr
	;
commentOnMiningModelStatement
	: COMMENT ON MINING MODEL model=nameIdentifier IS comment=expr
	;
commentOnOperatorStatement
	: COMMENT ON OPERATOR operator=nameIdentifier IS comment=expr
	;
commentOnTableStatement
    : COMMENT ON TABLE table=nameIdentifier IS comment=expr
    ;
// -------------------------------- COMMENT DDLs End


// $<Common DDL Clauses

table_indexed_by_part
    : (idx1=INDEXED | idx2=INDEX) BY dataType
    ;


function_call
    : CALL? expr
    ;


// $<SQL PL/SQL Statements

sqlStatement
    : dmlStatement
    | cursor_manipulation_statements
    | tclStatement
    ;

execute_immediate
    : //EXECUTE IMMEDIATE expr (into_clause using_clause? | using_clause dynamic_returning_clause? | dynamic_returning_clause)?
    ;

// $<DML SQL PL/SQL Statements


// $<Cursor Manipulation SQL PL/SQL Statements

cursor_manipulation_statements
    : closeStatement
    | openStatement
    | fetchStatement
    | openForStatement
    ;

//sessionControlStatements
//	: alterSESSION
//	| setROLE
//	;



// =------------------------------------------------- DML

// --------- CALL

callStatement
	: CALL call=expr (INTO into=expr)?
	;

// --------- explain
explainStatement
    : EXPLAIN PLAN (SET STATEMENT_ID '=' expr)? (INTO nameIdentifier)?
      FOR (selectStatement | updateStatement | deleteStatement | insertStatement | mergeStatement)
    ;

// --------- insert
insertStatement
    : INSERT INTO iTableReference (LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN)?
		iValueClause returningIntoClause? errorLoggingClause?
    ;
multiInsertStatement
	: INSERT option=(ALL|FIRST)? multiInsertClause iSelectQuery
	;

// Insert - Specific Clauses
iValueClause
	: valuesClause
	| iSelectQuery
	;
multiInsertClause
	: multiInsertIntoClause
	| multiConditionalInsertIntoClause
	;
multiInsertIntoClause
	: multiInsertIntoClauseItem+
	;
multiConditionalInsertIntoClause
	: multiConditionalInsertWhenClause+ (ELSE multiInsertIntoClauseItem+)?
	;
multiInsertIntoClauseItem
	: INTO iTableReference (LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN)?
		valuesClause? returningIntoClause? errorLoggingClause?
	;
multiConditionalInsertWhenClause
	: WHEN expr THEN multiInsertIntoClauseItem+
	;
valuesClause
    : VALUES valuesClauseItem (COMMA valuesClauseItem)*
    ;
valuesClauseItem
    : LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN
	;


// --------- merge Statement

mergeStatement
    : MERGE INTO nameIdentifier alias=nameIdentifier? USING selected_tableview ON LEFT_PAREN expr RIGHT_PAREN
      (merge_update_clause merge_insert_clause? | merge_insert_clause merge_update_clause?)?
      errorLoggingClause?
    ;

// Merge Statement - Specific Clauses
merge_update_clause
    : WHEN MATCHED THEN UPDATE SET merge_element (COMMA merge_element)* whereClause? merge_update_delete_part?
    ;

merge_element
    : nameIdentifier '=' expr
    ;

merge_update_delete_part
    : DELETE whereClause
    ;

merge_insert_clause
    : WHEN NOT MATCHED THEN INSERT (LEFT_PAREN nameIdentifier (COMMA nameIdentifier)* RIGHT_PAREN)? VALUES listExpr whereClause?
    ;

selected_tableview
    : (nameIdentifier | LEFT_PAREN selectStatement RIGHT_PAREN) nameIdentifier?
    ;


// --------- lockTableStatement
lockTableStatement
    : LOCK TABLE lockTableItem (COMMA lockTableItem)* IN lockMode MODE forUpdateOption?
    ;
// $<Lock - Specific Clauses
lockTableItem
    : nameIdentifier iPartitionClause?
    ;
lockMode
    : ROW SHARE
    | ROW EXCLUSIVE
    | SHARE
    | SHARE UPDATE
    | SHARE ROW EXCLUSIVE
    | EXCLUSIVE
    ;



// --------- Delete

deleteStatement
    : DELETE FROM? iTableReference whereClause? returningIntoClause? errorLoggingClause?
    ;


// --------- Select

selectStatement
	:  iSelectQuery
	;
iSelectQuery
	: selectUnionQuery | selectQueryBasic
	;
selectQueryBasic
	: selectQuery | selectParenQuery
	;
selectQuery
	: withClause? SELECT setQuantifier? selectItem (COMMA selectItem)* fromClause? whereClause?
		hierarchicalQueryClause? groupByClause? modelClause? orderByClause? rowLimitingClause? forUpdateClause?
	;
selectParenQuery
	: LEFT_PAREN iSelectQuery RIGHT_PAREN orderByClause? rowLimitingClause? forUpdateClause?
	;
selectUnionQuery
    : selectQueryBasic (unionOperator selectQueryBasic)+ orderByClause? rowLimitingClause? forUpdateClause?
    ;
setQuantifier
	: DISTINCT | UNIQUE | ALL
	;
unionOperator
	: UNION ALL? | INTERSECT | MINUS
	;

// $<Select - Specific Clauses
withClause
    : WITH plsqlDeclaration* (withElement (COMMA withElement)*)?
    ;
plsqlDeclaration
	: functionDeclaration
	| functionDefinition
	| procedureDeclaration
	| procedureDefinition
	;
withElement
	: subQueryFactoringClause
	| subAvFactoringClause
	;
subQueryFactoringClause
    : queryName=nameIdentifier (LEFT_PAREN columns+=nameIdentifier (COMMA columns+=nameIdentifier)* RIGHT_PAREN)?
        AS LEFT_PAREN iSelectQuery RIGHT_PAREN searchClause? cycleClause?
    ;

searchClause
    : SEARCH (DEPTH | BREADTH) FIRST BY orderByItem (COMMA orderByItem)* SET nameIdentifier
    ;
cycleClause
    : CYCLE cycleColumns+=nameIdentifier (COMMA cycleColumns+=nameIdentifier)* SET cycleMarkColumn=nameIdentifier TO cycleMarkValue=expr DEFAULT nonCycleMarkValue=expr
    ;

subAvFactoringClause
	: name=nameIdentifier ANALYTIC VIEW AS LEFT_PAREN subAvClause RIGHT_PAREN
	;
subAvClause
	: USING using=nameIdentifier hierarchiesClause?
		(FILTER FACT LEFT_PAREN subAvClauseFilterClause (COMMA subAvClauseFilterClause)* RIGHT_PAREN)?
		(ADD MEASURES LEFT_PAREN calcMeasClause (COMMA calcMeasClause)* RIGHT_PAREN)?
	;
hierarchiesClause
	: HIERARCHIES LEFT_PAREN (nameIdentifier (COMMA nameIdentifier)*)? RIGHT_PAREN
	;
subAvClauseFilterClause
	: value=expr TO predicate=expr
	;
calcMeasClause
	: value=expr AS LEFT_PAREN asExpr=expr RIGHT_PAREN
	;

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
	: ONLY LEFT_PAREN tableName=nameIdentifier objectNameTableReferenceOption?
        sampleClause? RIGHT_PAREN flashbackQueryClause* iPivotClause? alias2=nameIdentifier?                            #objectNameTableReference
    | tableName=nameIdentifier objectNameTableReferenceOption? sampleClause?
        flashbackQueryClause* iPivotClause? alias2=nameIdentifier?                                                      #objectNameTableReference

	| ONLY LEFT_PAREN tableName=nameIdentifier alias1=nameIdentifier? objectNameTableReferenceOption?
      		sampleClause? RIGHT_PAREN flashbackQueryClause* iPivotClause? alias2=nameIdentifier?                        #objectNameTableReference
	| tableName=nameIdentifier alias1=nameIdentifier? objectNameTableReferenceOption? sampleClause?
			flashbackQueryClause* iPivotClause? alias2=nameIdentifier?                                                  #objectNameTableReference

	| ONLY LEFT_PAREN LATERAL? LEFT_PAREN iSelectQuery iSubQueryRestrictionClause? RIGHT_PAREN RIGHT_PAREN
      		flashbackQueryClause* iPivotClause?  (AS? alias=nameIdentifier)?                                            #lateralSubQueryTableReference
	| LATERAL? LEFT_PAREN iSelectQuery iSubQueryRestrictionClause? RIGHT_PAREN
		flashbackQueryClause* iPivotClause?  (AS? alias=nameIdentifier)?                                                #lateralSubQueryTableReference

	| ONLY LEFT_PAREN TABLE LEFT_PAREN expr RIGHT_PAREN (LEFT_PAREN PLUS_SIGN RIGHT_PAREN)? RIGHT_PAREN
        flashbackQueryClause* iPivotClause?  (AS? alias=nameIdentifier)?                                                #tableFunctionTableReference
    | TABLE LEFT_PAREN expr RIGHT_PAREN (LEFT_PAREN PLUS_SIGN RIGHT_PAREN)?
        flashbackQueryClause* iPivotClause?  (AS? alias=nameIdentifier)?                                                #tableFunctionTableReference


	| CONTAINERS LEFT_PAREN name=nameIdentifier RIGHT_PAREN (AS? alias=nameIdentifier)?                                 #containersFunctionTableReference
	| SHARDS LEFT_PAREN name=nameIdentifier RIGHT_PAREN (AS? alias=nameIdentifier)?                                     #shardsFunctionTableReference

	| ANALYTIC VIEW LEFT_PAREN subAvClause RIGHT_PAREN (AS? nameIdentifier)?                                            #inlineAnalyticViewTableReference
	| LEFT_PAREN joinTableReference RIGHT_PAREN                                                                         #parenJoinTableReference
	;

joinTableReference
	: tableReferenceBasic rightJoinClause+
	;

objectNameTableReferenceOption
	: modifiedExternalTableClause
	| iPartitionClause
	| hierarchiesClause
	;

joinType
	: COMMA
	| INNER_JOIN
	| CROSS_JOIN
	| NATURAL_JOIN
	| NATURAL_INNER_JOIN

    | FULL_JOIN
	| FULL_OUTER_JOIN
	| NATURAL_FULL_JOIN
	| NATURAL_FULL_OUTER_JOIN

	| LEFT_JOIN
	| LEFT_OUTER_JOIN
	| NATURAL_LEFT_JOIN
	| NATURAL_LEFT_OUTER_JOIN

	| RIGHT_JOIN
	| RIGHT_OUTER_JOIN
	| NATURAL_RIGHT_JOIN
    | NATURAL_RIGHT_OUTER_JOIN

	| JOIN

	| CROSS APPLY
	| OUTER APPLY
	;
rightJoinClause
	: leftPartitionByClause=partitionByClause?
      		joinType tableReferenceBasic rightPartitionByClause=partitionByClause? joinSpecification*
	;
joinSpecification
	: ON expr                                                           #joinCondition
	| USING LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN                   #namedColumnsJoin
	;
locationClause
	: LOCATION LEFT_PAREN locationClauseItem (COMMA locationClauseItem)* RIGHT_PAREN
	;
locationClauseItem
	: (directory=expr COLON)? location=expr
	;
modifiedExternalTableClause
	: EXTERNAL MODIFY directoryExpr? locationClause?
		(ACCESS PARAMETERS (BADFILE|LOGFILE|DISCARDFILE) filename=expr)? (REJECT LIMIT rejectLimit=expr)?
	;

flashbackQueryClause
    : VERSIONS BETWEEN (SCN | TIMESTAMP) minValue=expr AND maxValue=expr                #flashbackQueryByVersionsBetweenClause
	| VERSIONS PERIOD FOR nameIdentifier BETWEEN minValue=expr AND maxValue=expr        #flashbackQueryByVersionsPeriodForClause
    | AS OF (SCN | TIMESTAMP) expr                                                      #flashbackQueryByAsOfClause
    | AS OF PERIOD FOR nameIdentifier expr                                              #flashbackQueryByAsOfPeriodForClause
    ;
inlineExternalTable
	: EXTERNAL LEFT_PAREN LEFT_PAREN expr (COMMA expr)* COMMA RIGHT_PAREN  RIGHT_PAREN
	;

iPivotClause
	: pivotClause
	| unpivotClause
	| rowPatternClause
	;
pivotClause
    : PIVOT XML? LEFT_PAREN pivotItem (COMMA pivotItem)* FOR forExpr=expr IN LEFT_PAREN inItems+=exprOrExprAsAliasArgument (COMMA inItems+=exprOrExprAsAliasArgument)* RIGHT_PAREN RIGHT_PAREN
    ;
pivotItem
    : aggregateFunction (AS? nameIdentifier)?
    ;

unpivotClause
    : UNPIVOT ((INCLUDE | EXCLUDE) NULLS)? LEFT_PAREN column=expr FOR forExpr=expr IN LEFT_PAREN inItems+=exprOrExprAsAliasArgument (COMMA inItems+=exprOrExprAsAliasArgument)* RIGHT_PAREN RIGHT_PAREN
    ;

sampleClause
    : SAMPLE BLOCK? LEFT_PAREN percent=expr RIGHT_PAREN SEED LEFT_PAREN send=expr RIGHT_PAREN
    ;

iPartitionClause
	: PARTITION LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN                       #partitionClause
	| PARTITION FOR LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN                   #partitionForClause
	| SUBPARTITION BY LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN                 #subPartitionClause
	| SUBPARTITION BY FOR LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN             #subPartitionForClause
	;

iSubQueryRestrictionClause
    : WITH READ ONLY (CONSTRAINT nameIdentifier)?               #withReadOnly
    | WITH CHECK OPTION (CONSTRAINT nameIdentifier)?            #withCheckOption
    ;

whereClause
    : WHERE (currentOfClause | expr)
    ;
currentOfClause
    : CURRENT OF nameIdentifier
    ;

hierarchicalQueryClause
    : CONNECT BY NOCYCLE? connectBy=expr (START WITH startWith=expr)?          #hierarchicalQueryConnectByToStartWithClause
    | START WITH startWith=expr CONNECT BY NOCYCLE? connectBy=expr             #hierarchicalQueryStartWithToConnectByClause
    ;

groupByClause
    : GROUP BY groupByItem (COMMA groupByItem)* havingClause?         #groupByHavingClause
    | havingClause (GROUP BY groupByItem (COMMA groupByItem)*)?       #havingGroupByClause
    ;
havingClause
    : HAVING expr
    ;

groupByItem
    : groupingSetsClause
    | rollupCubeClause
    | expr
    ;

rollupCubeClause
    : (ROLLUP|CUBE) LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN
    ;

groupingSetsClause
    : GROUPING SETS LEFT_PAREN groupingSetsClauseItem (COMMA groupingSetsClauseItem)* RIGHT_PAREN
    ;

groupingSetsClauseItem
    : rollupCubeClause
    | expr
    ;


modelClause
    : MODEL cellReferenceOptions? returnRowsClause? referenceModel* mainModel
    ;

cellReferenceOptions
    : ((IGNORE | KEEP) NAV)? (UNIQUE (DIMENSION | SINGLE REFERENCE))?
    ;

returnRowsClause
    : RETURN (UPDATED | ALL) ROWS
    ;

referenceModel
    : REFERENCE nameIdentifier ON LEFT_PAREN iSelectQuery RIGHT_PAREN modelColumnClauses cellReferenceOptions?
    ;

mainModel
    : (MAIN nameIdentifier)? modelColumnClauses cellReferenceOptions? modelRulesClause
    ;

modelColumnClauses
    : (PARTITION BY LEFT_PAREN partitionBy+=modelColumnClausesItem (COMMA partitionBy+=modelColumnClausesItem)*  RIGHT_PAREN)?
        DIMENSION BY LEFT_PAREN dimensionBy+=modelColumnClausesItem (COMMA dimensionBy+=modelColumnClausesItem)* RIGHT_PAREN
        MEASURES LEFT_PAREN measures+=modelColumnClausesItem (COMMA measures+=modelColumnClausesItem)* RIGHT_PAREN
    ;
modelColumnClausesItem
	: expr nameIdentifier?
	;

modelRulesClause
    : (RULES (UPDATE | UPSERT ALL?)?)? ((AUTOMATIC | SEQUENTIAL) ORDER)? modelIterateClause? LEFT_PAREN (modelRulesClauseItem (COMMA modelRulesClauseItem)*)? RIGHT_PAREN
    ;

modelRulesClauseItem
    : (UPDATE | UPSERT ALL?)? cellAssignment orderByClause? EQUALS_OP expr
    ;

modelIterateClause
    : ITERATE LEFT_PAREN value=expr RIGHT_PAREN (UNTIL LEFT_PAREN until=expr RIGHT_PAREN)?
    ;

cellAssignment
	: expr LEFT_BRACKET cellAssignmentItem (COMMA cellAssignmentItem)* RIGHT_BRACKET
	;
cellAssignmentItem
	: singleColumnForLoop
	| multiColumnForLoop
	| expr
	;

singleColumnForLoop
    : FOR nameIdentifier (IN LEFT_PAREN in+=expr (COMMA in+=expr) RIGHT_PAREN | (LIKE pattern=expr)? FROM from=expr TO to=expr (INCREMENT | DECREMENT) increment=expr)
    ;
multiColumnForLoop
    : FOR LEFT_PAREN nameIdentifier (COMMA nameIdentifier)* RIGHT_PAREN IN LEFT_PAREN in+=expr (COMMA in+=expr) RIGHT_PAREN
    ;

orderByClause
    : ORDER SIBLINGS? BY orderByItem (COMMA orderByItem)*
    ;
orderByItem
	: sortKey=expr orderingSpecification=(ASC | DESC)? (NULLS (FIRST | LAST))?
	;

rowLimitingClause
	: (OFFSET offset=expr  offSetRowType=(ROW | ROWS))?
      (FETCH fetchType=(FIRST | NEXT) (rowCount=expr PERCENT_KEYWORD?)? fetchRowType=(ROW | ROWS) (ONLY | WITH TIES) )?
	;

forUpdateClause
	: FOR UPDATE (OF nameIdentifier (COMMA nameIdentifier)*)? forUpdateOption?
	;

forUpdateOption
    : SKIP_ LOCKED              #forUpdateSkipLockedOption
    | NOWAIT                    #forUpdateNoWaitOption
    | WAIT expr                 #forUpdateWaitOption
    ;

rowPatternClause
	: MATCH_RECOGNIZE LEFT_PAREN partitionByClause? orderByClause?
        (MEASURES exprAsObjectExpr (COMMA exprAsObjectExpr)*)?
        rowPatternRowsPerMatch? rowPatternSkipTo?
        PATTERN LEFT_PAREN rowPattern RIGHT_PAREN
        rowPatternSubsetClause?
        DEFINE exprAsObjectExpr (COMMA exprAsObjectExpr)*
        RIGHT_PAREN
	;

rowPatternRowsPerMatch
	: (ONE ROW| ALL ROWS) PER MATCH
	;

rowPatternSkipTo
	: AFTER MATCH SKIP_ TO NEXT ROW                 #rowPatternSkipToNextRow
	| AFTER MATCH SKIP_ PAST LAST ROW               #rowPatternSkipPastLastRow
	| AFTER MATCH SKIP_ TO FIRST expr               #rowPatternSkipToFirstVar
	| AFTER MATCH SKIP_ TO LAST expr                #rowPatternSkipToLastVart
	| AFTER MATCH SKIP_ TO expr                     #rowPatternSkipToVar
	;

rowPattern
	: rowPattern rowPatternTerm
	| rowPatternTerm
	;
rowPatternTerm
	: rowPatternFactor
	| rowPatternTerm rowPatternFactor
	;
rowPatternFactor
	: rowPatternPrimary rowPatternQuantifier?
	;
rowPatternPrimary
	: nameIdentifier
	| DOLLAR
	| BIT_XOR_OP
	| LEFT_PAREN rowPattern? RIGHT_PAREN
	| LEFT_BRACE MINUS_SIGN rowPattern MINUS_SIGN RIGHT_BRACE
	| rowPatternPermute
	;
rowPatternPermute
	: PERMUTE LEFT_PAREN rowPattern (COMMA rowPattern) RIGHT_PAREN
	;
rowPatternQuantifier
	: ASTERISK QUESTION_MARK?
	| PLUS_SIGN QUESTION_MARK?
	| QUESTION_MARK QUESTION_MARK?
	| LEFT_BRACE expr? COMMA expr? RIGHT_BRACE QUESTION_MARK?
	| LEFT_BRACE expr RIGHT_BRACE
	;
rowPatternSubsetClause
	: SUBSET row_pattern_subset_item (COMMA row_pattern_subset_item)*
	;
row_pattern_subset_item
	: expr EQUALS_OP LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN
	;
row_pattern_rec_func
	: row_pattern_classifier_func
	| row_pattern_match_num_func
	| row_pattern_navigation_func
	| rowPatternAggregateFunc
	;
row_pattern_classifier_func
	: MATCH_NUMBER LEFT_PAREN RIGHT_PAREN
	;
row_pattern_match_num_func
	: MATCH_NUMBER LEFT_PAREN RIGHT_PAREN
	;
row_pattern_navigation_func
	: rowPatternNavLogical
	| rowPatternNavPhysical
	| rowPatternNavCompound
	;
rowPatternNavLogical
	: (RUNNING | FINAL)? (FIRST | LAST)? LEFT_PAREN expr (COMMA expr) RIGHT_PAREN
	;
rowPatternNavPhysical
	: (PREV | NEXT) LEFT_PAREN expr (COMMA expr) RIGHT_PAREN
	;
rowPatternNavCompound
	: (PREV | NEXT) LEFT_PAREN (RUNNING | FINAL)? (FIRST | LAST) LEFT_PAREN expr (COMMA offset=expr)? RIGHT_PAREN (COMMA expr)? RIGHT_PAREN
	;
rowPatternAggregateFunc
	: (RUNNING | FINAL)? aggregateFunction
	;

// --------- Update Start
updateStatement
    : UPDATE iTableReference iUpdateSetClause whereClause? returningIntoClause? errorLoggingClause?
    ;
// Update - Specific Clauses
iUpdateSetClause
	: SET updateSetItemClause (COMMA updateSetItemClause)*      #updateSetClause
	| SET VALUE column=expr EQUALS_OP value=expr                #updateSetByValueClause
	;
updateSetItemClause
	: column=expr EQUALS_OP value=expr
	;
// --------- Update End


// ------------------------------- TCL Start --------------------------

commitStatement
    : COMMIT WORK? commitStatementOption*
    ;
commitStatementOption
	: commitStatementCommentOption
	| commitStatementWriteOption
	| commitStatementForceOption
	;
commitStatementCommentOption
	: COMMENT expr
	;
commitStatementWriteOption
	:  WRITE (WAIT|NOWAIT)? (IMMEDIATE|BATCH)?
	;
commitStatementForceOption
	:  FORCE id=expr (COMMA scn=expr)?
	;

rollbackStatement
    : ROLLBACK WORK? rollbackStatementOption*
    ;
rollbackStatementOption
	: rollbackStatementToSavepointOption
	| rollbackStatementForceOption
	;
rollbackStatementToSavepointOption
	: TO SAVEPOINT? nameIdentifier
	;
rollbackStatementForceOption
	: FORCE expr
	;

savepointStatement
    : SAVEPOINT nameIdentifier
    ;

setTransactionStatement
    : SET TRANSACTION setTransactionStatementOption+
    ;
setTransactionStatementOption
	: setTransactionStatementReadOnlyOption
	| setTransactionStatementReadWriteOption
	| setTransactionStatementIsolationLevelOption
	| setTransactionStatementUseRollbackSegmentOption
	| setTransactionStatementNameOption
	;
setTransactionStatementReadOnlyOption
    : READ ONLY
    ;
setTransactionStatementReadWriteOption
    : READ WRITE
    ;
setTransactionStatementIsolationLevelOption
    : ISOLATION LEVEL (SERIALIZABLE | READ COMMITTED)
    ;
setTransactionStatementUseRollbackSegmentOption
    : USE ROLLBACK SEGMENT nameIdentifier
    ;
setTransactionStatementNameOption
    : NAME expr
    ;

setConstraintStatement
    : SET CONSTRAINT (ALL | nameIdentifier (COMMA nameIdentifier)*) (IMMEDIATE | DEFERRED)
    ;
setConstraintsStatement
    : SET CONSTRAINTS (ALL | nameIdentifier (COMMA nameIdentifier)*) (IMMEDIATE | DEFERRED)
    ;

// ------------------------------- TCL End --------------------------


// ------------------------------- SCL Start --------------------------
alterSessionStatement
	: ALTER SESSION
	;
setRoleStatement
	: SET ROLE
	;
// ------------------------------- SCL End --------------------------

// command

whenever_command
    : WHENEVER (SQLERROR | OSERROR)
      (EXIT (SUCCESS | FAILURE | WARNING) (COMMIT | ROLLBACK) | CONTINUE (COMMIT|ROLLBACK|NONE))
    ;

set_command
    : SET identifier (CHAR_STRING | ON | OFF | expr)
    ;

exit_command
    : EXIT
    ;

prompt_command
    : PROMPT
    ;

show_errors_command
    : SHOW ERR
    | SHOW ERRORS
    ;

start_command
    : START_CMD
    ;

// Common PL/SQL Named Elements

native_datatype_element
    : BINARY_INTEGER
    | PLS_INTEGER
    | NATURAL
    | BINARY_FLOAT
    | BINARY_DOUBLE
    | NATURALN
    | POSITIVE
    | POSITIVEN
    | SIGNTYPE
    | SIMPLE_INTEGER
    | NVARCHAR2
    | DEC
    | INTEGER
    | INT
    | NUMERIC
    | SMALLINT
    | NUMBER
    | DECIMAL
    | DOUBLE PRECISION?
    | FLOAT
    | REAL
    | NCHAR
    | LONG RAW?
    | CHAR
    | CHARACTER
    | VARCHAR2
    | VARCHAR
    | STRING
    | RAW
    | BOOLEAN
    | DATE
    | ROWID
    | UROWID
    | YEAR
    | MONTH
    | DAY
    | HOUR
    | MINUTE
    | SECOND
    | TIMEZONE_HOUR
    | TIMEZONE_MINUTE
    | TIMEZONE_REGION
    | TIMEZONE_ABBR
    | TIMESTAMP
    | TIMESTAMP_UNCONSTRAINED
    | TIMESTAMP_TZ_UNCONSTRAINED
    | TIMESTAMP_LTZ_UNCONSTRAINED
    | TIME_TZ_UNCONSTRAINED
    | TIME_UNCONSTRAINED
    | YMINTERVAL_UNCONSTRAINED
    | DSINTERVAL_UNCONSTRAINED
    | BFILE
    | BLOB
    | CLOB
    | NCLOB
    | MLSLABEL
    ;


// string
allTokens
	: A_LETTER
    | dataMiningFunctionName
    | jsonFunctionName
    | aggregateFunctionName
    | CUBE_TABLE
    | ABS
    | ADD
    | ADVANCED
    | AFTER
    | AGENT
    | AGGREGATE
    //| ALL
    //| ALTER
    | ANALYZE
    //| AND
    //| ANY
    | ARRAY
    // | AS
    //| ASC
    | ASSOCIATE
    | AT
    | ATTRIBUTE
    | AUDIT
    | AUTHID
    | AUTO
    | AUTOMATIC
    | AUTONOMOUS_TRANSACTION
    | BATCH
    | BEFORE
    //| BEGIN
    // | BETWEEN
    | BFILE
    | BINARY_DOUBLE
    | BINARY_FLOAT
    | BINARY_INTEGER
    | BLOB
    | BLOCK
    | BODY
    | BOOLEAN
    | BOTH
    // | BREADTH
    | BULK
    // | BY
    | BYTE
    | C_LETTER
    // | CACHE
    | CALL
    | CANONICAL
    | CASCADE
    //| CASE
    | CAST
    | CHAR
    | CHAR_CS
    | CHARACTER
    //| CHECK
    | CHR
    | CLOB
    | CLOSE
    | CLUSTER
    | COALESCE
    | COLLECT
    | COLUMNS
    | COLUMN_VALUE
    | COMMENT
    | COMMIT
    | COMMITTED
    | COMPATIBILITY
    | COMPILE
    | COMPOUND
    //| CONNECT
    //| CONNECT_BY_ROOT
    | CONSTANT
    | CONSTRAINT
    | CONSTRAINTS
    | CONSTRUCTOR
    | CONTENT
    | CONTEXT
    | CONTINUE
    | CONVERT
    | CORRUPT_XID
    | CORRUPT_XID_ALL
    | COST
    | COUNT
    //| CREATE
    | CROSS
    | CUBE
    //| CURRENT
    | CURRENT_USER
    | CURSOR
    | CUSTOMDATUM
    | CYCLE
    | DATA
    | DATABASE
    //| DATE
    | DAY
    | DB_ROLE_CHANGE
    | DBTIMEZONE
    | DDL
    | DEBUG
    | DEC
    | DECIMAL
    //| DECLARE
    | DECOMPOSE
    | DECREMENT
    //| DEFAULT
    | DEFAULTS
    | DEFERRED
    | DEFINER
    | DELETE
    | DEPTH
    //| DESC
    | DETERMINISTIC
    | DIMENSION
    | DISABLE
    | DISASSOCIATE
    //| DISTINCT
    | DOCUMENT
    | DOUBLE
    //| DROP
    | DSINTERVAL_UNCONSTRAINED
    | E
    | EACH
    | ELEMENT
    //| ELSE
    //| ELSIF
    | EMPTY
    | ENABLE
    | ENCODING
    //| END
    | ENTITYESCAPING
    | ERR
    | ERRORS
    | ESCAPE
    | EVALNAME
    | EXCEPTION
    | EXCEPTION_INIT
    | EXCEPTIONS
    | EXCLUDE
    //| EXCLUSIVE
    | EXECUTE
    //| EXISTS
    | EXIT
    | EXPLAIN
    | EXTERNAL
    | EXTRACT
    | FAILURE
    //| FALSE
    //| FETCH
    | FINAL
    | FIRST
    | FIRST_VALUE
    | FLOAT
    | FOLLOWING
    | FOLLOWS
    //| FOR
    | FORALL
    | FORCE
    // | FROM
    | FULL
    | FUNCTION
    | G
    //| GOTO
    //| GRANT
    //| GROUP
    | GROUPING
    | HASH
    //| HAVING
    | HIDE
    | HOUR
    | ID
    //| IF
    | IGNORE
    | IMMEDIATE
    // | IN
    | INCLUDE
    | INCLUDING
    | INCREMENT
    | INDENT
    //| INDEX
    | INDEXED
    | INDEXTYPE
    | INDICATOR
    | INDICES
    | INFINITE
    | INLINE
    | INNER
    | INOUT
    //| INSERT
    | INSTANTIABLE
    | INSTEAD
    | INT
    | INTEGER
    //| INTERSECT
    | INTERVAL
    // | INTO
    | INVALIDATE
    //| IS
    | ISOLATION
    | ITERATE
    | JAVA
    | JOIN
    | JSON
    | K
    | KEEP
    | KEY
    | LANGUAGE
    | LAST
    | LAST_VALUE
    | LEADING
    | LEFT
    | LENGTH
    | LEVEL
    | LIBRARY
    // | LIKE
    | LIKE2
    | LIKE4
    | LIKEC
    | LIMIT
    | LOCAL
    //| LOCK
    | LOCKED
    | LOG
    | LOGOFF
    | LOGON
    | LONG
    | LOOP
    | M
    | MAIN
    | MAP
    | MATCHED
    | MAXVALUE
    | MEASURES
    | MEMBER
    | MERGE
    //| MINUS
    | MINUTE
    | MINVALUE
    | MLSLABEL
    //| MODE
    | MODEL
    | MODIFY
    | MONTH
    | MULTISET
    | NAME
    | NAN
    | NATURAL
    | NATURALN
    | NAV
    | NCHAR
    | NCHAR_CS
    | NCLOB
    | NESTED
    | NEW
    | NO
    | NOAUDIT
    // | NOCACHE
    | NOCOPY
    | NOCYCLE
    | NOENTITYESCAPING
    //| NOMAXVALUE
    //| NOMINVALUE
    | NONE
    // | NOORDER
    | NOSCHEMACHECK
    //| NOT
    //| NOWAIT
    // | NULL
    | NULLS
    | NUMBER
    | NUMERIC
    | NVARCHAR2
    | OBJECT
    //| OF
    | OFF
    | OID
    | OLD
    //| ON
    | ONLY
    | OPAQUE
    | OPEN
    | OPERATOR
    //| OPTION
    //| OR
    | ORADATA
    //| ORDER
    | ORDINALITY
    | OSERROR
    | OUT
    | OUTER
    | OVER
    | OVERRIDING
    | P
    | PACKAGE
    | PARALLEL
    | PARALLEL_ENABLE
    | PARAMETERS
    | PARENT
    | PARTITION
    | PASSING
    | PATH
    //| PERCENT_ROWTYPE
    //| PERCENT_TYPE
    | PIPELINED
    //| PIVOT
    | PLAN
    | PLS_INTEGER
    | POSITIVE
    | POSITIVEN
    | PRAGMA
    | PRECEDING
    | PRECISION
    | PRESENT
    //| PRIOR
    //| PROCEDURE
    | PUBLIC
    | PURGE

    | Q
    | QUEUE

    | RAISE
    | RANGE
    | RAW
    | READ
    | REAL
    | RECORD
    | REF
    | REFRESH
    | REFERENCE
    | REFERENCING
    | REJECT
    | RELIES_ON
    | RENAME
    | REPLACE
    | RESPECT
    | RESTRICT_REFERENCES
    | RESULT
    | RESULT_CACHE
    | RETURN
    | RETURNING
    | REUSE
    | REVERSE
    //| REVOKE
    | RIGHT
    | ROLLBACK
    | ROLLUP
    | ROW
    | ROWID
    | ROWS
    | RULES
    | SAMPLE
    | SAVE
    | SAVEPOINT
    | SCHEMA
    | SCHEMACHECK
    | SCN
    // | SEARCH
    | SECOND
    | SEED
    | SEGMENT
    // | SELECT
    | SELF
    // | SEQUENCE
    | SEQUENTIAL
    | SERIALIZABLE
    | SERIALLY_REUSABLE
    | SERVERERROR
    | SESSIONTIMEZONE
    | SET
    | SETS
    | SETTINGS
    //| SHARE
    | SHOW
    | SHUTDOWN
    | SIBLINGS
    | SIGNTYPE
    | SIMPLE_INTEGER
    | SINGLE
    //| SIZE
    | SKIP_
    | SMALLINT
    | SNAPSHOT
    | SOME
    | SORT
    | SPECIFICATION
    | SQLDATA
    | SQLERROR
    | STANDALONE
    //| START
    | STARTUP
    | STATEMENT
    | STATEMENT_ID
    | STATIC
    | STATISTICS
    | STORE
    | STRING
    | SUBSTR
    | SUBMULTISET
    | SUBPARTITION
    | SUBSTITUTABLE
    | SUBTYPE
    | SUCCESS
    | SUSPEND
    | SYS
    | SYSAUX
    | T
    | TSYS
    | TABLE
    | TABLESPACE
    | THE
    | THEN
    | TIME
    | TIMESTAMP
    | TIMESTAMP_LTZ_UNCONSTRAINED
    | TIMESTAMP_TZ_UNCONSTRAINED
    | TIMESTAMP_UNCONSTRAINED
    | TIMEZONE_ABBR
    | TIMEZONE_HOUR
    | TIMEZONE_MINUTE
    | TIMEZONE_REGION
    | TO
    | TRAILING
    | TRANSACTION
    | TRANSLATE
    | TREAT
    | TRIGGER
    | TRIM
    | TRUE
    | TRUNCATE
    | TYPE
    | UNBOUNDED
    | UNDER
    //| UNION
    //| UNIQUE
    | UNLIMITED
    //| UNPIVOT
    | UNTIL
    //| UPDATE
    | UPDATED
    | UPSERT
    | UROWID
    | USE
    //| USING
    | VALIDATE
    | VALUE
    //| VALUES
    | VARCHAR
    | VARCHAR2
    | VARIABLE
    | VARRAY
    | VARYING
    | VERSION
    | VERSIONS
    | WAIT
    | WARNING
    | WELLFORMED
    // | WHEN
    | WHENEVER
    // | WHERE
    | WHILE
    //| WITH
    | WITHIN
    | WORK
    | WRITE
    | XML
    | XMLAGG
    | XMLATTRIBUTES
    | XMLCAST
    | XMLCOLATTVAL
    | XMLELEMENT
    | XMLEXISTS
    | XMLFOREST
    | XMLNAMESPACES
    | XMLPARSE
    | XMLPI
    | XMLQUERY
    | XMLROOT
    | XMLSERIALIZE
    | XMLTABLE
    | XMLTYPE
    | YEAR
    | YES
    | YMINTERVAL_UNCONSTRAINED
    | ZONE
    | PREDICTION
    | PREDICTION_BOUNDS
    | PREDICTION_COST
    | PREDICTION_DETAILS
    | PREDICTION_PROBABILITY
    | PREDICTION_SET
    | CUME_DIST
    | DENSE_RANK
    | LISTAGG
//    | PERCENT_RANK
    | PERCENTILE_CONT
    | PERCENTILE_DISC
    | RANK
    | AVG
    | CORR
    | LAG
    | LEAD
    | MAX
    | MEDIAN
    | MIN
    | NTILE
    | RATIO_TO_REPORT
    | ROW_NUMBER
    | SUM
    | VARIANCE
    | REGR_
    | STDDEV
    | VAR_
    | COVAR_
    | INTERFACE
    | PROCEDURE
    | MOD
    | PRIOR
    ;

// Data Type
// https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/Data-Types.html#GUID-A3C0D836-BADB-44E5-A5D4-265BA5968483
// https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/datatype-attribute.html#GUID-B4A364AB-7CC2-4B3F-AF52-09A752029C8E
dataType
    : iCharacterDataType | iNumericDatatype | longAndRawDatatype | dateTimeDataType | largeObjectDataType | iRowidDataType | booleanDataType
    | iJsonDataType
    | ansiSupportedDatatype
    | anyDataType | xmlDataType | spatialDataType | mediaDataType
    | refDataType

	| plsIntegerDataType
	| naturalDataType | naturalnDataType | positiveDataType | positivenDataType | signtypeDataType | simpleIntegerDataType
	| binaryIntegerDataType

	| typeDataType | rowtypeDataType
	| collectionDataType
	| objectSubDataType
	| objectDataType
	| selfAsResultDataType

    | otherDataType
    ;
iCharacterDataType
	: CHAR (LEFT_PAREN size=expr sizeUnit=(BYTE|CHAR)? RIGHT_PAREN)?            #charDataType
	| VARCHAR2 (LEFT_PAREN size=expr sizeUnit=(BYTE|CHAR)? RIGHT_PAREN)?        #varchar2DataType
	| NCHAR (LEFT_PAREN size=expr RIGHT_PAREN)?                                 #ncharDataType
	| NVARCHAR2 LEFT_PAREN size=expr RIGHT_PAREN                                #nvarchar2DataType
	;
iNumericDatatype
	: NUMBER (LEFT_PAREN precision=expr (COMMA scale=expr)? RIGHT_PAREN)?       #numberDataType
	| FLOAT (LEFT_PAREN precision=expr RIGHT_PAREN)?                            #floatDataType
	| BINARY_FLOAT                                                              #binaryFloatDataType
	| BINARY_DOUBLE                                                             #binaryDoubleDataType
	;
longAndRawDatatype
	: LONG                                                                      #longDataType
	| LONG RAW                                                                  #longRawDataType
	| RAW LEFT_PAREN size=expr RIGHT_PAREN                                      #rawDataType
	;
dateTimeDataType
	: DATE                                                                      #dateDataType
	| TIMESTAMP (LEFT_PAREN precision=expr RIGHT_PAREN)?
		(WITH LOCAL? TIME ZONE)?                                                #timestampDataType
	| INTERVAL unit=(YEAR | DAY) (LEFT_PAREN precision=expr RIGHT_PAREN)?
		TO toUnit=(MONTH | SECOND) (LEFT_PAREN toPrecision=expr RIGHT_PAREN)?   #intervalDataType
	;
largeObjectDataType
	: BLOB                              #blobDataType
	| CLOB                              #clobDataType
	| NCLOB                             #nclobDataType
	| BFILE                             #bfileDataType
	;
iRowidDataType
	: ROWID                                               #rowidDataType
	| UROWID (LEFT_PAREN size=expr RIGHT_PAREN)?          #urowidDataType
	;
booleanDataType
	: BOOLEAN
	;

ansiSupportedDatatype
	: CHARACTER LEFT_PAREN size=expr RIGHT_PAREN                                              #characterDataType
	| CHARACTER VARYING LEFT_PAREN size=expr RIGHT_PAREN                                      #characterVaryingDataType
	| CHAR VARYING LEFT_PAREN size=expr RIGHT_PAREN                                           #charVaryingDataType
	| NCHAR VARYING LEFT_PAREN size=expr RIGHT_PAREN                                          #ncharVaryingDataType
	| VARCHAR LEFT_PAREN size=expr RIGHT_PAREN                                                #varcharDataType
	| NATIONAL CHARACTER LEFT_PAREN size=expr RIGHT_PAREN                                     #nationalCharacterDataType
	| NATIONAL CHAR LEFT_PAREN size=expr RIGHT_PAREN                                          #nationalCharDataType
	| NATIONAL CHARACTER VARYING LEFT_PAREN size=expr RIGHT_PAREN                             #nationalCharacterVaryingDataType
    | NATIONAL CHAR VARYING LEFT_PAREN size=expr RIGHT_PAREN                                  #nationalCharVaryingDataType
	| NUMERIC (LEFT_PAREN precision=expr (COMMA scale=expr)? RIGHT_PAREN)?                    #numericDataType
	| DECIMAL (LEFT_PAREN precision=expr (COMMA scale=expr)? RIGHT_PAREN)?                    #decimalDataType
	| DEC (LEFT_PAREN precision=expr (COMMA scale=expr)? RIGHT_PAREN)?                        #decDataType
	| INTEGER                                                                                 #integerDataType
	| INT                                                                                     #intDataType
	| SMALLINT                                                                                #smallintDataType
	| DOUBLE PRECISION                                                                        #doublePrecisionDataType
	| REAL                                                                                    #realDataType
	;

anyDataType
	: (DOUBLE_QUOTE? SYS DOUBLE_QUOTE? PERIOD)? DOUBLE_QUOTE? ANYDATA DOUBLE_QUOTE?              #anyDataDataType
	| (DOUBLE_QUOTE? SYS DOUBLE_QUOTE? PERIOD)? DOUBLE_QUOTE? ANYTYPE DOUBLE_QUOTE?              #anyTypeDataType
	| (DOUBLE_QUOTE? SYS DOUBLE_QUOTE? PERIOD)? DOUBLE_QUOTE? ANYDATASET DOUBLE_QUOTE?           #anyDataSetDataType
	;
xmlDataType
	: (DOUBLE_QUOTE? SYS DOUBLE_QUOTE? PERIOD)? DOUBLE_QUOTE? XMLTYPE DOUBLE_QUOTE?              #xmlTypeDataType
	| (DOUBLE_QUOTE? SYS DOUBLE_QUOTE? PERIOD)? DOUBLE_QUOTE? URITYPE DOUBLE_QUOTE?              #uriTypeDataType
	;
iJsonDataType
	: JSON                          #jsonDataType
	;
spatialDataType
	: (DOUBLE_QUOTE? SYS DOUBLE_QUOTE? PERIOD)? DOUBLE_QUOTE? SDO_GEOMETRY DOUBLE_QUOTE?                  #sdoGeometryDataType
	| (DOUBLE_QUOTE? SYS DOUBLE_QUOTE? PERIOD)? DOUBLE_QUOTE? SDO_TOPO_GEOMETRY DOUBLE_QUOTE?             #sdoTopoGeometryDataType
	| (DOUBLE_QUOTE? SYS DOUBLE_QUOTE? PERIOD)? DOUBLE_QUOTE? SDO_GEORASTER DOUBLE_QUOTE?                 #sdoGeorasterDataType
	;
mediaDataType
	: (DOUBLE_QUOTE? SYS DOUBLE_QUOTE? PERIOD)? DOUBLE_QUOTE? ORDAUDIO DOUBLE_QUOTE?                      #oRDAUDIODataType
	| (DOUBLE_QUOTE? SYS DOUBLE_QUOTE? PERIOD)? DOUBLE_QUOTE? ORDIMAGE DOUBLE_QUOTE?                      #oRDIMAGEDataType
	| (DOUBLE_QUOTE? SYS DOUBLE_QUOTE? PERIOD)? DOUBLE_QUOTE? ORDVIDEO DOUBLE_QUOTE?                      #oRDVIDEODataType
	| (DOUBLE_QUOTE? SYS DOUBLE_QUOTE? PERIOD)? DOUBLE_QUOTE? ORDDOC DOUBLE_QUOTE?                        #oRDDOCDataType
	| (DOUBLE_QUOTE? SYS DOUBLE_QUOTE? PERIOD)? DOUBLE_QUOTE? ORDDICOM DOUBLE_QUOTE?                      #oRDDICOMDataType

	| (DOUBLE_QUOTE? SYS DOUBLE_QUOTE? PERIOD)? DOUBLE_QUOTE? SI_STILLIMAGE DOUBLE_QUOTE?                 #siStillimageDataType
    | (DOUBLE_QUOTE? SYS DOUBLE_QUOTE? PERIOD)? DOUBLE_QUOTE? SI_AVERAGECOLOR DOUBLE_QUOTE?               #siAveragecolorDataType
    | (DOUBLE_QUOTE? SYS DOUBLE_QUOTE? PERIOD)? DOUBLE_QUOTE? SI_POSITIONALCOLOR DOUBLE_QUOTE?            #siPositionalcolorDataType
    | (DOUBLE_QUOTE? SYS DOUBLE_QUOTE? PERIOD)? DOUBLE_QUOTE? SI_COLORHISTOGRAM DOUBLE_QUOTE?             #siColorhistogramDataType
    | (DOUBLE_QUOTE? SYS DOUBLE_QUOTE? PERIOD)? DOUBLE_QUOTE? SI_TEXTURE DOUBLE_QUOTE?                    #siTextureDataType
    | (DOUBLE_QUOTE? SYS DOUBLE_QUOTE? PERIOD)? DOUBLE_QUOTE? SI_FEATURELIST DOUBLE_QUOTE?                #siFeaturelistDataType
    | (DOUBLE_QUOTE? SYS DOUBLE_QUOTE? PERIOD)? DOUBLE_QUOTE? SI_COLOR DOUBLE_QUOTE?                      #siColorDataType
	;

plsIntegerDataType
	: PLS_INTEGER
	;
naturalDataType
	: NATURAL
	;
naturalnDataType
	: NATURALN
	;
positiveDataType
	: POSITIVE
	;
positivenDataType
	: POSITIVEN
	;
signtypeDataType
	: SIGNTYPE
	;
simpleIntegerDataType
	: SIMPLE_INTEGER
	;

binaryIntegerDataType
	: BINARY_INTEGER
	;
collectionDataType
	: assocArrayDataType
	| varrayDataType
	| varyingArrayDataType
	| nestedTableDataType
	;

refDataType
	: REF nameIdentifier
	;
otherDataType
	: name=nameIdentifier (LEFT_PAREN expr? (COMMA expr)* RIGHT_PAREN)?
	;

refCursorDataType
	: REF CURSOR
	;
typeDataType
	: name=nameIdentifier (PERCENT_TYPE | PERCENT TYPE)
	;
rowtypeDataType
	: name=nameIdentifier (PERCENT_ROWTYPE | PERCENT ROWTYPE)
	;
assocArrayDataType
	: TABLE OF of=dataType notNull? INDEX BY indexBy=dataType
	;
varrayDataType
    : VARRAY LEFT_PAREN expr RIGHT_PAREN OF argumentParen=LEFT_PAREN? dataType notNull? RIGHT_PAREN?
    ;
varyingArrayDataType
    : VARYING ARRAY LEFT_PAREN expr RIGHT_PAREN OF argumentParen=LEFT_PAREN? dataType notNull? RIGHT_PAREN?
    ;
nestedTableDataType
    : TABLE OF argumentParen=LEFT_PAREN? dataType notNull? RIGHT_PAREN?
    ;

objectSubDataType
    : UNDER nameIdentifier
    ;
objectDataType
	: OBJECT
	;
selfAsResultDataType
	: SELF AS RESULT
	;

// Identifier
identifier
	: ASTERISK                                                      #asteriskIdentifier
	| REGULAR_ID                                                    #normalIdentifier
	| allTokens                                                     #normalIdentifier
	| DELIMITED_ID                                                  #doubleQuoteIdentifier      // 定界标识符: 带双引号文本 "xx"
	;

nameIdentifier
	: identifier                                                    #identifier1
    | identifier (PERIOD identifier)+                               #propertyIdentifier1
    | queryName=nameIdentifier AT_SIGN dbLink=nameIdentifier        #dbLinkNameIdentifier
	;


// Literals
literal
	: DATE expr                                                                             #dateLiteral
    | TIMESTAMP value=expr                                                                  #timestampLiteral
    | INTERVAL value=expr
		unit=(YEAR | MONTH | DAY | HOUR | MINUTE | SECOND)
		(LEFT_PAREN precisions+=expr (COMMA precisions+=expr)* RIGHT_PAREN)?
		(TO toUnit=(YEAR | MONTH | DAY | HOUR | MINUTE | SECOND)
		(LEFT_PAREN toPrecisions+=expr (COMMA toPrecisions+=expr)* RIGHT_PAREN)?)?          #intervalLiteral

	| NQCHAR_STRING                                                                         #nQCharLiteral
	| NCHAR_STRING                                                                          #nCharLiteral
	| QCHAR_STRING                                                                          #qCharLiteral
	| CHAR_STRING                                                                           #charLiteral

	| MINUS_SIGN UNSIGNED_INTEGER                                                           #integerLiteral
	| UNSIGNED_INTEGER                                                                      #integerLiteral
	| MINUS_SIGN APPROXIMATE_NUM_LIT                                                        #numberLiteral
	| APPROXIMATE_NUM_LIT                                                                   #numberLiteral

	| BINARY_FLOAT_LIT                                                                      #binaryFloatLiteral
	| BINARY_DOUBLE_LIT                                                                     #binaryDoubleLiteral


    | DEFAULT                                                                               #defaultLiteral
    | ANY                                                                                   #anyLiteral
    | MINVALUE                                                                              #minValueLiteral
    | MAXVALUE                                                                              #maxValueLiteral
    | UNLIMITED                                                                             #unlimitedLiteral
    | FALSE                                                                                 #falseLiteral
    | TRUE                                                                                  #trueLiteral
	;

pseudoColumn
	: COLUMN_VALUE                                                  #columnValueExpr
	| CONNECT_BY_ISCYCLE                                            #connectByIsCycleExpr
	| CONNECT_BY_ISLEAF                                             #connectByIsLeafExpr
	| LEVEL                                                         #levelExpr
	| OBJECT_ID                                                     #objectIdExpr
	| OBJECT_VALUE                                                  #objectValueExpr
	| ORA_ROWSCN                                                    #oraRowScnExpr
	| ROWNUM                                                        #rowNumExpr
	| ROWID                                                         #rowIdExpr
	| sequence=nameIdentifier PERIOD (CURRVAL | NEXTVAL)            #sequenceExpr
	| VERSIONS_ENDSCN                                               #versionsEndScnExpr
	| VERSIONS_ENDTIME                                              #versionsEndTimeExpr
	| VERSIONS_OPERATION                                            #versionsOperationExpr
	| VERSIONS_STARTSCN                                             #versionsStartScnExpr
	| VERSIONS_STARTTIME                                            #versionsStartTimeExpr
	| VERSIONS_XID                                                  #versionsXidExpr
	| XMLDATA                                                       #xmlDataExpr
	;

// --------- Operators Start ---------------
unaryOperatorExpr
	: LEFT_PAREN? unaryOperator expr RIGHT_PAREN?
	;
unaryOperator
	: PLUS_SIGN
	| MINUS_SIGN
	| PRIOR
	| CONNECT_BY_ROOT
	| COLLATE
	;
multisetOperatorExpr
	: LEFT_PAREN nestedTable1=nameIdentifier MULTISET EXCEPT (ALL | DISTINCT)?
		nestedTable2=nameIdentifier RIGHT_PAREN                                                         #multisetExceptOperatorExpr
    | LEFT_PAREN nestedTable1=nameIdentifier MULTISET INTERSECT (ALL | DISTINCT)?
        nestedTable2=nameIdentifier RIGHT_PAREN                                                         #multisetIntersectOperatorExpr
    | LEFT_PAREN nestedTable1=nameIdentifier MULTISET UNION (ALL | DISTINCT)?
        nestedTable2=nameIdentifier RIGHT_PAREN                                                         #multisetUnionOperatorExpr
	| nestedTable1=nameIdentifier MULTISET EXCEPT (ALL | DISTINCT)? nestedTable2=nameIdentifier         #multisetExceptOperatorExpr
	| nestedTable1=nameIdentifier MULTISET INTERSECT (ALL | DISTINCT)? nestedTable2=nameIdentifier      #multisetIntersectOperatorExpr
	| nestedTable1=nameIdentifier MULTISET UNION (ALL | DISTINCT)? nestedTable2=nameIdentifier          #multisetUnionOperatorExpr
	;

// --------- Operators End ---------------

// --------- Expressions Start ---------------

variableExpr:                               QUESTION_MARK;
bindVariableExpr:                           ':' nameIdentifier | ':' UNSIGNED_INTEGER;
newVariableRefExpr:                         COLON_NEW nameIdentifier;
oldVariableRefExpr:                         COLON_OLD nameIdentifier;


caseExpr
	: CASE expr? caseExprWhenItem+ caseExprElseClause? END
	;
caseExprWhenItem
	: WHEN when=expr THEN then=expr
	;
caseExprElseClause
	: ELSE expr
	;

intervalExpr
	: LEFT_PAREN value1=expr MINUS_SIGN value2=expr RIGHT_PAREN (DAY|YEAR) (LEFT_PAREN precision=expr RIGHT_PAREN)?
		TO (SECOND|MONTH) (LEFT_PAREN toPrecision=expr RIGHT_PAREN)?
	;

placeholderExpr
	: hostVar=bindVariableExpr INDICATOR? indicatorVar=bindVariableExpr
	;
typeConstructorExpr
	: NEW name=nameIdentifier  LEFT_PAREN (expr (COMMA expr)*)? RIGHT_PAREN
	;
listExpr
    : LEFT_PAREN (expr (COMMA expr)*)? RIGHT_PAREN
	;


exprBasic
	: pseudoColumn
	| newVariableRefExpr
	| oldVariableRefExpr
	| function

	| unaryOperatorExpr

	| nameIdentifier
	| variableExpr
	| bindVariableExpr
	| caseExpr

	| placeholderExpr
    | typeConstructorExpr
	| multisetOperatorExpr
	| implicitCursorExpr
	| namedCursorExpr
	| listExpr
	| intervalExpr
	;

expr
	: NULL                                                                                                              #nullExpr

	| name=expr LEFT_BRACKET (arguments+=cellAssignmentItem (COMMA arguments+=cellAssignmentItem)*)? RIGHT_BRACKET      #arrayExpr
	| CURSOR LEFT_PAREN iSelectQuery RIGHT_PAREN                                                                        #cursorExpr
	| expr PERIOD nameIdentifier                                                                                        #propertyIdentifier2

	| name=nameIdentifier LEFT_PAREN PLUS_SIGN RIGHT_PAREN                                                              #outerExpr

	| name=expr LEFT_PAREN (setQuantifier? arguments+=expr defaultOnConversionErrorExpr?
	    (COMMA arguments+=expr)*)? RIGHT_PAREN                                                                          #methodInvocation2
	| noArgumentFunctionName (LEFT_PAREN (setQuantifier? arguments+=expr (COMMA arguments+=expr)*)? RIGHT_PAREN)?       #methodInvocation1

	| LEFT_PAREN iSelectQuery RIGHT_PAREN                                                                               #selectQueryExpr
	| iSelectQuery                                                                                                      #selectQueryExpr

	| literal                                                                                                           #literal2
    | exprBasic                                                                                                         #basicExpr

	| expr AT LOCAL                                                                                                     #dateTimeAtLocalExpr
    | value=expr AT TIME ZONE timeZone=expr                                                                             #dateTimeAtTimeZoneExpr

    | ANY expr                                                                                                          #anyExpr
    | ALL expr                                                                                                          #allExpr
    | SOME expr                                                                                                         #someExpr

	| expr TO expr                                                                                                      #exprToExprExpr

	| LEFT_PAREN expr operator=(ASTERISK | SOLIDUS | MOD) expr RIGHT_PAREN                                              #binaryOperatorExpr
	| LEFT_PAREN expr operator=(PLUS_SIGN | MINUS_SIGN) expr RIGHT_PAREN                                                #binaryOperatorExpr
	| LEFT_PAREN expr concatenationOp expr RIGHT_PAREN                                                                  #concatenationBinaryOperatorExpr
	| LEFT_PAREN expr comparisonOp expr RIGHT_PAREN                                                                     #relationalBinaryOperatorExpr

	| expr operator=(ASTERISK | SOLIDUS | MOD) expr                                                                     #binaryOperatorExpr
    | expr operator=(PLUS_SIGN | MINUS_SIGN) expr                                                                       #binaryOperatorExpr
    | expr concatenationOp expr                                                                                         #concatenationBinaryOperatorExpr
    | expr comparisonOp expr                                                                                            #relationalBinaryOperatorExpr

    | name=expr NOT? IN LEFT_PAREN values+=expr (COMMA values+=expr)* RIGHT_PAREN                                       #inCondition
    | expr IS NOT? NAN                                                                                                  #isNanCondition
    | expr IS NOT? INFINITE                                                                                             #isInfiniteCondition
    | expr IS PRESENT                                                                                                   #isPresentCondition
    | value=expr NOT? operator=(LIKE | LIKEC | LIKE2 | LIKE4) pattern=expr (ESCAPE escape=expr)?                        #likeCondition
    | expr IS NOT? NULL                                                                                                 #isNullCondition
    | expr IS NOT? JSON formatJson? (STRICT | LAX)? ((WITH | WITHOUT) UNIQUE KEYS)?                                     #isJsonCondition
    | member=expr NOT? MEMBER OF? nestedTable=nameIdentifier                                                            #memberCondition
    | name=expr NOT? BETWEEN between=expr AND and=expr                                                                  #betweenCondition
    | name=expr IS NOT? OF TYPE? LEFT_PAREN isOfTypeConditionItem (COMMA isOfTypeConditionItem)* RIGHT_PAREN            #isOfTypeCondition
    | condition                                                                                                         #iCondition
    | name=expr EQUALS_GREATER_THAN_OP value=expr                                                                       #callArgumentExpr



	| LEFT_PAREN expr operator=COLLATE expr RIGHT_PAREN                                                                 #binaryOperatorExpr
	| expr operator=COLLATE expr                                                                                        #binaryOperatorExpr
	| LEFT_PAREN expr operator=AND expr RIGHT_PAREN                                                                     #binaryOperatorExpr
	| LEFT_PAREN expr operator=OR expr RIGHT_PAREN                                                                      #binaryOperatorExpr
	| expr operator=AND expr                                                                                            #binaryOperatorExpr
	| expr operator=OR expr                                                                                             #binaryOperatorExpr
	;


concatenationOp
	: CONCATENATION_OP
	| BIT_OR_OP BIT_OR_OP
	;

comparisonOp
	: EQUALS_OP

	| NOT_EQUAL_OP
	| EXCLAMATION_SYMBOL EQUALS_OP
	| LESS_THAN_OP GREATER_THAN_OP
	| BIT_XOR_OP EQUALS_OP
	| BIT_NOT_OP EQUALS_OP

	| GREATER_THAN_OP

	| GREATER_THAN_OR_EQUALS_OP
	| GREATER_THAN_OP EQUALS_OP

	| LESS_THAN_OP

	| LESS_THAN_OR_EQUALS_OP
	| LESS_THAN_OP EQUALS_OP
	;

defaultOnConversionErrorExpr
	:  DEFAULT expr ON CONVERSION ERROR
	;
defaultClause
	: (DEFAULT | ASSIGN_OP) expr
	;
defaultOnNullClause
	: DEFAULT ON NULL expr
	;
assignmentExpr
	: column=expr EQUALS_OP value=expr
	;
editionableClause
	: EDITIONABLE
	;
nonEditionableClause
	: NONEDITIONABLE
	;
enableClause
	: ENABLE
	;
disableClause
	: DISABLE
	;
renameToClause
	: RENAME TO nameIdentifier
	;
exceptionClause
	: EXCEPTION exceptionHandler+
	;
usingClause
	: USING usingArgumentClause (COMMA usingArgumentClause)*
	;
usingArgumentClause
	: parameterModel? expr
	;

attributeDefinition
    : nameIdentifier dataType (EXTERNAL NAME externalName=expr)?
    ;
finalClause
	: FINAL
	;
notFinalClause
	: NOT FINAL
	;
instantiableClause
    :  INSTANTIABLE
    ;
notInstantiableClause
    : NOT INSTANTIABLE
    ;
persistableClause
    : PERSISTABLE
    ;
notPersistableClause
    : NOT PERSISTABLE
    ;
secureFileClause
	: SECUREFILE
	;
basicFileClause
	: BASICFILE
	;
resetClause
	: RESET
	;

implicitCursorExpr
	: SQL PERCENT_ISOPEN                                                                                                #isOpenImplicitCursorExpr
	| SQL PERCENT_FOUND                                                                                                 #foundImplicitCursorExpr
	| SQL PERCENT_NOTFOUND                                                                                              #notFoundImplicitCursorExpr
	| SQL PERCENT_ROWCOUNT                                                                                              #rowcountImplicitCursorExpr
	| SQL PERCENT_BULK_ROWCOUNT LEFT_PAREN expr RIGHT_PAREN                                                             #bulkRowcountImplicitCursorExpr
	| SQL PERCENT_BULK_EXCEPTIONS PERIOD COUNT                                                                          #bulkExceptionsCountImplicitCursorExpr
	| SQL PERCENT_BULK_EXCEPTIONS LEFT_PAREN expr RIGHT_PAREN PERIOD (ERROR_INDEX|ERROR_CODE)                           #bulkExceptionImplicitCursorExpr
	;
namedCursorExpr
	: namedCursorName PERCENT_ISOPEN                                                                                                #isOpenNameCursorExpr
    | namedCursorName PERCENT_FOUND                                                                                                 #foundNameCursorExpr
    | namedCursorName PERCENT_NOTFOUND                                                                                              #notFoundNameCursorExpr
    | namedCursorName PERCENT_ROWCOUNT                                                                                              #rowcountNameCursorExpr
	;
namedCursorName
	: nameIdentifier
	| bindVariableExpr
	;
// --------- Expressions End ---------------


// --------- Conditions Start ---------------
condition
	: notCondition
	| isAnyCondition
	| isASetCondition
	| isEmptyCondition
	| submultisetCondition
	| regexpLikeCondition
	| jsonExistsCondition
	| existsCondition
	| insertingCondition
	| updatingCondition
	| deletingCondition
	;

notCondition
	: NOT expr
	;
isAnyCondition
	: (nameIdentifier IS)? ANY
	;
isASetCondition
	: nameIdentifier IS NOT? A_LETTER SET
	;
isEmptyCondition
	: nameIdentifier IS NOT? EMPTY
	;

submultisetCondition
	: nestedTable1=nameIdentifier NOT? SUBMULTISET OF? nestedTable2=nameIdentifier
	;

regexpLikeCondition
	: REGEXP_LIKE LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN
	;
formatJson
	: FORMAT JSON
	;

jsonExistsCondition
	: JSON_EXISTS LEFT_PAREN name=expr formatJson? COMMA pathExpr=expr (PASSING exprAsObjectExpr (COMMA exprAsObjectExpr))? jsonExistsOnErrorClause? RIGHT_PAREN
	;
exprAsObjectExpr
	: expr AS? (expr | dataType)
	;
jsonExistsOnErrorClause
	: (ERROR | TRUE | FALSE) ON ERROR
	;

existsCondition
	: EXISTS LEFT_PAREN iSelectQuery RIGHT_PAREN
	;

isOfTypeConditionItem
	: ONLY? name=nameIdentifier
	;

insertingCondition
	: INSERTING
	;
updatingCondition
	: UPDATING (LEFT_PAREN expr RIGHT_PAREN)?
	;
deletingCondition
	: DELETING
	;

// --------- Conditions End ---------------

// --------- Functions Start ---------------
function
	: chrFunction
	| translateUsingFunction
	| trimFunction
	| extractFunction
	| castFunction
	| treatFunction
	| validateConversionFunction
	| dataMiningFunction

	| xmlCastFunction
	| xmlColAttValFunction
	| xmlElementFunction
	| xmlExistsFunction
	| xmlForestFunction
	| xmlParseFunction
	| xmlPiFunction
	| xmlQueryFunction
	| xmlRootFunction
	| xmlSerializeFunction
	| xmlTableFunction

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
	| CURRENT_TIMESTAMP
    | DBTIMEZONE
    | ITERATION_NUMBER
    | LOCALTIMESTAMP
    | ORA_INVOKING_USER
    | ORA_INVOKING_USERID
    | SESSIONTIMEZONE
    | SYSDATE
    | SYSTIMESTAMP
	| UID
	| USER
	| SQLERRM
	| SQLCODE
	;
chrFunction
	: CHR LEFT_PAREN expr usingNCharCS? RIGHT_PAREN
	;
usingNCharCS
	: USING NCHAR_CS
	;

translateUsingFunction
	: TRANSLATE LEFT_PAREN expr USING (CHAR_CS | NCHAR_CS) RIGHT_PAREN
	;

trimFunction
	: TRIM LEFT_PAREN((LEADING | TRAILING | BOTH)? character=expr? FROM)? source=expr RIGHT_PAREN
	;

extractFunction
	: EXTRACT LEFT_PAREN unit=(YEAR | MONTH | DAY| HOUR | MINUTE | SECOND | TIMEZONE_HOUR | TIMEZONE_MINUTE | TIMEZONE_REGION | TIMEZONE_ABBR) FROM expr RIGHT_PAREN
	;

castFunction
	: CAST LEFT_PAREN castFunctionArgument AS dataType defaultOnConversionErrorExpr? (COMMA expr)* RIGHT_PAREN
	;
castFunctionArgument
	: multisetExpr | expr
	;
multisetExpr
	:  MULTISET LEFT_PAREN iSelectQuery RIGHT_PAREN
	;

treatFunction
	: TREAT LEFT_PAREN expr AS REF? dataType RIGHT_PAREN
	;

validateConversionFunction
	: VALIDATE_CONVERSION LEFT_PAREN expr AS dataType (COMMA expr)* RIGHT_PAREN
	;

dataMiningFunction
	: dataMiningFunctionName LEFT_PAREN dataMiningFunctionArgument? (COMMA expr)* orderedByWeight=(DESC | ASC | ABS)? costMatrixClause?
		(minAtrr1=miningAttributeClause)? (AND andMinAttr=miningAttributeClause)? RIGHT_PAREN overClause?
	;
dataMiningFunctionName
	: CLUSTER_DETAILS
    | CLUSTER_DISTANCE
	| CLUSTER_ID
	| CLUSTER_PROBABILITY
	| CLUSTER_SET
	| FEATURE_COMPARE
	| FEATURE_DETAILS
	| FEATURE_ID
	| FEATURE_SET
	| FEATURE_VALUE
	| ORA_DM_PARTITION_NAME
	| PREDICTION
	| PREDICTION_BOUNDS
	| PREDICTION_COST
	| PREDICTION_DETAILS
	| PREDICTION_PROBABILITY
	| PREDICTION_SET
	;
dataMiningFunctionArgument
	: INTO expr
	| OF ANOMALY
	| FOR expr
	| expr
	;

costMatrixClause
	: COST MODEL AUTO?
	| COST LEFT_PAREN classValues+=expr (COMMA classValues+=expr)* RIGHT_PAREN
		VALUES LEFT_PAREN  costValues+=expr (COMMA  costValues+=expr)*
	;
miningAttributeClause
	: USING exprOrExprAsAliasArgument (COMMA exprOrExprAsAliasArgument)*
	;

xmlCastFunction
	: XMLCAST LEFT_PAREN exprAsObjectExpr RIGHT_PAREN
	;
xmlColAttValFunction
	: XMLCOLATTVAL LEFT_PAREN xmlColAttValFunctionArgument (COMMA xmlColAttValFunctionArgument)RIGHT_PAREN
	;
xmlElementFunction
	: XMLELEMENT LEFT_PAREN (ENTITYESCAPING | NOENTITYESCAPING)? (NAME|EVALNAME)? expr (COMMA xmlAttributesClause) (COMMA exprOrExprAsAliasArgument)* RIGHT_PAREN
	;
xmlExistsFunction
	: XMLEXISTS LEFT_PAREN expr xmlPassingClause? RIGHT_PAREN
	;
xmlForestFunction
	: XMLFOREST LEFT_PAREN xmlColAttValFunctionArgument (COMMA xmlColAttValFunctionArgument)* RIGHT_PAREN
	;
xmlParseFunction
	: XMLPARSE LEFT_PAREN (DOCUMENT | CONTENT)? expr WELLFORMED? RIGHT_PAREN
	;
xmlPiFunction
	: XMLPI LEFT_PAREN (NAME| EVALNAME)? expr (COMMA expr)* RIGHT_PAREN
	;
xmlQueryFunction
	: XMLQUERY LEFT_PAREN expr xmlPassingClause? RETURNING CONTENT (NULL ON EMPTY)? RIGHT_PAREN
	;
xmlRootFunction
	: XMLROOT LEFT_PAREN expr COMMA VERSION xmlRootFunctionVersionExpr (COMMA STANDALONE (YES | NO | NO VALUE))? RIGHT_PAREN
	;
xmlSerializeFunction
	: XMLSERIALIZE LEFT_PAREN (DOCUMENT | CONTENT) value=expr (AS dataType)? (ENCODING encoding=expr)? (VERSION version=expr)?
		(NO INDENT | INDENT (SIZE EQUALS_OP size=expr)?)? ((HIDE | SHOW) DEFAULTS)? RIGHT_PAREN
	;
xmlTableFunction
	: XMLTABLE LEFT_PAREN (xmlNamespacesClause COMMA)? expr xmlTableOption RIGHT_PAREN
	;

xmlRootFunctionVersionExpr
	: NO VALUE
	| expr
	;
xmlColAttValFunctionArgument
	: xmlFunctionEvalNameArgument
	| exprOrExprAsAliasArgument
	;
xmlFunctionEvalNameArgument
	: value=expr AS EVALNAME alias=expr
	;
xmlAttributesClause
	: XMLATTRIBUTES LEFT_PAREN (ENTITYESCAPING | NOENTITYESCAPING)? (SCHEMACHECK | NOSCHEMACHECK)?
		xmlColAttValFunctionArgument (COMMA xmlColAttValFunctionArgument)* RIGHT_PAREN
	;
exprOrExprAsAliasArgument
	: expr
	| exprAsObjectExpr
	;

xmlNamespacesClause
	: XMLNAMESPACES LEFT_PAREN xmlNamespacesClauseArgument (COMMA xmlNamespacesClauseArgument)* RIGHT_PAREN
	;
xmlNamespacesClauseArgument
	: exprAsObjectExpr
	| defaultClause
	;
xmlTableOption
	: xmlPassingClause? returningSequenceByRef? (COLUMNS xmlTableColumn (COMMA xmlTableColumn)*)?
	;
xmlPassingClause
	: PASSING byValue? exprOrExprAsAliasArgument (COMMA exprOrExprAsAliasArgument)*
	;
byValue
	: BY VALUE
	;
returningSequenceByRef
	: RETURNING SEQUENCE BY REF
	;
xmlTableColumn
    : nameIdentifier (FOR ORDINALITY | dataType sequenceByRef? (PATH path=expr)? (DEFAULT default_=expr)?)
    ;
sequenceByRef
	: LEFT_PAREN SEQUENCE RIGHT_PAREN BY REF
	;

jsonFunction
    : jsonFunctionName LEFT_PAREN jsonFunctionArgument? (COMMA jsonFunctionArgument)* orderByClause?
        jsonOnNullClause? jsonReturningClause? STRICT? withUniqueKeys? jsonWrapperClause? jsonOnErrorClause? jsonOnEmptyClause? jsonColumnsClause? RIGHT_PAREN
    ;
jsonFunctionName
	: JSON_QUERY
	| JSON_TABLE
	| JSON_VALUE
	| JSON_ARRAY
	| JSON_ARRAYAGG
	| JSON_OBJECT
	| JSON_OBJECTAGG
	| JSON_DATAGUIDE
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




// ---------------- Common SQL DDL Clauses Start ---------------------

// allocate_extent_clause
allocateExtentClause
	: ALLOCATE EXTENT (LEFT_PAREN allocateExtentItem+ RIGHT_PAREN)?
	;
allocateExtentItem
	: SIZE size=sizeClause
	| DATAFILE dataFile=literal
	| INSTANCE instance=UNSIGNED_INTEGER
	;


// constraint
constraint
	: columnConstraint
	| tableConstraint
	;

columnConstraint
    : (CONSTRAINT nameIdentifier)? NULL iConstraintState*                                                               #nullColumnConstraint
    | (CONSTRAINT nameIdentifier)? NOT NULL iConstraintState*                                                           #notNullColumnConstraint
    | (CONSTRAINT nameIdentifier)? UNIQUE iConstraintState*                                                             #uniqueColumnConstraint
    | (CONSTRAINT nameIdentifier)? PRIMARY KEY iConstraintState*                                                        #primaryKeyColumnConstraint
    | (CONSTRAINT constraintName=nameIdentifier)? REFERENCES referenced=nameIdentifier
        (LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN)? onDeleteAction? iConstraintState*                                  #referencesColumnConstraint
    | (CONSTRAINT nameIdentifier)? CHECK LEFT_PAREN expr RIGHT_PAREN iConstraintState*                                  #checkColumnConstraint
    | SCOPE IS nameIdentifier                                                                                           #scopeIsColumnConstraint
    | WITH ROWID                                                                                                        #withRowIdColumnConstraint
    ;
onDeleteAction
	: ON DELETE (CASCADE | SET NULL)
	;
tableConstraint
    : (CONSTRAINT nameIdentifier)? UNIQUE LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN iConstraintState*                   #uniqueTableConstraint
	| (CONSTRAINT nameIdentifier)? PRIMARY KEY LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN iConstraintState*              #primaryKeyTableConstraint
	| (CONSTRAINT constraintName=nameIdentifier)? FOREIGN KEY
		(LEFT_PAREN referencingColumns+=expr (COMMA referencingColumns+=expr)* RIGHT_PAREN)?
		REFERENCES referencedTable=nameIdentifier
		 (LEFT_PAREN referencedColumns+=expr (COMMA referencedColumns+=expr)* RIGHT_PAREN)?
	    (ON DELETE (CASCADE | SET NULL))? iConstraintState*                                                             #foreignKeyTableConstraint
	| (CONSTRAINT nameIdentifier)? CHECK LEFT_PAREN expr RIGHT_PAREN iConstraintState*                                  #checkTableConstraint
	| SCOPE FOR LEFT_PAREN expr RIGHT_PAREN IS nameIdentifier                                                           #scopeForTableConstraint
	| REF LEFT_PAREN expr RIGHT_PAREN WITH ROWID                                                                        #refWithRowIdTableConstraint
    ;

iConstraintState
	: deferrableConstraintState
	| notDeferrableConstraintState
	| initiallyImmediateConstraintState
	| initiallyDeferredConstraintState
	| relyConstraintState
	| noRelyConstraintState
	| iUsingIndexClause
	| enableConstraintState
	| disableConstraintState
	| validateConstraintState
	| novalidateConstraintState
	| exceptionsClause
	| exceptionsClause
	;
deferrableConstraintState:              DEFERRABLE;
notDeferrableConstraintState:           NOT DEFERRABLE;
initiallyImmediateConstraintState:      INITIALLY IMMEDIATE;
initiallyDeferredConstraintState:       INITIALLY DEFERRED;
relyConstraintState:                    RELY;
noRelyConstraintState:                  NORELY;
enableConstraintState:                  ENABLE;
disableConstraintState:                 DISABLE;
validateConstraintState:                VALIDATE;
novalidateConstraintState:              NOVALIDATE;

exceptionsClause
	: EXCEPTIONS INTO nameIdentifier
	;

// deallocate_unused_clause
deallocateUnusedClause
	: DEALLOCATE UNUSED (KEEP keep=sizeClause)?
	;
fileSpecification
	: dataFileTempFileSpec | redoLogFileSpec
	;
dataFileTempFileSpec
	: fileName=literal? (SIZE size=sizeClause)? REUSE? autoExtendClause?
	;
redoLogFileSpec
	: (fileName1=literal | LEFT_PAREN fileName2=literal (COMMA literal)* RIGHT_PAREN )?
      (SIZE size=sizeClause)? (BLOCKSIZE blockSize=sizeClause)? REUSE?
	;
autoExtendClause
	: AUTOEXTEND (OFF | ON (NEXT next=sizeClause)? maxSizeClause?)
	;
maxSizeClause
	: MAXSIZE (UNLIMITED | sizeClause)
	;
loggingClause
	: LOGGING | NOLOGGING | FILESYSTEM_LIKE_LOGGING
	;
parallelClause
	: NOPARALLEL
	| PARALLEL expr?
	;

// ----------- physical_attributes_clause
physicalAttributesClause
	: usageQueueClause
	| pctfreeClause
	| pctusedClause
	| initransClause
	| maxtransClause
	| storageClause
	;
usageQueueClause
	: USAGE QUEUE
	;
pctfreeClause
	: PCTFREE expr
	;
pctusedClause
	: PCTUSED expr
	;
initransClause
	: INITRANS expr
	;
maxtransClause
	: MAXTRANS expr
	;

sizeClause
	: expr sizeType?
	;
sizeType
	: K | M | G | T | P | E
	;
storageClause
	: STORAGE LEFT_PAREN storageClauseItem+ RIGHT_PAREN
	;
storageClauseItem
	: INITIAL sizeClause                                #storageClauseInitialItem
	| NEXT sizeClause                                   #storageClauseNextItem
	| MINEXTENTS expr                                   #storageClauseMinextentsItem
	| MAXEXTENTS expr                                   #storageClauseMaxextentsItem
	| MAXSIZE (UNLIMITED | sizeClause)                  #storageClauseMaxsizeItem
	| PCTINCREASE expr                                  #storageClausePctincreaseItem
	| FREELISTS expr                                    #storageClauseFreelistsItem
	| FREELIST GROUPS expr                              #storageClauseFreelistGroupsItem
	| OPTIMAL (sizeClause | NULL)?                      #storageClauseOptimalItem
	| BUFFER_POOL (KEEP | RECYCLE | DEFAULT)            #storageClauseBufferPoolItem
	| FLASH_CACHE (KEEP | NONE | DEFAULT)               #storageClauseFlashCacheItem
	| CELL_FLASH_CACHE (KEEP | NONE | DEFAULT)          #storageClauseCellFlashCacheItem
	| ENCRYPT                                           #storageClauseEncryptItem
	;

physicalProperty
	: deferredSegmentCreation
	| segmentAttributesClause
	| iInMemoryClause
	| iInMemoryColumnClause
	| ilmClause
	| physicalPropertyOrganizationHeapClause
	| physicalPropertyOrganizationIndexClause
	| physicalPropertyOrganizationExternalClause
	| physicalPropertyClusterClause
	;
physicalPropertyOrganizationHeapClause
	: ORGANIZATION HEAP segmentAttributesClause* heapOrgTableClause
	;

physicalPropertyOrganizationIndexClause
	: ORGANIZATION INDEX physicalPropertyOrganizationIndexClauseItem*
	;
physicalPropertyOrganizationIndexClauseItem
	: segmentAttributesClause
	| indexOrgTableClause
	;

physicalPropertyOrganizationExternalClause
	: ORGANIZATION EXTERNAL externalTableClause
	;
physicalPropertyClusterClause
	: CLUSTER cluster=expr LEFT_PAREN columns+=expr (COMMA columns+=expr)* RIGHT_PAREN
	;

externalTableClause
	: LEFT_PAREN (TYPE nameIdentifier)? externalTableDataProperty* RIGHT_PAREN (REJECT LIMIT rejectLimit=expr)? inMemoryTableClause?
	;
externalTableDataProperty
	: directoryExpr
	| accessParametersClause
	| locationClause
	;
accessParametersClause
	: ACCESS PARAMETERS accessParametersItem
	;
accessParametersItem
	: USING CLOB iSelectQuery
	| expr
	;

readOnlyClause
	: READ (ONLY|WRITE)
	;
indexingClause
	: INDEXING (ON | OFF)
	;

deferredSegmentCreation
	: SEGMENT CREATION (IMMEDIATE | DEFERRED)
	;

segmentAttributesClause
	: physicalAttributesClause
	| tableSpaceClause
	| tableSpaceSetClause
	| loggingClause
	| tableCompression
	;
tableSpaceClause
	: TABLESPACE nameIdentifier
	;
tableSpaceSetClause
	: TABLESPACE SET nameIdentifier
	;

tableCompression
	: COMPRESS (FOR (ALL | DIRECT_LOAD) OPERATIONS)?            #tableCompressionByCompress
    | ROW STORE COMPRESS (BASIC | ADVANCED)?                    #tableCompressionByRowStoreCompress
    | COLUMN STORE COMPRESS
        (FOR (QUERY | ARCHIVE) (LOW | HIGH)?)?
        (NO? ROW LEVEL LOCKING)?                                #tableCompressionByColumnStoreCompress
    | NOCOMPRESS                                                #tableCompressionByNoCompress
	;
inMemoryTableClause
	: iInMemoryClause? iInMemoryColumnClause*
	;
inMemoryAttributes
	: iInMemoryMemcompress? inMemoryPriority? inMemoryDistribute? iInMemoryDuplicate?
	;
iInMemoryMemcompress
	: MEMCOMPRESS FOR (DML | QUERY (LOW | HIGH) | CAPACITY (LOW | HIGH))                    #inMemoryMemCompressClause
    | NO MEMCOMPRESS                                                                        #inMemoryNoMemCompressClause
	;
inMemoryPriority
	: PRIORITY (NONE | LOW | MEDIUM | HIGH | CRITICAL)
	;
inMemoryDistribute
	: DISTRIBUTE (AUTO | BY (ROWID RANGE | PARTITION | SUBPARTITION))
                 (FOR SERVICE (DEFAULT | ALL | nameIdentifier | NONE))
	;
iInMemoryDuplicate
	: DUPLICATE                     #inMemoryDuplicate
	| DUPLICATE ALL?                #inMemoryDuplicateAll
	| NO DUPLICATE                  #inMemoryNoDuplicate
	;
iInMemoryColumnClause
	: INMEMORY iInMemoryMemcompress? LEFT_PAREN expr (COMMA expr) RIGHT_PAREN           #inMemoryColumnClause
	| NO INMEMORY LEFT_PAREN expr (COMMA expr) RIGHT_PAREN                              #noInMemoryColumnClause
	;

ilmClause
	: ILM ADD POLICY ilmPolicyClause                #ilmClauseAddPolicy
	| ILM DELETE POLICY nameIdentifier              #ilmClauseAddPolicy
	| ILM ENABLE POLICY nameIdentifier              #ilmClauseAddPolicy
	| ILM DISABLE POLICY nameIdentifier             #ilmClauseAddPolicy
	| ILM DELETE_ALL                                #ilmClauseDeleteAll
	| ILM ENABLE_ALL                                #ilmClauseEnableAll
	| ILM DISABLE_ALL                               #ilmClauseDisableAll
	;
ilmPolicyClause
	: ilmCompressionPolicy
	| ilmTieringPolicy
	| ilmInMemoryPolicy
	;
ilmCompressionPolicy
	: tableCompression (SEGMENT | GROUP)? ilmPolicyOption?
	| ROW STORE COMPRESS ADVANCED ROW AFTER ilmTieringPolicy OF NO MODIFICATION
    | COLUMN STORE COMPRESS FOR QUERY ROW AFTER ilmTieringPolicy OF NO MODIFICATION
	;
ilmTieringPolicy
	: TIER TO nameIdentifier (READ ONLY)? (SEGMENT | GROUP)? ilmPolicyOption?
	;
ilmInMemoryPolicy
	: ilmInMemoryPolicyAction SEGMENT? ilmPolicyOption
	;
ilmInMemoryPolicyAction
	: SET INMEMORY inMemoryAttributes?                      #ilmInMemoryPolicyBySetInMemory
	| MODIFY INMEMORY iInMemoryMemcompress                  #ilmInMemoryPolicyByModifyInMemory
	| NO INMEMORY                                           #ilmInMemoryPolicyByNoInMemory
	;

ilmPolicyOption
	: AFTER ilmTimePeriod OF (NO ACCESS | NO MODIFICATION | CREATION)           #ilmAfterOfClause
	| ON nameIdentifier                                                         #ilmOnClause
	;
ilmTimePeriod
	: expr (DAY | DAYS | MONTH | MONTHS | YEAR | YEARS)
	;

substitutableColumnClause
	: ELEMENT? IS OF TYPE? LEFT_PAREN ONLY nameIdentifier RIGHT_PAREN           #substitutableColumnIsOfClause
	| NOT? SUBSTITUTABLE AT ALL LEVELS                                          #substitutableColumnAtAllLevelsClause
	;
nestedTableColProperty
	: NESTED TABLE (COLUMN_VALUE | nestedItem=nameIdentifier) substitutableColumnClause?
      (LOCAL | GLOBAL)? STORE AS storageTable=nameIdentifier (LEFT_PAREN nestedTableColPropertyStoreAsItem+ RIGHT_PAREN)?
      (RETURN AS? (LOCATOR | VALUE))?
	;
nestedTableColPropertyStoreAsItem
	: LEFT_PAREN objectProperty RIGHT_PAREN
	| physicalProperty
	| columnProperty
	;
varrayColProperty
	: VARRAY nameIdentifier substitutableColumnClause? varrayStorageClause?
	;
varrayStorageClause
	: STORE AS basicFileType? LOB segName=nameIdentifier? lobStorageParameters?
	;
lobStorageClause
	: LOB LEFT_PAREN nameIdentifier (COMMA nameIdentifier)* RIGHT_PAREN STORE AS lobStorageClauseStoreAsItem+
	;
lobStorageClauseStoreAsItem
	: secureFileClause
	| basicFileClause
	| lobStorageParameters
	| nameIdentifier
	;
lobStorageParameters
	: LEFT_PAREN lobStorageParameter+ RIGHT_PAREN
	;
lobStorageParameter
	: tableSpaceClause
	| tableSpaceSetClause
	| lobParameter
	| storageClause
	;
lobParameter
	: ENABLE STORAGE IN ROW                             #lobParameterEnable
	| DISABLE STORAGE IN ROW                            #lobParameterDisable
    | CHUNK expr                                        #lobParameterChunk
    | PCTVERSION expr                                   #lobParameterPctversion
    | FREEPOOLS expr                                    #lobParameterFreepools
    | RETENTION (MAX | MIN expr | AUTO | NONE)?         #lobRetentionClause
    | DEDUPLICATE                                       #lobDeduplicate
    | KEEP_DUPLICATES                                   #lobKeepDuplicates
    | COMPRESS (HIGH | MEDIUM | LOW)?                   #lobCompressionClause
    | NOCOMPRESS                                        #lobNoCompressionClause
    | ENCRYPT encryptionSpec                            #lobParameterEncrypt
    | DECRYPT                                           #lobParameterDecrypt
    | CACHE loggingClause?                              #lobParameterCache
    | NOCACHE loggingClause?                            #lobParameterNoCache
    | CACHE READS loggingClause?                        #lobParameterCacheReads
    | REBUILD FREEPOOLS                                 #lobParameterRebuildFreepools
	;

lobPartitionStorage
	: PARTITION partitionName=nameIdentifier lobPartitionStoragePartitionItem+
        (LEFT_PAREN SUBPARTITION subpartitionName=nameIdentifier lobPartitionStorageSubpartitionItem+ RIGHT_PAREN)?
	;
lobPartitionStoragePartitionItem
	: lobStorageClause
	| varrayColProperty
	;
lobPartitionStorageSubpartitionItem
	: lobPartitioningStorage
	| varrayColProperty
	;
lobPartitioningStorage
	: LOB LEFT_PAREN lobItem=nameIdentifier RIGHT_PAREN STORE AS basicFileType? lobSegname=nameIdentifier? (LEFT_PAREN segmentAttributesClause RIGHT_PAREN)?
	;

xmlTypeColumnProperty
	: XMLTYPE COLUMN? expr xmlTypeStorage? xmlSchemaSpec?
	;
xmlTypeStorage
	: STORE AS OBJECT RELATIONAL                                                                                        #xmlTypeStorageAsObjectRelational
    | STORE AS basicFileType? CLOB segName=expr? (LEFT_PAREN lobParameter* RIGHT_PAREN)?                                #xmlTypeStorageAsClob
    | STORE AS basicFileType? BINARY XML segName=expr? (LEFT_PAREN lobParameter* RIGHT_PAREN)?                          #xmlTypeStorageAsBinaryXml
    | STORE AS ALL VARRAYS AS (LOBS | TABLES)                                                                           #xmlTypeStorageAsAllVarrays
	;
xmlSchemaSpec
	: (XMLSCHEMA xmlSchemaUrl=expr)? ELEMENT (elementXmlSchemaUrl=expr SHARP)? element=expr
      (STORE ALL VARRAYS AS (LOBS | TABLES))? ((ALLOW | DISALLOW) NONSCHEMA)? ((ALLOW | DISALLOW) ANYSCHEMA)?
	;

xmlTypeVirtualColumns
	: VIRTUAL COLUMNS LEFT_PAREN xmlTypeVirtualColumnsItem (COMMA xmlTypeVirtualColumnsItem)* RIGHT_PAREN
	;
xmlTypeVirtualColumnsItem
	: nameIdentifier AS LEFT_PAREN expr RIGHT_PAREN
	;

iFlashbackArchiveClause
	: FLASHBACK ARCHIVE nameIdentifier              #flashbackArchiveClause
	| NO FLASHBACK ARCHIVE                          #noFlashbackArchiveClause
	;

storeInClause
	: STORE IN LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN
	;
overflowStoreInClause
	: OVERFLOW STORE IN LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN
	;
subPartitionsetStoreInClause
	: SUBPARTITIONSET STORE IN LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN
	;

tablePartitioningClause
	: iPartitionBy
	| ipartitionsetBy
	;

iPartitionBy
	: partitionByRange
	| partitionByHash
	| partitionByList
	| partitionByReference
	| partitionBySystem
	| partitionByConsistentHash
	;
partitionByRange
	: PARTITION BY RANGE LEFT_PAREN columns+=expr (COMMA columns+=expr)* RIGHT_PAREN
        (INTERVAL interval=expr)? storeInClause? iSubPartitionBy?
        (LEFT_PAREN partitionDefinition (COMMA partitionDefinition)* RIGHT_PAREN)?
	;
partitionByHash
	: PARTITION BY HASH LEFT_PAREN columns+=expr (COMMA columns+=expr)* RIGHT_PAREN
		iSubPartitionBy? (PARTITIONS partitionsNum=expr)? storeInClause? iCompression? overflowStoreInClause?
		(LEFT_PAREN partitionDefinition (COMMA partitionDefinition)* RIGHT_PAREN)?
	;
partitionByList
	: PARTITION BY LIST LEFT_PAREN columns+=expr (COMMA columns+=expr)* RIGHT_PAREN
      AUTOMATIC? storeInClause? iSubPartitionBy? (LEFT_PAREN partitionDefinition (COMMA partitionDefinition)* RIGHT_PAREN)?
	;
partitionByReference
	: PARTITION BY REFERENCE LEFT_PAREN expr RIGHT_PAREN (LEFT_PAREN partitionDefinition (COMMA partitionDefinition)* RIGHT_PAREN)?
	;
partitionBySystem
	: PARTITION BY SYSTEM (PARTITIONS partitionsNum=expr)? (partitionDefinition (COMMA partitionDefinition)*)?
	;
partitionByConsistentHash
	: PARTITION BY CONSISTENT HASH LEFT_PAREN columns+=expr (COMMA columns+=expr)* RIGHT_PAREN
		iSubPartitionBy? partitionsAuto? tableSpaceClause?
	;

partitionDefinition
	: PARTITION partitionName=nameIdentifier? iPartitionValues? partitionDefinitionOption* (SUBPARTITIONS subpartitionsNum=expr)?
		storeInClause? (LEFT_PAREN subPartitionDefinition (COMMA subPartitionDefinition)* RIGHT_PAREN)?
	;
partitionDefinitionOption
	: deferredSegmentCreation
	| readOnlyClause
	| indexingClause
	| iUsingIndexClause
	| segmentAttributesClause
	| iCompression
	| iInMemoryClause
	| ilmClause

	| lobStorageClause
	| varrayColProperty
	| nestedTableColProperty

	| directoryExpr
	| locationClause
	| partitioningStorageClause
	;


ipartitionsetBy
	: partitionsetByRange
	| partitionsetByList
	;
partitionsetByRange
	: PARTITIONSET BY RANGE LEFT_PAREN columns+=expr (COMMA columns+=expr)* RIGHT_PAREN
        iPartitionBy iSubPartitionBy? partitionsAuto? LEFT_PAREN partitionsetDefinition (COMMA partitionsetDefinition)* RIGHT_PAREN
	;
partitionsetByList
	: PARTITIONSET BY LIST LEFT_PAREN columns+=expr (COMMA columns+=expr)* RIGHT_PAREN
       iPartitionBy iSubPartitionBy? partitionsAuto? LEFT_PAREN partitionsetDefinition (COMMA partitionsetDefinition)* RIGHT_PAREN
	;
partitionsetDefinition
	: PARTITIONSET nameIdentifier? iPartitionValues? partitionsetDefinitionOption*
	;
partitionsetDefinitionOption
	: tableSpaceSetClause
	| lobStorageClause
	| subPartitionsetStoreInClause
	;
directoryExpr
	: DEFAULT? DIRECTORY expr
	;
iCompression
	: tableCompression
	| indexCompression
	;
iPartitionValues
	: VALUES LESS THAN LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN            #partitionValuesLessThan
	| VALUES LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN                      #partitionValues
	;

iSubPartitionBy
	: subpartitionByRange
	| subpartitionByList
	| subpartitionByHash
	;

subpartitionTemplate
	: SUBPARTITION TEMPLATE (LEFT_PAREN subPartitionDefinition (COMMA subPartitionDefinition)* RIGHT_PAREN)?
	;

subpartitionByRange
	: SUBPARTITION BY RANGE LEFT_PAREN columns+=expr (COMMA columns+=expr)* RIGHT_PAREN subpartitionTemplate?
	;
subpartitionByList
	: SUBPARTITION BY LIST LEFT_PAREN columns+=expr (COMMA columns+=expr)* RIGHT_PAREN subpartitionTemplate?
	;
subpartitionByHash
	: SUBPARTITION BY HASH LEFT_PAREN columns+=expr (COMMA columns+=expr)* RIGHT_PAREN
		(SUBPARTITIONS subpartitionsNum=expr)? storeInClause? subpartitionTemplate?
	;
subPartitionDefinition
	: SUBPARTITION nameIdentifier? iPartitionValues? subPartitionDefinitionOption*
	;
subPartitionDefinitionOption
	: readOnlyClause
	| iUsingIndexClause
	| partitioningStorageClause
	| directoryExpr
	| locationClause
	;

partitioningStorageClause
	: tableSpaceClause
	| tableSpaceSetClause
	| overflowClause
	| tableCompression
	| indexCompression
	| iInMemoryClause
	| ilmClause
	| lobPartitioningStorage
	| varrayStorageAsClause
	;
overflowClause
	: OVERFLOW overflowClauseItem?
	;
overflowClauseItem
	: tableSpaceClause
	| tableSpaceSetClause
	;
varrayStorageAsClause
	: VARRAY expr STORE AS basicFileType LOB nameIdentifier
	;
iInMemoryClause
	: INMEMORY inMemoryAttributes?                  #inMemoryClause
	| NO INMEMORY                                   #noInMemoryClause
	;

// ---------------- Common SQL DDL Clauses End ---------------------




// --------- PL/SQL Language Elements ---------------

// 13.1 ACCESSIBLE BY Clause
accessibleByClause
	: ACCESSIBLE BY LEFT_PAREN accessor (COMMA accessor)* RIGHT_PAREN
	;
accessor
	: unitKind? unitName=nameIdentifier
	;
unitKind: FUNCTION | PROCEDURE | PACKAGE | TRIGGER | TYPE ;

// 13.2 AGGREGATE Clause
aggregateClause
	: AGGREGATE USING usingName=nameIdentifier
	;

// 13.3 Assignment Statement
assignmentStatement
    : target=expr ASSIGN_OP value=expr
    ;

// 13.4 AUTONOMOUS_TRANSACTION Pragma
autonomousTransPragma
	: PRAGMA AUTONOMOUS_TRANSACTION SEMI
	;

// 13.5 Basic LOOP Statement
basicLoopStatement
	: LOOP bodyItem+ END LOOP nameIdentifier?
	;

// 13.6 Block
plsqlBlock
	: labelDeclaration* (DECLARE declareSection+)? body
	;
declareSection
    : declareSectionItem1
    | declareSectionItem2
    ;
declareSectionItem1
	: typeDefinition
	| cursorDeclaration
	| itemDeclaration
	| functionDeclaration
	| procedureDeclaration
	;
declareSectionItem2
	: cursorDeclaration
	| cursorDefinition
	| functionDeclaration
	| functionDefinition
	| procedureDeclaration
	| procedureDefinition
	;
typeDefinition
	: collectionTypeDefinition
	| recordTypeDefinition
	| refCursorTypeDefinition
	| subTypeDefinition
	;
subTypeDefinition
	: SUBTYPE nameIdentifier IS dataType subTypeDefinitionConstraint? notNull?
	;
subTypeDefinitionConstraint
	: rangeExpr | characterSetOptionExpr
	;
rangeExpr
	: RANGE lowerValue=expr DOUBLE_PERIOD highValue=expr
	;
itemDeclaration
	: variableDeclaration
	| constantDeclaration
	| exceptionDeclaration
	;

body
	: BEGIN bodyItem+ exceptionClause? END nameIdentifier?
	;
bodyItem
	: labelDeclaration* bodyItemStatement (SEMI | EOF)
	;
labelDeclaration: LESS_THAN_LESS_THAN_OP nameIdentifier GREATER_THAN_GREATER_THAN_OP;

bodyItemStatement
    : CREATE swallow_to_semi
    | ALTER swallow_to_semi
    | GRANT ALL? swallow_to_semi
    | TRUNCATE swallow_to_semi

	| body
	| plsqlBlock

    | assignmentStatement
    | basicLoopStatement
    | caseStatement
    | closeStatement
    | collectionMethodCall
    | continueStatement
    | executeImmediateStatement
    | exitStatement
    | fetchStatement
    | forLoopStatement
    | forallStatement
    | gotoStatement
    | ifStatement
    | nullStatement
    | openStatement
    | openForStatement
    | pipeRowStatement

	| procedureCall
    | raiseStatement
    | returnStatement
    | selectIntoStatement
    | sqlStatement
    | whileLoopStatement
    ;

procedureCall
	: nameIdentifier (LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN)?
	;

// 13.7 Call Specification
callSpec
    : LANGUAGE JAVA NAME nameIdentifier                                                                     #javaDeclaration
    | (LANGUAGE C_LETTER | EXTERNAL) cDeclarationName*
        (AGENT IN LEFT_PAREN agentIn+=expr (COMMA agentIn+=expr)* RIGHT_PAREN)?
        withContext? (PARAMETERS LEFT_PAREN externalParameter (COMMA externalParameter)* RIGHT_PAREN)?      #cDeclaration
    ;
cDeclarationName
    : NAME expr               #languageCName
    | LIBRARY expr            #languageClibraryName
    ;
withContext
	: WITH CONTEXT
	;
externalParameter
	: CONTEXT                                                                           #contextExternalParameter
	| SELF externalParameterProperty?                                                   #selfExternalParameter
	| nameIdentifier externalParameterProperty? byReference? dataType?                  #returnExternalParameter
	;
externalParameterProperty
	: TDO
	| INDICATOR
	| INDICATOR STRUCT
	| INDICATOR TDO
	| LENGTH
	| DURATION
	| MAXLEN
	| CHARSETID
	| CHARSETFORM
	;
byReference
	: BY REFERENCE
	;
// 13.8 CASE Statement
caseStatement
	: CASE expr? caseStatementWhenItem+  caseStatementElseClause? END CASE nameIdentifier?
	;
caseStatementWhenItem
    : WHEN expr THEN bodyItem
    ;
caseStatementElseClause
    : ELSE bodyItem+
    ;

// 13.9 CLOSE Statement
closeStatement
    : CLOSE expr
	;

// 13.10 Collection Method Invocation
collectionMethodCall
	: collection=nameIdentifier PERIOD collectionMethod (LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN)?
	;
collectionMethod
	: COUNT
	| DELETE
	| EXISTS
	| EXTEND
	| FIRST
	| LAST
	| LIMIT
	| NEXT
	| PRIOR
	| TRIM
	;


// 13.11 Collection Variable Declaration
collectionTypeDefinition
	: TYPE nameIdentifier IS dataType SEMI
	;

// 13.13 COMPILE Clause
compileClause
	: COMPILE DEBUG? (PACKAGE | BODY | SPECIFICATION)? assignmentExpr* (REUSE SETTINGS)?
	;

// 13.14 Constant Declaration
constantDeclaration
	: nameIdentifier CONSTANT dataType notNull? defaultClause SEMI
	;

// 13.15 CONTINUE Statement
continueStatement
    : CONTINUE nameIdentifier? (WHEN expr)?
    ;

// 13.16 COVERAGE Pragma
coveragePragma
	: PRAGMA COVERAGE LEFT_PAREN expr RIGHT_PAREN SEMI
	;

// 13.17 Cursor FOR LOOP Statement
// see FOR LOOP Statement

// 13.18 Cursor Variable Declaration
refCursorTypeDefinition
	: TYPE nameIdentifier IS REF CURSOR RETURN dataType SEMI
	;

// 13.20 DEFAULT COLLATION Clause
collationExpr
	: DEFAULT? COLLATION collation=nameIdentifier
	;
collateExpr
	: DEFAULT? COLLATE collate=nameIdentifier
	;

// 13.22 DEPRECATE Pragma
deprecatePragma
	: PRAGMA DEPRECATE LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN SEMI
	;

// 13.23 DETERMINISTIC Clause
deterministicClause
	: DETERMINISTIC
	;

// 13.24 Element Specification
elementSpec
	: inheritanceClauses* elementSpecItem+ (COMMA restrictReferencesPragma)?
	;
elementSpecItem
	: subProgramDeclaration
	| constructorDeclaration
	| constructorDefinition
	| mapOrderFunctionDeclaration
	;
inheritanceClauses
	: OVERRIDING
	| FINAL
	| INSTANTIABLE
	| NOT OVERRIDING
    | NOT FINAL
    | NOT INSTANTIABLE
	;
subProgramDeclaration
    : (MEMBER|STATIC) subProgramExpr
    ;
subProgramExpr
	: procedureDeclaration
	| procedureDefinition
	| functionDeclaration
	| functionDefinition
	;

constructorDeclaration
	: FINAL? INSTANTIABLE? CONSTRUCTOR FUNCTION constructorFunction=dataType
		(LEFT_PAREN (SELF IN OUT selfInOut=dataType COMMA)? parameterDeclaration (COMMA parameterDeclaration)*  RIGHT_PAREN)?
		RETURN SELF AS RESULT
	;
constructorDefinition
    : FINAL? INSTANTIABLE? CONSTRUCTOR FUNCTION constructorFunction=dataType
		(LEFT_PAREN (SELF IN OUT selfInOut=dataType COMMA)? parameterDeclaration (COMMA parameterDeclaration)*  RIGHT_PAREN)?
        RETURN SELF AS RESULT asType (declareSection* body SEMI | callSpec)
    ;
mapOrderFunctionDeclaration
    : (MAP | ORDER) MEMBER mapOrderFunctionDeclarationItem
    ;
mapOrderFunctionDeclarationItem
	: functionDeclaration
	| functionDefinition
	;
iExternalNameClause
	: EXTERNAL NAME expr                #externalNameClause
	| EXTERNAL VARIABLE NAME expr       #externalVariableNameClause
	;

// 13.25 EXCEPTION_INIT Pragma
exceptionInitPragma
	: PRAGMA EXCEPTION_INIT LEFT_PAREN expr (COMMA expr)* SEMI
	;


// 13.26 Exception Declaration
exceptionDeclaration
    : nameIdentifier EXCEPTION SEMI
    ;

// 13.27 Exception Handler
exceptionHandler
	: WHEN nameIdentifier (OR nameIdentifier)*
        THEN bodyItem+
	;

// 13.28 EXECUTE IMMEDIATE Statement
executeImmediateStatement
	: EXECUTE IMMEDIATE stmt=expr bulkCollect? (INTO intoItems+=expr (COMMA intoItems+=expr)*)? usingClause? returningIntoClause?
	;


// 13.29 EXIT Statement
exitStatement
    : EXIT nameIdentifier? (WHEN expr)?
    ;

// 13.30 Explicit Cursor Declaration and Definition
cursorDeclaration
    : CURSOR nameIdentifier (LEFT_PAREN parameterDeclaration (COMMA parameterDeclaration)* RIGHT_PAREN)? RETURN dataType SEMI
    ;
cursorDefinition
	: CURSOR nameIdentifier (LEFT_PAREN parameterDeclaration (COMMA parameterDeclaration)* RIGHT_PAREN)? (RETURN dataType)? IS selectStatement SEMI
	;


// 13.32 FETCH Statement
fetchStatement
    : FETCH name=expr bulkCollect? INTO intoItems+=expr (COMMA intoItems+=expr)* (LIMIT limit=expr)?
    ;

// 13.33 FOR LOOP Statement
forLoopStatement
	: FOR index=expr IN REVERSE? forLoopStatementCondition
		LOOP bodyItem+ END LOOP nameIdentifier?
	;
forLoopStatementCondition
	: iBoundsClause
	| expr
	;

// 13.34 FORALL Statement
forallStatement
    : FORALL nameIdentifier IN iBoundsClause before=saveExceptions? dmlStatement after=saveExceptions?
    ;
iBoundsClause
    : lower=expr DOUBLE_PERIOD upper=expr                                   #boundsClause
    | INDICES OF nameIdentifier (BETWEEN lower=expr AND upper=expr)?        #boundsClauseByIndicesOf
    | VALUES OF nameIdentifier                                              #boundsClauseByValuesOf
    ;


// 13.35 Formal Parameter Declaration
parameterDeclaration
	: nameIdentifier parameterModel? NOCOPY? dataType? defaultClause?
	;
parameterModel
	: IN
	| OUT
	| IN OUT
	;

// 13.36 Function Declaration and Definition
functionDeclaration
	: functionHeading iExternalNameClause? functionProperty* SEMI?
	;
functionDefinition
	: functionHeading functionProperty* (IS | AS) (declareSection* body SEMI | callSpec)
	;
functionProperty
	: invokerRightsClause
	| accessibleByClause
	| deterministicClause
    | iPipelinedClause
    | iParallelEnableClause
    | resultCacheClause

	;
functionHeading
	: FUNCTION nameIdentifier (LEFT_PAREN parameterDeclaration (COMMA parameterDeclaration)* RIGHT_PAREN)? RETURN dataType
	;

// 13.37 GOTO Statement
gotoStatement
    : GOTO nameIdentifier
    ;

// 13.38 IF Statement
ifStatement
    : IF expr THEN then+=bodyItem+ ifStatementElsIf* (ELSE else_+=bodyItem*)? END IF
    ;

ifStatementElsIf
    : ELSIF expr THEN bodyItem+
    ;

// 13.40 INLINE Pragma
inlinePragma
	: PRAGMA INLINE LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN SEMI
	;

// 13.41 Invoker’s Rights and Definer’s Rights Clause
invokerRightsClause
    : AUTHID (CURRENT_USER | DEFINER)
    ;

// 13.44 NULL Statement
nullStatement
    : NULL
    ;

// 13.45 OPEN Statement
openStatement
    : OPEN name=nameIdentifier (LEFT_PAREN parameter+=expr (COMMA parameter+=expr)* RIGHT_PAREN)?
    ;
// 13.46 OPEN FOR Statement
openForStatement
    : OPEN open=expr FOR forExpr=expr usingClause?
    ;

// 13.47 PARALLEL_ENABLE Clause
iParallelEnableClause
	: PARALLEL_ENABLE                                                                                                   #parallelEnableClause
	| PARALLEL_ENABLE LEFT_PAREN PARTITION expr BY ANY  RIGHT_PAREN                                                     #parallelEnableByAnyClause
	| PARALLEL_ENABLE LEFT_PAREN PARTITION expr BY HASH
		LEFT_PAREN nameIdentifier (COMMA nameIdentifier)* LEFT_PAREN streamingClause? RIGHT_PAREN                       #parallelEnableByHashClause
	| PARALLEL_ENABLE LEFT_PAREN PARTITION expr BY RANGE
		LEFT_PAREN nameIdentifier (COMMA nameIdentifier)* RIGHT_PAREN streamingClause? RIGHT_PAREN                      #parallelEnableByRangeClause
	| PARALLEL_ENABLE LEFT_PAREN PARTITION expr BY VALUE RIGHT_PAREN nameIdentifier RIGHT_PAREN                         #parallelEnableByValueClause
	;
streamingClause
	:  (ORDER | CLUSTER) value=expr BY LEFT_PAREN argument+=expr (COMMA argument+=expr)* RIGHT_PAREN
	;

// 13.48 PIPE ROW Statement
pipeRowStatement
    : PIPE ROW LEFT_PAREN expr RIGHT_PAREN
    ;

// 13.49 PIPELINED Clause
iPipelinedClause
	: PIPELINED                                                         #pipelinedClause
	| PIPELINED USING nameIdentifier                                    #pipelinedByUsingClause
    | PIPELINED ROW POLYMORPHIC USING nameIdentifier                    #pipelinedByRowClause
    | PIPELINED TABLE POLYMORPHIC USING nameIdentifier                  #pipelinedByTableClause
	;

// 13.50 Procedure Declaration and Definition
procedureDeclaration
	: procedureHeading procedureProperty* SEMI?
	;
procedureDefinition
	: procedureHeading procedureProperty* (IS | AS) (declareSection* body SEMI | callSpec)
	;
procedureHeading
	: PROCEDURE nameIdentifier (LEFT_PAREN parameterDeclaration (COMMA parameterDeclaration)* RIGHT_PAREN)?
	;
procedureProperty
	: accessibleByClause
	| collationExpr
	| invokerRightsClause
	;

// 13.51 RAISE Statement
raiseStatement
    : RAISE nameIdentifier?
    ;

// 13.52 Record Variable Declaration
recordTypeDefinition
	: TYPE nameIdentifier IS RECORD LEFT_PAREN variableDeclaration (COMMA variableDeclaration)* RIGHT_PAREN SEMI
	;

// 13.53 RESTRICT_REFERENCES Pragma
restrictReferencesPragma
	: PRAGMA RESTRICT_REFERENCES LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN SEMI
	;

// 13.54 RETURN Statement
returnStatement
    : RETURN expr?
    ;

// 13.55 RETURNING INTO Clause
returningIntoClause
    : (RETURNING | RETURN) returningItems+=expr (COMMA returningItems+=expr)* bulkCollect?
        INTO intoItems+=expr (COMMA intoItems+=expr)*
    ;

// 13.56 RESULT_CACHE Clause
resultCacheClause
	: RESULT_CACHE (RELIES_ON LEFT_PAREN (expr (COMMA expr)*)? RIGHT_PAREN)?
	;


// 13.58 Scalar Variable Declaration
variableDeclaration
    : nameIdentifier dataType notNull? defaultClause? SEMI
    ;

// 13.59 SELECT INTO Statement
selectIntoStatement
	: SELECT setQuantifier? selectItem (COMMA selectItem)* bulkCollect? INTO selectTargetItem (COMMA selectTargetItem)*
		fromClause? whereClause? hierarchicalQueryClause? groupByClause? modelClause? orderByClause? rowLimitingClause? forUpdateClause?
	;
// select Into Statement Details
selectTargetItem
	: expr
	;

// 13.60 SERIALLY_REUSABLE Pragma
seriallyReusablePragma
	: PRAGMA SERIALLY_REUSABLE SEMI
	;

// 13.61 SHARING Clause
sharingClause
	: SHARING EQUALS_OP (METADATA | NONE | DATA | EXTENDED DATA)
	;

// 13.65 UDF Pragma
udfPragma
	: UDF PRAGMA
	;

// 13.67 WHILE LOOP Statement
whileLoopStatement
	: WHILE expr LOOP bodyItem+ END LOOP endLabel=nameIdentifier?
    ;



// details
orReplace
	: OR REPLACE
	;
notNull
	: NOT NULL
	;
bulkCollect
	: BULK COLLECT
	;
errorLoggingClause
    : LOG ERRORS (INTO nameIdentifier)? (LEFT_PAREN simpleExpr=expr RIGHT_PAREN)? (REJECT LIMIT rejectLimit=expr)?
    ;
saveExceptions
	: SAVE EXCEPTIONS
	;
editionableType
	: EDITIONABLE
	| NONEDITIONABLE
	| EDITIONING
	| EDITIONABLE EDITIONING
	;
asType
	: IS | AS
	;
visibleType
	: VISIBLE
	| INVISIBLE
	;
forUpdate
	: FOR UPDATE
	;
partitionsAuto
	: PARTITIONS AUTO
	;
enableType
	: ENABLE | DISABLE
	;
cacheType
	: CACHE
	| NOCACHE
	;
basicFileType
	: SECUREFILE | BASICFILE
	;
invalidationType
	: (DEFERRED | IMMEDIATE) INVALIDATION
	;
validateType
	: VALIDATE | NOVALIDATE
	;
forceType
	: FORCE
	| NOFORCE
	;
keepIndexType
	: (KEEP | DROP) INDEX
	;
yesType
	: YES | NO
	;