# KD's Diary
start : 22.05.15 <br><br>
원하는 라이브러리 다써보고, 공부도해보고, 내 장난감이라고 생각하고 계속 붙혀나갈 예정 <br>

사용한 기술 <br>
#### Swagger, GenerateSwaggerCode
gradle 설정, yaml로 swagger 작성, spec-json작성, generateSwaggerCode 을 돌려서 코드 자동 생성 <br>
controller 구현체를 생성(Impl) - @Service를 통해서 구현해주고 서비스처럼 사용한다  <br>
swagger의 config을 사용해서 쓸때없는 로그들을 제거해줘야할듯하다 이상한 로그들이 수없이 뜬다 <br>


#### JPA, H2
Docker에서 MySQL을 실행시켜두고 연결해서 사용하자 <br>


<br><br>

#### TODO
- CustomException 구현
- 프로젝트 설계? 구조? 작성하기



<br><br><br>


#### SLF4j + logback
gradle 설정 추가 -> logback 설정추가(resource/logback.xml) <br>
Gradle에 작성하는걸 보자 <br>
- compile : 프로젝트를 컴파일할 때 필요한 의존성
- compileOnly : Gradle이 컴파일 경로만 종속성을 추가한다 따라서 빌드 출력시에는 출력되지 않는 모습이다
- runTime : 프로젝트를 실행할 때 필요한 의존 라이브러리들, 기본적으로 compile을 포함
- runTimeOnly : gradle이 런타임시에 사용하도록 빌드 출력에만 종속성을 추가
- testCompile : 프로젝트의 테스트를 컴파일할 떄 필요한 라이브러리들, 기본적으로 프로젝트의 컴파일된 클래스와 compile 의존성을 포함
- testRuntime : 프로젝트의 테스트르르 실행할 때만 필요한 라이브러리들, 기본적으로 compile, runtime, testCompile 의존성을 포함
- annotationProcessor : 주석 프로세서인 라이브러리를 추가하기 위해서는 이놈을 사용해서 주석 프로세서 클래스 경로에 추가해야함, 이걸 사용하면 컴파일 클래스의 경로를 이것과 분리해서 빌드 가능
- implementation : 순수하게 내부에서만 사용하고 외부에서는 표현되지 않게 의존성을 추가하고 싶을 때 사용