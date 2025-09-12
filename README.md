# Java Spring Clean Architecture Template

DDD (도메인 주도 설계)와 클린 아키텍처(Clean Architecture)를 적용한 Spring Boot 템플릿.
복잡한 비즈니스 로직의 효과적인 관리와 유연하고 확장 가능한 애플리케이션 구축을 목표로 함.

## 기술 스택 (Tech Stack)

- **Java 24**
- **Spring Boot 3.5.5**
- **Gradle**
- **Spring Security**: 인증 및 인가
- **Spring Data JPA**: 데이터 영속성
- **QueryDSL**: 타입-세이프(Type-safe)한 동적 쿼리
- **SQLite**: 경량 데이터베이스
- **Lombok**: 보일러플레이트 코드 감소
- **JUnit 5**: 테스트 프레임워크

## 프로젝트 구조 (Project Structure)

클린 아키텍처의 의존성 규칙(안쪽 원이 바깥쪽 원을 알지 못함)에 따라 계층을 분리.
패키지 구조는 기능별 패키지(Package-by-Feature) 방식을 채택하여 기능별 응집도를 높임.

```
src
└── main
    └── java
        └── template
            └── choi
                └── java_spring_clean_arci
                    ├── domain/           # Domain Layer
                    ├── application/      # Application Layer
                    ├── infrastructure/   # Infrastructure Layer
                    ├── interface/        # Interface Layer (or Presentation)
                    └── common/           # Common Utilities & Config
```

### 계층별 설명

1.  **`domain` (도메인 계층)**
    -   비즈니스의 가장 핵심 규칙과 데이터(Entity, Value Object)를 포함.
    -   다른 어떤 계층에도 의존하지 않는 순수한 비즈니스 로직의 집합.
    -   외부에 필요한 기능을 포트(Port) 인터페이스로 정의.

2.  **`application` (애플리케이션 계층)**
    -   사용자의 요청을 처리하는 유스케이스(Use Case)를 구현.
    -   도메인 객체를 사용하여 비즈니스 흐름을 조정(Orchestration).
    -   입력 포트(Input Port)를 통해 외부에 기능을 노출하고, 출력 포트(Output Port)를 통해 외부 기능에 의존.

3.  **`infrastructure` (인프라스트럭처 계층)**
    -   데이터베이스, 외부 API 연동, 메시징 큐 등 외부 기술을 다루는 영역.
    -   내부 계층(도메인, 애플리케이션)이 정의한 출력 포트(Port)에 대한 실제 구현체(Adapter)가 위치.

4.  **`interface` (인터페이스 계층)**
    -   외부와의 상호작용을 담당하는 진입점(Entry Point).
    -   Spring MVC 컨트롤러(`@RestController`) 등이 위치하며, 사용자의 입력을 받아 애플리케이션 계층으로 전달하는 어댑터(Adapter) 역할.

5.  **`common` (공통 계층)**
    -   여러 계층에서 공통으로 사용되는 코드(전역 예외, 커스텀 어노테이션, 순수 유틸리티 등)를 포함.
    -   특정 계층이나 프레임워크에 의존하지 않아야 함.

## 주요 특징 (Features)

-   DDD와 클린 아키텍처 기반의 유지보수 및 테스트 용이성이 높은 구조.
-   헥사고날 아키텍처(포트와 어댑터) 패턴을 통한 계층 간 느슨한 결합(Loose Coupling).
-   Spring Security와 JWT를 통한 인증/인가 기본 설정.
-   예제 엔티티 (`Member`) 및 로그인 기능 포함.

## 시작하기 (Getting Started)

### 빌드

```bash
./gradlew build
```

### 실행

```bash
./gradlew bootRun
```