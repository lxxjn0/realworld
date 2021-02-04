# Endpoint - Profiles

## Get Profile - 프로필 조회

### Url

- `GET /api/profiles/:username`

### Request

- Authentication optional

- Empty body

### Response

- Profile

```json
{
  "profile": {
    "username": "jake",
    "bio": "I work at statefarm",
    "image": "https://static.productionready.io/images/smiley-cyrus.jpg",
    "following": false
  }
}
```

## Follow User - 팔로우

### Url

- `POST /api/profiles/:username/follow`

### Request

- Authentication

- Empty Body

### Response

- Profile

```json
{
  "profile": {
    "username": "jake",
    "bio": "I work at statefarm",
    "image": "https://static.productionready.io/images/smiley-cyrus.jpg",
    "following": false
  }
}
```

## Unfollow User - 언팔로우

### Url

- `DELETE /api/profiles/:username/follow`

### Request

- Authentication

- Empty Body

### Response

- Profile

```json
{
  "profile": {
    "username": "jake",
    "bio": "I work at statefarm",
    "image": "https://static.productionready.io/images/smiley-cyrus.jpg",
    "following": false
  }
}
```