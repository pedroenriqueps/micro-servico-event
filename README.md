# Evento Microserviço

## Visão Geral

Este projeto é uma API desenvolvida usando Java, Java Spring e H2 como banco de dados. Foi criada para demonstrar como construir e integrar microsserviços usando Java Spring.

## Sobre o projeto

- Ferramentas Utilizadas
- Configuração
- Endpoints da API
- Banco de Dados
- Contribuições

## Ferramentas Utilizadas

- Java
- Java Spring
- Maven
- H2 Database

Exemplo de resposta:

```json
[
  {
    "id": "ae413540-515d-4add-8cd1-1702c7d280d7",
    "maxParticipants": 20,
    "registeredParticipants": 0,
    "date": "28/11/2023",
    "title": "Frontin Floripa",
    "description": "Evento Tech em Floripa!!"
  }
]
```

### Obter Eventos Futuros

**GET** `/events/upcoming` - Lista todos os eventos futuros (eventos com datas posteriores à data atual).

Exemplo de resposta:

```json
[
  {
    "id": "ae413540-515d-4add-8cd1-1702c7d280d7",
    "maxParticipants": 20,
    "registeredParticipants": 0,
    "date": "28/11/2023",
    "title": "Frontin Floripa",
    "description": "Evento Tech em Floripa!!"
  }
]
```

### Registrar um Novo Evento

**POST** `/events` - Registra um novo evento.

Exemplo de corpo da requisição:

```json
{
  "maxParticipants": 20,
  "registeredParticipants": 0,
  "date": "28/11/2023",
  "title": "Frontin Floripa",
  "description": "Evento Tech em Floripa!!"
}
```

### Registrar um Participante

**POST** `/events/{id}` - Registra um usuário em um evento, se não estiver cheio.

Exemplo de corpo da requisição:

```json
{
  "participantEmail": "liveskipperdev@gmail.com"
}
```

## Banco de Dados

Este projeto utiliza o H2 Database como banco de dados.

## Contribuições

Contribuições são bem-vindas! Se você encontrar algum problema ou tiver sugestões de melhorias, abra uma issue ou envie um pull request para o repositório.

Ao contribuir, por favor:

- Siga o estilo de código existente.
- Use mensagens de commit claras e descritivas.
- Submeta as alterações em um branch separado.

