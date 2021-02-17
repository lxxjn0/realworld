# Endpoint - Articles

## List Articles - 게시글 전체 조회

### Url

- `GET /api/articles`

### Request

- Authentication optional

- Query Parameters

  - default : 모든 게시글 조회

  - `?tag=:tag` : 해당 태그로 게시글 필터링

  - `?author=:author` : 해당 작가로 게시글 필터링

  - `?favorited=:username` : 해당 사용자가 좋아요를 누른 게시글 필터링

  - `?limit=:limit` : 해당 값만큼 게시글 조회

  - `?offset=:offset` : 해당 값만큼의 게시글을 스킵하고 조회

- 아마 `limit`과 `offset`을 함께 사용해서 페이지네이션

### Response

- Multiple Articles

- 최신 순으로 정렬

```json
{
  "articles": [
    {
      "slug": "how-to-train-your-dragon",
      "title": "How to train your dragon",
      "description": "Ever wonder how?",
      "body": "It takes a Jacobian",
      "tagList": [
        "dragons",
        "training"
      ],
      "createdAt": "2016-02-18T03:22:56.637Z",
      "updatedAt": "2016-02-18T03:48:35.824Z",
      "favorited": false,
      "favoritesCount": 0,
      "author": {
        "username": "jake",
        "bio": "I work at statefarm",
        "image": "https://i.stack.imgur.com/xHWG8.jpg",
        "following": false
      }
    },
    {
      "slug": "how-to-train-your-dragon-2",
      "title": "How to train your dragon 2",
      "description": "So toothless",
      "body": "It a dragon",
      "tagList": [
        "dragons",
        "training"
      ],
      "createdAt": "2016-02-18T03:22:56.637Z",
      "updatedAt": "2016-02-18T03:48:35.824Z",
      "favorited": false,
      "favoritesCount": 0,
      "author": {
        "username": "jake",
        "bio": "I work at statefarm",
        "image": "https://i.stack.imgur.com/xHWG8.jpg",
        "following": false
      }
    }
  ],
  "articlesCount": 2
}
```

## Feed Articles - 피드 조회

### Url

- `GET /api/articles/feed`

### Request

- Query Parameters

  - Nothing : 피드의 모든 게시글 조회

  - `?limit` : List Articles와 동일

  - `?offset` : List Articles와 동일

- Authentication

### Response

- Multiple Articles

  - 팔로우한 User들에 대한 게시글만 조회

- 최신 순으로 정렬

```json
{
  "articles": [
    {
      "slug": "how-to-train-your-dragon",
      "title": "How to train your dragon",
      "description": "Ever wonder how?",
      "body": "It takes a Jacobian",
      "tagList": [
        "dragons",
        "training"
      ],
      "createdAt": "2016-02-18T03:22:56.637Z",
      "updatedAt": "2016-02-18T03:48:35.824Z",
      "favorited": false,
      "favoritesCount": 0,
      "author": {
        "username": "jake",
        "bio": "I work at statefarm",
        "image": "https://i.stack.imgur.com/xHWG8.jpg",
        "following": false
      }
    },
    {
      "slug": "how-to-train-your-dragon-2",
      "title": "How to train your dragon 2",
      "description": "So toothless",
      "body": "It a dragon",
      "tagList": [
        "dragons",
        "training"
      ],
      "createdAt": "2016-02-18T03:22:56.637Z",
      "updatedAt": "2016-02-18T03:48:35.824Z",
      "favorited": false,
      "favoritesCount": 0,
      "author": {
        "username": "jake",
        "bio": "I work at statefarm",
        "image": "https://i.stack.imgur.com/xHWG8.jpg",
        "following": false
      }
    }
  ],
  "articlesCount": 2
}
```

## ~~Get Article - 게시글 조회~~ (완료)

### Url

- `GET /api/articles/:slug`

### Request

- No Authentication

- Empty Body

### Response

- Single Article

```json
{
  "article": {
    "slug": "how-to-train-your-dragon",
    "title": "How to train your dragon",
    "description": "Ever wonder how?",
    "body": "It takes a Jacobian",
    "tagList": [
      "dragons",
      "training"
    ],
    "createdAt": "2016-02-18T03:22:56.637Z",
    "updatedAt": "2016-02-18T03:48:35.824Z",
    "favorited": false,
    "favoritesCount": 0,
    "author": {
      "username": "jake",
      "bio": "I work at statefarm",
      "image": "https://i.stack.imgur.com/xHWG8.jpg",
      "following": false
    }
  }
}
```

## ~~Create Article - 게시글 생성~~ (완료)

### Url

- `POST /api/articles`

### Request

- Authentication

- `title`, `description`, `body` : not null

- `tagList` : nullable

```json
{
  "article": {
    "title": "How to train your dragon",
    "description": "Ever wonder how?",
    "body": "You have to believe",
    "tagList": [
      "reactjs",
      "angularjs",
      "dragons"
    ]
  }
}
```

### Response

- Single Article

```json
{
  "article": {
    "slug": "how-to-train-your-dragon",
    "title": "How to train your dragon",
    "description": "Ever wonder how?",
    "body": "It takes a Jacobian",
    "tagList": [
      "dragons",
      "training"
    ],
    "createdAt": "2016-02-18T03:22:56.637Z",
    "updatedAt": "2016-02-18T03:48:35.824Z",
    "favorited": false,
    "favoritesCount": 0,
    "author": {
      "username": "jake",
      "bio": "I work at statefarm",
      "image": "https://i.stack.imgur.com/xHWG8.jpg",
      "following": false
    }
  }
}
```

## Update Article - 게시글 수정

### Url

- `PUT /api/articles/:slug`

### Request

- Authentication

- `title`, `description`, `body` : nullable

- `slug` : `title`이 수정되면 같이 수정됨

```json
{
  "article": {
    "title": "Did you train your dragon?",
    "description": null,
    "body": null
  }
}
```

### Response

- Single Article

```json
{
  "article": {
    "slug": "how-to-train-your-dragon",
    "title": "How to train your dragon",
    "description": "Ever wonder how?",
    "body": "It takes a Jacobian",
    "tagList": [
      "dragons",
      "training"
    ],
    "createdAt": "2016-02-18T03:22:56.637Z",
    "updatedAt": "2016-02-18T03:48:35.824Z",
    "favorited": false,
    "favoritesCount": 0,
    "author": {
      "username": "jake",
      "bio": "I work at statefarm",
      "image": "https://i.stack.imgur.com/xHWG8.jpg",
      "following": false
    }
  }
}
```

## Delete Article : 게시글 삭제

### Url

- `DELETE /api/articles/:slug`

### Request

- Authentication

### Response

- Empty Body

## Create Comments - 댓글 생성

### Url

- `POST /api/articles/:slug/comments`

### Request

- Authentication

```json
{
  "comment": {
    "body": "His name was my name too."
  }
}
```

### Response

- Single Comment

```json
{
  "comment": {
    "id": 1,
    "createdAt": "2016-02-18T03:22:56.637Z",
    "updatedAt": "2016-02-18T03:22:56.637Z",
    "body": "It takes a Jacobian",
    "author": {
      "username": "jake",
      "bio": "I work at statefarm",
      "image": "https://i.stack.imgur.com/xHWG8.jpg",
      "following": false
    }
  }
}
```

## Get Comments from an Article - 게시글 댓글 전체 조회

### Url

- `GET /api/articles/:slug/comments`

### Request

- Authentication optional

- Empty Body

### Response

- Multiple Comments

```json
{
  "comments": [
    {
      "id": 1,
      "createdAt": "2016-02-18T03:22:56.637Z",
      "updatedAt": "2016-02-18T03:22:56.637Z",
      "body": "It takes a Jacobian",
      "author": {
        "username": "jake",
        "bio": "I work at statefarm",
        "image": "https://i.stack.imgur.com/xHWG8.jpg",
        "following": false
      }
    }
  ]
}
```

## Delete Comment - 댓글 삭제

### Url

- `DELETE /api/articles/:slug/comments/:id`

### Request

- Authentication

- Empty body

### Response

- Empty body

## Favorite Article - 게시글 좋아요

### Url

- `POST /api/articles/:slug/favorite`

### Request

- Authentication

### Response

- Single Article

```json
{
  "article": {
    "slug": "how-to-train-your-dragon",
    "title": "How to train your dragon",
    "description": "Ever wonder how?",
    "body": "It takes a Jacobian",
    "tagList": [
      "dragons",
      "training"
    ],
    "createdAt": "2016-02-18T03:22:56.637Z",
    "updatedAt": "2016-02-18T03:48:35.824Z",
    "favorited": false,
    "favoritesCount": 0,
    "author": {
      "username": "jake",
      "bio": "I work at statefarm",
      "image": "https://i.stack.imgur.com/xHWG8.jpg",
      "following": false
    }
  }
}
```

## Unfavorite Article - 게시글 좋아요 취소

### Url

- `DELETE /api/articles/:slug/favorite`

### Request

- Authentication

### Response

- Single Article

```json
{
  "article": {
    "slug": "how-to-train-your-dragon",
    "title": "How to train your dragon",
    "description": "Ever wonder how?",
    "body": "It takes a Jacobian",
    "tagList": [
      "dragons",
      "training"
    ],
    "createdAt": "2016-02-18T03:22:56.637Z",
    "updatedAt": "2016-02-18T03:48:35.824Z",
    "favorited": false,
    "favoritesCount": 0,
    "author": {
      "username": "jake",
      "bio": "I work at statefarm",
      "image": "https://i.stack.imgur.com/xHWG8.jpg",
      "following": false
    }
  }
}
```

###       