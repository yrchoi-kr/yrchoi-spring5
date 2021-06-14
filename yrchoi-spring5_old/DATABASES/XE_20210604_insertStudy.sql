-- transactional
-- commit과 rollback;(DML문:INSERT, UPDATE, DELETE)
-- rollback는 제일 마지막 커밋된 상태로 되돌립니다.
DROP TABLE tbl_member_del;
CREATE TABLE TBL_MEMBER_DEL
(
USER_ID VARCHAR(50)
,USER_PW VARCHAR(255)
,USER_NAME VARCHAR(255)
,EMAIL VARCHAR(255)
,POINT NUMBER(11)
,ENABLED NUMBER(1)
,LEVELS VARCHAR(255)
,REG_DATE TIMESTAMP
,UPDATE_DATE TIMESTAMP
);
--ALTER 테이블로 필드명 변경(아래)
DESC tbl_member_del;
ALTER TABLE tbl_member_del RENAME COLUMN email TO user_email;
--DEPT테이블의 DEPTNO 숫자2자리때문에 에러 -> 4자리 크기를 변경
DESC dept; --작은 자리수 에서 큰자리수로 가는건 문제없음 단 큰자리수에서 작은 자리수로 변경하는건 에러남
ALTER TABLE dept MODIFY(deptno NUMBER(4));

--8장 함수(count, upper, lower, to_char, round...)
--부서별 연봉의 합계를 구해서 제일급여가 많이 지출되는 부서(아래)
SELECT * FROM emp, dept
WHERE emp.deptno = dept.deptno;
SELECT * FROM emp e JOIN dept d
ON e.deptno = d.deptno
WHERE e.ename = 'SCOTT';
--조인과 그룹을 이용해서 댓글 카운터도 출력하는 게시판리스트만들기
SELECT bod.bno, title, COUNT(*) AS reply_count, writer, bod.reg_date,view_count 
FROM tbl_board BOD
INNER JOIN tbl_reply REP ON bod.bno=rep.bno
GROUP BY bod.bno, title, writer, bod.reg_date, view_count
ORDER BY bod.bno;
--표준쿼리(ANSI)방식(아래) INNER 키워드 디폴트 값임.
SELECT d.dname, e.* FROM emp e JOIN dept d ON e.deptno = d.deptno WHERE e.ename = 'SCOTT';
SELECT deptno, round(avg(sal)) FROM emp
--where avg(sal) >=2000;
GROUP BY deptno
HAVING avg(sal) >=2000;
SELECT R.* FROM (
SELECT deptno, Sum(sal) AS dept_sal  FROM emp GROUP BY deptno
) R ORDER BY dept_sal DESC;
SELECT ename, ROUND(sal,-3) FROM emp; --레코드가 여러개 
SELECT SUM(sal) FROM emp; --1개의 레코드만 그룹함수라고 말함.
SELECT round(AVG(sal),2) FROM emp; --평균 1개의 레코드로 출력
SELECT COUNT(*) FROM emp WHERE sal < 
(
SELECT round(AVG(sal),2) FROM emp
);
--위쿼리는 사원중에 평균연봉보다 많이 받는 사람의 숫자. error
--위 AVG함수를 where 조건에 사용 못할때 서브쿼리를 이용합니다.
SELECT MAX(sal), MIN(sal), MAX(sal)-MIN(sal) AS "" FROM emp;
--DDL문(create; alter;), DCL문(commit; rollback;)
--DML문(Data Manufacture Language) insert,update,delete
--insert문:테이블에 새로운 레코드(row)를 추가
CREATE TABLE dept02 AS SELECT * FROM dept WHERE 1=0;
--위 쿼리는 테이블을 복제하는 명령
--위처럼 쿼리를 실행 dept테이블과 구조와 내용이 똑같은 테이블생성
--where 조건이 붙으면, 구조는 같으나 내용은 빈 테이블이 생성
INSERT INTO dept02(
--필드명
deptno, dname, loc
)VALUES(
10, '개발부서', '천안'
--바인딩값
);
--DCL명령어 인 커밋이 필수입니다.
COMMIT;--데이터베이스쿼리직접입력한 결과는 반드시 커밋을 해줘야지만
--실제 저장이 됩니다. 커밋을 하지않으면, 여기만 보이고, 다른곳은X
SELECT * FROM dept02 ORDER BY deptno;
--DELETE는 레코드1줄을 지우는 명령
DELETE FROM dept02 WHERE deptno >= 0;
--DROP table 테이블명은 테이블 자체를 물리적으로 없애는 명령
DROP TABLE dept02; --드롭테이블 커밋없이 바로 적용가능.
CREATE TABLE emp01 AS SELECT * FROM emp;
SELECT * FROM emp01;
--UPDATE 테이블명 SET 필드명 = '바꿀값' where empno='특정ID'
UPDATE emp01 SET ename = '최영락' WHERE empno = 7839;
ROLLBACK;--롤백은 마지막 커밋 바로전까지 되돌립니다.
UPDATE emp01 SET sal =sal*1.1; --모든직원연봉을 10%인상
UPDATE emp01 SET hiredate = sysdate;





