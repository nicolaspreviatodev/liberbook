# Módulo library

Siga exatamente o padrão do módulo `user` (veja a raiz do projeto):

- `domain/`        → regras de negócio puras, zero import de Spring
- `application/port/in`  → interface do caso de uso
- `application/port/out` → interface do que o módulo precisa de fora
- `application/service`  → implementa o port "in", usa @Service
- `adapter/in/web`       → @RestController + DTOs
- `adapter/out/persistence` → @Entity + Repository + implementa o port "out"

Apague este README quando o módulo tiver código de verdade.
