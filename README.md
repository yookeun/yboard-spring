yboard-spring
============
>**yboard-spring은 jquery, angularJS, bootstrap, spring을 이용한 간단한 게시판입니다.**

게시판은 웹의 기본기능을 모두 담고 있습니다.
조회(select), 입력(insert), 수정(update), 삭제(delete)등 포함되어 있습니다.
그래서 새로운 언어를 이용해서 간단한 게시판을 만들어보면 새로운 언어의 특성을 배울 수 있습니다.
즉, 초급자에게 새로운 언어의 특성을 잘 보여주는 프로토타입이라고 할 수 있습니다.

yboard-spring은 jquery와 spring간의 ajax기반으로 json 메시지를 주고받는 
REST API 구조로 되어 있습니다.
따라서 본 소스를 통해서 jquery, spring간의 연동 방법을 배울 수 있고, 
아울러서 bootstrap를 통해서 UI를 만들 수 있습니다.

-------------
**yboard-spring에 적용된 기술은 다음과 같습니다.**



사용된 오픈소스|버전
------------|---
java|1.7
spring|3.2.8
maven|3.0
jquery|1.10.2
jquery-mobile|1.4.5
bower|1.3.12


-----


Database는 mariadb나 mysql등으로 사용되었으나, MSSQL, ORACLE용으로도 사용이 가능합니다.

설치방법은 eclipse에서
>**import > maven > Existing Maven Projects**

처리하면 됩니다.
그리고 이클립스내에서 서버로 등록하면 바로 사용할 수 있습니다.
물론, 그전에 DB를 설치하고 해당 생성 쿼리문을 이용해서 테이블을 만들어야 합니다.
생성테이블은  아래 경로에 위치하고 있습니다.

>**src/main/resources/install_sql/install_yboard_mysql.sql** 


------
**추가사항**

- 2015.03.15 : JQuery-mobile부분이 추가되었습니다.(모바일화면에서 jquery 부분 조회가능함)


