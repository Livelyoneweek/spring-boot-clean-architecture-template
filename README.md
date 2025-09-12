# Java Spring Clean Architecture Template

이 프로젝트는 DDD (도메인 주도 설계)와 클린 아키텍처(Clean Architecture)를 적용한 Spring Boot 템플릿입니다. 복잡한 비즈니스 로직을 효과적으로 관리하고, 유연하고 확장 가능한 애플리케이션을 구축하는 것을 목표로 합니다.

## 🚀 주요 기술 스택 (Tech Stack)

- **Java 24**
- **Spring Boot 3.5.5**
- **Gradle**
- **Spring Security**: 인증 및 인가
- **Spring Data JPA**: 데이터 영속성
- **QueryDSL**: 타입-세이프(Type-safe)한 동적 쿼리
- **SQLite**: 경량 데이터베이스 (개발 및 테스트용)
- **Lombok**: 보일러플레이트 코드 감소

## 🏛️ 프로젝트 구조 (Project Structure)

클린 아키텍처의 의존성 규칙(안쪽 원이 바깥쪽 원을 알지 못함)에 따라 계층을 분리했습니다.

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

### 📂 계층별 설명

1.  **`domain` (도메인 계층)**
    -   비즈니스의 가장 핵심 규칙과 데이터(Entity, Value Object, Domain Event)를 포함합니다.
    -   다른 어떤 계층에도 의존하지 않는 순수한 비즈니스 로직의 집합입니다.
    -   예: `Member`, `Post` 엔티티

2.  **`application` (애플리케이션 계층)**
    -   사용자의 요청을 처리하는 Use Case를 구현합니다.
    -   도메인 객체를 사용하여 비즈니스 흐름을 조정(Orchestration)합니다.

3.  **`infrastructure` (인프라스트럭처 계층)**
    -   데이터베이스, 외부 API 연동, 메시징 큐 등 외부 기술을 다룹니다.
    -   애플리케이션 계층의 `port.out` 인터페이스를 구현하는 `Adapter`가 위치합니다.
    -   예: `JpaMemberRepository`, `JpaPostRepository`

4.  **`interface` (인터페이스 계층)**
    -   외부와의 상호작용을 담당하는 진입점(Entry Point)입니다.
    -   Spring MVC 컨트롤러(`@RestController`) 등이 위치하며, 사용자의 입력을 받아 애플리케이션 계층으로 전달합니다.

5.  **`common` (공통 계층)**
    -   설정(`@Configuration`), 전역 예외 처리(`@RestControllerAdvice`), 유틸리티 클래스 등 여러 계층에서 공통으로 사용되는 코드를 포함합니다.

## ✨ 주요 특징 (Features)

-   **DDD & 클린 아키텍처**: 유지보수성과 테스트 용이성을 높이는 구조.
-   **Spring Security 기본 설정**: 기본적인 인증/인가 처리를 위한 시큐리티 필터 및 설정 포함.
-   **예제 엔티티**: `Member`와 `Post`를 통해 기본적인 관계 매핑 및 CRUD 예시 제공.
-   **QueryDSL 통합**: 컴파일 시점에 타입 체크가 가능한 동적 쿼리 작성 환경.

## 🏁 시작하기 (Getting Started)

### 빌드

```bash
./gradlew build
```

### 실행

```bash
./gradlew bootRun
```

프로젝트가 성공적으로 실행되면 `localhost:8080`에서 애플리케이션을 확인할 수 있습니다.
