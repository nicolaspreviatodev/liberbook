# Liberbook

Rede social de livros — backend em Java 17 + Spring Boot 4, arquitetura hexagonal
(Ports & Adapters), um pacote por domínio.

## Antes de rodar
Confira as versões exatas de dependências (Spring Boot 4 é recente — nov/2025) em:
https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-4.0-Migration-Guide

## Como rodar localmente
1. Suba um Postgres local (ou aponte para o Neon) e exporte as variáveis:
   `DB_URL`, `DB_USERNAME`, `DB_PASSWORD`, `JWT_SECRET`
2. `mvn spring-boot:run`
3. A API sobe em `http://localhost:8080`; teste com `POST /api/users`

## Estrutura
Cada pacote de topo em `com.liberbook` é um domínio independente, organizado em:
`domain/` (puro) → `application/` (casos de uso) → `adapter/` (web + persistência).

O módulo `user` está implementado por completo como referência — cadastro de
usuário ponta a ponta (domínio, caso de uso, controller REST, persistência JPA).
Os demais módulos têm só a pasta e um README explicando o padrão a seguir.

## Testes
- `mvn test` roda os testes normais + o `ArchitectureTest` (ArchUnit), que quebra
  o build se o pacote `domain` de qualquer módulo importar Spring ou JPA.
