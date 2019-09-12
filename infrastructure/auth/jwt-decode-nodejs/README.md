# JWT decode example

## Usaga

Install

```sh
$ npm install
```

## Decode

```
$ node index.js <your jwk url> <jwt>
```

## Result of example

```json
{
  sub: 'aaaaaa-bbbbbbb',
  event_id: 'sssssssssssssssssssssssssssss',
  token_use: 'ddddd',
  scope: 'test.test.example',
  auth_time: 1568286190,
  iss: 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx',
  exp: 1568289123,
  iat: 1568286110,
  jti: 'ttt-ttt-ttt-ttt-ttt',
  client_id: 'aaaaaaaaaaa',
  username: 'testuser'
}
```