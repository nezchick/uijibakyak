프로젝트 요구사항 정의서
=======================
본 문서는 일정 관리 및 루틴 공유 사이트인 가칭 '의지박약' 프로젝트의 요구사항을 정의한 문서이다.

프로젝트 목적
------------
이 프로젝트는 사용자가 간단히 일정을 저장하고 나만의 루틴을 만들어 가는 것을 돕는다.


프로젝트 구조
------------

프로젝트 기능
------------
- 회원가입/로그인
회원가입을 할 수 있다.
회원 가입에는 이메일, 비밀번호, 닉네임 데이터가 필요하다.
이메일, 닉네임은 중복을 허용하지 않는다.
로그인을 할 수 있다.
저장된 이메일과 비밀번호가 일치하면 로그인에 성공한다.

- 회원정보수정
비밀번호와 닉네임을 변경할 수 있다.

- 일정저장/달력기능
일정을 저장한다.
날짜가 지정된 일정은 달력에 표시된다.

- 일정보기
저장된 일정을 불러온다.
일정은 임의로 묶을 수 있다.
완료 버튼을 누르거나, 날짜가 지정된 경우에 해당 날짜가 되면 일정은 완료일정으로 넘어간다.

- 완료일정보기/루틴생성/루틴공유
완료된 일정을 불러온다.
완료일정은 임의로 묶을 수 있다.
묶인 일정을 루틴으로써 타 사용자와 공유할 수 있다.

- 그룹기능
사용자 간의 그룹을 만들어 동일한 루틴을 공유하며 진척도를 비교할 수 있다.
그룹에 소속된 사용자만 그룹에 접근할 수 있다.

- 게시판
그냥.....뭐...나 이만큼 했다 자랑도 하구..
그냥...게시판..
사용자들의... 커뮤니티....느낌...
로그인한 사용자만 이용할 수 있다.

사용 기술스택
------------
- SpringBoot
- Java
- MySQL