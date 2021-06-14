-- ������ Oracle SQL Developer Data Modeler 19.2.0.182.1216
--   ��ġ:        2021-05-31 15:03:52 KST
--   ����Ʈ:      Oracle Database 11g
--   ����:      Oracle Database 11g




CREATE TABLE tbl_attach (
    save_file_name   VARCHAR2(255) NOT NULL,
    real_file_name   VARCHAR2(255),
    reg_date         DATE,
    bno              NUMBER(11)
)
LOGGING;

COMMENT ON TABLE tbl_attach IS
    '÷�����ϰ������̺�';

COMMENT ON COLUMN tbl_attach.save_file_name IS
    '��������������Ǵ� ÷�����ϸ�(�ؽõ�����)';

COMMENT ON COLUMN tbl_attach.real_file_name IS
    '�ѱ����ϸ����� UI���� ���̰�';

COMMENT ON COLUMN tbl_attach.reg_date IS
    '�������';

COMMENT ON COLUMN tbl_attach.bno IS
    '�θ����̺��ǰ���Ű';

ALTER TABLE tbl_attach ADD CONSTRAINT tbl_attach_pk PRIMARY KEY ( save_file_name );
CREATE TABLE tbl_board (
    bno           NUMBER(11) NOT NULL,
    title         VARCHAR2(255),
    content       CLOB,
    writer        VARCHAR2(50),
    view_count    NUMBER(11),
    reply_count   NUMBER(11),
    reg_data      TIMESTAMP,
    update_data   TIMESTAMP,
    board_type    VARCHAR2(20)
)
LOGGING;

COMMENT ON TABLE tbl_board IS
    '�Խù��������̺�';

COMMENT ON COLUMN tbl_board.bno IS
    '�Խ��ǰ�����ȣ(�ڵ�����ó��)';

COMMENT ON COLUMN tbl_board.title IS
    '�Խù�����';

COMMENT ON COLUMN tbl_board.content IS
    '�۳���';

COMMENT ON COLUMN tbl_board.writer IS
    '���ۼ���ID';

COMMENT ON COLUMN tbl_board.view_count IS
    '����ȸ��ī����';

COMMENT ON COLUMN tbl_board.reply_count IS
    '��� ī��Ʈ';

COMMENT ON COLUMN tbl_board.reg_data IS
    '����Ͻ�';

COMMENT ON COLUMN tbl_board.update_data IS
    '�����Ͻ�';

ALTER TABLE tbl_board ADD CONSTRAINT tbl_board_pk PRIMARY KEY ( bno );
CREATE TABLE tbl_board_type (
    board_type   VARCHAR2(20) NOT NULL,
    board_name   VARCHAR2(50),
    board_sun    NUMBER(11)
)
LOGGING;

COMMENT ON TABLE tbl_board_type IS
    '�Խ��ǻ�������(NOTICE,GALLERY���)';

COMMENT ON COLUMN tbl_board_type.board_type IS
    '�Խ���Ÿ��(NOTICE, GALLERY��)';

COMMENT ON COLUMN tbl_board_type.board_name IS
    '�ѱ۰Խ����̸�';

COMMENT ON COLUMN tbl_board_type.board_sun IS
    '�Խ��� ��� ����';

ALTER TABLE tbl_board_type ADD CONSTRAINT tbl_board_type_pk PRIMARY KEY ( board_type );
CREATE TABLE tbl_member (
    user_id       VARCHAR2(50) NOT NULL,
    user_pw       VARCHAR2(255),
    user_name     VARCHAR2(255),
    email         VARCHAR2(255),
    point         NUMBER(11),
    enabled       NUMBER(1),
    levels        VARCHAR2(50),
    update_date   TIMESTAMP
)
LOGGING;

COMMENT ON TABLE tbl_member IS
    'ȸ���������̺�';

COMMENT ON COLUMN tbl_member.user_id IS
    'ȸ������ID';

COMMENT ON COLUMN tbl_member.user_pw IS
    'ȸ���α��ξ�ȣ(��������ť��Ƽ)';

COMMENT ON COLUMN tbl_member.user_name IS
    'ȸ���̸�';

COMMENT ON COLUMN tbl_member.email IS
    'ȸ���̸���';

COMMENT ON COLUMN tbl_member.point IS
    'ȸ������Ʈ';

COMMENT ON COLUMN tbl_member.enabled IS
    '�α��ν��ο���';

COMMENT ON COLUMN tbl_member.levels IS
    'ȸ������(ROLE_ADMIN,ROLE_USER)';

COMMENT ON COLUMN tbl_member.update_date IS
    '�����Ͻ�';

ALTER TABLE tbl_member ADD CONSTRAINT tbl_member_pk PRIMARY KEY ( user_id );
CREATE TABLE tbl_reply (
    rno           NUMBER(11) NOT NULL,
    reply_text    VARCHAR2(255),
    replyer       VARCHAR2(50),
    reg_date      DATE,
    update_date   DATE,
    bno           NUMBER(11)
)
LOGGING;

COMMENT ON TABLE tbl_reply IS
    '��۰������̺�';

COMMENT ON COLUMN tbl_reply.rno IS
    '��۰�����ȣ(�ڵ�����AI)';

COMMENT ON COLUMN tbl_reply.reply_text IS
    '��۳���';

COMMENT ON COLUMN tbl_reply.replyer IS
    '����ۼ���ID';

COMMENT ON COLUMN tbl_reply.reg_date IS
    '������';

COMMENT ON COLUMN tbl_reply.update_date IS
    '������';

ALTER TABLE tbl_reply ADD CONSTRAINT table_5_pk PRIMARY KEY ( rno );
ALTER TABLE tbl_attach
    ADD CONSTRAINT tbl_attach_tbl_board_fk FOREIGN KEY ( bno )
        REFERENCES tbl_board ( bno )
            ON DELETE CASCADE
    NOT DEFERRABLE;
ALTER TABLE tbl_board
    ADD CONSTRAINT tbl_board_tbl_board_type_fk FOREIGN KEY ( board_type )
        REFERENCES tbl_board_type ( board_type )
    NOT DEFERRABLE;
ALTER TABLE tbl_reply
    ADD CONSTRAINT tbl_reply_tbl_board_fk FOREIGN KEY ( bno )
        REFERENCES tbl_board ( bno )
    NOT DEFERRABLE;

-- Oracle SQL Developer Data Modeler ��� ����: 
-- 
-- CREATE TABLE                             5
-- CREATE INDEX                             0
-- CREATE VIEW                              0
-- ALTER TABLE                              8
-- ALTER INDEX                              0
-- ALTER VIEW                               0
-- DROP TABLE                               0
-- DROP INDEX                               0
-- DROP VIEW                                0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- DROP PACKAGE                             0
-- DROP PACKAGE BODY                        0
-- DROP PROCEDURE                           0
-- DROP FUNCTION                            0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- DROP TRIGGER                             0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- DROP TYPE                                0
-- CREATE SEQUENCE                          0
-- ALTER SEQUENCE                           0
-- DROP SEQUENCE                            0
-- CREATE MATERIALIZED VIEW                 0
-- DROP MATERIALIZED VIEW                   0
-- CREATE SYNONYM                           0
-- DROP SYNONYM                             0
-- CREATE DIMENSION                         0
-- DROP DIMENSION                           0
-- CREATE CONTEXT                           0
-- DROP CONTEXT                             0
-- CREATE DIRECTORY                         0
-- DROP DIRECTORY                           0

-- 
-- ERRORS                                   0
-- WARNINGS                                 0
