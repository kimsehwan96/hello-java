# 학교 과제 중 계산기 프로그램 만들다가 만든 프로젝트

- 우선 vs code에서 만들고, 테스트하고 실행했는데, 하나의 jar 파일로 배포하고자 만든 프로젝트.

- 우선 이 디렉터리는 Eclipse에서 도움을 받아서 만들었다. 

* soruce 밑에 module-info.java가 있는데

```java
module ProjectTest {
	requires java.desktop;
}
```

이렇게 작성되어있다. 

내 프로젝트 이름인 ProjectTest가 모듈명으로 들어가있고.

`requires java.desktop;`은 Swing을 사용하기 위해서 넣어줬다 (안넣으면 swing 임포트에서 미친듯한 빨간 줄 들이 나온다..;;)

* Eclipse에서 Project Export * jar 파일로 export 해서 실행가능한 파일 만들었다.

## TODO:
class path, 자바 프로젝트 디렉터리의 구조, 패키지 / 모듈 / 등등 용어나 개념이 아직 확립되지 않아서 중구 난방 상태다.

-> 언젠가 정리해보겠다