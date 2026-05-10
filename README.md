# YouTube Channel API Documentation

## Overview

- **OpenAPI Version:** 3.1.0
- **API Version:** v1
- **Base URL:** `http://localhost:8083`
- **Tag:** Channel

---

# Endpoints

## `GET /youtube/v1`

Gets a YouTube channel by username from the YouTube database.

### Description

Returns a channel from the YouTube database using its username.

### Query Parameters

| Name | Type | Required | Default | Description | Example |
|------|------|----------|---------|-------------|---------|
| `name` | string | Yes | - | The channel username | `@penguinz0` |
| `apiKey` | string | Yes | - | Your YouTube API key | - |
| `maxVideos` | integer | No | `10` | Maximum number of videos to be returned | - |
| `maxComments` | integer | No | `2` | Maximum number of comments to be returned | - |

### Responses

#### `200 OK`

Channel found.

**Content-Type:** `application/json`  
**Schema:** `ChannelDTO`

##### Example Response

```json
{
  "id": "UCq6VFHwMzcMXbuKyG7SQYIg",
  "name": "penguinz0",
  "description": "Twitter: https://twitter.com/MoistCr1TiKaL ...",
  "createdTime": "2007-05-07T23:42:34Z",
  "videos": [
    {
      "id": "8A2UjJtV_nU",
      "name": "She Was Killed for Her Pokemon Cards",
      "description": "Starforge PC https://starforgepc.com/moist-yt ...",
      "releaseTime": "2026-04-28T18:00:14Z",
      "user": {
        "id": null,
        "name": "penguinz0",
        "user_link": "https://www.youtube.com/penguinz0",
        "picture_link": "https://yt3.ggpht.com/..."
      },
      "captions": [
        {
          "id": "AUieDaZwxmYrJBEtWRid6W1sQr2ATu7jC8e7gBn9QP-eaL1knCI",
          "language": "en"
        }
      ],
      "comments": [
        {
          "id": "UgzgLIFbgUfkWb0ToX14AaABAg",
          "text": "A fully kitted Spartan may be a slight challenge...",
          "createdOn": "2026-05-07T16:28:59Z"
        }
      ]
    }
  ]
}
```

#### `404 Not Found`

Channel not found.

---

## `POST /youtube/v1`

Fetches a YouTube channel by username and stores it in the VideoMiner database.

### Description

Gets the channel from the YouTube database using its username and posts it in the VideoMiner database.

### Query Parameters

| Name | Type | Required | Default | Description | Example |
|------|------|----------|---------|-------------|---------|
| `name` | string | Yes | - | The channel username | `@penguinz0` |
| `apiKey` | string | Yes | - | Your YouTube API key | - |
| `maxVideos` | integer | No | `10` | Maximum number of videos to be returned | - |
| `maxComments` | integer | No | `2` | Maximum number of comments to be returned | - |

### Responses

#### `201 Created`

Channel found and stored successfully.

**Content-Type:** `application/json`  
**Schema:** `ChannelDTO`

#### `404 Not Found`

Channel not found.

---

# Data Models

## `ChannelDTO`

```json
{
  "id": "string",
  "name": "string",
  "description": "string",
  "createdTime": "string",
  "videos": [
    "VideoDTO"
  ]
}
```

| Field | Type | Description |
|------|------|-------------|
| `id` | string | Channel ID |
| `name` | string | Channel name |
| `description` | string | Channel description |
| `createdTime` | string | Channel creation timestamp |
| `videos` | `VideoDTO[]` | List of videos |

---

## `VideoDTO`

```json
{
  "id": "string",
  "name": "string",
  "description": "string",
  "releaseTime": "string",
  "user": "UserDTO",
  "captions": ["CaptionDTO"],
  "comments": ["CommentDTO"]
}
```

| Field | Type | Description |
|------|------|-------------|
| `id` | string | Video ID |
| `name` | string | Video title |
| `description` | string | Video description |
| `releaseTime` | string | Video publication timestamp |
| `user` | `UserDTO` | Video author information |
| `captions` | `CaptionDTO[]` | Available captions |
| `comments` | `CommentDTO[]` | Video comments |

---

## `UserDTO`

```json
{
  "id": "integer",
  "name": "string",
  "user_link": "string",
  "picture_link": "string"
}
```

| Field | Type | Description |
|------|------|-------------|
| `id` | integer | Internal user ID |
| `name` | string | Username |
| `user_link` | string | Link to the user's YouTube page |
| `picture_link` | string | Profile image URL |

---

## `CaptionDTO`

```json
{
  "id": "string",
  "link": "string",
  "language": "string"
}
```

| Field | Type | Description |
|------|------|-------------|
| `id` | string | Caption ID |
| `link` | string | Caption URL |
| `language` | string | Caption language code |

---

## `CommentDTO`

```json
{
  "id": "string",
  "text": "string",
  "createdOn": "string"
}
```

| Field | Type | Description |
|------|------|-------------|
| `id` | string | Comment ID |
| `text` | string | Comment text |
| `createdOn` | string | Comment timestamp |

# Error Codes

The API may return the following HTTP status codes depending on the outcome of the request.

| Status Code | Name | Description |
|-----------:|------|-------------|
| `200` | OK | The request was successful and the requested channel was returned. |
| `201` | Created | The channel was successfully retrieved and stored in the VideoMiner database. |
| `404` | Not Found | The specified channel could not be found on the source platform. |
| `500` | Internal Server Error | The channel object was incorrectly formed, usually because the provided channel ID or name does not exist or the upstream service returned invalid data. |
