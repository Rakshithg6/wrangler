grammar Directives;

// Parser Rules
directive
    : aggregateStats
    | otherDirectives
    ;

aggregateStats
    : 'aggregate-stats' byteSizeColumn timeDurationColumn targetSizeColumn targetTimeColumn
    ;

byteSizeColumn
    : COLUMN_NAME
    ;

timeDurationColumn
    : COLUMN_NAME
    ;

targetSizeColumn
    : COLUMN_NAME
    ;

targetTimeColumn
    : COLUMN_NAME
    ;

// Lexer Rules
BYTE_SIZE
    : [0-9]+ ('.' [0-9]+)? ('B'|'KB'|'MB'|'GB'|'TB')
    ;

TIME_DURATION
    : [0-9]+ ('.' [0-9]+)? ('ns'|'us'|'µs'|'ms'|'s'|'m'|'h')
    ;

BYTE_UNIT
    : 'B' | 'KB' | 'MB' | 'GB' | 'TB'
    ;

TIME_UNIT
    : 'ns' | 'us' | 'µs' | 'ms' | 's' | 'm' | 'h'
    ;

COLUMN_NAME
    : [a-zA-Z_][a-zA-Z0-9_]*
    ;

WS
    : [ \t\r\n]+ -> skip
    ;
