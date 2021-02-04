# Endpoint - Users

## Authentication - 로그인

### Url

- `POST /api/users/login`

### Request

- No authentication

- `email`, `password` : not null

```json
{
  "user": {
    "email": "jake@jake.jake",
    "password": "jakejake"
  }
}
```

### Response body

- User

```json
{
  "user": {
    "email": "jake@jake.jake",
    "token": "jwt.token.here",
    "username": "jake",
    "bio": "I work at statefarm",
    "image": null
  }
}
```

## Registration - 회원가입

### Url

- `POST /api/users`

### Request

- No authentication

- `email`, `password`, `username` : not null

```json
{
  "user": {
    "username": "Jacob",
    "email": "jake@jake.jake",
    "password": "jakejake"
  }
}
```

### Response

- User

```json
{
  "user": {
    "email": "jake@jake.jake",
    "token": "jwt.token.here",
    "username": "jake",
    "bio": "I work at statefarm",
    "image": null
  }
}
```

## Get Current User - 현재 사용자 조회

### Url

- `GET /api/user`

### Request

- Authentication

- Empty Body

### Response

- 현재 User

```json
{
  "user": {
    "email": "jake@jake.jake",
    "token": "jwt.token.here",
    "username": "jake",
    "bio": "I work at statefarm",
    "image": null
  }
}
```

## Update User - 현재 사용자 수정

### Url

- `PUT /api/user`

### Request

- Authentication

- Accepted fields : `email`, `username`, `password`, `image`, `bio`

  - 전부 넘겨주고 변경하지 않는 값을 null 처리 해야할 듯

```json
{
  "user": {
    "email": "updated-jake@jake.jake",
    "password": "updatedjakejake",
    "username": "updated-jake",
    "bio": "updated",
    "image": null
  }
}
```

### Response

- User

```json
{
  "user": {
    "email": "jake@jake.jake",
    "token": "jwt.token.here",
    "username": "jake",
    "bio": "I work at statefarm",
    "image": null
  }
}
```